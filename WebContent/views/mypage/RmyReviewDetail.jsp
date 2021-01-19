<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="shop.steamowls.steam.mypage.vo.MypageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% MypageVo mypageVo = (MypageVo) request.getAttribute("vo"); 
    LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <header>
        <jsp:include page="/views/common/header-logout.jsp"></jsp:include>
    </header>
    <h1>Article Detail</h1>
    <br>
    <h3>NO : <%=mypageVo.getReview_sq()%></h3>
    <h3>SUBJECT : <%=mypageVo.getReview_subject()%></h3>
    <h3>CONTENT : <%=mypageVo.getReview_content()%></h3>
    <h3>STAR : <%=mypageVo.getReview_star()%></h3>
    <h3>DATE : <%=mypageVo.getReview_dttm()%></h3>

    <%if(Integer.parseInt(sq) == mypageVo.getSq()){ %>
    <a href="/mypage/RmyReviewModify?review_sq=<%=mypageVo.getReview_sq()%>">글수정</a>
    <a href="/mypage/RmyReviewDelete?review_sq=<%=mypageVo.getReview_sq()%>">글삭제</a>

    <%} %>
    <a href="/mypage/RmyReview">확인</a>
</body>

</html>