Ext.define('Admin.view.inventariosSections.inventario.view.InventarioViewTab', {
    extend:'Admin.base.BaseViewTab',
    xtype: 'inventarioViewTab', 
    viewName:'Inventario', 
    entity:'inventario',
    staticFilters:'inventario.id',
    items: [
        {
            xtype: 'inventarioDetails'//item 0
        },
        {
            xtype: 'inventarioEditor' //item 1
        }
    ]
});
