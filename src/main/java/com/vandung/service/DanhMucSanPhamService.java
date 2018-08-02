package com.vandung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandung.dao.DanhMucSanPhamDAO;
import com.vandung.dao.DanhMucSanPhamDAOImp;
import com.vandung.entity.DanhMucSanPham;
import com.vandung.entity.SanPham;

@Service
public class DanhMucSanPhamService implements DanhMucSanPhamDAOImp{

	@Autowired
	DanhMucSanPhamDAO danhmucsanphamDAO;
	
	@Override
	public List<DanhMucSanPham> LayDanhMucSanPham() {
		return danhmucsanphamDAO.LayDanhMucSanPham();
	}

	@Override
	public List<SanPham> LaySanPhamTheoDanhMuc(int madanhmuc) {
		return danhmucsanphamDAO.LaySanPhamTheoDanhMuc(madanhmuc);
	}
	
}
