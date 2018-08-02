package com.vandung.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vandung.entity.DanhMucSanPham;
import com.vandung.entity.SanPham;
import com.vandung.service.DanhMucSanPhamService;
import com.vandung.service.SanPhamService;


@Controller
@RequestMapping("/")
public class TrangChuController {
	
	@Autowired
	SanPhamService sanphamService;
	
	@Autowired
	DanhMucSanPhamService danhmucsanphamService;
	
	@GetMapping
	public String Default(HttpSession httpSession, ModelMap modelmap)
	{	
		if(httpSession.getAttribute("email") != null)
		{
			String email = (String)httpSession.getAttribute("email");
			modelmap.addAttribute("email", email);
		}
		if(httpSession.getAttribute("emaildangky") != null)
		{
			String emaildangky = (String)httpSession.getAttribute("emaildangky");
			modelmap.addAttribute("emaildangky", emaildangky);
		}
		List<SanPham> listsanpham = sanphamService.LayDanhSachSanPhamLimit(-1);
		modelmap.addAttribute("listsanpham", listsanpham);
		List<DanhMucSanPham> listdanhmucsanpham = danhmucsanphamService.LayDanhMucSanPham();
		modelmap.addAttribute("listdanhmucsanpham", listdanhmucsanpham);
		return "trangchu";
	}
	
}
















































