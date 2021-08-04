package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Exercice implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numExercice;
	@Column(unique = true)
	private String codeExercice;
	private String libExercice;
	private Date dateDebut;
	private Date dateFin;
	private String etatExo;
	private boolean cloturerExo;
	
	public Exercice() {
		super();
	}


	public Exercice(String codeExercice, String libExercice, Date dateDebut, Date dateFin, String etatExo,
			boolean cloturerExo) {
		super();
		this.codeExercice = codeExercice;
		this.libExercice = libExercice;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etatExo = etatExo;
		this.cloturerExo = cloturerExo;
	}


	public String getCodeExercice() {
		return codeExercice;
	}

	public void setCodeExercice(String codeExercice) {
		this.codeExercice = codeExercice;
	}

	public String getLibExercice() {
		return libExercice;
	}

	public void setLibExercice(String libExercice) {
		this.libExercice = libExercice;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getEtatExo() {
		return etatExo;
	}

	public void setEtatExo(String etatExo) {
		this.etatExo = etatExo;
	}


	public boolean isCloturerExo() {
		return cloturerExo;
	}


	public void setCloturerExo(boolean cloturerExo) {
		this.cloturerExo = cloturerExo;
	}

	

	public Long getNumExercice() {
		return numExercice;
	}


	public void setNumExercice(Long numExercice) {
		this.numExercice = numExercice;
	}


	@Override
	public String toString() {
		return "Exercice [numExercice=" + numExercice + ", codeExercice=" + codeExercice + ", libExercice="
				+ libExercice + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", etatExo=" + etatExo
				+ ", cloturerExo=" + cloturerExo + "]";
	}


	
	
	
}
