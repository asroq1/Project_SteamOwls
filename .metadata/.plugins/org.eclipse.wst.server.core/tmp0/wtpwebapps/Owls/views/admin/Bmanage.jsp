<%@page import="java.text.DecimalFormat"%>
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
DecimalFormat won = new DecimalFormat("###,###");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>예약관리</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/admin/Bmanage.css">
<link rel="stylesheet" href="/css/mypage/Bhistory.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/flatpickr.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/flatpickr.js"></script>
<script src="/js/common/calendar.js" defer></script>
<script src="/js/admin/Bdelete.js"></script>
</head>
<body>
	<header>
		<jsp:include page="/views/common/adminHeader.jsp"></jsp:include>
	</header>
	<nav role="navigation">
		<jsp:include page="/views/common/admin-nav.jsp"></jsp:include>
	</nav>
	<section>
	<article>
		<div>
			<form action="/admin/BmanageProc" id="ckpoint" method="get">
				<input type="text" class="form_input" id="basicDate" placeholder="예약날짜" name="booking_date" data-input>
				<button type="submit" class="form_input form_submit">
					<i class="fas fa-search"></i>
				</button>
			</form>
		</div>
	
	</article>
	<%
		for (int i = 0; i < list.size(); i++) {
	%>
	<article>
		<div class="booking__container">
			<div class="booking__img">
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
			<div class="booking__bottom">
				<div class="booking__people">
					<h3 class="booking__title">인원</h3>
					<p class="booking__text">
						<%=list.get(i).getBooking_people()%>명
					</p>
				</div>
				<div class="booking__price">
					<h3 class="booking__title">금액</h3>
					<p class="booking__text">
						<%=won.format(list.get(i).getProduct_price() * list.get(i).getBooking_people())%>원
					</p>
				</div>
			</div>
			<div class="btn__container">
				<button id="cancel__btn" onclick="bookingDelete(<%=list.get(i).getBooking_sq()%>)">예약취소</button>
			</div>
		</div>
		<%
		}
		%>
	</article>
	</section>

	<footer>
		<jsp:include page="/views/common/footer.jsp"></jsp:include>
	</footer>
</body>

</html>