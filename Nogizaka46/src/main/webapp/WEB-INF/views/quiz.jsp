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
<title>クイズ画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body style="background-color:#EE82EE;">
	<div class="center"><img src="logo.jpg" class="img-circle" width="250" height="250">

		<h1>第${sessionScope.count}問</h1>
		<h3>この歌詞はどの曲の歌詞でしょう？</h3>
		<br> <br>
		<form:form action="result" modelAttribute="quiz">
			${ fn:escapeXml(update.getLyrics())}

		<form:hidden path="question_id"
				value="${ fn:escapeXml(update.getLyrics_id())}" />
			<form:hidden path="question"
				value="${ fn:escapeXml(update.getTitle_id())}" />
			<br>
			<br>
			<h3>答えを↓から選んでください。</h3>
			<br>
			<form:radiobutton path="answer"
				value="${ fn:escapeXml(dummy.get(0))}" checked="checked" />
			<c:out value="${ fn:escapeXml(dummyTitle.get(0))}" />
			<form:radiobutton path="answer"
				value="${ fn:escapeXml(dummy.get(1))}" />
			<c:out value="${ fn:escapeXml(dummyTitle.get(1))}" />
			<form:radiobutton path="answer"
				value="${ fn:escapeXml(dummy.get(2))}" />
			<c:out value="${ fn:escapeXml(dummyTitle.get(2))}" />
			<form:radiobutton path="answer"
				value="${ fn:escapeXml(dummy.get(3))}" />
			<c:out value="${ fn:escapeXml(dummyTitle.get(3))}" />
			<br>
			<br>
			<div>
				<button type='submit' class="btn btn-default">次へ</button>
			</div>
		</form:form>
		<br>
		<div>
			<a href="menu" style="color:#ffffff"> メニューに戻る </a>
		</div>
	</div>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
