Ext.define('Admin.view.tipo_movsSection.tipo_mov.grid.Tipo_movGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.tipo_movGrid',
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
                text: "Nombre",
                dataIndex: 'name',
                filterType: 'filterText',
                width: '30%'
            },            
            {
                text: "Descripci&oacute;n",
                dataIndex: 'descripcion',
                filterType: 'filterText',
                width: '69%'
            }
        ]
    }
});