Ext.define('Admin.view.movimientosSections.mov_prod.view.Mov_prodDetails', {
    extend: 'Admin.base.BaseDetails',
    xtype: 'mov_prodDetails',
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
                        '<td><b>Movimiento: </b>{[Util.formatDate(values.fecha)]}</td>',
                        '<td><b>Cantidad: </b> {cantidad}</td>',
                        '<td><b>Precio: ($)</b> {precio}</td>',                                              
                    '</tr>',
                '</table>',
                '<table cellpadding="10" style="width:100%;cellspacing">',
                    '<tr>',
                        '<td><b>Producto: </b>({productoClave}) {producto}</td>', 
                        '<td><b>Descripción: </b> {descripcion}</td>', 
                    '</tr>',                    
                '</table>',
                '<div>'
            ].join('') 

            )
        }
    ]
});

