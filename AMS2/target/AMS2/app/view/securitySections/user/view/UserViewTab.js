Ext.define('Admin.view.securitySections.user.view.UserViewTab', {
    extend:'Admin.base.BaseViewTab',
    xtype: 'userViewTab', 
    viewName:'User', 
    entity:'user',
    items: [
        {
            xtype: 'userDetails'
        },
        {
            xtype: 'userEditor' 
        }
//        {
//            xtype: 'userSubPanel'
//        }
    ],
    setTabTitle: function (newData) {   //this function should be overriden when required
        var me = this,
            data = newData || me.config.data,
            title = '';       
            if (data && data.id) {
                 title = 'Modificar Usuario';
                //var titleName = data[me.propertyTitleName || 'name']; //if data has not name, then specify 'propertyTitleName'
                //title = me.viewName + ': ' + titleName;
            } else {
                title = 'Nuevo Usuario';
            }        
        me.setTitle(title);
    }
});
