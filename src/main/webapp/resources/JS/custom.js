$(document).ready(function(){
	$("#btndangnhap").click(function(){
		var email = $("#email").val();
		var matkhau = $("#matkhau").val();
		$.ajax({
			url: "/FashionShop/api/kiemtradangnhap",
			type: "GET",
			data:{
				email: email,
				matkhau: matkhau
			},
			success: function(value){
				if(value == "true"){
					duongdanhientai = window.location.href;
					duongdan = duongdanhientai.replace("dangnhap/","");
					window.location = duongdan;
				}
				else{
					alert("Failed")
				}
			}
		})
	});
	$("#btndangnhap").click(function(){
		var email = $("#email").val();
		var matkhau = $("#matkhau").val();
		$.ajax({
			url: "/FashionShop/api/kiemtradangnhap",
			type: "GET",
			data:{
				email: email,
				matkhau: matkhau
			},
			success: function(value){
				if(value == "true"){
					duongdanhientai = window.location.href;
					duongdan = duongdanhientai.replace("dangnhap/","");
					window.location = duongdan;
				}
				else{
					alert("Failed")
				}
			}
		})
	});
	$("#dangnhap").click(function(){
		$("#form-login").show();
		$("#form-signup").hide();
	});
	$("#dangky").click(function(){
		$("#form-login").hide();
		$("#form-signup").show();
	});
	$(".btn-giohang").click(function(){
		var masanpham = $(".tensanpham").attr("data-masanpham");
		var mamau = $(this).closest("tr").find(".mausanpham").attr("data-mamau");
		var masize = $(this).closest("tr").find(".sizesanpham").attr("data-masize");
		var tensanpham = $(".tensanpham").text();
		var giatien = $(".giatien").attr("data-giatien");
		var tenmau = $(this).closest("tr").find(".mausanpham").text();
		var tensize = $(this).closest("tr").find(".sizesanpham").text();
		$.ajax({
			url: "/FashionShop/api/themgiohang",
			type: "GET",
			data:{
				masanpham : masanpham,
				mamau : mamau,
				masize : masize,
				tensanpham : tensanpham,
				giatien : giatien,
				tenmau : tenmau,
				tensize : tensize,
			},
			success: function(value){
				$("#icon-giohang").find("div").addClass("circle-giohang");
				$("#icon-giohang").find("div").html("<span>" + value + "</span>");
			}
		})
	});
	
	GanTongTienHang();
	
	function GanTongTienHang(eventChange) {
		var TongTiensp = 0;
		$(".giatien-sanpham").each(function(){
			var giatien = $(this).text();
			var soluong = $(this).closest("tr").find(".soluong-sp").val();
			var tongtien = parseInt(giatien) * soluong;
			var format = parseInt(tongtien).toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString()
			if(!eventChange){
				$(this).html(format);
			}
			TongTiensp = TongTiensp + tongtien;
			var formatTongTien = TongTiensp.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString()
			$(".tongtien-sanpham").html(formatTongTien)
		})
	}
	$(".soluong-sp").change(function(){
		var giatien = $(this).closest("tr").find(".giatien-sanpham").attr("data-giatiensp").replace(".",",");
		var soluong = $(this).val();
		var tongtien = parseInt(giatien) * soluong;
		var format = tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\.)/g, "$1.").toString()
		$(this).closest("tr").find(".giatien-sanpham").html(format);
		GanTongTienHang(true);
		var masanpham = $(this).closest("tr").find(".ten-sanpham").attr("data-masp");
		var mamau = $(this).closest("tr").find(".mau-sanpham").attr("data-mamausp");
		var masize = $(this).closest("tr").find(".size-sanpham").attr("data-masizesp");
		$.ajax({
			url: "/FashionShop/api/capnhapgiohang",
			type: "GET",
			data:{
				masanpham : masanpham,
				mamau : mamau,
				masize : masize,
				soluong : soluong
			},
			success: function(value){
				if(value == "success"){
					alert("Update" + value);
				}
				else{
					alert("Update failed");
				}
			}
		})
	});
	
	$("#btn-xoasanphamgiohang").click(function(){
		var masanpham = $(this).closest("tr").find(".ten-sanpham").attr("data-masp");
		var mamau = $(this).closest("tr").find(".mau-sanpham").attr("data-mamausp");
		var masize = $(this).closest("tr").find(".size-sanpham").attr("data-masizesp");
		$.ajax({
			url: "/FashionShop/api/xoasanphamgiohang",
			type: "GET",
			data:{
				masanpham : masanpham,
				mamau : mamau,
				masize : masize,
			},
			success: function(value){
				if(value == "success"){
					alert("Delete" + value);
				}
				else{
					alert("Delete failed");
				}
			}
		})
	});
	
	$("body").on("click",".view-page",function(){
		$(".view-page").removeClass("active");
		$(this).addClass("active");
		var sotrang = $(this).text();
		var spbatdau = (parseInt(sotrang)-1)*8;
		$.ajax({
			url: "/FashionShop/api/adminsanpham",
			type: "GET",
			data:{
				spbatdau : spbatdau,
			},
			success: function(value){
				var bodysanpham = $("#table-sanpham").find("tbody");
				bodysanpham.empty();
				bodysanpham.append(value);
			}
		})
	});
	$("#btn-xoasanphamDB").click(function(){
		var masanpham = $(this).closest("tr").find(".ten-sanphamcanxoa").attr("data-masanphamcanxoa");
		$(this).closest("tr").remove();
		$.ajax({
			url: "/FashionShop/api/xoasanphamDB",
			type: "GET",
			data:{
				masanpham : masanpham,
			},
			success: function(value){
				alert("Delete success");
			}
		})
	});
	
	$("#btn-suasanphamDB").click(function(){
		var masanpham = $(this).closest("tr").find(".ten-sanphamcanxoa").attr("data-masanphamcanxoa");
		var tensanpham = $(".tensanpham").text();
		var giatien = $(".giatien").text();
		var mota = $(".mota").text();
		$.ajax({
			url: "/FashionShop/api/suasanphamDB",
			type: "GET",
			data:{
				masanpham : masanpham,
				tensanpham : tensanpham,
				giatien : giatien,
				mota : mota,
			},
			success: function(value){
				alert("Update success");
			}
		})
	});
	
	var files= [];
	$("#hinhsanpham").change(function(event){
		files = event.target.files;
		forms = new FormData();
		forms.append("file",files[0]);
		$.ajax({
			url: "/FashionShop/api/uploadfile",
			type: "POST",
			data:forms,
			contentType:false,
			processData:false,
			enctype:"multipart/form-data",
			success: function(value){}
		})
	});
	
	$("#btn-themsanpham").click(function(event){
		event.preventDefault();
		var formdata = $("#form-sanpham").serializeArray();
		console.log(formdata);
		json = {};
		json["hinhsanpham"] = hinhsanpham;
		$.each(formdata,function(i,field){
			json[field.name] = field.value;
		});
		$.ajax({
			url: "/FashionShop/api/themsanpham",
			type: "POST",
			data:{
				dataJson : JSON.stringify(json)
			},
			success: function(value){
				alert("Add success");
			}
		})
	});
})
