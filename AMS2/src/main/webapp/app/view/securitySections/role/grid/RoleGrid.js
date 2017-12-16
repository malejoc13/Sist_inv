Ext.define('Admin.view.securitySections.role.grid.RoleGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.roleGrid',
    columns: {
        defaults: {
            align: 'center'
        },
        items: [
            {
                xtype: 'idGridColumn'
            },
            {
                text: "Rol",
                dataIndex: 'name',
                width: '30%',
                filterType: 'filterText'
            },            
            {
                text: "Descripci&oacute;n",
                dataIndex: 'descripcion',
                filterType: 'filterText',
                width: '69%'
            }
        ]
    }
});


