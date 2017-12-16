Ext.define('Admin.view.tipo_prodsSection.tipo_prod.grid.Tipo_prodGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.tipo_prodGrid',
    height: '100%',
    storeClass: 'Admin.base.BaseStore20',
    columns: {
        defaults: {
            align: 'left'
        },
        items: [
            {
                xtype: 'idGridColumn',
                dataIndex: 'id',
            },
            {
                text: "Nombre",
                dataIndex: 'name',
                filterType: 'filterText',
                width: '100%'
            }
        ]
    }
});