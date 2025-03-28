<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">상세보기</h1>
	작성자 : ${board.writer }<br><br>
	제목 : ${board.title }<br><br>
	내용 : ${board.content }<br><br>
	
	<a href="list"><button type="button" class="btn btn-outline-info">목록보기</button></a>
</body>
</html>