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
                xtype: 'booleanGridColumn',
                text: 'Acceso total', 
                dataIndex: 'access_all',
                filterType:'filterBoolean',                
                width: '10%'
            },
            {
                text: "Rol",
                dataIndex: 'name',
                width: '29%',
                filterType: 'filterText'
            },            
            {
                text: "Descripci&oacute;n",
                dataIndex: 'descripcion',
                filterType: 'filterText',
                width: '60%'
            }
        ]
    }
});


