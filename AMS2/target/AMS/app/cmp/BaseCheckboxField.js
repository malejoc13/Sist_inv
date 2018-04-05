Ext.define('Admin.cmp.BaseCheckboxField', {
    extend: 'Ext.form.field.Checkbox',
    xtype: 'baseCheckboxField',
    width: "100%",
    prefix:'(B)',
    disabledOnCreate: null,
    disabledOnEdit: null,
    init: function () {
        var me = this;         
        if (!Session.Principal.accessAll){ 
            me.disable();
           }       
    }
});