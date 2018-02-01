Ext.define('Admin.view.productosSections.producto.view.ProductoDetails', {
    extend: 'Admin.base.BaseDetails',
    xtype: 'productoDetails',
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
                        '<td><b>Nombre: </b> {name}</td>', 
                        '<td><b>UM: </b> {un_medida}</td>',
                        '<td><b>Clave: </b> {clave}</td>',                                                                
                    '</tr>',
                    '<tr>',
                        '<td><b>Precio costo: $</b> {precio_costo}</td>',
                        '<td><b>Precio: $</b> {precio_max}</td>',                        
                         '<td><b>Precio m&iacute;nimo: $</b> {precio_min}</td>',
                    '</tr>',
                '</table>',
                '<table cellpadding="10" style="width:100%;cellspacing">',
                    '<tr>',
                        '<td><b>Tipo: </b> {tipo_prod}</td>',
                        '<td><b>Proveedor: </b> {proveedor}</td>',
                    '</tr>',
                '</table>',
                '<table cellpadding="10" style="width:100%;cellspacing">',
                    '<tr>',
                        '<td><b>Fecha de alta: </b> {[Util.formatDate(values.fecha_alta)]}</td>',
                    '</tr>',
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




