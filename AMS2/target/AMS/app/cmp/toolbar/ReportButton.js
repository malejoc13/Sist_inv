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
            var grid = button.up().up().items.items[0],
                    gridTab = grid.up(),
                    params = grid.getParams(),
                    entity = gridTab.entity,
                    url = "/AMS/report/" + entity + "_r.htm?params=" + params;
            if (params) {
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
            } else {
                Ext.Msg.alert('Informaci&oacute;n', "Debe filtrar primeramente por una Unidad");
            }
           
        }
    }
});
  