Ext.define('Admin.cmp.toolbar.ReportButton', {
    extend: 'Ext.button.Button',
    xtype: 'reportButton',
    //text : "Listar",
    itemId:'reportButton',
    tooltip: "Reporte para conteo de inventario",
    iconCls: 'x-fa fa-list-ol',
    //hidden : true,
    listeners: {
        click: function (button) {
            var grid = button.up().items.items[0],
                    gridTab = grid.up(),
                    params = grid.getParams(),
                    entity = gridTab.entity,
                    url = "/AMS/report/" + entity + "_r.htm?params=" + params;
            if (params) {
               var total = grid.getStore().totalCount;
            if (total > 50) {
                if (confirm('Est&aacute; a punto de generar un reporte de m&aacute;s de  ' + total + ' registros, desea continuar?')) {
                    window.open(url, 'window', 'HEIGHT=660,resizable=yes,scrollbars=yes,WIDTH=900,target="blank_"');
                }
            } else {
                window.open(url, 'window', 'HEIGHT=660,resizable=yes,scrollbars=yes,WIDTH=900,target="blank_"');
            } 
            } else {
                Ext.Msg.alert('Informaci&oacute;n', "Debe filtrar primeramente por una Unidad");
            }
           

        }
    }
});

