Ext.define('Admin.view.securitySections.page_access.grid.Page_accessGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.page_accessGrid',
    columns: {
        defaults: {
            width: '50%',
            align: 'center'
        },
        items: [
            {
                xtype: 'idGridColumn'
            },
            {
                text: "Nombre de p&aacute;gina",
                dataIndex: 'name',
                filterType: 'filterText'
            },
            {
                text: "Id de p&aacute;gina",
                dataIndex: 'idPage',
                width: '49%'
            }
        ]
    }
});

