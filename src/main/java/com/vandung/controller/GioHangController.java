package com.vandung.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vandung.entity.ChiTietHoaDon;
import com.vandung.entity.ChiTietHoaDonId;
import com.vandung.entity.DanhMucSanPham;
import com.vandung.entity.GioHang;
import com.vandung.entity.HoaDon;
import com.vandung.service.ChiTietHoaDonService;
import com.vandung.service.DanhMucSanPhamService;
import com.vandung.service.HoaDonService;

@Controller
@RequestMapping("chitiet/giohang/")
@SessionAttributes("giohangs")
public class GioHangController {

	@Autowired
	HoaDonService hoadonService;
	
	@Autowired
	ChiTietHoaDonService chitiethoadonService;
	
	@Autowired
	DanhMucSanPhamService danhmucsanphamService;
	
	@GetMapping()
	public String Default(ModelMap modelmap, HttpSession httpSession)
	{		
		if(null != httpSession.getAttribute("giohangs")) {
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohangs");
			modelmap.addAttribute("listgiohang", listgiohang);
		}
		List<DanhMucSanPham> listdanhmucsanpham = danhmucsanphamService.LayDanhMucSanPham();
		modelmap.addAttribute("listdanhmucsanpham", listdanhmucsanpham);
		return "giohang";
	}
	
	@PostMapping()
	public String ThemHoaDon(@RequestParam String tenkhachhang, @RequestParam String sodt, @RequestParam String hinhthucgiaohang, @RequestParam String diachigiaohang, @RequestParam String ghichu, HttpSession httpSession)
	{		
		if(null != httpSession.getAttribute("giohangs")) {
			List<GioHang> listgiohang = (List<GioHang>) httpSession.getAttribute("giohangs");
			HoaDon hoadon = new HoaDon();
			hoadon.setTenkhachhang(tenkhachhang);
			hoadon.setSodt(sodt);
			hoadon.setHinhthucgiaohang(hinhthucgiaohang);
			hoadon.setDiachigiaohang(diachigiaohang);
			hoadon.setGhichu(ghichu);
			boolean ok = hoadonService.ThemHoaDon(hoadon);
			if(ok) {
				Set<ChiTietHoaDon> listchitiethoadon = new HashSet<>();
				listgiohang.forEach((giohang)->{
					ChiTietHoaDonId chitiethoadonId = new ChiTietHoaDonId();
					chitiethoadonId.setMachitietsanpham(giohang.getMachitietsanpham());
					chitiethoadonId.setMahoadon(hoadon.getMahoadon());
					
					ChiTietHoaDon chitiethoadon = new ChiTietHoaDon();
					chitiethoadon.setChiTietHoaDonId(chitiethoadonId);
					chitiethoadon.setGiatien(giohang.getGiatien());
					chitiethoadon.setSoluong(giohang.getSoluong());
					
					chitiethoadonService.ThemChiTietHoaDon(chitiethoadon);
				});
			}
			
		}
		return "trangchu";
	}
}
