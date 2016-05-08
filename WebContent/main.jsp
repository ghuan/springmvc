<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.fanfan.system.vo.LoginInfo"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="com.fanfan.system.util.VTools"%>
<%@page import="net.sf.json.JSONArray"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
LoginInfo loginInfo = (LoginInfo)request.getSession().getAttribute("loginInfo");
%>
<!DOCTYPE HTML>
<html>
 <head>
  <title> 后台管理系统</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <link id="_systemTheme" rel="stylesheet" type="text/css" href="<%=path %>/js/extjs-4-2-1/resources/css/ext-all.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/js/extjs-4-2-1/resources/css/ext-patch.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/js/extjs-4-2-1/resources/css/icon.css">
	<script type="text/javascript" src="<%=path %>/js/extjs-4-2-1/ext-all.js"></script>
	
	<script type="text/javascript" src="<%=path %>/js/extjs-4-2-1/locale/ext-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=path %>/js/system/Fanfan.js"></script>
	<script type="text/javascript" src="<%=path %>/js/login/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="<%=path %>/system/main.js"></script>
 
 <script type="text/javascript">
		
		//注册当前登录者以及系统相关信息
		<%
			if(loginInfo == null){
	
				out.print("alert('对不起，您的登录信息已失效，请重新登录系统！');window.location='login.html';");
			}else{
		%>
				fn.base.basePath = '<%=basePath%>';
				fn.base.path = '<%=path%>';
				fn.base.user = <%=JSONObject.fromObject(loginInfo.getUser()).toString()%>;
				fn.base.org = <%=loginInfo.getOrg() == null ? "{}" : JSONObject.fromObject(loginInfo.getOrg()).toString()%>;
				fn.base.roles = <%=VTools.ListIsEmpty(loginInfo.getRoles()) ? "[]" : JSONArray.fromObject(loginInfo.getRoles()).toString()%>;
				fn.base.subsystem = <%=VTools.ListIsEmpty(loginInfo.getSubsystem()) ? "[]" : JSONArray.fromObject(loginInfo.getSubsystem()).toString()%>;
				fn.base.userexts = <%=VTools.ListIsEmpty(loginInfo.getUserExts()) ? "[]" : JSONArray.fromObject(loginInfo.getUserExts()).toString()%>;
		<%
			}
		%>
</script>
 
 </head>
 <body>

 </body>
</html>