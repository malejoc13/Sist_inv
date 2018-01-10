Ext.define('Admin.view.securitySections.role_page_access.view.RolePage_accessDetails', {
    extend:'Admin.base.BaseDetails',
    xtype: 'role_page_accessDetails', 
    items: [
        {
            xtype: 'component', 
            flex: 1,
            cls: 'single-mail-email-subject',
            data: {  
            },
            tpl: new Ext.XTemplate([
                '<div style="padding:20px">', 
                '<table cellpadding="4" style="width:100%;cellspacing">',
                    '<tr>',
                        '<td><b>Rol: </b> {role}</td>',
                        '<td><b>Acceso a P&aacute;gina: </b> {page_access}</td>',
                    '</tr>', 
                    '<tr>',
                        '<td><b>Crear: </b> {create}</td>',
                        '<td><b>Actualizar: </b> {update}</td>',
                        '<td><b>Eliminar: </b> {delete}</td>',
                    '</tr>', 
                '</table>',
                '<div>'
            ].join('') 
            )
        }
    ]
});


