<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="shop.steamowls.steam.mypage.vo.MypageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MypageVo mypageVo = (MypageVo) request.getAttribute("vo");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>상세리뷰</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/mypage/Rdetail.css">
</head>
<body>
	<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>

	<section>
		<div class="review__container">
			<div class="reivew__title">
				<h3>글제목</h3>
				<p class="review__text"><%=mypageVo.getReview_subject()%></p>
			</div>
			<div class="review__content">
				<h3>글내용</h3>
				<p class="review__text">
					<%=mypageVo.getReview_content()%></p>
			</div>

			<div class="review__date">
				<h3>작성일</h3>
				<p class="review__text"><%=mypageVo.getReview_dttm()%></p>
			</div>

			<div class="review__star">
				<h3>평점</h3>
				<div class="review__text review__star">
					 <i class="fas fa-star"></i>
					<%=mypageVo.getReview_star()%>
				</div>
			</div>
					<div class="btn__container">
		<%
			if (Integer.parseInt(sq) == mypageVo.getSq()) {
		%>
		<a 	href="/mypage/RmyReviewModify?review_sq=<%=mypageVo.getReview_sq()%>">수정</a>
		<a 	href="/mypage/RmyReviewDelete?review_sq=<%=mypageVo.getReview_sq()%>">삭제</a>

		<%
			}
		%>
	</div>
		</div>

	</section>	

	
	<!-- 
<a href="/mypage/RmyReview">확인</a> -->
</body>
</html>