Ext.define('Admin.view.unidadesSections.unidad.grid.UnidadGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.unidadGrid',
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
                dataIndex: 'name',
                width: '40%',
                filterType: 'filterText'
            },            
            {
                text: "Direcci&oacute;n",
                dataIndex: 'direccion',
                filterType: 'filterText',
                width: '40%'
            },
            {
                text: "Tel&eacute;fono",
                dataIndex: 'telefono',
                filterType: 'filterText',
                width: '19%'
            }
        ]
    }
});
