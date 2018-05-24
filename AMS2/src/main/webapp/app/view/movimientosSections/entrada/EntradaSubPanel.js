Ext.define('Admin.view.movimientosSections.entrada.EntradaSubPanel', {
    extend: 'Admin.base.BaseSubPanel',
    xtype: 'entradaSubPanel',
    config: {
        subPanels: [
            {
                xtype: 'mov_prodGridTab',
                openViewFilters: 'mov_prod.id'//le paso el id para cuando abra un tab 
            }                                          
        ]
    }
});
