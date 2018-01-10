Ext.define('Admin.view.unidadesSections.unidad.view.UnidadViewTab', {
    extend:'Admin.base.BaseViewTab',
    xtype: 'unidadViewTab', 
    viewName:'Unidad', 
    entity:'unidad',
    staticFilters:'unidad.id',
    items: [
        {
            xtype: 'unidadDetails'//item 0
        },
        {
            xtype: 'unidadEditor' //item 1
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


