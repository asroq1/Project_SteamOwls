<%@page import="shop.steamowls.steam.booking.vo.BookingVo"%>
<%@page import="shop.steamowls.steam.admin.product.vo.ProductVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>

<%@page import="shop.steamowls.common.LoginManager"%>
<%
ArrayList<BookingVo> list = (ArrayList<BookingVo>) request.getAttribute("list");
BookingVo bookingVo = (BookingVo) request.getAttribute("bookingVo");
MemberVo vo = (MemberVo) request.getAttribute("vo");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
/* 여기서 날짜, 시간, 인원, 상품정보 들고 같이 예약정보 확인까지 들고가기
 */
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>예약</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/booking/booking.css">
<link rel="stylesheet" href="/css/c_header.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.1/css/all.css"
	integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp"
	crossorigin="anonymous">
<script src="/js/booking/booking.js" defer></script>
<script src="/js/common/c_header.js" defer></script>
</head>

<body>
	<header>
		<a href="/"> <img src="/css/picture/owls.PNG" alt="로고사진">
		</a>
		<ul class="signForm">
			<li class="toggle_btn"><i class="fas fa-bars"></i></li>
			<ul class="toggle_bar">
				<li><a href="/mypage/gotoMypage">마이페이지</a></li>
				<li><a href="/member/logout">로그아웃</a></li>
			</ul>
		</ul>
	</header>
	<%
		for (int i = 0; i < list.size(); i++) {
	%> 
	<section>
		<div class="booking_container">
			<div class="form_img">
				<%=list.get(i). getProduct_imagePath()%>
			</div>
			<div class="form_top">
				<h3><%=list.get(i).getProduct_name()%></h3>
				<p class="form_intro">
					<%=list.get(i).getProduct_detail()%>
				</p>
			</div>
			<div class="form_bottom">
				<div class="bottom_text">
					<span class="form_intro"><%=list.get(i).getProduct_people()%></span> 

					<span class="form_price"><%=list.get(i).getProduct_price()%></span>
				</div>
				<!-- 여기에다가 불러온 자바 데이터 폼에 함께 실어서 보냄 -->
				<form method="post" id="ckpoint" action="/booking/Binfo?=booking_date<%=list.get(i).getBooking_date()%>
				&booking_start=<%=list.get(i).getBooking_start()%>
				&booking_people=<%=list.get(i).getBooking_people()%>
				&product_sq=<%=list.get(i).getProduct_sq()%>
				">
					<button class="booking_btn">예약</button>
				</form>
			</div>
		</div>
	</section>
	<%
		}
	%>
</body>
</html>