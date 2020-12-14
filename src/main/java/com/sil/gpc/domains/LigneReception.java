package com.sil.gpc.domains;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LigneReception {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idReceprtion;
	private double quantiteLigneReception;
	private double PULigneReception;
	@Column(length = 150)
	private String observationLigneReception;
	private int numSerieDebLigneReception;
	private int numSerieFinLigneReception;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Reception.class)
	public Reception reception;
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = LigneCommande.class)
	public LigneCommande lignecmde;
	
	public LigneReception() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneReception(Long idReceprtion, double quantiteLigneReception, double pULigneReception,
			String observationLigneReception, int numSerieDebLigneReception, int numSerieFinLigneReception,
			Reception reception, LigneCommande lignecmde) {
		super();
		this.idReceprtion = idReceprtion;
		this.quantiteLigneReception = quantiteLigneReception;
		PULigneReception = pULigneReception;
		this.observationLigneReception = observationLigneReception;
		this.numSerieDebLigneReception = numSerieDebLigneReception;
		this.numSerieFinLigneReception = numSerieFinLigneReception;
		this.reception = reception;
		this.lignecmde = lignecmde;
	}

	public Long getIdReceprtion() {
		return idReceprtion;
	}

	public void setIdReceprtion(Long idReceprtion) {
		this.idReceprtion = idReceprtion;
	}

	public double getQuantiteLigneReception() {
		return quantiteLigneReception;
	}

	public void setQuantiteLigneReception(double quantiteLigneReception) {
		this.quantiteLigneReception = quantiteLigneReception;
	}

	public double getPULigneReception() {
		return PULigneReception;
	}

	public void setPULigneReception(double pULigneReception) {
		PULigneReception = pULigneReception;
	}

	public String getObservationLigneReception() {
		return observationLigneReception;
	}

	public void setObservationLigneReception(String observationLigneReception) {
		this.observationLigneReception = observationLigneReception;
	}

	public int getNumSerieDebLigneReception() {
		return numSerieDebLigneReception;
	}

	public void setNumSerieDebLigneReception(int numSerieDebLigneReception) {
		this.numSerieDebLigneReception = numSerieDebLigneReception;
	}

	public int getNumSerieFinLigneReception() {
		return numSerieFinLigneReception;
	}

	public void setNumSerieFinLigneReception(int numSerieFinLigneReception) {
		this.numSerieFinLigneReception = numSerieFinLigneReception;
	}

	public Reception getReception() {
		return reception;
	}

	public void setReception(Reception reception) {
		this.reception = reception;
	}

	public LigneCommande getLignecmde() {
		return lignecmde;
	}

	public void setLignecmde(LigneCommande lignecmde) {
		this.lignecmde = lignecmde;
	}

	
	
}
