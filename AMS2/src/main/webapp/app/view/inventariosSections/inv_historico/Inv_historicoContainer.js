Ext.define('Admin.view.inventariosSections.inv_historico.Inv_historicoContainer', {
    extend: 'Admin.base.BaseContainer',
    xtype: 'inv_historicos',
    listeners: {
        show : function ( me, eOpts ) {            
            me.items.items[0].items.items[0].getStore().loadPage(1);
        }
    },
    items: [
        {
            xtype: 'inv_historicoGridTab'
        } 
    ]
});




