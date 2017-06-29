<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
<title>問題解説画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body style="background-color:#EE82EE;">
	<div class="center"><img src="logo.jpg" class="img-circle" width="250" height="250">
		<h3>問題歌詞↓</h3>
		<br> <br> ${fn:escapeXml(Lyrics)} <br>
		<br>
		<h3>正解タイトル↓</h3>
		<br>
		<br> ${fn:escapeXml(title)} <br> <br>
		<br>
		<div>
			<a href="resultreboot" style="color:#ffffff"> リザルトに戻る </a>
		</div>
	</div>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
