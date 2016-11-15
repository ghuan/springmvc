Ext.define("system.com.CommonFormWindow", {
			extend : "Ext.Window",
			xtype : "commonFormWindow",
			modal : true,
			resizable : false,
			frame : true,
			plain : true,
			border: false,
			bodyPadding : "2 2 2 2",
			closeAction : "hide",
			buttonAlign : 'center',
			layout : "fit",
			width : 550,
			height : 400,
			buttons : [{
						text : "保存",
						iconCls : "Disk",
						handler : function() {
							var a = this.up("window");
							if (a.getFormPanel().getForm().isValid()) {
								a.submit();
							}
						}
					}, {
						text : "关闭",
						iconCls : "Cancel",
						handler : function() {
							this.up("window").hide();
						}
					}],
			constructor : function(a) {
				a = a || {};
				this.getConfig = function() {
					return a;
				};
				this.callParent(arguments);
			},
			initComponent : function() {
				var b = this;
				var c = b.getConfig().columnCount || 1;
				var a = null;
				if (c <= 1) {
					a = Ext.create("Ext.form.Panel", {
								frame : true,
								plain : true,
								border : false,
								bodyPadding : "5 5 5 5",
								autoScroll : true,
								defaults : {
									anchor : "95%",
									labelWidth : b.getConfig().labelWidth || 80,
									labelAlign : "right"
								},
								defaultType : "textfield",
								items : b.getConfig().items
							});
				} else {
					a = Ext.create("system.com.CommonFormPanel", {
								frame : true,
								plain : true,
								border : false,
								bodyPadding : "5 5 5 5",
								autoScroll : true,
								columnCount : c,
								items : b.getConfig().items
							});
				}
				this.getFormPanel = function() {
					return a;
				};
				this.loadRecord = function(d) {
					b.getFormPanel().getForm().loadRecord(d);
				};
				this.findField = function(d) {
					return b.getFormPanel().getForm().findField(d);
				};
				this.setParams = function(d) {
					b.getConfig().params = d;
				};
				this.submit = function() {
					var d = this.getFormPanel().getForm();
					if (d.isValid()) {
						if (b.getConfig().validate) {
							if (!b.getConfig().validate(d)) {
								return;
							}
						}
						b.getConfig().failure = b.getConfig().failure
								|| function(e, f) {
									Ext.Msg.alert(fn.ERROR, System_Constants.SYSTEM_ERROR_MSG);
								};
						d.submit({
									waitMsg : "正在保存数据，请稍后...",
									method : "POST",
									url : b.getConfig().url,
									params : b.getConfig().params || {},
									success : function(e, f) {
										if (b.getConfig().success) {
											b.getConfig().success(e, f);
										}
									}
								});
					}
				};
				Ext.apply(this, {
							items : a
						});
				this.callParent(arguments);
			}
		});