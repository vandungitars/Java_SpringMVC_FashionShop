package com.vandung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vandung.service.NhanVienService;

@Controller
@RequestMapping("dangnhap/")
public class DangNhapController {
	
	@Autowired
	NhanVienService nhanvienService;
	
	@GetMapping
	public String Default()
	{
		return "dangnhap";
	}
	
	@PostMapping
	public String DangKy(@RequestParam String emaildangky, @RequestParam String matkhaudangky, @RequestParam String nhaplaimatkhau, ModelMap modelmap)
	{
		boolean ok = nhanvienService.KiemTraDangKy(emaildangky, matkhaudangky, nhaplaimatkhau);
		if(ok){
			modelmap.addAttribute("thongbaodangky", "dang ky thanh cong");
			return "trangchu";
		}
		else{
			modelmap.addAttribute("thongbaodangky", "nhap sai thong tin");
			return "dangky";
		}
	}
}
