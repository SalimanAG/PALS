package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class DemandeApprovisionnement implements Serializable{
	@Id
	@Column(length = 20)
	private String numDA;
	private Date dateDA;
	private int valeur;
	private boolean valideDA;
	
	//Liaison avec Exercice
	@ManyToOne(targetEntity = Exercice.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice",nullable = false)
	public Exercice exercice;
	
	//Liaison avec Centre de consommation 
	@ManyToOne(targetEntity = Service.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "codeService", referencedColumnName = "codeService",nullable = false)
	public Service service;

	public DemandeApprovisionnement() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public DemandeApprovisionnement(String numDA, Date dateDA, int valeur, boolean valideDA, Exercice exercice,
			Service service) {
		super();
		this.numDA = numDA;
		this.dateDA = dateDA;
		this.valeur = valeur;
		this.valideDA = valideDA;
		this.exercice = exercice;
		this.service = service;
	}



	/**
	 * @return the valeur
	 */
	public int getValeur() {
		return valeur;
	}

	public boolean isValideDA() {
		return valideDA;
	}

	public void setValideDA(boolean valideDA) {
		this.valideDA = valideDA;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the numDA
	 */
	public String getNumDA() {
		return numDA;
	}

	/**
	 * @param numDA the numDA to set
	 */
	public void setNumDA(String numDA) {
		this.numDA = numDA;
	}

	/**
	 * @return the dateDA
	 */
	public Date getDateDA() {
		return dateDA;
	}

	/**
	 * @param dateDA the dateDA to set
	 */
	public void setDateDA(Date dateDA) {
		this.dateDA = dateDA;
	}

	/**
	 * @return the exercice
	 */
	public Exercice getExercice() {
		return exercice;
	}

	/**
	 * @param exercice the exercice to set
	 */
	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}



	public Service getService() {
		return service;
	}



	public void setService(Service service) {
		this.service = service;
	}



	@Override
	public String toString() {
		return "DemandeApprovisionnement [numDA=" + numDA + ", dateDA=" + dateDA + ", valeur=" + valeur + ", valideDA="
				+ valideDA + ", exercice=" + exercice + ", service=" + service + "]";
	}



}
