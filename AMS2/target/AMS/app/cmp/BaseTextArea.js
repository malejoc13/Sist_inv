Ext.define('Admin.cmp.BaseTextArea', {
    extend: 'Ext.form.field.TextArea',
    xtype: 'baseTextAreaField',
    labelAlign : "top" ,
    prefix:'(S)',
    anchor: '100%',
    regex : /^[0-9A-Za-z]|^[0-9\sA-Za-z]$/,//solo alfanumericos
    regexText : "Solo se permiten valores alfanumericos"
});


