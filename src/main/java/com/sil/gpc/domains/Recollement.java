package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Recollement implements Serializable{

	@Id
	private String numRecollement;
	private String descriptionRecollement;
	private Date dateRecollement;
	private Long numMagasinier;
	
	//Liaison  avec Exercice
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Exercice.class)
	@JoinColumn(name="codeExercice", referencedColumnName = "codeExercice", nullable = false)
	private Exercice exercice;

	//Liaison à la table LigneRecollement
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = LigneRecollement.class, mappedBy = "recollement")
	public List<LigneRecollement> ArticlesParRecollement;

	public Recollement() {
		super();
	}

	public Recollement(String numRecollement, String descriptionRecollement, Date dateRecollement, Long numMagasinier,
			Exercice exercice, List<LigneRecollement> articlesParRecollement) {
		super();
		this.numRecollement = numRecollement;
		this.descriptionRecollement = descriptionRecollement;
		this.dateRecollement = dateRecollement;
		this.numMagasinier = numMagasinier;
		this.exercice = exercice;
		ArticlesParRecollement = articlesParRecollement;
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
	 * @return the numMagasinier
	 */
	public Long getNumMagasinier() {
		return numMagasinier;
	}

	/**
	 * @param numMagasinier the numMagasinier to set
	 */
	public void setNumMagasinier(Long numMagasinier) {
		this.numMagasinier = numMagasinier;
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
	 * @return the articlesParRecollement
	 */
	public List<LigneRecollement> getArticlesParRecollement() {
		return ArticlesParRecollement;
	}

	/**
	 * @param articlesParRecollement the articlesParRecollement to set
	 */
	public void setArticlesParRecollement(List<LigneRecollement> articlesParRecollement) {
		ArticlesParRecollement = articlesParRecollement;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ArticlesParRecollement, dateRecollement, descriptionRecollement, exercice, numMagasinier,
				numRecollement);
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
		return Objects.equals(ArticlesParRecollement, other.ArticlesParRecollement)
				&& Objects.equals(dateRecollement, other.dateRecollement)
				&& Objects.equals(descriptionRecollement, other.descriptionRecollement)
				&& Objects.equals(exercice, other.exercice) && Objects.equals(numMagasinier, other.numMagasinier)
				&& Objects.equals(numRecollement, other.numRecollement);
	}

	@Override
	public String toString() {
		return "Recollement [numRecollement=" + numRecollement + ", descriptionRecollement=" + descriptionRecollement
				+ ", dateRecollement=" + dateRecollement + ", numMagasinier=" + numMagasinier + ", exercice=" + exercice
				+ ", ArticlesParRecollement=" + ArticlesParRecollement + "]";
	}

}
