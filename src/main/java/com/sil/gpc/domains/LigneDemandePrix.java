package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneDemandePrix {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneDemandePrix;
	private double qteLigneDemandePrix;
	private String designationLigneDemandePrix;
	
	//Migration de la clé de l'unité vers l'article
		@ManyToOne(fetch = FetchType.EAGER,targetEntity = DemandePrix.class)
		@JoinColumn(name = "idDemandePrix", referencedColumnName = "idDemandePrix",nullable = false)
		public DemandePrix demandePrix;
		
	//Liaison à la article
		@ManyToOne(targetEntity = Article.class, fetch = FetchType.EAGER)
		@JoinColumn(name = "numArticle", referencedColumnName = "numArticle", nullable = false)
		private Article article;
	
	//Liaison à la unité
		@ManyToOne(targetEntity = Uniter.class, fetch = FetchType.EAGER)
		@JoinColumn(name = "numUniter", referencedColumnName = "numUniter", nullable = false)
		private Uniter uniter;
		
		private String caracteristiqArti;

	public LigneDemandePrix() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public LigneDemandePrix(Long idLigneDemandePrix, double qteLigneDemandePrix, String designationLigneDemandePrix,
			DemandePrix demandePrix, Article article, Uniter uniter, String caracteristiqArti) {
		super();
		this.idLigneDemandePrix = idLigneDemandePrix;
		this.qteLigneDemandePrix = qteLigneDemandePrix;
		this.designationLigneDemandePrix = designationLigneDemandePrix;
		this.demandePrix = demandePrix;
		this.article = article;
		this.uniter = uniter;
		this.caracteristiqArti = caracteristiqArti;
	}



	public Long getIdLigneDemandePrix() {
		return idLigneDemandePrix;
	}

	public void setIdLigneDemandePrix(Long idLigneDemandePrix) {
		this.idLigneDemandePrix = idLigneDemandePrix;
	}

	public double getQteLigneDemandePrix() {
		return qteLigneDemandePrix;
	}

	public void setQteLigneDemandePrix(double qteLigneDemandePrix) {
		this.qteLigneDemandePrix = qteLigneDemandePrix;
	}

	public String getDesignationLigneDemandePrix() {
		return designationLigneDemandePrix;
	}

	public void setDesignationLigneDemandePrix(String designationLigneDemandePrix) {
		this.designationLigneDemandePrix = designationLigneDemandePrix;
	}

	public DemandePrix getDemandePrix() {
		return demandePrix;
	}

	public void setDemandePrix(DemandePrix demandePrix) {
		this.demandePrix = demandePrix;
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

	public String getCaracteristiqArti() {
		return caracteristiqArti;
	}

	public void setCaracteristiqArti(String caracteristiqArti) {
		this.caracteristiqArti = caracteristiqArti;
	}



	@Override
	public String toString() {
		return "LigneDemandePrix [idLigneDemandePrix=" + idLigneDemandePrix + ", qteLigneDemandePrix="
				+ qteLigneDemandePrix + ", designationLigneDemandePrix=" + designationLigneDemandePrix
				+ ", demandePrix=" + demandePrix + ", article=" + article + ", uniter=" + uniter
				+ ", caracteristiqArti=" + caracteristiqArti + "]";
	}
		
	
	
	
	
}
