package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneInventaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneInv;
	private double pu;
	private double stockTheoriq;
	private double stockreel;
	private String observation;

	//Migration de la clé de l'unité vers l'article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Article.class)
	@JoinColumn(name = "codeArticle", referencedColumnName = "codeArticle",nullable = false)
	private Article article;

	//Migration de la clé de l'unité vers l'article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Inventaire.class)
	@JoinColumn(name = "numInv", referencedColumnName = "numInv",nullable = false)
	private Inventaire inventaire;

	/**
	 * 
	 */
	public LigneInventaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public LigneInventaire(Long idLigneInv, double pu, double stockTheoriq, double stockreel, String observation,
			Article article, Inventaire inventaire) {
		super();
		this.idLigneInv = idLigneInv;
		this.pu = pu;
		this.stockTheoriq = stockTheoriq;
		this.stockreel = stockreel;
		this.observation = observation;
		this.article = article;
		this.inventaire = inventaire;
	}



	/**
	 * @return the idLigneInv
	 */
	public Long getIdLigneInv() {
		return idLigneInv;
	}

	/**
	 * @param idLigneInv the idLigneInv to set
	 */
	public void setIdLigneInv(Long idLigneInv) {
		this.idLigneInv = idLigneInv;
	}

	/**
	 * @return the pu
	 */
	public double getPu() {
		return pu;
	}

	/**
	 * @param pu the pu to set
	 */
	public void setPu(double pu) {
		this.pu = pu;
	}

	/**
	 * @return the stockTheoriq
	 */
	public double getStockTheoriq() {
		return stockTheoriq;
	}

	/**
	 * @param stockTheoriq the stockTheoriq to set
	 */
	public void setStockTheoriq(double stockTheoriq) {
		this.stockTheoriq = stockTheoriq;
	}

	/**
	 * @return the stockreel
	 */
	public double getStockreel() {
		return stockreel;
	}

	/**
	 * @param stockreel the stockreel to set
	 */
	public void setStockreel(double stockreel) {
		this.stockreel = stockreel;
	}

	

	public String getObservation() {
		return observation;
	}



	public void setObservation(String observation) {
		this.observation = observation;
	}



	/**
	 * @return the article
	 */
	public Article getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(Article article) {
		this.article = article;
	}

	/**
	 * @return the inventaire
	 */
	public Inventaire getInventaire() {
		return inventaire;
	}

	/**
	 * @param inventaire the inventaire to set
	 */
	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}



	@Override
	public String toString() {
		return "LigneInventaire [idLigneInv=" + idLigneInv + ", pu=" + pu + ", stockTheoriq=" + stockTheoriq
				+ ", stockreel=" + stockreel + ", observation=" + observation + ", article=" + article + ", inventaire="
				+ inventaire + "]";
	}
	
	
	
}
