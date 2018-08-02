<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
			      </ul>
			    </div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
		</nav>
		<div class="row" style="padding-top: 30px; padding-left: 40px; padding-right: 40px">
			<div class="col-sm-4 col-md-4">
					  <h2>THÔNG TIN KHÁCH HÀNG</h2>
					  <form action="" method="post">
					    <div class="form-group">
					      <label for="tenkhachhang">TÊN KHÁCH HÀNG:</label>
					      <input type="text" class="form-control" id="tenkhachhang" placeholder="Enter name" name="tenkhachhang">
					    </div>
					    <div class="form-group">
					      <label for="sodt">ĐIỆN THOẠI LIÊN LẠC:</label>
					      <input type="text" class="form-control" id="sodt" placeholder="Enter phone" name="sodt">
					    </div>
					    <div class="checkbox">
						  <label><input type="checkbox" value="" name="hinhthucgiaohang">GIAO HÀNG TẬN NƠI</label>
						</div>
						<div class="checkbox">
						  <label><input type="checkbox" value="" name="hinhthucgiaohang">MUA TẠI CỬA HÀNG</label>
						</div>
						<div class="form-group">
					      <label for="diachigiaohang">ĐỊA CHỈ NHẬN HÀNG:</label>
					      <input type="text" class="form-control" id="diachigiaohang" placeholder="Enter address" name="diachigiaohang">
					    </div>
					    <div class="form-group">
						  <label for="ghichu">GHI CHÚ:</label>
						  <textarea class="form-control" rows="5" id="ghichu" name="ghichu"></textarea>
						</div>
					    <div class="checkbox">
					      <label><input type="checkbox" name="remember"> REMEMBER ME</label>
					    </div>
					    <button type="submit" class="btn btn-success">ĐẶT HÀNG</button>
					  </form>
			</div>
			
			<div class="col-sm-8 col-md-8">
		 		<table class="table">
				    <thead>
				      <tr>
				      	<th style="font-size: 20px">TÊN SẢN PHẨM</th>
				        <th style="font-size: 20px">MÀU SẢN PHẨM</th>
				        <th style="font-size: 20px">SIZE</th>
				        <th style="font-size: 20px">SỐ LƯỢNG</th>
				        <th style="font-size: 20px">GIÁ TIỀN/SP</th>
				      </tr>
				    </thead>
				    <tbody>
				    	<c:forEach items="${listgiohang}" var="sanphamtronggiohang">
					      <tr>
					      	<td class="ten-sanpham" style="font-size: 20px" data-masp="${sanphamtronggiohang.getMasanpham()}">${sanphamtronggiohang.getTensanpham()}</td>
							<td class="mau-sanpham" style="font-size: 20px" data-mamausp="${sanphamtronggiohang.getMamau()}">${sanphamtronggiohang.getTenmau()}</td>
						    <td class="size-sanpham" style="font-size: 20px" data-masizesp="${sanphamtronggiohang.getMasize()}">${sanphamtronggiohang.getTensize()}</td>
						    <td class="soluong-sanpham" style="font-size: 20px"><input class="soluong-sp" type="number" min="1" value="${sanphamtronggiohang.getSoluong()}"/></td>
						    <td class="giatien-sanpham" style="font-size: 20px" data-giatiensp="${sanphamtronggiohang.getGiatien()}">${sanphamtronggiohang.getGiatien()}</td>
						    <td class="btn btn-danger" id="xoasanphamgiohang">XÓA</td>
					      </tr>
				      	</c:forEach>
				    </tbody>
				  </table>
				  <h3 style="color: red;">Tổng Tiền = <span class="tongtien-sanpham"></span></h3>
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