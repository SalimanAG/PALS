package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CategorieFrs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numCatFrs;
	private String codeCatFrs;
	private String libCatFrs;
	
	public CategorieFrs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategorieFrs(String codeCatFrs, String libCatFrs) {
		super();
		this.codeCatFrs = codeCatFrs;
		this.libCatFrs = libCatFrs;
	}

	public String getCodeCatFrs() {
		return codeCatFrs;
	}

	public void setCodeCatFrs(String codeCatFrs) {
		this.codeCatFrs = codeCatFrs;
	}

	public String getLibCatFrs() {
		return libCatFrs;
	}

	public void setLibCatFrs(String libCatFrs) {
		this.libCatFrs = libCatFrs;
	}

	
	
	
	public Long getNumCatFrs() {
		return numCatFrs;
	}

	public void setNumCatFrs(Long numCatFrs) {
		this.numCatFrs = numCatFrs;
	}

	@Override
	public String toString() {
		return "CategorieFrs [numCatFrs=" + numCatFrs + ", codeCatFrs=" + codeCatFrs + ", libCatFrs=" + libCatFrs + "]";
	}


	
	
	
}
