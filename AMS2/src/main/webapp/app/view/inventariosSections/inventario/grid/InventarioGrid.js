Ext.define('Admin.view.inventariosSections.inventario.grid.InventarioGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.inventarioGrid',
    height: '100%',
    storeClass: 'Admin.base.BaseStore20',
    viewConfig: {
        loadingText: 'Cargando...', 
        getRowClass: function(record) { 
            var me = this;
            if (record.get('saldo_ini') > record.get('cantidad')) {               
               return record.get('cantidad') < me.up().getLimit(record.get('saldo_ini')) ? 'warning-row':''; 
            }
                       
            if (record.get('cantidad') < 5) {
                 return 'warning-row';
            }
            if (record.get('cantidad') === record.get('saldo_ini')) {
                 return 'new-row';
            }
            return ''; 
        } 
    },
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
                width: '13%',
                renderer: function(value, metaData, record, rowIdx, colIdx, store) {
                    metaData.tdAttr = 'data-qtip="Clave SAT: ' + record.get('productoClaveSat') + '"';
                    return value;
                }
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
                text: "UM",
                dataIndex: 'umNombre',
                filter: 'un_medida.nombre_um',//para cuando valla a filtrar por esa columna ese es el valo que manda como criterio de busqueda
                width: '13%',  
                renderer: function(value, metaData, record) {
                                metaData.tdAttr = 'data-qtip="(' + record.get('umClave') + ') '+ record.get('umNombre')+'"';
                                return value;
                            }
                
            },
            {
                text: "Precio",
                dataIndex: 'precio_max',
                filterType: 'filterNumber',
                width: '7%',
                renderer: function(value, metaData, record, rowIdx, colIdx, store) {
                    metaData.tdAttr = 'data-qtip="Precio mínimo: $' + record.get('precio_min') + '"';
                    return value;
                }
            },
            {
                text: "Cantidad ini",
                dataIndex: 'saldo_ini',
                filterType: 'filterNumber',
                width: '10%',
                renderer: function(value, metaData, record, rowIdx, colIdx, store) {
                    metaData.tdAttr = 'data-qtip="Rotación: ' + record.get('rotacion') + '"';
                    return value;
                }
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
    },
    getLimit: function(ini) {
        
        if (ini >= 5 && ini <= 9) {
            return ini/2; //mitad            
        }        
        if (ini >= 10 && ini <= 40) {
            return ini*20/100; //20%            
        }
        if (ini >= 41 && ini <= 50) {
            return ini*15/100; //15%            
        }
        if (ini >= 51 && ini <= 110) {
            return ini*10/100; //10%            
        }
        if (ini >= 111 && ini <= 300) {
            return ini*5/100; //5%            
        }
        if (ini >= 301 && ini <= 1000) {
            return ini*2/100; //2%            
        } 
        if (ini >= 1001) {
            return ini/100; //1%            
        }
        return ini;//cuando es menos que 5
    }
});






