Ext.define('Admin.view.un_medidasSections.un_medida.view.Un_medidaEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.un_medidaEditor',
    items: [
        {
            width: "50%",
            items: [                
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Nombre',
                    name: 'nombre_um',
                    allowBlank : false,
                    regexText : "Solo se permiten valores alfanumericos"
                }                
            ]
        },
        {
            width: "50%",
            items: [
                {
                    xtype     : 'baseTextAreaField',                    
                    name      : 'descipcion_um',
                    fieldLabel: 'Descripci&oacute;n'
                },
                {
                    xtype: 'idField'//para en caso de modificar ahi se va a guardar el ID
                }
            ]
        }
    ] 
});
