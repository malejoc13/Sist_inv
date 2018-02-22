Ext.define('Admin.view.clientesSections.cliente.grid.ClienteGridTab', {
    extend:'Admin.base.BaseGridTab',
    xtype: 'clienteGridTab', 
    title: 'Clientes',   
    entity:'cliente',
    filters:'cliente.id',
    items: [ 
        {
            xtype: 'clienteGrid' //item 0 de grid tab
        }
    ]
});

