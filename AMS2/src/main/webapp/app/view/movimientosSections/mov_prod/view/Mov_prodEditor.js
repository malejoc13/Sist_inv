 Ext.define('Admin.view.movimientosSections.mov_prod.view.Mov_prodEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.mov_prodEditor',
    items: [
        {
            items: [                 
                {
                    fieldLabel: 'Producto',
                    xtype: 'baseSelectField',
                    name: 'productoId', //referencia al atributo id en el DTO
                    url: 'producto',// referencia al alias en el DAO para que busque en esa entidad y llene el combo
                    allowBlank : false,                    
                    emptyText : "Seleccione...",                   
                    forceSelection:true,
                    typeAhead: true,
                    blankText : 'Este campo es obligatorio',
                    listConfig : ({
                        loadingText: 'Cargando...',
                        getInnerTpl: function() {
                                return '<div data-qtip="{descripcion}">({clave}) {name}</div>';
                            }
                  })
                }        
            ]
        },        
        {
            items: [ 
                {
                    fieldLabel: 'Cantidad',                  
                    name: 'cantidad',
                    xtype: 'baseDoubleField',                    
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'
                },
                {
                    name: 'movimientoId',//para que mande el id del movimiento tambien inicializado en initData() en caso de estar adicionando
                    xtype: 'idField'
                },
                {
                    xtype: 'idField'//para en caso de modificar ahi se va a guardar el ID
                }
            ]
        }
    ],
    initData: function () {
       var me = this;
       var data={
                movimientoId:me.superEntityId
              };
        return data;
    } 
});
