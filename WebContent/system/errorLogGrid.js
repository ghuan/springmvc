Ext.define("system.errorLogGrid", {
	extend : "Ext.Panel",
	xtype : "errorLogGrid",
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
			title : "异常日志详情",
			width : 500,
			height : 520,
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
				fieldLabel : "异常代码",
				name : "exceptionCode"
			}, {
				fieldLabel : "异常描述",
				xtype : 'textarea',
				name : "exceptionDetail"
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
					var userNameText =  Ext.getCmp('userCheck1');
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
			var userNameText =  Ext.getCmp('userCheck1');
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
				id : 'userCheck1',
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
				id : 'startTime1'
			},{
				xtype : 'label',
				text : '至'
			},{
				xtype:'datefield',
				format : 'Y-m-d',//日期格式
				value : nowDate,
				width : 100,
				id : 'endTime1'
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
					Ext.getCmp('userCheck1').setValue('');
					Ext.getCmp('startTime1').setValue(new Date(nowDate.getFullYear(),nowDate.getMonth(),1));
					Ext.getCmp('endTime1').setValue(nowDate);
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
			title : '异常日志列表[<font color=red>双击单条数据查看详细</font>]',
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
					type : 1,
					startTime : Ext.getCmp('startTime1').rawValue,
					endTime : Ext.getCmp('endTime1').rawValue,
					userId : own.queryUserId ? own.queryUserId : ''
				}
			);
		});

		//双击监听
		grid.addListener("celldblclick", function(a, td, cellIndex, record, tr, rowIndex, e, eOpts ) {

				Ext.Ajax.request({
					url : "log/getExceptionDetail.action",
					method : 'POST',
					params: {
						id : record.get('id')
					},
					success : function(r) {
						showWin.loadRecord(record);
						showWin.getFormPanel().getForm().findField('exceptionDetail').setValue(r.responseText);
						showWin.show();
					}
				});
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