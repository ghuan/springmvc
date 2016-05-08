fn.imports('js.system.upload.UploadPanel');
fn.imports('js.system.upload.swfupload.swfupload');

Ext.onReady(function() {

	var divid = "imageUploadMng.viewImageUploadMng";
	var height = document.getElementById(divid).offsetHeight;
	var width = document.getElementById(divid).offsetWidth;
	
	 //上传相片组件
	
	var uploadPanel = new Ext.create('Ext.ux.uploadPanel.UploadPanel',{  
        addFileBtnText : '选择图片...',  
        uploadBtnText : '上传',  
        removeBtnText : '移除所有',  
        cancelBtnText : '取消上传',
        file_size_limit : 10000,//MB  
        upload_url : 'imageUploadMng/imageUpload.action',
        post_params : {checkLogin:false}
    });  
	
	//上传窗体
    var win = Ext.create('Ext.window.Window', {
    	
        title : '图片上传窗体[<font color=red>点击标题可进行修改</font>]',  
        width : 580,
		height : 300,
		layout : 'fit',
	    modal : true,
	    frame : true,
	    plain : true,
	    closeAction : 'hide',
	    items: uploadPanel
	});
    win.on("hide", function () {
    	grid.getPagging().doRefresh();
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
						fieldLabel : "标题",
						name : "title"
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
					text : "上传图片",
					iconCls : "Add",
					handler : function() {
						win.show();
						uploadPanel.getStore().removeAll();
					}
				}, {
					text : "删除",
					iconCls : "Delete",
					handler : function() {
						fn.tools.grid.deletex(grid,'imageUploadMng/delete.action');
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
			model : 'subsystem.gsgl.personnel.uploadimage.model.Image',
			url : 'imageUploadMng/getImages.action',
			pageSize : 20,
			title : '图片列表',
			columns : [{
					text : "序号",
					xtype : "rownumberer",
					width : 35,
					tdCls:'tdValign'
				}, {
					text : "图片",
					dataIndex : "image",
					tdCls:'tdValign',
					width:40,
					renderer:function(value,metaData,record,rowIndex,colIndex,store,view){
						
						return "<img src='imageUploadMng/showImageById.action?id="+record.data.id+"' width='100' height='100'/>";
					}
				}, {
					text : "标题",
					dataIndex : "title",
					tdCls:'tdValign'
				}, {
					text : "更新时间",
					dataIndex : "updateTime",
					tdCls:'tdValign'
				}]
		});
		
	//数据集查询之前
    grid.getStore().on('beforeload', function() {
    	
	 	Ext.apply(grid.getStore().proxy.extraParams,{
	 		title : queryForm.getForm().findField("title").getValue()
	 		}
	 	);
     });
     
    var viewPanel = Ext.create('Ext.Panel', {
		
		width: width,
		height: height,
		renderTo : divid,
		border : false,
		layout:'border',
		items:[queryForm,grid]
	});
});
tabPanel.setLoading(false);