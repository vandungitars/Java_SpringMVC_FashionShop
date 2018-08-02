package com.vandung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandung.dao.SanPhamDAO;
import com.vandung.dao.SanPhamDAOImp;
import com.vandung.entity.SanPham;

@Service
public class SanPhamService implements SanPhamDAOImp{

	@Autowired
	SanPhamDAO sanphamDAO;
	
	@Override
	public List<SanPham> LayDanhSachSanPhamLimit(int sanphambatdau) {
		return sanphamDAO.LayDanhSachSanPhamLimit(sanphambatdau);
	}

	@Override
	public SanPham LayChiTietSanPham(int masanpham) {
		return sanphamDAO.LayChiTietSanPham(masanpham);
	}

	@Override
	public int XoaSanPham(int masanpham) {
		return sanphamDAO.XoaSanPham(masanpham);
	}

	@Override
	public int ThemSanPham(SanPham sanPham) {		
		return sanphamDAO.ThemSanPham(sanPham);
	}

	@Override
	public int SuaSanPham(int masanpham, SanPham sanpham) {
		return sanphamDAO.SuaSanPham(masanpham, sanpham);
	}

}
