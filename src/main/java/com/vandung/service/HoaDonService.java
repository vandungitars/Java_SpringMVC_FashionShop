package com.vandung.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandung.dao.HoaDonDAO;
import com.vandung.dao.HoaDonImp;
import com.vandung.entity.HoaDon;

@Service
public class HoaDonService implements HoaDonImp{

	@Autowired
	HoaDonDAO hoadonDAO;
	
	@Override
	public boolean ThemHoaDon(HoaDon hoadon) {		
		return hoadonDAO.ThemHoaDon(hoadon);
	}

}
