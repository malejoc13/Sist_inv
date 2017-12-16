Ext.define('Admin.cmp.toolbar.EditGridRowButton', {
    extend: 'Ext.button.Button',
    xtype: 'editGridRowButton',
    tooltip: "Modificar",
     iconCls: 'x-fa fa-folder-open-o',
    listeners: {
        click: 'editGridRow'
    }
});