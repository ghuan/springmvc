//自定义树
Ext.define("system.com.CommonTree", {
	extend : "Ext.tree.Panel",
	xtype : "commonTree",
	animate : false,
	extended : false,
	autoScroll : true,
	rootVisible : true,
	border : false,
	containerScroll : true,
	collapsible : false,
	autoScroll : true,
	useArrows : true,
	split : true,
	displayField : "name",
	constructor : function(a) {

		a = a || {};
		this.displayField = a.displayField || this.displayField;
		this.getConfig = function() {
			return a;
		};
		this.callParent(arguments);
	},
	initComponent : function() {
		var a = this;
		//fn.imports(this.getConfig().model);
		var b = Ext.create("Ext.data.TreeStore", {
			model : a.getConfig().model,
			autoLoad : false,
			proxy : {
				type : "ajax",
				url : a.getConfig().url,
				reader : {
					type : "json",
					idProperty : a.getConfig().idProperty || "id",
					clearOnLoad : true
				}
//				,
//				extractResponseData: function(response) {
//					
//              	 	var o = Ext.JSON.decode(response.responseText);
//	   				if(o.success == false){
//	   					Ext.Msg.consoleAlert(fn.ERROR,o);
//	   					return;
//	   				}
//	   				return response;
//          		}
			},
			root : {
				id : a.getConfig().rootId || "root",
				name : a.getConfig().rootText || "root",
				state : a.getConfig().STATE || 1
			} 
		});
		this.getExpandAllBtn = function() {
			return Ext.create("Ext.Button", {
				text : "展开全部",
				iconCls : "Chartorganisationadd",
				handler : function() {
					a.expandAll();
				}
			});
		};
		this.getCollapseAllBtn = function() {
			return Ext.create("Ext.Button", {
				text : "收缩全部",
				iconCls : "Chartorganisationdelete",
				handler : function() {
					a.collapseAll();
				}
			});
		};
		if (this.getConfig().tbar) {
			this.getTbar = function() {
				return a.getConfig().tbar;
			};
		}
		Ext.apply(this, {
			store : b
		});
		this.callParent(arguments);
	}
});