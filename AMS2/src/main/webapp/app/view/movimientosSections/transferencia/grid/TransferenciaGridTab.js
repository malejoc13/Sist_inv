Ext.define('Admin.view.movimientosSections.transferencia.grid.TransferenciaGridTab', {
    extend: 'Admin.base.BaseGridTab',
    xtype: 'transferenciaGridTab',
    title: 'Transferencias',
    filters: 'movimiento.id',
    entity: 'movimiento',
    staticFilters:'tipo_mov',
    items: [
        {
            xtype: 'transferenciaGrid'
        },
        {
            xtype: 'transferenciaSubPanel'
        }
    ]
});


