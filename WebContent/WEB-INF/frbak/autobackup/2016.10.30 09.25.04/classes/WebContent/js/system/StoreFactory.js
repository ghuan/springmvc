Fanfan.StoreFactory = {
	createStore : function(c,m) {//如果参数有selModel(m)，则store加载时取消selModel的选择
		if (!c || !c.model) {
			Ext.Msg.alert(fn.INFO, "store的model属性必须配置");
			return;
		}
		fn.imports(c.model);
		var d = c.pageSize || 20;
		var b = {
			start : 0,
			limit : d
		};
		if (c.autoLoad === false) {
			b = false;
		}
		var a = Ext.create("Ext.data.Store", {
					model : c.model,
					pageSize : d,
					proxy : {
						type : "ajax",
						url : c.url,
						actionMethods : {
							read : "POST"
						},
						reader : {
							type : "json",
							root : "data",
							totalProperty : "totalProperty"
						}
					},
					autoLoad : b
				});
		if(m){//如果参数有selModel，则store加载时取消selModel的选择
		
			a.addListener('load', function(st, rds, opts) {
		    	m.deselectAll();
			});
		}
		return a;
	},
	createHttpStore : function(d) {
		d = d || {};
		var c = d.autoLoad;
		var a = d.url;
		d.autoLoad = false;
		d.url = "sys/system.loginOther";
		var b = this.createStore(d);
		Ext.apply(b.proxy.extraParams, {
					_httpUrl_ : a
				});
		if (c === false) {
			return b;
		}
		var e = d.pageSize || 20;
		c = {
			start : 0,
			limit : e
		};
		b.load(c);
		return b;
	},
	createArrayStore : function(a) {
		var b = Ext.create("Ext.data.ArrayStore", {
					fields : ["value", "text"],
					data : a
				});
		return b;
	}
};
Fanfan.sf = Fanfan.StoreFactory;