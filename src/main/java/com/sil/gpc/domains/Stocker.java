package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Stocker implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idStocker;
	private double quantiterStocker;
	private double stockDeSecuriter;
	private double stockMinimal;
	private double cmup;

	//Liaison à l'article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Article.class)
	@JoinColumn(name = "numArticle",referencedColumnName = "numArticle",nullable = false)
	private Article article;

	//Liaison à l'article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Magasin.class)
	@JoinColumn(name = "numMagasin",referencedColumnName = "numMagasin",nullable = false)
	private Magasin magasin;
	
	public Stocker() {
		super();
	}

	public Stocker(Long idStocker, double quantiterStocker, double stockDeSecuriter, double stockMinimal, double cmup,
			Article article, Magasin magasin) {
		super();
		this.idStocker = idStocker;
		this.quantiterStocker = quantiterStocker;
		this.stockDeSecuriter = stockDeSecuriter;
		this.stockMinimal = stockMinimal;
		this.cmup = cmup;
		this.article = article;
		this.magasin = magasin;
	}
	
	/**
	 * @return the numRecollement
	 */
	public Long getIdStocker() {
		return idStocker;
	}

	/**
	 * @param
	 */
	public void setIdStocker(Long idStocker) {
		this.idStocker = idStocker;
	}
	
	
	/**
	 * @return 
	 */
	public double getStockDeSecuriter() {
		return stockDeSecuriter;
	}

	/**
	 * @param 
	 */
	public void setStockDeSecuriter(double stockDeSecuriter) {
		this.stockDeSecuriter = stockDeSecuriter;
	}
	
	/**
	 * @return 
	 */
	public double getCmup() {
		return cmup;
	}

	/**
	 * @param 
	 */
	public void setCmup(double cmup) {
		this.cmup = cmup;
	}
	
	/**
	 * @return 
	 */
	public double getStockMinimal() {
		return stockMinimal;
	}

	/**
	 * @param 
	 */
	public void setstockMinimal(double stockMinimal) {
		this.stockMinimal = stockDeSecuriter;
	}
	
	/**
	 * @return 
	 */
	public double getQuantiterStocker() {
		return quantiterStocker;
	}

	/**
	 * @param 
	 */
	public void setQuantiterStocker(Double quantiterStocker) {
		this.quantiterStocker = quantiterStocker;
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
	
	//
	public Article getArticle() {
		return article;
	}
	
	//
	public void setArticle(Article article) {
		this.article = article;
	}
	
	

	public void setStockMinimal(Double stockMinimal) {
		this.stockMinimal = stockMinimal;
	}

	@Override
	public String toString() {
		return "Stocker [idStocker=" + idStocker + ", quantiterStocker=" + quantiterStocker + ", stockDeSecuriter="
				+ stockDeSecuriter + ", stockMinimal=" + stockMinimal + ", cmup=" + cmup + ", article=" + article
				+ ", magasin=" + magasin + "]";
	}

}
