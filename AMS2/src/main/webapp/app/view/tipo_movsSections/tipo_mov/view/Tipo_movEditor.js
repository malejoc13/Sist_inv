Ext.define('Admin.view.tipo_movsSection.tipo_mov.view.Tipo_movEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.tipo_movEditor',
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




