Ext.define('Admin.cmp.toolbar.CreateButton', {
    extend: 'Ext.button.Button',
    xtype: 'createButton',
    tooltip: "Adicionar",
    iconCls: 'x-fa fa-plus-square-o',
    listeners: {
        click: 'editGridRow'
    }
});