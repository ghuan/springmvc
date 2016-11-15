Ext.define("system.com.CommonQueryGrid", {
			extend : "Ext.Panel",
			xtype : "commonQueryGrid",
			frame : false,
			border : false,
			plain : true,
			bodyPadding : "0 0 0 0",
			layout : "border",
			constructor : function(a) {
				a = a || {};
				this.getConfig = function() {
					return a;
				};
				this.callParent(arguments);
			},
			initComponent : function() {
				var c = this;
				var e = Ext.create("system.com.CommonFormPanel", {
							collapsible : true,
							title : "查询条件",
							region : "north",
							split : true,
							frame : true,
							height : c.getConfig().formHeight || 90,
							autoScroll : true,
							buttonAlign : "center",
							margins : "0 0 0 0",
							cmargins : "0 0 0 0",
							items : c.formItems,
							columnCount : c.columnCount,
							labelWidth : c.labelWidth,
							buttons : [{
										text : "查询",
										iconCls : "Search",
										handler : function() {
											a.loadPage(1);
										}
									}, {
										text : "重置",
										iconCls : "Cancel",
										handler : function() {
											if (c.getConfig().beforeClear) {
												c.getConfig().beforeClear();
											}
											var g = this.up("form").getForm();
											g.reset();
										}
									}]
						});
				this.getFormPanel = function() {
					return e;
				};
				var f = {
					region : "center",
					model : c.getConfig().model,
					url : c.getConfig().url,
					pageSize : c.getConfig().pageSize,
					autoLoad : c.getConfig().autoLoad || false,
					title : c.getConfig().gridTitle,
					columns : c.getConfig().columns
				};
				var d = c.getConfig().gridTbar;
				if (d) {
					f.tbar = d;
				}
				var b = Ext.create("system.com.CommonGrid", f);
				this.getGrid = function() {
					return b;
				};
				var a = b.getStore();
				e.on("render", function() {
							a.on("beforeload", function() {
										Ext.apply(a.proxy.extraParams, e
														.getParameters());
									});
						});
				Ext.apply(this, {
							items : [e, b]
						});
				this.callParent(arguments);
			}
		});