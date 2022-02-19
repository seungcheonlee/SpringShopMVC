<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src = "https://www.google.com/jsapi"></script>
<script>
	//차트 라이브러리 로딩
	google.load("visualization", "1", {"packages":["corechart"]});
	//라이브러리 로딩이 완료되면 실행할 함수 지정
	google.setOnLoadCallback(drawChart);
	function drawChart(){
		var jsonData = $.ajax({
			url : "/ex/json/sample.json",
			dataType : "json",
			async : false
		}).responseText;
		var data = new google.visualization.DataTable(jsonData);
		var chart  = new google.visualization.PieChart(document.getElementById("chart_div"));
		chart.draw(data, {title:"차트 예제", width : 600, height : 400});
	}
</script>
</head>
<body>
<%@ include file = "../include/menu.jsp" %>
<div id = "chart_div"></div>
<button id = "btn" type = "button" onclick = "drawChart()">refresh</button>
</body>
</html>