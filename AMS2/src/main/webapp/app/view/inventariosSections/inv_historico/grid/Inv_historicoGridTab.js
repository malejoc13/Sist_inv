Ext.define('Admin.view.inventariosSections.inv_historico.grid.Inv_historicoGridTab', {
    extend:'Admin.base.BaseGridTab',
    xtype: 'inv_historicoGridTab', 
    title: 'Inventario histórico',   
    entity:'inv_historico',
    filters:'inv_historico.id',
    staticFilters:'unidad.id',//para listar inventarios solo de la unidad del usuario autenticado
    items: [ 
        {
            xtype: 'inv_historicoGrid' //item 0 de grid tab           
        }
    ],
    tbar: [ 
        '->',       
//        {
//            xtype: 'editGridRowButton' 
//        },
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
            xtype: 'showFilters' 
        }
    ]
});


