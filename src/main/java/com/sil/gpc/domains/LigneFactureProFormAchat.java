package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneFactureProFormAchat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneFactureProFormAchat;
	private double qteLigneFactureProFormAchat;
	private double prixUnitLigneFactureProFormAchat;
	private String designLigneFactureProFormAchat;
	private double tauxTaxeAibicLigneFactureProFormAchat;
	private double tauxTvaLigneFactureProFormAchat;
	private double tauxTsLigneFactureProFormAchat;
	private double prixUnitHtLigneFactureProFormAchat;
	
	//Migration de la clé de l'unité vers l'article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = FactureProFormAcha.class)
	@JoinColumn(name = "idFactureProFormAcha", referencedColumnName = "idFactureProFormAcha",nullable = false)
	public FactureProFormAcha factureProFormAcha;
	
	//Liaison à la article
	@ManyToOne(targetEntity = Article.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codeArticle", referencedColumnName = "codeArticle", nullable = false)
	private Article article;

	//Liaison à la unité
	@ManyToOne(targetEntity = Uniter.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "codeUniter", referencedColumnName = "codeUniter", nullable = false)
	private Uniter uniter;

	public LigneFactureProFormAchat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneFactureProFormAchat(Long idLigneFactureProFormAchat, double qteLigneFactureProFormAchat,
			double prixUnitLigneFactureProFormAchat, String designLigneFactureProFormAchat,
			double tauxTaxeAibicLigneFactureProFormAchat, double tauxTvaLigneFactureProFormAchat,
			double tauxTsLigneFactureProFormAchat, double prixUnitHtLigneFactureProFormAchat,
			FactureProFormAcha factureProFormAcha, Article article, Uniter uniter) {
		super();
		this.idLigneFactureProFormAchat = idLigneFactureProFormAchat;
		this.qteLigneFactureProFormAchat = qteLigneFactureProFormAchat;
		this.prixUnitLigneFactureProFormAchat = prixUnitLigneFactureProFormAchat;
		this.designLigneFactureProFormAchat = designLigneFactureProFormAchat;
		this.tauxTaxeAibicLigneFactureProFormAchat = tauxTaxeAibicLigneFactureProFormAchat;
		this.tauxTvaLigneFactureProFormAchat = tauxTvaLigneFactureProFormAchat;
		this.tauxTsLigneFactureProFormAchat = tauxTsLigneFactureProFormAchat;
		this.prixUnitHtLigneFactureProFormAchat = prixUnitHtLigneFactureProFormAchat;
		this.factureProFormAcha = factureProFormAcha;
		this.article = article;
		this.uniter = uniter;
	}

	public Long getIdLigneFactureProFormAchat() {
		return idLigneFactureProFormAchat;
	}

	public void setIdLigneFactureProFormAchat(Long idLigneFactureProFormAchat) {
		this.idLigneFactureProFormAchat = idLigneFactureProFormAchat;
	}

	public double getQteLigneFactureProFormAchat() {
		return qteLigneFactureProFormAchat;
	}

	public void setQteLigneFactureProFormAchat(double qteLigneFactureProFormAchat) {
		this.qteLigneFactureProFormAchat = qteLigneFactureProFormAchat;
	}

	public double getPrixUnitLigneFactureProFormAchat() {
		return prixUnitLigneFactureProFormAchat;
	}

	public void setPrixUnitLigneFactureProFormAchat(double prixUnitLigneFactureProFormAchat) {
		this.prixUnitLigneFactureProFormAchat = prixUnitLigneFactureProFormAchat;
	}

	public String getDesignLigneFactureProFormAchat() {
		return designLigneFactureProFormAchat;
	}

	public void setDesignLigneFactureProFormAchat(String designLigneFactureProFormAchat) {
		this.designLigneFactureProFormAchat = designLigneFactureProFormAchat;
	}

	public double getTauxTaxeAibicLigneFactureProFormAchat() {
		return tauxTaxeAibicLigneFactureProFormAchat;
	}

	public void setTauxTaxeAibicLigneFactureProFormAchat(double tauxTaxeAibicLigneFactureProFormAchat) {
		this.tauxTaxeAibicLigneFactureProFormAchat = tauxTaxeAibicLigneFactureProFormAchat;
	}

	public double getTauxTvaLigneFactureProFormAchat() {
		return tauxTvaLigneFactureProFormAchat;
	}

	public void setTauxTvaLigneFactureProFormAchat(double tauxTvaLigneFactureProFormAchat) {
		this.tauxTvaLigneFactureProFormAchat = tauxTvaLigneFactureProFormAchat;
	}

	public double getTauxTsLigneFactureProFormAchat() {
		return tauxTsLigneFactureProFormAchat;
	}

	public void setTauxTsLigneFactureProFormAchat(double tauxTsLigneFactureProFormAchat) {
		this.tauxTsLigneFactureProFormAchat = tauxTsLigneFactureProFormAchat;
	}

	public double getPrixUnitHtLigneFactureProFormAchat() {
		return prixUnitHtLigneFactureProFormAchat;
	}

	public void setPrixUnitHtLigneFactureProFormAchat(double prixUnitHtLigneFactureProFormAchat) {
		this.prixUnitHtLigneFactureProFormAchat = prixUnitHtLigneFactureProFormAchat;
	}

	public FactureProFormAcha getFactureProFormAcha() {
		return factureProFormAcha;
	}

	public void setFactureProFormAcha(FactureProFormAcha factureProFormAcha) {
		this.factureProFormAcha = factureProFormAcha;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Uniter getUniter() {
		return uniter;
	}

	public void setUniter(Uniter uniter) {
		this.uniter = uniter;
	}

	@Override
	public String toString() {
		return "LigneFactureProFormAchat [idLigneFactureProFormAchat=" + idLigneFactureProFormAchat
				+ ", qteLigneFactureProFormAchat=" + qteLigneFactureProFormAchat + ", prixUnitLigneFactureProFormAchat="
				+ prixUnitLigneFactureProFormAchat + ", designLigneFactureProFormAchat="
				+ designLigneFactureProFormAchat + ", tauxTaxeAibicLigneFactureProFormAchat="
				+ tauxTaxeAibicLigneFactureProFormAchat + ", tauxTvaLigneFactureProFormAchat="
				+ tauxTvaLigneFactureProFormAchat + ", tauxTsLigneFactureProFormAchat=" + tauxTsLigneFactureProFormAchat
				+ ", prixUnitHtLigneFactureProFormAchat=" + prixUnitHtLigneFactureProFormAchat + ", factureProFormAcha="
				+ factureProFormAcha + ", article=" + article + ", uniter=" + uniter + "]";
	}
	
	

	
	
	

}
