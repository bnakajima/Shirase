<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<p>名前を入力してください</p>
		<br> ${ fn:escapeXml(msg)}

		<form:form action="quiz" modelAttribute="name" method="post">
			<div>
				<form:input path="name" />
			</div>
			<br>
			<div>
				<form:button class="btn btn-default">
				クイズスタート！
			</form:button>
			</div>
		</form:form>
		<br>
		<br>
		<a href="index" style="color:#ffffff"> TOPに戻る </a>
	</div>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
