 Ext.define('Admin.view.productosSections.producto.view.ProductoEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.productoEditor',
    height: 350,
    items: [
        {
            items: [                
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Nombre',
                    name: 'name',//le pongo de nombre el mismo valord el grid para que me lo cargue a la hora de modificar
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'                    
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
                    fieldLabel: 'Fecha de alta',                  
                    name: 'fecha_alta',
                    xtype: 'baseDateField',
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
                }
            ]
        },
        {
            items: [  
                {
                    fieldLabel: 'Unidad de medida',
                    xtype: 'baseSelectField',
                    name: 'un_medidaId', //referencia al atributo id en el DTO
                    url: 'un_medida',// referencia al alias en el DAO para que busque en esa entidad y llene el combo
                    allowBlank : false,                    
                    emptyText : "Seleccione...",
                    editable : false,
                    blankText : 'Este campo es obligatorio'
                 },
                {
                    fieldLabel: 'Tipo de producto',
                    xtype: 'baseSelectField',
                    name: 'tipo_prodId', //
                    url: 'tipo_prod',
                    allowBlank : false,                    
                    emptyText : "Seleccione...",
                    editable : false,
                    blankText : 'Este campo es obligatorio'
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
