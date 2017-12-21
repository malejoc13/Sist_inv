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
            if (total > 50) {
                if (confirm('Est&aacute; a punto de generar un reporte de m&aacute;s de  ' + total + ' registros, desea continuar?')) {
                    window.open(url, 'window', 'HEIGHT=660,resizable=yes,scrollbars=yes,WIDTH=900,target="blank_"');
                }
            } else {
                window.open(url, 'window', 'HEIGHT=660,resizable=yes,scrollbars=yes,WIDTH=900,target="blank_"');
            }

        }
    }
});