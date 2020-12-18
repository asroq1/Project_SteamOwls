<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록화면</title>
<script type="text/javascript">

 function registerArticle(){
	 var sj = $(#sj);
	 var cntnt = $(#cntnt);

	 if(!sj.val()){
		alert("제목을 입력");
		sj.focus();
		return;
		}	
	 saveCount();
	 
	 }

 	
 </script>

</head>
<body>
	<header>
		<div class="header__logo"></div>
		<div class="header__signForm">
			<a href="">로그아웃</a>
		</div>
	</header>
	<form action="/admin/productManage" method="post" id="editorForm">


		<h2>상품등록</h2>
		<!-- <label for="img">이미지</label>
<input type="file" name="img" id="img" >

<label for="title">제목</label>
<input type="text" name="title" id="title" >

<label for="intro">상품설명</label>
<input type="text" name="intro" id="intro" >

<label for="price">가격</label>
<input type="text" name="price" id="price" > -->

		<div>
			<jsp:include page="/editor/editorSkinForRegister.jsp" flush="false" />
		</div>
		<button type="submit" onclick="#()">등록</button>
	</form>

</body>
</html> --%>

<%-- <%
HttpSession session = request.getSession()%>
<%= session.getAttribute("a")%>
 --%>
 
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>



</script>
</head>
<body>
상품추가화면
상품상세란에 정보 기입
<form>
	<div>상품</div>
	<!-- 이거되면 그냥 창문에 뛰어내린다 얏호 -->
	<!-- 탈출은 능지순 -->
	<%-- <jsp:includ page="/editor/editorSkinForRegister.jsp" flush="false"/> --%>
</form>
<a href="/admin/productManage">상품추가</a>

</body>
</html>