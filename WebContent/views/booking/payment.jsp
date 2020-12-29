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
<title>결제완료</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/booking/payment.css">
<link rel="stylesheet" href="/css/c_header.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.1/css/all.css"
	integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp"
	crossorigin="anonymous">
<script src="/js/common/c_header.js" defer></script>

</head>
<body>
	<%
	 if (sq == null) {
	%>
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
	
	<%
		} else {
	%>
	<header>
		<a href="/"> <img src="/css/picture/owls.PNG" alt="로고사진">
		</a>
		<ul class="signForm">
			<li class="toggle_btn"><i class="fas fa-bars"></i></li>
			<ul class="toggle_bar">
				<li><a href="/mypage/gotoMypage">마이페이지</a></li>
				<li><a href="/member/logout">로그아웃</a></li>
			</ul>
		</ul>
	</header>
	<%
		}
	%>
	<section>
		<div class="pay_form">
			<div class="pay_info_container">
				<div class="pay_info">
					<h1 class="info_title cut_line">예약 정보</h1>
					<div class="info_date">
						<h3>날짜</h3>
						<p class="intro_sub">2020-12-25</p>
					</div>
					<div class="info_people">
						<h3>인원</h3>
						<p class="intro_sub cut_line">인원 2명</p>
					</div>
				</div>
				<div class="pay_way cut_line">
					<h2>결제 수단</h2>
					<select value="way">
						<option name="네이버페이" id="">네이버페이</option>
						<option name="카카오페이" id="">카카오페이</option>
						<option name="신용 카드" id="">신용 카드</option>
						<option name="계좌이체" id="">계좌이체</option>
					</select>
				</div>
				<div class="pay_agree">
					<label for="agreement">결제약관에 동의하신다면 확인해주세요.</label>
					 <input type="checkbox" name="agreement" id="agreement">
				</div>
				<!-- <a href="/views/booking/bookingSuccess.jsp">결제완료</a> -->
				<button type="submit" id="ckpoint">
					결제하기
				</button>
			</div>
			<div class="pay_detail_container">
				<div class="detail_img_container">
					<div class="detail_img">
						<img src="/css/picture/massage-1017255_640.png" alt="상품사진">
						<div class="intro_sub cut_line">우리의 떙떙쓰 파리투나잇 와우 언빌리버블
							마사즤입니다.</div>
					</div>
				</div>
				<div class="detail_info_container">
					<h1>요금 세부정보</h1>
					<p class="intro_sub">가격 16,000</p>
					<p class="intro_sub">인원 2명</p>
					<p>총 합계 (KRW) 32,000</p>
				</div>
			</div>
		</div>
	</section>
	<footer>
		<!-- 추후에 작성해야함. -->
	</footer>
	<script src="/js/booking/payment.js" defer></script>
</body>

</html>

