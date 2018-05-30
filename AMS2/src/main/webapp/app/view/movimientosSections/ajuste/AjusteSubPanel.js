Ext.define('Admin.view.movimientosSections.ajuste.AjusteSubPanel', {
    extend: 'Admin.base.BaseSubPanel',
    xtype: 'ajusteSubPanel',
    config: {
        subPanels: [
            {
                xtype: 'mov_prodGridTab',
                title: 'Ajuste - Productos'                
            }                                          
        ]
    }
});


