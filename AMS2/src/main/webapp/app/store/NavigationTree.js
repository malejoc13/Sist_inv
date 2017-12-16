Ext.define('Admin.store.NavigationTree', {
//    extend: 'Admin.override.tree.TreeStore',
    extend: 'Ext.data.TreeStore',
    storeId: 'NavigationTree',
    fields: [{
            name: 'text'
        }],
    custom: function () {
        var me = this;
        me.getRootNode().removeAll();

        me.config.children.forEach(function (node) {

//            if (node.children) {
//                var children = node.children;
//
//                node.children = [];
//
//                children.forEach(function (child) {
//                     if (me.hasAccess(child)) {
//                          node.children.push(child);
//                     }
//                });
//
//                    if (node.children.length > 0) {
//                    me.getRootNode().appendChild(node);
//                }
//            } else {
                if (me.hasAccess(node)) {
                    me.getRootNode().appendChild(node);
//                }
            }
        });
    },
    hasAccess: function (node) {
        var Principal = Session.Principal,
                pageAccess = Principal.pageAccess,
                accessAll = Principal.accessAll;

//TODO implement this 
//        return (accessAll && (pageAccess.indexOf(node.viewType) === -1 && pageAccess.indexOf(node.routeId) === -1))
//                || !accessAll && ((pageAccess.indexOf(node.viewType) > -1) || pageAccess.indexOf(node.routeId) > -1);
        return true;
    },
    root: {
        expanded: true,
        children: []
    },
    config: {
        children: [
            {
                text: 'Tablero',
                iconCls: 'x-fa fa-desktop',
                rowCls: 'nav-tree-badge',
                viewType: 'admindashboard',
                routeId: 'dashboard',
                leaf: true
            },
            {
                text: 'Inventario',
                iconCls: 'x-fa fa-file-text-o',
                viewType: 'transactions',
                leaf: true
            },
            {
                text: 'Nomencladores',
                iconCls: 'x-fa fa-leanpub',
                expanded: false,
                selectable: false,//                
                children: [
                    {
                        text: 'Unidades',
                        iconCls: 'x-fa fa-shopping-cart',
                        viewType: 'unidades',
                        leaf: true
                    },
                    {
                        text: 'Proveedores',
                        iconCls: 'x-fa fa-truck',
                        viewType: 'proveedores',
                        leaf: true
                    },
                    {
                        text: 'Tipos de productos',
                        iconCls: 'x-fa fa-object-group',
                        viewType: 'tipo_prods',
                        leaf: true
                    },
                    {
                        text: 'Unidadeds de medidas',
                        iconCls: 'x-fa fa-underline',
                        viewType: 'un_medidas',
                        leaf: true
                    },
                    {
                        text: 'Productos',
                        iconCls: 'x-fa fa-folder-open-o',
                        viewType: 'productos',
                        leaf: true
                    }
                ]
            }/*,
            {
                text: 'Clients',
                iconCls: 'x-fa fa-users',
                viewType: 'clients',
                leaf: true
            },
             {
                text: 'Mobile Clients',
                iconCls: 'x-fa fa-mobile',
                viewType: 'mobileClients',
                leaf: true
            },            
            {
                text: 'Credit Cards',
                iconCls: 'x-fa fa-credit-card',
                rowCls: 'nav-tree-badge',
                viewType: 'cards',
                leaf: true
            }, 
            {
                text: 'Profile',
                iconCls: 'x-fa fa-edit',
                viewType: 'profile',
                leaf: true
            }/*,
            {
                text: 'Configurations',
                iconCls: 'x-fa fa-arrows',
                expanded: false,
                selectable: false,
                children: [
                    {
                        text: 'Fee Schedules',
                        iconCls: 'x-fa fa-clock-o',
                        viewType: 'feeAllocationConfigs',
                        leaf: true,
                        style: {
                            'margin-right': '0px',
                            'padding-right': '0px'
                        }
                    },
                ]
            }*/,
            {
                text: 'Seguridad',
                iconCls: 'x-fa fa-key',
                expanded: false,
                selectable: false,
                children: [
                    {
                        text: 'Roles',
                        iconCls: 'x-fa fa-diamond',
                        viewType: 'roles',
                        leaf: true
                    },
                    {
                        text: 'Accesos',
                        iconCls: 'x-fa fa-object-ungroup',
                        viewType: 'pages_access',
                        leaf: true
                    },
                    {
                        text: 'Usuarios',
                        iconCls: 'x-fa fa-user',
                        viewType: 'users',
                        leaf: true
                    }
                ]
            }/*,
            {
                text: 'Charts',
                iconCls: 'x-fa fa-home',
                viewType: 'reports',
                leaf: true
            }*/
        ]
    }
});
