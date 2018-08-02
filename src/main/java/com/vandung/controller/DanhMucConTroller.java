package com.vandung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vandung.entity.DanhMucSanPham;
import com.vandung.entity.SanPham;
import com.vandung.service.DanhMucSanPhamService;

@Controller
@RequestMapping("danhmuc/")
public class DanhMucConTroller {
	
	@Autowired
	DanhMucSanPhamService danhmucsanphamService;
	
	@GetMapping("/{madanhmuc}")
	public String Default(@PathVariable int madanhmuc, ModelMap modelmap) {
		List<SanPham> listsanpham = danhmucsanphamService.LaySanPhamTheoDanhMuc(madanhmuc);
		modelmap.addAttribute("listsanpham", listsanpham);
		List<DanhMucSanPham> listdanhmucsanpham = danhmucsanphamService.LayDanhMucSanPham();
		modelmap.addAttribute("listdanhmucsanpham", listdanhmucsanpham);
		return "danhmucsanpham";
	}
}
