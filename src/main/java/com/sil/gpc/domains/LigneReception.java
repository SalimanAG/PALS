package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity

public class LigneReception implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneReception;
	private double quantiteLigneReception;
	private double puLigneReception;
	private String observationLigneReception;
	private Long numSerieDebLigneReception;
	private Long numSerieFinLigneReception;
	private boolean imputer;
	
	@ManyToOne(targetEntity = LigneCommande.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "idLigneCmde",referencedColumnName = "idLigneCommande")
	private LigneCommande ligneCommande;
	
	@ManyToOne( targetEntity = Reception.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "numReception", referencedColumnName = "numReception")
	private Reception reception;
	

	public LigneReception() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LigneReception(Long idLigneReception, double quantiteLigneReception, double puLigneReception,
			String observationLigneReception, Long numSerieDebLigneReception, Long numSerieFinLigneReception,
			boolean imputer, LigneCommande ligneCommande, Reception reception) {
		super();
		this.idLigneReception = idLigneReception;
		this.quantiteLigneReception = quantiteLigneReception;
		this.puLigneReception = puLigneReception;
		this.observationLigneReception = observationLigneReception;
		this.numSerieDebLigneReception = numSerieDebLigneReception;
		this.numSerieFinLigneReception = numSerieFinLigneReception;
		this.imputer = imputer;
		this.ligneCommande = ligneCommande;
		this.reception = reception;
	}


	/**
	 * @return the idLigneReception
	 */
	public Long getIdLigneReception() {
		return idLigneReception;
	}

	/**
	 * @param idLigneReception the idLigneReception to set
	 */
	public void setIdLigneReception(Long idLigneReception) {
		this.idLigneReception = idLigneReception;
	}

	/**
	 * @return the quantiteLigneReception
	 */
	public double getQuantiteLigneReception() {
		return quantiteLigneReception;
	}

	/**
	 * @param quantiteLigneReception the quantiteLigneReception to set
	 */
	public void setQuantiteLigneReception(double quantiteLigneReception) {
		this.quantiteLigneReception = quantiteLigneReception;
	}


	

	public double getPuLigneReception() {
		return puLigneReception;
	}


	public void setPuLigneReception(double puLigneReception) {
		this.puLigneReception = puLigneReception;
	}


	public boolean isImputer() {
		return imputer;
	}


	public void setImputer(boolean imputer) {
		this.imputer = imputer;
	}


	/**
	 * @return the observationLigneReception
	 */
	public String getObservationLigneReception() {
		return observationLigneReception;
	}

	/**
	 * @param observationLigneReception the observationLigneReception to set
	 */
	public void setObservationLigneReception(String observationLigneReception) {
		this.observationLigneReception = observationLigneReception;
	}

	/**
	 * @return the numSerieDebLigneReception
	 */
	public Long getNumSerieDebLigneReception() {
		return numSerieDebLigneReception;
	}

	/**
	 * @param numSerieDebLigneReception the numSerieDebLigneReception to set
	 */
	public void setNumSerieDebLigneReception(Long numSerieDebLigneReception) {
		this.numSerieDebLigneReception = numSerieDebLigneReception;
	}

	/**
	 * @return the numSerieFinLigneReception
	 */
	public Long getNumSerieFinLigneReception() {
		return numSerieFinLigneReception;
	}

	/**
	 * @param numSerieFinLigneReception the numSerieFinLigneReception to set
	 */
	public void setNumSerieFinLigneReception(Long numSerieFinLigneReception) {
		this.numSerieFinLigneReception = numSerieFinLigneReception;
	}

	/**
	 * @return the ligneCommande
	 */
	public LigneCommande getLigneCommande() {
		return ligneCommande;
	}

	/**
	 * @param ligneCommande the ligneCommande to set
	 */
	public void setLigneCommande(LigneCommande ligneCommande) {
		this.ligneCommande = ligneCommande;
	}

	/**
	 * @return the reception
	 */
	public Reception getReception() {
		return reception;
	}

	/**
	 * @param reception the reception to set
	 */
	public void setReception(Reception reception) {
		this.reception = reception;
	}


	@Override
	public String toString() {
		return "LigneReception [idLigneReception=" + idLigneReception + ", quantiteLigneReception="
				+ quantiteLigneReception + ", puLigneReception=" + puLigneReception + ", observationLigneReception="
				+ observationLigneReception + ", numSerieDebLigneReception=" + numSerieDebLigneReception
				+ ", numSerieFinLigneReception=" + numSerieFinLigneReception + ", imputer=" + imputer
				+ ", ligneCommande=" + ligneCommande + ", reception=" + reception + "]";
	}

	
}
