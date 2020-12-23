<%@page import="shop.steamowls.steam.admin.admin.vo.AdminVo"%>
<%@page import="shop.steamowls.steam.admin.product.vo.ProductVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@page import="shop.steamowls.common.LoginManager"%>

<%
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
/* 	ProductVo  productVo = (ProductVo) request.getAttribute("productVo"); */
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
<script src="/js/admin/Padd.js" defer></script>
</head>
<header>
	<div class="header__logo">
		<a href="/views/home/index.jsp">
			<img src="/css/picture/owls.PNG" alt="로고사진">
		</a>
	</div>
	<div class="header__signForm">
		<a href="/admin/Alogout">로그아웃</a>
	</div>
</header>
<body>
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
	<section>
		
		<form  action="/admin/PaddProc" id="ckpoint" method="post" enctype="multipart/form-data">
			<div>
				<label for="product_image">이미지</label> 
				<input type="file" name="product_image" id="product_image" multiple="multiple" max="5">
			</div>
			<div class="text__form">
				<label for="product_name">상품이름</label> 
				<input type="text" placeholder="상품이름" name="product_name" id="product_name"> 
					<label for="product_detail">설명</label> <input type="text"
					placeholder="상품설명" name="product_detail" id="product_detail">
			</div>
			<label for="product_price">가격</label><input type="text"
				name="product_price" id="product_price" placeholder="가격">
				<label for="product_people">인원수</label><input type="text"
				name="product_people" id="product_people" placeholder="인원수">
		</form>
		<button id="Padd" onclick="Padd()">상품추가</button>
	</section>
</body>

</html>