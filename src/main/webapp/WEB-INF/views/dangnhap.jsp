<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SHOP FASHION</title>
<jsp:include page="header.jsp"/>
</head>
<body id="body-login">
	<div id="body-fex-login">
		<div id="container-login">
			<div id="container-login-left">
				<div id="header-top-left" class="header-login">
					<p><span id="text-logo">MELIODAS</span></p>
					<p><span id="hint-text-logo">Thất Hình Đại Tội</span></p>
				</div>
				<div id="header-bottom-left">
					<p><img id="image-icon" alt="icon_oval" src="<c:url value="/resources/Image/icon_Circle.png" />" /><span>Thập giới bị phong ấn</span></p>
					<p><img id="image-icon" alt="icon_oval" src="<c:url value="/resources/Image/icon_Circle.png" />" /><span>MELIODAS hồi sinh</span></p>
					<p><img id="image-icon" alt="icon_oval" src="<c:url value="/resources/Image/icon_Circle.png" />" /><span>Thất hình đại hội tụ hội</span></p>
				</div>
			</div>
			<div id="container-login-right">
				<div id="header-top-right" class="header-login">
					<button id="dangnhap" onclick="dangnhap()" style="background-color: red;">Đăng nhập</button>
					<span style="font-size: 20px">/</span>
					<button id="dangky" onclick="dangky()" style="background-color: white">Đăng ký</button>
					<script type="text/javascript">
						function dangnhap() {
							document.getElementById("dangnhap").style.backgroundColor = "red";
							document.getElementById("dangky").style.backgroundColor = "white";
						}
						function dangky() {
							document.getElementById("dangky").style.backgroundColor = "red";
							document.getElementById("dangnhap").style.backgroundColor = "white";
						}
					</script>
				</div>
				<div id="container-center-login-right">
					<div id="form-login">
						<!--<form action="" method="post">-->
						<h3>EMAIL</h3>
						<input id="email" class="material-textinput" type="text" placeholder="email" name="email"/><br>
						<h3>PASSWORD</h3>
						<input id="matkhau" class="material-textinput" type="password" placeholder="password" name="matkhau"/><br><br/>
						<input id="btndangnhap" class="material-button" type="submit" name="btndangnhap" value="Đăng Nhập"/>
						<!--<button id="submit" class="material-button">Đăng Nhập</button>-->
						<!--</form>-->
					</div>
					
					<div id="form-signup">
						<form action="" method="post">
							<h3>EMAIL</h3>
							<input id="emaildangky" class="material-textinput" type="text" placeholder="email" name="emaildangky"/><br>
							<h3>PASSWORD</h3>
							<input id="matkhaudangky" class="material-textinput" type="password" placeholder="password" name="matkhaudangky"/><br>
							<h3>NHẬP LẠI PASSWORD</h3>
							<input id="nhaplaimatkhau" class="material-textinput" type="password" placeholder="nhập lại password" name="nhaplaimatkhau"/><br><br/>
							<input id="btndangky" class="material-button" type="submit" name="btndangky" value="Đăng ký"/>
							<!--<button id="submit" class="material-button">Đăng Nhập</button>-->
						</form>
					</div>		
				</div>
				<div id="container-social-login">
					<img id="logo-icon-facebook" alt="icon_facebook" src="<c:url value="/resources/Image/icon_Facebook.png" />" />
					<img id="logo-icon-google" alt="icon_google" src="<c:url value="/resources/Image/icon_Google.png" />" />
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
</body>
</html>
