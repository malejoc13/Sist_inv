Ext.define('Admin.base.BaseController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.baseController',
    singleClickTask: null,
    executingDblClick: false,
    init: function () {

        var me = this,
                grid = me.getView().down('basePaginatedGrid');

        if (grid) {
            grid.getStore().load();
        }
    },
//Cuando al Grid que esta en el SuperTab se le da click
//Se actualiza el entityId del super tab y del Tab que este seleccionado en el SubPanel
//y se recarga el grid el Tab seleccionado en el SubPanel
    onGridItemClick: function (view, td, cellIndex, record) {
        var me = this,
                superTab = view.up().up(); //the tab that wraps the grid

        me.singleClickTask = setTimeout(function () { //to diferenciate between click and double click

            if (me.executingDblClick || superTab.isShowingOnBottom()) {
                me.executingDblClick = false;
                return;
            }
            //le asigno las propiedades al baseTab
            if (!superTab.isShowingOnBottom()) {//Actualizar superTab.entityId solo cuando el click sea en el grid de arriba.
                superTab.entityId = record.data.id;  //Important (don't remove)
                superTab.superData = record.data;
            }

            if (superTab.items.items && //if the parent tab of the grid contains items
                    superTab.items.items.length > 1) { //if more than one
                var subPanel = view.up().up().items.items[1];//busco en el container si tengo declarado un subtab

                var activeSubTab = subPanel.getActiveTab();
                //le paso al subtab de abajo el filtro de busqueda y el id de la entidad
                if (activeSubTab) {//si estoy mostrando un tab 
                    activeSubTab.filters = superTab.filters;//filtros de busqueda para el subtab que se los pasa automaticacamente el plugin ante de cargar
                    activeSubTab.entityId = superTab.entityId;//id de la entidad

                    var activeTabElement = activeSubTab.items.items[0];
                    //si es un grid lo que hay n el subtab lo mando a cargar
                    if (activeTabElement instanceof Admin.base.BasePaginatedGrid) {
                        if (activeSubTab.entity === 'role_page_access') {
                            activeSubTab.setTitle("Rol "+record.data.name+" - Acceso a P&aacute;ginas");
                        }
                        
                        activeTabElement.getStore().loadPage(1);//recargo el grid del subtab
                    }                                           //y el plugin del grid filter que se anexa 
                                                               //cada vez que creo un grid y le pasa los filtros
                                                                //que los coje del supertab con la funcion getParams
                }

                if (!subPanel.isVisible()) {
                    subPanel.show();
                }

            }
        }, 200);
    },
    
    //se levanta un nuevo tab con los datos de la fila seleccionada
    onGridItemDblClick: function (data, grid) {
        var me = this,
                tab = grid.up();
       if (String(tab.entity) !== 'inv_historico') {
           
            me.executingDblClick = true;
            clearTimeout(me.singleClickTask); //to diferenciate between click and double click

            if (!tab.isShowingOnBottom()) {//Actualizar superTab.entityId solo cuando el click sea en el grid de arriba.
                tab.entityId = data.id;  //Important (don't remove)
                tab.superData = data;
            }

            me.openViewTab(data, grid);
        }  
    },
    openSingleView: function (cmp) {
        var me = this;
        me.openSigleViewTab(cmp.openView);
    },
    deleteGridRow: function (cmp){
       var me = this,
           grid = cmp.up().up().items.items[0],
           currentTab = grid.up(),
           message = "¿Est&aacute; seguro que desea eliminar?",
           data = grid.getSelectionModel().getSelection();
           if (data.length !== 1) {//si no ha selecciondo nada
                return;
            } else {
                data = data[0].data;
            }
        if (String(currentTab.entity) === 'inventario') {
            //alert('inv.');
            message = "¿Est&aacute; seguro que desea eliminar?<br/>Tenga en cuenta que también eliminará todas sus entradas en el Histórico"
        }
        Ext.Msg.confirm("Eliminar", message, function(btn){
            if (btn == "yes") {
                Ext.getBody().mask("Eliminando...");
                Request.load({
                    url: me.getView().xtype + '/' + currentTab.entity + '/delete',
                    method: 'POST',            
                    jsonData:'{"id":"(L)'+data.id+'"}',
                    ignoreError: true,
                    success: function (response) {
                        Ext.getBody().unmask();
                        if (response.status === 450 || response.status === 550 || response.status === 500) {
                             Ext.Msg.alert('Informaci&oacute;n', response.statusMessage);
                        } else {
                            grid.getStore().loadPage(1);  
                        }                                   
                     }
                }) 
            } 
        });         
    },
    editGridRow: function (cmp) {
        //Usado por los botones de 'New' y 'Edit' del Toolbar
        var me = this,
            grid = cmp.up().up().items.items[0];//voy al container y escojo el grid

        var data = null;
        if (cmp instanceof Admin.cmp.toolbar.EditGridRowButton) {
            data = grid.getSelectionModel().getSelection();
            //Si es el boton Edit, tomar la data del row seleccionado en el Grid
            if (data.length !== 1) {
                return;
            } else {
                data = data[0].data;
            }
        }

        me.openViewTab(data, grid);
    },
    //Cuando se le da doble click a un grid row o en la opcion 'Crear Nuevo'
    // o la opcion de 'Editar'
    //Se crea un ViewTab del tipo de elemento del grid
   
    openViewTab: function (data, grid) {
        var me = this,
                xtype = grid.xtype, //ej 'proveedorGridTab'
                currentTab = grid.up(),//gridTab
                openViewFilters = currentTab.openViewFilters,//ej role_page_accessGridTab
                originCmpId = grid.id,
                superTab = me.getView().getActiveTab(),
                view = xtype.substring(0, xtype.indexOf('Grid')),//ej proveedor
                viewTab = grid.openViewTab || view + 'ViewTab',//ej proveedorViewTab
                itemId = viewTab + '-' + (data ? data.id : (new Date()).getTime()), //ej proveedorViewTab-1 o uno aleatorio
                existentTab = me.getView().down('#' + itemId),
                showingOnTop = !currentTab.isShowingOnBottom();         

        if (data && showingOnTop) {
            superTab.entityId = data.id; //Important (don't remove) 
        }

        if (existentTab) {
            me.getView().setActiveTab(existentTab);
        } else {

            var newTab = {xtype: viewTab,
                closable: true,
                itemId: itemId,
                filters: openViewFilters || superTab.filters,
                //'filters' determina el filtro que se le aplicara a los Sub Tabs
                //de la vista que se esta abriendo
                //OJO
                //Debe ser especificado en el SubPanel que contiene el GridTab (ver PartnerSubPanel como ejemplo)
                //y nunca ser especificado en el mismo GridTab, ya que ese GridTab puede ser utilizado
                //desde varios SubPanels con diferentes filtros.
                //SINO
                //Sino se especifica 'openViewFilters', la vista se abrira con el filtro de la vista actual
                entityId: (data ? data.id : null),
                superEntityId: superTab.entityId,
                //En algunos casos se necesita el ID de la entidad seleccionada en el SuperTab
                originCmpId: originCmpId,
                //ID del componente desde el cual se esta abriendo una nueva vista
                //Esto se usa para refrescar dicho componente despues de crear/editar 
                data: data,
                superData: (showingOnTop && !data) ? null : superTab.superData,
                subPanelsToShow: currentTab.subPanelsToShow
                        //Usar cuando se quiera que el tab que se abre, muestre solo ciertos subpanels
            };

            if (grid.loadAdditionalInfoWhenDblClick && data) {//si se necesita cargar datos
                Request.load({
                    url: me.getView().xtype + '/' + currentTab.entity + '/load',
                    params: 'params=id=(L)' + data.id,
                    success: function (response) {
                        newTab.data = response;

                        if (showingOnTop) {
                            newTab.superData = response; //If is tab on top, superData should include the data obtained on load
                        }

                        me.getView().setActiveTab(newTab);
                        me.getView().down('#' + itemId).init(response);
                    }
                });
            } else {
                me.getView().setActiveTab(newTab);
                me.getView().down('#' + itemId).init(data);
            }
        }
    },
    openSigleViewTab: function (xtype) {
        var me = this,
                itemId = me.getView().xtype + '_' + xtype,
                existentTab = me.getView().down('#' + itemId);

        if (existentTab) {
            me.getView().setActiveTab(existentTab);
        } else {
            var newTab = {
                itemId: itemId,
                xtype: xtype,
                closable: true
            };
            me.getView().setActiveTab(newTab);
        }
    }
});
