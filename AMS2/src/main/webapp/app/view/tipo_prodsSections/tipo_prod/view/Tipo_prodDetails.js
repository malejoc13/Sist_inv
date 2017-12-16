Ext.define('Admin.view.tipo_prodsSection.tipo_prod.view.Tipo_prodDetails', {
    extend: 'Admin.base.BaseDetails',
    xtype: 'tipo_prodDetails',
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
                        '<td><b>Nombre: </b> {name}</td>',
                    '</tr>', 
                '<div>'
            ].join('') 

            )
        }
    ]
});

