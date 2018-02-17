Ext.define('Admin.cmp.BaseDoubleField', {
    extend: 'Ext.form.field.Text',
    xtype: 'baseDoubleField',
    labelAlign : "top" ,
    prefix:'(d)',
    regex : /^[0-9]+\.?[0-9]*$/,//solo numeros
    regexText : "Solo se permiten valores num&eacute;ricos",
    disabledOnCreate: null,
    disabledOnEdit: null,
    init: function (data) {
      var me = this;
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