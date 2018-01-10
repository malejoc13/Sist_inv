Ext.define('Admin.cmp.toolbar.ExcelReportButton', {
    extend: 'Ext.button.Button',
    xtype: 'excelReportButton',
    tooltip: "Exportar a Excel",
    iconCls: 'x-fa fa-file-excel-o',
    listeners: {
        click: function (button) {
            var grid = button.up().up().items.items[0],
                    gridTab = grid.up(),
                    grid = gridTab.items.items[0],
                    params = grid.getParams(),
                    entity = gridTab.entity,
                    url = "/AMS/report/" + entity + ".htm?report=excel&params=" + params;
            console.log(url);

            var total = grid.getStore().totalCount;
           
           if (total > 50) {
               if (confirm('Est&aacute; a punto de generar un reporte de m&aacute;s de  ' + total + ' registros, desea continuar?')) {
                    window.open(url, '_blank');
                }
            }else{
                window.open(url, '_blank');
            }


        }
    }
});