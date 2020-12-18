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
<title>Insert title here</title>
</head>
<body>
글쓰기화면
<form>
	<div>내용</div>
	<jsp:includ page="/editor/editorSkinForRegister.jsp" flush="false"/>
</form>

<a href="/mypage/question">문의로 돌아가기2</a>
</body>
</html>