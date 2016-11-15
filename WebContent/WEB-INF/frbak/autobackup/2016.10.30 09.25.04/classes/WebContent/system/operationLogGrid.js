Ext.define("system.operationLogGrid", {
	extend : "Ext.Panel",
	xtype : "operationLogGrid",
	border : false,
	autoScroll : false,
	frame : false,
	collapsible : false,
	forceFit : false,
	split : false,
	layout : "border",
	constructor : function(params) {
		params = params || {};

		var nowDate = new Date();
		var own = this;
		own.queryUserId = '';

		//查看窗体
		var showWin = Ext.create("system.com.CommonFormWindow", {
			title : "操作日志详情",
			width : 400,
			height : 370,
			labelWidth : 60,
			buttons : [],

			items : [{
				fieldLabel : "描述",
				name : "description"
			}, {
				fieldLabel : "位置",
				xtype : 'textarea',
				name : "method"
			}, {
				fieldLabel : "参数",
				xtype : 'textarea',
				name : "params"
			}, {
				fieldLabel : "操作IP",
				name : "requestIp"
			}, {
				fieldLabel : "操作用户",
				name : "createName"
			}, {
				fieldLabel : "操作时间",
				name : "createTime"
			}]
		});

		//用户选择窗体start

		var userGridTbar = Ext.create("Ext.toolbar.Toolbar", {
			items : [{
				text : "选择",
				iconCls : "Tick",
				handler : function() {
					var userNameText =  Ext.getCmp('userCheck');
					var n = userPanel.getGrid().getSelectionModel().getSelection();
					if (n.length != 1) {
						Ext.Msg.alert(fn.INFO, "请选择唯一的用户。");
						return;
					}
					var record = n[0];
					userNameText.setValue(record.get('name'));
					own.queryUserId = record.get('id');
					grid.getStore().loadPage(1);
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
			width: params.width,
			height: params.height
		});
		userPanel.getGrid().addListener("celldblclick", function(a, td, cellIndex, record, tr, rowIndex, e, eOpts ) {
			var userNameText =  Ext.getCmp('userCheck');
			userNameText.setValue(record.get('name'));
			own.queryUserId = record.get('id');
			grid.getStore().loadPage(1);
			userChooseWin.hide();
		});
		var userChooseWin = Ext.create('Ext.window.Window', {

			title: '用户选择窗体[<font color = red>双击用户列表即可快速选择</font>]',
			border : false,
			modal : true,
			frame : true,
			plain : true,
			width: params.width,
			height: params.height,
			layout: 'fit',
			closeAction : 'hide',
			items:[userPanel]
		});

		//用户选择窗体end

		//列表按钮栏
		var gridTbar = Ext.create("Ext.toolbar.Toolbar", {
			items : [{
				xtype : 'label',
				text : '用户：'
			},{
				xtype : 'textfield',
				width : 100,
				id : 'userCheck',
				editable : false,
				listeners : {
					focus : function() {
						userChooseWin.show();
						userPanel.getGrid().getStore().loadPage(1);
					}
				}
			},{
				xtype : 'label',
				text : '日期：'
			},{
				xtype:'datefield',
				format : 'Y-m-d',//日期格式
				width : 100,
				value : new Date(nowDate.getFullYear(),nowDate.getMonth(),1),
				id : 'startTime'
			},{
				xtype : 'label',
				text : '至'
			},{
				xtype:'datefield',
				format : 'Y-m-d',//日期格式
				value : nowDate,
				width : 100,
				id : 'endTime'
			},{
				text : "查询",
				iconCls : "Magnifier",
				handler : function() {
					grid.getPagging().doRefresh();
				}
			}, {
				text : "重置",
				iconCls : "Cancel",
				handler : function() {
					own.queryUserId = '';
					Ext.getCmp('userCheck').setValue('');
					Ext.getCmp('startTime').setValue(new Date(nowDate.getFullYear(),nowDate.getMonth(),1));
					Ext.getCmp('endTime').setValue(nowDate);
				}
			},'-', {
				text : "删除",
				iconCls : "Delete",
				handler : function() {
					fn.tools.grid.deletex(grid,'log/delete.action');
				}
			}]
		});
		//显示列表
		var grid = Ext.create("system.com.CommonGrid", {
			border : false,
			//autoLoad : false,
			//isloadDeselect : false,//store加载后是否取消选择,默认true
			padding : 0,
			tbar : gridTbar,
			region : "center",
			model : 'system.model.Log',
			url : 'log/getLogPage.action',
			pageSize : 20,
			title : '操作日志列表[<font color=red>双击单条数据查看详细</font>]',
			columns : [{
				text : "序号",
				xtype : "rownumberer",
				width : 35,
				align : "center"
			}, {
				text : "描述",
				dataIndex : "description"
			}, {
				text : "位置",
				dataIndex : "method"
			}, {
				text : "参数",
				dataIndex : "params"
			}, {
				text : "操作IP",
				dataIndex : "requestIp"
			}, {
				text : "操作用户",
				dataIndex : "createName"
			}, {
				text : "操作时间",
				dataIndex : "createTime"
			}]
		});

		//数据集查询之前
		grid.getStore().on('beforeload', function() {
			Ext.apply(grid.getStore().proxy.extraParams,{
					type : 0,
					startTime : Ext.getCmp('startTime').rawValue,
					endTime : Ext.getCmp('endTime').rawValue,
					userId : own.queryUserId ? own.queryUserId : ''
				}
			);
		});

		//双击监听
		grid.addListener("celldblclick", function(a, td, cellIndex, record, tr, rowIndex, e, eOpts ) {
			showWin.loadRecord(record);
			showWin.show();
		});

		params.items = grid;
		this.getGrid = function(){
			return grid;
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