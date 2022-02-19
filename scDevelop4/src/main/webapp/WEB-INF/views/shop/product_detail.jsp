<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<h2>상품정보</h2>
<table>
	<tr>
		<td><img src = "/ex/images/${dto.filename}" width = "300px" height = "300px">
		<td align = "center">
			<table>
				<tr>
					<td>상품명</td>
					<td>${dto.product_name}</td>
				</tr>
				<tr>
					<td>가격</td>
					<td>${dto.price}</td>
				</tr>
				<tr>
					<td>$nbsp;</td>
					<td>${dto.description}</td>
				</tr>
				<tr>
					<td colspan = "2">
						<form name = "form1" method = "post" action = "/ex/shop/cart/insert">
							<input type = "hidden" name = "product_code" value = "${dto.product_code}">
							<select name = "amount">
								<c:forEach begin = "1" end = "10" var = "i">
									<option value = "${i}">${i}</option>
								</c:forEach>
							</select>&nbsp;개
							<input type = "submit" value = "장바구니에 담기">
						</form>
						<a href = "/ex/shop/product/list">상품목록</a>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>