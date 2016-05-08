Ext.define("system.model.Org", {
			extend : "Ext.data.Model",
			fields : [{
						name : 'id',
						type : 'string'
					}, {
						name : 'pid',
						type : 'string'
					}, {
						name : 'type',
						type : 'int'
					}, {
						name : 'rank',
						type : 'int'
					}, {
						name : 'remark',
						type : 'string'
					}, {
						name : 'orgCode',
						type : 'string'
					}, {
						name : 'name',
						type : 'string'
					}, {
						name : 'morgId',
						type : 'string'
					}, {
						name : 'morgId_name',
						type : 'string'
					}]
		});
