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
			<a href="/member/logout">로그아웃</a>
		</div>
	</header>
	<nav>
		<div class="nav__container">
            <a href="/admin/product/Pmanage">상품관리</a> 
            <a href="/admin/booking/Bmanage">예약관리</a> 
            <a href="/admin/sales/Smanage">매출관리</a>
            <a href="/admin/member/Mmanage">회원관리</a> 
            <a href="/admin/question/QManage">문의관리</a>
		</div>
		<div class="sub__wrapper">
			<div class="nav__sub pm">
				<ul>
					<li><a href="#">상품추가</a></li>
					<li><a href="#">상품삭제</a></li>
					<li><a href="#">상품내역</a></li>
				</ul>
			</div>
			<div class="nav__sub bm">
				<ul>
					<li><a href="#">예약관리</a></li>
					<li><a href="#">예약취소</a></li>
				</ul>
			</div>
			<div class="nav__sub pm">
				<ul>
					<li><a href="#">매출관리</a></li>
				</ul>
			</div>
			<div class="nav__sub um">
				<ul>
					<li><a href="#">회원수정</a></li>
					<li><a href="#">회원탈퇴</a></li>
					<li><a href="#">회원내역</a></li>
				</ul>
			</div>
			<div class="nav__sub qm">
				<ul>
					<li><a href="#">문의내역</a></li>
					<li><a href="#">답변하기</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<section>
		<h1>관리자 메인</h1>
	</section>
</body>

</html>