Ext.define('Admin.view.inventariosSections.inventario.view.InventarioDetails', {
    extend: 'Admin.base.BaseDetails',
    xtype: 'inventarioDetails',
    height: 270,
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
                        '<td><b>Nombre: </b>({productoClave}) {producto}</td>', 
                        '<td><b>Cantidad inicial: </b> {saldo_ini}</td>',
                        '<td><b>Cantidad: </b> {cantidad}</td>', 
                    '</tr>',
                    '<tr>',
                        '<td><b>Fecha de alta: </b> {[Util.formatDate(values.fecha_ini)]}</td>',
                        '<td><b>Fecha: </b> {[Util.formatDate(values.fecha)]}</td>',
                        '<td><b>Unidad: </b> {unidad}</td>', 
                    '</tr>',
                '</table>',
                '<table cellpadding="10" style="width:100%;cellspacing">',
                    '<tr>',
                        '<td><b>Descripción: </b> {descripcion}</td>', 
                    '</tr>',                    
                '</table>',
                '<div>'
            ].join('') 

            )
        }
    ]
});
