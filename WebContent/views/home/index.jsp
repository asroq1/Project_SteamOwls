<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
	<title>Using Flatpickr</title>
	<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/flatpickr.css">
	<link rel="stylesheet" type="text/css" href="https://npmcdn.com/flatpickr/dist/themes/airbnb.css">
	<link rel="stylesheet" href="/css/home/index.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css"
		integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
	<script src="/js/common/calendar.js" defer></script>
	<script src="/js/common/c_header.js" type="text/javascript" defer></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/flatpickr.js"></script>
<script>
	function log() {
		var basicDate = document.getElemnetById('basicDate');
		console.log(basicDate);
	}
</script>
</head>
<body>
	<%
		if (sq == null) {
	%>
	<header>
		<a href="/">
			<img src="/css/picture/owls.PNG" alt="로고사진">
		</a>
		<ul class="signForm">
			<li class="toggle_btn">
				<i class="fas fa-bars"></i>
			</li>
			<ul class="toggle_bar">
				<li><a href="/member/login">로그인</a></li>
				<li><a href="/member/signup">회원가입 </a></li>
				<li><a href="/admin">관리자</a></li>
			</ul>
		</ul>
	</header>
	<section>
		<div class="fir_container">
			<form action="/booking/book"id="ckpoint" method="get">
				<input type="text" class="form_input" id="basicDate" placeholder="언제가 편하신가요?" name="date" data-input>
				<input type="text" class="form_input" id="basicTime" placeholder="예약시간" name="time" data-input>
				<select name="people" class="form_input" id="" name="people">
					<option class="form_input" value="1">1명</option>
					<option class="form_input" value="2">2명</option>
					<option class="form_input" value="3">3명</option>
					<option class="form_input" value="4">4명</option>
				</select>
				<button class="form_input form_submit">
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
		<a href="/">
			<img src="/css/picture/owls.PNG" alt="로고사진">
		</a>
		<ul class="signForm">
			<li class="toggle_btn">
				<i class="fas fa-bars"></i>
			</li>
			<ul class="toggle_bar">
				<li><a href="//mypage/gotoMypage">마이페이지</a></li>
				<li><a href="/member/logout">로그아웃</a></li>
				<li><a href="/admin">관리자</a></li>
			</ul>
		</ul>
	</header>
	<section>
		<div class="fir_container">
			<form action="/booking/book" id="ckpoint">
				<input type="text" class="form_input" onchange="log()" name="date" id="basicDate" placeholder="언제가 편하신가요 ?" data-input>
				<input type="text" class="form_input" name="time" id="basicTime" placeholder="원하시는 시간을 선택해주세요." data-input> 
				<select class="form_input" name="people">
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
	<script>
		"js/flatpickr.js"
	</script>
	<script src="https://npmcdn.com/flatpickr/dist/flatpickr.min.js"></script>
	<script src="https://npmcdn.com/flatpickr/dist/l10n/ko.js"></script>
</body>

</html>