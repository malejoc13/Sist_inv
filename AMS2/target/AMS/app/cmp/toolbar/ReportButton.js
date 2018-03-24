Ext.define('Admin.cmp.toolbar.ReportButton', {
    extend: 'Ext.button.Button',
    xtype: 'reportButton',
    itemId:'reportButton',
    tooltip: "Reporte para conteo de inventario",
    iconCls: 'x-fa fa-list-ol',
    listeners: {
        click: function (button) {
            var grid = button.up().up().items.items[0],
                    gridTab = grid.up(),
                    params = grid.getParams(),
                    entity = gridTab.entity,
                    url = "/AMS/report/" + entity + "_r.htm?params=" + params,
                    me = this;
             var total = grid.getStore().totalCount;
           
            if (gridTab.getXType()=== "inventarioGridTab") {                
                if (params && params.indexOf("unidad.name") !== -1) { 
                    me.getReport(url,total);
                } else {
                    Ext.Msg.alert('Informaci&oacute;n', "Debe filtrar primeramente por una Unidad");
                }
            }else {
                 me.getReport(url,total);
            }          
        }
    },
    getReport: function(url, total){        
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
});


  