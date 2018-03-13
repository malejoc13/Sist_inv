Ext.define('Admin.view.clientesSections.cliente.grid.ClienteGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.clienteGrid',
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
                width: '20%',
                filterType: 'filterText',
                renderer: function(value, metaData, record, rowIdx, colIdx, store) {
                    metaData.tdAttr = 'data-qtip="Dirección: ' + record.get('direccion') + '"';
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
                text: "Tel&eacute;fono",
                dataIndex: 'telefono',
                filterType: 'filterText',
                width: '11%'
            },
            {
                xtype: 'dateGridColumn',
                text: "Fecha de nacimiento",
                dataIndex: 'fecha_nac',
                filterType: 'filterDate',
                width: '15%'
            },
            {
                text: "Cr&eacute;dito",
                dataIndex: 'credito_max',
                filterType: 'filterNumber',
                width: '8%'
            },
            {
                text: "Email",
                dataIndex: 'email',
                filterType: 'filterText',
                width: '25%'
            }
        ]
    }
});



