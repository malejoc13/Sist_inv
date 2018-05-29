Ext.define('Admin.view.movimientosSections.entrada.EntradaSubPanel', {
    extend: 'Admin.base.BaseSubPanel',
    xtype: 'entradaSubPanel',
    config: {
        subPanels: [
            {
                xtype: 'mov_prodGridTab'                
            }                                          
        ]
    }
});
