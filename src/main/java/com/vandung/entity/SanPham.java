package com.vandung.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="SANPHAM")
public class SanPham {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "masanpham", nullable=false)
	int masanpham;
	
	@Column(name="tensanpham")
	String tensanpham;
	
	@Column(name="giatien")
	String giatien;
	
	@Column(name="mota")
	String mota;
	
	@Column(name="hinhsanpham")
	String hinhsanpham;
	
	@Column(name="gianhcho")
	String gianhcho;
	
	@OneToOne()
	@JoinColumn(name="madanhmuc")
	DanhMucSanPham danhmucsanpham;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="masanpham")
	Set<ChiTietSanPham> chitietsanpham;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="CHITIETKHUYENMAI",
	joinColumns= {@JoinColumn(name="masanpham",referencedColumnName="masanpham")},
	inverseJoinColumns= {@JoinColumn(name="makhuyenmai",referencedColumnName="makhuyenmai")})
	Set<KhuyenMai> danhsachkhuyenmai;
	
	public int getMasanpham() {
		return masanpham;
	}

	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getHinhsanpham() {
		return hinhsanpham;
	}

	public void setHinhsanpham(String hinhsanpham) {
		this.hinhsanpham = hinhsanpham;
	}

	public DanhMucSanPham getDanhmucsanpham() {
		return danhmucsanpham;
	}

	public void setDanhmucsanpham(DanhMucSanPham danhmucsanpham) {
		this.danhmucsanpham = danhmucsanpham;
	}

	public Set<ChiTietSanPham> getChitietsanpham() {
		return chitietsanpham;
	}

	public void setChitietsanpham(Set<ChiTietSanPham> chitietsanpham) {
		this.chitietsanpham = chitietsanpham;
	}

	public Set<KhuyenMai> getDanhsachkhuyenmai() {
		return danhsachkhuyenmai;
	}

	public void setDanhsachkhuyenmai(Set<KhuyenMai> danhsachkhuyenmai) {
		this.danhsachkhuyenmai = danhsachkhuyenmai;
	}

	public String getGianhcho() {
		return gianhcho;
	}

	public void setGianhcho(String gianhcho) {
		this.gianhcho = gianhcho;
	}
	
}
