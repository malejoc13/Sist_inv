 Ext.define('Admin.view.productosSections.producto.view.ProductoEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.productoEditor',
    height: 500,
    items: [
        {
            items: [  
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Clave',
                    name: 'clave',//le pongo de nombre el mismo valord el grid para que me lo cargue a la hora de modificar
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'                    
                },
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Clave SAT',
                    name: 'clave_sat'                  
                },
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Nombre',
                    name: 'name',//le pongo de nombre el mismo valord el grid para que me lo cargue a la hora de modificar
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'                    
                },
                {
                    fieldLabel: 'Precio costo',                  
                    name: 'precio_costo',
                    xtype: 'baseDoubleField',                    
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'
                }           
            ]
        },
        {
            items: [
                {
                    fieldLabel: 'Fecha de alta',                  
                    name: 'fecha_alta',
                    xtype: 'baseDateField',
                    minValue: '01-01-2017', 
                    maxValue: new Date(),
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'                    
                },
                {
                    fieldLabel: 'Precio',                  
                    name: 'precio_max',
                    xtype: 'baseDoubleField',                    
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'
                },
                {
                    fieldLabel: 'Precio m&iacute;nimo',                  
                    name: 'precio_min',
                    xtype: 'baseDoubleField',
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio',
                    validator:function (val) {
                          precioMax = parseFloat(this.up().up().getValues().values['precio_max']); 
                            if (val){
                                    if (parseFloat(val) <= precioMax) {           
                                        return true;
                                    }else{
                                         return "El precio m&iacute;nimo debe ser menor o igual que el precio";
                                    }
                            }                         
                     }
                },
                {
                    xtype     : 'baseTextAreaField',    //DE TIPO TEX AREA YA DEFINIDO EN CMP                
                    name      : 'descripcion',
                    fieldLabel: 'Descripci&oacute;n'              
                }
            ]
        },
        {
            items: [  
                {
                    fieldLabel: 'Unidad de medida',
                    xtype: 'baseSelectField',
                    name: 'un_medidaId', //referencia al alias en el DAO 
                    url: 'un_medida',// para que busque en esa entidad y llene el combo
                    allowBlank : false,                    
                    emptyText : "Seleccione...",
                    editable : false,
                    blankText : 'Este campo es obligatorio',
                    listConfig : ({
                    loadingText: 'Cargando...',
                    getInnerTpl: function() {
                            return '<div data-qtip="{name}">({clave}) {name}</div>';
                        }
                  })
                },
                {
                    fieldLabel: 'Tipo de producto',
                    xtype: 'baseSelectField',
                    name: 'tipo_prodId', //
                    url: 'tipo_prod',
                    allowBlank : false,                    
                    emptyText : "Seleccione...",
                    editable : false,
                    blankText : 'Este campo es obligatorio',
                    listConfig : ({
                    loadingText: 'Cargando...',
                    getInnerTpl: function() {
                            return '<div data-qtip="{name}">({clave}) {name}</div>';
                        }
                  })                 
                },
                {
                    fieldLabel: 'Proveedor',
                    xtype: 'baseSelectField',
                    name: 'proveedorId', //
                    url: 'proveedor',
                    allowBlank : false,                    
                    emptyText : "Seleccione...",
                    editable : false,
                    blankText : 'Este campo es obligatorio'
                },
                {
                    xtype: 'idField'//para en caso de modificar ahi se va a guardar el ID
                }
            ]
        }
    ] 
});
