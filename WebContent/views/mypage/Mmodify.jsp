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
	    <title>회원수정</title>
	    <link rel="stylesheet" href="/css/base.css">
	    <link rel="stylesheet" href="/css/mypage/Mwithdraw.css">
	    <script src="/js/mypage/Mmodify.js" type="text/javascript" defer></script>
	</head>

	<body>
	    <header>
	        <div class="header__logo">
	            <a href="/views/home/index.jsp">
	                <img src="/css/picture/owls.PNG" alt="로고사진">
	            </a>
	            <div class="header__signForm">
	                <a href="#">로그아웃</a>
	            </div>
	        </div>
	    </header>

	    <body>
	        <form action="/mypage/Mmodify" id="checkPoint" onsubmit="return join()">
	            <h2>회원정보 수정</h2>
	            <input type="text" name="name" id="name" placeholder="<%=vo.getName() %>" value="<%=vo.getName() %>" maxlength="10">
	            <p class="name__text"></p>
	            <input type="password" name="pw" id="pw" placeholder="새 비밀번호 입력" maxlength="10">
	            <p class="pw__text"></p>
	            <input type="password" name="pw" id="cpw" placeholder="새 비밀번호 확인" maxlength="10">
	            <input type="tel" name="tel" id="tel" placeholder="<%=vo.getTel() %>" value="<%=vo.getTel() %>"
	                maxlength="11">
	            <p class="tel__text"></p>
	            <button type="submit">수정하기</button>
	        </form>
	        <form action="/mypage/Mwithdraw" onsubmit="return">
	            <button type="submit">회원탈퇴</button>
	        </form>
	        <footer>
	            <div class="agreement__form">
	                <a href="#">이용안내</a>
	                <a href="#">개인정보방침</a>
	                <a href="#">제휴문의</a>
	            </div>
	        </footer>
	    </body>
	</body>

	</html>