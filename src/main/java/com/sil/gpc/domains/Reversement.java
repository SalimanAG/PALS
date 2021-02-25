package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Reversement implements Serializable{

	@Id
	private String numReversement;
	private Date dateVersement;
	private boolean valideReve;
	
	//Liaison avec Exercice
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice",referencedColumnName = "codeExercice",nullable = false)
	private Exercice exercice;
	
	//Liaison avec Reversement
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Regisseur.class)
	@JoinColumn(name = "idRegisseur",referencedColumnName = "idRegisseur",nullable = false)
	private Regisseur regisseur;
	
	public Reversement() {
		super();
	}
	/**
	 * @return the numReversement
	 */
	public String getNumReversement() {
		return numReversement;
	}

	/**
	 * @param numReversement
	 * @param dateVersement
	 * @param valideReve
	 * @param exercice
	 * @param regisseur
	 */
	public Reversement(String numReversement, Date dateVersement, boolean valideReve, Exercice exercice,
			Regisseur regisseur) {
		this.numReversement = numReversement;
		this.dateVersement = dateVersement;
		this.valideReve = valideReve;
		this.exercice = exercice;
		this.regisseur = regisseur;
	}
	/**
	 * @param numReversement the numReversement to set
	 */
	public void setNumReversement(String numReversement) {
		this.numReversement = numReversement;
	}

	/**
	 * @return the dateVersement
	 */
	public Date getDateVersement() {
		return dateVersement;
	}

	/**
	 * @param dateVersement the dateVersement to set
	 */
	public void setDateVersement(Date dateVersement) {
		this.dateVersement = dateVersement;
	}


	/**
	 * @return the valideReve
	 */
	public boolean isValideReve() {
		return valideReve;
	}
	/**
	 * @param valideReve the valideReve to set
	 */
	public void setValideReve(boolean valideReve) {
		this.valideReve = valideReve;
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

	/**
	 * @return the regisseur
	 */
	public Regisseur getRegisseur() {
		return regisseur;
	}

	/**
	 * @param regisseur the regisseur to set
	 */
	public void setRegisseur(Regisseur regisseur) {
		this.regisseur = regisseur;
	}
	@Override
	public String toString() {
		return "Reversement [numReversement=" + numReversement + ", dateVersement=" + dateVersement + ", valideReve="
				+ valideReve + ", exercice=" + exercice + ", regisseur=" + regisseur + "]";
	}


}
