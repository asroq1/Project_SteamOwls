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
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/mypage/Qwriting.css">
<script src="/js/mypage/Qwriting.js"></script>
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
				<jsp:include page="/editor/editorSkinForRegister.jsp" flush="false" />
			</div>
		</form>
		<div class="btn__container">
				<button type="button" onclick="add()">등록</button>
				<a href="/mypage/question">돌아가기</a>
			</div>
	</div>
	</section>
</body>
</html>