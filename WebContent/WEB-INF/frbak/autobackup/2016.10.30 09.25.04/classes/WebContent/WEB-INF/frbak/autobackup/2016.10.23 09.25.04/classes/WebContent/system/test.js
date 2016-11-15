Ext.override(Ext.grid.Panel, {
			viewConfig : {
				loadMask : {
					msg : "正在查询数据 ..."
				}
			}
		});
Ext.Ajax.timeout = 180000;
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
						totalProperty : "total"
					}
				}
			});
	a.getModelId = function() {
		return c;
	};
	return a;
};
Wdg.imports("scripts.common.file.File", true);
Wdg.importCss("scripts.common.ext-datetime.datetime");
Wdg.importCss("css.TopMsg");
Wdg.imports("scripts.common.ext-datetime.datetime", true, function() {
			Ext.form.field.Date.prototype.getValue = function() {
				return this.getRawValue();
			};
			Ext.override(Ext.form.field.Date, {
						setValue : function() {
							try {
								var a = arguments[0];
								if (typeof(a) == "string") {
									a = a.replaceAll("-", "").replaceAll(" ",
											"").replaceAll(":", "");
									if (a == "") {
										a = null
									}
								}
								return this.callParent([a]);
							} catch (b) {
							}
						}
					});
		});
Ext.override(Ext, {
			onReadyx : function(a) {
				Ext.onReady(function() {
							var b = document.createElement("div");
							b.style.position = "absolute";
							b.style.top = wdg.base.height / 2;
							b.style.left = wdg.base.width / 2;
							b.style.zIndex = 10000;
							b.innerHTML = '<img src="' + wdg.base.path
									+ '/images/login/ajax_loader.gif"/>初始化...';
							document.body.appendChild(b);
							a();
							document.body.removeChild(b);
						});
			}
		});
var _msgTop;
Ext.override(Ext.Msg, {
			confirm : function() {
				return this.callParent(arguments).setIcon(Ext.Msg.QUESTION);
			},
			error : function() {
				this.alert(wdg.ERROR, "服务器内部错误，请联系管理员！");
			},
			alert : function() {
				var b = arguments[0];
				var a = Ext.Msg.INFO;
				switch (b) {
					case wdg.INFO :
						arguments[0] = "提示";
						break;
					case wdg.WARN :
						a = Ext.Msg.WARNING;
						arguments[0] = "警告";
						break;
					case wdg.ERROR :
						a = Ext.Msg.ERROR;
						arguments[0] = "错误";
						break;
					default :
						arguments[0] = "提示";
				}
				return this.callParent(arguments).setIcon(a);
			},
			showTop : function(c, b) {
				b = b || "提示！";
				if (!_msgTop) {
					_msgTop = Ext.DomHelper.insertFirst(document.body, {
								id : "msg-div"
							}, true);
				}
				var a = Ext.DomHelper.append(_msgTop, '<div class="msg"><h3>'
								+ b + "</h3><p>" + c + "</p></div>", true);
				a.hide();
				a.slideIn("t").ghost("t", {
							delay : 1000,
							remove : true
						});
			}
		});
Ext.override(Ext.Ajax, {
			request : function(c) {
				var a = wdg.analyseUrl(c.url, false);
				var b = "wdg.action?random=" + Math.random();
				if (a.paramString) {
					b += ("&" + a.paramString);
				}
				c.url = b;
				c.method = c.method || "POST";
				var d = c.params || {};
				Wdg.tools.merger2json({
							transcode : a.action,
							opttype : a.method
						}, d);
				c.params = d;
				if (c.waitMsg && typeof(c.waitMsg) === "string"
						&& c.waitMsg.trim() !== "") {
					Wdg.tools.showProgress(c.waitMsg);
				}
				if (c.download === true) {
					c.url = "download.action";
				}
				return this.callParent([c]);
			}
		});
wdg.getDictValue("SYSTEM.ANIMATE", function(a) {
			if (a == "1") {
				Ext.override(Ext.Window, {
							show : function(b) {
								if (b) {
									return this.callParent([b]);
								}
								return this.callParent([document.body]);
							},
							hide : function(b) {
								if (b) {
									return this.callParent([b]);
								}
								return this.callParent([document.body]);
							}
						});
			}
		});