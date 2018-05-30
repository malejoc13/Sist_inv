Ext.define('Admin.view.movimientosSections.transferencia.view.TransferenciaViewTab', {
    extend: 'Admin.base.BaseViewTab',
    xtype: 'transferenciaViewTab',
    viewName: 'Transferencia',
    entity: 'movimiento',
    items: [
        {
            xtype: 'transferenciaDetails'
        },
        {
            xtype: 'transferenciaEditor'
        },
        {
            xtype: 'transferenciaSubPanel'
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



