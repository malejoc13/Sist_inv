Ext.define('Admin.view.clientesSections.cliente.view.ClienteViewTab', {
    extend:'Admin.base.BaseViewTab',
    xtype: 'clienteViewTab', 
    viewName:'Cliente', 
    entity:'cliente',
    staticFilters:'cliente.id',
    items: [
        {
            xtype: 'clienteDetails'//item 0
        },
        {
            xtype: 'clienteEditor' //item 1
        }
    ]
});


