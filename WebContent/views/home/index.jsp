<%@page import="shop.steamowls.steam.mypage.vo.BoardVo"%>
<%@page import="shop.steamowls.steam.admin.review.vo.ReviewVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.steamowls.steam.mypage.vo.MypageVo"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
MypageVo mypageVo = (MypageVo) request.getAttribute("vo");
ArrayList<MypageVo> list = (ArrayList<MypageVo>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Owls</title>
	<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/flatpickr.css">
	<link rel="stylesheet" type="text/css" href="https://npmcdn.com/flatpickr/dist/themes/airbnb.css">
	<link rel="stylesheet" href="/css/home/index.css">
	<link rel="stylesheet" href="/css/agreement.css">
	<link rel="stylesheet" href="/css/base.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link rel="stylesheet" href="/css/mypage/Rwriting.css">
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap" rel="stylesheet">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/flatpickr.js" defer></script>
	<script src="https://npmcdn.com/flatpickr/dist/flatpickr.min.js" defer></script>
	<script src="https://npmcdn.com/flatpickr/dist/l10n/ko.js" defer></script>
	<script src="/js/common/calendar.js" defer></script>
	<script src="/js/agreement/agree.js" defer></script>
	<script src="/js/home/index.js" defer></script>
</head>

<body>
	<%
		if (sq == null) {
	%>
	<header>
		<jsp:include page="/views/common/header.jsp"></jsp:include>
	</header>
	<section>
		<form action="/booking/Blist" id="ckpoint" method="get">
			<input type="text" class="form_input" id="basicDate" placeholder="언제가 편하신가요?" name="booking_date"
				data-input> <input type="text" class="form_input" id="basicTime" placeholder="예약시간" name="booking_start"
				data-input> <select class="form_input input__btn" name="booking_people">
				<option class="form_input" value="1">1명</option>
				<option class="form_input" value="2">2명</option>
				<option class="form_input" value="3">3명</option>
				<option class="form_input" value="4">4명</option>
			</select>
			<button type="submit" class="form_input form_submit">
				<i class="fas fa-search"></i>
			</button>
		</form>
		<div class="main__intro"></div>
		<div class="img__container">
			<img src="/css/picture/Spa.png" alt="main">
		</div>
	</section>
	<%
		} else {
	%>
	<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>
	`
	<section>
		<form action="/booking/Blist" id="ckpoint" method="get">
			<input type="text" class="form_input" id="basicDate" placeholder="언제가 편하신가요?" name="booking_date"
				data-input> <input type="text" class="form_input" id="basicTime" placeholder="예약시간" name="booking_start"
				data-input> <select class="form_input input__btn" name="booking_people">
				<option class="form_input" value="1">1명</option>
				<option class="form_input" value="2">2명</option>
				<option class="form_input" value="3">3명</option>
				<option class="form_input" value="4">4명</option>
			</select>
			<button type="submit" class="form_input form_submit">
				<i class="fas fa-search"></i>
			</button>
		</form>
		<div class="img__container">
			<img src="/css/picture/Spa.png" alt="main">
		</div>
	</section>
	<%
		}
	%>

	<article>
		<div class="intro__container">
			<h1 class="slider__intro">수백만 명에 이르는 아울스 회원의 리뷰어가 되어보세요.</h1>

		</div>
		<div id="slider">

			<%
				for (int i = 1; i < list.size(); i++) {
			%>
			<div class="slider__item">
				<!-- 박스 1 -->
				<div class="review__box">
					<div class="review__top">
						<div class="review__title">
							<%=list.get(i).getReview_subject()%>
						</div>
						<div class="review__name">
							<%=list.get(i).getId()%>
						</div>
						<div class="review__star">
							<span class="star"> <i class="fas fa-star"></i>
							</span>
							<%=list.get(i).getReview_star()%>
						</div>
					</div>
					<div class="review__bottom">
						<%=list.get(i).getReview_content()%>
					</div>
				</div>
				<!-- 박스 1 -->

				<!-- 박스2 -->
				<div class="review__box">
					<div class="review__top">
						<div class="review__title">
							<%=list.get(i-1).getReview_subject()%>
						</div>
						<div class="review__name">
							<%=list.get(i-1).getId()%>
						</div>
						<div class="review__star">
							<span class="star"> <i class="fas fa-star"></i>
							</span>
							<%=list.get(i-1).getReview_star()%>
						</div>
					</div>
					<div class="review__bottom">
						<%=list.get(i-1).getReview_content()%>
					</div>
				</div>
			</div>
			<!-- 박스2-->
			<% } %>
		</div>

		<div class="btn__container">
			<button class="btn prev"> < </button>
			<button class="btn next"> > </button>
		</div>
	</article>
	<section>
		<div class="wrapper">
			<div class="intro__container">
				<h1>이제, 스파는</h1>
				<h1>더 특별해진 아울스에서</h1>
			</div>
			<div class="info__container">
				<div class="info__box">
					<img src="/css/picture/picForSlide/massage-835468_1280.jpg">
					<div class="info__text">헤드 마사지</div>
				</div>
				<div class="info__box">
					<img src="/css/picture/picForSlide/treatment-1327811_1280.jpg">
					<div class="info__text">지압</div>
				</div>
				<div class="info__box">
					<img src="/css/picture/picForSlide/spa-3184610_1280.jpg">
					<div class="info__text">핫스톤 마사지</div>
				</div>
				<div class="info__box">
					<img src="/css/picture/picForSlide/massage-1929064_1280.jpg">
					<div class="info__text">24시간 풀케어</div>
				</div>
			</div>
		</div>
	</section>
	<footer>
		<jsp:include page="/views/common/footer.jsp"></jsp:include>
	</footer>
</body>

</html>