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
<title>리뷰수정</title>
<link rel="stylesheet" href="/css/base.css">
<link rel="stylesheet" href="/css/mypage/Rmodify.css">
	<script  src="/js/mypage/Rmodify.js" defer></script>	
</head>
<body>
	<section>
		<header>
			<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
		</header>
		<section>
			<form action="/mypage/RmyReviewModifyProc?board_sq=<%=mypageVo.getReview_sq() %>" method="post" id="editorForm">
				<div class="review__container">
				<div class="review__title">
					<h3>제목</h3>
					<input type="text" class="review__text" name="board_subject" value="<%=mypageVo.getReview_subject()%>" />
					
				</div>
				<div class="review__content">
					<h3>이용후기</h3>
					<textarea rows="10" cols="30" class="review__detail" name="review_content"><%=mypageVo.getReview_content()%></textarea>
				
				</div>
				<div class="review__star">
					<h3>평점</h3>
					<div class="review__star">
						<div class="startRadio">
							<label class="startRadio__box"> <input type="radio"
								name="review_star" id="" value="0.5"> <span
								class="startRadio__img"><span class="blind">별 1개</span></span>
							</label> <label class="startRadio__box"> <input type="radio"
								name="review_star" id="" value="1.0"> <span
								class="startRadio__img"><span class="blind">별 1.5개</span></span>
							</label> <label class="startRadio__box"> <input type="radio"
								name="review_star" id="" value="1.5"> <span
								class="startRadio__img"><span class="blind">별 2개</span></span>
							</label> <label class="startRadio__box"> <input type="radio"
								name="review_star" id="" value="2.0"> <span
								class="startRadio__img"><span class="blind">별 2.5개</span></span>
							</label> <label class="startRadio__box"> <input type="radio"
								name="review_star" id="" value="2.5"> <span
								class="startRadio__img"><span class="blind">별 3개</span></span>
							</label> <label class="startRadio__box"> <input type="radio"
								name="review_star" id="" value="3.0"> <span
								class="startRadio__img"><span class="blind">별 3.5개</span></span>
							</label> <label class="startRadio__box"> <input type="radio"
								name="review_star" id="" value="3.5"> <span
								class="startRadio__img"><span class="blind">별 4개</span></span>
							</label> <label class="startRadio__box"> <input type="radio"
								name="review_star" id="" value="4.0"> <span
								class="startRadio__img"><span class="blind">별 4.5개</span></span>
							</label> <label class="startRadio__box"> <input type="radio"
								name="review_star" id="" value="4.5"> <span
								class="startRadio__img"><span class="blind">별 5개</span></span>
							</label> <label class="startRadio__box"> <input type="radio"
								name="review_star" id="" value="5.0"> <span
								class="startRadio__img"><span class="blind">별 5.5개</span></span>
							</label>
						</div>
					</div>
				</div>
				<div class="btn__container">
					<%
						if (Integer.parseInt(sq) == mypageVo.getSq()) {
					%>
					<button id="modifyBtn">수정</button>
					<a href="/mypage/RmyReviewDetail?review_sq=<%=mypageVo.getReview_sq()%>">취소</a>
					<%
						}
					%>
				</div>
			</div>
			</form>
		</section>	
		
</body>
</html>