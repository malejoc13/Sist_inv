Ext.define('Admin.cmp.BaseDateField', {
    extend: 'Ext.form.DateField',
    xtype: 'baseDateField',
    labelAlign : "top" ,
    format: 'd/m/Y',
    formatText :"",
    prefix:'(D)',
    disabled:false,
    editable : false,
    disabledOnCreate: null,
    disabledOnEdit: null,
    init: function (data) {
        var me = this,
                date = new Date();
 
        if (data && data[me.name]) {
            date = new Date(parseInt( data[me.name] ));
        }
        me.setValue(date);
     if (!Session.Principal.accessAll){ 
        if (data && data.id) {//si esta editando
            me.disabledOnCreate=false;
            if (me.disabledOnEdit) {
                me.disable();               
            }
        } else {//si esta creando
            me.disabledOnEdit=false;
            if (me.disabledOnCreate) {
                me.disable();
               
            }
        }
    }
    } 
});
 