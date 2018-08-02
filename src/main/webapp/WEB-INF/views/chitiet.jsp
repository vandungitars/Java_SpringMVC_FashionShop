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
	<div class="container-fluid">
		<nav id="none-navbar" class="navbar navbar-default">
			  <div class="container-fluid" id="header-chitietsanpham">
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
			        <li><a href="dangnhap/">${email}</a></li>
			        <li id="icon-giohang">
			        	<a href='<c:url value="giohang/"/> '><img style="width: 50px; height: 26px" src='<c:url value="/resources/Image/icon_Rohang.png"/> '%></a>
				        <c:if test="${soluongdonhang > 0}">
				        	<div class="circle-giohang"><span>${soluongdonhang}</span></div>
				        </c:if>
				        <c:if test="${soluongdonhang <= 0 || soluongdonhang == null}">
				        	<div><span>${soluongdonhang}</span></div>
				        </c:if>
			        </li>
			      </ul>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
		</nav>
		<div class="row" style="padding-top: 30px">
			<div class="col-sm-2 col-md-2">
				  <p style="font-size: 20px"><span class="label label-default">DANH MỤC</span></p><br/>
				  <ul class="list-group">
				    <a href="#"><li class="list-group-item">Áo sơ mi</li></a>
				    <a href="#"><li class="list-group-item">Áo khoác</li></a>
				    <a href="#"><li class="list-group-item">Quần Âu</li></a>
				    <a href="#"><li class="list-group-item">Quần dài</li></a>
				  </ul>
			</div>
			
			<div class="col-sm-8 col-md-8">
				 <div class="row">
				 	<div class="col-sm-6 col-md-6">
				 		<img class="sanphamchitiet" style="width: 70%; height: 70%" alt="Sản Phẩm" src="<c:url value="/resources/Image/sanpham/${chitietsanpham.getHinhsanpham()}" />" />
				 	</div>
				 	<div class="col-sm-6 col-md-6">
				 		<p><span style="font-size: 30px" class="tensanpham" data-masanpham="${chitietsanpham.getMasanpham()}">${chitietsanpham.getTensanpham()}</span></p>
				 		<span style="font-size: 20px" class="giatien" data-giatien="${chitietsanpham.getGiatien()}">${chitietsanpham.getGiatien()}</span>
				 		<table class="table">
						    <thead>
						      <tr>
						        <th>MÀU SẢN PHẨM</th>
						        <th>SIZE</th>
						        <th>SỐ LƯỢNG</th>
						      </tr>
						    </thead>
						    <tbody>
						    	<c:forEach items="${chitietsanpham.getChitietsanpham()}" var="sanpham">
							      <tr>
										<td class="mausanpham" data-mamau="${sanpham.getMausanpham().getMamau()}">${sanpham.getMausanpham().getTenmau()}</td>
								        <td class="sizesanpham" data-masize="${sanpham.getSizesanpham().getMasize()}">${sanpham.getSizesanpham().getSize()}</td>
								        <td class="tensanpham" data-soluong="${sanpham.getSoluong()}">${sanpham.getSoluong()}</td>
								        <td><button id="submit" class="btn-giohang">GIỎ HÀNG</button></td>
							      </tr>
						      	</c:forEach>
						    </tbody>
						  </table>
				 	</div>
				 </div>
			</div>
			<div class="col-sm-2 col-md-2">
				  <span style="font-size: 30px">${chitietsanpham.getMota()}</span>
			</div>
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