package com.vandung.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "CHITIETHOADON")

public class ChiTietHoaDon {

	@EmbeddedId
	ChiTietHoaDonId chiTietHoaDonId;
	
	@Column(name = "soluong")
	int soluong;
	
	@Column(name = "giatien")
	String giatien;

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

	public ChiTietHoaDonId getChiTietHoaDonId() {
		return chiTietHoaDonId;
	}

	public void setChiTietHoaDonId(ChiTietHoaDonId chiTietHoaDonId) {
		this.chiTietHoaDonId = chiTietHoaDonId;
	}
	
}
