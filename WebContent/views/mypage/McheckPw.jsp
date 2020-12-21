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
    <title>회원확인</title>
    <link rel="stylesheet" href="/css/base.css" type="text/css"></link>
    <link rel="stylesheet" href="/css/mypage/McheckPw.css" type="text/css"></link>
    <script src="/js/mypage/McheckPw.js" defer></script>
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
    <section>
        <form action="/mypage/McheckPwProc" method="post" id="checkPoint" onsubmit="return join()">
            <input type="password" name="pw" id="pw" maxlength="10" placeholder="비밀번호">
            <button type="submit">입력</button>
        </form>
    </section>
    <footer>
        <div class="agreement__form">
            <a href="#">이용안내</a>
            <a href="#">개인정보방침</a>
            <a href="#">제휴문의</a>
        </div>
    </footer>
</body>

</html>