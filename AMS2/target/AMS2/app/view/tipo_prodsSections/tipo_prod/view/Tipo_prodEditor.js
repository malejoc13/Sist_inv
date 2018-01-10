Ext.define('Admin.view.tipo_prodsSection.tipo_prod.view.Tipo_prodEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.tipo_prodEditor',
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



