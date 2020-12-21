package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Point implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="numPoint", length = 15)
	private String numPoint; 
	private Date datePoint;
	private boolean payerPoint;
	/// Liaison à venir avec la table Exercice
	private String codeExercice;
	/// Liaison à venir avec la table Regisseur
	private String idRegisseur;
	/// Liaison à venir avec la table Corresondant
	private String idCorrespondant;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, targetEntity = LignePoint.class)
	public List<LignePoint> lignesParPoint;
	
	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Point(String numPoint, Date datePoint, boolean payerPoint, String codeExercice, String idRegisseur,
			String idCorrespondant) {
		super();
		this.numPoint = numPoint;
		this.datePoint = datePoint;
		this.payerPoint = payerPoint;
		this.codeExercice = codeExercice;
		this.idRegisseur = idRegisseur;
		this.idCorrespondant = idCorrespondant;
	}

	public String getNumPoint() {
		return numPoint;
	}

	public void setNumPoint(String numPoint) {
		this.numPoint = numPoint;
	}

	public Date getDatePoint() {
		return datePoint;
	}

	public void setDatePoint(Date datePoint) {
		this.datePoint = datePoint;
	}

	public boolean isPayerPoint() {
		return payerPoint;
	}

	public void setPayerPoint(boolean payerPoint) {
		this.payerPoint = payerPoint;
	}

	public String getCodeExercice() {
		return codeExercice;
	}

	public void setCodeExercice(String codeExercice) {
		this.codeExercice = codeExercice;
	}

	public String getIdRegisseur() {
		return idRegisseur;
	}

	public void setIdRegisseur(String idRegisseur) {
		this.idRegisseur = idRegisseur;
	}

	public String getIdCorrespondant() {
		return idCorrespondant;
	}

	public void setIdCorrespondant(String idCorrespondant) {
		this.idCorrespondant = idCorrespondant;
	}
	
}
