<%@page import="shop.steamowls.common.LoginManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리뷰작성</title>
	<link href="/css/picture/icons8_owl.ico" rel="shortcut icon" type="image/x-icon">
    <link rel="stylesheet" href="/css/mypage/Rwriting.css">
    <link rel="stylesheet" href="/css/base.css">
    <script src="/js/mypage/Rwriting.js" defer></script>
</head>

<body>
    <header>
        <jsp:include page="/views/common/header-logout.jsp"></jsp:include>
    </header>
    <form action="/mypage/RwritingProc" method="POST" id="checkPoint">
    
    	 <div class="review__rating">
            <span>
                <h2>별점</h2>
            </span>
            <div class="startRadio">
                <label class="startRadio__box">
                    <input type="radio" name="review_star" class="rating__star" value="0.5">
                    <span class="startRadio__img"><span class="blind">0.5</span></span>
                </label>
                <label class="startRadio__box">
                    <input type="radio" name="review_star" class="rating__star" value="1.0">
                    <span class="startRadio__img"><span class="blind">1.0</span></span>
                </label>
                <label class="startRadio__box">
                    <input type="radio" name="review_star" class="rating__star" value="1.5">
                    <span class="startRadio__img"><span class="blind">1.5</span></span>
                </label>
                <label class="startRadio__box">
                    <input type="radio" name="review_star" class="rating__star" value="2.0">
                    <span class="startRadio__img"><span class="blind">2.0</span></span>
                </label>
                <label class="startRadio__box">
                    <input type="radio" name="review_star" class="rating__star" value="2.5">
                    <span class="startRadio__img"><span class="blind">2.5</span></span>
                </label>
                <label class="startRadio__box">
                    <input type="radio" name="review_star" class="rating__star" value="3.0">
                    <span class="startRadio__img"><span class="blind">3.0</span></span>
                </label>
                <label class="startRadio__box">
                    <input type="radio" name="review_star" class="rating__star" value="3.5">
                    <span class="startRadio__img"><span class="blind">3.5</span></span>
                </label>
                <label class="startRadio__box">
                    <input type="radio" name="review_star" class="rating__star" value="4.0">
                    <span class="startRadio__img"><span class="blind">4.0</span></span>
                </label>
                <label class="startRadio__box">
                    <input type="radio" name="review_star" class="rating__star" value="4.5">
                    <span class="startRadio__img"><span class="blind">4.5</span></span>
                </label>
                <label class="startRadio__box">
                    <input type="radio" name="review_star" class="rating__star" value="5.0">
                    <span class="startRadio__img"><span class="blind">별 5.0</span></span>
                </label>
            </div>
        </div>
        
        <div class="review__title">
            <span>
                <h2>제목</h2>
            </span>
            <input type="text" id="review__subject" name="review_subject" maxlength="50">
        </div>


        <div class="review__detail">
            <span>
                <h2>이용후기</h2>
            </span>
            <textarea id="detail__form" name="review_content" rows="5" placeholder="자세한 리뷰는 고객의 예약에 많은 도움이 됩니다." maxlength="200"></textarea>
        </div>
    </form>
    <div class="review__btn">
        <button type="button" id="submit__btn">등록하기</button>
    </div>
</body>

</html>