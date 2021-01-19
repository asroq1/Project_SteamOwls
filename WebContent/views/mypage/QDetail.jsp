<%@page import="shop.steamowls.common.LoginManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="shop.steamowls.steam.mypage.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<BoardVo> list = (ArrayList<BoardVo>) request.getAttribute("list");
BoardVo vo = (BoardVo) request.getAttribute("vo");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>상세페이지</title>
</head>

<body>
    <header>
        <jsp:include page="/views/common/header-logout.jsp"></jsp:include>
    </header>
    <h1>Article Detail</h1>
    <br>
    <h3>NO : <%=vo.getBoard_sq()%></h3>
    <h3>SUBJECT : <%=vo.getBoard_subject()%></h3>
    <h3>CONTENT : <%=vo.getBoard_content()%></h3>
    <h3>ID : <%=vo.getMember_id()%></h3>
    <h3>DATE : <%=vo.getBoard_dttm()%></h3>

    <%if(Integer.parseInt(sq) == vo.getMember_sq()){ %>
    <a href="/mypage/QModify?board_sq=<%=vo.getBoard_sq()%>">글수정</a>
    <a href="/mypage/QDelete?board_sq=<%=vo.getBoard_sq()%>">글삭제</a>
    <%} %>
    <a href="/mypage/question">문의목록으로</a>
</body>

</html>