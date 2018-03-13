Ext.define('Admin.view.securitySections.role_page_access.view.RolePage_accessViewTab', {
    extend: 'Admin.base.BaseViewTab',
    xtype: 'role_page_accessViewTab',
    viewName: 'Acceso',
    entity: 'role_page_access',
    items: [
        {
            xtype: 'role_page_accessDetails'
        },
        {
            xtype: 'role_page_accessEditor'
        }
    ],
    setTabTitle: function (newData) {
        var me = this,
                data = newData || me.config.data,
                title = '';

        if (data && data.id) {
            title = 'Rol: ' + data.role + ' - Acceso a P&aacute;gina: ' + data.page_access;
        } else {
            title = 'Nuevo ' + me.viewName;
        }
        me.setTitle(title);
    }
});


