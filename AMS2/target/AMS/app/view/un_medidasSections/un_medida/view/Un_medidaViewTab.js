Ext.define('Admin.view.un_medidasSections.un_medida.view.Un_medidaViewTab', {
    extend:'Admin.base.BaseViewTab',
    xtype: 'un_medidaViewTab', 
    viewName:'Unidad de medida', 
    entity:'un_medida',
    staticFilters:'un_medida.id',
    items: [
        {
            xtype: 'un_medidaDetails'//item 0
        },
        {
            xtype: 'un_medidaEditor' //item 1
        }
    ],
    setTabTitle: function (newData) {   //this function should be overriden when required
        var me = this,
                data = newData || me.config.data,
                title = '';

        if (me.staticTabTitle) {
            title = me.staticTabTitle;
        } else {
            if (data && data.id) {
                 title = 'Modificar ' + me.viewName;
            } else {
                title = 'Nueva ' + me.viewName;
            }
        }
        me.setTitle(title);
    }
});

