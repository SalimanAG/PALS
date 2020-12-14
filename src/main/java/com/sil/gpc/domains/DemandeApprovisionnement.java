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
public class DemandeApprovisionnement implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(length = 12)
	private String numDA;
	private Date dateDA;
	//Liaison à venir sur exercice
	private String codeExercice;
	
	public DemandeApprovisionnement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemandeApprovisionnement(String numDA, Date dateDA, String codeExercice) {
		super();
		this.numDA = numDA;
		this.dateDA = dateDA;
		this.codeExercice = codeExercice;
	}

	public String getNumDA() {
		return numDA;
	}

	public void setNumDA(String numDA) {
		this.numDA = numDA;
	}

	public Date getDateDA() {
		return dateDA;
	}

	public void setDateDA(Date dateDA) {
		this.dateDA = dateDA;
	}

	public String getCodeExercice() {
		return codeExercice;
	}

	public void setCodeExercice(String codeExercice) {
		this.codeExercice = codeExercice;
	}
	
	

}
