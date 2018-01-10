Ext.define('Admin.cmp.BaseIntegerField', {
    extend: 'Ext.form.field.Text',
    xtype: 'baseIntegerField',
    labelAlign : "top" ,
    prefix:'(I)',
    regex : /^\d*$/,//solo numeros
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

