<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>결제화면</title>
<link rel="stylesheet" href="/css/c_header.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.1/css/all.css"
	integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/agreement.css">
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/booking/payment.css">
<script src="/js/common/c_header.js" defer></script>
<script src="/js/booking/payment.js" defer></script>
<script src="/js/agreement/agree.js" defer></script>
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
		<form action="/pay/Pinfo" id="ckpoint">
			<div class="pay_way">
				<h2 class="pay_form">결제 수단</h2>
				<select value="way" class="pay_form">
					<option name="네이버페이" id="">네이버페이</option>
					<option name="카카오페이" id="">카카오페이</option>
					<option name="신용 카드" id="">신용 카드</option>
					<option name="계좌이체" id="">계좌이체</option>
				</select>
			</div>
			<div class="pay_agree">
				<input type="checkbox" name="agreement" id="agreement" class="pay_form">
				<label for="agreement" class="pay_form">결제약관에 동의해주세요.</label> 
			</div>
			<form action="/pay/Pinfo" method="GET">
				<button type="submit" id="Pinfo_submit">
					결제하기
				</button>
			</form> 
			</div>
		</form>
	</section>
	<footer>
        <div class="signup__form">
            <a href="#" class="agreement" onclick="createFeed()">이용약관</a>
            <a href="#"  class="agreement" onclick="createFeed()">개인정보 보호정책</a>
        </div>
	</footer>
</body>
</html>