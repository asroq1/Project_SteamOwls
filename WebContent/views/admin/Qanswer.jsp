<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

    <%
    MemberVo vo = (MemberVo) request.getAttribute("vo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의답변</title>
<script type="text/javascript">
	<%-- let content = '<%=vo.getContent()%>'; --%>
</script>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/admin/gotoAdmin.css">
</head>
<body>
문의답변화면
<header>
    <div class="header__logo">
        <a href="/views/home/index.jsp">
            <img src="/css/picture/owls.PNG" alt="로고사진">
        </a>
    </div>
    <div class="header__signForm">
        <a href="/member/logout">로그아웃</a>
    </div>
</header>
<nav role="navigation">
    <ul id="main-menu">
        <li><a href="#">상품관리</a>
            <ul id="sub-menu">
                <li><a href="/views/admin/Padd.jsp" aria-label="subemnu">상품추가</a></li>
                <li><a href="/views/admin/Pdelete.jsp" aria-label="subemnu">상품삭제</a></li>
                <li><a href="/views/admin/Pmanage.jsp" aria-label="subemnu">상품관리</a></li>
            </ul>
        </li>
        <li><a href="#">예약관리</a>
            <ul id="sub-menu">
                <li><a href="/views/admin/Bmanage.jsp" aria-label="subemnu">예약내역</a></li>
                <li><a href="/views/admin/" aria-label="subemnu">예약완료</a></li>
                <li><a href="/views/admin/" aria-label="subemnu">예약수정</a></li>
                <li><a href="/views/admin/" aria-label="subemnu">예약취소</a></li>
            </ul>
        </li>
        <li><a href="#">매출관리</a>
            <ul id="sub-menu">
                <li><a href="/views/admin/Smanage.jsp" aria-label="subemnu">매출내역</a></li>
            </ul>
        </li>
        <li><a href="#">회원관리</a>
            <ul id="sub-menu">
                <li><a href="/views/admin/" aria-label="subemnu">회원수정</a></li>
                <li><a href="/views/admin/" aria-label="subemnu">회원탈퇴</a></li>
                <li><a href="/views/admin/Mmanage.jsp" aria-label="subemnu">회원내역</a></li>
            </ul>
        </li>
        <li><a href="#">문의관리</a>
            <ul id="sub-menu">
                <li><a href="/views/admin/Qmanage.jsp" aria-label="subemnu">문의내역</a></li>
                <li><a href="/views/admin/Qanswer.jsp" aria-label="subemnu">답변하기</a></li>
            </ul>
        </li>
    </ul>
</nav>
<a href="/admin/question/Qmanage">게시</a>
<form action="/admin/product/PaddProc" method="post" id="editorForm">
<div>
	<jsp:include page="/editor/editorSkinForModify.jsp" flush="false" />
</div>
</form>
</body>
</html>