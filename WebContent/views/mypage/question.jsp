<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>문의게시판</title>
<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/css/base.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">

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