Ext.define("system.model.Log", {
			extend : "Ext.data.Model",
			fields : [{
						name : 'id',
						type : 'string'
					}, {
						name : 'description',
						type : 'string'
					}, {
						name : 'type',
						type : 'int'
					}, {
						name : 'method',
						type : 'string'
					}, {
						name : 'params',
						type : 'string'
					}, {
						name : 'exceptionCode',
						type : 'string'
					}, {
						name : 'exceptionDetail',
						type : 'string'
					}, {
						name : 'requestIp',
						type : 'string'
					}, {
						name : 'createName',
						type : 'string'
					}, {
						name : 'creator',
						type : 'string'
					}, {
						name : 'createTime',
						type : 'string'
					}]
		});
