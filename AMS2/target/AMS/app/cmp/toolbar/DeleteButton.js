Ext.define('Admin.cmp.toolbar.DeleteButton', {
    extend: 'Ext.button.Button',
    xtype: 'deleteButton',
    tooltip: "Eliminar",
    iconCls: 'x-fa fa-trash',
    listeners: {
        click: 'deleteGridRow'
    }
});