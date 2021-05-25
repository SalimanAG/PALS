package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;

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
	@Column(length = 20)
	private String numReception;
	@Column(length = 150)
	private String observation;
	private Date dateReception;
	private boolean valideRecep;
	private int valeur;

	@ManyToOne(targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice")
	Exercice exercice;
	
	@ManyToOne(targetEntity = Magasin.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codeMagasin", referencedColumnName = "codeMagasin")
	private Magasin magasin;
	
	
	public Reception() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Reception(String numReception, String observation, Date dateReception, boolean valideRecep, int valeur,
			Exercice exercice, Magasin magasin) {
		super();
		this.numReception = numReception;
		this.observation = observation;
		this.dateReception = dateReception;
		this.valideRecep = valideRecep;
		this.valeur = valeur;
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

	/**
	 * @return the dateReception
	 */
	public Date getDateReception() {
		return dateReception;
	}

	/**
	 * @param dateReception the dateReception to set
	 */
	public void setDateReception(Date dateReception) {
		this.dateReception = dateReception;
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
	@Override
	public String toString() {
		return "Reception [numReception=" + numReception + ", observation=" + observation + ", dateReception="
				+ dateReception + ", valideRecep=" + valideRecep + "]";
	}

}
