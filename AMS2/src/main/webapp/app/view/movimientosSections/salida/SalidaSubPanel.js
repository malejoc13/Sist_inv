Ext.define('Admin.view.movimientosSections.salida.SalidaSubPanel', {
    extend: 'Admin.base.BaseSubPanel',
    xtype: 'salidaSubPanel',
    config: {
        subPanels: [
            {
                xtype: 'mov_prodGridTab'                
            }                                          
        ]
    }
});

