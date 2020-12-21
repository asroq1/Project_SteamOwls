<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	LoginManager lm = LoginManager.getInstance();
	String sq = lm.getMemberSq(session);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면</title>
</head>
<body>
	<%
		if(sq == null) {
	%>
	
	<a href="/member/login">로그인</a>
	<a href="/member/signup">회원가입</a>
	<%
		}else{
	%>
		<a href="/">Owls</a>	
		<a href="/booking/book">예약하기</a> 
		<a href="/mypage/gotoMypage">마이페이지</a>
		<a href="/admin">admin</a>	
		<a href="/member/logout">로그아웃</a>
	<%
		}
	%>

</body>
</html>