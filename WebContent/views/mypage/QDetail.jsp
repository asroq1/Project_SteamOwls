<%@page import="java.util.ArrayList"%>
<%@page import="shop.steamowls.steam.mypage.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<BoardVo> list = (ArrayList<BoardVo>) request.getAttribute("list");
BoardVo vo = (BoardVo) request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<body>
<h1>글 상세보기</h1>
<br>
<h3>문의 번호 : <%=vo.getBoard_sq()%></h3>
<h3>제목 : <%=vo.getBoard_subject()%></h3>
<h3>내용 : <%=vo.getBoard_content()%></h3>
<h3>작성자 : <%=vo.getMember_id()%></h3>
<h3>날짜 : <%=vo.getBoard_dttm()%></h3>


<a href="/mypage/QModify?board_sq=<%=vo.getBoard_sq()%>">글수정</a>
<a href="/mypage/QDelete?board_sq=<%=vo.getBoard_sq()%>">글삭제</a>
<a href="/mypage/question">문의목록으로</a>
</body>
</html>