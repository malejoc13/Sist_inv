 Ext.define('Admin.view.inventariosSections.inventario.view.InventarioEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.inventarioEditor',
    height: 420,
    items: [
        {
            items: [  
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Clave',
                    name: 'productoClave',//le pongo de nombre el mismo valord el grid para que me lo cargue a la hora de modificar
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'                    
                },
                {
                    fieldLabel: 'Producto',
                    xtype: 'baseSelectField',
                    name: 'productoId', //referencia al atributo id en el DTO
                    url: 'producto',// referencia al alias en el DAO para que busque en esa entidad y llene el combo
                    allowBlank : false,                    
                    emptyText : "Seleccione...",
                    editable : false,
                    blankText : 'Este campo es obligatorio'
                },
                {
                    fieldLabel: 'Unidad',
                    xtype: 'baseSelectField',
                    name: 'unidadId', //referencia al atributo id en el DTO
                    url: 'unidad',// referencia al alias en el DAO para que busque en esa entidad y llene el combo
                    allowBlank : false,                    
                    emptyText : "Seleccione...",
                    editable : false,
                    blankText : 'Este campo es obligatorio'
                 }         
            ]
        },
        {
            items: [
                {
                    fieldLabel: 'Saldo inicial',                  
                    name: 'saldo_ini',
                    xtype: 'baseDoubleField',                    
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'
                },
                {
                    fieldLabel: 'Fecha de alta',                  
                    name: 'fecha_ini',
                    xtype: 'baseDateField',
                    minValue: '01-01-2017', 
                    maxValue: new Date(),
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'                    
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
                    fieldLabel: 'Fecha',                  
                    name: 'fecha',
                    xtype: 'baseDateField',
                    minValue: '01-01-2017', 
                    maxValue: new Date(),
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'                    
                },
                {
                    xtype: 'idField'//para en caso de modificar ahi se va a guardar el ID
                }
            ]
        }
    ] 
});
