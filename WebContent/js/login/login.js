// JavaScript Document
//支持Enter键登录
		document.onkeydown = function(e){
			if($(".bac").length==0)
			{
				if(!e) e = window.event;
				if((e.keyCode || e.which) == 13){
					var obtnLogin=document.getElementById("submit_btn")
					obtnLogin.focus();
				}
			}
		}

    	$(function(){
			//提交表单
			$('#submit_btn').click(function(){
//				var remmber = document.getElementById('j_remember').checked;
				show_loading();
				
				if($('#loginname').val() == ''){
					show_err_msg('请输入用户名！');	
					$('#loginname').focus();
				}else if($('#password').val() == ''){
					show_err_msg('密码还没填呢！');
					$('#password').focus();
				}else{
					//ajax提交表单，#login_form为表单的ID。 如：$('#login_form').ajaxSubmit(function(data) { ... });
					$.ajax({                           
				 	 	
				 	 	type: "POST",                          
				 	 	url: "system/login.action",                           
				 	 	dataType:"json",                          
				 	 	data:{loginName:$('#loginname').val(),password:$('#password').val()},//,REMEMBER:remmber},                          
				 	 	success : function(data){ 
				 	 		
				 	 		if(data){
				 	 			
				 	 			if(!data.success){
				 	 				show_err_msg(data.msg);
				 	 				return;
				 	 			}
				 	 		
				 	 		}
				 	 		show_msg("登陆成功，正在跳转到主页面...",'main.jsp');
//			 	 			show_err_msg(JSON.stringify(data));
			            },  
			            error : function(data){  
			                show_err_msg("服务器内部错误，请联系管理员！");
				 	 	}
				 	 });
					
					//show_msg('登录成功咯！  正在为您跳转...','/');	
				}
			});
		});