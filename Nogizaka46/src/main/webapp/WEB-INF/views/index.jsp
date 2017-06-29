<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link href="css/commons.css" rel="stylesheet">
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TOP画面</title>
</head>
<body style="background-color:#EE82EE;">
	<div class="center"><img src="logo.jpg" class="img-circle" width="250" height="250">
	<h1>乃木坂46歌詞当てクイズへようこそ！</h1>
	<h5>このサイトでは乃木坂46の歌詞当てクイズを行えます！</h5>
	<h5>ランキングも確認できるよ！</h5>
		<form:form action="quiz" modelAttribute="quiz" method="get">

			<div>
				<button type='submit' class="btn btn-default">クイズを行う</button>
			</div>
			<br>
			<div>
				<input type="button" onClick="location.href='/rank'" value="ランキング" class="btn btn-default"/>
			</div>

		</form:form>

<br><br>

		<form:form action="login" modelAttribute="login">

			<a href="login" style="color:#ffffff">管理者ログイン</a>

		</form:form>
	</div>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>