Ext.define('Admin.view.proveedoresSections.proveedor.grid.ProveedorGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.proveedorGrid',
    height: '100%',
    storeClass: 'Admin.base.BaseStore20',
    columns: {
        defaults: {
            width: '30%',
            align: 'left'
        },
        items: [
            {
                xtype: 'idGridColumn',
                dataIndex: 'id'
            },
            {
                text: "Nombre",
                dataIndex: 'name',
                width: '40%',
                filterType: 'filterText',
                renderer: function(value, metaData, record, rowIdx, colIdx, store) {
                    metaData.tdAttr = 'data-qtip="Dirección: ' + record.get('direccion') + '"';
                    return value;
                }
            },            
            {
                text: "Tel&eacute;fono fijo",
                dataIndex: 'telefono',
                filterType: 'filterText',
                width: '15%'
            },
            {
                text: "Tel&eacute;fono movil",
                dataIndex: 'telefono_m',
                filterType: 'filterText',
                width: '15%'
            },
            {
                text: "Email",
                dataIndex: 'email',
                filterType: 'filterText',
                width: '29%'
            }
        ]
    }
});


