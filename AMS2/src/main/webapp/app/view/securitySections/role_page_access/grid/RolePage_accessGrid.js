Ext.define('Admin.view.securitySections.role_page_access.grid.RolePage_accessGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.role_page_accessGrid',
    columns: {
        defaults: {          
            align: 'left'
        },
        items: [
            {
                xtype: 'idGridColumn'
            },
            {
                text: "P&aacute;gina",
                dataIndex: 'page_access',
                filter: 'page_access.name',
                width: '99%'
            }
        ]
    }
});


