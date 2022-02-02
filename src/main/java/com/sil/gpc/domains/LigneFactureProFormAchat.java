package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class LigneFactureProFormAchat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneFpfa;
	private double qteLigneFpfa;
	private double prixUnitLigneFpfa;
	private String designLigneFpfa;
	private double tauxTaxeAibicLigneFpfa;
	private double tauxTvaLigneFpfa;
	private double tauxTsLigneFpfa;
	private double prixUnitHtLigneFpfa;
	
	//Migration de la clé de l'unité vers l'article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = FactureProFormAcha.class)
	@JoinColumn(name = "idFpfa", referencedColumnName = "idFpfa",nullable = false)
	public FactureProFormAcha factureProFormAcha;
	
	//Liaison à la article
	@ManyToOne(targetEntity = Article.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "numArticle", referencedColumnName = "numArticle", nullable = false)
	private Article article;

	//Liaison à la unité
	@ManyToOne(targetEntity = Uniter.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "numUniter", referencedColumnName = "numUniter", nullable = false)
	private Uniter uniter;
	
	//@ColumnDefault(value = "false")
	@ColumnDefault(value = "0")
	private boolean prixUnitTtc;
	
	private String caracteristiqArti;

	public LigneFactureProFormAchat() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LigneFactureProFormAchat(Long idLigneFpfa, double qteLigneFpfa, double prixUnitLigneFpfa,
			String designLigneFpfa, double tauxTaxeAibicLigneFpfa, double tauxTvaLigneFpfa, double tauxTsLigneFpfa,
			double prixUnitHtLigneFpfa, FactureProFormAcha factureProFormAcha, Article article, Uniter uniter,
			boolean prixUnitTtc, String caracteristiqArti) {
		super();
		this.idLigneFpfa = idLigneFpfa;
		this.qteLigneFpfa = qteLigneFpfa;
		this.prixUnitLigneFpfa = prixUnitLigneFpfa;
		this.designLigneFpfa = designLigneFpfa;
		this.tauxTaxeAibicLigneFpfa = tauxTaxeAibicLigneFpfa;
		this.tauxTvaLigneFpfa = tauxTvaLigneFpfa;
		this.tauxTsLigneFpfa = tauxTsLigneFpfa;
		this.prixUnitHtLigneFpfa = prixUnitHtLigneFpfa;
		this.factureProFormAcha = factureProFormAcha;
		this.article = article;
		this.uniter = uniter;
		this.prixUnitTtc = prixUnitTtc;
		this.caracteristiqArti = caracteristiqArti;
	}


	public Long getIdLigneFpfa() {
		return idLigneFpfa;
	}


	public void setIdLigneFpfa(Long idLigneFpfa) {
		this.idLigneFpfa = idLigneFpfa;
	}


	public double getQteLigneFpfa() {
		return qteLigneFpfa;
	}


	public void setQteLigneFpfa(double qteLigneFpfa) {
		this.qteLigneFpfa = qteLigneFpfa;
	}


	public double getPrixUnitLigneFpfa() {
		return prixUnitLigneFpfa;
	}


	public void setPrixUnitLigneFpfa(double prixUnitLigneFpfa) {
		this.prixUnitLigneFpfa = prixUnitLigneFpfa;
	}


	public String getDesignLigneFpfa() {
		return designLigneFpfa;
	}


	public void setDesignLigneFpfa(String designLigneFpfa) {
		this.designLigneFpfa = designLigneFpfa;
	}


	public double getTauxTaxeAibicLigneFpfa() {
		return tauxTaxeAibicLigneFpfa;
	}


	public void setTauxTaxeAibicLigneFpfa(double tauxTaxeAibicLigneFpfa) {
		this.tauxTaxeAibicLigneFpfa = tauxTaxeAibicLigneFpfa;
	}


	public double getTauxTvaLigneFpfa() {
		return tauxTvaLigneFpfa;
	}


	public void setTauxTvaLigneFpfa(double tauxTvaLigneFpfa) {
		this.tauxTvaLigneFpfa = tauxTvaLigneFpfa;
	}


	public double getTauxTsLigneFpfa() {
		return tauxTsLigneFpfa;
	}


	public void setTauxTsLigneFpfa(double tauxTsLigneFpfa) {
		this.tauxTsLigneFpfa = tauxTsLigneFpfa;
	}


	public double getPrixUnitHtLigneFpfa() {
		return prixUnitHtLigneFpfa;
	}


	public void setPrixUnitHtLigneFpfa(double prixUnitHtLigneFpfa) {
		this.prixUnitHtLigneFpfa = prixUnitHtLigneFpfa;
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


	public boolean isPrixUnitTtc() {
		return prixUnitTtc;
	}


	public void setPrixUnitTtc(boolean prixUnitTtc) {
		this.prixUnitTtc = prixUnitTtc;
	}



	public String getCaracteristiqArti() {
		return caracteristiqArti;
	}



	public void setCaracteristiqArti(String caracteristiqArti) {
		this.caracteristiqArti = caracteristiqArti;
	}


	@Override
	public String toString() {
		return "LigneFactureProFormAchat [idLigneFpfa=" + idLigneFpfa + ", qteLigneFpfa=" + qteLigneFpfa
				+ ", prixUnitLigneFpfa=" + prixUnitLigneFpfa + ", designLigneFpfa=" + designLigneFpfa
				+ ", tauxTaxeAibicLigneFpfa=" + tauxTaxeAibicLigneFpfa + ", tauxTvaLigneFpfa=" + tauxTvaLigneFpfa
				+ ", tauxTsLigneFpfa=" + tauxTsLigneFpfa + ", prixUnitHtLigneFpfa=" + prixUnitHtLigneFpfa
				+ ", factureProFormAcha=" + factureProFormAcha + ", article=" + article + ", uniter=" + uniter
				+ ", prixUnitTtc=" + prixUnitTtc + ", caracteristiqArti=" + caracteristiqArti + "]";
	}
	
	

		

}
