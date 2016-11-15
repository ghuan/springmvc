Ext.define("system.com.CommonAssignPanel", {
			extend : "Ext.Panel",
			xtype : "commonAssignPanel",
			plant : true,
			split : true,
			constructor : function(a) {
				a = a || {};
				this.getConfig = function() {
					return a;
				};
				this.callParent(arguments);
			},
			initComponent : function() {
				var k = this;
				var e = this.getConfig().cdPanel;
				var j = this.getConfig().chPanel;
				var h = this.getConfig().model;
				var l = this.getConfig().initData;
				var q = this.getConfig().idProperty || "id";
				this.setInitData = function(u) {
					var r = -1;
					if (u && (r = u.length) <= 0) {
						return;
					}
					for (var t = 0; t < r; t++) {
						var s = Ext.create(h, u[t]);
						j.getStore().add(s);
					}
					p();
				};
				this.on("render", function() {
							k.setInitData(l);
						});
				var p = function() {
					var t = e.getStore();
					var v = j.getStore();
					var r = [];
					for (var u = 0; u < v.getCount(); u++) {
						for (var s = 0; s < t.getCount(); s++) {
							if (t.getAt(s).get(q) == v.getAt(u).get(q)) {
								r.push(t.getAt(s));
								break;
							}
						}
					}
					if (r.length != 0) {
						e.getSelectionModel().select(r);
					}
				};
				e.getStore().on("load", function() {
							p();
						});
				var c = function(v) {
					var s = -1;
					if (v && (s = v.length) <= 0) {
						Ext.Msg.showTop("请选择要添加的数据。");
						return;
					}
					var r = 0;
					var u = function(y) {
						var z = j.getStore();
						for (var x = 0; x < z.getCount(); x++) {
							if (y.get(q) == z.getAt(x).get(q)) {
								r++;
								return;
							}
						}
						var w = Ext.create(h, y.data);
						z.add(w);
					};
					for (var t = 0; t < s; t++) {
						u(v[t]);
					}
					if (r != 0) {
						Ext.Msg.showTop("您选择了" + r + "个重复数据，数据并没有重复添加。");
					}
				};
				var g = function() {
					var r = e.getSelectionModel().getSelection();
					c(r);
				};
				var n = function() {
					var r = e.getStore().data.items;
					c(r);
					e.getSelectionModel().select(r);
				};
				var m = function(w) {
					var r = -1;
					if (w && (r = w.length) <= 0) {
						Ext.Msg.showTop("请选择要移除的数据。");
						return;
					}
					var t = e.getStore();
					var s = [];
					for (var v = 0; v < t.getCount(); v++) {
						for (var u = 0; u < r; u++) {
							if (w[u].get(q) == t.getAt(v).get(q)) {
								s.push(t.getAt(v));
								break;
							}
						}
					}
					if (s.length != 0) {
						e.getSelectionModel().deselect(s);
					}
					j.getStore().remove(w);
				};
				var o = function() {
					var r = j.getSelectionModel().getSelection();
					m(r);
				};
				var i = function() {
					var r = j.getStore().data.items;
					m(r);
				};
				var a = Ext.create("Ext.Button", {
							text : " >> ",
							height : 30,
							width : 60,
							handler : function() {
								g();
							}
						});
				var b = Ext.create("Ext.Button", {
							text : " << ",
							height : 30,
							width : 60,
							handler : function() {
								o();
							}
						});
				var f = Ext.create("Ext.Button", {
							text : " >>> ",
							height : 30,
							width : 60,
							handler : function() {
								n();
							}
						});
				var d = Ext.create("Ext.Button", {
							text : " <<< ",
							height : 30,
							width : 60,
							handler : function() {
								i();
							}
						});
				this.getPanel1 = function() {
					return e;
				};
				this.getPanel2 = function() {
					return j;
				};
				this.getChoosed = function() {
					var r = k.getPanel2().getStore().data.items;
					if (r) {
						return r;
					}
					return [];
				};
				Ext.apply(this, {
							layout : "border",
							border : false,
							frame : false,
							items : [e, {
										region : "center",
										layout : "border",
										frame : false,
										border : false,
										items : [{
													region : "west",
													width : 75,
													layout : "vbox",
													bodyPadding : "50 1 50 1",
													frame : true,
													border : false,
													split : true,
													plain : false,
													items : [a, b, f, d]
												}, j]
									}]
						});
				this.callParent(arguments);
			}
		});