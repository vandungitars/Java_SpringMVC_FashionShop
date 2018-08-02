package com.vandung.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vandung.entity.DanhMucSanPham;
import com.vandung.entity.GioHang;
import com.vandung.entity.SanPham;
import com.vandung.service.DanhMucSanPhamService;
import com.vandung.service.SanPhamService;



@Controller
@RequestMapping("chitiet/")
@SessionAttributes("giohangs")
public class ChiTietController {
	
	@Autowired
	SanPhamService sanphamService;
	
	@Autowired
	DanhMucSanPhamService danhmucsanphamService;
	
	@GetMapping("/{masanpham}")
	public String Default(@PathVariable int masanpham, ModelMap modelmap, HttpSession httpSession)
	{		
		SanPham chitietsanpham = sanphamService.LayChiTietSanPham(masanpham);
		modelmap.addAttribute("chitietsanpham", chitietsanpham);
		if(null != httpSession.getAttribute("giohangs")) {
			List<GioHang> listgiohangs = (List<GioHang>) httpSession.getAttribute("giohangs");
			modelmap.addAttribute("soluongdonhang", listgiohangs.size());
		}
		List<DanhMucSanPham> listdanhmucsanpham = danhmucsanphamService.LayDanhMucSanPham();
		modelmap.addAttribute("listdanhmucsanpham", listdanhmucsanpham);
		return "chitiet";
	}
}
