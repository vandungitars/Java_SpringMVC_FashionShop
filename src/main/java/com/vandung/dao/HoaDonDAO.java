package com.vandung.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vandung.entity.HoaDon;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HoaDonDAO implements HoaDonImp{

	@Autowired
	SessionFactory mySessionFactory;
	
	@Override
	@Transactional
	public boolean ThemHoaDon(HoaDon hoadon) {
		Session session = mySessionFactory.getCurrentSession();
		int id = (int) session.save(hoadon);
		if(0 < id) {
			return true;
		}
		return false;
	}
	
}
