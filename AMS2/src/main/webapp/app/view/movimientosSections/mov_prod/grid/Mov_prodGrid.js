Ext.define('Admin.view.movimientosSections.mov_prod.grid.Mov_prodGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.mov_prodGrid',
    columns: {
        defaults: {          
            align: 'left'
        },
        items: [
            {
                xtype: 'idGridColumn'
            },
            {
                text: "Clave",
                dataIndex: 'productoClave',               
                filter: 'producto.clave',
                width: '15%'
            },
            {
                text: "Producto",
                dataIndex: 'producto',
                filter: 'producto.name',
                width: '35%',
                renderer: function(value, metaData, record, rowIdx, colIdx, store) {
                    metaData.tdAttr = 'data-qtip="' + record.get('descripcion') + '"';
                    return value;
                }
            },
            {
                text: "Cantidad",
                dataIndex: 'cantidad',
                filterType: 'filterNumber',
                width: '25%'
            },
            {
                text: "($) Saldo",
                dataIndex: 'saldo_prod',
                filterType: 'filterNumber',
                width: '24%'
            }
        ]
    }
});



