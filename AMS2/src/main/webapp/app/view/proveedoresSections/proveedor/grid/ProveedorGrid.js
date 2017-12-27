Ext.define('Admin.view.proveedoresSections.proveedor.grid.ProveedorGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.proveedorGrid',
    height: '100%',
    storeClass: 'Admin.base.BaseStore20',
    columns: {
        defaults: {
            width: '30%',
            align: 'center'
        },
        items: [
            {
                xtype: 'idGridColumn',
                dataIndex: 'id'
            },
            {
                text: "Nombre",
                dataIndex: 'name',
                width: '30%',
                filterType: 'filterText'
            },            
            {
                text: "Direcci&oacute;n",
                dataIndex: 'direccion',
                filterType: 'filterText',
                width: '30%'
            },
            {
                text: "Tel&eacute;fono",
                dataIndex: 'telefono',
                filterType: 'filterText',
                width: '20%'
            },
            {
                text: "Email",
                dataIndex: 'email',
                filterType: 'filterText',
                width: '20%'
            }
        ]
    }
});


