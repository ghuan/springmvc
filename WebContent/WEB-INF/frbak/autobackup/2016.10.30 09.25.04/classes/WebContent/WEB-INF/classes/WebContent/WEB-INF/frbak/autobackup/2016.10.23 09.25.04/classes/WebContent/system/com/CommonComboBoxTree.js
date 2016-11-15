/**
 *  基于Extjs4的异步下拉树控件
 *  author: huan.gao
 *  用法:
    
	下拉单选树例子
	{
		//基本属性设置
		xtype :'commoncomboboxtree',
		fieldLabel:'组织机构',
		name:'orgId',
		editable: true,							//是否可编辑，默认为false
		allowBlank : false,						//是否允许为空，默认为true
		
		//树的属性设置
		url : 'org/getOrg.action',				//treestore的url
		model:'system.model.Org',				//treestore的model
		expandAll : false,						//树初始化是否展开全部，默认为false
		rootId : 'root',						//treestore的root id，默认为root
		rootText : orgRootText,					//treestore的root name，默认为root
		rootVisible : true,						//是否显示根节点，默认为false
		displayField : 'name',					//显示值的映射,默认为text
		multiCascade:false,						//是否多选，默认false
		multiSelect : false,					//多选时是否级联选择，默认为true
		
		//树的模糊查询设置
		allowQuery : true,						//是否允许模糊查询，默认为false
		queryUrl : 'org/getOrgByPath.action'	//模糊查询url，前提allowQuery为true,默认传参名queryText,queryValue，返回json串需包含path字段名，path值为'/'隔开的树节点id值
												//如'/1/934c35317bf349b9abc5e743ff8ed034'
	}
	
	说明：
	1)注意单选时加载的store的对象串中不要有checked字段，多选时加载的store的对象串中一定要有checked字段;
	2)multiSelect属性不写默认是false，是单选;设定为true时是多选;
	3)multiCascade属性不写默认是true,代表多选时是否级联选择;设定为false时不级联选择;
	4)treeHeight属性是指下拉树层的高度，不写默认是300;
	
	常用方法:
	
	清除当前值
	ctree.clearValue();
	
	获得当前选中的提交值
	ctree.getSubmitValue();
	
	获得当前选中的显示值
	ctree.getDisplayValue();
	
	单选时获得当前选中的对应树节点的JSON值
	ctree.getEleJson();
	
	设置控件默认值
	单选默认值('树节点id值','树节点text显示值')
	ctree.setDefaultValue('4100000000021119950','北京');
	多选默认值('逗号隔开的树节点id值','逗号隔开的树节点text显示值')
	ctree.setDefaultValue('4100000000021119950,4100000000021119951','北京,上海');
	
	设置控件自动展开定位或选中
	单选展开定位('树上的节点路径')
	ctree.setPathValue('/root/4100000000021119950');
	多选展开选中
	var pathArray = [];
	pathArray[0] = '/root/4100000000021119950';
	pathArray[1] = '/root/4100000000021119951';
	ctree.setPathArray(pathArray);
	
 */
