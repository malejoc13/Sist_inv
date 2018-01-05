Ext.define('Admin.view.inventariosSections.inventario.grid.InventarioGridTab', {
    extend:'Admin.base.BaseGridTab',
    xtype: 'inventarioGridTab', 
    title: 'Inventario',   
    entity:'inventario',
    filters:'inventario.id',
    staticFilters:'unidad.id',//para listar inventarios solo de la unidad del usuario autenticado
    items: [ 
        {
            xtype: 'inventarioGrid' //item 0 de grid tab           
        }
    ],
    listeners: {
        render: function () {
              //Ext.ComponentQuery.query('#reportButton')[0].setVisible(true);           
              //Ext.ComponentQuery.query('#reportButton')[0].setTooltip ( "Listar inventario" )
              this.insertDocked(1,{xtype: 'reportButton'});              
        }       
    } 
});

