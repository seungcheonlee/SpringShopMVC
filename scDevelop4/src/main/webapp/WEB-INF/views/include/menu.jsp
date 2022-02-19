<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<a href = "/ex/upload/input">파일 업로드 테스트</a>
<a href = "/ex/memo/list">한줄메모장</a>
<a href = "/ex/shop/product/list">상품목록</a>
<a href = "/ex/board/list">게시판</a>
<a href = "/ex/chart/char1.do">구글차트(json)</a>
<a href = "/ex/chart/char2.do">구글차트(db)</a>
<c:if test = "${sessionScope.admin_userid != null }">
	<a href = "/ex/shop/product/write">상품등록</a>
</c:if>
<a href = "/ex/shop/cart/list.do">장바구니</a>

<div style = "text-align : right;">
	<c:choose>
		<c:when test = "${sessionScope.userid == null}">
			<a href = "/ex/member/login">로그인</a>
			<a href = "/ex/admin/login">관리자 로그인</a>
		</c:when>
		<c:otherwise>
			${sessionScope.name}님이 로그인중입니다.
			<a href = "/ex/member/logout">로그아웃</a>
			<a href = "/ex/admin/logout">관리자 로그아웃</a>
		</c:otherwise>
	</c:choose>
</div>
<hr style = "height:5px;background:yellow;">