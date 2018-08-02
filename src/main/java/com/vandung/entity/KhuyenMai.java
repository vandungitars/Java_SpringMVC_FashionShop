package com.vandung.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity(name="KHUYENMAI")
public class KhuyenMai {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="makhuyenmai", nullable=false)
	int makhuyenmai;
	
	@Column(name="tenkhuyenmai")
	String tenkhuyenmai;
	
	@Column(name="thoigianbatdau")
	String thoigianbatdau;
	
	@Column(name="thoigianketthuc")
	String thoigianketthuc;
	
	@Column(name="mota")
	String mota;
	
	@Column(name="hinhkhuyenmai")
	String hinhkhuyenmai;
	
	@Column(name="giagiam")
	int giagiam;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="CHITIETKHUYENMAI",
	joinColumns= {@JoinColumn(name="makhuyenmai",referencedColumnName="makhuyenmai")},
	inverseJoinColumns= {@JoinColumn(name="masanpham",referencedColumnName="masanpham")})
	Set<SanPham> danhsachsanpham;

	public int getMakhuyenmai() {
		return makhuyenmai;
	}

	public void setMakhuyenmai(int makhuyenmai) {
		this.makhuyenmai = makhuyenmai;
	}

	public String getTenkhuyenmai() {
		return tenkhuyenmai;
	}

	public void setTenkhuyenmai(String tenkhuyenmai) {
		this.tenkhuyenmai = tenkhuyenmai;
	}

	public String getThoigianbatdau() {
		return thoigianbatdau;
	}

	public void setThoigianbatdau(String thoigianbatdau) {
		this.thoigianbatdau = thoigianbatdau;
	}

	public String getThoigianketthuc() {
		return thoigianketthuc;
	}

	public void setThoigianketthuc(String thoigianketthuc) {
		this.thoigianketthuc = thoigianketthuc;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getHinhkhuyenmai() {
		return hinhkhuyenmai;
	}

	public void setHinhkhuyenmai(String hinhkhuyenmai) {
		this.hinhkhuyenmai = hinhkhuyenmai;
	}

	public int getGiagiam() {
		return giagiam;
	}

	public void setGiagiam(int giagiam) {
		this.giagiam = giagiam;
	}

	public Set<SanPham> getDanhsachsanpham() {
		return danhsachsanpham;
	}

	public void setDanhsachsanpham(Set<SanPham> danhsachsanpham) {
		this.danhsachsanpham = danhsachsanpham;
	}
	
}
