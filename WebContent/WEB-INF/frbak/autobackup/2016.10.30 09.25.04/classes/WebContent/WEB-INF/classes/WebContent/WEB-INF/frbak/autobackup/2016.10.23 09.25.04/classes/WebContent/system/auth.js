fn.imports("system.constants.Org_Constants");
fn.imports("system.constants.User_Constants");
fn.imports("system.constants.Menu_Constants");
fn.imports("system.com.CommonComboBoxTree");

Ext.onReady(function() {
	var userSexDict = fn.getDictStore(User_Constants.USER_SEX, "int");
	var userStateDict = fn.getDictStore(User_Constants.USER_STATE, "int");
	var orgRootText = fn.getDictValue(Org_Constants.ORG_DICT_ORGROOT);
	var menuTypeDict = fn.getDictStore(Menu_Constants.MENU_DICT_TYPE, "int");
	var divid = "auth.viewAuth";
	var height = document.getElementById(divid).offsetHeight;
	var width = document.getElementById(divid).offsetWidth;
	var frontRole = null;
	var a = Ext.create("system.com.CommonFormWindow", {
				title : "保存系统角色",
				url : "auth/saveOrUpdateRole.action",
				height : 300,
				success : function(m, n) {
					a.hide();
					Ext.Msg.showTop("保存系统角色成功。");
					roleGrid.getPagging().doRefresh();
				},
				items : [{
							fieldLabel : "角色名称",
							name : "name"
						}, {
							//基本属性设置
							xtype :'commoncomboboxtree',
							fieldLabel:'组织机构',
							name:'orgIds',
							editable: false,							//是否可编辑，默认为false
							
							//树的属性设置
							url : 'org/getOrg.action',				//treestore的url
							model:'system.model.Org',				//treestore的model
							expandAll : true,						//树初始化是否展开全部，默认为false
							rootId : 'root',						//treestore的root id，默认为root
							rootText : orgRootText,					//treestore的root name，默认为root
							rootVisible : true,						//是否显示根节点，默认为false
							displayField : 'name',					//显示值的映射,默认为text
							multiCascade:false,						//多选时是否级联选择，默认为true
							multiSelect : true,					//是否多选，默认false
							
							//树的模糊查询设置
							allowQuery : true						//是否允许模糊查询，默认为false
							//queryUrl : 'org/getOrgByPath.action'	//模糊查询url，前提allowQuery为true,不填默认为url的路径，默认传参名name，返回json串需包含path字段名，path值为'/'隔开的树节点id值
																	//如'/1/934c35317bf349b9abc5e743ff8ed034'
							
						}, {
							xtype : "numberfield",
							fieldLabel : "排序值",
							name : "rank",
							value : 1
						}, {
							xtype : "textarea",
							fieldLabel : "备注",
							name : "remark"
						}, {
							xtype : "hidden",
							name : "id"
						}]
			});
			
	//用户选择窗体start
     
    var userGridTbar = Ext.create("Ext.toolbar.Toolbar", {
		items : [{
					text : "选择",
					iconCls : "Tick",
					handler : function() {
						var n = userPanel.getGrid().getSelectionModel().getSelection();
						if (n.length != 1) {
							Ext.Msg.alert(fn.INFO, "请选择唯一的用户。");
							return;
						}
						var record = n[0];
						userNameText.setValue(record.get('name'));
						if(record.get('roleIds')){
							roleIdsHidden.setValue(record.get('roleIds'));
						}else {
							
							roleIdsHidden.setValue("null");
						}
						roleGrid.getStore().loadPage(1);
						userChooseWin.hide();
					}
				},{
					text : "刷新",
					iconCls : "Arrowrefresh",
					handler : function() {
						userPanel.getGrid().getPagging().doRefresh();
					}
				}]
	});
	var userPanel = Ext.create('system.com.UserQueryPanel', {
		gridTbar : userGridTbar,
		width: width,
		height: height
	});
	userPanel.getGrid().addListener("celldblclick", function(a, td, cellIndex, record, tr, rowIndex, e, eOpts ) {
		userNameText.setValue(record.get('name'));
		if(record.get('roleIds')){
			roleIdsHidden.setValue(record.get('roleIds'));
		}else {
			
			roleIdsHidden.setValue("null");
		}
		roleGrid.getStore().loadPage(1);
		userChooseWin.hide();
	});
	var userChooseWin = Ext.create('Ext.window.Window', {
		
		title: '用户选择窗体[<font color = red>双击用户列表即可快速选择</font>]',
		border : false,
		modal : true,
	    frame : true,
	    plain : true,
	    width: width,
	    height:height,
	    layout: 'fit',
	    closeAction : 'hide',
		items:[userPanel]
	});
	
	//用户选择窗体end
	
	//人员分配窗体start
	var userAssignPanel = Ext.create("system.com.UserAssignPanel",{
	
		width: width,
		height: height
	});
	var userAssignWin = Ext.create('Ext.window.Window', {
		
		border : false,
		modal : true,
	    frame : true,
	    plain : true,
	    width: width,
	    height:height,
	    layout: 'fit',
	    closeAction : 'hide',
	    buttons : [{
					text : "确定",
					iconCls : "Tick",
					handler : function() {
						var p = userAssignPanel.getAssignPanel().getChoosed();
						
						var m = p.length;
						if (m == 0) {
							Ext.Msg.alert(fn.INFO, "您没有选中任何用户数据。");
							return;
						}
						
						Ext.Msg.confirm(fn.INFO, "未在已选列表中的用户，会删除其关联，确认关联选中的用户？", function(q) {
							if ("yes" == q) {
								userAssignPanel.getAssignPanel().getPanel2().getSelectionModel().selectAll();
								var o = [];
								for (var n = 0; n < m; n++) {
									o.push(p[n].get("id"));
								}
								Ext.Ajax.request({
											url : "auth/saveUserRole.action",
											waitMsg : "正在保存用户与角色的关联，请稍后...",
											params : {
												roleId : roleGrid.getSelectionModel().getSelection()[0].get("id"),
												userIds : o
											},
											success : function(s) {
												Ext.Msg.hide();
												userAssignWin.hide();
												Ext.Msg.showTop("用户与角色已经成功关联。");
											}
										});
							}
						});
					}
				}, {
					text : "取消",
					iconCls : "Cancel",
					handler : function() {
						var v = userAssignPanel.getAssignPanel().getChoosed();
						if (v.length == 0) {
							Ext.Msg.confirm(fn.INFO, "已选用户列表并没有数据，确认关闭吗？",
									function(w) {
										if ("yes" == w) {
											userAssignWin.hide();
										}
									});
							return;
						}
						userAssignWin.hide();
					}
				}],
		items:[userAssignPanel]
	});
	//人员分配窗体end
	var orgTree = Ext.create("system.com.CommonTree", {
				
				url : "org/getOrg.action",
				rootId : "root",
				rootText : orgRootText,
				model : "system.model.Org",
				rootVisible : true
			});
	orgTree.addListener("itemclick", function(h, k, o, l) {
		roleGrid.getStore().loadPage(1);
	});
	var treeTbar = 	Ext.create("Ext.toolbar.Toolbar", {
						items : [{
							text : "本机构",
							iconCls : "Usergo",
							handler : function() {
								orgTree.getStore().on("beforeload",
										function() {
											Ext.apply(
															orgTree.getStore().proxy.extraParams,
															{
																id : orgTree.getConfig().firstOrgid || fn.base.org.id
															});
										});
								orgTree.getStore().load();
							}
						},'-', {
							text : "所有",
							iconCls : "Groupgo",
							handler : function() {
								orgTree.getStore().on("beforeload",
										function() {
											Ext
													.apply(
															orgTree
																	.getStore().proxy.extraParams,
															{
																id : "root"
															});
										});
								orgTree.getStore().load();
							}
						}]
					});	
	
	var treePanel = Ext.create("Ext.Panel",{
		tbar : treeTbar,
		title : '组织机构',
		region : "west",
		width:240,
		height:height,
		frame : false,
		border : true,
		split : true,
		plain : false,
		padding : 0,
		layout : "fit",
		items:orgTree
	});
	orgTree.getRootNode().expand(false, function(e) {
					orgTree.getRootNode().expand();
				}, this);
	var saveAuth = function(p, o) {
		var m = p.length;
		if (m == 0) {
			Ext.Msg.showTop("没有可保存的数据。");
			return;
		}
		var n = roleGrid.getSelectionModel().getSelection();
		if (n.length != 1) {
			Ext.Msg.alert("提示", "请选择唯一的角色。");
			return;
		}
		Ext.Msg.confirm(fn.INFO, "确认对角色[<font color=red>" + n[0].get("name") + "</font>]保存系统权限？",
				function(s) {
					if ("yes" == s) {
						var q = [];
						for (var r = 0; r < m; r++) {
							q.push({
										id : p[r].get("id"),
										check : p[r].get("check")
									});
						}
						Ext.Ajax.request({
									url : "auth/saveAuth.action",
									waitMsg : "正在保存菜单及权限，请稍后...",
									params : {
										roleId : n[0].get("id"),
										auths : Ext.encode(q)
									},
									success : function() {
										Ext.Msg.hide();
										Ext.Msg.showTop("保存系统权限菜单成功。");
										l.getStore().load();
									}
								});
					}
				});
	};
	var roleNameText = Ext.create("Ext.form.field.Text", {
				fieldLabel : '角色名',
				labelAlign : 'right',
				labelWidth : 50,
				text : 60
			});
	var userNameText = Ext.create("Ext.form.field.Text", {
				fieldLabel : '用户',
				labelAlign : 'right',
				labelWidth : 40,
				text : 60,
				editable : false,
				listeners : {
					focus : function() {
						userChooseWin.show();
						userPanel.getGrid().getStore().loadPage(1);
					}
				}
			});
	var roleIdsHidden = Ext.create("Ext.form.field.Hidden");
	var roleGrid = Ext.create("system.com.CommonGrid", {
		frame : false,
		border : true,
		region : "center",
		model : "system.model.Role",
		pageSize : 20,
		title : "角色列表",
		autoLoad : false,
		url : "auth/getRole.action",
		columns : [{
					text : "序号",
					xtype : "rownumberer",
					width : 35,
					align : "center"
				}, {
					text : "角色名",
					dataIndex : "name"
				}, {
					text : "备注",
					dataIndex : "remark"
				}, {
					text : "组织机构",
					dataIndex : "orgNames"
				}],
		dockedItems : [{
					xtype : "toolbar",
					dock : "top",
					items : [roleNameText,userNameText, {
								text : "查询",
								iconCls : "Magnifier",
								handler : function() {
									roleGrid.getStore().loadPage(1);
								}
							}, {
								text : "重置",
								iconCls : "Cancel",
								handler : function() {
									orgTree.getSelectionModel().deselectAll();
									roleIdsHidden.reset();
									roleNameText.reset();
									userNameText.reset();
								}
							}]
				}, {
					xtype : "toolbar",
					dock : "top",
					items : [{
								text : "新增",
								iconCls : "Applicationadd",
								handler : function() {
									var m = orgTree.getSelectionModel()
											.getSelection();
									if (m.length == 1) {
										a.setParams({
													orgIds : m[0].get("id")
												});
									}
									a.getFormPanel().getForm().reset();
									a.show();
								}
							}, {
								text : "修改",
								iconCls : "Applicationedit",
								handler : function() {
									var m = roleGrid.getSelectionModel()
											.getSelection();
									if (m.length != 1) {
										Ext.Msg.showTop("请选中唯一的角色修改。");
										return;
									}
									a.loadRecord(m[0]);
									a.getFormPanel().getForm().findField('orgIds').setDefaultValue(m[0].data.orgIds,m[0].data.orgNames);
									a.show();
								}
							}, {
								text : "删除",
								iconCls : "Applicationdelete",
								handler : function() {
						
									var j = roleGrid.getSelectionModel().getSelection();
									var len = j.length;
									if (len == 0) {
										Ext.Msg.showTop("请选择角色进行删除。");
										return;
									}
									
									var ids = [];
									//根节点不能删除
									for(i=0;i<len;i++){
									
										ids.push(j[i].get("id"));
									}
									
									Ext.Msg.confirm(fn.INFO, "确定删除选中的菜单吗？</br>[注：<font color=red>删除角色的同时将删除其关联的用户角色、组织角色、角色权限关系</font>]", function(a) {
										if ("yes" == a) {
											
											Ext.Ajax.request({
												waitMsg : "正在删除...",
												url : "auth/delRole.action",
												method : 'POST',
												params : {
													roleIds:ids
												},
												success : function(response) {
													Ext.Msg.hide();
													Ext.Msg.showTop("删除成功。");
													roleGrid.getPagging().doRefresh();
												}
											});
										}
									});
									
								}
							}, {
								text : "刷新",
								iconCls : "Arrowrefresh",
								handler : function() {
									roleGrid.getPagging().doRefresh();
								}
							}, "-", {
								text : "人员分配",
								iconCls : "Useredit",
								handler : function() {
									var m = roleGrid.getSelectionModel()
											.getSelection();
									if (m.length != 1) {
										Ext.Msg.showTop("请选择唯一的角色进行分配。");
										return;
									}
									
									Ext.Ajax.request({
												waitMsg : "正在初始化人员信息，请稍后...",
												url : "auth/getUserRole.action",
												params : {
													roleId : m[0].get("id")
												},
												success : function(o) {
													Ext.Msg.hide();
													var n = Ext.decode(o.responseText);
													
													userAssignPanel.getAssignPanel().getPanel1().getStore().loadPage(1);
													userAssignPanel.reset();
													userAssignPanel.setInitData(n);
													userAssignWin.setTitle('正在为角色[<font color=red>'+m[0].data.name+'</font>]分配人员');
													userAssignWin.show();
												}
											});
								}
							}]
				}],
		listeners : {
			beforecellmousedown : function(u, m, s, n, r, t, o, p) {//记录前一个选择的角色
				if(n){
					var a = roleGrid.getSelectionModel().getSelection();
					if(a.length != 0){
						frontRole = a;
					}
					//alert(a.length);
				}
			},
			cellclick : function(u, m, s, n, r, t, o, p) {
				if (roleGrid.chooseRoleId) {
					if (roleGrid.chooseRoleId == n.data.id) {
						return;
					}
				}
				var q = function() {
					roleGrid.chooseRoleId = n.data.id;
					e = {};
					l.getStore().load(l.getRootNode());
				};
				var v = l.getStore().getModifiedRecords();
				if (v.length > 0) {
					Ext.Msg.confirm("提示", "检测到您有数据没有保存，是否保存？", function(w) {
								if ("yes" == w) {
									roleGrid.getSelectionModel().select(frontRole[0]);
									saveAuth(v, function(x) {
												q();
											});
								} else {
									frontRole = null;
									q();
								}
							});
					return;
				}else {
					frontRole = null;
				}
				q();
			}
		}
	});
	roleGrid.getStore().on("beforeload", function() {
		Ext.apply(roleGrid.getStore().proxy.extraParams, {
					roleIds : roleIdsHidden.getValue(),
					name : roleNameText.getValue(),
					orgIds : orgTree.getSelectionModel().getSelection().length == 0
							? ""
							: orgTree.getSelectionModel().getSelection()[0].get("id") == "root" ? "":orgTree.getSelectionModel().getSelection()[0].get("id")
				});
	});
	roleGrid.getStore().load();
	var e = {};
	var l = Ext.create("system.com.CommonTree", {
		tbar : Ext.create("Ext.toolbar.Toolbar", {
					items : [{
								text : "保存",
								iconCls : "Disk",
								handler : function() {
									var m = l.getStore().getModifiedRecords();
									saveAuth(m, function() {
												l.getStore().load();
											});
								}
							}, {
								text : "刷新",
								iconCls : "Arrowrefresh",
								handler : function() {
									l.getStore().load();
								}
							}]
				}),
		title : "权限树",
		region : "east",
		width : 360,
		url : "auth/getAuth.action",
		rootId : "root",
		rootText : fn.base.systemTitle,
		model : "system.model.Menu",
		rootVisible : true,
		frame : false,
		border : true,
		plant : true,
		columns : [{
					xtype : "treecolumn",
					text : "菜单名称",
					flex : 2,
					dataIndex : "name",
					align : "left"
				}, {
					text : "类型",
					flex : 1,
					dataIndex : "type",
					renderer : function(i) {
						return fn.tools.viewName(menuTypeDict, i, "根节点");
					}
				}],
		viewConfig : {
			onCheckboxChange : function(u, w) {
				var v = u.getTarget(this.getItemSelector(), this.getTargetEl()), r;
				if (v) {
					r = this.getRecord(v);
					var m = !r.get("checked");
					r.set("checked", m);
					if (!e["E" + r.data.id]) {
						r.on("expand", function(n) {
									n.cascadeBy(function(t) {
												t.set("check", n.data.check);
												t.set("checked", n.data.check);
											});
									n.expandChildren();
								});
						e["E" + r.data.id] = true;
					}
					r.expandChildren();
					r.expand();
					if (m) {
						r.bubble(function(n) {
									if (n.data.id == "root") {
										return;
									}
									n.set("check", true);
									n.set("checked", true);
								});
						r.cascadeBy(function(n) {
									n.set("check", true);
									n.set("checked", true);
								});
					} else {
						r.cascadeBy(function(n) {
									n.set("check", false);
									n.set("checked", false);
								});
						var p = r.parentNode.childNodes;
						var s = p.length;
						if (s <= 1) {
							return;
						}
						for (var q = 0; q < s; q++) {
							var o = p[q];
							if (o.data.id == r.data.id) {
								continue;
							}
							if (o.data.checked) {
								return;
							}
						}
						r.bubble(function(n) {
									if (n.data.id == "root") {
										return;
									}
									n.set("check", false);
									n.set("checked", false);
								});
					}
				}
			}
		},
		listeners : {
			beforeload : function(m, o) {
				var n = roleGrid.getSelectionModel().getSelection();
				if (n.length != 1) {
					Ext.Msg.showTop("查询权限树必须选中一个唯一的角色。");
					return false;
				}
				Ext.apply(l.getStore().proxy.extraParams, {
							roleId : n[0].get("id")
						});
			}
		}
	});
	l.getTbar().add("-");
	l.getTbar().add(l.getExpandAllBtn());
	l.getTbar().add(l.getCollapseAllBtn());
	l.getStore().on("load", function() {
				l.getRootNode().expand();
			});
	var d = Ext.create("Ext.Panel", {
				renderTo : divid,
				layout : "border",
				frame : false,
				border : false,
				height : height,
				items : [treePanel, roleGrid, l]
			});
});
tabPanel.setLoading(false); 