<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.steamowls.steam.booking.vo.BookingVo"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
BookingVo bookingVo = (BookingVo) request.getAttribute("bookingVo");
BookingVo productInfoVo = (BookingVo) request.getAttribute("productInfoVo");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
DecimalFormat won = new DecimalFormat("###,###");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>결제완료</title>
<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/booking/payment.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.1/css/all.css"
	integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp"
	crossorigin="anonymous">
	
</head>

<body>
	<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>

	<section>
		<div class="Binfo_container">
			<div class="Binfo">
				<div class="Binfo_date">
					<h3>예약날짜</h3>
					<p><%=bookingVo.getBooking_date()%></p>
				</div>
				<div class="Binfo_time">
					<h3>시간</h3>
					<p><%=bookingVo.getBooking_start()%>시</p>
				</div>
				<div class="Binfo_people">
					<h3>인원</h3>
					<p><%=bookingVo.getBooking_people()%>명</p>
				</div>
				<div class="Binfo_paid">
					<h3>결제금액</h3>
					<p><%=won.format(productInfoVo.getProduct_price() * bookingVo.getBooking_people())%>
					원</p>
				</div>
				<div class="Binfo_info">
					<h3>예약상품</h3>
					<p><%=productInfoVo.getProduct_name()%></p>
				</div>
				<div class="Binfo_submit">
					<form method="POST"
						action="/booking/Pinfo?booking_date=<%=bookingVo.getBooking_date()%>
						&booking_start=<%=bookingVo.getBooking_start()%>
						&booking_people=<%=bookingVo.getBooking_people()%>
						&product_sq=<%=bookingVo.getProduct_sq()%>
						&product_name=<%=productInfoVo.getProduct_name()%>
						&product_price=<%=productInfoVo.getProduct_price()%>
						">
						<button type="submit" class="booking_btn">결제하기</button>
					</form>
				</div>
			</div>
			<div class="Binfo_img">
				<img alt="" src="/css/picture/Spa.png">
				<%=productInfoVo.getProduct_imagePath()%>
			</div>
		</div>
	</section>
	<footer>
		<jsp:include page="/views/common/footer.jsp"></jsp:include>
	</footer>
</body>

</html>