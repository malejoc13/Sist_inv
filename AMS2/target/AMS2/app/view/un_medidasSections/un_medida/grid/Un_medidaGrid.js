Ext.define('Admin.view.un_medidasSections.un_medida.grid.Un_medidaGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.un_medidaGrid',
    height: '100%',
    storeClass: 'Admin.base.BaseStore20',
    columns: {
        defaults: {
            align: 'center'
        },
        items: [
            {
                xtype: 'idGridColumn'
            },
            {
                text: "Nombre",
                dataIndex: 'nombre_um',
                filterType: 'filterText',
                width: '30%'
            },            
            {
                text: "Descripci&oacute;n",
                dataIndex: 'descipcion_um',
                filterType: 'filterText',
                width: '69%'
            }
        ]
    }
});
