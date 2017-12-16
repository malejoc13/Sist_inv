Ext.define('Admin.view.userSections.user.grid.UserGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.userGrid',
    columns: {
        defaults: {
            align: 'center'
        },
        items: [
            {
                xtype: 'idGridColumn'
            },
            {
                text: "Nombre",
                dataIndex: 'firstName',
                filterType: 'filterText',
                width: '20%'
            },
            {
                text: "Apellidos",
                dataIndex: 'lastName',
                filterType: 'filterText',
                width: '20%'
            },
            {
                text: "Usuario",
                dataIndex: 'username',
                filterType: 'filterText',
                width: '15%'
            },            
            {
                text: "Email",
                dataIndex: 'email',                
                filterType: 'filterText',
                width: '20%'
            },
            {
                text: "Unidad",
                dataIndex: 'unidad',
                filter: 'unidad.name',
                width: '20%'
            },
            {
                text: "Rol",
                dataIndex: 'role',
                filter: 'role.name',
                width: '15%'
            },
            { 
                text: 'Activo', 
                dataIndex: 'active',
                filterType:'filterBoolean',                
                width: '8%',
                xtype: 'booleanGridColumn',
            }
        ]
    }
});