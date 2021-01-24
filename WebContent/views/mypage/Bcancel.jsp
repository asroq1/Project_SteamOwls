<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.steamowls.steam.booking.vo.BookingVo"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%
BookingVo vo = (BookingVo) request.getAttribute("vo");
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
<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/mypage/Bcancel.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap"
	rel="stylesheet">
<script src="/js/mypage/Bcancel.js" defer></script>
<title>예약취소</title>
</head>
<body>
	<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>
	<section>
		<div class="bill_container">
			<div class="bill_img">
				<img src="/css/picture/massage-1017255_640.png" alt="">
			</div>
			<div class="bill_date">
				<h3>예약날짜</h3>

				<p><%=vo.getBooking_date()%></p>
			</div>
			<div class="bill_time">
				<h3>예약시간</h3>
				<p><%=vo.getBooking_start()%>시
				</p>
			</div>
			<div class="bill_price">
				<h3>결제금액</h3>
				<p><%=won.format(vo.getProduct_price() * vo.getBooking_people())%>원
				</p>
			</div>
			<div class="bill_info">
				<h3>예약상품</h3>
				<p><%=vo.getProduct_name()%></p>
			</div>
		</div>
		<form action="/" method="POST">
			<a class="bill_submit" href="/mypage/BCancelProc?booking_sq=<%=vo.getBooking_sq()%>">예약취소</a>
		</form>
	</section>
	<footer>
		<jsp:include page="/views/common/footer.jsp"></jsp:include>
	</footer>
</body>
</html>