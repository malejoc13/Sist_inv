Ext.define('Admin.view.securitySections.role.view.RoleDetails', {
    extend: 'Admin.base.BaseDetails',
    xtype: 'roleDetails',
    items: [
        {
            xtype: 'component',
            flex: 1,
            cls: 'single-mail-email-subject',
            data: {
            },
            tpl: new Ext.XTemplate([
                '<div style="padding:20px">',
                '<table cellpadding="10" style="width:100%;cellspacing">',
                    '<tr>',
                        '<td><b>Rol: </b> {name}</td>',
                        '<td><b>Acceso total: </b> {[Util.formatBool(values.access_all)]}</td>',
                    '</tr>',                                        
                '</table>',
                '<table cellpadding="10" style="width:100%;cellspacing">',
                    '<tr>',                    
                        '<td><b>Descripci&oacute;n: </b> {descripcion}</td>',                        
                    '</tr>',
                '</table>',   
                '<div>'
            ].join('') 
            )
        }
    ]
});


