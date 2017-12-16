Ext.define('Admin.view.securitySections.page_access.view.Page_accessViewTab', {
    extend: 'Admin.base.BaseViewTab',
    xtype: 'page_accessViewTab',
    viewName: 'Acceso a P&aacute;gina',
    entity: 'page_access',
    items: [
        {
            xtype: 'page_accessDetails'
        },
        {
            xtype: 'page_accessEditor'
        }
    ]
});


