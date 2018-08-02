package com.vandung.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="MAUSANPHAM")
public class MauSanPham {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mamau", nullable=false)
	int mamau;
	
	@Column(name="tenmau")
	String tenmau;

	public int getMamau() {
		return mamau;
	}

	public void setMamau(int mamau) {
		this.mamau = mamau;
	}

	public String getTenmau() {
		return tenmau;
	}

	public void setTenmau(String tenmau) {
		this.tenmau = tenmau;
	}
	
}
