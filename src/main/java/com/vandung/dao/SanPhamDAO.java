package com.vandung.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vandung.entity.ChiTietSanPham;
import com.vandung.entity.KhuyenMai;
import com.vandung.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamDAOImp{

	@Autowired
	SessionFactory mySessionFactory;
	
	@Override
	@Transactional
	public List<SanPham> LayDanhSachSanPhamLimit(int sanphambatdau) {
		Session session = mySessionFactory.getCurrentSession();
		List<SanPham> listsanpham = new ArrayList<>();
		if(sanphambatdau < 0){
			listsanpham = (List<SanPham>)session.createQuery("from SANPHAM").getResultList();
		}
		else{
			listsanpham = (List<SanPham>)session.createQuery("from SANPHAM").setFirstResult(sanphambatdau).setMaxResults(8).getResultList();
		}
		return listsanpham;
	}

	@Override
	@Transactional
	public SanPham LayChiTietSanPham(int masanpham) {
		Session session = mySessionFactory.getCurrentSession();
		SanPham sanpham = (SanPham)session.createQuery("from SANPHAM where masanpham="+masanpham).getSingleResult();
		return sanpham;
	}

	@Override
	@Transactional
	public int XoaSanPham(int masanpham) {
		Session session = mySessionFactory.getCurrentSession();
		SanPham sanPham = session.get(SanPham.class, masanpham);
		Set<KhuyenMai> danhsachkhuyenmai = sanPham.getDanhsachkhuyenmai();
		for (KhuyenMai khuyenMai : danhsachkhuyenmai) {
			session.createQuery("delete KHUYENMAI where makhuyenmai="+khuyenMai.getMakhuyenmai()).executeUpdate();
		}
		Set<ChiTietSanPham> chitietsanpham = sanPham.getChitietsanpham();
		for (ChiTietSanPham chiTietSanPham2 : chitietsanpham) {
			session.createQuery("delete CHITIETHOADON where machitietsanpham="+chiTietSanPham2.getMachitietsanpham()).executeUpdate();
		}
		session.createQuery("delete CHITIETSANPHAM where masanpham="+masanpham).executeUpdate();
		session.createQuery("delete SANPHAM where masanpham="+masanpham).executeUpdate();
		return 0;
	}

	@Override
	@Transactional
	public int ThemSanPham(SanPham sanPham) {
		Session session = mySessionFactory.getCurrentSession();
		session.save(sanPham);
		return 0;
	}

	@Override
	@Transactional
	public int SuaSanPham(int masanpham,SanPham sanpham) {
		Session session = mySessionFactory.getCurrentSession();
		SanPham sanphamDB = (SanPham) session.createQuery("form SANPHAM where masanpham="+masanpham).getSingleResult();
		sanphamDB.setTensanpham(sanpham.getTensanpham());
		sanphamDB.setGiatien(sanpham.getGiatien());
		sanphamDB.setMota(sanpham.getMota());
		session.update(sanphamDB);
		return 0;
	}
	
}
