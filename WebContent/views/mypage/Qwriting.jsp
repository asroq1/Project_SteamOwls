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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>문의하기</title>
<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/mypage/Qwriting.css">
<script src="/js/mypage/Qwriting.js" defer></script>
</head>
<body>
	<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>
	<section>
	<div class="question__container"> 
		<form action="/mypage/QWritingProc" method="post" id="editorForm">
			<div class="title"> 
				<label for="title">제목</label>
			<input type="text" id="title" name="board_subject" />
			</div>
			<div>
				<h3 class="question__title">문의내역</h3>
				<jsp:include page="/editor/editorSkinForRegister.jsp" flush="false" />
			</div>
		</form>
				<button type="button" onclick="add()" class="addBtn">등록</button>
	</div>
	</section>
</body>
</html>