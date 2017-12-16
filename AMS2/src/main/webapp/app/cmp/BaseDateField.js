Ext.define('Admin.cmp.BaseDateField', {
    extend: 'Ext.form.DateField',
    xtype: 'baseDateField',
    labelAlign : "top" ,
    format: 'd-m-Y',
    prefix:'(D)',
    disabled:false,
    init: function (data) {
        var me = this,
                date = new Date();
 
        if (data && data[me.name]) {
            date = new Date(parseInt( data[me.name] ));
        }
        me.setValue(date);
    } 
});
 