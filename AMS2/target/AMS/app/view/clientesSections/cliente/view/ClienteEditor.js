Ext.define('Admin.view.clientesSections.cliente.view.ClienteEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.clienteEditor',
    height: 350,
    items: [
        {
            //width: "40%",
            items: [                
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Nombre',
                    name: 'name',
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'
                },
                {
                    xtype     : 'baseTextAreaField',                    
                    name      : 'direccion',
                    fieldLabel: 'Direcci&oacute;n'
                }           
            ]
        },
        {
           // width: "28%",
            items: [
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Apellidos',
                    name: 'lastName',
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'
                },
                {
                    xtype: 'baseTextField',
                    fieldLabel: 'Tel&eacute;fono',                  
                    name: 'telefono',
                    regex : /^\d*$/,//solo numeros
                    regexText : "Solo se permiten valores num&eacute;ricos"
                },
                {
                    fieldLabel: 'Fecha de nacimiento',                  
                    name: 'fecha_nac',
                    xtype: 'baseDateField', 
                    maxValue: new Date()
                }
            ]
        },
        {
           // width: "32%",
            items: [                
                {
                    xtype: 'baseTextField',
                    fieldLabel: 'Email',                  
                    name: 'email',
                    regex : /^([a-z]+[a-z1-9._-]*)@{1}([a-z1-9\._-]{2,})\.([a-z]{2,3})$/,//solo email
                    regexText : "Solo se permiten direcciones de correo v&aacute;lidos"                 
                },
                {
                    fieldLabel: 'Cr&eacute;dito',                  
                    name: 'credito_max',
                    xtype: 'baseDoubleField'                    
                },
                {
                    xtype: 'idField'//para en caso de modificar ahi se va a guardar el ID
                }
            ]
        }
    ] 
});


