Ext.define('Admin.view.proveedoresSections.proveedor.view.ProveedorDetails', {
    extend: 'Admin.base.BaseDetails',
    xtype: 'proveedorDetails',
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
                        '<td><b>Tel&eacute;fono: </b> {telefono}</td>',
                        '<td><b>Email: </b> {email}</td>',
                    '</tr>',                                        
                '</table>',
                '<table cellpadding="10" style="width:100%;cellspacing">',
                    '<tr>',                    
                        '<td><b>Direcci&oacute;n: </b> {direccion}</td>',                        
                    '</tr>',
                '</table>',   
                '<div>'
            ].join('') 

            )
        }
    ]
});


