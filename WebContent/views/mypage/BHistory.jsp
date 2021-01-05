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
			<div class="booking__top">
				<div class="booking__title">
					<h3>
						<h3>예약상품</h3>
						<p>A-초특급 코오스</p>
						<%-- <p><%=bookingVo.getProduct_name()%></p> --%>
					</h3>
				</div>
				<div class="booking__intro">
					<h3>상품내역</h3>
					<p>수비상황에서 집중해야 합니다
					아! 이게 뭔가요!
					자! 끊어내고 올라갑니다
					제라드! 골키퍼와 일대일 기회 제라드!</p>
					<%-- <p><%=bookingVo.getProduct_detail()%></p> --%>
				</div>
			</div>
			<div class="booking_bottom">
				<div class="booking_people">
					<h3>인원</h3>
					<p>4명</p>
					<%-- <p><%=bookingVo.getBooking_people()%></p> --%>
					<p>
				</div>
				<div class="booking_price">
					<h3>금액</h3>
					<p>
						30000원
						<%-- <p><%=bookingVo.getProduct_price()%></p> --%>
					</p>
				</div>
			</div>
			<div class="btn-container">
				<a href="/mypage/BChange">예약변경</a>
				<a href="/mypage/BCancel">예약취소</a>
			</div>
		</div>
	</section>
	<footer>
		  <jsp:include page="/views/common/footer.jsp"></jsp:include>
	</footer>
	<!-- 
<a href="/mypage/BCancel">예약취소</a>
<a href="/mypage/BChange">예약변경</a>
<a href="/mypage/BDetail">예약확인</a>
</body> -->
</html>