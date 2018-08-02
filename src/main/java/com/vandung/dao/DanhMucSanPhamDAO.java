package com.vandung.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vandung.entity.DanhMucSanPham;
import com.vandung.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucSanPhamDAO implements DanhMucSanPhamDAOImp{

	@Autowired
	SessionFactory mySessionFactory;
	
	@Override
	@Transactional
	public List<DanhMucSanPham> LayDanhMucSanPham() {
		Session session = mySessionFactory.getCurrentSession();
		List<DanhMucSanPham> listdanhmucsanpham = (List<DanhMucSanPham>) session.createQuery("from DANHMUCSANPHAM").getResultList();
		return listdanhmucsanpham;
	}

	@Override
	@Transactional
	public List<SanPham> LaySanPhamTheoDanhMuc(int madanhmuc) {
		Session session = mySessionFactory.getCurrentSession();
		List<SanPham> listsanpham = (List<SanPham>) session.createQuery("from SANPHAM sp where sp.danhmucsanpham.madanhmuc="+madanhmuc).getResultList();
		listsanpham.forEach((p)->{
			p.getTensanpham();
		});
		return listsanpham;
	}

}
