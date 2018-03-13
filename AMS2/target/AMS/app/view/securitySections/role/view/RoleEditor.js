Ext.define('Admin.view.securitySections.role.view.RoleEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.roleEditor',
    items: [
        {
            width: "50%",
            items: [                
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Rol',
                    name: 'name',
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'
                },
                {
                    xtype     : 'baseCheckboxField',
                    fieldLabel: 'Acceso total',
                    name: 'access_all'                   
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


