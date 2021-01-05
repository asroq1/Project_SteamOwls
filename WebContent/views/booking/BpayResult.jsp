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
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제완료</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/agreement.css">
<link rel="stylesheet" href="/css/c_header.css">
<link rel="stylesheet" href="/css/booking/BpayResult.css">
<script src="/js/agreement/agree.js" defer></script>
</head>
<body>
	<header>
		<a href="/"> <img src="/css/picture/owls.PNG" alt="로고사진">
		</a>
		<ul class="signForm">
			<li class="toggle_btn"><i class="fas fa-bars"></i></li>
			<ul class="toggle_bar">
				<li><a href="/member/login">로그인</a></li>
				<li><a href="/member/signup">회원가입</a></li>
			</ul>
		</ul>
	</header>
	<section>
		<div class="bill_container">
			<div class="bill_img">
				<img src="/css/picture/massage-1017255_640.png" alt="">
			</div>
			<div class="bill_date">
				<h3>예약날짜</h3>
				<p><%=bookingVo.getBooking_date()%></p>
			</div>
			<div class="bill_time">
				<h3>예약시간</h3>
				<p><%=bookingVo.getBooking_start() %>시</p>
			</div>
			<!-- 예약인원도 넣어주셈 -->
			<div class="bill_price">
				<h3>결제금액</h3>
				<p><%=bookingVo.getProduct_price() %>원</p>
			</div>
			<div class="bill_info">
				<h3>예약상품</h3>
				<p><%=bookingVo.getProduct_name() %></p>
			</div>
		</div>
		<form action="/pay/Ppay" method="POST">
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