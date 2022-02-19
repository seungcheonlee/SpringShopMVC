<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	iframe{
		width : 400px;
		height : 200px;
		border; 1px;
		border-style : solid;
	}
</style>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<!--  enctype="multipart/form-data" 파일첨부 -->
<form action = "/ex/upload/upload" method = "post" enctype = "multipart/form-data" target = "iframe1">
	<input type = "file" name = "file">
	<input type = "submit" value = "업로드">
</form>
<iframe name = "iframe1"></iframe> <!--  웹페이지 속에 있는 또 다른 웹페이지  -->
</body>
</html>