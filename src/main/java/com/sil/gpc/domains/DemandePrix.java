package com.sil.gpc.domains;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DemandePrix {

	@Id
	private String idDemandePrix;
	private String designationDemandePrix;
	private Timestamp dateDemandePrix;
	private Timestamp dateLimiteDemandePrix;
	private boolean valideDemandePrix;
	private double reporter;
	
	//Liaison à exercice
		@ManyToOne(fetch = FetchType.EAGER, targetEntity = Exercice.class)
		@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = true)
		private Exercice exercice;

	public DemandePrix() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemandePrix(String idDemandePrix, String designationDemandePrix, Timestamp dateDemandePrix,
			Timestamp dateLimiteDemandePrix, boolean valideDemandePrix, double reporter, Exercice exercice) {
		super();
		this.idDemandePrix = idDemandePrix;
		this.designationDemandePrix = designationDemandePrix;
		this.dateDemandePrix = dateDemandePrix;
		this.dateLimiteDemandePrix = dateLimiteDemandePrix;
		this.valideDemandePrix = valideDemandePrix;
		this.reporter = reporter;
		this.exercice = exercice;
	}

	public String getIdDemandePrix() {
		return idDemandePrix;
	}

	public void setIdDemandePrix(String idDemandePrix) {
		this.idDemandePrix = idDemandePrix;
	}

	public String getDesignationDemandePrix() {
		return designationDemandePrix;
	}

	public void setDesignationDemandePrix(String designationDemandePrix) {
		this.designationDemandePrix = designationDemandePrix;
	}

	public Timestamp getDateDemandePrix() {
		return dateDemandePrix;
	}

	public void setDateDemandePrix(Timestamp dateDemandePrix) {
		this.dateDemandePrix = dateDemandePrix;
	}

	public Timestamp getDateLimiteDemandePrix() {
		return dateLimiteDemandePrix;
	}

	public void setDateLimiteDemandePrix(Timestamp dateLimiteDemandePrix) {
		this.dateLimiteDemandePrix = dateLimiteDemandePrix;
	}

	public boolean isValideDemandePrix() {
		return valideDemandePrix;
	}

	public void setValideDemandePrix(boolean valideDemandePrix) {
		this.valideDemandePrix = valideDemandePrix;
	}

	public double getReporter() {
		return reporter;
	}

	public void setReporter(double reporter) {
		this.reporter = reporter;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	@Override
	public String toString() {
		return "DemandePrix [idDemandePrix=" + idDemandePrix + ", designationDemandePrix=" + designationDemandePrix
				+ ", dateDemandePrix=" + dateDemandePrix + ", dateLimiteDemandePrix=" + dateLimiteDemandePrix
				+ ", valideDemandePrix=" + valideDemandePrix + ", reporter=" + reporter + ", exercice=" + exercice
				+ "]";
	}
	
		
	
}
