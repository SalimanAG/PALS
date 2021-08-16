package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Reception implements Serializable {

	@Id
	@Column(length = 50)
	private String numReception;
	private String observation;
	private Timestamp dateReception;
	private boolean valideRecep;
	private int valeur;
	private String referenceReception;
	private String refBordLivraiRecept;
	private Timestamp dateValidation;

	@ManyToOne(targetEntity = Exercice.class)
	@JoinColumn(name = "numExercice", referencedColumnName = "numExercice")
	Exercice exercice;
	
	@ManyToOne(targetEntity = Magasin.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "numMagasin", referencedColumnName = "numMagasin")
	private Magasin magasin;
	
	
	public Reception() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Reception(String numReception, String observation, Timestamp dateReception, boolean valideRecep, int valeur,
			String referenceReception, String refBordLivraiRecept, Exercice exercice, Magasin magasin) {
		super();
		this.numReception = numReception;
		this.observation = observation;
		this.dateReception = dateReception;
		this.valideRecep = valideRecep;
		this.valeur = valeur;
		this.referenceReception = referenceReception;
		this.refBordLivraiRecept = refBordLivraiRecept;
		this.exercice = exercice;
		this.magasin = magasin;
	}




	public Exercice getExercice() {
		return exercice;
	}
	
	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}
	
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	public String getNumReception() {
		return numReception;
	}

	/**
	 * @param numReception the numReception to set
	 */
	public void setNumReception(String numReception) {
		this.numReception = numReception;
	}

	public int getValeur() {
		return valeur;
	}
	
	public String getObservation() {
		return observation;
	}

	/**
	 * @param observation the observation to set
	 */
	public void setObservation(String observation) {
		this.observation = observation;
	}

	

	public Timestamp getDateReception() {
		return dateReception;
	}



	public void setDateReception(Timestamp dateReception) {
		this.dateReception = dateReception;
	}



	public String getReferenceReception() {
		return referenceReception;
	}



	public void setReferenceReception(String referenceReception) {
		this.referenceReception = referenceReception;
	}



	public String getRefBordLivraiRecept() {
		return refBordLivraiRecept;
	}



	public void setRefBordLivraiRecept(String refBordLivraiRecept) {
		this.refBordLivraiRecept = refBordLivraiRecept;
	}



	public boolean isValideRecep() {
		return valideRecep;
	}

	/**
	 * @param valideRecep the valideRecep to set
	 */
	public void setValideRecep(boolean valideRecep) {
		this.valideRecep = valideRecep;
	}
	
	

	public Magasin getMagasin() {
		return magasin;
	}
	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}



	public Timestamp getDateValidation() {
		return dateValidation;
	}



	public void setDateValidation(Timestamp dateValidation) {
		this.dateValidation = dateValidation;
	}


	@Override
	public String toString() {
		return "Reception [numReception=" + numReception + ", observation=" + observation + ", dateReception="
				+ dateReception + ", valideRecep=" + valideRecep + ", valeur=" + valeur + ", referenceReception="
				+ referenceReception + ", refBordLivraiRecept=" + refBordLivraiRecept + ", dateValidation="
				+ dateValidation + ", exercice=" + exercice + ", magasin=" + magasin + "]";
	}

	
	
	
}
