<%@page import="java.util.ArrayList"%>
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
<title>リザルト画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body style="background-color:#EE82EE;">
	<%
		int i = 1;
	%>

	<form:form action="detail" modelAttribute="quiz">
		<div class="center">
			<h1>クイズ結果</h1>

			<table class="table table-hover">
				<tr class="active">
					<th class="text-center">問題番号</th>
					<th class="text-center">あなたの回答</th>
					<th class="text-center">結果</th>
					<th class="text-center">問題詳細</th>
				</tr>
				<c:forEach var="list" items="${sessionScope.answer}">
					<c:if test="${list.judge.equals('〇')}" var="flg" />
					<c:if test="${flg}">
						<tr class="success">
					</c:if>
					<c:if test="${!flg}">
						<tr class="danger">
					</c:if>
					<td><%=i++%>問目</td>
					<td>${ list.answertitle}</td>
					<td>${ list.judge}</td>
					<td><button type="submit" name="id"
							value="${ list.question_id}" class="btn btn-default">答えを確認する</button></td>

					</tr>
				</c:forEach>
			</table>
			<input type="button" onClick="location.href='/rank'" value="ランキングへ" class="btn btn-default"/>
			<input type="button" onClick="location.href='/index'" value="TOPへ" class="btn btn-default"/>
			<br>
		</div>
	</form:form>



	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
