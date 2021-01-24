<%@page import="java.text.DecimalFormat"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>
<%@page import="shop.steamowls.steam.booking.vo.BookingVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
BookingVo bookingVo = (BookingVo) request.getAttribute("bookingVo");
MemberVo vo = (MemberVo) request.getAttribute("vo");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
DecimalFormat won = new DecimalFormat("###,###");
BookingVo productInfoVo = (BookingVo) request.getAttribute("productInfoVo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>결제완료</title>
<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/agreement.css">
<link rel="stylesheet" href="/css/c_header.css">
<link rel="stylesheet" href="/css/booking/BpayResult.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
<script src="/js/agreement/agree.js" defer></script>
</head>
<body>
	<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>
	<section>
		<div class="bill_container">
			<div class="bill_img">
			<%=productInfoVo.getProduct_imagePath()%>
			</div>
			<div class="bill_date">
				<h3>예약날짜</h3>
				<p><%=bookingVo.getBooking_date()%></p>
			</div>
			<div class="bill_time">	
				<h3>예약시간</h3>
				<p><%=bookingVo.getBooking_start() %>시</p>
			</div>
			<div class="bill_price">
				<h3>결제금액</h3>
				<p><%= won.format(bookingVo.getProduct_price() * bookingVo.getBooking_people())%>원</p>
			</div>
			<div class="bill_info">
				<h3>예약상품</h3>
				<p><%=bookingVo.getProduct_name() %></p>
			</div>
		</div>
		<form action="/" method="POST">
			<button class="bill_submit" onclick="">확인</button>
		</form>
	</section>
	<footer>
		<div class="signup__form">
			<a href="#" class="agreement" onclick="createFeed()">이용약관</a> <a
				href="#" class="agreement" onclick="createFeed()">개인정보 보호정책</a>
		</div>
	</footer>
</body>
</html>