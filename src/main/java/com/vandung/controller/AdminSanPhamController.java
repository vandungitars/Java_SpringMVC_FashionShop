package com.vandung.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vandung.dao.ChiTietSanPhamDAO;
import com.vandung.entity.DanhMucSanPham;
import com.vandung.entity.MauSanPham;
import com.vandung.entity.SanPham;
import com.vandung.entity.SizeSanPham;
import com.vandung.service.ChiTietSanPhamService;
import com.vandung.service.DanhMucSanPhamService;
import com.vandung.service.SanPhamService;

@Controller
@RequestMapping("adminsanpham/")
public class AdminSanPhamController {
	
	@Autowired
	SanPhamService sanphamService;
	
	@Autowired
	DanhMucSanPhamService danhmucsanphamService;
	
	@Autowired
	ChiTietSanPhamService chitietsanphamService;
	
	@GetMapping
	public String Default(ModelMap modelmap)
	{
		List<SanPham> listsanpham = sanphamService.LayDanhSachSanPhamLimit(0);
		List<SanPham> listsanphamall = sanphamService.LayDanhSachSanPhamLimit(-1);
		List<DanhMucSanPham> listdanhmucsanpham = danhmucsanphamService.LayDanhMucSanPham();
		List<MauSanPham> listmausanpham = chitietsanphamService.ChiTietMauSanPham();
		List<SizeSanPham> listsizesanpham = chitietsanphamService.ChiTietSizeSanPham();
		int soluongpage = Math.round(listsanphamall.size()/8);
		modelmap.addAttribute("listsanpham", listsanpham);
		modelmap.addAttribute("soluongpage", soluongpage);
		modelmap.addAttribute("listdanhmucsanpham", listdanhmucsanpham);
		modelmap.addAttribute("listmausanpham", listmausanpham);
		modelmap.addAttribute("listsizesanpham", listsizesanpham);
		return "adminsanpham";
	}	
}
