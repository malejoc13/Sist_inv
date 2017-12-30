Ext.define('Admin.view.inventariosSections.inventario.grid.InventarioGridTab', {
    extend:'Admin.base.BaseGridTab',
    xtype: 'inventarioGridTab', 
    title: 'Inventario',   
    entity:'inventario',
    filters:'inventario.id',
    items: [ 
        {
            xtype: 'inventarioGrid' //item 0 de grid tab
        }
    ]
});

