Ext.define('Admin.cmp.gridColumn.ToolTipColumn', {
    extend: 'Ext.grid.column.Column',
    xtype: 'toolTipColumn',  
    sortable: true,  
    renderer: function(value, metaData, record, rowIdx, colIdx, store) {
                    metaData.tdAttr = 'data-qtip="' + record.get('descripcion') + '"';
                    return value;
                }
});

