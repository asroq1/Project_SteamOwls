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
    <title>회원탈퇴</title>
    <link rel="stylesheet" href="/css/mypage/withdraw.css">
    <script src="/js/mypage/withdraw.js" defer></script>
</head>

<body>
    <header>
        <div class="section__logo">
            <a href="/"> <img src="/css/picture/owls.PNG" alt="로고">
            </a>
        </div>
    </header>
    <section>
        <h3>회원탈퇴</h3>
        <div>탈퇴하시면 기존의 모든 할인과 혜택을 받으실 수 없습니다.</div>
        <button onclick="ckpoint()">탈퇴하기</button>
    </section>
</body>

</html>