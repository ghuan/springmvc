fn.imports("system.constants.User_Constants");
Ext.onReady(function() {

	var divid = "log.viewLog";
	var height = document.getElementById(divid).offsetHeight;
	var width = document.getElementById(divid).offsetWidth;

	var userSexDict = fn.getDictStore(User_Constants.USER_SEX, "int");

	//保存窗体
	var saveOrUpdateWin = Ext.create("system.com.CommonFormWindow", {
		title : "保存员工基本信息",
		url : "personnelJbxxMng/saveOrUpdate.action",
		width : 300,
		height : 280,
		labelWidth : 50,
//				validate : function(a) {
//					if (a.findField("orgId").getSubmitValue() == a.findField("orgId").rootId) {
//						Ext.Msg.alert(fn.INFO, "不能选择组织根节点[<font color=red>"+orgRootText+"</font>]，请重新选择。");
//						return false;
//					}
//					return true;
//				},
		success : function(l, m) {
			saveOrUpdateWin.hide();
			Ext.Msg.showTop("保存成功。");
			grid.getStore().load();
		},

		items : [{
			fieldLabel : "姓名",
			allowBlank : false,
			name : "name"
		}, {
			fieldLabel : "性别",
			name : "sex",
			xtype : "combobox",
			store : userSexDict,
			queryMode : "local",
			displayField : "text",
			valueField : "value",
			value : 1,
			editable : false
		}, {
			fieldLabel : "身份证",
			name : "idCard"
		}, {
			xtype:'datefield',
			format : 'Y-m-d',//日期格式
			fieldLabel : "生日",
			value : '1990-07-23',
			name : "birthday"
		}, {
			fieldLabel : "地址",
			name : "address"
		}, {
			fieldLabel : "电话",
			name : "phone"
		}, {
			xtype : "hidden",
			name : "id"
		}]
	});

	//更新导入模板窗体
	var updateTempWin = Ext.create("system.com.CommonFormWindow", {
		title : "更新导入模板",
		url : "personnelJbxxMng/updateTemplate.action",
		width : 350,
		height : 100,
		labelWidth : 60,
		validate : function(a) {
			if(!fn.tools.checkFileExt(updateTempWin.findField("file").getValue(),/.xls/i))
			{
				Ext.Msg.alert(fn.INFO, '请上传excel文件');
				return false;
			}
			return true;
		},
		success : function(l, m) {
			updateTempWin.hide();
			Ext.Msg.showTop("保存成功。");
		},

		items : [{
			fieldLabel : "导入模板",
			xtype : 'filefield',
			buttonText : '选择',
			allowBlank : false,
			name : "file"
		}]
	});

	//导入窗体
	var importTempWin = Ext.create("system.com.CommonFormWindow", {
		title : "导入",
		url : "personnelJbxxMng/importTemplate.action",
		width : 350,
		height : 100,
		labelWidth : 60,
		validate : function(a) {
			if(!fn.tools.checkFileExt(importTempWin.findField("file").getValue(),/.xls/i))
			{
				Ext.Msg.alert(fn.INFO, '请上传excel文件');
				return false;
			}
			return true;
		},
		success : function(l, m) {
			importTempWin.hide();
			grid.getPagging().doRefresh();
			Ext.Msg.confirm(fn.INFO, m.response.responseText,function(btn){
				if('yes' == btn){
					window.open('personnelJbxxMng/downloadTemplate.action');
				}
			});
		},

		items : [{
			fieldLabel : "excel",
			xtype : 'filefield',
			buttonText : '选择',
			allowBlank : false,
			name : "file"
		}],
		buttons : [
			{
				text : "导入",
				iconCls : "Diskdownload",
				handler : function() {
					this.up("window").submit();
				}
			}, {
				text : "关闭",
				iconCls : "Cancel",
				handler : function() {
					this.up("window").hide();
				}
			}]
	});

	//store的数据模型
	Ext.create('Ext.data.Store', {

		storeId:'simpsonsStore',
		model : 'subsystem.gsgl.personnel.jbxx.model.Personnel'
	});
	//批量保存或更新panel
	var saveOrUpdatexPanel = Ext.create('Ext.grid.Panel', {

		store: Ext.data.StoreManager.lookup('simpsonsStore'),
		autoScroll : true,
		frame : false,
		forceFit: true,
		border: false,
		split: false,
		selType:'checkboxmodel',//设定选择模式
		enableKeyNav:true,//允许使用键盘上下键选择
		multiSelect: true,
		columns: [{
			text : "序号",
			xtype : "rownumberer",
			width : 35,
			align : "center"
		}, {
			text : "姓名",
			field: {xtype: 'textfield',emptyText :'请填写姓名',allowBlank: false},
			dataIndex : "name"
		}, {
			text : "性别",
			dataIndex : "sex",
			width:50,
			editor: new Ext.form.ComboBox({

				store:userSexDict,
				queryMode: 'local',
				displayField: 'text',
				valueField: 'value',
				editable:false,
				emptyText:'---请选择---'
			}),
			renderer : function(v) {
				return fn.tools.viewName(userSexDict, v);
			}
		}, {
			text : "身份证号",
			field: {xtype: 'textfield',emptyText :'请填写身份证号',allowBlank: false},
			dataIndex : "idCard"
		}, {
			text : "生日",
			field: {xtype: 'datefield',format : 'Y-m-d',emptyText :'请选择日期',allowBlank: false},
			dataIndex : "birthday",
			renderer : function(v) {
				return Ext.util.Format.date(v,'Y-m-d');
			}
		}, {
			text : "地址",
			field: {xtype: 'textfield',emptyText :'请填写地址',allowBlank: false},
			dataIndex : "address"
		}, {
			text : "电话",
			field: {xtype: 'textfield',emptyText :'请填写电话',allowBlank: false},
			dataIndex : "phone"
		}
		],
		tbar:[{xtype:'button',text:'添加',iconCls:'Add',handler:function(){

			var modelObj = {
				id : '',
				name: '',
				sex: 1,
				idCard : '',
				birthday:'',
				address: '',
				phone: ''
			};

			var myPanel = this.ownerCt.ownerCt;
			myPanel.getStore().insert(0,modelObj);
			myPanel.getSelectionModel().selectByPosition({"row":0,"column":3});
			myPanel.view.refresh();
		}},{xtype:'button',text:'删除',iconCls:'Delete',handler:function(){
			var myPanel = this.ownerCt.ownerCt;
			var recs = myPanel.getSelectionModel().getSelection();

			if(recs.length == 0){

				Ext.Msg.alert(fn.INFO,'请选择要删除的数据！');
				return;
			}else{

				Ext.Msg.confirm(fn.INFO,'<center>您确定要删除所选信息吗？</br>[<font color=red>注：此操作不会对数据进行删除</font>]</center>',function(btn){

					if('yes' == btn){

						//如果有被选中的数据则删除该行
						for(var i = 0,len = recs.length;i<len;i++ ){
							myPanel.getStore().remove(recs[i],true);
							myPanel.getView().refresh();
						}
					}
				});

			}
		}}
		],
		bbar:['->',
			{xtype:'button',text:'保存',iconCls:'Disk',handler:function(){

				var myPanel = this.ownerCt.ownerCt;
				myPanel.getView().refresh();
				myPanel.getSelectionModel().selectAll();//全选;
				var recs = myPanel.getSelectionModel().getSelection();

				if(recs.length == 0 ){

					Ext.Msg.alert(fn.INFO,'数据为空！请添加数据！');
					return;
				}else{


					for(var i = 0; i< recs.length; i++){

						if(recs[i].data.name == ''){

							Ext.Msg.alert('提示',"有姓名为空的项！请填写！");
							return;
						}
						//提交的date为日期类型，需要转成string
						myPanel.getSelectionModel().getSelection()[i].data.birthday = Ext.util.Format.date(recs[i].data.birthday,'Y-m-d');
					}
					Ext.Msg.confirm(fn.INFO, "确认保存选中的数据？", function(k) {
						if ("yes" == k) {

							fn.tools.grid.saveOrUpdatex(myPanel,'personnelJbxxMng/saveOrUpdateBatch.action',function(){
								Ext.Msg.showTop("保存成功。");
								Ext.Msg.hide();
								saveOrUpdatexWin.hide();
								grid.getPagging().doRefresh();
							});
						}
					});

				}

			}},{xtype:'button',text:'关闭',iconCls:'Cancel',handler:function(){

				saveOrUpdatexWin.hide();
			}},
			'->'],

		plugins: [
			Ext.create('Ext.grid.plugin.CellEditing', {
				clicksToEdit: 1
			})
		]
	});

	//批量新增修改窗体-window
	var saveOrUpdatexWin = Ext.create('Ext.window.Window', {

		title: '批量保存员工信息',
		width: 800,
		height: 500,
		modal : true,
		frame : true,
		plain : true,
		layout: 'fit',
		closeAction : 'hide',
		items:[saveOrUpdatexPanel]
	});

	//查询条件
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
		}],
		columnCount : 4,
		labelWidth : 60,
		buttons : [{
			text : "查询",
			iconCls : "Magnifier",
			handler : function() {
				grid.getStore().loadPage(1);
			}
		}, {
			text : "重置",
			iconCls : "Cancel",
			handler : function() {

				var g = this.up("form").getForm();
				g.reset();
			}
		}]
	});

	//列表按钮栏
	var gridTbar = Ext.create("Ext.toolbar.Toolbar", {
		items : [{
			text : "新增",
			iconCls : "Add",
			handler : function() {
				saveOrUpdateWin.getFormPanel().getForm().reset();
				saveOrUpdateWin.show();
			}
		}, {
			text : "修改",
			iconCls : "Diskedit",
			handler : function() {
				var l = grid.getSelectionModel().getSelection();
				if (l.length != 1) {
					Ext.Msg.showTop("请选择唯一的员工记录进行修改。");
					return;
				}
				saveOrUpdateWin.loadRecord(l[0]);
				saveOrUpdateWin.show();
			}
		}, {
			text : "删除",
			iconCls : "Delete",
			handler : function() {
				fn.tools.grid.deletex(grid,'personnelJbxxMng/delete.action');
			}
		},{
			text : "批量新增",
			iconCls : "Applicationadd",
			handler : function() {
				saveOrUpdatexPanel.getStore().removeAll();
				saveOrUpdatexWin.show();
			}
		},{
			text : "批量修改",
			iconCls : "Applicationedit",
			handler : function() {
				var recs = grid.getSelectionModel().getSelection();
				if(recs.length > 0){
					saveOrUpdatexWin.show();
					var myPanel = saveOrUpdatexPanel;
					myPanel.getStore().removeAll();
					for(var i = 0; i < recs.length; i++){
						var modelObj = {
							id:recs[i].data.id,
							name: recs[i].data.name,
							sex: recs[i].data.sex,
							idCard:recs[i].data.idCard,
							birthday:recs[i].data.birthday,
							address:recs[i].data.address,
							phone:recs[i].data.phone
						};

						myPanel.getStore().insert(0,modelObj);
						myPanel.getSelectionModel().selectByPosition({"row":0,"column":3});
						myPanel.view.refresh();
					}
				}else{
					Ext.Msg.showTop("请选择需要修改的信息！");
				}
			}
		},{

			text : 'Excel',
			iconCls : 'Pagewhiteexcel',
			menu: {
				xtype: 'menu',
				plain: true,
				items: [
					{
						xtype: 'panel',
						items:[{
							xtype: 'buttongroup',
							title: '请选择操作',
							defaults: {
								xtype: 'button',
								iconAlign: 'left',
								width: 80
							},
							items: [{
								text: '更新模板',
								iconCls: 'Diskedit',
								handler:function(){
									updateTempWin.getFormPanel().getForm().reset();;
									updateTempWin.show();
								}
							},{
								text: '下载模板',
								iconCls: 'Arrowdown',
								handler:function(){
									window.open('personnelJbxxMng/downloadTemplate.action');
								}
							}]
						},{
							xtype: 'buttongroup',
							defaults: {
								xtype: 'button',
								iconAlign: 'left',
								textAlign : 'left',
								width: 80
							},
							items: [{
								text: '导入数据',
								iconCls: 'Diskdownload',
								handler:function(){

									importTempWin.getFormPanel().getForm().reset();;
									importTempWin.show();
								}
							},{
								text: '导出数据',
								iconCls: 'Diskupload',
								handler:function(){

									Ext.Msg.confirm(fn.INFO, "是否导出当前查询条件下的所有的数据？", function(k) {
										if ("yes" == k) {

											Ext.Ajax.request({
												url : "personnelJbxxMng/exportTemplate.action",
												waitMsg : "正在导出数据，请稍后...",
												params : {
													name : queryForm.getForm().findField("name").getValue()
												},
												success : function(s) {
													Ext.Msg.hide();
													Ext.Msg.alert(fn.INFO,"导出成功，请下载导出结果文件。",function(){

														fn.downloadLocalFile('download/exportResult.xlsx', 'result');
													});
												}
											});
										}
									});
								}
							}]
						}]
					}]
			}
		},'-', {
			text : "刷新",
			iconCls : "Arrowrefresh",
			handler : function() {
				grid.getPagging().doRefresh();
			}
		}]
	});
	//显示列表
	var grid = Ext.create("system.com.CommonGrid", {
		frame : true,
		border : false,
		//autoLoad : false,
		//isloadDeselect : false,//store加载后是否取消选择,默认true
		padding : 0,
		tbar : gridTbar,
		region : "center",
		model : 'subsystem.gsgl.personnel.jbxx.model.Personnel',
		url : 'personnelJbxxMng/getPersonnelPage.action',
		pageSize : 20,
		title : '员工列表[<font color=red>双击单条数据可进行修改</font>]',
		listeners : {

			celldblclick : function( a, td, cellIndex, record, tr, rowIndex, e, eOpts ){
				grid.columns[2].field.setValue(record.data.sex);
			}
		},
		columns : [{
			text : "序号",
			xtype : "rownumberer",
			width : 35,
			align : "center"
		}, {
			text : "姓名",
			field: {xtype: 'textfield',emptyText :'请填写姓名',allowBlank: false},
			dataIndex : "name"
		}, {
			text : "性别",
			dataIndex : "sex",
			width:50,
			editor: new Ext.form.ComboBox({
				store:userSexDict,
				queryMode: 'local',
				displayField: 'text',
				valueField: 'value',
				editable:false,
				emptyText:'---请选择---'
			}),
			renderer : function(v) {
				return fn.tools.viewName(userSexDict, v);
			}
		}, {
			text : "身份证号",
			field: {xtype: 'textfield',emptyText :'请填写身份证号',allowBlank: false},
			dataIndex : "idCard"
		}, {
			text : "生日",
			field: {xtype: 'datefield',format : 'Y-m-d',emptyText :'请选择日期',allowBlank: false},
			dataIndex : "birthday",
			renderer : function(v) {
				return Ext.util.Format.date(v,'Y-m-d');
			}
		}, {
			text : "地址",
			field: {xtype: 'textfield',emptyText :'请填写地址',allowBlank: false},
			dataIndex : "address"
		}, {
			text : "电话",
			field: {xtype: 'textfield',emptyText :'请填写电话',allowBlank: false},
			dataIndex : "phone"
		}],
		plugins: [
			Ext.create('Ext.grid.plugin.RowEditing', {
				saveBtnText: '保存',
				cancelBtnText: "取消",
				autoCancel: false,
				errorSummary :false,
				clicksToEdit: 2,
				listeners:{

					edit:function(e,t){
						grid.getSelectionModel().getSelection()[0].data.birthday = Ext.util.Format.date(t.record.data.birthday,'Y-m-d');
						fn.tools.grid.saveOrUpdatex(grid,'personnelJbxxMng/saveOrUpdateBatch.action');
					}
				}
			})
		]
	});

	//数据集查询之前
	grid.getStore().on('beforeload', function() {

		Ext.apply(grid.getStore().proxy.extraParams,{

				name : queryForm.getForm().findField("name").getValue()
			}
		);
	});

	var viewPanel1 = Ext.create('Ext.Panel', {

		width: width,
		height: height,
		border : false,
		layout:'border',
		items:[queryForm,grid]
	});

	//标签页
	var logTab = Ext.create("Ext.tab.Panel", {
		activeTab : 0,
		border : false,
		region : "center",
		autoScroll : true,
		items : [{
			title : "<div>操作日志</div>",
			autoScroll : true,
			border : 0,
			layout : "fit",
			bodyStyle : "padding:0px",
			items : [viewPanel1]
		},{
		title : "<div>异常日志</div>",
			autoScroll : true,
			border : 0,
			layout : "fit",
			bodyStyle : "padding:0px",
			html : '<img src="./images/system/bg.jpg"/>'
	}]
	});

	var viewPanel = Ext.create('Ext.Panel', {

		width: width,
		height: height,
		renderTo : divid,
		border : false,
		layout:'border',
		items:[logTab]
	});
});
tabPanel.setLoading(false);