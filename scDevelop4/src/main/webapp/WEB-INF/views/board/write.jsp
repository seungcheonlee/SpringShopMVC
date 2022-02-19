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
		$(".fileDrop").on("dragenter dragover", function(e){
			e.preventDefault();
		});
	})$(".fileDrop").on("drop", functiomn(e){
		e.preventDefault();
		var files = e.originalEvent.dataTransfer.files;
		var file = files[0];
		var form_data = new FormData();
		form_data.append("file", file);
		$.ajax({
			uri : "/ex/upload/ajax_upload",
			data : form_data,
			processData : false,
			contentType : false,
			type : "post",
			success : function(data){
				var fileInfo = getFileInfo(data);
				var html = "<a href = ''+fileInfo.getLink"'>"+fileInfo.original_name+"</a><br>";
				html+="<input type = 'hidden' name = 'files' value = '"+fileInfo.file_name+"'>";
				$("#uploadedList").append(html);
			}
		});
	});
	$("#btnSave").click(function(){
		var title = document.form1.title.value;
		if(title == ""){
			alert("제목을 입력하세요.");
			document.form1.title.focus();
			return;
		}
		document.form1.submit();
	});
	});
	function getFileInfo(file_name){
		var fileLink = file_name.substr(12);
		var get_link = "/ex/upload/displayFile?file_name="+file_name;
		original_name = fileLink.substr(fileLink.indexOf("_")+1);
		return {original_name : original_name, get_link, file_name : file_name};
	}
</script>
<style>
	.fileDrop{
		width : 600px;
		height :100px;
		border : 1px dotted gray;
		background-color : gray;
	}
</style>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<h2>게시물 작성</h2>
<form id = "form1" name = "form1" method = "post" action = "/ex/board/insert">
	<div>제목<input name = "title" id = "title" size = '80' placeholder = "제목을 입력하세요."></div>
	<div style = "width:800px">내용
	<textarea rows = "5" cols = "80" id = "contents" name = "contents"></textarea>
	</div>
	<div>첨부파일 등록
		<div class = "fileDrop"></div>
		<div id = "uploadList"></div>
	</div>
</form>
</body>
</html>