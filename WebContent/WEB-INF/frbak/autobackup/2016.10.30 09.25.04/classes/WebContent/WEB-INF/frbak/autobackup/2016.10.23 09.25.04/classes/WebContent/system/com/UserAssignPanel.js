Ext.define("system.com.UserAssignPanel", {
	extend : "Ext.Panel",
	xtype : "userAssignPanel",
	border : false,
	constructor : function(params) {
		var f = this;
		params = params || {};
		fn.imports("system.constants.User_Constants");
		fn.imports("system.constants.Org_Constants");
		var c = fn.getDictStore(User_Constants.USER_STATE, "int");
		var orgRootText = fn.getDictValue(Org_Constants.ORG_DICT_ORGROOT);
		var o = document.body.clientWidth * 0.8;
		var l = document.body.clientHeight * 0.9;
		var m = 220;
		
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
			width:m,
			height:params.height,
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
		
		var userGridColumns = function() {
		return [ {
					text : "学工号",
					dataIndex : "stuempNo"
				}, {
					text : "姓名",
					dataIndex : "name"
				}, {
					text : "组织部门",
					dataIndex : "orgName"
				}, {
					text : "状态",
					dataIndex : "state",
					renderer : function(h) {
						return fn.tools.viewName(c, h);
					}
				}];
		};
		var userGrid = Ext.create("system.com.CommonGrid", {
			frame : false,
			border : true,
			autoLoad : false,
			width : o * 0.40,
			//isloadDeselect : false,//store加载后是否取消选择,默认true
			padding : 0,
			region : "west",
			model : 'system.model.User',
			url : 'user/getUser.action',
			pageSize : 20,
			title : '待选用户',
			columns : userGridColumns()
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
		var userGrid2 = Ext.create("system.com.CommonGrid", {
				frame : false,
				border : true,
				split : true,
				plain : false,
				region : "center",
				model : "system.model.User",
				url : 'user/getUser.action',
				title : "已选用户",
				autoLoad : false,
				columns : userGridColumns()
		});
		userGrid2.getPagging().hide();
		
		var AssignContent = {
			region : "center",
			model : "system.model.User",
			cdPanel : userGrid,
			chPanel : userGrid2
		};
		var up = Ext.create("system.com.CommonAssignPanel", AssignContent);
		params.layout = 'border';
		params.items = [queryForm, {
					frame : false,
					border : false,
					plain : true,
					layout : "border",
					region : "center",
					items : [treePanel, up]
				}];
		this.getAssignPanel = function(){
			return up;
		};
		this.setInitData = function(v){
			up.setInitData(v);
		};
		this.reset = function() {
//			up.getPanel1().getSelectionModel().deselectAll();
			up.getPanel2().getStore().removeAll();
		};
		this.getConfig = function() {
			return params;
		};
		this.callParent(arguments);
	},
	initComponent : function() {
		this.callParent(arguments);
	}
});