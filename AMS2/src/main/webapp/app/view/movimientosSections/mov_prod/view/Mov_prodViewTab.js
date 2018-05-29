Ext.define('Admin.view.movimientosSections.mov_prod.view.Mov_prodViewTab', {
    extend: 'Admin.base.BaseViewTab',
    xtype: 'mov_prodViewTab',
    viewName: 'Producto',
    entity: 'mov_prod',
    items: [
        {
            xtype: 'mov_prodDetails'
        },
        {
            xtype: 'mov_prodEditor'            
        }
    ]
});
