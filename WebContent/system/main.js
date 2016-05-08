
fn.imports("system.constants.System_Constants");
fn.importCss("css.system.TabScrollerMenu");
Ext.Loader.setPath('Ext.ux', 'system/com/ux');

Ext.require([
    'Ext.ux.TabScrollerMenu',
    'Ext.ux.TabCloseMenu'
]);

var menuTreePanel = null;
var modifyPwdWindow = null;
var loadMarsk = null;
var tabPanel = null;
Ext.onReady(function() {
	Ext.getBody().mask("正在加载主页，请稍后...");
	var systemtitle = fn.getDictValue(System_Constants.SYSTEM_TITLE);
	var contact = fn.getDictValue(System_Constants.SYSTEM_CONTACT);
	var expand = fn.getDictValue(System_Constants.SYSTEM_MENU_EXPAND);
	var about = fn.getDictValue(System_Constants.SYSTEM_ABOUT);
	menuTreePanel = Ext.create("system.com.CommonTree", {
				url : "system/loadSubsystemMenu.action",
				rootId : "root",
				rootText : systemtitle,
				model : "system.model.Menu",
				rootVisible : false,
				bodyStyle : "padding-top:4px;",
				layout : "fit"
				
			});

	menuTreePanel.getStore().addListener("beforeload", function(e) {
				Ext.apply(e.proxy.extraParams, {
							subsystemId : e.subsystemid
						});
			});

	tabPanel = Ext.create("Ext.tab.Panel", {
				activeTab : 0,
				border : false,
				autoScroll : true,
				//plain : true,
				region : "center",
				plugins : [{
							ptype : 'tabscrollermenu',
							maxText : 15,
							pageSize : 5
						},{
							ptype : 'tabclosemenu',
							extraItemsTail: [
			                '-',
			                {
			                    text: '允许关闭',
			                    checked: true,
			                    hideOnClick: true,
			                    handler: function (item) {
			                        currentItem.tab.setClosable(item.checked);
			                    }
			                },
			                '-',
			                {
			                    text: '允许操作',
			                    checked: true,
			                    hideOnClick: true,
			                    handler: function(item) {
			                        currentItem.tab.setDisabled(!item.checked);
			                    }
			                }
			            ],
			            listeners: {
			                beforemenu: function (menu, item) {
			                    var enabled = menu.child('[text="允许操作"]'); 
			                    menu.child('[text="允许关闭"]').setChecked(item.closable);
			                    if (item.tab.active) {
			                        enabled.disable();
			                    } else {
			                        enabled.enable();
			                        enabled.setChecked(!item.tab.isDisabled());
			                    }
			
			                    currentItem = item;
			                }
			            }
						}],
				items : [{
							title : "首页",
							iconCls : 'House',
							autoScroll : true,
							border : 0,
							layout : "fit",
							bodyStyle : "padding:0px",
							html : '<img src="./images/system/bg.jpg"/>'
						}]
			});

	menuTreePanel.addListener("itemclick", function(h, k, o, l) {
		var g = Ext.getCmp("tab-" + k.data.id);
		if (!Ext.isEmpty(g)) {
			tabPanel.setActiveTab(g);
			return;
		}
		for (var j = 0; j < tabPanel.items.length; j++) {
			if (tabPanel.items.items[j].title == k.data.name) {
				tabPanel.setActiveTab(tabPanel.items.items[j]);
				return;
			}
		}
		if (k.data.type < 3) {
			h.expand(k);
			return;
		}
		if (tabPanel.items.getCount() >= System_Constants.SYSTEM_OPENTABCOUNT) {
			Ext.Msg.showTop("最多只能打开" + System_Constants.SYSTEM_OPENTABCOUNT
					+ "个活动面板,请关闭不常用的功能窗口!");
			return;
		}
		var e = k.data.url;
		if (e.trim() == "") {
			Ext.Msg.alert(fn.INFO, "此菜单访问地址为空。");
			return;
		}

		var n = k.data.iconCls || 'Applicationviewdetail';
		var f = null;
		
		if (k.data.openMethod == System_Constants.TAB_OPENTYPE_COMMON) {
			tabPanel.setLoading('正在加载页面，请稍后...');
			f = tabPanel.add({
				id : "tab-" + k.data.id,
				title : k.data.name,
				frame : false,
				border : false,
				autoScroll : true,
				layout : "fit",
				closable : true,
				scripts : true,
				iconCls : n,
				nocache : true,
				sidebarChange : false,
				listeners: {
				
					activate : function(me,o){
						
						if(me.sidebarChange){
							me.sidebarChange = false;
							me.loader.load();
						}
					}
				},
				loader : {
					
					listeners: {
			            exception: function (a,response) {
			            	if(response.status == 404){
				        		Ext.MessageBox.alert(fn.ERROR, "找不到页面,请检查菜单url地址是否正确！");
				        		tabPanel.setLoading(false); 
				        		return;
				        	}
				        	if(response.status == 500){
				        		Ext.MessageBox.alert(fn.ERROR, "程序内部错误,请联系管理员！");
				        		tabPanel.setLoading(false); 
				        		return;
				        	}
				        	
			            }
			        },
			        
					url : e + System_Constants.SYSTEM_ACTION_SUFFIX,
					autoLoad : true,
					loadMask: true,
					scripts : true
				}
			});
		} else {
			if (k.data.openMethod == System_Constants.TAB_OPENTYPE_IFRAME) {
				f = tabPanel.add({
					id : "tab-" + k.data.id,
					title : "<div>" + k.data.name + "</div>",
					frame : false,
					border : false,
					autoScroll : true,
					layout : "fit",
					closable : true,
					scripts : true,
					iconCls : n,
					nocache : true,
					html : '<iframe src="'
							+ e
							+ System_Constants.SYSTEM_ACTION_SUFFIX
							+ '" scrolling="auto" frameborder="0" width="100%" height="100%"></iframe>'
				});
			} else {
				Ext.Msg.alert(fn.INFO, "不能识别的菜单打开类型。");
				return;
			}
		}
		tabPanel.setActiveTab(f);
		//tabPanel.setLoading(false);
		//Ext.getBody().mask("正在加载页面，请稍后...");	
	});
	var systemMenuButton = Ext.create('system.com.ButtonTransparent', {
				text : '主菜单',
				iconCls : 'Layout',
				menu : []
			});

	var updatePasswordButton = Ext.create('system.com.ButtonTransparent', {
				text : '修改密码',
				iconCls : 'Wrench',
				handler : function() {
					modifyPwd();
				}

			});

	var exitButton = Ext.create('system.com.ButtonTransparent', {
				text : '注销',
				iconCls : 'Controlpowerblue',
				handler : function() {
					logout();
				}
			});

	var helpButton = Ext.create('system.com.ButtonTransparent', {
				text : '帮助',
				iconCls : 'Help',
				handler : function() {
					help();
				}
			});

	var a = Ext.create('Ext.Viewport', {
				layout : {
					type : "border",
					padding : '5 5 0 5'
				},
				
				autoScroll : true,
				border : false,
				items : [{
					frame : false,
					region : "north",
					height : 40,
					split : false,
					border : false,
					layout : {
						type : "border"
					},
					defaults : {
						bodyStyle : "background-color:#D7E4F3;padding:0px",
						frame : false,
						height : 40,
						split : false,
						border : false
					},
					items : [{

								region : "center",
								id : 'topview'

							}, {
								region : "east",
								width : 300,
								defaults : {
									padding : '0 5 0 0'
								},
								items : [systemMenuButton,
										updatePasswordButton, exitButton,
										helpButton]
							}]
				}, {
					title : "系统导航",
					region : "west",
					layout : "accordion",
					iconCls : 'Keyboard',
					defaults : {
						anchor : '100%'
					},
					
					width : 200,
					border : false,
					split : true,
					collapsible : true,
					listeners: {
					move : {fn:function(b,c,p,o){
						doRefresh();
					}},
					collapse : {fn:function(p,o){
						doRefresh();
					}},
					expand : {fn:function(p,o){
						doRefresh();
					}}
				},
					items : [{
								xtype : "panel",
								title : "菜单",
								autoScroll : true,
								iconCls : 'Textalignjustify',
								items : [menuTreePanel]
							}, {
								title : "关于我",
								xtype : "panel",
								iconCls : 'Usergraycool',
								html : about
							}]
				}, {
					height : 25,
					border : true,
					id : 'bottomview',
					split : false,
					region : "south",
					html : '',
					autoScroll : false
				}, tabPanel]
			});

	/**
	 * =======================script=============================
	 */

	/**
	 * 加载事件
	 */

	// 点击子系统菜单事件
	function loadSubsystem(c, b) {
		if (menuTreePanel.getStore().subsystemid
				&& menuTreePanel.getStore().subsystemid == c) {
			Ext.Msg.showTop('您正在访问当前子系统，请操作左边菜单栏!');
			return;
		}
		menuTreePanel.getStore().subsystemid = c;
		var a = function() {
			menuTreePanel.getStore().removeListener("load", a);
			var d = fn.getDictValue(System_Constants.SYSTEM_MENU_EXPAND);
			if (d === System_Constants.EXPAND_VALUE_ONE) {
				menuTreePanel.getRootNode().expand(false, function(e) {
							menuTreePanel.getRootNode().firstChild.expand();
						}, this);
			} else {
				menuTreePanel.expandAll();
			}
			Ext.getBody().unmask();
		};
		menuTreePanel.getStore().addListener("load", a);
		menuTreePanel.getStore().load();
		
	}

	// 注销
	function logout() {
		Ext.Msg.confirm(fn.INFO, "确定退出系统吗？", function(a) {
			if ("yes" == a) {
				Ext.Ajax.request({
							waitMsg : "正在进行安全退出...",
							url : "system/logout.action",
							method : 'POST'
						});
			}
		});
	}

	// 修改用户密码
	function modifyPwd() {
		if (modifyPwdWindow) {
			modifyPwdWindow.getFormPanel().getForm().reset();
		} else {
			fn.imports("system.com.CommonFormWindow");
			modifyPwdWindow = Ext.create("system.com.CommonFormWindow", {
				title : "正在修改用户[<font color=red>" + fn.base.user.name
						+ "</font>]的密码...",
				url : "system/modifyPWD.action",
				height : 240,
				width : 400,
				validate : function(a) {
					if (a.findField("newPwd").getValue() != a
							.findField("newPwd2").getValue()) {
						Ext.Msg.alert(fn.WARN, "新输入的两次密码不一致。");
						return false;
					}
					if (a.findField("newPwd").getValue().length < 6) {
						Ext.Msg.alert(fn.WARN, "密码长度不能小于6");
						return false;
					}
					return true;
				},
				success : function(a, b) {
					Ext.Msg.alert(fn.WARN, "密码修改成功，确定重新登录。", function() {
						window.location.href = System_Constants.SYSTEM_LOGINPAGE;
					});
				},
				items : [{
							name : "loginName",
							xtype : 'hidden',
							value : fn.base.user.loginName
						}, {
							fieldLabel : "登录名",
							value : fn.base.user.loginName,
							disabled : true
						}, {
							inputType : "password",
							fieldLabel : "原始密码",
							name : "oldPwd",
							allowBlank : false
						}, {
							inputType : "password",
							fieldLabel : "新密码",
							name : "newPwd",
							allowBlank : false
						}, {
							inputType : "password",
							fieldLabel : "确认新密码",
							name : "newPwd2",
							allowBlank : false
						}]
			});
		}
		modifyPwdWindow.show();
	}

	

	// 下载帮助文档
	function help() {
		Ext.Msg.confirm("提示", "是否下载帮助文档？", function(a) {
					if ("yes" == a) {
						fn.downloadLocalFile('download/help.docx', '帮助文档1.0');
					}
				});
	}
	
	function doRefresh(){
		
		var tabs = tabPanel.items.items;
		
		Ext.Array.each(tabs,function(tab){
		
			tab.sidebarChange = (tab.sidebarChange == true ? false : true);
			
		});
		var activeTab = tabPanel.getActiveTab();
		activeTab.sidebarChange = false;
		if(activeTab.title!='首页'){
		
			activeTab.loader.load();
		}
	}

	/**
	 * 加载页面元素
	 */
	// 加载权限内的所有子系统菜单
	if (fn.base.subsystem.length > 0) {

		for (i = 0; i < fn.base.subsystem.length; i++) {

			var checked = false;
			if (i == 0) {

				checked = true;
			}
			systemMenuButton.menu.add(new Ext.menu.Item({

						checked : checked,
						text : fn.base.subsystem[i].name,
						value : fn.base.subsystem[i].id,
						iconCls : fn.base.subsystem[i].iconCls
								? fn.base.subsystem[i].iconCls
								: 'Folder',
						handler : function() {

							loadSubsystem(this.value, this.text);
						}
					}));
		}
	}

	// 加载页头页脚
	var topview = '<div style="background-color:#D7E4F3;height:40px;">&nbsp;&nbsp;';
	topview += '<img src="js/extjs-4-2-1/resources/icons/laptop.png" width="20" height="20"/>';
	topview += '<font style="font-size:24px;font-weight:bold;">' + systemtitle
			+ '</font>';
	topview += '(version:'+System_Constants.SYSTEM_VERSION+')';
	topview += '<font style="float:right;font-size:14px;margin-right:5px;">欢迎您&nbsp;<font color=red>'
			+ fn.base.user.name + '</font>！</font>';
	topview += '</div>';

	var bottomview = '<table background="images/system/main_bottom_bg.png" width="100%" height="25" border="0" cellpadding="0" cellspacing="0">';
	bottomview += '<tr>';
	bottomview += '<td width="100%" style="text-align: center; padding-top: 5px">';
	bottomview += '<font size="2">';
	bottomview += '<marquee behavior="scroll" scrollamount="2" width="40%">欢迎访问'
			+ systemtitle + '</marquee>';
	bottomview += '</font>';
	bottomview += '</td>';
	bottomview += '</tr>';
	bottomview += '</table>';

	document.getElementById('topview').innerHTML = topview;
	document.getElementById('bottomview').innerHTML = bottomview;

	// 第一次加载树菜单
	loadSubsystem(fn.base.subsystem.length == 0
					? null
					: fn.base.subsystem[0].id, null);

	// 获取高度宽度
	fn.base.width = a.getWidth();
	fn.base.height = a.getHeight();
	fn.base.editorWidth = a.getWidth() - 200;
	fn.base.editorHeight = a.getHeight() - 80;
	fn.base.systemTitle = systemtitle;
});
