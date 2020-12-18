<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberVo vo = (MemberVo) request.getAttribute("vo");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>아이디 결과</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.1/css/all.css"
	integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/base.css" type="text/css"></link>
<link rel="stylesheet" href="/css/member/checkId.css" type="text/css"></link>

</head>

<body>
	<header>
		<span class="header__logo"> 
		<a href="/views/home/index.jsp">
	  		<img src="/css/picture/owls.PNG" alt="로고사진">
		</a>
		</span>
		 <span class="header__hambuger">
			<button>
				<i class="fas fa-bars"></i>
			</button>
		</span>
	</header>
	<section>
		<div class="checkId__form">
			<h1>찾으시는 고객님의 아이디는</h1>
			<div class="checkId__name">
				<p>
					아이디는 <span id="myId"><%=vo.getId()%></span> 입니다.
				</p>
			</div>
			<div>
				<button id="checkId__btn">
					<p>
						<a href="/member/login">로그인 화면으로 가기</a>
					</p>
				</button>
			</div>
			<span id="login__line">
				또는 다른 것이 필요하신가요?
			 </span>
			<div class="chekcPw__others">
				<button id="checkPw__btn">
					<p>
					  <a href="/member/forgotPw">비밀번호 찾기</a>
					</p>
				</button>
				<div class="sign__up__kakao">
					<a href="#">카카오톡으로 로그인</a>
				</div>
				<div class="sign__up__naver">
					<a href="#">네이버로 로그인</a>
				</div>
			</div>
		</div>
	</section>
	<script defer="defer" src="/js/member/checkId.js"
		type="text/javascript"></script>
</body>

</html>