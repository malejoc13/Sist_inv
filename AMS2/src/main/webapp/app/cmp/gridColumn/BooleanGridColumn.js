Ext.define('Admin.cmp.gridColumn.BooleanGridColumn', {
    extend: 'Ext.grid.column.Column',
    xtype: 'booleanGridColumn',  
    sortable: true,
    trueText: 'Si',
    falseText: 'No',
    renderer: function (value, metaData) {  
        return value && value === true ? metaData.column.trueText : metaData.column.falseText;
    }
});
 