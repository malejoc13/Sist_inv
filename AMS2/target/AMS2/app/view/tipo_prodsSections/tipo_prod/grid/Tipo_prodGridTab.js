Ext.define('Admin.view.tipo_prodsSection.tipo_prod.grid.Tipo_prodGridTab', {
    extend:'Admin.base.BaseGridTab',
    xtype: 'tipo_prodGridTab', 
    title: 'Tipos de producto',   
    entity:'tipo_prod',
    filters:'tipo_prod.id',
    items: [ 
        {
            xtype: 'tipo_prodGrid' //item 0 de grid tab
        }//,
        //{
        //    xtype: 'proveedorSubPanel' //item 1 de grid tab
       // }
    ]
});

