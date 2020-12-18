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
<title>비밀번호 재설정</title>
<link rel="stylesheet" href="/css/base.css" type="text/css">
</link>
<link rel="stylesheet" href="/css/member/resetPw.css" type="text/css">
</link>

</head>

<body>
	<header>
		<a href="/views/home/index.jsp"> <img src="/css/picture/owls.PNG"
			alt="로고사진">
		</a> <a href="/member/login" class="signForm"> 로그인 </a>
	</header>
	<section>
		<div class="checkPw__form">
			<form action="/member/resetPw?sq=<%=vo.getSq()%>" method="post"
				id="ckpoint">
				<h3>비밀번호 재설정</h3>
				<div>
					<input type="password" placeholder="신규 비밀번호" id="pw" name="pw">
				</div>
				<div>
					<input type="password" placeholder="비밀번호 재확인" id="cpw" name="cpw">
				</div>
				<div class="btn__color">
					<button id="findPw__btn" value="변경하기">변경하기</button>
				</div>
			</form>
		</div>
	</section>
	<script src="/js/member/resetPw.js" type="text/javascript"></script>
</body>

</html>