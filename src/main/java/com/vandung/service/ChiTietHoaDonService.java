package com.vandung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandung.dao.ChiTietHoaDonDAO;
import com.vandung.dao.ChiTietHoaDonDAOImp;
import com.vandung.entity.ChiTietHoaDon;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonDAOImp{

	@Autowired
	ChiTietHoaDonDAO chitiethoadonDAO;
	
	@Override
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chitiethoadon) {
		return chitiethoadonDAO.ThemChiTietHoaDon(chitiethoadon);
	}

}
