 Ext.define('Admin.view.inventariosSections.inventario.view.InventarioEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.inventarioEditor',
    height: 300,
    items: [
        {
            items: [                
                {
                    fieldLabel: 'Unidad',
                    xtype: 'baseSelectField',
                    name: 'unidadId', //referencia al atributo id en el DTO
                    url: 'unidad',// referencia al alias en el DAO para que busque en esa entidad y llene el combo
                    allowBlank : false,                    
                    emptyText : "Seleccione...",
                    editable : false,
                    disabledOnEdit: true,
                    blankText : 'Este campo es obligatorio',
                    applyFilter: 'id@is@(L)',//filtro por el que se busca
                    filterPropertyName: 'new.unidadId'//indicarle que es nuevo y no depende de ningun tab
                 }, 
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
                    disabledOnEdit: true,
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
                    fieldLabel: 'Saldo inicial',                  
                    name: 'saldo_ini',
                    xtype: 'baseDoubleField',                    
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio',
                    disabledOnEdit:true,
                    listeners:{
                        change: function(me, newValue, oldValue, eOpts){
                            if(me.up().up().getForm().findField ( 'cantidad' ).isDisabled()){
                                me.up().up().getForm().findField ( 'cantidad' ).setValue(newValue);
                            }                                                    
                        }
                    }
                },                
                {
                    fieldLabel: 'Fecha de alta',                  
                    name: 'fecha_ini',
                    xtype: 'baseDateField',
                    minValue: '01-01-2017', 
                    maxValue: new Date(),
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio',
                    disabledOnEdit:true,
                    listeners:{
                        change: function(me, newValue, oldValue, eOpts){
                            if(me.up().up().getForm().findField ( 'fecha' ).isDisabled()){
                                me.up().up().getForm().findField ( 'fecha' ).setValue(newValue);
                                //Ext.Msg.alert('Informaci&oacute;n', "val");
                            }                                                    
                        }
                    }
                },
                {
                    xtype     : 'baseCheckboxField',
                    fieldLabel: 'Rotar',
                    name: 'rotate'                   
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
                    blankText : 'Este campo es obligatorio',
                    disabledOnCreate: true,
                    validator:function (val) { 
                          saldoIni =  this.up().up().getForm().findField ( 'saldo_ini' ).getValue();
                          //Ext.Msg.alert('Informaci&oacute;n', saldoIni);
                            if (val){
                                    if (parseFloat(val) <= saldoIni) {           
                                        return true;
                                    }else{
                                         return "La cantidad debe ser menor o igual al Saldo inicial";
                                    }
                            }                         
                     }
                },
                {
                    fieldLabel: 'Fecha',                  
                    name: 'fecha',
                    xtype: 'baseDateField',                  
                    maxValue: new Date(),
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio',
                    disabledOnCreate: true,
                    validator:function (val) { 
                          fechaIni = new Date(parseInt(this.up().up().getValues().values['fecha_ini']));                          
                         
                            if (val){
                                    if ( (Date.parse(this.getValue()))  >= (Date.parse(fechaIni))) {           
                                        return true;
                                    }else{
                                         return "La fecha de actualizacíon debe ser mayor o igual que la fecha de alta";
                                    }
                            }                         
                     }
                },
                {
                    xtype: 'idField'//para en caso de modificar ahi se va a guardar el ID
                }
            ]
        }
    ] 
});
