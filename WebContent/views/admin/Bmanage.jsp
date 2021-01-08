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
<title>예약관리</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/admin/Bmanage.css">
<link rel="stylesheet" href="/css/mypage/Bhistory.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.1/css/all.css"
	integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/flatpickr.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/flatpickr.js"></script>
<script src="/js/common/calendar.js" defer></script>
</head>
<body>
	<header>
		<div class="header__logo">
			<a href="/views/home/index.jsp"> <img src="/css/picture/owls.PNG"
				alt="로고사진">
			</a>
		</div>
		<div class="header__signForm">
			<a href="/admin/Alogout">로그아웃</a>
		</div>
	</header>
	<nav role="navigation">
		<jsp:include page="/views/common/admin-nav.jsp"></jsp:include>
	</nav>
	<section>
		<div>
			<form action="/admin/BmanageProc" id="ckpoint" method="get">
				<input type="text" class="form_input" id="basicDate"
					placeholder="언제가 편하신가요?" name="booking_date" data-input> <input
					type="text" class="form_input" id="basicTime" placeholder="예약시간"
					name="booking_start" data-input>
				<button type="submit" class="form_input form_submit">
					<i class="fas fa-search"></i>
				</button>
			</form>
		</div>
	</section>
	<%
	for (int i = 0; i < list.size(); i++) {
	%>
	<section>

		<!-- 주석 풀고 다시 사용하면 됩니다.  -->
		<div class="booking_container">
			<div class="booking_img">
				<%=list.get(i).getProduct_imagePath()%>
			</div>
			<div class="booking__top">
				<div class="booking__title">
					<h3 class="booking__title">고객성함</h3>
					<p class="booking__text">
						<%=list.get(i).getName()%>
					</p>
					<h3 class="booking__title">예약상품</h3>
					<p class="booking__text">
						<%=list.get(i).getProduct_name()%>
					</p>
				</div>
				<div class="booking__intro">
					<h3 class="booking__title">예약일자</h3>
					<p class="booking__text">
						<%=list.get(i).getBooking_date()%>
						<%=list.get(i).getBooking_start()%>시
					</p>
				</div>
			</div>
			<div class="booking_bottom">
				<div class="booking_people">
					<h3 class="booking__title">인원</h3>
					<p class="booking__text">
						<%=list.get(i).getBooking_people()%>명
					</p>
				</div>
				<div class="booking_price">
					<h3 class="booking__title">금액</h3>
					<p class="booking__text">
						<%=list.get(i).getProduct_price()%>원
					</p>
				</div>
			</div>
			<div class="btn-container">
				<a href="/admin/Bcancel?booking_sq=<%=list.get(i).getBooking_sq()%>">예약취소</a>
			</div>
		</div>
	</section>
	<%
	}
	%>
</body>

</html>