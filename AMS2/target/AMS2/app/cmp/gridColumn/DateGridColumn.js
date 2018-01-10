Ext.define('Admin.cmp.gridColumn.DateGridColumn', {
    extend: 'Ext.grid.column.Date',
    xtype: 'dateGridColumn',  
    sortable: true,
    format: 'd/m/Y',   
    renderer: function (value, metaData) { 
        var date = new Date( value );
        return Ext.Date.format(date, metaData.column.format);
    }
});
 