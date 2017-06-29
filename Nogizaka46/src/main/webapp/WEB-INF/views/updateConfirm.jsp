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
<title>更新内容確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<div class="center">
		<p>これでよろしいですか？</p>

		<form:form action="update" modelAttribute="update" method="post">
			<p>歌詞を↓に入力してください。</p>
			<form:textarea path="lyrics"
				value="${ fn:escapeXml(update.getLyrics())}"></form:textarea>

			<p>答えを↓から選んでください。</p>
			<form:select path="title_id">
				<c:forEach var="tmp" items="${list}">]
			<c:if test="${update.getTitle_id().equals(tmp.title_id)}" var="flg" />
					<c:if test="${flg}">
						<option value="${tmp.title_id}" selected><c:out
								value="${tmp.title}" /></option>
					</c:if>
					<c:if test="${!flg}">
						<option value="${tmp.title_id}"><c:out
								value="${tmp.title}" /></option>
					</c:if>
				</c:forEach>
			</form:select>
			<br>
			<div>
				<button type='submit' class="btn btn-default">更新実行</button>
			</div>
		</form:form>

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
