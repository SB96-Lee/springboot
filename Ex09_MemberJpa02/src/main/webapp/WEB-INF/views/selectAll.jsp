<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SelectAll</title>
</head>
<body>
		<h1>Member JPA #02 - SelectAll</h1>
		
		<c:forEach var="b" items="${members }">
			아이디 : ${b.id} <br><br>
			이름 : ${b.name} <br><br>
			날짜 : ${b.email} <br><hr>	
		</c:forEach>
		
		
</body>
</html>