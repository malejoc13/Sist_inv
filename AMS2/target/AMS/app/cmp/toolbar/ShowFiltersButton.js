Ext.define('Admin.cmp.toolbar.ShowFiltersButton', {
    extend: 'Ext.button.Button',
    xtype: 'showFilters',
    tooltip: "Filtros",
    iconCls: 'x-fa fa-filter',
    listeners: {
        click: function (element) {
            var grid = element.up().up().items.items[0];

            grid.columns.forEach(function (column) {
                var filterComponent = column.items.items[0];
                if (filterComponent.isVisible()) {
                    filterComponent.hide();
                } else {
                    filterComponent.show();
                }
            });
        }
    }
});