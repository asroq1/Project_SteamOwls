<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/base.css">
</head>
<body>
<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
</header>
문의목록화면<br>
<a href="QDetail">글1 상세보기</a>
<br>
<a href="QDetail">글2 상세보기</a>
<br>
<a href="QDetail">글3 상세보기</a>
<br>
...<br>
<a href="/mypage/QWriting">글쓰기</a>
<a href="/mypage/gotoMypage">마이페이지로 이동</a>
</body>
</html>