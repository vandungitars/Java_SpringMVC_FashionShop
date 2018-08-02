package com.vandung.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="SIZESANPHAM")
public class SizeSanPham {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="masize", nullable=false)
	int masize;
	
	@Column(name="size")
	String size;

	public int getMasize() {
		return masize;
	}

	public void setMasize(int masize) {
		this.masize = masize;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
}
