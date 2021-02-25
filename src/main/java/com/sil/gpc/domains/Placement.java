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
public class Placement implements Serializable{

	@Id
	private String numPlacement;
	private Date datePlacement;

	//Liaison avec Regisseur
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Regisseur.class)
	@JoinColumn(name = "idRegisseur",referencedColumnName = "IdRegisseur",nullable = false)
	private Regisseur regisseur;

	//Liaison avec correspondant
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Correspondant.class)
	@JoinColumn(name = "idCorrespondant",referencedColumnName = "idCorrespondant",nullable = false)
	private Correspondant correspondant;

	//Liaison avec Exercice
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice",referencedColumnName = "codeExercice",nullable = false)
	private Exercice exercice;

	public Placement() {
		super();
	}

	/**
	 * @param numPlacement
	 * @param datePlacement
	 * @param regisseur
	 * @param correspondant
	 * @param exercice
	 */
	public Placement(String numPlacement, Date datePlacement, Regisseur regisseur, Correspondant correspondant,
			Exercice exercice) {
		this.numPlacement = numPlacement;
		this.datePlacement = datePlacement;
		this.regisseur = regisseur;
		this.correspondant = correspondant;
		this.exercice = exercice;
	}

	/**
	 * @return the numPlacement
	 */
	public String getNumPlacement() {
		return numPlacement;
	}

	/**
	 * @param numPlacement the numPlacement to set
	 */
	public void setNumPlacement(String numPlacement) {
		this.numPlacement = numPlacement;
	}

	/**
	 * @return the datePlacement
	 */
	public Date getDatePlacement() {
		return datePlacement;
	}

	/**
	 * @param datePlacement the datePlacement to set
	 */
	public void setDatePlacement(Date datePlacement) {
		this.datePlacement = datePlacement;
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

	/**
	 * @return the correspondant
	 */
	public Correspondant getCorrespondant() {
		return correspondant;
	}

	/**
	 * @param correspondant the correspondant to set
	 */
	public void setCorrespondant(Correspondant correspondant) {
		this.correspondant = correspondant;
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

	@Override
	public String toString() {
		return "Placement [numPlacement=" + numPlacement + ", datePlacement=" + datePlacement + ", regisseur="
				+ regisseur + ", correspondant=" + correspondant + ", exercice=" + exercice + "]";
	}
	
}
