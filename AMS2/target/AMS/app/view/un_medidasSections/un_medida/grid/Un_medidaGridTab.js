Ext.define('Admin.view.un_medidasSections.un_medida.grid.Un_medidaGridTab', {
    extend:'Admin.base.BaseGridTab',
    xtype: 'un_medidaGridTab', 
    title: 'Unidades de medidas',   
    entity:'un_medida',
    filters:'un_medida.id',
    items: [ 
        {
            xtype: 'un_medidaGrid' //item 0 de grid tab
        }
    ]
});

