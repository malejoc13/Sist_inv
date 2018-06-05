Ext.define('Admin.view.movimientosSections.transferencia.view.TransferenciaDetails', {
    extend: 'Admin.base.BaseDetails',
    xtype: 'transferenciaDetails',
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
                        '<td><b>Unidad: </b> {unidad}</td>', 
                        '<td><b>Fecha: </b> {[Util.formatDate(values.fecha)]}</td>',
                        '<td><b>Saldo total: </b> {saldo}</td>',
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


