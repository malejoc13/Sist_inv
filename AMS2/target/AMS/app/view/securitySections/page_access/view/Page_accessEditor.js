Ext.define('Admin.view.securitySections.page_access.view.Page_accessEditor', {
    extend: 'Admin.base.BaseEditor',
    alias: 'widget.page_accessEditor',
    items: [
        {
            width: "50%",
            items: [
                {
                    xtype: 'idField'
                },
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Nombre de p&aacute;gina',
                    name: 'name',
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'
                }
            ]
        },
        {
            width: "50%",
            items: [
                {
                    xtype     : 'baseTextField',
                    fieldLabel: 'Id de p&aacute;gina',
                    name: 'idPage',
                    allowBlank : false,
                    blankText : 'Este campo es obligatorio'
                }
            ]
        }
    ]
});

