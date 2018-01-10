Ext.define('Admin.view.unidadesSections.unidad.view.ProveedorEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.unidadEditor',
    items: [
        {
            width: "50%",
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
            items: [
                {
                    xtype: 'baseTextField',
                    fieldLabel: 'Tel&eacute;fono',                  
                    name: 'telefono',
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio',
                    regex : /^\d*$/,//solo numeros
                    regexText : "Solo se permiten valores num&eacute;ricos"
                }
            ]
        },
        {
            items: [ 
                {
                    xtype: 'idField'//para en caso de modificar ahi se va a guardar el ID
                }
            ]
        }
    ],
    setTabTitle: function () {   //this function should be overriden when required
     var me = this;
        title = 'Nueva ' + me.viewName;         
        me.setTitle(title);
    } 
});
