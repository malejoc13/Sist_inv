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
                width: '25%',
                renderer: function(value, metaData, record, rowIdx, colIdx, store) {
                    metaData.tdAttr = 'data-qtip="' + record.get('descripcion') + '"';
                    return value;
                }
            },
            {
                text: "Saldo inicial",
                dataIndex: 'saldo_ini',
                filterType: 'filterNumber',
                width: '10%'
            },
            {
                text: "Cantidad",
                dataIndex: 'cantidad',
                filterType: 'filterNumber',
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
    },
    getParams: function () {//redefino la funcion para que cargue el inventrio de la unidad
         var me = this,
             searchParams;
        if (!Session.Principal.accessAll) {
            searchParams = me.up().staticFilters + '@is@(L)' +Session.Principal.entityId;//en caso de cargarse el grid en base a un id
        }else{
            searchParams = me.up().getFilters();
        }
        me.columns.forEach(function (column) {
            var cmp = column.items.items[0];
            var val = cmp.getValue();
            if (val) {
                searchParams += '@p@' + (column.filter || column.dataIndex) + "@is@" + cmp.prefix + val;
            }
        });
        return searchParams;
    }
});






