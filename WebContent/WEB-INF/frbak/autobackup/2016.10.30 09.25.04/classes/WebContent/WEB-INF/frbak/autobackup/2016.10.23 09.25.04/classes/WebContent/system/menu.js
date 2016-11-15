fn.imports("system.constants.Menu_Constants");

Ext.onReady(function() {
	var g = fn.getDictStore(Menu_Constants.MENU_DICT_OPENMETHOD, "int");
	var e = fn.getDictStore(Menu_Constants.MENU_DICT_STATE, "int");
	var c = fn.getDictStore(Menu_Constants.MENU_DICT_TYPE, "int");
	var b = "root"; 
	var d = fn.getDictValue("SYSTEM.TITLE");
	var a = Ext.create("system.com.CommonFormWindow", {
				title : "保存系统菜单",
				url : "menu/saveOrUpdate.action",
				success : function(i, k) {
						Ext.Msg.alert(fn.INFO,'保存成功！',function(){
						
							a.hide();
							var j = f.getSelectionModel().getSelection();
							var fm = a.getFormPanel().getForm();
							
							if (j.length == 0) {
								f.getStore().load();
							} else {
								var content;
								if(fm.findField('id').getValue()){
									content = f.getStore().getNodeById(j[0].get("pid"));     //获取要刷新的节点
								}else {
								
									content = f.getStore().getNodeById(j[0].get("id"));     //获取要刷新的节点
								}
								var opions = {node:content};//进行封装       
								//这里如果以前是叶子节点，如功能点，就刷新上级节点
								if(j[0].get("type") == 3){
									f.getStore().reload(content);//局部加载
									
								}else {
									f.getStore().reload(opions);//局部加载
								}
								
							}
						});
				},
				
				items : [{
							fieldLabel : "上级菜单",
							name : "pid_name",
							disabled : true
						}, {
							fieldLabel : "菜单名称",
							allowBlank : false,
							name : "name"
						}, {
							fieldLabel : "访问地址",
							name : "url"
						}, {
							fieldLabel : "菜单类型",
							name : "type",
							xtype : "combobox",
							store : c,
							queryMode : "local",
							displayField : "text",
							valueField : "value",
							value : 1,
							//disabled : true,
							editable : false
						}, {
							fieldLabel : "访问图标",
							name : "iconCls"
						}, {
							fieldLabel : "启用状态",
							xtype : "combobox",
							store : e,
							queryMode : "local",
							displayField : "text",
							valueField : "value",
							value : 1,
							name : "state",
							editable : false
						}, {
							fieldLabel : "打开方式",
							name : "openMethod",
							xtype : "combobox",
							store : g,
							queryMode : "local",
							displayField : "text",
							valueField : "value",
							value : 1,
							editable : false
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
						}, {
							xtype : "hidden",
							name : "pid"
						}]
			});
	var h = Ext.create("Ext.toolbar.Toolbar", {
				items : [{
					text : "新增",
					iconCls : "Applicationadd",
					handler : function() {
						a.getFormPanel().getForm().reset();
						var j = f.getSelectionModel().getSelection();
						var i = j.length;
						if (i == 0) {
							a.findField("pid").setValue(b);
							a.findField("pid_name").setValue(d);
							a.findField("type").setValue(1);
						} else {
							if (i == 1) {
								if(j[0].get("type") == 4){
								
									Ext.Msg.showTop("【权限】为最底级菜单类型，不能作为上级菜单。");
									return;
								}
								
								a.findField("pid").setValue(j[0].get("id"));
								a.findField("pid_name").setValue(j[0].get("name"));
								//a.findField("showType").setValue((j[0].get("type"))+1);
								a.findField("type").setValue((j[0].get("type"))+1);
							} else {
								Ext.Msg.showTop("请选择唯一的上级菜单。");
								return;
							}
						}
						a.show();
					}
				}, {
					text : "修改",
					iconCls : "Applicationedit",
					handler : function() {
						var j = f.getSelectionModel().getSelection();
						if (j.length != 1) {
							Ext.Msg.showTop("请选择唯一的菜单进行修改。");
							return;
						}
						if (b == j[0].get("id")) {
							Ext.Msg.showTop("根节点不能修改。");
							return;
						}
						a.getFormPanel().getForm().reset();
						var i = f.getStore().getNodeById(j[0].get("id"));
						
						a.findField("pid_name").setValue(i.parentNode.data.name);
						//a.findField("showType").setValue(j[0].get("type"));
						a.loadRecord(j[0]);
						a.show();
					}
				}, {
					text : "删除",
					iconCls : "Applicationdelete",
					id : 'menuDel',
					handler : function() {
//						fn.checkAuth('系统管理.组织机构管理.只操88作本机构',function(c){
//						
//							alert(c);
//						});return;
						var j = f.getSelectionModel().getSelection();
						var len = j.length;
						if (len == 0) {
							Ext.Msg.showTop("请选择菜单进行删除。");
							return;
						}
						
						var ids = [];
						//根节点不能删除
						for(i=0;i<len;i++){
						
							if (b == j[i].get("id")) {
								Ext.Msg.showTop("根节点不能删除。");
								return;
							}
							ids.push(j[i].get("id"));
						}
						
						Ext.Msg.confirm(fn.INFO, "确定删除选中的菜单吗？", function(a) {
							if ("yes" == a) {
								
								Ext.Ajax.request({
									waitMsg : "正在删除...",
									url : "menu/delete.action",
									method : 'POST',
									params : {
										ids:ids
									},
									success : function(response) {
										
										Ext.Msg.alert(fn.INFO,"删除成功！",function(){
											
											for(i=0;i<len;i++){
						
												j[i].remove();//逻辑删除
											}
										});
									}
								});
							}
						});
						
					}
				}, {
					text : "刷新树",
					iconCls : "Arrowrefresh",
					handler : function() {
						f.getStore().load();
					}
				}, "-"]
			});
	//权限控制
	fn.checkAuth(Menu_Constants.MENU_DEL_AUTH_PATH,function(c){
					
		if(!c){
			Ext.getCmp('menuDel').hide();
		}
	});
	var f = Ext.create("system.com.CommonGridTree", {
				title : "系统菜单",
				renderTo : "menu.viewMenu",
				tbar : h,
				url : "menu/loadMenu.action",
				rootId : b,
				rootText : d,
				model : "system.model.Menu",
				//selectModel : "MULTI",
				height : document.getElementById("menu.viewMenu").offsetHeight,
				columns : [{
							text : "序号",
							xtype : "rownumberer",
							width : 35,
							align : "center"
						}, {
							xtype : "treecolumn",
							text : "菜单名称",
							flex : 1,
							dataIndex : "name",
							align : "left"
						}, {
							text : "访问路径",
							flex : 1,
							dataIndex : "url"
						}, {
							text : "状态",
							flex : 1,
							dataIndex : "state",
							renderer : function(i) {
								return fn.tools.viewName(e, i);
							}
						}, {
							text : "节点类型",
							flex : 1,
							dataIndex : "type",
							renderer : function(i) {
								return fn.tools.viewName(c, i, "根节点");
							}
						}, {
							text : "排序值",
							dataIndex : "rank"
						}]
			});
	
	f.getTbar().add(f.getExpandAllBtn());
	f.getTbar().add(f.getCollapseAllBtn());
	f.getTbar().add({
		
		text : "菜单缓存清理",
		iconCls : "Pagewhiteswoosh",
		handler : function() {
			Ext.Msg.confirm(fn.INFO, "当系统菜单有改动时，需要刷新菜单缓存", function(a) {
							if ("yes" == a) {
								
								Ext.Ajax.request({
									waitMsg : "正在删除...",
									url : "menu/rfMenuSession.action",
									method : 'POST',
									
									success : function(response) {
										Ext.Msg.confirm(fn.INFO, "刷新成功！是否刷新页面？", function(a) {
										
											if(a=="yes"){
												location.reload();
											}
										});
									}
								});
							}
						});
		}
	});
});
tabPanel.setLoading(false);