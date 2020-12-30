<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제화면</title>
<link rel="stylesheet" href="/css/c_header.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css"integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/booking/payment.css">
<script src="/js/common/c_header.js" defer></script>
</head>
<body>
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
	<section>
		<form action="/pay/Pinfo">
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
		<!-- <button type="submit" id="ckpoint">
					결제하기
				</button> -->
		<a href="/views/booking/Pinfo.jsp">결제</a>
		</div>
		<!-- <div class="pay_detail_container">
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
		</div> -->
	</form>	
	</section>

</body>
</html>