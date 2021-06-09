package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Famille implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numFamille;
	private String codeFamille;
	private String libFamille;
	
	//Liaison à la sa superFamille
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Famille.class)
	@JoinColumn(name = "codeSuperFamille", referencedColumnName = "numFamille")
	private Famille superFamille;
	
	//Liaison à la son magasin qui la gère
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Magasin.class)
	@JoinColumn(name = "numMagasin", referencedColumnName = "numMagasin")
	private Magasin magasin;

	public Famille() {
		super();
	}



	public Famille(String codeFamille, String libFamille, Famille superFamille, Magasin magasin) {
		super();
		this.codeFamille = codeFamille;
		this.libFamille = libFamille;
		this.superFamille = superFamille;
		this.magasin = magasin;
	}



	public Long getNumFamille() {
		return numFamille;
	}



	public void setNumFamille(Long numFamille) {
		this.numFamille = numFamille;
	}



	public String getCodeFamille() {
		return codeFamille;
	}

	public void setCodeFamille(String codeFamille) {
		this.codeFamille = codeFamille;
	}

	public String getLibFamille() {
		return libFamille;
	}

	public void setLibFamille(String libFamille) {
		this.libFamille = libFamille;
	}



	public Famille getSuperFamille() {
		return superFamille;
	}

	public void setSuperFamille(Famille superFamille) {
		this.superFamille = superFamille;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}



	@Override
	public String toString() {
		return "Famille [numFamille=" + numFamille + ", codeFamille=" + codeFamille + ", libFamille=" + libFamille
				+ ", superFamille=" + superFamille + ", magasin=" + magasin + "]";
	}





}
