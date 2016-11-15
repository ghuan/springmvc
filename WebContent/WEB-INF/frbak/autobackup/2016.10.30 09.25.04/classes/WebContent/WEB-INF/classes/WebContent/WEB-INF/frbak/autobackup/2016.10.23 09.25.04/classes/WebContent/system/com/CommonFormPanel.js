Ext.define("system.com.CommonFormPanel", {
			extend : "Ext.form.Panel",
			xtype : "commonFormPanel",
			frame : false,
			border : false,
			plain : true,
			bodyPadding : "0 0 0 0",
			constructor : function(a) {
				a = a || {};
				this.getConfig = function() {
					return a;
				};
				this.callParent(arguments);
			},
			createFormItems : function() {
				var f = this;
				var a = f.getConfig().items;
				var g = f.getConfig().columnCount;
				var d = a.length;
//				if (d < g) {
//					g = d;
//				}
				var c = function(j) {
					var h = [];
					for (var k = 0; k < d; k++) {
						if (k % g == j) {
							h.push(a[k]);
						}
					}
					return h;
				};
				var b = [];
				
				for (var e = 0; e < g; e++) {
					b.push({
								defaultType : "textfield",
								defaults : {
									labelWidth : f.getConfig().labelWidth || 80,
									labelAlign : "right",
									anchor : "95%"
								},
								columnWidth : 1 / g,
								layout : "anchor",
								items : c(e)
							});
				}
				return b;
			},
			initComponent : function() {
				var a = this;
				this.getParameters = function() {
					var f = {};
					var d = a.getForm().getFields();
					var c = d.length;
					for (var e = 0; e < c; e++) {
						f[d.get(e).getName()] = d.get(e).getValue();
					}
					return f;
				};
				var b = a.getConfig().defaults || {};
				if (b) {
					b.baseCls = "x-column";
				}
				Ext.apply(this, {
							defaults : b,
							layout : "column",
							items : a.createFormItems()
						});
				this.callParent(arguments);
			}
		});