Ext.define("subsystem.gsgl.personnel.jbxx.model.Personnel", {
			extend : "Ext.data.Model",
			fields : 
					[
		           {name:'id',type:'string'},
		           {name:'name',type:'string'},
		           {name:'sex',type:'int'},
		           {name:'idCard',type:'string'},
		           {name:'birthday',type:'string'},
		           {name:'address',type:'string'},
		           {name:'phone',type:'string'}]
		});