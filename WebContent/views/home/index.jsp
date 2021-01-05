<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	LoginManager lm = LoginManager.getInstance();
	String sq = lm.getMemberSq(session);
%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<title>메인화면</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/flatpickr.css">
	<link rel="stylesheet" type="text/css" href="https://npmcdn.com/flatpickr/dist/themes/airbnb.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css"
		integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/home/index.css">
	<link rel="stylesheet" href="/css/agreement.css">
	<link rel="stylesheet" href="/css/base.css">
	<link rel="stylesheet" href="/css/c_header.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap" rel="stylesheet">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/flatpickr.js"></script>
	<script src="/js/common/calendar.js" defer></script>
	<script src="/js/agreement/agree.js" defer></script>
	<script src="/js/common/c_header.js" type="text/javascript" defer></script>
</head>

<body>
	<%
		if (sq == null) {
	%>
	<header>
		   <jsp:include page="/views/common/header.jsp"></jsp:include>
	</header>
	<section>
		<div class="fir_container">
			<form action="/booking/Blist" id="ckpoint" method="get">
				<input type="text" class="form_input" id="basicDate" placeholder="언제가 편하신가요?" name="booking_date" data-input>
				<input type="text" class="form_input" id="basicTime" placeholder="예약시간" name="booking_start" data-input>
				<select class="form_input" id="" name="booking_people">
					<option class="form_input" value="1">1명</option>
					<option class="form_input" value="2">2명</option>
					<option class="form_input" value="3">3명</option>
					<option class="form_input" value="4">4명</option>
				</select>
				<button type="submit" class="form_input form_submit">
					<i class="fas fa-search"></i>
				</button>
			</form>
		</div>
	</section>

	<section>
		<div class="fir_container">
			<!-- 테스트용 -->
			<h1>테스트</h1>
		</div>
	</section>
	<section>
		<div class="fir_container">
			<!-- 테스트용 -->
			<h1>테스트</h1>
			</form>
		</div>
	</section>
	<section>
		<div class="fir_container">
			<!-- 테스트용 -->
			<h1>테스트</h1>
		</div>
	</section>
	<%
		} else {
	%>
	<header>
		  <jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>
	<section>
		<div class="fir_container">
			<form action="/booking/Blist" id="ckpoint" method="get">
				<input type="text" class="form_input" id="basicDate" placeholder="언제가 편하신가요?" name="booking_date" data-input>
				<input type="text" class="form_input" id="basicTime" placeholder="예약시간" name="booking_start" data-input>
				<select  class="form_input" id=""  name="booking_people">
					<option class="form_input" value="1">1명</option>
					<option class="form_input" value="2">2명</option>
					<option class="form_input" value="3">3명</option>
					<option class="form_input" value="4">4명</option> 
				</select>
				<button type="submit" class="form_input form_submit">
					<i class="fas fa-search"></i>
				</button>
			</form>
		</div>
	</section>
	<%
		}
	%>
	
	<script src="https://npmcdn.com/flatpickr/dist/flatpickr.min.js"></script>
	<script src="https://npmcdn.com/flatpickr/dist/l10n/ko.js"></script>
</body>

</html>