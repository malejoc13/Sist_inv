Ext.define('Admin.view.movimientosSections.transferencia.TransferenciaSubPanel', {
    extend: 'Admin.base.BaseSubPanel',
    xtype: 'transferenciaSubPanel',
    config: {
        subPanels: [
            {
                xtype: 'mov_prodGridTab',
                title: 'Transferencia - Productos'
            }                                          
        ]
    }
});


