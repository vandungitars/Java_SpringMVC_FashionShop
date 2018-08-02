package com.vandung.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vandung.entity.ChiTietSanPham;
import com.vandung.entity.DanhMucSanPham;
import com.vandung.entity.GioHang;
import com.vandung.entity.MauSanPham;
import com.vandung.entity.SanPham;
import com.vandung.entity.SizeSanPham;
import com.vandung.service.NhanVienService;
import com.vandung.service.SanPhamService;

@Controller
@RequestMapping("api/")
@SessionAttributes({"email", "giohangs"})
public class ApiController {

	@Autowired
	NhanVienService nhanvienService;
	
	@Autowired
	SanPhamService sanphamService;
	
	@GetMapping("kiemtradangnhap")
	@ResponseBody
	public String KiemTraDangNhap(@RequestParam String email, @RequestParam String matkhau, ModelMap modelmap)
	{
		boolean ok = nhanvienService.KiemTraDangNhap(email, matkhau);
		modelmap.addAttribute("email",email);
		return "" + ok;
	}
		
	private int KiemTraSanPhamTonTaiGioHang(List<GioHang> listgiohang, int masp, int mamau, int masize)
	{
		for(int i = 0; i < listgiohang.size(); i++) {
			if(listgiohang.get(i).getMasanpham() == masp && listgiohang.get(i).getMamau() == mamau && listgiohang.get(i).getMasize() == masize) {
				return i;
			}
		}
		return -1;
	}
	
	@GetMapping("themgiohang")
	@ResponseBody
	public String ThemGioHang(@RequestParam int masanpham, @RequestParam int mamau, @RequestParam int masize, @RequestParam String tensanpham, @RequestParam String giatien, @RequestParam String tenmau, @RequestParam String tensize, HttpSession httpSession)
	{
		if(null == httpSession.getAttribute("giohangs")){
			List<GioHang> listgiohang = new ArrayList<>();
			GioHang giohang = new GioHang();
			giohang.setMasanpham(masanpham);
			giohang.setMamau(mamau);
			giohang.setMasize(masize);
			giohang.setTensanpham(tensanpham);
			giohang.setGiatien(giatien);
			giohang.setTenmau(tenmau);
			giohang.setTensize(tensize);
			giohang.setSoluong(1);
			listgiohang.add(giohang);
			httpSession.setAttribute("giohangs", listgiohang);
			return listgiohang.size()+"";
		}
		else {
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohangs");
			int exist = KiemTraSanPhamTonTaiGioHang(listgiohang,masanpham, mamau, masize);
			if(exist == -1) {
				GioHang giohang = new GioHang();
				giohang.setMasanpham(masanpham);
				giohang.setMamau(mamau);
				giohang.setMasize(masize);
				giohang.setTensanpham(tensanpham);
				giohang.setGiatien(giatien);
				giohang.setTenmau(tenmau);
				giohang.setTensize(tensize);
				giohang.setSoluong(1);
				listgiohang.add(giohang);
			}
			else {
				listgiohang.get(exist).setSoluong(listgiohang.get(exist).getSoluong() + 1);
			}
			return listgiohang.size()+"";
		}
	}
	
	@GetMapping("capnhapgiohang")
	@ResponseBody
	public String CapNhapGioHang(@RequestParam int masanpham, @RequestParam int mamau, @RequestParam int masize, @RequestParam int soluong, HttpSession httpSession)
	{
		if(null == httpSession.getAttribute("giohangs")){			
			return "fail";
		}
		else {
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohangs");
			int exist = KiemTraSanPhamTonTaiGioHang(listgiohang,masanpham, mamau, masize);
			listgiohang.get(exist).setSoluong(soluong);
			return "success";
		}
	}
	
