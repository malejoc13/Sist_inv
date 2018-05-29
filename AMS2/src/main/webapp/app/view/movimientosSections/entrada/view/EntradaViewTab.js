Ext.define('Admin.view.movimientosSections.entrada.view.EntradaViewTab', {
    extend: 'Admin.base.BaseViewTab',
    xtype: 'entradaViewTab',
    viewName: 'Entrada',
    entity: 'movimiento',
    items: [
        {
            xtype: 'entradaDetails'
        },
        {
            xtype: 'entradaEditor'
        },
        {
            xtype: 'entradaSubPanel'
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


