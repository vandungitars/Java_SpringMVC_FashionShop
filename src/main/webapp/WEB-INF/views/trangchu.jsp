<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SHOP FASHION</title>
<jsp:include page="header.jsp"/>
</head>
<body>
	<div id="header-trangchu" class="container-fluid">
		<nav id="none-navbar" class="navbar navbar-default">
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			    <div class="navbar-header">
			      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
			      <a class="navbar-brand" href="#"><img style="width: 50px; height: 32px" src='<c:url value="/resources/Image/logo_Yameshop.png"/> '></a>
			    </div>
			    <!-- Collect the nav links, forms, and other content for toggling -->
			    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav navbar-center">
			        <li class="active"><a href="#">TRANG CHU <span class="sr-only">(current)</span></a></li>
			        <li class="dropdown">
			          <a class="dropdown-toggle" data-toggle="dropdown" href="#">DANH MUC <span class="caret"></span></a>
			          <ul class="dropdown-menu">				      
					      <c:forEach items="${listdanhmucsanpham}" var="danhmucsanpham">
						      <li><a href="danhmuc/${danhmucsanpham.getMadanhmuc()}">${danhmucsanpham.getTendanhmuc()}</a></li>
					      </c:forEach>
				       </ul>				      
			        </li>
			        <li><a href="#">DICH VU</a></li>
			        <li><a href="#">LIEN HE</a></li>
			        
			      </ul>
			      <ul class="nav navbar-nav navbar-right">
			        <li><a href="dangnhap/">
				     	<c:choose>
						  <c:when test="${email != null}">
						  		<c:out value = "${email}"/>
						  </c:when>
						  <c:when test="${emaildangky != null}">
						    	<c:out value = "${emaildangky}"/>
						  </c:when>
						  <c:otherwise>
						    	<c:out value = "ĐĂNG NHẬP"/>
						  </c:otherwise>
						</c:choose>
			        </a></li>
			      </ul>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
		</nav>
		<div class="event-header container wow bounceInLeft">
			<span style="font-size: 20px">Ngay 08-12-2018</span><br/>
			<span style="font-size: 40px">MUA 1 TANG 1</span><br/>
			<span><button>XEM NGAY</button></span>
		</div>
	</div>
	
	<div class="container-fluid">
		<div id="info" class="row">
			<div class="col-12 col-sm-4 col-md-4 wow fadeInDown" data-wow-duration="1s">
				<img class="icon-info" src='<c:url value="/resources/Image/icon_Chatluong.png" />'><br/>
				<span style="font-size: 20px; font-weight: bold;">CHAT LUONG</span><br/>
				<span>Chung toi cam ket mang den cho ban chat luong san pham tot nhat</span>
			</div>
			<div class="col-12 col-sm-4 col-md-4 wow fadeInDown" data-wow-duration="1s">
				<img class="icon-info" src='<c:url value="/resources/Image/icon_Chatluong.png" />'><br/>
				<span style="font-size: 20px; font-weight: bold;">TIET KIEM CHI PHI</span><br/>
				<span>Cam ket gia re giup ban tiet kiem hon cho tung san pham</span>
			</div>
			<div class="col-12 col-sm-4 col-md-4 wow fadeInDown" data-wow-duration="1s">
				<img class="icon-info" src='<c:url value="/resources/Image/icon_Chatluong.png" />'><br/>
				<span style="font-size: 20px; font-weight: bold;">GIAO HANG</span><br/>
				<span>Cam ket giao hang tan noi, trong ngay, de mang san pham den voi quy khach nhanh nhat</span>
			</div>
		</div>
	</div>
	
	<div class="container">
		<p id="title-sanpham" class="wow fadeInDown">SAN PHAM HOT</p>
		<div class="row"  data-wow-delay="1s">
			<c:forEach items="${listsanpham}" var="sanpham">
			    <div class="col-md-3 col-sm-6 wow rollIn">
					<a href="chitiet/${sanpham.getMasanpham()}">
						<div class="sanpham">
							<img style="width: 250px; height: 300px" src="<c:url value="/resources/Image/sanpham/${sanpham.getHinhsanpham()}"/>" alt="So mi thoi trang nam">
							<span class="ten-ao">${sanpham.getTensanpham()}</span><br/>
							<span>${sanpham.getGiatien()}</span>
						</div>
					</a>
				</div>
			</c:forEach>
		</div>
	</div>

	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4 wow fadeInDown">
				<p><span class="title-footer">THONG TIN SHOP</span></p>
				<span>Yame la mot thuong hieu thoi trang uy tin, luon dam bao chat luong san pham tot nhat cho khach hang</span>
			</div>
			<div class="col-sm-4 col-md-4 wow fadeInDown">
				<p><span class="title-footer">LIEN HE</span></p>
				<span>So 27-Tran Cung-Co Nhue- Bac Tu Liem-Ha Noi</span>
			</div>
			<div class="col-sm-4 col-md-4 wow fadeInDown">
				<p><span class="title-footer">GOP Y</span></p>
				<input class="material-textinput" type="text" placeholder="Email" style="margin-bottom: 8px"/><br/>
				<textarea rows="4" cols="60" placeholder="Y kien ca nhan" style="margin-bottom: 8px"></textarea>
				<button class="material-button" style="margin-bottom: 8px">DONG Y</button>
			</div>
		</div>
	</div>	
	<jsp:include page="footer.jsp"/>
</body>
</html>
