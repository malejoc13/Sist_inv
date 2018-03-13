Ext.define('Admin.view.securitySections.page_access.view.Page_accessViewTab', {
    extend: 'Admin.base.BaseViewTab',
    xtype: 'page_accessViewTab',
    viewName: 'P&aacute;gina',
    entity: 'page_access',
    items: [
        {
            xtype: 'page_accessDetails'
        },
        {
            xtype: 'page_accessEditor'
        }
    ],
    setTabTitle: function (newData) {   //this function should be overriden when required
        var me = this,
                data = newData || me.config.data,
                title = '';

        if (me.staticTabTitle) {
            title = me.staticTabTitle;
        } else {
            if (data && data.id) {
                 title = 'Modificar ' + me.viewName;
                //var titleName = data[me.propertyTitleName || 'name']; //if data has not name, then specify 'propertyTitleName'
                //title = me.viewName + ': ' + titleName;
            } else {
                title = 'Nueva ' + me.viewName;
            }
        }
        me.setTitle(title);
    }
});


