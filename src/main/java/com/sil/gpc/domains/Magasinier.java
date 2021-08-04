package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Magasinier implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numMAgasinier;
	@Column(unique = true)
	private String nomMagasinier;
	private String prenomMagasinier;
	private String telMagasinier;
	
	public Magasinier() {
		super();
	}

	public Magasinier(String nomMagasinier, String prenomMagasinier, String telMagasinier) {
		super();
		this.nomMagasinier = nomMagasinier;
		this.prenomMagasinier = prenomMagasinier;
		this.telMagasinier = telMagasinier;
	}

	public Long getNumMAgasinier() {
		return numMAgasinier;
	}

	public void setNumMAgasinier(Long numMAgasinier) {
		this.numMAgasinier = numMAgasinier;
	}

	public String getNomMagasinier() {
		return nomMagasinier;
	}

	public void setNomMagasinier(String nomMagasinier) {
		this.nomMagasinier = nomMagasinier;
	}

	public String getPrenomMagasinier() {
		return prenomMagasinier;
	}

	public void setPrenomMagasinier(String prenomMagasinier) {
		this.prenomMagasinier = prenomMagasinier;
	}

	public String getTelMagasinier() {
		return telMagasinier;
	}

	public void setTelMagasinier(String telMagasinier) {
		this.telMagasinier = telMagasinier;
	}



	@Override
	public String toString() {
		return "MagasinierService [numMAgasinier=" + numMAgasinier + ", nomMagasinier=" + nomMagasinier + ", prenomMagasinier="
				+ prenomMagasinier + ", telMagasinier=" + telMagasinier + "]";
	}
	
	
	
}
