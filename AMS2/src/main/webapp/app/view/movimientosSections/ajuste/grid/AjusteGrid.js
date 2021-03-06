Ext.define('Admin.view.movimientosSections.ajuste.grid.AjusteGrid', {
    extend: 'Admin.base.BasePaginatedGrid',
    alias: 'widget.ajusteGrid',
    columns: {
        defaults: {
            align: 'center'
        },
        items: [
            {
                xtype: 'idGridColumn'
            },
            {
                xtype: 'dateGridColumn',
                text: "Fecha",
                dataIndex: 'fecha',
                format: 'd/m/Y g:i:s a',
                filterType: 'filterDate',
                width: '18%'
            },
            {
                text: "Saldo Total",
                dataIndex: 'saldo',
                filterType: 'filterNumber',
                width: '15%'
            },            
            {
                text: "Descripci&oacute;n",
                dataIndex: 'descripcion',
                filterType: 'filterText',
                xtype: 'toolTipColumn',
                width: '46%'
            }, 
            {
                text: "Unidad",//implementar un render para qeu muetre o oculte la columna en caso de quiene sta autenticado
                dataIndex: 'unidad',
                filter: 'unidad.name',
                width: '20%'
            }
        ]
    },
    getParams: function () {//redefino la funcion para que cargue por el tipo de mov deseado
         var me = this,
             searchParams;
        
            searchParams = me.up().staticFilters + '@is@(I)' +4;//en caso de ser entradas
       
            //searchParams = me.up().getFilters();
        
        me.columns.forEach(function (column) {
            var cmp = column.items.items[0];
            var val = cmp.getValue();
            if (val) {
                searchParams += '@p@' + (column.filter || column.dataIndex) + "@is@" + cmp.prefix + val;
            }
        });
        return searchParams;
    }
});


