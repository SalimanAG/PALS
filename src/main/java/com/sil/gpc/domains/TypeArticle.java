package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeArticle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numTypeArt;
	private String codeTypeArt;
	private String libTypeArt;
	
	public TypeArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeArticle(String codeTypeArt, String libTypeArt) {
		super();
		this.codeTypeArt = codeTypeArt;
		this.libTypeArt = libTypeArt;
	}

	public String getCodeTypeArt() {
		return codeTypeArt;
	}

	public void setCodeTypeArt(String codeTypeArt) {
		this.codeTypeArt = codeTypeArt;
	}

	public String getLibTypeArt() {
		return libTypeArt;
	}

	public void setLibTypeArt(String libTypeArt) {
		this.libTypeArt = libTypeArt;
	}

	
	
	public Long getNumTypeArt() {
		return numTypeArt;
	}

	public void setNumTypeArt(Long numTypeArt) {
		this.numTypeArt = numTypeArt;
	}

	@Override
	public String toString() {
		return "TypeArticle [numTypeArt=" + numTypeArt + ", codeTypeArt=" + codeTypeArt + ", libTypeArt=" + libTypeArt
				+ "]";
	}

	
	

}
