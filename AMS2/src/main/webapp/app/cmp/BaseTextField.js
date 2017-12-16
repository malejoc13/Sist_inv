Ext.define('Admin.cmp.BaseTextField', {
    extend: 'Ext.form.field.Text',
    xtype: 'baseTextField',
    labelAlign : "top" ,
    prefix:'(S)',
    cls: 'baseTextField',
    regex : /^[0-9A-Za-z]|^[0-9\sA-Za-z]$/,//solo alfanumericos
    regexText : "Solo se permiten valores alfanumericos"
});