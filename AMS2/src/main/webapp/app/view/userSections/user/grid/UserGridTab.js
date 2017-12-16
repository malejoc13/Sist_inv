Ext.define('Admin.view.userSections.user.grid.UserGridTab', {
    extend:'Admin.base.BaseGridTab',
    xtype: 'userGridTab', 
    title: 'Usuarios',  
    entity:'user',
    filters:'user.id',
    items: [ 
        {
            xtype: 'userGrid' 
        }
    ]
});
