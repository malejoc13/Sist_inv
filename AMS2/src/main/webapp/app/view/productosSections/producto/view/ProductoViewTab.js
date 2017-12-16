Ext.define('Admin.view.productosSections.producto.view.ProductoViewTab', {
    extend:'Admin.base.BaseViewTab',
    xtype: 'productoViewTab', 
    viewName:'Producto', 
    entity:'producto',
    staticFilters:'producto.id',
    items: [
        {
            xtype: 'productoDetails'//item 0
        },
        {
            xtype: 'productoEditor' //item 1
        }
    ]
});

