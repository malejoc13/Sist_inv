Ext.define('Admin.view.productosSections.producto.grid.ProductoGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.productoGrid',
    height: '100%',
    storeClass: 'Admin.base.BaseStore20',
    columns: {
        defaults: {
            width: '30%',
            align: 'center'
        },
        items: [
            {
                xtype: 'idGridColumn'
            },
            {
                text: "Nombre",
                dataIndex: 'name',
                filterType: 'filterText',//para cuando fitre sepa qe tipo de datos envia
                width: '25%'
            },            
            {
                dataIndex: 'descripcion',
                hidden: true,
            },
            {
                xtype: 'dateGridColumn',
                text: "Fecha de alta",
                dataIndex: 'fecha_alta',
                filterType: 'filterDate',
                width: '15%'
            },
            {
                text: "Precio",
                dataIndex: 'precio_max',
                filterType: 'filterNumber',
                width: '12%'
            },
            {
                text: "Precio min",
                dataIndex: 'precio_min',
                filterType: 'filterNumber',
                width: '12%'
            },
            {
                text: "UM",
                dataIndex: 'un_medida',
                filter: 'un_medida.nombre_um',//para cuando valla a filtrar por esa columna ese es el valo que manda como criterio de busqueda
                width: '5%'
            },
            {
                text: "Tipo",
                dataIndex: 'tipo_prod',
                filter: 'tipo_prod.name',
                width: '10%'
            },
            {
                text: "Proveedor",
                dataIndex: 'proveedor',
                filter: 'proveedor.name',
                width: '21%'
            }
        ]
    }
});




