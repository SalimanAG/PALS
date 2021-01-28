package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
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
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Regisseur.class)
	@JoinColumn(name = "idRegisseur",referencedColumnName = "IdRegisseur",nullable = false)
	private Regisseur regisseur;

	//Liaison avec correspondant
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Correspondant.class)
	@JoinColumn(name = "idCorrespondant",referencedColumnName = "idCorrespondant",nullable = false)
	private Correspondant correspondant;

	//Liaison avec Exercice
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice",referencedColumnName = "codeExercice",nullable = false)
	private Exercice exercice;

	public Placement() {
		super();
	}

	public Placement(String numPlacement, Date datePlacement, Exercice exercice) {
		super();
		this.numPlacement = numPlacement;
		this.datePlacement = datePlacement;
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
	public int hashCode() {
		return Objects.hash(correspondant, datePlacement, exercice, numPlacement, regisseur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Placement other = (Placement) obj;
		return Objects.equals(correspondant, other.correspondant) && Objects.equals(datePlacement, other.datePlacement)
				&& Objects.equals(exercice, other.exercice) && Objects.equals(numPlacement, other.numPlacement)
				&& Objects.equals(regisseur, other.regisseur);
	}

	@Override
	public String toString() {
		return "Placement [numPlacement=" + numPlacement + ", datePlacement=" + datePlacement + ", regisseur="
				+ regisseur + ", correspondant=" + correspondant + ", exercice=" + exercice + "]";
	}

}
