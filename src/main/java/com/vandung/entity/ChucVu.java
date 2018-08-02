package com.vandung.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "CHUCVU")
public class ChucVu {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "machucvu", nullable=false)
	int machucvu;
	
	@Column(name = "tenchucvu")
	String tenchucvu;

	public int getMachucvu() {
		return machucvu;
	}

	public void setMachucvu(int machucvu) {
		this.machucvu = machucvu;
	}

	public String getTenchucvu() {
		return tenchucvu;
	}

	public void setTenchucvu(String tenchucvu) {
		this.tenchucvu = tenchucvu;
	}
	
}
