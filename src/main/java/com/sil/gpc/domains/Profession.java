package com.sil.gpc.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profession {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numProfession;
	@Column(unique = true)
	private String codeProfession;
	private String libProfession;
	
	
	public Profession() {
		// TODO Auto-generated constructor stub
	}


	public Long getNumProfession() {
		return numProfession;
	}


	public void setNumProfession(Long numProfession) {
		this.numProfession = numProfession;
	}


	public String getCodeProfession() {
		return codeProfession;
	}


	public void setCodeProfession(String codeProfession) {
		this.codeProfession = codeProfession;
	}


	public String getLibProfession() {
		return libProfession;
	}


	public void setLibProfession(String libProfession) {
		this.libProfession = libProfession;
	}


	@Override
	public String toString() {
		return "Profession [numProfession=" + numProfession + ", codeProfession=" + codeProfession + ", libProfession="
				+ libProfession + "]";
	}
	
	
	
	
	

}
