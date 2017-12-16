Ext.define('Admin.view.userSections.user.view.UserDetails', {
    extend: 'Admin.base.BaseDetails',
    xtype: 'userDetails',
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
                        '<td><b>Nombre: </b> {firstName}</td>',
                        '<td><b>Apellidos: </b> {lastName}</td>',
                        '<td><b>Usuario: </b> {username}</td>',
                    '</tr>',
                    '<tr>', 
                        '<td><b>Email: </b> {email}</td>',
                        '<td><b>Unidad: </b> {unidad}</td>',
                        '<td><b>Rol: </b> {role}</td>',
                    '</tr>',
                '</table>',
                '<div>'
            ].join('')
                    )
        }
    ]
});
