<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		$("#btnAdd").click(function(){
			location.href = "/ex/shop/product/write";
		});
	});
</script>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<h2>상품 목록</h2>
<c:if test = "${sessionScope.admin_userid != null}">
	<button type = "button" id = "btnAdd">상품등록</button>
</c:if>
	<table border = "1" width = "500px">
		<tr>
			<td>상품ID</td>
			<td>&nbsp;</td>
			<td>상품명</td>
			<td>가격</td>
		</tr>
		<c:forEach var = "row" items = "${list}">
			<tr>
				<td>${row.product_code}</td>
				<td><img src = "/ex/images/${row.filename}" width = "100px" height = "100px"></td>
				<td><a href = "/ex/shop/product/detail/${row.product_code}">${row.product_name }</a> <!--  상품 이름 클릭하면 상세보기로 이동  -->
				<c:if test= "${sessionScope.admin_userid != null}">
					<br>
					<a href = "/ex/shop/product/edit/${row.product_code}">[편집]</a> <!--  edit/2 면 2는 row.product_code임  -->
					<!--  @RequestMapping("edit/{product_code}" @PathVariable("product_code")int product_code 컨트롤러 경로로 이동해서 편집기능 수행  -->
				</c:if></td>
				<td><fmt:formatNumber value = "${row.price}" pattern = "#,###"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>