Ext.define('system.com.CommonComboBoxTree',{
	extend : 'Ext.form.field.Picker',
	requires : ['Ext.tree.Panel'],
	alias : ['widget.commoncomboboxtree'],
	multiSelect : false,
	multiCascade:true,
	submitValue:'',
	pathValue:'',
	pathText:'',
	pathArray:[],
	localRecords : null,
	initComponent : function(){
		var self = this;
		Ext.apply(self,{
			fieldLabel : self.fieldLabel,
			labelWidth : self.labelWidth     
		});
		self.callParent();
	},
	createPicker:function(){
		var self = this;
		//fn.imports(self.model);
		var store = Ext.create("Ext.data.TreeStore", {
			model : self.model,
			autoLoad : true,
			proxy : {
				type : "ajax",
				url : self.url,
				reader : {
					type : "json",
					idProperty : self.idProperty || "id",
					clearOnLoad : true
				}
			},
			root : {
				id : self.rootId || "root",
				name : self.rootText || "root",
				state : self.STATE || 1
			} 
		});
		if (self.multiSelect) {//如果是多选，则添加选择框
		
			var treeRoot = store.getRootNode();
			if(treeRoot){
				treeRoot.set('checked',false);
			}
			store.on('load',function(th, node, records, successful, eOpts){
	             Ext.Array.each(records, function(rec) {
		    		rec.set('checked',false);
		    	});
	    	});
		}
		
		  
		var bbar = Ext.create("Ext.toolbar.Toolbar", {
				items : ['->',{
							text : "确定",
							iconCls : "Tick",
							handler : function() {
								self.collapse();
							}
						},{
							text : "重置",
							iconCls : "Reload",
							handler : function() {
								self.clearValue();
							    
							}
						},'->']
				});
		if (!self.multiSelect){//如果是单选树，则隐藏bbar
			bbar.hide();
		}
		
		self.picker = Ext.create('Ext.tree.Panel',{
			height : self.treeHeight==null?300:self.treeHeight,
			autoScroll : true,
			floating : true,
			focusOnToFront : false,
			bbar : bbar,
			shadow : true,
			ownerCt : this.ownerCt,
			useArrows : true,
			columns : self.columns,
			store : store,
			displayField : self.displayField || 'text',
			rootVisible : self.rootVisible || false,
			constructor : function(a) {

				a = a || {};
				this.displayField = a.displayField || this.displayField;
				this.getConfig = function() {
					return a;
				};
				this.callParent(arguments);
			},
			viewConfig: {
				onCheckboxChange: function(e,t) {
				}
			}
		});
		self.picker.on({
			itemclick: function (view,record,item,index,e,object) {
				if (!self.multiSelect) {//单选树
					
					self.submitValue = record.get('id');
					self.setValue(record.get(self.displayField || 'text')); 
					self.eleJson = Ext.encode(record.raw);
					self.pathText = self.getValue();
					self.collapse();    
				}else {
					
				if (self.multiSelect) {//多选树
					
						if (item) {
							var check = !record.get('checked');
							record.set('checked',check);
							if(self.multiCascade){
								if (check) {
									record.bubble(function(parentNode) {
										if ('root' != parentNode.get(self.displayField || 'text')) {
											parentNode.set('checked',true);
										}
									});
									record.cascadeBy(function(node) {
										node.set('checked',true);
										node.expand(true);
									});
								} else {
									record.cascadeBy(function(node) {
										node.set('checked',false);
									});
									record.bubble(function(parentNode) {
										if ('root' != parentNode.get(self.displayField || 'text')) {
											var flag = true;
											for (var i = 0; i < parentNode.childNodes.length; i++) {
												var child = parentNode.childNodes[i];
												if(child.get('checked')){
													flag = false;
													continue;
												}
											}
											if(flag){
												parentNode.set('checked',false);
											}
										}
									});
								}
							}
						}
						var records = view.getChecked(), names = [], values = [];
				    	Ext.Array.each(records, function(rec) {
				    		
				    		if(rec.get('id') != (self.rootId || "root")){//根节点除外
				    		
				    			names.push(rec.get(self.displayField || 'text'));
				    			values.push(rec.get('id'));
				    		}
				    	});
				    	self.submitValue = values.join(',');
				    	self.setValue(names.join(','));
				    	self.pathText = names.join(',');
					}
				}
			},
			cellkeydown: function( a, td, cellIndex, record, tr, rowIndex, e, eOpts ){
				var rc = record;
				if (e.getKey()==Ext.EventObject.ENTER){
						if (!self.multiSelect) {
							
							self.submitValue = rc.get('id');
							self.setValue(rc.get(self.displayField || 'text')); 
							self.eleJson = Ext.encode(rc.raw);
							self.pathText = self.getValue();
							self.collapse();    
						}
					}
			},
        show : function(a,b){
        	
			var picker = self.getPicker();
			if(self.expandAll){
			
				picker.expandAll();
			}
			if(self.pathText != self.getValue()){//输入条件改变
					self.pathText = self.getValue();
					self.queryByPath();
				}
		}
		});
		return self.picker;
	},
	listeners:{
		expand : function(field,eOpts){
		},
		specialkey:function(field,e){  
			
                if (e.getKey()==Ext.EventObject.ENTER){
                	if(field.getValue() != ''){
					
						if(this.pathText != field.getValue()){//输入条件改变
							this.pathText = field.getValue();
							this.queryByPath();
						}
					}
             	}     
        }
	},
	clearValue : function() {
		this.setDefaultValue('','');
		this.pathText = '';
		if(this.multiSelect){
			Ext.Array.each(this.getPicker().getView().getChecked(), function(rec) {
	    		rec.set('checked',false);
	    	});
		}
	},
	getEleJson : function() {
		if(this.eleJson == undefined){
			this.eleJson = [];
		}
		return this.eleJson;
	},
	getSubmitValue : function() {
		if(this.submitValue == undefined){
			this.submitValue = '';
		}
		return this.submitValue;
	},
	getDisplayValue:function(){
		if(this.value == undefined){
			this.value = '';
		}
		return this.value;
	},
	setPathValue:function(pathValue){
		this.pathValue = pathValue;
	},
	setPathText:function(pathText){
		this.pathText = pathText;
	},
	setPathArray:function(pathArray){
		this.pathArray = pathArray;
	},
	setDefaultValue:function(submitValue,displayValue){
		this.submitValue = submitValue;
		this.setValue(displayValue);
		this.eleJson = undefined;
		this.pathArray = [];
	},
	alignPicker:function(){
		var me = this, picker, isAbove, aboveSfx = '-above';
		if (this.isExpanded){
			picker = me.getPicker();
			if (me.matchFieldWidth){picker.setWidth(me.bodyEl.getWidth());}
			if (picker.isFloating()){
				picker.alignTo(me.inputEl, "", me.pickerOffset);// ""->tl
				isAbove = picker.el.getY() < me.inputEl.getY();
				me.bodyEl[isAbove ? 'addCls' : 'removeCls'](me.openCls+aboveSfx);
				picker.el[isAbove ? 'addCls' : 'removeCls'](picker.baseCls+aboveSfx);
			}
		}
	},
	queryByPath : function(){
		if(this.allowQuery){
        	var picker = this.getPicker();
        	var isMultiSelect = this.multiSelect;
        	var isMultiCascade = this.multiCascade;
			this.expand();
        	Ext.Ajax.request({
			waitMsg : "正在查询，请稍后...",
			url : this.queryUrl || this.url,
			params : {
				queryText : this.pathText,
				queryValue : this.submitValue
			},
			success : function(h) {
				
				Ext.Msg.hide();
				var f = Ext.JSON.decode(h.responseText);
				if (f.length != 0) {
					var len = f.length;
					var j = [];
					if(isMultiSelect){
					
						self.localRecords = picker.getView().getChecked();
				    	Ext.Array.each(self.localRecords, function(rec) {
				    		rec.set('checked',false);
				    	});
					}
					for (var g = 0; g < len; g++) {
						picker.expandPath('/'+(this.rootId || 'root') + f[g].path,'id','/',function(bSucess,oLastNode){
							
							if (!isMultiSelect) {//如果是单选则选中
								picker.getSelectionModel().select(oLastNode);
							}else{//如果是多选，则设置checked为true
								
								
								if(oLastNode.get('id') != (this.rootId || 'root')){
									oLastNode.set('checked',true);
								}
								if(isMultiCascade){
									if(oLastNode.parentNode!=null){//如果有父节点,则选中
									
										if(oLastNode.parentNode.get('checked') == false){
										
											oLastNode.parentNode.set('checked',true);
										}
									}
								}
								
							}
							
						});
						
					}     
					//picker.focus(false,100);
				}
				
			}
		});
	}
	}
});