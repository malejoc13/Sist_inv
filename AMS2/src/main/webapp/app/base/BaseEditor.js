Ext.define('Admin.base.BaseEditor', {
    extend: 'Ext.form.Panel',
    xtype: 'baseEditor',
    defaultType: 'baseTextField',
    requires: [
        'Ext.form.Panel',
        'Admin.cmp.BaseTextField'
    ],
    bodyPadding: '10 25',
    width: "100%",
    height: 300,
    layout: 'hbox',
    hidden: true, //Editors will be always hidden when the ViewTab starts
    border: '1px solid #32404e',
    style: {
        'padding': '10px'
    }, 
    defaults: {
        xtype: 'fieldcontainer',
        labelWidth: 80,
        width: "33%",
        defaults: {
            xtype: 'textfield',
            width: "100%",
            style: {
                'padding': '10px 20px 10px 20px'
            }
        }
    },
    bbar: [
        '->',
        {
            text: 'Cancelar',
            id: 'cancelar',
            ui: 'soft-green',
            handler: function () {
                var me = this,
                    viewTab = me.up().up().up(),
                    items = viewTab.items.items;                        
                    // viewTab.close();  
                    viewTab.down('editButton').show();
                    items[0].show();
                    items[1].hide();
            }
        },
        {
            text: 'Aceptar',
            id: 'aceptar',
            ui: 'green',
            handler: function () {
                var me = this,
                    editor = me.up().up(),
                    viewTab = editor.up(),
                    formData = editor.getValues(); 
                if(!editor.isValid()){
                    Ext.Msg.alert('Informaci&oacute;n', "Debe llenar correctamente todos los campos y los obligatorios");
                             
                }else{
                if (viewTab.additionalValues) {
                    Ext.apply(formData.typedValues, editor.getAdditionalValues());
                }

                Request.load({
                    url: viewTab.up().xtype + '/' + viewTab.entity + '/save',
                    method: 'POST',
                    jsonData: formData.typedValues,
                    ignoreError: true,
                    success: function (response) {
                        if (response.status === 560) {
                             Ext.Msg.alert('Informaci&oacute;n', response.statusMessage);
                         }else{
                            var items = viewTab.items.items,
                                    id = response.data;

                            formData.values['id'] = id;
                            viewTab.entityId = id;

                            editor.getForm().findField('id').setValue(id);
                            viewTab.setTabTitle(formData.values);

                            items[0].items.items[0].setData(formData.values);
                            viewTab.down('editButton').show();
                            items[0].show();
                            items[1].hide();

                            var subPanel = items[2];

                            if (subPanel && subPanel instanceof Admin.base.BaseSubPanel) {
                                subPanel.show();

                                var activeSubTab = subPanel.getActiveTab();

                                if (activeSubTab) {
                                    var activeTabElement = activeSubTab.items.items[0];

                                    if (activeTabElement instanceof Admin.base.BasePaginatedGrid) {
                                        activeTabElement.getStore().loadPage(1);
                                    }
                                }
                            }

                            var originCmpId = viewTab.originCmpId;

                            if (originCmpId) {
                                var originCmp = Ext.getCmp(originCmpId);
                                if (originCmp && originCmp.getStore()) {
                                    originCmp.getStore().load();
                                }
                            }
                        }
                    }
                });
                }
            }
        },
        {//This is a separator (need time to research on a better way to do it)
            text: '',
            width: 60,
            style: {
                'background-color': 'white',
                'border-width': '0px'
            }
        }
    ],
    init: function (data) {
        var me = this;
        data = data || {};

        if (me.initData) {
            Ext.apply(data, me.initData());
        }

        me.getForm().setValues(data);

        Ext.each(me.getForm().getFields().items, function (field) {
            if (field.init) {
                field.init(data);
            }
        });
    },
    getValues: function () {
        var me = this,
                typedValues = {},
                values = me.getForm().getValues();

        Ext.each(me.getForm().getFields().items, function (field) {
            var name = field.name,
                    value = field.getValue();

            var prefix = field.prefix || "(S)";

            if (field.putValueIn) { //If we want to put the value in hte data with another name.
                values[field.putValueIn] = value;
            }

            if (field instanceof Admin.cmp.BaseCheckboxField) {
                value = (field.getValue() === true) + "";
            } else {
                if (field instanceof Ext.form.DateField) {
                    values[name] = value && value.getTime();
                } else {
                    if (field instanceof Admin.cmp.BaseSelectField) {
                        var rawValueName = name;
                        if (rawValueName.indexOf('Id') > -1) {
                            rawValueName = rawValueName.substring(0, rawValueName.indexOf('Id'));
                        }
                        values[rawValueName] = field.rawValue;
                    }
                }
            }

            typedValues[name] = prefix + (value || '');
        });

        return {values: values, typedValues: typedValues};
    },
    validate: function () {
        var me = this,
            valid = false;  
        if (me.isValid()) {
            valid = true;
        }        
       return valid;
    },
    initData: function () {
        return null;
    },
    getAdditionalValues: function () {
        var me = this,
                view = me.up(),
                additionalValues = {};

        view.additionalValues.forEach(function (val) {
            var propertyName = val.propertyName,
                    propertyValue = val.propertyValue;

            additionalValues[ propertyName ] = '(I)' + view.superData[propertyValue];
        });

        return additionalValues;
    }
});