Ext.override(Ext.grid.Panel, {
	viewConfig : {
		loadMask : {
			msg : "正在查询数据 ..."
		}
	}
});
Ext.Ajax.timeout = 180000000;
Ext.createExtModel = function(modelString) {
	window.eval(modelString);
};
Ext.createExtStore = function(b) {
	if (b.model) {
		this.createExtModel(b.model);
	}
	var c = b.modelId;
	if (!c) {
		throw "store must be has modelId";
	}
	var a = Ext.create("Ext.data.Store", {
		autoLoad : true,
		pageSize : b.limit || 1000,
		model : c,
		data : b,
		proxy : {
			type : "memory",
			reader : {
				type : "json",
				root : "data",
				totalProperty : "totalProperty"
			}
		}
	});
	alert('dd');
	a.getModelId = function() {
		return c;
	};
	return a;
};

//加载初始化loading
Ext.override(Ext, {
	onReadyx : function(a) {
		Ext.onReady(function() {
			tabPanel.setLoading('初始化...');
			a();
			tabPanel.setLoading(false);
		});
	}
});
//自定义Ext.Msg
fn.importCss("css.system.Toast");
Ext.override(Ext.Msg, {
	confirm : function() {
		var b = arguments[0];
		var a = Ext.Msg.INFO;
		switch (b) {
			case fn.INFO :
				arguments[0] = "提示";
				break;
			case fn.WARN :
				a = Ext.Msg.WARNING;
				arguments[0] = "警告";
				break;
			case fn.ERROR :
				a = Ext.Msg.ERROR;
				arguments[0] = "错误";
				break;
			default :
				arguments[0] = "提示";
		}
		return this.callParent(arguments).setIcon(a);
	},
	error : function(text) {
		this.alert(Ext.Msg.ERROR,text);
	},
	
	//解析控制台信息并提示 返回信息必须为：{type:'...',success:false,msg:'...'}
	consoleAlert : function() {
		var b = arguments[0];
		var c = arguments[1];
		var a = Ext.Msg.INFO;
		switch (b) {
			case fn.INFO :
				arguments[0] = "提示";
				break;
			case fn.WARN :
				a = Ext.Msg.WARNING;
				arguments[0] = "警告";
				break;
			case fn.ERROR :
				a = Ext.Msg.ERROR;
				arguments[0] = "错误";
				break;
			default :
				arguments[0] = "提示";
		}
	   var type = System_Constants.SYSTEM_EXCEPTION_COMMON;
	   var msg = System_Constants.SYSTEM_ERROR_MSG;
	   
	   if(c){
	   		type = c.type;
	   		msg = c.msg;
	   }
	   var config = {};
	   if(type == System_Constants.SYSTEM_EXCEPTION_SESSION){//如果是会话失效
	   	tabPanel.setLoading(false); 
	        config = {
                title: "提示",
                msg: msg,
                buttons: Ext.Msg.YESNO,
                icon: Ext.Msg.INFO,
                fn: function (a) {
                	
                	if(a=='yes'){
                	
                	var submitButton = Ext.create('Ext.Button', {
					    text : "确定",
						iconCls : "Disk",
					    listeners:{
					           click:function(){
						            var loginName = loginWindow.getFormPanel().getForm().findField('loginName').getValue();
									var password = loginWindow.getFormPanel().getForm().findField('password').getValue();
									if (!loginName) {
										Ext.Msg.alert(fn.ERROR, "请输入用户名！",function(){
										
											loginWindow.getFormPanel().getForm().findField('loginName').focus(100,false);
										});
										return;
									}
									if (!password) {
										Ext.Msg.alert(fn.ERROR, "请输入密码！",function(){
										
											loginWindow.getFormPanel().getForm().findField('password').focus(100,false);
										});
										return;
									}
									if (password.length<6) {
										Ext.Msg.alert(fn.ERROR, "密码长度不能小于6位！",function(){
										
											loginWindow.getFormPanel().getForm().findField('password').focus(100,false);
										});
										return;
									}
									Ext.Ajax.request({
									waitMsg : "正在登陆...",
									url : "system/login.action",
									method : 'POST',
									params: {
										loginName : loginName,
										password : password
								    },
									success : function(response) {
										Ext.Msg.hide();
										Ext.MessageBox.wait("登陆成功！正在重新载入页面...", "提示", {text:"正在重新载入页面..."});
										location.reload();
									}
								});
					     }
						}
					});
                	//fn.imports("system.com.CommonFormWindow");
					var loginWindow = Ext.create("system.com.CommonFormWindow", {
						title : "用户登陆",
						url : "system/login.action",
						height : 140,
						width : 300,
						buttons : [submitButton, {
						text : "关闭",
						iconCls : "Cancel",
						handler : function() {
							this.up("window").hide();
						}
					}],
						items : [{
									fieldLabel : "用户名",
									name : 'loginName',
									listeners:{  
							              specialkey:function(field,e){  
							                    if (e.getKey()==Ext.EventObject.ENTER){
							                    	submitButton.fireEvent('click');
							                 }     
							            }  
							         
							           },
									allowBlank : false
								}, {
									fieldLabel : "密码",
									name : "password",
									inputType : "password",
									listeners:{  
							              specialkey:function(field,e){  
							                    if (e.getKey()==Ext.EventObject.ENTER){
							                    	submitButton.fireEvent('click');
							                 }     
							            }  
							         
							           },
									allowBlank : false
								}]
					});
			
					loginWindow.show();
                	}
				}
        	 };
		}else {
			config = {
                title: arguments[0],
                msg: msg,
                buttons: Ext.Msg.OK,
                icon: a
        	 };
		}
		
         Ext.Msg.show(config);
	},
	
	alert : function() {
		var b = arguments[0];
		var a = Ext.Msg.INFO;
		switch (b) {
			case fn.INFO :
				arguments[0] = "提示";
				break;
			case fn.WARN :
				a = Ext.Msg.WARNING;
				arguments[0] = "警告";
				break;
			case fn.ERROR :
				a = Ext.Msg.ERROR;
				arguments[0] = "错误";
				break;
			default :
				arguments[0] = "提示";
		}
		return this.callParent(arguments).setIcon(a);
	},
	
	showTop : function(c, b) {
		b = b || "提示";
		var _msgTop;
		if (!_msgTop) {
			_msgTop = Ext.DomHelper.insertFirst(document.body, {
						id : "msg-div"
					}, true);
		}
		var a = Ext.DomHelper.append(_msgTop, '<div class="msg"><h3><img src="js/extjs-4-2-1/resources/icons/error.png" width="20" height="20"/>&nbsp;'
						+ b + "</h3><p>" + c + "</p></div>", true);
		a.hide();
		a.slideIn("t").ghost("t", {
					delay : 1000,
					remove : true
				});
	}
});


