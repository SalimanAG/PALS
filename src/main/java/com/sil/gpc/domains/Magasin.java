package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Magasin implements Serializable{

	@Id
	private String codeMagasin;
	private String libMagasin;
	
	public Magasin() {
		super();
	}

	public Magasin(String codeMagasin, String libMagasin) {
		super();
		this.codeMagasin = codeMagasin;
		this.libMagasin = libMagasin;
	}

	public String getCodeMagasin() {
		return codeMagasin;
	}

	public void setCodeMagasin(String codeMagasin) {
		this.codeMagasin = codeMagasin;
	}

	public String getLibMagasin() {
		return libMagasin;
	}

	public void setLibMagasin(String libMagasin) {
		this.libMagasin = libMagasin;
	}



	@Override
	public String toString() {
		return "Magasin [codeMagasin=" + codeMagasin + ", libMagasin=" + libMagasin + "]";
	}
	
}
