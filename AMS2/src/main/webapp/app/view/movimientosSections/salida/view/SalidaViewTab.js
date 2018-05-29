Ext.define('Admin.view.movimientosSections.salida.view.SalidaViewTab', {
    extend: 'Admin.base.BaseViewTab',
    xtype: 'salidaViewTab',
    viewName: 'Salida',
    entity: 'movimiento',
    items: [
        {
            xtype: 'salidaDetails'
        },
        {
            xtype: 'salidaEditor'
        },
        {
            xtype: 'salidaSubPanel'
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
