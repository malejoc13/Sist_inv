Ext.define('Admin.view.securitySections.page_access.view.Page_accessDetails', {
    extend: 'Admin.base.BaseDetails',
    xtype: 'page_accessDetails',
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
                            '<td><b>Nombre de p&aacute;gina: </b> {name}</td>',
                            '<td><b>Id de p&aacute;gina: </b> {idPage}</td>',
                        '</tr>',
                    '</table>',
                '<div>'
            ].join('') 
            )
        }
    ]
});

