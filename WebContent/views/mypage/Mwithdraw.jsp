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
    <title>회원탈퇴</title>
     <link rel="stylesheet" href="/css/base.css" type="text/css"></link>
	<link rel="stylesheet" href="/css/mypage/Mwithdraw.css" type="text/css"></link>
</head>
  <script src="/js/mypage/Mwithdraw.js" defer></script>
</head>
<body>
    <header>
        <div class="header__logo">
            <a href="home/index.jsp">
                <img src="/mypage/css/owls.PNG" alt="로고사진">
            </a>
            <div class="header__signForm">
                <a href="/member/logout">로그아웃</a>
            </div>
        </div>
    </header>

    <body>
        <form action="/mypage/Mwithdraw" method="POST" id="checkPoint" onsubmit="return checkleave()">
            <input type="password" name="pw" id="pw" placeholder="비밀번호" maxlength="10">
            <input type="password" name="pw" id="pw" placeholder="비밀번호 재확인" maxlength="10">
            <button type="submit">회원탈퇴</button>
        </form>
    </body>
    <footer>
        <div class="agreement__form">
            <a href="#">이용안내</a>
            <a href="#">개인정보방침</a>
            <a href="#">제휴문의</a>
        </div>
    </footer>

</body>
</html>