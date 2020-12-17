<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MemberVo memberVo = (MemberVo) request.getAttribute("memberVo");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원수정</title>
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/mypage/Mwithdraw.css">
    <link rel="stylesheet" href="/css/agreement.css" type="text/css"></link>
    <script src="/" type="text/javascript" defer></script>
    <script src="/js/agreement/agree.js" type="text/javascript" defer></script>
</head>
<body>
    <header>
        <div class="header__logo">
            <a href="/views/home/index.jsp">
                <img src="/css/picture/owls.PNG" alt="로고사진">
            </a>
            <div class="header__signForm">
                <a href="/member/logout">로그아웃</a>
            </div>
        </div>
    </header>
    <body>
        <form action="/mypage/Mmodify" id="checkPoint" onsubmit="return join()">
            <h2>회원정보 수정</h2>
            <input type="text" name="name" id="name" placeholder="<%=memberVo.getName() %>">
            <p class="name__text"></p> 
            <input type="password" name="pw" id="pw" placeholder="새 비밀번호 입력" maxlength="10">
             <p class="pw__text"></p> 
            <input type="password" name="pw" id="cpw" placeholder="새 비밀번호 확인" maxlength="10"> 
            <input type="tel" name="tel" id="tel" placeholder="<%=memberVo.getTel() %>">
           	<p class="tel__text"></p> 
            <button type="submit">수정하기</button>
        </form>
        <footer>
            <div class="agreement__form">
                <a href="#" onclick="createFeed()">이용안내</a>
                <a href="#" onclick="createFeed()">개인정보방침</a>
                <a href="#" onclick="createFeed()">제휴문의</a>
            </div>
    </footer>
    </body>
</body>
</html>