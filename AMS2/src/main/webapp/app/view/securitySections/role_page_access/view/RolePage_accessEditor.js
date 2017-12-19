Ext.define('Admin.view.securitySections.role_page_access.view.RolePage_accessEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.role_page_accessEditor',
    items: [
        {
            items: [
                {
                    xtype: 'idField'
                },
                {
                    fieldLabel: 'Rol',
                    xtype: 'baseSelectField',
                    name: 'roleId',
                    url: 'role',
                    applyFilter: 'id=(L)',
                    filterPropertyName: 'superData.id',
                    disabledIfHasValue:true,
                    defaultPropertyValue:'superData.id'
                },
                {
                    fieldLabel: 'P&aacute;gina',
                    xtype: 'baseSelectField',
                    name: 'page_accessId',
                    url: 'page_access',
                    allowBlank : false,                    
                    emptyText : "Seleccione...",
                    editable : false,
                    blankText : 'Este campo es obligatorio'
                }
            ]
        }
    ]
});



