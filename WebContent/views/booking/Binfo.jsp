<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
/* String booking_date = 
String booking_start = 
String booking_people =
String product_sq =
여기서 날짜, 시간, 인원, 상품정보 들고 같이 결제확인까지 들고가기
post방식 이용
*/
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
	<link rel="stylesheet" href="/css/agreement.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css"
		integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
	<script src="/js/common/c_header.js" defer></script>
	<script src="/js/agreement/agree.js" defer></script>
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
        <div class="Binfo_container">
            <div class="Binfo">
                <div class="Binfo_date">
                    <h3>예약날짜</h3>
                    <p>2000-01-01</p>
                </div>
                <div class="Binfo_time">
                    <h3>시간</h3>
                    <p>00 : 00 </p>
                </div>
                <div class="Binfo_people">
                    <h3>인원</h3>
                    <p>4명</p>
                </div>
                <div class="Binfo_info">
                    <h3>예약상품</h3>
                    <p>매우 좋은 아울스의 대표 코스입니다 ! 어쩌고 저쩌고 쌀롸쌀롸</p>
                </div>
                <div class="Binfo_submit">
                    <!-- 액션에 데이터값 입력 필요 -->
                    <form action="/pay/Pinfo">
                        <button class="booking_btn">결제하기</button>
                    </form>
                </div>
            </div>
            <div class="Binfo_img">
                <img src="/css/picture/owls.PNG" alt="상품사진">
            </div>
        </div>
    </section>
	<footer>
        <div class="signup__form">
            <a href="#" class="agreement" onclick="createFeed()">이용약관</a>
            <a href="#"  class="agreement" onclick="createFeed()">개인정보 보호정책</a>
        </div>
	</footer>

</body>

</html>