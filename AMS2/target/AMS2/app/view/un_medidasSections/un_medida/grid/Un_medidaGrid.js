Ext.define('Admin.view.un_medidasSections.un_medida.grid.Un_medidaGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.un_medidaGrid',
    height: '100%',
    storeClass: 'Admin.base.BaseStore20',
    columns: {
        defaults: {
            align: 'left'
        },
        items: [
            {
                xtype: 'idGridColumn'
            },
            {
                text: "Clave",
                dataIndex: 'clave',
                filterType: 'filterText',
                width: '10%'
            }, 
            {
                text: "Nombre",
                dataIndex: 'nombre_um',
                filterType: 'filterText',
                width: '20%'
            },            
            {
                text: "Descripci&oacute;n",
                dataIndex: 'descripcion',
                filterType: 'filterText',
                xtype: 'toolTipColumn',
                width: '69%'
            }
        ]
    }
});
