Ext.define('Admin.view.clientesSections.cliente.view.ClienteDetails', {
    extend: 'Admin.base.BaseDetails',
    xtype: 'clienteDetails',
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
                        '<td><b>Apellidos: </b> {lastName}</td>',
                        '<td><b>Tel&eacute;fono: </b> {telefono}</td>',                        
                    '</tr>',
                    '<tr>',
                        '<td><b>Email: </b> {email}</td>',
                        '<td><b>Cr&eacute;dito: </b> {credito_max}</td>',
                        '<td><b>Fecha de nacimiento: </b> {[Util.formatDate(values.fecha_nac)]}</td>',
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


