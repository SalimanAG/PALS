package com.sil.gpc.domains;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reception {

	@Id
	@Column(length = 12)
	private String numReception;
	@Column(length = 150)
	private String observation;
	private Date dateReception;
	private boolean valideRecep; 
	private Long valeur;
	
	public Reception() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numReception
	 * @param observation
	 * @param dateReception
	 * @param valideRecep
	 */
	public Reception(String numReception, String observation, Date dateReception, boolean valideRecep) {
		this.numReception = numReception;
		this.observation = observation;
		this.dateReception = dateReception;
		this.valideRecep = valideRecep;
	}

	/**
	 * @return the numReception
	 */
	public String getNumReception() {
		return numReception;
	}

	/**
	 * @param numReception the numReception to set
	 */
	public void setNumReception(String numReception) {
		this.numReception = numReception;
	}

	/**
	 * @return the observation
	 */
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

	/**
	 * @return the valeur
	 */
	public Long getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(Long valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the valideRecep
	 */
	public boolean isValideRecep() {
		return valideRecep;
	}

	/**
	 * @param valideRecep the valideRecep to set
	 */
	public void setValideRecep(boolean valideRecep) {
		this.valideRecep = valideRecep;
	}

	@Override
	public String toString() {
		return "Reception [numReception=" + numReception + ", observation=" + observation + ", dateReception="
				+ dateReception + ", valideRecep=" + valideRecep + "]";
	}

}
