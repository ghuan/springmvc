Ext.onReady(function() {

	var divid = "log.viewLog";
	var height = document.getElementById(divid).offsetHeight;
	var width = document.getElementById(divid).offsetWidth;

	//标签页
	var logTab = Ext.create("Ext.tab.Panel", {
		activeTab : 0,
		border : false,
		region : "center",
		autoScroll : true,
		items : [{
			title : "<div>操作日志</div>",
			autoScroll : true,
			border : 0,
			layout : "fit",
			bodyStyle : "padding:0px",
			items : [Ext.create('system.operationLogGrid', {
                width : width,
                height : height
            })]
		},{
		title : "<div>异常日志</div>",
			autoScroll : true,
			border : 0,
			layout : "fit",
			bodyStyle : "padding:0px",
			items : [Ext.create('system.errorLogGrid', {
                width : width,
                height : height
            })]
	}]
	});

	var viewPanel = Ext.create('Ext.Panel', {

		width: width,
		height: height,
		renderTo : divid,
		border : false,
		layout:'border',
		items:[logTab]
	});
});
tabPanel.setLoading(false);