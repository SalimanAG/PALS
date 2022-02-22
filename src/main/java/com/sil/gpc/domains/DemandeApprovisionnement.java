package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;

@SuppressWarnings("serial")
@Entity
public class DemandeApprovisionnement implements Serializable{
	@Id
	@Column(length = 20)
	private String numDA;
	private Timestamp dateDA;
	private int valeur;
	private boolean valideDA;
	private String description;
	
	//Liaison avec Exercice
	@ManyToOne(targetEntity = Exercice.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "numExercice", referencedColumnName = "numExercice",nullable = false)
	public Exercice exercice;
	
	//Liaison avec Centre de consommation 
	@ManyToOne(targetEntity = Service.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "numService", referencedColumnName = "numService",nullable = false)
	public Service service;
	
	//@ColumnDefault(value = "false")
	@ColumnDefault(value = "0")
	private boolean notProcessAgain;

	public DemandeApprovisionnement() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public DemandeApprovisionnement(String numDA, Timestamp dateDA, int valeur, boolean valideDA, String description,
			Exercice exercice, Service service, boolean notProcessAgain) {
		super();
		this.numDA = numDA;
		this.dateDA = dateDA;
		this.valeur = valeur;
		this.valideDA = valideDA;
		this.description = description;
		this.exercice = exercice;
		this.service = service;
		this.notProcessAgain = notProcessAgain;
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
	public Timestamp getDateDA() {
		return dateDA;
	}

	/**
	 * @param dateDA the dateDA to set
	 */
	public void setDateDA(Timestamp dateDA) {
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


	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public boolean isNotProcessAgain() {
		return notProcessAgain;
	}



	public void setNotProcessAgain(boolean notProcessAgain) {
		this.notProcessAgain = notProcessAgain;
	}



	@Override
	public String toString() {
		return "DemandeApprovisionnement [numDA=" + numDA + ", dateDA=" + dateDA + ", valeur=" + valeur + ", valideDA="
				+ valideDA + ", description=" + description + ", exercice=" + exercice + ", service=" + service
				+ ", notProcessAgain=" + notProcessAgain + "]";
	}



	


}
