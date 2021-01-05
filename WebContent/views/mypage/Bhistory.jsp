<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약내역</title>
	<link rel="stylesheet" href="/css/base.css">
</head>
<body>

<header>
	 <jsp:include page="/views/common/header-logout.jsp"></jsp:include>
</header>
<section>
	<form
		action="/admin/PdeleteProc?product_sq=<%-- <%=list.get(i).getProduct_sq()%> --%>"
		class="form__container" method="post" id="ckpoint">
		<div class="booking__Form">

			<div class="booking_img">
				<%-- <!-- <%=list.get(i).getProduct_image()%> --> --%>
				<img src="/css/picture/massage-1017255_640.png" alt="">
			</div>
			<div class="title__top">
				<div class="booking__title">
					<h3>
					<%-- 	<%=list.get(i).getProduct_name()%> --%>
					</h3>
				</div>
				<div class="booking_bottom">
					<div class="booking__intro">
						<p>
						<%-- 	<%=list.get(i).getProduct_detail()%> --%>
						</p>
					</div>
					<div class="booking_info">
						<p>
							<%-- <%=list.get(i).getProduct_people()%>명 --%>
						</p>
						<p>
							<%-- <%=list.get(i).getProduct_price()%> --%>
						</p>
					</div>
				</div>
			</div>

		</div>
	</form>
</section>
<!-- 
<a href="/mypage/BCancel">예약취소</a>
<a href="/mypage/BChange">예약변경</a>
<a href="/mypage/BDetail">예약확인</a>
</body> -->
</html>