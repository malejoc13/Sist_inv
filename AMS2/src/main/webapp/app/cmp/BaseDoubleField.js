Ext.define('Admin.cmp.BaseDoubleField', {
    extend: 'Ext.form.field.Text',
    xtype: 'baseDoubleField',
    labelAlign : "top" ,
    prefix:'(d)',
    regex : /^[1-9]+\.?[0-9]*$/,//solo numeros
    regexText : "Solo se permiten valores num&eacute;ricos",
});