<%@page import="shop.steamowls.steam.booking.vo.BookingVo"%>
<%@page import="shop.steamowls.steam.admin.product.vo.ProductVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>

<%@page import="shop.steamowls.common.LoginManager"%>
<%
ArrayList<BookingVo> list = (ArrayList<BookingVo>) request.getAttribute("list");
BookingVo bookingInfoVo = (BookingVo) request.getAttribute("bookingInfoVo");
BookingVo bookingVo = (BookingVo) request.getAttribute("bookingVo");
MemberVo vo = (MemberVo) request.getAttribute("vo");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>예약</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/booking/booking.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.1/css/all.css"
	integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
<script src="/js/booking/booking.js" defer></script>
</head>

<body>
	<header>
		  <jsp:include page="/views/common/header-logout.jsp"></jsp:include>
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
			
				<form method="post" id="ckpoint" action="/booking/Binfo?booking_date=<%=bookingInfoVo.getBooking_date()%>
				&booking_start=<%=bookingInfoVo.getBooking_start()%>
				&booking_people=<%=bookingInfoVo.getBooking_people()%>
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