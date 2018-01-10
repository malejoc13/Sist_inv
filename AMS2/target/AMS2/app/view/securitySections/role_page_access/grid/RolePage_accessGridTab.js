Ext.define('Admin.view.securitySections.role_page_access.grid.RolePage_accessGridTab', {
    extend: 'Admin.base.BaseGridTab',
    xtype: 'role_page_accessGridTab',
    title: 'Rol - Acceso a P&aacute;ginas',
    entity: 'role_page_access',
    items: [
        {
            xtype: 'role_page_accessGrid'
        }
    ]
});


