Ext.define('Admin.view.tipo_movsSection.tipo_mov.grid.Tipo_movGridTab', {
    extend:'Admin.base.BaseGridTab',
    xtype: 'tipo_movGridTab', 
    title: 'Tipos de movimiento',   
    entity:'tipo_mov',
    filters:'tipo_mov.id',
    items: [ 
        {
            xtype: 'tipo_movGrid' //item 0 de grid tab
        }
    ]
});




