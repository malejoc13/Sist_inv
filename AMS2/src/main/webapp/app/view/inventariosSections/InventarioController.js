Ext.define('Admin.view.inventariosSections.InventarioController', {
    extend: 'Admin.base.BaseController',
    alias: 'controller.inventarioController',
    onLisInv: function () {        
        if (!Session.Principal.accessAll){
               var me = this,
                 searchParams;
         searchParams = 'unidad.id@is@(L)' +Session.Principal.entityId;
            Ext.Msg.alert('Informaci&oacute;n', "Listado de "+searchParams);
        }else{
             //Ext.Msg.alert('Informaci&oacute;n', "Listado completo "+searchParams);
        }
    }
    
    
});


