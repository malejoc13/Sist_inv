Ext.define('Admin.view.movimientosSections.ajuste.view.AjusteViewTab', {
    extend: 'Admin.base.BaseViewTab',
    xtype: 'ajusteViewTab',
    viewName: 'Ajuste',
    entity: 'movimiento',
    items: [
        {
            xtype: 'ajusteDetails'
        },
        {
            xtype: 'ajusteEditor'
        },
        {
            xtype: 'ajusteSubPanel'
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
            } else {
                title = 'Nueva ' + me.viewName;
            }
        }
        me.setTitle(title);
    }
});




