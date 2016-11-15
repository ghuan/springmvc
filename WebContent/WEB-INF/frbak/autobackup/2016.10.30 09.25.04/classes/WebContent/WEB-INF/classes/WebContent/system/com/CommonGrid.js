Ext.define("system.com.CommonGrid", {
			extend : "Ext.grid.Panel",
			xtype : "commonGrid",
			autoScroll : true,
			frame : true,
			collapsible : true,
			forceFit : true,
			border : true,
			split : true,
			layout : "fit",
			constructor : function(a) {
				a = a || {};
				this.getConfig = function() {
					return a;
				};
				this.callParent(arguments);
			},
			initComponent : function() {
				
				var d = this;
				var f = Ext.create("Ext.selection.CheckboxModel", {
							showHeaderCheckbox : true,
							mode : d.getConfig().selectModel || "MULTI",
							checkOnly : false
						});
				var c = {
					pageSize : d.getConfig().pageSize,
					model : d.getConfig().model,
					url : d.getConfig().url
				};
				if (d.getConfig().autoLoad === false) {
					c.autoLoad = false;
				}
				var a = null;
				var isloadDeselect = true;
				if(d.getConfig().isloadDeselect === false){
				
					isloadDeselect = false;
				}
				if(isloadDeselect){
					a = fn.sf.createStore(c,f);
				}else {
					a = fn.sf.createStore(c);
				}
				var b = Ext.create("Ext.toolbar.Paging", {
							store : a,
							displayInfo : true
						});
				this.getPagging = function() {
					return b;
				};
				if (this.getConfig().tbar) {
					this.getTbar = function() {
						return d.getConfig().tbar;
					};
				}
				e = d.getConfig().plugins;
				this.getCellEditing = function() {
					return e;
				};
				Ext.apply(this, {
							store : a,
							selModel : f,
							bbar : b,
							plugins : e
						});
				this.callParent(arguments);
				
			}
		});