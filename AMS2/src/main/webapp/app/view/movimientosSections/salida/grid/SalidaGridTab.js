Ext.define('Admin.view.movimientosSections.salida.grid.SalidaGridTab', {
    extend: 'Admin.base.BaseGridTab',
    xtype: 'salidaGridTab',
    title: 'Salidas',
    filters: 'movimiento.id',
    entity: 'movimiento',
    staticFilters:'tipo_mov',
    items: [
        {
            xtype: 'salidaGrid'
        },
        {
            xtype: 'salidaSubPanel'
        }
    ]
});
