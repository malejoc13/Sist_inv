Ext.define('Admin.view.un_medidasSections.un_medida.view.Un_medidaEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.un_medidaEditor',
    items: [
        {
            width: "50%",
            items: [  
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Clave',
                    name: 'clave',
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'
                },
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Nombre',
                    name: 'nombre_um',
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'
                }                
            ]
        },
        {
            width: "50%",
            items: [
                {
                    xtype     : 'baseTextAreaField',                    
                    name      : 'descripcion',
                    fieldLabel: 'Descripci&oacute;n'
                },
                {
                    xtype: 'idField'//para en caso de modificar ahi se va a guardar el ID
                }
            ]
        }
    ] 
});
