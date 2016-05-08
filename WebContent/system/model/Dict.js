Ext.define("system.model.Dict", {
			extend : "Ext.data.Model",
			fields : 
					[
		           {name:'id',type:'string'},
		           {name:'pid',type:'string'},
		           {name:'dataId',type:'string'},
		           {name:'creator',type:'string'},
		           {name:'updateTime',type:'string'},
		           {name:'value',type:'string'},
		           {name:'state',type:'int'},
		           {name:'rank',type:'int'},
		           {name:'remark',type:'string'}]
		});