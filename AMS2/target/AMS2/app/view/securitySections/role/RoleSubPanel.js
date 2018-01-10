Ext.define('Admin.view.securitySections.role.RoleSubPanel', {
    extend: 'Admin.base.BaseSubPanel',
    xtype: 'roleSubPanel',
    config: {
        subPanels: [
            {
                xtype: 'role_page_accessGridTab',
                openViewFilters: 'role_page_access.id'//le paso el id para cuando abra un tab 
            }                                          
        ]
    }
});


