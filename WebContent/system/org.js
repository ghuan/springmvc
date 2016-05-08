fn.imports("system.constants.Org_Constants");

Ext.onReady(function() {

	var c = fn.getDictStore(Org_Constants.ORG_DICT_TYPE, "int");
	//alert(c.getCount());
	var b = "root";
	var d = fn.getDictValue(Org_Constants.ORG_DICT_ORGROOT);

	var a = Ext.create("system.com.CommonFormWindow", {
				title : "保存组织部门",
				url : "org/saveOrUpdate.action",
				height : 350,
				success : function(h, j) {
					
					Ext.Msg.alert(fn.INFO,'保存成功！',function(){
					
						a.hide();
						var i = e.getSelectionModel().getSelection();
						var fm = a.getFormPanel().getForm();
							
							if (i.length == 0) {
								e.getStore().load();
							} else {
								var content;
								if(fm.findField('id').getValue()){
								
									content = e.getStore().getNodeById(i[0].get("pid")); 
								}else {
									content = e.getStore().getNodeById(i[0].get("id")); 
								}
								var opions = {node:content};//进行封装       
								e.getStore().reload(opions);//局部加载
								
							}
					});
				},

				items : [{
							fieldLabel : "上级机构",
							name : "pid_name",
							disabled : true
						}, {
							fieldLabel : "机构编码",
							allowBlank : false,
							name : "orgCode"
						}, {
							fieldLabel : "机构名称",
							allowBlank : false,
							name : "name"
						}, {
							fieldLabel : "机构类型",
							name : "type",
							xtype : "combobox",
							store : c,
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
						}, {
							xtype : "hidden",
							name : "morgId"
						}]
			});

	var queryText = Ext.create("Ext.form.field.Text", {
				width : 100,
				listeners : {
					specialkey : function(field, e) {
						if (e.getKey() == Ext.EventObject.ENTER) {
							queryByKey();
						}
					}

				}
			});
	var h = Ext.create("Ext.toolbar.Toolbar", {
		items : ["机构名称", queryText, {
					text : "查询",
					iconCls : "Magnifier",
					handler : function() {
						queryByKey();
					}
				}, '-', {
					text : "新增",
					iconCls : "Applicationadd",
					handler : function() {
						a.getFormPanel().getForm().reset();
						var j = e.getSelectionModel().getSelection();
						var i = j.length;
						if (i == 0) {
							a.findField("pid").setValue(b);
							a.findField("pid_name").setValue(d);
							a.findField("type").setValue(1);
						} else {
							if (i == 1) {
								if (j[0].get("type") == c.getCount()) {

									Ext.Msg.showTop("["+c.getAt(c.getCount()-1).get('text')+"]为最底级组织类型，不能作为上级组织。");
									return;
								}
								a.findField("pid").setValue(j[0].get("id"));
								a.findField("pid_name").setValue(j[0]
										.get("name"));
								a.findField("type").setValue((j[0].get("type"))
										+ 1);
							} else {
								Ext.Msg.showTop("请选择唯一的上级组织。");
								return;
							}
						}
						a.show();
					}
				}, {
					text : "修改",
					iconCls : "Applicationedit",
					handler : function() {
						var j = e.getSelectionModel().getSelection();
						if (j.length != 1) {
							Ext.Msg.showTop("请选择唯一的数据进行修改。");
							return;
						}
						if (b == j[0].get("id")) {
							Ext.Msg.showTop("根节点不能修改。");
							return;
						}
						a.getFormPanel().getForm().reset();
						var i = e.getStore().getNodeById(j[0].get("id"));

						a.findField("pid_name")
								.setValue(i.parentNode.data.name);
						a.loadRecord(j[0]);
						a.show();
					}
				}, {
					text : "删除",
					iconCls : "Applicationdelete",
					handler : function() {

						var j = e.getSelectionModel().getSelection();
						var len = j.length;
						if (len == 0) {
							Ext.Msg.showTop("请选择数据进行删除。");
							return;
						}

						var ids = [];
						// 根节点不能删除
						for (i = 0; i < len; i++) {

							if (b == j[i].get("id")) {
								Ext.Msg.showTop("根节点不能删除。");
								return;
							}
							ids.push(j[i].get("id"));
						}

						Ext.Msg.confirm(fn.INFO, "确定删除选中的数据吗？", function(a) {
							if ("yes" == a) {

								Ext.Ajax.request({
											waitMsg : "正在删除...",
											url : "org/delete.action",
											method : 'POST',
											params : {
												ids : ids
											},
											success : function(response) {

												Ext.Msg.alert(fn.INFO, "删除成功！",
														function() {

															for (i = 0; i < len; i++) {

																j[i].remove();// 逻辑删除
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
				title : "组织部门",
				renderTo : "org.viewOrg",
				url : "org/getOrg.action",
				rootId : b,
				rootText : d,
				tbar : h,
				model : "system.model.Org",
				height : document.getElementById("org.viewOrg").offsetHeight,
				columns : [{
							text : "序号",
							xtype : "rownumberer",
							width : 35,
							align : "center"
						}, {
							xtype : "treecolumn",
							text : "机构名称",
							flex : 1,
							dataIndex : "name",
							align : "left"
						}, {
							text : "机构类型",
							flex : 1,
							dataIndex : "type",
							renderer : function(h) {
								return fn.tools.viewName(c, h, "学校");
							}
						}, {
							text : "备注",
							flex : 1,
							dataIndex : "remark"
						}, {
							text : "排序值",
							dataIndex : "rank"
						}]
			});

	e.getTbar().add(e.getExpandAllBtn());
	e.getTbar().add(e.getCollapseAllBtn());
	e.getTbar().add('-');
	e.getTbar().add({
		text : "查看本机构",
		iconCls : "Usergo",
		handler : function() {
			e.getStore().on("beforeload", function() {
						Ext.apply(e.getStore().proxy.extraParams, {
									id : e.getConfig().firstOrgid
											|| fn.base.org.id
								});
					});
			e.getStore().load();
		}
	});
	e.getTbar().add({
				text : "查看所有",
				iconCls : "Groupgo",
				handler : function() {
					e.getStore().on("beforeload", function() {
								Ext.apply(e.getStore().proxy.extraParams, {
											id : "root"
										});
							});
					e.getStore().load();
				}
			});

	// scripts
	var queryByKey = function() {

		var b = e.initData || e.getConfig().initData || [];
		if (!b || b.length <= 0) {
			if (queryText.getValue().trim() == "") {
				e.getStore().reload();
				return;
			}
		}
		Ext.Ajax.request({
					waitMsg : "正在查询，请稍后...",
					url : "org/getOrgByPath.action",
					params : {
						name : queryText.getValue()
					},
					success : function(h) {
						Ext.Msg.hide();
						var f = Ext.JSON.decode(h.responseText);
						if (f.length != 0) {
							var len = f.length;
							var j = [];
							for (var g = 0; g < len; g++) {
								e.expandPath("/root" + f[g].path, null, null,
										function(l, i) {
											j.push(i);
											e.getSelectionModel().select(j);
										});
							}
						} else {
							Ext.Msg.showTop("根据条件[" + queryText.getValue()
									+ "]没有搜索到相关节点");
						}
					}
				});
	};
});
tabPanel.setLoading(false);