Ext.define("system.model.Menu", {
	extend : "Ext.data.Model",
	fields : [
	           {name:'id',type:'string'},
	           {name:'pid',type:'string'},
	           {name:'name',type:'string'},
	           {name:'url',type:'string'},
	           {name:'iconCls',type:'string'},
	           {name:'type',type:'int'},
	           {name:'state',type:'int'},
	           {name:'openMethod',type:'int'},
	           {name:'rank',type:'int'},
	           {name:'leaf',type:'boolean'},
	           {name:'check',type:'boolean'},
	           {name:'remark',type:'string'}]
});