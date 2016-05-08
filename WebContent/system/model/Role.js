Ext.define("system.model.Role", {
			extend : "Ext.data.Model",
			fields : 
					[
		           {name:'id',type:'string'},
		           {name:'name',type:'string'},
		           {name:'rank',type:'int'},
		           {name:'leaf',type:'boolean'},
		           {name:'path',type:'string'},
		           {name:'pathName',type:'string'},
		           {name:'iconCls',type:'string',defaultValue:'Usergraycool'},
		           {name:'remark',type:'string'},
		           {name:'orgIds',type:'string'},
		           {name:'orgNames',type:'string'}]
		});