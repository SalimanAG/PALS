package com.sil.gpc.domains;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CloturePeriodiq {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCloturePer;
	private Date dateDebutCloturePer;
	private Date dateFinCloturePer;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Exercice.class)
	@JoinColumn(name = "numExercice", referencedColumnName = "numExercice", nullable = true)
	private Exercice exercice;

	public CloturePeriodiq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CloturePeriodiq(Long idCloturePer, Date dateDebutCloturePer, Date dateFinCloturePer, Exercice exercice) {
		super();
		this.idCloturePer = idCloturePer;
		this.dateDebutCloturePer = dateDebutCloturePer;
		this.dateFinCloturePer = dateFinCloturePer;
		this.exercice = exercice;
	}

	public Long getIdCloturePer() {
		return idCloturePer;
	}

	public void setIdCloturePer(Long idCloturePer) {
		this.idCloturePer = idCloturePer;
	}

	public Date getDateDebutCloturePer() {
		return dateDebutCloturePer;
	}

	public void setDateDebutCloturePer(Date dateDebutCloturePer) {
		this.dateDebutCloturePer = dateDebutCloturePer;
	}

	public Date getDateFinCloturePer() {
		return dateFinCloturePer;
	}

	public void setDateFinCloturePer(Date dateFinCloturePer) {
		this.dateFinCloturePer = dateFinCloturePer;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	@Override
	public String toString() {
		return "CloturePeriodiq [idCloturePer=" + idCloturePer + ", dateDebutCloturePer=" + dateDebutCloturePer
				+ ", dateFinCloturePer=" + dateFinCloturePer + ", exercice=" + exercice + "]";
	}
	
	
	
}
