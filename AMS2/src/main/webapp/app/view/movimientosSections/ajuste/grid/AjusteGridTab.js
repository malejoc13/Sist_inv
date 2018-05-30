Ext.define('Admin.view.movimientosSections.ajuste.grid.AjusteGridTab', {
    extend: 'Admin.base.BaseGridTab',
    xtype: 'ajusteGridTab',
    title: 'Ajustes',
    filters: 'movimiento.id',
    entity: 'movimiento',
    staticFilters:'tipo_mov',
    items: [
        {
            xtype: 'ajusteGrid'
        },
        {
            xtype: 'ajusteSubPanel'
        }
    ]
});


