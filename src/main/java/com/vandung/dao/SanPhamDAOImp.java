package com.vandung.dao;

import java.util.List;

import com.vandung.entity.SanPham;

public interface SanPhamDAOImp {
	List<SanPham> LayDanhSachSanPhamLimit(int sanphambatdau);
	SanPham LayChiTietSanPham(int masanpham);
	int XoaSanPham(int masanpham);
	int ThemSanPham(SanPham sanPham);
	int SuaSanPham(int masanpham, SanPham sanpham);
}
