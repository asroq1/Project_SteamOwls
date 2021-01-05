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
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약내역</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/mypage/Bhistory.css">
</head>
<body>

	<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>
	<section>
		<div class="booking_container">
			<div class="booking_img">
				<%-- <!-- <%=list.get(i).getProduct_image()%> --> --%>
				<img src="/css/picture/massage-1017255_640.png" alt="">
			</div>
			<div class="title__top">
				<div class="booking__title">
					<h3>
						<h3>예약상품</h3>
						<p>A-초특급 코오스</p>
						<%-- <p><%=bookingVo.getProduct_name()%></p> --%>
					</h3>
					<div class="booking__intro">
						<h3>상품내역</h3>
						<p>디스 이즈 왓더 와우</p>
						<%-- <p><%=bookingVo.getProduct_detail()%></p> --%>
					</div>
				</div>
				<div class="booking_bottom">
					<div class="booking_info">
						<h3>인원</h3>
						<p>4명</p>
						<%-- <p><%=bookingVo.getBooking_people()%></p> --%>
						<p>
						<h3>금액</h3>
						30000원
						<%-- <p><%=bookingVo.getProduct_price()%></p> --%>
						</p>
					</div>
				</div>
			</div>
		</div>
		<div class="btn-container">
			<a href="/mypage/BCancel">예약취소</a>
			<a href="/mypage/BChange">예약변경</a>
		</div>
	</section>
	<!-- 
<a href="/mypage/BCancel">예약취소</a>
<a href="/mypage/BChange">예약변경</a>
<a href="/mypage/BDetail">예약확인</a>
</body> -->
</html>