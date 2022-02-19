<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(function(){
		$("#btnWrite").click(function(){
			location.href = "/spring04/board/write";
		});
	});
	function list(page){
		location.href = "/spring04/board/list?cur_page="+page+"&search_option=${map.search_option}&keyword=${map.keyword}";
	}
</script>
</head>
<body>
<%@ include = file = "../include/menu.jsp" %>
<h2>게시판</h2>
<form name = "form1" method = "post" action = "/spring04/board/list">
	<select name = "search_option">
		<option value = "all" <c:out value = "${map.search_option == 'all' ? 'selected' : '' }"/> >이름+내용+제목</option>
		<option value = "name" <c:out value = "${map.search_option == 'name' ? 'select' : '' }"/> >이름
		<option value = "contents" <c:out value = "${map.search_option == 'contents' ? 'selected' : ''}"/> > 내용</option>
		<option value = "title" <c:out value = "${map.search_option == 'title' ? 'selected' : '' }"/> > 제목</option>
	</select>
	<input type = "keyword" value = "${map.keyword }">
	<input type = "submit" value = "조회">
	<!--  로그인 상태이면 글쓰기 버튼 표시함  -->
	<c:if test = "${sessionScope.userid != null }">
		<button type = "button" id = "btnWrite">글쓰기</button>
	</c:if>
</form>
${map.count}개의 게시물이 있습니다.
<table border = "1" width = "600px">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>이름</th>
		<th>날짜</th>
		<th>조회수</th>
	</tr>
	<c:forEach var= "row" items = "${map.list}">
	<tr>
		<td>${row.idx}</td>
		<td><a href = "/spring04/board/detail?idx = #{row.idx}&cur_page=#{map.page_info.curPage}&search_option=${map.search_option}&keyword=${map.keyword}">${row.title}</a>
		<c:if test = "${row.cnt > 0 }"> <!--  댓글 갯수가 0보다 크면 아래에 span 표시 , 댓글이 0이면 굳이 표시할 이유는 없으니  -->
			<span style = "color:red">(${row.cnt})</span>
		</c:if>
		</td>
		<td>${row.name}</td> <!--  작성자 이름  -->
		<td><fmt : formatDate value = "${row.regdate}" pattern = "yyyy-MM-dd HH:mm:ss"/></td> <!-- 날짜  -->
		<td>${row.hit}</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan = "5" align = "center">
			<c:if test = "${map.pege_info.curBlock > 1 }">
				<a href = "javascript:list('1')">[처음]</a>
			</c:if>
			<c:if test = "${map.page_info.curBlock > 1 }">
				<a href = "javascript:list('${map.page_info.prevPage}}')">[이전]</a>
			</c:if>
			<c:forEach var = "num" begin = "${map.page_info.blockBegin}" end = "${map.page_info.blockEnd}" > <!--  시작 페이지부터 끝 페이지 번호  -->
				<c:choose>
					<c:when test = "${num == map.page_info.curPage}"><!-- 현재 페이지하면 하이퍼링크 생략 -->
						<span style = "color:red">${num}</span>&nbsp;
					</c:when>
					<c:otherwise>
						<a href = "javascript:list('${num}')">${num}</a>&nbsp;
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test = "${map.page_info.curBlock <= map.page_info.totBlock}">
				<a href = "javascript:list('${map.page_info.nextPage}')">[다음]</a>
			</c:if>
			<c:if test = "${map.page_info.curPage <= map.page_info.totPage}">
				<a href = "javascript:list('${map.page_info.totPage}')">[끝]</a>
			</c:if>
	</tr>
</table>
</body>
</html>