Ext.define('Admin.view.securitySections.user.grid.UserGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.userGrid',
    height: '100%',
    storeClass: 'Admin.base.BaseStore20',
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
                text: 'Activo', 
                dataIndex: 'active',
                filterType:'filterBoolean',                
                width: '8%'
            },
            {
                text: "Nombre",
                dataIndex: 'firstName',
                filterType: 'filterText',
                width: '20%',
                renderer: function(value, metaData, record, rowIdx, colIdx, store) {
                    metaData.tdAttr = 'data-qtip="Rol: ' + record.get('role') + '"';
                    return value;
                }
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
            }     
        ]
    }
});