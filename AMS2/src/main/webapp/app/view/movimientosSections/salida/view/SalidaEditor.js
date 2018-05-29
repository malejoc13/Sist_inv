Ext.define('Admin.view.movimientosSections.salida.view.SalidaEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.salidaEditor',
    items: [
        {
            width: "50%",
            items: [                
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
                    xtype     : 'baseTextAreaField',                    
                    name      : 'descripcion',
                    fieldLabel: 'Descripci&oacute;n'
                }                
            ]
        },
        {
            width: "50%",
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
                    value: 2          //para en caso de modificar ahi se va a guardar el tipo mov
                }
            ]
        }
    ]
});




