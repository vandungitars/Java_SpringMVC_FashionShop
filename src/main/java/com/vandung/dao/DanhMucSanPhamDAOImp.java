package com.vandung.dao;

import java.util.List;

import com.vandung.entity.DanhMucSanPham;
import com.vandung.entity.SanPham;

public interface DanhMucSanPhamDAOImp {
	List<DanhMucSanPham> LayDanhMucSanPham();
	List<SanPham> LaySanPhamTheoDanhMuc(int madanhmuc);
}
