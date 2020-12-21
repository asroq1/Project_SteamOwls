<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%
	LoginManager lm = LoginManager.getInstance();
	String sq = lm.getMemberSq(session);
%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>상품등록화면</title>
	<link rel="stylesheet" href="/css/base.css">
	<link rel="stylesheet" href="/css/admin/gotoAdmin.css">
	<link rel="stylesheet" href="/css/admin/productAdd.css">
</head>
<header>
	<div class="header__logo">
		<img src="/css/picture/owls.PNG" alt="로고사진">
	</div>
	<div class="header__signForm">
		<a href="/member/logout">로그아웃</a>
	</div>
</header>
<body>
	<nav>
		<div class="nav__container">
            <a href="/admin/productManage">상품관리</a> 
            <a href="/admin/bookingManage">예약관리</a> 
            <a href="/admin/salesManage">매출관리</a>
            <a href="/admin/memberManage">회원관리</a> 
            <a href="/admin/questionManage">문의관리</a>
		</div>
		<div class="sub__wrapper">
			<div class="nav__sub pm">
				<ul>
					<li><a href="#">상품등록</a></li>
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
		<h1>상품등록화면</h1>
		<form class="add__form">
			<input type="file" name="img" id="img">
			<div class="text__form">
				<input type="text" placeholder="상품제목">
				<input type="text" placeholder="상품내용">				
			</div>
			<input type="text" name="price" id="price" placeholder="가격">
		</form>
		<button href="/admin/product/PaddProc">상품추가</button>
	</section>
</body>

</html>