//自定义EXT.Ajax
Ext.override(Ext.Ajax, {
	request : function(c) {
		
		c.method = c.method || "POST";
		
		if (c.waitMsg && typeof(c.waitMsg) === "string"
				&& c.waitMsg.trim() !== "") {
			fn.tools.showProgress(c.waitMsg);
		}
		
		return this.callParent([c]);
	}
});

//重写connection，为了异常统一处理 (∩_∩)
Ext.override(Ext.data.Connection,{
    /**
     * To be called when the request has come back from the server
     * @private
     * @param {Object} request
     * @return {Object} The response
     */
    onComplete : function(request, xdrResult) {
        var me = this,
            options = request.options,
            result,
            success,
            response;
        try {
        	
            result = me.parseStatus(request.xhr.status);
        } catch (e) {
            // in some browsers we can't access the status if the readyState is not 4, so the request has failed
            result = {
                success : false,
                isException : false
            };

        }
        success = me.isXdr ? xdrResult : result.success;
        if (success) {
            response = me.createResponse(request);
            //异常处理
            var text = response.responseText;
        	if(text.indexOf('"success":false')!=-1){
        		Ext.Msg.consoleAlert(fn.ERROR, Ext.JSON.decode(text));
        		return;
	        }
            me.fireEvent('requestcomplete', me, response, options);
            Ext.callback(options.success, options.scope, [response, options]);
        } else {
			
        	//请求异常
        	Ext.Msg.alert(fn.ERROR,System_Constants.SYSTEM_ERROR_MSG);
            if (result.isException || request.aborted || request.timedout) {
            	
                response = me.createException(request);
            } else {
            	
                response = me.createResponse(request);
            }
            me.fireEvent('requestexception', me, response, options);
            Ext.callback(options.failure, options.scope, [response, options]);
        }
        Ext.callback(options.callback, options.scope, [options, success, response]);
        delete me.requests[request.id];
        return response;
    }
});

