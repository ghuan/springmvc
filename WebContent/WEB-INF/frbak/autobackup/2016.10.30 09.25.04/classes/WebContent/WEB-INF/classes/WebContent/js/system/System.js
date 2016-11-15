var System = System || {};
System.orgWindow = function(e, b, h, d) {
	var a = wdg.getDictStore("SYSTEM.ORG.TYPE", "int");
	var g = Ext.create("system.com.OrgQueryTree", {
				showRoot : d,
				firstOrgid : h,
				initData : b,
				columns : [{
							text : "序号",
							xtype : "rownumberer",
							width : 35,
							align : "center"
						}, {
							xtype : "treecolumn",
							text : "机构名称",
							width : 300,
							dataIndex : "NAME",
							align : "left"
						}, {
							text : "机构类型",
							flex : 1,
							dataIndex : "TYPE",
							renderer : function(i) {
								return wdg.tools.viewName(a, i, "学校");
							}
						}],
				listeners : {
					render : function() {
						g.expand();
					},
					itemdblclick : function() {
						if (e) {
							var i = g.getSelectionModel().getSelection();
							e(i);
						}
					}
				}
			});
	if (e) {
		g.getTbar().add({
					text : "选择",
					iconCls : "ok",
					handler : function() {
						var i = g.getSelectionModel().getSelection();
						e(i);
					}
				});
		g.getTbar().add("-");
	}
	var c = 465;
	if (d === true) {
		c = 590;
	}
	g.getTbar().add(g.getExpandAllBtn());
	g.getTbar().add(g.getCollapseAllBtn());
	var f = Ext.create("Ext.Window", {
				title : "选择组织部门(双击选择或者点击选择按钮)",
				modal : true,
				resizable : false,
				frame : true,
				plain : true,
				bodyPadding : "0 0 0 0",
				closeAction : "hide",
				layout : "fit",
				width : c,
				height : 580,
				items : g
			});
	f.setQueryKey = function(i) {
		if (i && i.trim() != "") {
			g.setQueryKey(i);
			g.queryByKey();
		}
	};
	f.setInitData = function(i) {
		if (i && i.length > 0) {
			g.setInitData(i);
			g.queryByKey();
		}
	};
	f.reset = function() {
		g.getSelectionModel().deselectAll();
	};
	return f;
};
System.userWindow = function(i, t, a, p, e) {
	var c = wdg.getDictStore("SYSTEM.USER.STATE", "int");
	var o = document.body.clientWidth * 0.8;
	var l = document.body.clientHeight * 0.9;
	var m = 220;
	if (p === true && e === true) {
		m = 300;
	}
	var d = Ext.create("system.com.OrgTreePanel", {
				title : "组织部门",
				collapsible : true,
				width : m,
				region : "west",
				firstOrgid : a,
				showQuery : p,
				showRoot : e,
				listeners : {
					render : function() {
						d.expand();
					},
					itemclick : function(w, v) {
						g.getForm().findField("node").setValue(v.data.ID);
						g.getForm().findField("ORG_NAME").setValue(v.data.NAME);
						k.getStore().loadPage(1);
					}
				}
			});
	var s = function() {
		return [{
					text : "学工号",
					dataIndex : "STUEMPNO"
				}, {
					text : "姓名",
					dataIndex : "NAME"
				}, {
					text : "组织部门",
					dataIndex : "ORG_NAME"
				}, {
					text : "状态",
					dataIndex : "STATE",
					renderer : function(w) {
						return wdg.tools.viewName(c, w);
					}
				}];
	};
	var k = Ext.create("system.com.CommonGrid", {
				region : "west",
				width : o * 0.35,
				model : "system.model.User",
				url : "system/user.query",
				title : "待选用户",
				autoLoad : false,
				collapsible : false,
				split : true,
				columns : s()
			});
	k.getStore().on("beforeload", function() {
				Ext.apply(k.getStore().proxy.extraParams, {
							node : a || wdg.base.user.ORGID
						});
			});
	var u = Ext.create("system.com.CommonGrid", {
				region : "center",
				model : "system.model.User",
				url : "system/user.query",
				title : "已选用户",
				autoLoad : false,
				collapsible : false,
				split : false,
				columns : s()
			});
	u.getPagging().hide();
	var q = t && wdg.isArray(t) && t.length > 0;
	var b = {
		region : "center",
		model : "system.model.User",
		cdPanel : k,
		chPanel : u
	};
	var j = function(v) {
		Ext.Ajax.request({
					url : "system.queryUserByIds",
					params : {
						ids : v
					},
					success : function(x) {
						var w = Ext.decode(x.responseText);
						f.setInitData(w.list);
					},
					failure : function() {
						Ext.Msg.alert(wdg.ERROR, "初始化用户失败。");
					}
				});
	};
	if (q) {
		var r = t[0];
		if (typeof(r) === "string") {
			j(t);
		} else {
			b.initData = t;
		}
	}
	var n = Ext.create("system.com.CommonChoosePanel", b);
	var g = Ext.create("system.com.CommonFormPanel", {
				region : "north",
				height : 80,
				frame : true,
				plain : true,
				border : false,
				bodyPadding : "5 5 5 5",
				autoScroll : true,
				columnCount : 3,
				items : [{
							fieldLabel : "姓名",
							name : "NAME"
						}, {
							fieldLabel : "学工号",
							name : "STUEMPNO"
						}, {
							fieldLabel : "组织部门",
							name : "ORG_NAME",
							disabled : true
						}, {
							xtype : "hidden",
							name : "node"
						}],
				buttonAlign : "center",
				buttons : [{
							text : "查询",
							iconCls : "search",
							handler : function() {
								k.getStore().loadPage(1);
							}
						}, {
							text : "重置",
							iconCls : "cancel",
							handler : function() {
								d.getSelectionModel().deselectAll();
								g.getForm().reset();
							}
						}]
			});
	k.getStore().on("beforeload", function() {
				Ext.apply(k.getStore().proxy.extraParams, g.getParameters());
			});
	var h = {
		title : "人员选择",
		modal : true,
		resizable : true,
		frame : true,
		plain : true,
		bodyPadding : "0 0 0 0",
		closeAction : "hide",
		layout : "border",
		width : o,
		height : l,
		items : [g, {
					frame : true,
					plain : true,
					layout : "border",
					region : "center",
					items : [d, n]
				}],
		listeners : {
			render : function() {
				k.getStore().load();
			}
		}
	};
	if (i) {
		h.buttons = [{
					text : "确定",
					iconCls : "save",
					handler : function() {
						i(n.getChoosed());
					}
				}, {
					text : "取消",
					iconCls : "cancel",
					handler : function() {
						var v = n.getChoosed();
						if (v.length == 0) {
							Ext.Msg.confirm("提示", "已选用户列表并没有数据，确认关闭吗？",
									function(w) {
										if ("yes" == w) {
											f.hide();
										}
									});
							return;
						}
						f.hide();
					}
				}];
	}
	var f = Ext.create("Ext.Window", h);
	f.setOrgQueryKey = function(v) {
		if (v && v.trim() != "") {
			d.setQueryKey(v);
			d.queryByKey();
		}
	};
	f.reset = function() {
		n.getPanel1().getSelectionModel().deselectAll();
		n.getPanel2().getStore().removeAll();
	};
	f.setInitData = function(v) {
		if (v && wdg.isArray(v) && v.length > 0 && typeof(v[0]) === "string") {
			j(v);
		} else {
			n.setInitData(v);
		}
	};
	return f;
};
System.userSampleWindow = function(e, b, g) {
	var a = wdg.getDictStore("SYSTEM.USER.STATE", "int");
	var f = Ext.create("Ext.toolbar.Toolbar", {
				items : [{
							text : "选择",
							iconCls : "add",
							handler : function() {
								if (e) {
									e(d.getGrid().getSelectionModel()
											.getSelection());
								}
							}
						}, {
							text : "关闭",
							iconCls : "cancel",
							handler : function() {
								h.hide();
							}
						}]
			});
	var d = Ext.create("system.com.UserQueryGrid", {
				gridTbar : f,
				labelWidth : 60,
				treeWidth : 200,
				firstOrgid : b,
				showRoot : g,
				columns : [{
							text : "序号",
							xtype : "rownumberer",
							width : 35,
							align : "center"
						}, {
							text : "学工号",
							dataIndex : "STUEMPNO"
						}, {
							text : "姓名",
							dataIndex : "NAME"
						}, {
							text : "组织部门",
							dataIndex : "ORG_NAME"
						}, {
							text : "状态",
							dataIndex : "STATE",
							renderer : function(k) {
								return wdg.tools.viewName(a, k);
							}
						}]
			});
	var c = document.body.clientWidth * 0.6;
	var j = document.body.clientHeight * 0.7;
	var i = {
		title : "人员选择(双击列表可以快速选择)",
		modal : true,
		resizable : true,
		frame : false,
		border : false,
		plain : true,
		bodyPadding : "0 0 0 0",
		closeAction : "hide",
		layout : "fit",
		width : c,
		height : j,
		items : d,
		listeners : {
			render : function() {
				d.getGrid().getStore().load();
			}
		}
	};
	d.getTree().getRootNode().expand();
	d.getGrid().on("itemdblclick", function(l, k) {
				if (e) {
					e([k]);
				}
			});
	var h = Ext.create("Ext.Window", i);
	return h;
};
System.roleWindow = function(d) {
	var c = Ext.create("Ext.form.field.Text", {
				width : 80
			});
	var b = Ext.create("system.com.CommonGrid", {
		tbar : Ext.create("Ext.toolbar.Toolbar", {
					items : ["角色名称：", c, {
								text : "查询",
								iconCls : "search",
								handler : function() {
									b.getStore().loadPage(1);
								}
							}, "-", {
								text : "选择",
								iconCls : "ok",
								handler : function() {
									if (d) {
										d(b.getSelectionModel().getSelection());
									}
								}
							}, {
								text : "关闭",
								iconCls : "cancel",
								handler : function() {
									a.hide();
								}
							}]
				}),
		model : "system.model.Role",
		url : "system/auth.queryRole",
		autoLoad : false,
		collapsible : false,
		columns : [{
					text : "序号",
					xtype : "rownumberer",
					width : 35,
					align : "center"
				}, {
					text : "角色名",
					dataIndex : "NAME"
				}, {
					text : "备注",
					dataIndex : "REMARK"
				}],
		listeners : {
			itemdblclick : function(f, e) {
				if (d) {
					d([e]);
				}
			}
		}
	});
	b.getStore().on("beforeload", function() {
				b.getStore().proxy.extraParams.NAME = c.getValue();
			});
	b.getStore().loadPage(1);
	var a = Ext.create("Ext.Window", {
				title : "可选择的角色列表",
				modal : true,
				resizable : false,
				frame : true,
				plain : true,
				bodyPadding : "0 0 0 0",
				closeAction : "hide",
				layout : "fit",
				width : 600,
				height : 500,
				items : b
			});
	return a;
};