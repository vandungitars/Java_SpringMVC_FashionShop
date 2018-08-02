package com.vandung.dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vandung.entity.NhanVien;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NhanVienDAO implements NhanVienDAOImp{

	@Autowired
	SessionFactory mySessionFactory;
	
	@Override
	@Transactional
	public boolean KiemTraDangNhap(String email, String matkhau) {
		System.out.println(email + " " + matkhau);
		NhanVien nhanvien = new NhanVien();
		Session session = mySessionFactory.getCurrentSession();
		nhanvien = (NhanVien)session.createQuery("FROM NHANVIEN WHERE email='"+email+"' AND matkhau='"+matkhau+"'").getSingleResult();
		if(nhanvien != null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	@Transactional
	public boolean KiemTraDangKy(String emaildangky, String matkhaudangky, String nhaplaimatkhau) {
		boolean checkemail = validate(emaildangky);
		if(checkemail){
			if(matkhaudangky.equals(nhaplaimatkhau)) {
				NhanVien nhanvien = new NhanVien();
				nhanvien.setMatkhau(matkhaudangky);
				Session session = mySessionFactory.getCurrentSession();
				session.save(nhanvien);
				return true;
			}
			else {
				return false;
			}
		}
		else{
			return false;
		}
	}
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
	        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
	        return matcher.find();
	}
}