	@GetMapping("xoasanphamgiohang")
	@ResponseBody
	public String XoaSanPhamGioHang(@RequestParam int masanpham, @RequestParam int mamau, @RequestParam int masize, HttpSession httpSession)
	{
		if(null == httpSession.getAttribute("giohangs")){			
			return "fail";
		}
		else {
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohangs");
			int exist = KiemTraSanPhamTonTaiGioHang(listgiohang,masanpham, mamau, masize);
			listgiohang.remove(exist);
			return "success";
		}
		
	}
	@GetMapping(path = "adminsanpham", produces = "text/plain; charset=utf-8")
	@ResponseBody
	public String AdminSanPham(@RequestParam int spbatdau)
	{
		String html = "";
		List<SanPham> listsanpham = sanphamService.LayDanhSachSanPhamLimit(spbatdau);
		for (SanPham sanPham : listsanpham) {
			html += "<tr>";
			html += "<td><img style=\"width: 200px; height: 200px\" src=\"/resources/Image/sanpham/"+sanPham.getHinhsanpham()+"\" alt=\"So mi thoi trang nam\"/></td>";
			html += "<td><span style=\"font-size: 30px\">"+sanPham.getTensanpham()+"</span></td>";
			html += "<td><span style=\"font-size: 30px\">"+sanPham.getGiatien()+"</span></td>";
			html += "<td class=\"btn btn-danger\" id=\"btn-deletesanpham\" style=\"color: white;\">XÓA</td>";
			html += "</tr>";
		}
		return html;
	}
	@GetMapping("xoasanphamDB")
	@ResponseBody
	public String XoaSanPhamDB(@RequestParam int masanpham)
	{
		sanphamService.XoaSanPham(masanpham);
		return "";
	}
	@GetMapping("suasanphamDB")
	@ResponseBody
	public String SuaSanPhamDB(@RequestParam int masanpham,@RequestParam String tensanpham,@RequestParam String giatien,@RequestParam String mota)
	{
		SanPham sanPham = new SanPham();
		sanPham.setTensanpham(tensanpham);
		sanPham.setGiatien(giatien);
		sanPham.setMota(mota);
		sanphamService.SuaSanPham(masanpham, sanPham);
		return "";
	}
	@Autowired
	ServletContext context;
	
	@PostMapping("uploadfile")
	@ResponseBody
	public String UploadFile(MultipartHttpServletRequest request)
	{
		String path_save_file = context.getRealPath("/resources/Image/sanpham/");
		Iterator<String> listNames = request.getFileNames();
		MultipartFile mpf = request.getFile(listNames.next());
		File file_save = new File(path_save_file + mpf.getOriginalFilename());
		try {
			mpf.transferTo(file_save);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(path_save_file);
		return "true";
	}
	
	@PostMapping("themsanpham")
	@ResponseBody
	public void UpdateSanPham(@RequestParam String  dataJson)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonObject;
		SanPham sanPham = new SanPham();
		try {
			jsonObject = objectMapper.readTree(dataJson);
			DanhMucSanPham danhMucSanPham = new DanhMucSanPham();
			danhMucSanPham.setMadanhmuc(jsonObject.get("danhmucsanpham").asInt());
			Set<ChiTietSanPham> setChiTietSanPham = new HashSet<ChiTietSanPham>();
			ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
			MauSanPham mauSanPham = new MauSanPham();
			mauSanPham.setMamau(jsonObject.get("mausanpham").asInt());
			SizeSanPham sizeSanPham = new SizeSanPham();
			sizeSanPham.setMasize(jsonObject.get("sizesanpham").asInt());
			chiTietSanPham.setMausanpham(mauSanPham);
			chiTietSanPham.setSizesanpham(sizeSanPham);
			chiTietSanPham.setSoluong(jsonObject.get("soluongsanpham").asInt());
			setChiTietSanPham.add(chiTietSanPham);
			sanPham.setTensanpham(jsonObject.get("tensanpham").asText());
			sanPham.setGiatien(jsonObject.get("giatien").asText());
			sanPham.setHinhsanpham(jsonObject.get("hinhsanpham").asText());
			sanPham.setMota(jsonObject.get("mota").asText());
			sanPham.setGianhcho(jsonObject.get("gianhcho").asText());
			sanPham.setChitietsanpham(setChiTietSanPham);
			sanPham.setDanhmucsanpham(danhMucSanPham);
		} catch (Exception e) {
			// TODO: handle exception
		}
		sanphamService.ThemSanPham(sanPham);
	}
}