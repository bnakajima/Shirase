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
<title>メニュー画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<div class="center">
		${sessionScope.usrdata}さん、こんにちは。

		<form action="select">
			<div>
				<button type='submit' class="btn btn-default">クイズ閲覧</button>
			</div>
		</form>
		<form action="insert">
			<div>
				<button type='submit' class="btn btn-default">クイズ作成</button>
			</div>
		</form>
		<form action="update">
			<div>
				<button type='submit' class="btn btn-default">クイズ編集</button>
			</div>
		</form>
		<form action="delete">
			<div>
				<button type='submit' class="btn btn-default">クイズ削除</button>
			</div>
		</form>
		<form action="logout">
			<div>
				<button type='submit' class="btn btn-default">ログアウト</button>
			</div>
		</form>
	</div>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
