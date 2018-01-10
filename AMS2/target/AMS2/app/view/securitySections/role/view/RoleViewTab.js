Ext.define('Admin.view.securitySections.role.view.RoleViewTab', {
    extend: 'Admin.base.BaseViewTab',
    xtype: 'roleViewTab',
    viewName: 'Rol',
    entity: 'role',
    items: [
        {
            xtype: 'roleDetails'
        },
        {
            xtype: 'roleEditor'
        },
        {
            xtype: 'roleSubPanel'
        }
    ]
});

