<%@page import="shop.steamowls.steam.mypage.vo.BoardVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
ArrayList<BoardVo> list = (ArrayList<BoardVo>) request.getAttribute("list");
BoardVo boardVo = (BoardVo) request.getAttribute("boardVo");
%>
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
	<style>
		h3 {
			display: inline-block;
		}
	</style>
</head>

<body>
	<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>

	<h1>문의 게시판</h1>
	<br>
	<div>
		<tr>
			<th>문의번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
		</tr>

	</div>


	<%
	for (int i = 0; i < list.size(); i++) {
	%>
	<tr>
		<td><%=list.get(i).getBoard_sq()%></td>
		<td><a href="/mypage/QDetail?board_sq=<%=list.get(i).getBoard_sq()%>"><%=list.get(i).getBoard_subject()%></a></td>
		<td><%=list.get(i).getBoard_dttm()%></td>
		<br>
	</tr>
	<%
	}
	%>

	<a href="/mypage/QWriting">글쓰기</a>
	<a href="/mypage/gotoMypage">마이페이지로 이동</a>
</body>

</html>