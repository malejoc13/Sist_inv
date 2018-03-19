Ext.define('Admin.view.productosSections.producto.grid.ProductoGridTab', {
    extend:'Admin.base.BaseGridTab',
    xtype: 'productoGridTab', 
    title: 'Productos',   
    entity:'producto',
    filters:'producto.id',
    items: [ 
        {
            xtype: 'productoGrid' //item 0 de grid tab
        }
    ],
    tbar: [ 
        '->',
        {
            xtype: 'createButton'
        },
        {
            xtype: 'editGridRowButton' 
        },
        {
            xtype: 'deleteButton'
        },
        {
            xtype: 'excelReportButton'
        },
        {
            xtype: 'pdfReportButton'
        },
        {
            xtype: 'reportButton'
        },
        {
            xtype: 'showFilters' 
        }
    ]
});


