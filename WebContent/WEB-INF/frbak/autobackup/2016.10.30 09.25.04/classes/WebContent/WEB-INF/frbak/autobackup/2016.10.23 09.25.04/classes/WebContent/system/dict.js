fn.imports("system.constants.Dict_Constants");
fn.imports("system.constants.System_Constants");

Ext.onReady(function() {
	
	var c = fn.getDictStore(Dict_Constants.DICT_STATE, "int");
	var b = "root";
	var d = fn.getDictValue(System_Constants.SYSTEM_TITLE);
	var a = Ext.create("system.com.CommonFormWindow", {
				title : "保存数据字典",
				url : "dict/saveOrUpdate.action",
				height : 340,
				success : function(g, i) {
					Ext.Msg.alert(fn.INFO,'保存成功！',function(){
						
							a.hide();
							var h = e.getSelectionModel().getSelection();
							var fm = a.getFormPanel().getForm();
							if (h.length == 0) {
								e.getStore().load();
							} else {
								var content;
								if(fm.findField('id').getValue()){
								
									content = e.getStore().getNodeById(h[0].get("pid")); 
								}else {
									content = e.getStore().getNodeById(h[0].get("id")); 
								}
								var opions = {node:content};//进行封装       
								e.getStore().reload(opions);//局部加载
							}
						});
					
				},
				items : [{
							fieldLabel : "父字典",
							name : "pid_name",
							disabled : true
						}, {
							fieldLabel : "数据标识",
							allowBlank : false,
							name : "dataId"
						}, {
							fieldLabel : "字典值",
							allowBlank : false,
							name : "value"
						}, {
							fieldLabel : "启用状态",
							xtype : "combobox",
							store : c,
							queryMode : "local",
							displayField : "text",
							valueField : "value",
							value : 1,
							name : "state",
							editable : false
						}, {
							fieldLabel : "排序值",
							name : "rank",
							xtype : "numberfield",
							value : 0
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
						}, {
							xtype : "hidden",
							name : "creator",
							value : fn.base.user.id
						}, {
							xtype : "hidden",
							name : "updateTime"
						}]
			});
	var f = Ext.create("Ext.toolbar.Toolbar", {
				items : [{
					text : "新增",
					iconCls : "Applicationadd",
					handler : function() {
						a.getFormPanel().getForm().reset();
						var h = e.getSelectionModel().getSelection();
						var g = h.length;
						if (g == 0) {
							a.findField("pid").setValue(b);
							a.findField("pid_name").setValue(d);
						} else {
							if (g == 1) {
								a.findField("pid").setValue(h[0].get("id"));
								a.findField("pid_name").setValue(h[0].get("dataId"));
							} else {
								Ext.Msg.showTop("请选择唯一的上级字典。");
								return;
							}
						}
						a.show();
					}
				}, {
					text : "修改",
					iconCls : "Applicationedit",
					handler : function() {
						var h = e.getSelectionModel().getSelection();
						if (h.length <= 0) {
							Ext.Msg.showTop("请选择一个节点进行修改！");
							return;
						}
						if (h.length != 1) {
							Ext.Msg.showTop("最多只能选择一个节点进行修改！");
							return;
						}
						if (b == h[0].get("id")) {
							Ext.Msg.showTop("根节点不能修改。");
							return;
						}
						var g = e.getStore().getNodeById(h[0].get("id"));
						a.findField("pid_name").setValue(g.parentNode.data.dataId||d);
						a.loadRecord(h[0]);
						a.show();
					}
				}, {
					text : "删除",
					iconCls : "Applicationdelete",
					handler : function() {
						
						var j = e.getSelectionModel().getSelection();
						var len = j.length;
						if (len == 0) {
							Ext.Msg.showTop("请选择数据字典进行删除。");
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
						
						Ext.Msg.confirm(fn.INFO, "确定删除选中的数据字典吗？", function(a) {
							if ("yes" == a) {
								
								Ext.Ajax.request({
									waitMsg : "正在删除...",
									url : "dict/delete.action",
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
						e.getStore().load();
					}
				}, "-"]
			});
	var e = Ext.create("system.com.CommonGridTree", {
				displayField : "dataId",
				title : "系统字典",
				renderTo : "dict.viewDict",
				tbar : f,
				url : "dict/loadSystemDicts.action",
				rootId : b,
				rootText : d,
				rootVisible : false,
				model : "system.model.Dict",
				height : document.getElementById("dict.viewDict").offsetHeight,
				columns : [{
							text : "序号",
							xtype : "rownumberer",
							width : 35,
							align : "center"
						}, {
							xtype : "treecolumn",
							text : "数据标识",
							flex : 1,
							dataIndex : "dataId"
						}, {
							text : "字典值",
							flex : 1,
							dataIndex : "value"
						}, {
							text : "状态",
							flex : 1,
							dataIndex : "state",
							renderer : function(g) {
								return fn.tools.viewName(c, g);
							}
						}, {
							text : "排序值",
							dataIndex : "rank"
						}]
			});
	e.getRootNode().expand();
	e.getTbar().add(e.getExpandAllBtn());
	e.getTbar().add(e.getCollapseAllBtn());
//	e.getTbar().add({
//		text : "刷新系统字典缓存",
//		iconCls : "Pagewhiteswoosh",
//		handler : function() {
//			Ext.Msg.confirm("提示", "确认清空系统字典缓存？", function(g) {
//				if ("yes" == g) {
//					Ext.Ajax.request({
//								waitMsg : "正在清除缓存，请稍后...",
//								url : "system.clearDictCache",
//								success : function(i) {
//									Ext.Msg.hide();
//									var h = Ext.decode(i.responseText);
//									if (h.success === true) {
//										Ext.Msg.alert(wdg.INFO, "字典缓存清除成功。");
//									} else {
//										Ext.Msg.alert(wdg.INFO, "字典缓存清除失败。");
//									}
//								}
//							});
//				}
//			});
//		}
//	});
	 
});

tabPanel.setLoading(false);