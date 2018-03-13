Ext.define('Admin.view.unidadesSections.unidad.grid.UnidadGridTab', {
    extend:'Admin.base.BaseGridTab',
    xtype: 'unidadGridTab', 
    title: 'Unidades',   
    entity:'unidad',
    filters:'unidad.id',
    items: [ 
        {
            xtype: 'unidadGrid' //item 0 de grid tab
        }
    ]
});


