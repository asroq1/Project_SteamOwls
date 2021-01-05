<%@page import="java.util.ArrayList"%>
<%@page import="shop.steamowls.steam.booking.vo.BookingVo"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<BookingVo> list = (ArrayList<BookingVo>) request.getAttribute("list");
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
	<%
		for (int i = 0; i < list.size(); i++) {
	%>
	<section>
		<div class="booking_container">
			<div class="booking_img">
					<%=list.get(i).getProduct_imagePath()%>
			</div>
			<div class="booking__top">
				<div class="booking__title">
					<h3>
						<h3>예약상품</h3>
						<%=list.get(i).getProduct_name()%>
					</h3>
				</div>
				<div class="booking__intro">
					<h3>상품내역</h3>
						<%=list.get(i).getProduct_detail()%>
				</div>
			</div>
			<div class="booking_bottom">
				<div class="booking_people">
					<h3>인원</h3>
						<%=list.get(i).getBooking_people()%>
					<p>
				</div>
				<div class="booking_price">
					<h3>금액</h3>
					<p>
						<%=list.get(i).getProduct_price()%>원
					</p>
				</div>
			</div>
			<div class="btn-container">
				<a href="/mypage/BCancel?booking_sq=<%=list.get(i).getBooking_sq()%>">예약취소</a>
			</div>
		</div>
	</section>
	<%
		}
	%>
	<footer>
		  <jsp:include page="/views/common/footer.jsp"></jsp:include>
	</footer>
	<!-- 
<a href="/mypage/BCancel">예약취소</a>
<a href="/mypage/BChange">예약변경</a>
<a href="/mypage/BDetail">예약확인</a>
</body> -->
</html>