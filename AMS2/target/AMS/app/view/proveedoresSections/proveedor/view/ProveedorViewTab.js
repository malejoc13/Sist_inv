Ext.define('Admin.view.proveedoresSections.proveedor.view.ProveedorViewTab', {
    extend:'Admin.base.BaseViewTab',
    xtype: 'proveedorViewTab', 
    viewName:'Proveedor', 
    entity:'proveedor',
    staticFilters:'proveedor.id',
    items: [
        {
            xtype: 'proveedorDetails'//item 0
        },
        {
            xtype: 'proveedorEditor' //item 1
        }//, 
      //  {
       //     xtype: 'proveedorSubPanel'
       // }
    ]
});

