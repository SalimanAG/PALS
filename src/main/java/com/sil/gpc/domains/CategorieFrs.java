package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CategorieFrs {

	@Id
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

	@Override
	public String toString() {
		return "CategorieFrs [codeCatFrs=" + codeCatFrs + ", libCatFrs=" + libCatFrs + "]";
	}
	
	
	
}
