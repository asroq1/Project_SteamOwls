<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberVo vo = (MemberVo) request.getAttribute("vo");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>아이디 결과</title>
<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/css/base.css" type="text/css"></link>
<link rel="stylesheet" href="/css/member/checkId.css" type="text/css"></link>

</head>

<body>
	<header>
		<jsp:include page="/views/common/header.jsp"></jsp:include>
	</header>
	<section>
		<div class="checkId__form">
			<p>찾으시는 고객님의 아이디는
			<p>
			<div class="checkId__name">
				아이디는 <span id="myId"><%=vo.getId()%></span> 입니다.
			</div>
			<div>
				<button id="checkId__btn">
					<a href="/member/login">로그인 화면으로 가기</a>
				</button>
			</div>
		</div>
	</section>
	<script src="/js/member/checkId.js" type="text/javascript" defer></script>
</body>

</html>