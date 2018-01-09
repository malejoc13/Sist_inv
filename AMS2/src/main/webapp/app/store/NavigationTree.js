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
        if (!Session.Principal.accessAll) {

            me.config.children.forEach(function (node) {

                if (node.children) {//si no es hoja y tiene subnodos dentro 
                    var children = node.children;//escojo los hijos

                    node.children = [];

                    children.forEach(function (child) {//recoro los hijo a ver si teng permiso
                         if (me.hasAccess(child)) {
                              node.children.push(child);
                         }
                    });
                     if (node.children.length > 0) {//si se le asignaron hijos lo incluyo al tree
                        me.getRootNode().appendChild(node);
                    }
               } else {//en caso de que sea hoja
                    if (me.hasAccess(node)) {
                        me.getRootNode().appendChild(node);
                    }
                }
            });
        }else{
            me.config.children.forEach(function (node) {
                me.getRootNode().appendChild(node);
            });
        }   
    },
    hasAccess: function (node) {
        var Principal = Session.Principal,
                pageAccess = Principal.pageAccess;

        if (pageAccess.indexOf(node.viewType) > -1) {
            return true;
        }
        return false;
    },
    root: {
        expanded: true,
        children: []
    },
    config: {
        children: [
            {//nodos del tree
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
                viewType: 'inventarios',
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
            },
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
                        text: 'P&aacute;ginas',
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
