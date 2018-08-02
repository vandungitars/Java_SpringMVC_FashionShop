package com.vandung.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vandung.entity.MauSanPham;
import com.vandung.entity.SizeSanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChiTietSanPhamDAO implements ChiTietSanPhamDAOImp{

	@Autowired
	SessionFactory mySessionFactory;
	
	@Override
	@Transactional
	public List<MauSanPham> ChiTietMauSanPham() {
		Session session = mySessionFactory.getCurrentSession();
		List<MauSanPham> listmausanpham = (List<MauSanPham>) session.createQuery("from MAUSANPHAM").getResultList();
		return listmausanpham;
	}

	@Override
	@Transactional
	public List<SizeSanPham> ChiTietSizeSanPham() {
		Session session = mySessionFactory.getCurrentSession();
		List<SizeSanPham> listsizesanpham = (List<SizeSanPham>) session.createQuery("from SIZESANPHAM").getResultList();
		return listsizesanpham;
	}

}
