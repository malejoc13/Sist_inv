Ext.define('Admin.view.tipo_movsSection.tipo_mov.view.Tipo_movViewTab', {
    extend:'Admin.base.BaseViewTab',
    xtype: 'tipo_movViewTab', 
    viewName:'Tipo de movimiento', 
    entity:'tipo_mov',
    staticFilters:'tipo_mov.id',
    items: [
        {
            xtype: 'tipo_movDetails'//item 0
        },
        {
            xtype: 'tipo_movEditor' //item 1
        }
    ]
});


