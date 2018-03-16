Ext.define('Admin.cmp.toolbar.PdfReportButton', {
    extend: 'Ext.button.Button',
    xtype: 'pdfReportButton',
    tooltip: "Exportar a PDF",
    iconCls: 'x-fa fa-file-pdf-o',
    listeners: {
        click: function (button) {
            var grid = button.up().up().items.items[0],
                    gridTab = grid.up(),
                    params = grid.getParams(),
                    entity = gridTab.entity,
                    url = "/AMS/report/" + entity + ".htm?params=" + params;
            var total = grid.getStore().totalCount;
            if (total > 500) {
                Ext.Msg.confirm("Aviso", 'Está a punto de generar un reporte de mas de  ' + total + ' registros, desea continuar?', function(btn){
                    if (btn == "yes") {
                            window.open(url, '_blank');
                    } 
                });
            } else {
                window.open(url, '_blank');
            }
        }
    }
});