Ext.define('Admin.view.un_medidasSections.un_medida.grid.Un_medidaGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.un_medidaGrid',
    columns: {
        defaults: {
            width: '30%',
            align: 'center'
        },
        items: [
            {
                xtype: 'idGridColumn',
                dataIndex: 'id',
            },
            {
                text: "Nombre",
                dataIndex: 'nombre_um',
                filterType: 'filterText',
                width: '30%'
                //filterType: 'filterProveedorNombreSelectField',
                //xtype: 'customGridColumn'
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
