Ext.define('Admin.base.BaseGridTab', {
    extend:'Admin.base.BaseTab',
    xtype: 'baseGridTab',
    cls: 'shadow', 
    entity:null,
    requires: [ 
        'Admin.cmp.toolbar.ShowFiltersButton',
        'Admin.cmp.toolbar.CreateButton',
        'Admin.cmp.toolbar.EditGridRowButton',
        'Admin.cmp.toolbar.PdfReportButton',
        'Admin.cmp.toolbar.DeleteButton', 
        'Admin.cmp.toolbar.ReportButton'
    ],   
    tbar: [ 
        '->',
        {
            xtype: 'createButton'
        },
        {
            xtype: 'editGridRowButton' 
        },
        {
            xtype: 'deleteButton'
        },
        {
            xtype: 'excelReportButton'
        },
        {
            xtype: 'pdfReportButton'
        },
        {
            xtype: 'showFilters' 
        }
    ]
});
