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
	welcome : Member<br><br>
	<c:if test="${not empty pageContext.request.userPrincipal} ">
		<p> Log - In</p>
	</c:if>
	
	USER ID : ${pageContext.request.userPrincipal.name}<br><br>
	
	<!-- userPrincipal : 기본적인 모든 정보들이 등러옴 -->
	user info : ${pageContext.request.userPrincipal}<br><br>
	
	<a href="/logout">Log out</a>
</body>
</html>