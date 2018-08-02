package com.vandung.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vandung.entity.ChiTietHoaDon;
import com.vandung.entity.ChiTietHoaDonId;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDAO implements ChiTietHoaDonDAOImp{
	
	@Autowired
	SessionFactory mySessionFactory;

	@Override
	@Transactional
	public boolean ThemChiTietHoaDon(ChiTietHoaDon chitiethoadon) {
		Session session = mySessionFactory.getCurrentSession();
		ChiTietHoaDonId chitiethoadonId = (ChiTietHoaDonId) session.save(chitiethoadon);
		if(null != chitiethoadonId) {
			return true;
		}
		return false;
	}
}
