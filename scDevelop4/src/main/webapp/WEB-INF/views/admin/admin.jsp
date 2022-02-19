<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "../include/header.jsp" %>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<c:if test = "${message == 'success' }">
<h2>
	${sessionScope.admin_name}
	(${sessionScope.admin_userid})님 환영합니다.
</h2>
</c:if>
</body>
</html>