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
<link href="/css/picture/icons8_owl.ico" rel="shortcut icon"
	type="image/x-icon">
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/admin/gotoAdmin.css">
<link rel="stylesheet" href="/css/mypage/gotoMypage.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
</head>

<body>
	<header>
		<jsp:include page="/views/common/adminHeader.jsp"></jsp:include>
	</header>
	<nav role="navigation">
		<jsp:include page="/views/common/admin-nav.jsp"></jsp:include>
	</nav>
	<section>
		<div class="info-container1">
			<div class="info-box">
				<i class="fas fa-tags"></i>
				<h1>상품관리</h1>
				<ul>
					<li><a href="/admin/Padd" aria-label="subemnu">상품추가</a></li>
					<li><a href="/admin/Pdelete" aria-label="subemnu">상품삭제</a></li>
					<li><a href="/admin/Pmanage" aria-label="subemnu">상품관리</a></li>
				</ul>
			</div>
			<div class="info-box">
				<i class="far fa-calendar-alt"></i>
				<h1>예약관리</h1>
				<ul>
					<li><a href="/admin/Bmanage" aria-label="subemnu">예약내역</a></li>
				</ul>
			</div>
			<div class="info-box">
				<i class="fas fa-dollar-sign"></i>
				<h1>매출관리</h1>
				<ul>
					<li><a href="admin/Smanage" aria-label="subemnu">매출내역</a></li>
				</ul>
			</div>
		</div>
		<div class="info-container2">
			<div class="info-box box-blur">
				<i class="fas fa-user"></i>
				<h1>회원관리</h1>
				<ul>
					<li><a href="/admin/Mmanage" aria-label="subemnu">회원내역</a></li>
				</ul>
			</div>
			<div class="info-box">
				<i class="far fa-question-circle"></i>
				<h1>문의관리</h1>
				<ul>
					<li><a href="/admin/Qmanage" aria-label="subemnu">문의내역</a></li>
				</ul>
			</div>
			<div class="info-box box-blur">
				<i class="far fa-comment-dots"></i>
				<h1>리뷰관리</h1>
				<ul>
					<li><a href="/admin/Rmanage" aria-label="subemnu">리뷰내역</a></li>
				</ul>
			</div>
		</div>
	</section>
</body>

</html>