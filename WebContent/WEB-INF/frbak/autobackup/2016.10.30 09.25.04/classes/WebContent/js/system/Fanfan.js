var Fanfan = Fanfan || {};
var fan = Fanfan;
var fn = fan;
fn.INFO = "info";
fn.WARN = "warn";
fn.ERROR = "error";
fn.base = {
	author : "huan.gao",
	qq : "2223486623"
};
fn.main = {};
fn.isArray = function(a) {
	return a && typeof (a) === "object" && typeof (a.length) === "number"
			&& typeof (a.splice) === "function"
			&& !(a.propertyIsEnumerable("length"));
};
fn.imports = function(c, b, f) {
	var e = function(k) {
		var o = false;
		var q = k.split(".");
		var g = "";
		var m = q.length;
		for ( var l = 0; l < m; l++) {
			if (l == (m - 1)) {
				g += q[l];
			} else {
				g += q[l] + "/";
			}
		}
		g += ".js";
		var n = document.getElementsByTagName("head").item(0);
		var p = n.childNodes.length;
		for ( var l = 0; l < p; l++) {
			var h = n.childNodes[l];
			if (h && h.type == "text/javascript" && h.path == g) {
				if (o) {
					n.removeChild(h);
					break;
				} else {
					if (f) {
						f();
					}
					return;
				}
			}
		}
		var j = null;
		if (window.ActiveXObject) {
			j = new ActiveXObject("MsXml2.XmlHttp");
		} else {
			j = new XMLHttpRequest();
		}
		j.onreadystatechange = function() {
			if (j.readyState == 4) {
				if (j.status == 200) {
					var i = document.createElement("script");
					i.type = "text/javascript";
					i.text = j.responseText;
					i.path = g;
					n.appendChild(i);
					if (f) {
						f();
					}
				} else {
					alert("加载js[" + g + "]出错: " + j.statusText + " ("
							+ j.status + ")");
				}
			}
		};
		b = b || false;
		j.open("GET", g, b);
		j.send(null);
	};
	if (fn.isArray(c)) {
		var a = c.length;
		for ( var d = 0; d < a; d++) {
			e(c[d]);
		}
	} else {
		e(c);
	}
};
fn.importCss = function(b) {
	var d = function(g) {
		var m = false;
		var o = g.split(".");
		var e = "";
		var j = o.length;
		for ( var h = 0; h < j; h++) {
			if (h == (j - 1)) {
				e += o[h];
			} else {
				e += o[h] + "/";
			}
		}
		e += ".css";
		var l = document.getElementsByTagName("head").item(0);
		var n = l.childNodes.length;
		for ( var h = 0; h < n; h++) {
			var f = l.childNodes[h];
			if (f && f.type == "text/css" && f.path == e) {
				if (m) {
					l.removeChild(f);
					break;
				} else {
					return;
				}
			}
		}
		var k = document.createElement("link");
		k.type = "text/css";
		k.rel = "stylesheet";
		k.href = e;
		k.path = e;
		l.appendChild(k);
	};
	if (fn.isArray(b)) {
		var a = b.length;
		for ( var c = 0; c < a; c++) {
			d(b[c]);
		}
	} else {
		d(b);
	}
};
fn.analyseUrl = function(c, o) {
	var h = c.trim();
	var j = h.indexOf("?");
	var q = null;
	var f = null;
	if (j >= 0) {
		q = h.substring(0, j);
		try {
			f = h.substring(j + 1);
		} catch (n) {
		}
	} else {
		q = h;
	}
	var l = q.indexOf(".");
	var g = q.substring(0, l);
	var b = q.substring(l + 1);
	var r = {
		action : g,
		method : b,
		paramString : f
	};
	if (o && f) {
		var a = f.split("&");
		if (a) {
			var d = {};
			var m = a.length;
			for ( var k = 0; k < m; k++) {
				var p = a[k].split("=");
				try {
					d[p[0]] = p[1];
				} catch (n) {
				}
			}
			r.paramJson = d;
		}
	}
	return r;
};
//fn.imports("scripts.common.js-ext", true);
fn.imports("js.system.Extjs", true);
fn.imports("js.system.StoreFactory", true);
fn.imports("js.system.Tools", true);
//fn.imports("system.common.System", true);
//fn.imports("scripts.My97DatePicker.WdatePicker", true, function() {
//	if (!window.ActiveXObject) {
//		WdatePicker( {
//			dateFmt : "yyyy"
//		});
//	}
//});

fn.getDictValue = function(path) {
	
	var result = "";
	Ext.Ajax.request({
		
	    url: 'system/getDictValue.action',
	    method:'GET',
	    async: false,//同步请求
	    params: {
			path:path
	    },
	        
       	success : function(response){
       		
    		var data = response.responseText;
	    	data = Ext.JSON.decode(data);
	    	result = data.value;
        }
	});
	
	return result;
};
//fn.getDictNodes = function(a) {
//	this.get(a);
//	return Constants[a + ".nodes"];
//};
fn.getDictStore = function(h, g) {
	
	var result = null;
	Ext.Ajax.request({
		
	    url: 'system/getDictStore.action',
	    method:'GET',
	    async: false,//同步请求
	    params: {
			path:h
	    },
	        
       	success : function(response){
       		
    		var data = response.responseText;
	    	data = Ext.JSON.decode(data);
	    	
       		var a = [];
	    	for(i=0;i<data.length;i++){
	    		if (g === "int") {
					a.push( [ parseInt(data[i].dataId), data[i].value ]);
				} else {
					if (g === "boolean") {
						if (data[i].dataid.trim() == "true") {
							a.push( [ true, data[i].value ]);
						} else {
							a.push( [ false, data[i].value ]);
						}
					} else {
						a.push( [ data[i].dataId, data[i].value ]);
					}
				}
	    	}
	    	result = Ext.create("Ext.data.ArrayStore", {
					fields : ["value", "text"],
					data : a
				});
        }
	});
	
	return result;
};
//fn.getUserExtValue = function(c) {
//	var e = this.base.userexts;
//	if (e) {
//		var a = e.length;
//		for ( var d = 0; d < a; d++) {
//			var b = e[d];
//			if (b.FNAME === c) {
//				return b.FVALUE;
//			}
//		}
//	}
//};

//权限验证
fn.checkAuth = function(a, b) {
	Ext.Ajax.request( {
		url : "system/checkSystemAuth.action",
		params : {
			authPath : a
		},
		success : function(d) {
			var c = Ext.decode(d.responseText);
			if (b) {
				b(c);
			}
		}
	});
};

//下载本地文件
fn.downloadLocalFile = function(path,fileName) {
	window.open('system/download.action?filePath='+path+'&fileName='+fileName);
};

fn.removeImport = function(k, e) {
	var g = e || "js";
	var j = k.split(".");
	var a = "";
	var d = j.length;
	for ( var c = 0; c < d; c++) {
		if (c == (d - 1)) {
			a += j[c];
		} else {
			a += j[c] + "/";
		}
	}
	a += "." + g;
	var f = document.getElementsByTagName("head").item(0);
	var h = f.childNodes.length;
	for ( var c = 0; c < h; c++) {
		var b = f.childNodes[c];
		if ("js" == g) {
			if (b && b.type == "text/javascript" && b.path == a) {
				f.removeChild(b);
				break;
			}
		} else {
			if (b && b.type == "text/css" && b.path == a) {
				f.removeChild(b);
				break;
			}
		}
	}
};