//为form表单中必填项添加红色*号标志 
Ext.override(Ext.form.field.Base,{//针对form中的基本组件 　　
	initComponent:function(){ 
		if(this.allowBlank!==undefined && !this.allowBlank){ 　　　
			if(this.fieldLabel){ 
			
				this.fieldLabel = '<font color=red>*</font>' + this.fieldLabel; 　　
			　} 
			} 
		this.callParent(arguments); 　
		　} 
}); 


//重写Ext.form.Basic 使之submit不用返回success:true，就能进入success
Ext.override(Ext.form.Basic, {
     /**
     * @private
     * Called after an action is performed via {@link #doAction}.
     * @param {Ext.form.action.Action} action The Action instance that was invoked
     * @param {Boolean} success True if the action completed successfully, false, otherwise.
     */
    afterAction: function(action, success) {
        var me = this;
        if (action.waitMsg) {
            var messageBox = Ext.MessageBox,
                waitMsgTarget = me.waitMsgTarget;
            if (waitMsgTarget === true) {
                me.owner.el.unmask();
            } else if (waitMsgTarget) {
                waitMsgTarget.unmask();
            } else {
                messageBox.hide();
            }
        }
        // Restore setting of any floating ancestor which was manipulated in beforeAction
        if (me.floatingAncestor) {
            me.floatingAncestor.preventFocusOnActivate = me.savePreventFocusOnActivate;
        }
        //改动在这里
        if (action.failure || (action.result.type != null && action.result.msg != null && action.result.success == false)) {
        	
        	Ext.Msg.consoleAlert(fn.ERROR,action.result);
            Ext.callback(action.failure, action.scope || action, [me, action]);
            me.fireEvent('actionfailed', me, action);
        } else {
            if (action.reset) {
                me.reset();
            }
            Ext.callback(action.success, action.scope || action, [me, action]);
            me.fireEvent('actioncomplete', me, action);
        }
    }
}); 

//import model
Ext.override(Ext.data.AbstractStore,{

    constructor: function(config) {
        var me = this,
            filters;
        Ext.apply(me, config);
        me.removed = [];
        me.mixins.observable.constructor.apply(me, arguments);
        var configModel = me.model;
		if(configModel){
			fn.imports(configModel);
		}
        me.model = Ext.ModelManager.getModel(me.model);
        Ext.applyIf(me, {
            modelDefaults: null
        });
        if (!me.model && me.fields) {
            me.model = Ext.define('Ext.data.Store.ImplicitModel-' + (me.storeId || Ext.id()), {
                extend: 'Ext.data.Model',
                fields: me.fields,
                proxy: me.proxy || me.defaultProxyType
            });
            delete me.fields;
            me.implicitModel = true;
        }
        if (!me.model && me.useModelWarning !== false) {
            var logMsg = [
                Ext.getClassName(me) || 'Store',
                ' created with no model.'
            ];
            if (typeof configModel === 'string') {
                logMsg.push(" The name '", configModel, "'", ' does not correspond to a valid model.');
            }
            Ext.log.warn(logMsg.join(''));
        }
        me.setProxy(me.proxy || me.model.getProxy());
        if (!me.disableMetaChangeEvent) {
            me.proxy.on('metachange', me.onMetaChange, me);
        }
        if (me.id && !me.storeId) {
            me.storeId = me.id;
            delete me.id;
        }
        if (me.storeId) {
            Ext.data.StoreManager.register(me);
        }
        me.mixins.sortable.initSortable.call(me);

        filters = me.decodeFilters(me.filters);
        me.filters = new Ext.util.MixedCollection();
        me.filters.addAll(filters);
    }
});
