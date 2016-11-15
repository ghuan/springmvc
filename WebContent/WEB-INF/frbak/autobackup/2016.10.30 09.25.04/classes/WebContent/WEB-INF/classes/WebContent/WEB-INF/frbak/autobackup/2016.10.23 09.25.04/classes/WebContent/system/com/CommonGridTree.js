Ext.define("system.com.CommonGridTree", {
			extend : "system.com.CommonTree",
			xtype : "commonGridTree",
			rowLines : true,
			useArrows : true,
			border : true,
			constructor : function(a) {
				a = a || {};
				this.getConfig = function() {
					return a;
				};
				this.callParent(arguments);
			},
			initComponent : function() {
				var a = this;
				var b = Ext.create("Ext.selection.CheckboxModel", {
							showHeaderCheckbox : true,
							mode : a.getConfig().selectModel || "MULTI",
							checkOnly : false
						});
				Ext.apply(this, {
							selModel : b
						});
				this.callParent(arguments);
			}
		});