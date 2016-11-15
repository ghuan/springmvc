Fanfan.Tools = {
	progress : function() {
		var a = Ext.MessageBox.show({
					title : "请等待",
					msg : "正在加载项目...",
					progressText : "正在初始化...",
					width : 300,
					progress : true,
					closable : false
				});
		a.over = function(b) {
			b = b == -1 ? -1 : parseInt(b * (1 / (parseInt(b / 9) + 1)));
			if (b == -1) {
				a.updateProgress(1, "已完成100% ");
				a.hide();
			} else {
				var c = b / 10;
				a.updateProgress(c, "已完成" + Math.round(100 * c) + "% ");
			}
		};
	},
	showProgress : function(b,c) {
		Ext.MessageBox.wait(b || "请等待！", "提示", {text:c || "请等待..."});
	},
	
	dateFormat : function(b, i) {
		if (!b) {
			b = new Date();
		}
		if (!i) {
			i = "yyyy-MM-dd HH:mm:ss";
		}
		var g = b.getFullYear();
		var f = b.getMonth() + 1;
		if (f < 10) {
			f = "0" + f;
		}
		var h = b.getDate();
		if (h < 10) {
			h = "0" + h;
		}
		var d = b.getHours();
		if (d < 10) {
			d = "0" + d;
		}
		var e = b.getMinutes();
		if (e < 10) {
			e = "0" + e;
		}
		var a = b.getSeconds();
		if (a < 10) {
			a = "0" + a;
		}
		var c = b.getMilliseconds();
		if (c < 10) {
			c = "00" + c;
		} else {
			if (c < 100) {
				c = "0" + c;
			}
		}
		return i.replace("yyyy", g).replace("MM", f).replace("dd", h).replace(
				"HH", d).replace("mm", e).replace("ss", a).replace("sss", c);
	},
	bindDatePicker : function(b, c) {
		c = c || "yyyy-MM-dd HH:mm:ss";
		var a = $(b.getEl().dom).find("input")[0];
		a.onclick = function() {
			WdatePicker({
						dateFmt : c
					});
		};
	},
	viewName : function(g, f, d, j, a) {
		j = j || "value";
		a = a || "text";
		var c = g.getCount();
		var e = null;
		for (var b = 0; b < c; b++) {
			var h = g.getAt(b);
			if (f == h.get(j)) {
				e = h.get(a);
				break;
			}
		}
		return e || d || "<font color=red>未知[" + f + "]</font>";
	},
	operateTime : function(b) {
		if (!b) {
			alert("请配置操作时间的参数，参数为一个json对象{type:'hour', num:1, date: new Date()}，date可选，默认为当前时间");
			return;
		}
		if (!b.type) {
			alert('操作类型必填，请从下列值选择["day","hour","minute","second","milSecond"]');
			return;
		}
		if (!b.num || isNaN(b.num)) {
			alert("相加减的数字必填，且必须为整形数字");
			return;
		}
		var a = b.date;
		if (!a) {
			a = new Date();
		}
		var c = null;
		switch (b.type) {
			case "day" :
				c = a.getTime() + (24 * 3600 * 1000 * b.num);
				break;
			case "hour" :
				c = a.getTime() + (3600 * 1000 * b.num);
				break;
			case "minute" :
				c = a.getTime() + (60 * 1000 * b.num);
				break;
			case "second" :
				c = a.getTime() + (1000 * b.num);
				break;
			default :
				c = a.getTime() + (b.num);
		}
		a.setTime(c);
		return a;
	},
	setHtml : function(a, b) {
		a.body.dom.innerHTML = b;
	},
	isArray : function(a) {
		return Fanfan.isArray(a);
	},
	clone : function(c) {
		function a() {
		}
		a.prototype = c;
		var d = new a();
		for (var b in d) {
			if (typeof(d[b]) === "object") {
				d[b] = this.clone(d[b]);
			}
		}
		return d;
	},
	merger2json : function(c, b) {
		for (var a in c) {
			if (typeof(c[a]) === "object" && c[a] != null
					&& !this.isArray(c[a])) {
				if (!b[a]) {
					b[a] = {};
				}
				this.merger2json(c[a], b[a]);
			} else {
				b[a] = c[a];
			}
		}
	},
	grid : {
		deletex : function(e, d, c, f, b) {
			b = b || "id";
			if(!d){
				Ext.Msg.showTop("删除url不能为空。");
			}
			var h = c || function() {
				Ext.Msg.hide();
				e.getPagging().doRefresh();
				Ext.Msg.showTop("删除成功。");
			};
			var g = e.getSelectionModel().getSelection();
			var a = g.length;
			if (a == 0) {
				
				Ext.Msg.showTop("请选择要删除的数据。");
				return;
			}
			Ext.Msg.confirm(fn.INFO, "确认删除选中的数据？", function(k) {
						if ("yes" == k) {
							var l = [];
							for (var j = 0; j < a; j++) {
								l.push(g[j].get(b));
							}
							Ext.Ajax.request({
										waitMsg : "正在删除数据，请稍后...",
										url : d,
										params : {
											idProperty : b,
											table : f,
											ids : l
										},
										success : function(v){
											h();
										}
									});
						}
					});
		},
		saveOrUpdatex : function(e, d, c, f, b) {
			b = b || "id";
			if(!d){
				Ext.Msg.showTop("保存url不能为空。");
			}
			var h = c || function() {
				Ext.Msg.hide();
				e.getPagging().doRefresh();
				Ext.Msg.showTop("保存成功。");
			};
			var g = e.getSelectionModel().getSelection();
			var a = g.length;
			if (a == 0) {
				
				Ext.Msg.showTop("请选择要保存的数据。");
				return;
			}
			var json = [];
						
			for(i=0;i<g.length;i++){
				json.push(g[i].data);
			}
			Ext.Ajax.request({
				waitMsg : "正在保存数据，请稍后...",
			    url: d,
			    jsonData:json,
			    success: function(response){
			        h();
			    }
			});
		},
		indexOf : function(e, c, d) {
			d = d || "ID";
			var a = c.getStore();
			for (var b = 0; b < a.count(); b++) {
				if (a.getAt(b).get(d) == e.get(d)) {
					return b;
				}
			}
			return -1;
		},
		changeRecord : function(g, f, l, h) {
			var b = function(o) {
				if (h) {
					var m = h.length;
					for (var n = 0; n < m; n++) {
						if (o == h[n]) {
							return true;
						}
					}
				}
				return false;
			};
			var a = null;
			if (l) {
				a = l;
			} else {
				a = [];
				var d = g.getData();
				for (var j in d) {
					a.push(j);
				}
			}
			var e = a.length;
			for (var c = 0; c < e; c++) {
				if (b(a[c])) {
					continue;
				}
				var k = g.get(a[c]);
				g.set(a[c], f.get(a[c]));
				f.set(a[c], k);
			}
		},
		upMove : function(b, e, g, a, f) {
			var d = e.getStore().first();
			if (b.get(g) == d.get(g)) {
				Ext.Msg.alert("提示", "所选择的记录已经是第一条了！");
				return;
			}
			var c = Fanfan.Tools.grid.indexOf(b, e, g) - 1;
			var h = e.getStore().getAt(c);
			Fanfan.Tools.grid.changeRecord(h, b, a, f);
			e.getSelectionModel().select(c, false);
		},
		downMove : function(b, c, f, a, d) {
			var g = c.getStore().last();
			if (b.get(f) == g.get(f)) {
				Ext.Msg.alert("提示", "所选择的记录已经是最后一条了！");
				return;
			}
			var h = Fanfan.Tools.grid.indexOf(b, c, f) + 1;
			var e = c.getStore().getAt(h);
			Fanfan.Tools.grid.changeRecord(e, b, a, d);
			c.getSelectionModel().select(h, false);
		},
		calculateIndex : function(c, d) {
			var a = c.getStore();
			for (var b = 1; b <= a.count(); b++) {
				var e = a.getAt(b - 1);
				e.set(d, b);
			}
		}
	},
	
 //文件上传类型验证
 checkFileExt : function(extstr,exg)
	{
	    var extstr = extstr.substring(extstr.lastIndexOf(".")).toLowerCase();
	    if (!extstr.match(exg)) {
	        return false;
	    }
	    return true;
	}
};
Fanfan.tools = Fanfan.Tools;