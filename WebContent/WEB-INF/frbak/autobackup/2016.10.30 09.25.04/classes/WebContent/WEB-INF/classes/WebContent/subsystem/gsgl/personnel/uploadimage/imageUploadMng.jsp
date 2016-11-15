<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE HTML>
<html>
 <head>
  <title>图片上传管理测试</title>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="<%=path %>/subsystem/gsgl/personnel/uploadimage/imageUploadMng.js"></script>
<style>
.tdValign{vertical-align:middle}
</style>
 </head>
 <body>
	<div style="width:100%; height:100%" id="imageUploadMng.viewImageUploadMng"></div>
 </body>
</html>