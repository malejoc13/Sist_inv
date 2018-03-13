Ext.define('Admin.view.proveedoresSections.proveedor.grid.ProveedorGridTab', {
    extend:'Admin.base.BaseGridTab',
    xtype: 'proveedorGridTab', 
    title: 'Proveedores',   
    entity:'proveedor',
    filters:'proveedor.id',
    items: [ 
        {
            xtype: 'proveedorGrid' //item 0 de grid tab
        }//,
        //{
        //    xtype: 'proveedorSubPanel' //item 1 de grid tab
       // }
    ]
});

