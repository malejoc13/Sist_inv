Ext.define('Admin.view.productosSections.producto.grid.ProductoGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.productoGrid',
    height: '100%',
    storeClass: 'Admin.base.BaseStore20',
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
                dataIndex: 'clave',
                filterType: 'filterText',//para cuando fitre sepa qe tipo de datos envia
                width: '10%',
                renderer: function(value, metaData, record, rowIdx, colIdx, store) {
                    metaData.tdAttr = 'data-qtip="Clave SAT: ' + record.get('clave_sat') + '"';
                    return value;
                }
            },
            {
                text: "Nombre",
                dataIndex: 'name',
                filterType: 'filterText',//para cuando fitre sepa qe tipo de datos envia
                width: '25%',
                xtype: 'toolTipColumn'
            },
            {
                xtype: 'dateGridColumn',
                text: "Fecha de alta",
                dataIndex: 'fecha_alta',
                filterType: 'filterDate',
                width: '12%'
            },
//            {
//                text: "Precio costo",
//                dataIndex: 'precio_costo',
//                filterType: 'filterNumber',
//                width: '10%'
//            },
            {
                text: "Precio",
                dataIndex: 'precio_max',
                filterType: 'filterNumber',
                width: '10%',
                renderer: function(value, metaData, record, rowIdx, colIdx, store) {
                    metaData.tdAttr = 'data-qtip="Precio mínimo: $' + record.get('precio_min') + '"';
                    return value;
                }
            },
            {
                text: "UM",
                dataIndex: 'un_medida',
                filter: 'un_medida.nombre_um',//para cuando valla a filtrar por esa columna ese es el valo que manda como criterio de busqueda
                width: '8%',  
                renderer: function(value, metaData, record) {
                                metaData.tdAttr = 'data-qtip="(' + record.get('un_medidaClave') + ') '+ record.get('un_medida')+'"';
                                return value;
                            }
                
            },
            {
                text: "Tipo",
                dataIndex: 'tipo_prod',
                filter: 'tipo_prod.name',
                width: '20%',  
                renderer: function(value, metaData, record) {
                                metaData.tdAttr = 'data-qtip="(' + record.get('tipo_prodClave') + ') '+ record.get('tipo_prod')+'"';
                                return value;
                            }
            },
            {
                text: "Proveedor",
                dataIndex: 'proveedor',
                filter: 'proveedor.name',
                width: '30%',  
                renderer: function(value, metaData, record) {
                                metaData.tdAttr = 'data-qtip="' + record.get('proveedor') + '"';
                                return value;
                            }
            }
        ]
    }
});




