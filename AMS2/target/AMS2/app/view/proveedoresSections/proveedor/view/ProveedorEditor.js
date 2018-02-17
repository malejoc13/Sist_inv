Ext.define('Admin.view.proveedoresSections.proveedor.view.ProveedorEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.proveedorEditor',
    items: [
        {
            width: "40%",
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
            width: "28%",
            items: [
                {
                    xtype: 'baseTextField',
                    fieldLabel: 'Tel&eacute;fono fijo',                  
                    name: 'telefono',
                    regex : /^\d*$/,//solo numeros
                    regexText : "Solo se permiten valores num&eacute;ricos"
                },
                {
                    xtype: 'baseTextField',
                    fieldLabel: 'Tel&eacute;fono movil',                  
                    name: 'telefono_m',
                    regex : /^\d*$/,//solo numeros
                    regexText : "Solo se permiten valores num&eacute;ricos"
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
                    xtype: 'idField'//para en caso de modificar ahi se va a guardar el ID
                }
            ]
        }
    ] 
});



