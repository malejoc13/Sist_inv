Ext.define('Admin.view.tipo_prodsSection.tipo_prod.view.Tipo_prodViewTab', {
    extend:'Admin.base.BaseViewTab',
    xtype: 'tipo_prodViewTab', 
    viewName:'Tipo de producto', 
    entity:'tipo_prod',
    staticFilters:'tipo_prod.id',
    items: [
        {
            xtype: 'tipo_prodDetails'//item 0
        },
        {
            xtype: 'tipo_prodEditor' //item 1
        }//, 
      //  {
       //     xtype: 'proveedorSubPanel'
       // }
    ]
});

