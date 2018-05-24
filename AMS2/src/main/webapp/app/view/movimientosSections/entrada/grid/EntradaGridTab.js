Ext.define('Admin.view.movimientosSections.entrada.grid.EntradaGridTab', {
    extend: 'Admin.base.BaseGridTab',
    xtype: 'entradaGridTab',
    title: 'Entradas',
    filters: 'movimiento.id',
    entity: 'movimiento',
    staticFilters:'tipo_mov',
    items: [
        {
            xtype: 'entradaGrid'
        },
        {
            xtype: 'entradaSubPanel'
        }
    ]
});
