<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainPage</title>
<style>
	a {
		text-decoration:none;
		color:black;
		cursor: pointer:
	}
</style>
</head>
<body>
	<h1>Member JPA #02</h1>
	
	<a href="insert">데이터 추가 </a><br><Br>
	<a href=/selectAll>전체 조회 </a><br><Br>
	<a href=/select?id=955>개별 조회 </a><br><Br>
	<hr>
	
	<a href=/selectByName?name=이조은>개별 조회 - Byname </a><br><Br>
	<a href=/selectByEmail?email=test2@test.com>개별 조회 - ByEmail </a><br><Br>
	<a href=/selectByNameLike?name=김>개별 조회 - ByNameLike </a><br><Br>
	<a href=/selectByNameLikeDesc?name=김>개별 조회 - ByNameLikeOrderByDesc </a><br><Br>
	<a href=/selectByNameLikeSort?name=김>개별 조회 - ByNameLikeOrderBySort </a><br><Br>

	
</body>
</html>