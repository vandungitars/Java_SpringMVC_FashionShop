package com.vandung.dao;

public interface NhanVienDAOImp {
	boolean KiemTraDangNhap(String email, String matkhau);
	boolean KiemTraDangKy(String emaildangky, String matkhaudangky, String nhaplaimatkhau);
}
