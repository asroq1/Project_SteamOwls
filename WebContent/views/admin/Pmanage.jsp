<%@page import="java.text.DecimalFormat"%>
<%@page import="shop.steamowls.steam.admin.product.vo.ProductVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="shop.steamowls.steam.member.vo.MemberVo"%>
<%@page import="shop.steamowls.steam.admin.product.vo.ProductVo"%>
<%@page import="shop.steamowls.common.LoginManager"%>
<%

ProductVo productVo = (ProductVo) request.getAttribute("productVo");
MemberVo vo = (MemberVo) request.getAttribute("vo");
LoginManager lm = LoginManager.getInstance();
String sq = lm.getMemberSq(session);
ArrayList<ProductVo> list = (ArrayList<ProductVo>) request.getAttribute("list");
DecimalFormat won = new DecimalFormat("###,###");
%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<title>상품관리</title>
	<link rel="stylesheet" href="/css/base.css">
	<link rel="stylesheet" href="/css/admin/gotoAdmin.css">
	<link rel="stylesheet" href="/css/admin/productManage.css">
</head>

<body>
	<header>
		<jsp:include page="/views/common/header-logout.jsp"></jsp:include>
	</header>
	<nav role="navigation">
		 <jsp:include page="/views/common/admin-nav.jsp"></jsp:include>	
	</nav>
	<%
		for (int i = 0; i < list.size(); i++) {
	%>
	<section>
		<form
			action="/admin/PdeleteProc?product_sq=<%=list.get(i).getProduct_sq()%>"
			class="form__container" method="post" id="ckpoint">
			<div class="booking__Form">

				<div class="booking_img">
					<!-- 로컬환경이라서 임시로 레이아웃 조절을 위해 주석처리 -->
					<!-- <%=list.get(i).getProduct_image()%> -->
					<img src="/css/picture/massage-1017255_640.png" alt="">
				</div>
				<div class="title__top">
					<div class="booking__title">
						<h3>
							<%=list.get(i).getProduct_name()%>
						</h3>
					</div>
					<div class="booking_bottom">
						<div class="booking__intro">
							<p>
								<%=list.get(i).getProduct_detail()%>
							</p>
						</div>
						<div class="booking_info">
							<p>
								<%=won.format(list.get(i).getProduct_price())%>원
							</p>
						</div>
					</div>
				</div>

			</div>
			<div class="booking__confirm">
				<input class="confirm__add" type="submit" value="상품판매" formaction="/admin/PsellingButton?product_sq=<%=list.get(i).getProduct_sq()%>">
				<input class="confirm__delete" type="submit" value="판매정지" formaction="/admin/PstopButton?product_sq=<%=list.get(i).getProduct_sq()%>">
		</div>
		</form>
	</section>
	<%
		}
	%>
</body>

</html>