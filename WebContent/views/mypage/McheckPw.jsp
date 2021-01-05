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
    <link rel="stylesheet" href="/css/base.css" type="text/css"></link>
    <link rel="stylesheet" href="/css/mypage/McheckPw.css" type="text/css"></link>
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
    <article>
        <div class="signup__form">
            <jsp:include page="/views/common/footer-middle.jsp"></jsp:include>
        </div>
    </article>
</body>

</html>