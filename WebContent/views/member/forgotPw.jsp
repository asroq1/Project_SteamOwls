<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	LoginManager lm = LoginManager.getInstance();
	String sq = lm.getMemberSq(session);
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>비밀번호 찾기</title>
<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/css/base.css" type="text/css"></link>
<link rel="stylesheet" href="/css/member/forgotPw.css" type="text/css"></link>

</head>

<body>
	<header>
		<jsp:include page="/views/common/header.jsp"></jsp:include>
	</header>
	<section>
		<div class="forgotpw__form">
			<h3>비밀번호 찾기</h3>
			<form action="/member/forgotPwProc" method="post" id="ckpoint">
				<div class="forgotpw__id">
					<input type="text" placeholder="아이디" id="id" name="id">
				</div>
				<div class="forgotpw__name">
					<input type="text" placeholder="이름" id="name" name="name">
				</div>
				<div class="forgotpw__tel">
					<input type="tel" placeholder="전화번호" id="tel" name="tel">
				</div>
				<div>
					<button id="forgotpw__btn">비밀번호 찾기</button>
				</div>
			</form>
		</div>
	</section>
	<script defer="defer" src="/js/member/forgotPw.js"
		type="text/javascript"></script>
</body>

</html>