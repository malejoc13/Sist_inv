Ext.define('Admin.cmp.gridColumn.BooleanGridColumn', {
    extend: 'Ext.grid.column.Column',
    xtype: 'booleanGridColumn',  
    sortable: true,
    trueVal: 'Si',
    falseVal: 'No',
    renderer: function (value, metaData) {  
        return value && value === true ? metaData.column.trueVal : metaData.column.falseVal;
    }
});
 