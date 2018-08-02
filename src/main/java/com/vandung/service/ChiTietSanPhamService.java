package com.vandung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandung.dao.ChiTietSanPhamDAO;
import com.vandung.dao.ChiTietSanPhamDAOImp;
import com.vandung.entity.MauSanPham;
import com.vandung.entity.SizeSanPham;

@Service
public class ChiTietSanPhamService implements ChiTietSanPhamDAOImp{

	@Autowired
	ChiTietSanPhamDAO chitietsanphamDAO;
	
	@Override
	public List<MauSanPham> ChiTietMauSanPham() {
		return chitietsanphamDAO.ChiTietMauSanPham();
	}

	@Override
	public List<SizeSanPham> ChiTietSizeSanPham() {
		return chitietsanphamDAO.ChiTietSizeSanPham();
	}
}
