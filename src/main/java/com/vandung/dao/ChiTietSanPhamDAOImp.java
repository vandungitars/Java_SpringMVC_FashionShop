package com.vandung.dao;

import java.util.List;

import com.vandung.entity.MauSanPham;
import com.vandung.entity.SizeSanPham;

public interface ChiTietSanPhamDAOImp {
	List<MauSanPham> ChiTietMauSanPham();
	List<SizeSanPham> ChiTietSizeSanPham();
}
