Ext.define('Admin.view.movimientosSections.entrada.view.EntradaEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.entradaEditor',
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
                    xtype     : 'baseTextAreaField',                    
                    name      : 'descripcion',
                    fieldLabel: 'Descripci&oacute;n'
                } 
             ]
        },
        {
            items: [
                
                {
                    fieldLabel: 'Fecha',                  
                    name: 'fecha',
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
                    fieldLabel: 'Saldo total',                  
                    name: 'saldo',
                    xtype: 'baseDoubleField',                    
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'
                },
                {
                    xtype: 'idField'//para en caso de modificar ahi se va a guardar el ID
                },
                {
                    xtype: 'tmField',
                    value: 1          //para en caso de modificar ahi se va a guardar el tipo mov
                }
            ]
        }
    ]
});

