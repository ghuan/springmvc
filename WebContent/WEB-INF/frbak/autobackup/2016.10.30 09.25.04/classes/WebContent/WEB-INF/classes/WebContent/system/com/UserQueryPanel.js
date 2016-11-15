Ext.define("system.com.UserQueryPanel", {
	extend : "Ext.Panel",
	xtype : "userQueryPanel",
	border : false,
	constructor : function(c) {
		var f = this;
		c = c || {};
		fn.imports("system.constants.User_Constants");
		fn.imports("system.constants.Org_Constants");
		var j = fn.getDictStore(User_Constants.USER_SEX, "int");
		var b = fn.getDictStore(User_Constants.USER_STATE, "int");
		var orgRootText = fn.getDictValue(Org_Constants.ORG_DICT_ORGROOT);
		var orgTree = Ext.create("system.com.CommonTree", {
				
				url : "org/getOrg.action",
				rootId : "root",
				rootText : orgRootText,
				model : "system.model.Org",
				rootVisible : true
			});
		orgTree.addListener("itemclick", function(h, k, o, l) {
			
			if(queryForm.getForm().findField('orgId').getValue() != k.data.id){
				queryForm.getForm().findField('orgName').setValue(k.data.name);
				queryForm.getForm().findField('orgId').setValue(k.data.id);
				userGrid.getStore().loadPage(1);
			}
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
			height:c.height,
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
		var queryForm = Ext.create("system.com.CommonFormPanel", {
								collapsible : true,
								title : "查询条件",
								region : "north",
								split : true,
								frame : true,
								border : false,
								height : 100,
								autoScroll : true,
								buttonAlign : "center",
								margins : "0 0 0 0",
								cmargins : "0 0 0 0",
								items : [{
											fieldLabel : "姓名",
											name : "name"
										}, {
											fieldLabel : "学工号",
											name : "stuempNo"
										}, {
											fieldLabel : "组织部门",
											name : "orgName",
											disabled : true
										}, {
											xtype : 'hidden',
											name : "orgId"
										}],
								columnCount : 4,
								labelWidth : 60,
								buttons : [{
											text : "查询",
											iconCls : "Magnifier",
											handler : function() {
												userGrid.getStore().loadPage(1);
											}
										}, {
											text : "重置",
											iconCls : "Cancel",
											handler : function() {
												
												var g = this.up("form").getForm();
												g.reset();
												orgTree.getSelectionModel().deselectAll();
											}
										}]
							});	
							
		var userGrid = Ext.create("system.com.CommonGrid", {
			frame : false,
			border : true,
			autoLoad : false,
			//isloadDeselect : false,//store加载后是否取消选择,默认true
			padding : 0,
			tbar : c.gridTbar,
			region : "center",
			model : 'system.model.User',
			url : 'user/getUser.action',
			pageSize : 20,
			title : '用户列表',
			columns : [{
							text : "序号",
							xtype : "rownumberer",
							width : 35,
							align : "center"
						}, {
							text : "学工号",
							dataIndex : "stuempNo"
						}, {
							text : "姓名",
							dataIndex : "name"
						}, {
							text : "性别",
							dataIndex : "sex",
							renderer : function(h) {
								return fn.tools.viewName(j, h);
							}
						}, {
							text : "组织部门",
							dataIndex : "orgName"
						}, {
							text : "最后登录IP",
							dataIndex : "lastIp"
						}, {
							text : "最后登录时间",
							dataIndex : "lastTime"
						}, {
							text : "状态",
							dataIndex : "state",
							renderer : function(h) {
								return fn.tools.viewName(b, h);
							}
						}]
		});
		
		//数据集查询之前
	    userGrid.getStore().on('beforeload', function() {
	    	
		 	Ext.apply(userGrid.getStore().proxy.extraParams,{
		 			
		 		name : queryForm.getForm().findField("name").getValue(),
		 		stuempNo : queryForm.getForm().findField("stuempNo").getValue(),
		 		orgId : queryForm.getForm().findField("orgId").getValue()
		 		}
		 	);
	     });
	    c.layout = 'border';
		c.items = [treePanel,queryForm,userGrid];
		this.getGrid = function(){
			return userGrid;
		}
		this.getConfig = function() {
			return c;
		};
		this.callParent(arguments);
	},
	initComponent : function() {
		this.callParent(arguments);
	}
});