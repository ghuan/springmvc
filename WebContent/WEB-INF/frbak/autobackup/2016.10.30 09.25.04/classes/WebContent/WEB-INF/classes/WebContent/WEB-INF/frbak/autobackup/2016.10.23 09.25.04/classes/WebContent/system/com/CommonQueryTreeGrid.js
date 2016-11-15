Ext.define("system.com.CommonQueryTreeGrid", {
	extend : "Ext.Panel",
	xtype : "commonQueryTreeGrid",
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
		var d = this;
		var b = d.getConfig().tree;
		b.region = "west";
		var a = Ext.create("system.com.CommonTree", b);
		var c = d.getConfig().queryGrid;
		c.region = "center";
		c.beforeClear = function() {
			a.getSelectionModel().deselectAll();
		};
		var e = Ext.create("system.com.CommonQueryGrid", c);
		e.on("render", function() {
					e.getGrid().getStore().on("beforeload", function() {
								var g = e.getFormPanel().getParameters();
								var f = a.getSelectionModel().getSelection();
								g.node = f.length > 0 ? f[0].get("id") : "";
								Ext
										.apply(
												e.getGrid().getStore().proxy.extraParams,
												g);
							});
				});
		this.getTree = function() {
			return a;
		};
		this.getGrid = function() {
			return e.getGrid();
		};
		this.getFormPanel = function() {
			return e.getFormPanel();
		};
		Ext.apply(this, {
					items : [a, e]
				});
		this.callParent(arguments);
	}
});