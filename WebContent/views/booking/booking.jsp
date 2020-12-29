<%@page import="shop.steamowls.steam.admin.product.vo.ProductVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>

<%@page import="shop.steamowls.common.LoginManager"%>
<%
	ArrayList<ProductVo> list = (ArrayList<ProductVo>) request.getAttribute("list");
MemberVo vo = (MemberVo) request.getAttribute("vo");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>예약</title>
	<link rel="stylesheet" href="/css/base.css">
	<link rel="stylesheet" href="/css/booking/booking.css">
	<link rel="stylesheet" href="/css/c_header.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css"
		integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
	<script src="/js/booking/booking.js" defer></script>
	<script src="/js/common/c_header.js" defer></script>
</head>

<body>
	<%
		if (sq == null) {
	%>
			<header>
				<a href="/">
					<img src="/css/picture/owls.PNG" alt="로고사진">
				</a>
				<ul class="signForm">
					<li class="toggle_btn">
						<i class="fas fa-bars"></i>
					</li>
					<ul class="toggle_bar">
						<li><a href="/member/login">로그인</a></li>
						<li><a href="/member/signup">회원가입</a></li>
					</ul>
				</ul>
			</header>
	
	<%
		} else {
	%>
	<header>
		<a href="/">
			<img src="/css/picture/owls.PNG" alt="로고사진">
		</a>
		<ul class="signForm">
			<li class="toggle_btn">
				<i class="fas fa-bars"></i>
			</li>
			<ul class="toggle_bar">
				<li><a href="/mypage/gotoMypage">마이페이지</a></li>
				<li><a href="/member/logout">로그아웃</a></li>
			</ul>
		</ul>
	</header>
	<%
	}
	%>
	<%-- <%
		for (int i = 0; i < list.size(); i++) {
	%> --%>
	<%-- <section>
		<form action="/admin/bookProc" class="form__container" method="post"
			id="ckpoint">
			<div class="booking__Form">

				<div class="booking_img">
					<%-<%=list.get(i).getProduct_image()%>
	</div>
	<div class="title__top">
		<div class="booking__title">
			<h3>
				<%=list.get(i).getProduct_name()%>
			</h3>
		</div>
		<div class="booking_bottom">
			<div class="booking__intro">
				<p>
					<%=list.get(i).getProduct_detail()%>
				</p>
			</div>
			<div class="booking_info">
				<p>
					<%=list.get(i).getProduct_people()%>명
				</p>
				<p>
					₩<%=list.get(i).getProduct_price()%>
				</p>
			</div>
		</div>
	</div>
	</form>
	<div class="booking__confirm">
		<button class="confirm__add" onclick="Pdelete()">예약하기</button>
	</div>
	</section> --%>
	<section>
		<div class="booking_container">
			<div class="form_img">
				<img src="/css/picture/massage-1017255_640.png" alt="A코스">
			</div>
			<div class="form_top">
				<h3>A- 최상급 코스</h3>
				<p class="form_intro">이 코스는 인도에서 부터 유래되어 아주 영국으로 저기로 아무튼 프리미엄 입니다. </p>
			</div>
			<div class="form_bottom">
				<div class="bottom_text">
					<span class="form_intro">1인,</span>
					<span class="form_intro">성인 기준</span>
					<span class="form_price">$90,000</span>
				</div>
				<button class="booking_btn" onclick="book()">예약</button>
			</div>
		</div>
	</section>
	<%-- <%
		}
	%> --%>
</body>

</html>