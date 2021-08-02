package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Fonction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numFonction;
	private String codeFonction;
	private String libFonction;
	
	
	public Fonction() {
		// TODO Auto-generated constructor stub
	}


	public Fonction(String codeFonction, String libFonction) {
		super();
		this.codeFonction = codeFonction;
		this.libFonction = libFonction;
	}


	public Long getNumFonction() {
		return numFonction;
	}


	public void setNumFonction(Long numFonction) {
		this.numFonction = numFonction;
	}


	public String getCodeFonction() {
		return codeFonction;
	}


	public void setCodeFonction(String codeFonction) {
		this.codeFonction = codeFonction;
	}


	public String getLibFonction() {
		return libFonction;
	}


	public void setLibFonction(String libFonction) {
		this.libFonction = libFonction;
	}


	@Override
	public String toString() {
		return "Fonction [numFonction=" + numFonction + ", codeFonction=" + codeFonction + ", libFonction="
				+ libFonction + "]";
	}
	
	
	
	
	
	

}
