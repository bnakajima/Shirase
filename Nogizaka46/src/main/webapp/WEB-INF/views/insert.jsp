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
<title>問題登録画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>


	<form:form action="insert" modelAttribute="insert" method="post">
		<div class="center">
			<p>これでよろしいですか？</p>
			<p>歌詞を↓に入力してください。</p>
			<form:textarea path="lyrics"></form:textarea>

			<p>答えを↓から選んでください。</p>
			<form:select path="title_id">
				<c:forEach var="tmp" items="${list}">
					<option value="${tmp.title_id}"><c:out
							value="${tmp.title}" /></option>
				</c:forEach>
			</form:select>
			<br>
			<div>
				<button type='submit' class="btn btn-default">登録</button>
			</div>
			<div>
				<a href="menu" style="color:#ffffff"> メニューに戻る </a>
			</div>
		</div>
	</form:form>



	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
