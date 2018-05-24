Ext.define('Admin.view.movimientosSections.mov_prod.Mov_prodGridTab', {
    extend: 'Admin.base.BaseGridTab',
    xtype: 'mov_prodGridTab',
    title: 'Movimiento - Detalles',
    entity: 'mov_prod',
    staticFilters:'movimiento.id',
    items: [
        {
            xtype: 'mov_prodGrid'
        }
    ]
});



