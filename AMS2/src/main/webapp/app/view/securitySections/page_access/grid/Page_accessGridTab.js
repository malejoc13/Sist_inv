Ext.define('Admin.view.securitySections.page_access.grid.Page_accessGridTab', {
    extend:'Admin.base.BaseGridTab',
    xtype: 'page_accessGridTab', 
    title: 'Acceso a P&aacute;ginas',    
    entity:'page_access',
    filters:'page_access.id', 
    items: [ 
        {
            xtype: 'page_accessGrid' 
        }
    ]
});


