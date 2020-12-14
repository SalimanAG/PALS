package com.sil.gpc.domains;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name ="LignePoint")
public class LignePoint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLignePoint;
	private double qtePointVente;
	private double prixPointVente;
	@Column(length = 15)
	private String numDebPointVente;
	@Column(length = 15)
	private String numFinPointVente;
	
	//Liaison à la table Point
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "numPoint", nullable = false, referencedColumnName = "numPoint")
	public Point pointVente;
	
	//Liaison à la table Article
	//@ManyToOne()
	//@JoinColumn(name = "codeArticle", nullable = false, referencedColumnName = "codeArticle")
	public String codeArticle;//article;

	public LignePoint() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LignePoint(Long idLignePoint, double qtePointVente, double prixPointVente, String numDebPointVente,
			String numFinPointVente, Point pointVente, String codeArticle) {
		super();
		this.idLignePoint = idLignePoint;
		this.qtePointVente = qtePointVente;
		this.prixPointVente = prixPointVente;
		this.numDebPointVente = numDebPointVente;
		this.numFinPointVente = numFinPointVente;
		this.pointVente = pointVente;
		this.codeArticle = codeArticle;
	}

	public Long getIdLignePoint() {
		return idLignePoint;
	}

	public void setIdLignePoint(Long idLignePoint) {
		this.idLignePoint = idLignePoint;
	}

	public double getQtePointVente() {
		return qtePointVente;
	}

	public void setQtePointVente(double qtePointVente) {
		this.qtePointVente = qtePointVente;
	}

	public double getPrixPointVente() {
		return prixPointVente;
	}

	public void setPrixPointVente(double prixPointVente) {
		this.prixPointVente = prixPointVente;
	}

	public String getNumDebPointVente() {
		return numDebPointVente;
	}

	public void setNumDebPointVente(String numDebPointVente) {
		this.numDebPointVente = numDebPointVente;
	}

	public String getNumFinPointVente() {
		return numFinPointVente;
	}

	public void setNumFinPointVente(String numFinPointVente) {
		this.numFinPointVente = numFinPointVente;
	}

	public Point getPointVente() {
		return pointVente;
	}

	public void setPointVente(Point pointVente) {
		this.pointVente = pointVente;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}
			
}
