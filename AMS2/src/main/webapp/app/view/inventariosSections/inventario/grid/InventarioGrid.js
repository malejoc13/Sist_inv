Ext.define('Admin.view.inventariosSections.inventario.grid.InventarioGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.inventarioGrid',
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
                text: "Clave",
                dataIndex: 'productoClave',               
                filter: 'producto.clave',
                width: '10%'
            },
            {
                text: "Producto",
                dataIndex: 'producto',
                filter: 'producto.name',
                width: '25%'
            },
            {
                text: "Saldo inicial",
                dataIndex: 'saldo_ini',
                filterType: 'filterInteger',
                width: '10%'
            },
            {
                text: "Cantidad",
                dataIndex: 'cantidad',
                filterType: 'filterInteger',
                width: '10%'
            },
            {
                xtype: 'dateGridColumn',
                text: "Fecha de alta",
                dataIndex: 'fecha_ini',
                filterType: 'filterDate',
                width: '12%'
            },
            {
                xtype: 'dateGridColumn',
                text: "Fecha",
                dataIndex: 'fecha',
                filterType: 'filterDate',
                width: '12%'
            }, 
            {
                text: "Unidad",//implementar un render para qeu muetre o oculte la columna en caso de quiene sta autenticado
                dataIndex: 'unidad',
                filter: 'unidad.name',
                width: '25%'
            }
        ]
    }
});






