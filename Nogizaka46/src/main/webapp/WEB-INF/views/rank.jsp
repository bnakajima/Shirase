<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ランキング画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body style="background-color:#EE82EE;">
	<%
		int i = 1;
	%>
	<div class="center">
		<h1>ランキング</h1>
		<form:form action="index" modelAttribute="quiz">
			<table class="table table-hover">
				<tr class="active">
					<th class="text-center">順位</th>
					<th class="text-center">名前</th>
					<th class="text-center">ポイント</th>
				</tr>
				<c:forEach var="rank" items="${rank}">

					<tr class="info">
						<td><%=i++%>位</td>
						<td>${ rank.name}</td>
						<td>${ rank.point}</td>

					</tr>
				</c:forEach>
			</table>
			<button type='submit' class="btn btn-default">TOPへ戻る</button>
		</form:form>
	</div>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
