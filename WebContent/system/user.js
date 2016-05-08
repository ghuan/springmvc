fn.imports("system.constants.User_Constants");
fn.imports("system.constants.Org_Constants");
fn.imports("system.com.CommonComboBoxTree");
Ext.onReady(function() {
	var j = fn.getDictStore(User_Constants.USER_SEX, "int");
	var b = fn.getDictStore(User_Constants.USER_STATE, "int");
	var orgRootText = fn.getDictValue(Org_Constants.ORG_DICT_ORGROOT);
	var divid = "user.viewUser";
	var height = document.getElementById(divid).offsetHeight;
	var width = document.getElementById(divid).offsetWidth;
	
	var a = Ext.create("system.com.CommonFormWindow", {
				title : "保存系统用户",
				url : "user/saveOrUpdate.action",
				height : 480,
				validate : function(a) {
					if (a.findField("orgId").getSubmitValue() == a.findField("orgId").rootId) {
						Ext.Msg.alert(fn.INFO, "不能选择组织根节点[<font color=red>"+orgRootText+"</font>]，请重新选择。");
						return false;
					}
					return true;
				},
				success : function(l, m) {
					a.hide();
					Ext.Msg.showTop("保存用户成功。");
					viewPanel.getGrid().getStore().load();
				},
				
				items : [{
							fieldLabel : "学工号",
							allowBlank : false,
							name : "stuempNo"
						}, {
							fieldLabel : "姓名",
							allowBlank : false,
							name : "name"
						}, {
							fieldLabel : "登录名",
							allowBlank : false,
							name : "loginName"
						}, {
							//基本属性设置
							xtype :'commoncomboboxtree',
							fieldLabel:'组织机构',
							name:'orgId',
							editable: true,							//是否可编辑，默认为false
							allowBlank : false,						//是否允许为空，默认为true
							
							//树的属性设置
							url : 'org/getOrg.action',				//treestore的url
							model:'system.model.Org',				//treestore的model
							expandAll : true,						//树初始化是否展开全部，默认为false
							rootId : 'root',						//treestore的root id，默认为root
							rootText : orgRootText,					//treestore的root name，默认为root
							rootVisible : true,						//是否显示根节点，默认为false
							displayField : 'name',					//显示值的映射,默认为text
							multiCascade:false,						//多选时是否级联选择，默认为true
							multiSelect : false,					//是否多选，默认false
							
							//树的模糊查询设置
							allowQuery : true						//是否允许模糊查询，默认为false
							//queryUrl : 'org/getOrgByPath.action'	//模糊查询url，前提allowQuery为true,不填默认为url的路径，默认传参名name，返回json串需包含path字段名，path值为'/'隔开的树节点id值
																	//如'/1/934c35317bf349b9abc5e743ff8ed034'
							
						}, {
							//基本属性设置
							xtype :'commoncomboboxtree',
							fieldLabel:'所属角色',
							name:'roleIds',
							editable: false,							
							//allowBlank : false,					
							
							//树的属性设置
							url : 'user/getRole.action',				
							model:'system.model.Role',				
							expandAll : true,					
							rootId : 'root',					
							rootText : '全部',					
							rootVisible : true,					
							displayField : 'name',				
							//multiCascade:true,				
							multiSelect : true,					//是否多选，默认false
							columns : [{
								text : "序号",
								xtype : "rownumberer",
								width : 35,
								align : "center"
							}, {
								xtype : "treecolumn",
								text : "名称",
								flex : 1,
								dataIndex : "name"
							}, {
								text : "组织机构",
								flex : 1,
								dataIndex : "orgNames"
							}],
							//树的模糊查询设置
							allowQuery : true						//是否允许模糊查询，默认为false
							//queryUrl : 'org/getOrgByPath.action'	//模糊查询url，前提allowQuery为true,不填默认为url的路径，默认传参名name，返回json串需包含path字段名，path值为'/'隔开的树节点id值
																	//如'/1/934c35317bf349b9abc5e743ff8ed034'
							
						}, {
							fieldLabel : "身份证",
							name : "idCard"
						}, {
							fieldLabel : "性别",
							name : "sex",
							xtype : "combobox",
							store : j,
							queryMode : "local",
							displayField : "text",
							valueField : "value",
							value : 1,
							editable : false
						}, {
							fieldLabel : "邮箱",
							name : "email"
						}, {
							fieldLabel : "移动电话",
							name : "mobile"
						}, {
							fieldLabel : "家庭电话",
							name : "home_phone"
						}, {
							fieldLabel : "办公室电话",
							name : "office_phone"
						}, {
							fieldLabel : "家庭住址",
							name : "home_address"
						}, {
							fieldLabel : "启用状态",
							xtype : "combobox",
							store : b,
							queryMode : "local",
							displayField : "text",
							valueField : "value",
							value : 1,
							name : "state",
							editable : false
						}, {
							xtype : "numberfield",
							fieldLabel : "排序值",
							name : "rank",
							value : 1
						}, {
							xtype : "hidden",
							name : "id"
						}, {
							xtype : "hidden",
							name : "password"
						}, {
							xtype : "hidden",
							name : "professional"
						}, {
							xtype : "hidden",
							name : "image"
						}, {
							xtype : "hidden",
							name : "creator",
							value : fn.base.user.id
						}, {
							xtype : "hidden",
							name : "createTime"
						}, {
							xtype : "hidden",
							name : "lastIp"
						}, {
							xtype : "hidden",
							name : "lastTime"
						}]
			});
	var userGridTbar = Ext.create("Ext.toolbar.Toolbar", {
		items : [{
					text : "新增",
					iconCls : "Applicationadd",
					handler : function() {
						a.getFormPanel().getForm().reset();
						a.getFormPanel().getForm().findField('orgId').clearValue();
						a.getFormPanel().getForm().findField('roleIds').clearValue();
						a.show();
					}
				}, {
					text : "修改",
					iconCls : "Applicationedit",
					handler : function() {
						var l = viewPanel.getGrid().getSelectionModel().getSelection();
						if (l.length != 1) {
							Ext.Msg.showTop("请选择唯一的用户进行修改。");
							return;
						}
						a.loadRecord(l[0]);
						a.getFormPanel().getForm().findField('orgId').setDefaultValue(l[0].data.orgId,l[0].data.orgName);
						a.getFormPanel().getForm().findField('roleIds').setDefaultValue(l[0].data.roleIds,l[0].data.roleNames);
						a.show();
					}
				}, {
					text : "删除",
					iconCls : "Applicationdelete",
					handler : function() {

						var j = viewPanel.getGrid().getSelectionModel().getSelection();
						var len = j.length;
						if (len == 0) {
							Ext.Msg.showTop("请选择数据进行删除。");
							return;
						}

						var ids = [];
						for (i = 0; i < len; i++) {

							ids.push(j[i].get("id"));
						}

						Ext.Msg.confirm(fn.INFO, "确定删除选中的数据吗？", function(a) {
							if ("yes" == a) {

								Ext.Ajax.request({
											waitMsg : "正在删除...",
											url : "user/delete.action",
											method : 'POST',
											params : {
												ids : ids
											},
											success : function(response) {
												Ext.Msg.hide();
												viewPanel.getGrid().getStore().load();
											}
										});
							}
						});
					}
				}, {
					text : "刷新",
					iconCls : "Arrowrefresh",
					handler : function() {
						viewPanel.getGrid().getPagging().doRefresh();
					}
				}]
	});
	var viewPanel = Ext.create('system.com.UserQueryPanel', {
		
		gridTbar : userGridTbar,
		width: '100%',
		height: height,
		renderTo : "user.viewUser"
	});
	viewPanel.getGrid().getStore().loadPage(1);
});
tabPanel.setLoading(false);