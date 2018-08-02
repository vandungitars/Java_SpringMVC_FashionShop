package com.vandung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandung.dao.NhanVienDAO;
import com.vandung.dao.NhanVienDAOImp;

@Service
public class NhanVienService implements NhanVienDAOImp{

	@Autowired
	NhanVienDAO nhanvienDAO;
	
	@Override
	public boolean KiemTraDangNhap(String email, String matkhau) {
		boolean ok = nhanvienDAO.KiemTraDangNhap(email, matkhau);
		return ok;
	}

	@Override
	public boolean KiemTraDangKy(String emaildangky, String matkhaudangky, String nhaplaimatkhau) {
		boolean ok = nhanvienDAO.KiemTraDangKy(emaildangky, matkhaudangky, nhaplaimatkhau);
		return ok;
	}

}
