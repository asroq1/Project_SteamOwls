<%@page import="shop.steamowls.steam.mypage.vo.MypageVo"%>
<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	
	MypageVo vo = (MypageVo) request.getAttribute("vo");
	LoginManager lm = LoginManager.getInstance();
	String sq = lm.getMemberSq(session);
%>
	<!DOCTYPE html>
	<html lang="ko">

	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>회원수정</title>
	    <link rel="stylesheet" href="/css/base.css">
	    <link rel="stylesheet" href="/css/mypage/Mmodify.css">
	    <link rel="stylesheet" href="/css/agreement-middle.css">
	    <script src="/js/mypage/Mmodify.js" type="text/javascript" defer></script>
	    <script src="/js/agreement/agree.js" type="text/javascript" defer></script>
	</head>

	<body>
	    <header>
	        <jsp:include page="/views/common/header-logout.jsp"></jsp:include>
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
	        <article>
	            <div class="signup__form">
	                <a href="#" onclick="createFeed()"class="agreement">이용안내</a>
	                <a href="#" onclick="createFeed()"class="agreement">개인정보방침</a>
	                <a href="#" onclick="createFeed()"class="agreement">제휴문의</a>
	                <a id="delete-btn" href="/mypage/MwithdrawProc?sq=<%=vo.getSq()%>">회원탈퇴</a>
	            </div>
	        </article>
	    </body>
	</body>

	</html>