package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Recollement implements Serializable {

	@Id
	private String numRecollement;
	private String descriptionRecollement;
	private Date dateRecollement;

	// Liaison avec Magasin
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Magasin.class)
	@JoinColumn(name = "codeMagasin", referencedColumnName = "codeMagasin", nullable = false)
	private Magasin magasin;

	// Liaison avec Correspondant
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Correspondant.class)
	@JoinColumn(name = "idCorrespondant", referencedColumnName = "idCorrespondant", nullable = true)
	private Correspondant corres;

	// Liaison avec Regisseur
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Regisseur.class)
	@JoinColumn(name = "idRegisseur", referencedColumnName = "idRegisseur", nullable = false)
	private Regisseur regisseur;

	// Liaison avec Exercice
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = false)
	private Exercice exercice;
	public Recollement() {
		super();
	}

	public Recollement(String numRecollement, String descriptionRecollement, Date dateRecollement, Magasin magasin,
			Regisseur regisseur, Exercice exercice) {
		super();
		this.numRecollement = numRecollement;
		this.descriptionRecollement = descriptionRecollement;
		this.dateRecollement = dateRecollement;
		this.magasin = magasin;
		this.regisseur = regisseur;
		this.exercice = exercice;
	}

	/**
	 * @return the numRecollement
	 */
	public String getNumRecollement() {
		return numRecollement;
	}

	/**
	 * @param numRecollement the numRecollement to set
	 */
	public void setNumRecollement(String numRecollement) {
		this.numRecollement = numRecollement;
	}

	/**
	 * @return the descriptionRecollement
	 */
	public String getDescriptionRecollement() {
		return descriptionRecollement;
	}

	/**
	 * @param descriptionRecollement the descriptionRecollement to set
	 */
	public void setDescriptionRecollement(String descriptionRecollement) {
		this.descriptionRecollement = descriptionRecollement;
	}

	/**
	 * @return the dateRecollement
	 */
	public Date getDateRecollement() {
		return dateRecollement;
	}

	/**
	 * @param dateRecollement the dateRecollement to set
	 */
	public void setDateRecollement(Date dateRecollement) {
		this.dateRecollement = dateRecollement;
	}

	/**
	 * @return the magasin
	 */
	public Magasin getMagasin() {
		return magasin;
	}

	/**
	 * @param magasin the magasin to set
	 */
	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
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
		return Objects.hash(dateRecollement, descriptionRecollement, exercice, magasin, numRecollement, regisseur);
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
		Recollement other = (Recollement) obj;
		return Objects.equals(dateRecollement, other.dateRecollement)
				&& Objects.equals(descriptionRecollement, other.descriptionRecollement)
				&& Objects.equals(exercice, other.exercice) && Objects.equals(magasin, other.magasin)
				&& Objects.equals(numRecollement, other.numRecollement) && Objects.equals(regisseur, other.regisseur);
	}

	@Override
	public String toString() {
		return "Recollement [numRecollement=" + numRecollement + ", descriptionRecollement=" + descriptionRecollement
				+ ", dateRecollement=" + dateRecollement + ", magasin=" + magasin + ", corres=" + corres
				+ ", regisseur=" + regisseur + ", exercice=" + exercice + "]";
	}

}
