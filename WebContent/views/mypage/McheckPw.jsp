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
    <title>회원확인</title>
    <link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
    <link rel="stylesheet" href="/css/base.css" type="text/css"></link>
    <link rel="stylesheet" href="/css/mypage/McheckPw.css" type="text/css"></link>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
    <script src="/js/mypage/McheckPw.js" defer></script>
</head>

<body>
    <header>
         <jsp:include page="/views/common/header-logout.jsp"></jsp:include>
    </header>
    <section>
        <form action="/mypage/McheckPwProc" method="post" id="checkPoint" onsubmit="return join()">
            <input type="password" name="pw" id="pw" maxlength="10" placeholder="비밀번호">
            <button type="submit">확인</button>
        </form>
    </section>
</body>

</html>