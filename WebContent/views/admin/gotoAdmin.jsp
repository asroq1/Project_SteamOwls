<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="shop.steamowls.common.LoginManager"%>
<%
	LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);

%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>관리자 메인화면</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/admin/gotoAdmin.css">
<script src="/js/admin/gotoAdmin.js" defer></script>
</head>

<body>
	<header>
		<div class="header__logo">
			<a href="/views/home/index.jsp"> <img src="/css/picture/owls.PNG"
				alt="로고사진">
			</a>
		</div>
		<div class="header__signForm">
			<a href="/admin/Alogout">로그아웃</a>
		</div>
	</header>
	<nav role="navigation">
		 <jsp:include page="/views/common/admin-nav.jsp"></jsp:include>	
	</nav>
	<section>
		<h1>관리자 메인</h1>
	</section>
</body>

</html>