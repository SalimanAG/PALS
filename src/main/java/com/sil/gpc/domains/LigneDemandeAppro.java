package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

@SuppressWarnings("serial")
@Entity
public class LigneDemandeAppro implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneDA;
	private double quantiteDemandee;

	
	//Liaison avec Article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Article.class)
	@JoinColumn(name = "numArticle", referencedColumnName = "numArticle",nullable = false)
	public Article article;
	
	//Liaison à la unité
	@ManyToOne(targetEntity = Uniter.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "numUniter", referencedColumnName = "numUniter", nullable = false)
	private Uniter uniter;

	//Liaison avec Demande Appro Approvisionnement
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = DemandeApprovisionnement.class)
	@JoinColumn(name = "numDA", referencedColumnName = "numDA",nullable = false)
	public DemandeApprovisionnement appro;
	
	//@ColumnDefault(value = "false")
	@ColumnDefault(value = "0")
	private boolean satisfaite;
	
	public LigneDemandeAppro() {
		super();
	}



	public LigneDemandeAppro(Long idLigneDA, Long quantiteDemandee, Article article, Uniter uniter,
			DemandeApprovisionnement appro) {
		super();
		this.idLigneDA = idLigneDA;
		this.quantiteDemandee = quantiteDemandee;
		this.article = article;
		this.uniter = uniter;
		this.appro = appro;
	}



	/**
	 * @return the idLigneDA
	 */
	public Long getIdLigneDA() {
		return idLigneDA;
	}

	/**
	 * @param idLigneDA the idLigneDA to set
	 */
	public void setIdLigneDA(Long idLigneDA) {
		this.idLigneDA = idLigneDA;
	}

	/**
	 * @return the quantiteDemandee
	 */
	public double getQuantiteDemandee() {
		return quantiteDemandee;
	}

	/**
	 * @param quantiteDemandee the quantiteDemandee to set
	 */
	public void setQuantiteDemandee(double quantiteDemandee) {
		this.quantiteDemandee = quantiteDemandee;
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
	 * @return the appro
	 */
	public DemandeApprovisionnement getAppro() {
		return appro;
	}

	/**
	 * @param appro the appro to set
	 */
	public void setAppro(DemandeApprovisionnement appro) {
		this.appro = appro;
	}

	public Uniter getUniter() {
		return uniter;
	}

	public void setUniter(Uniter uniter) {
		this.uniter = uniter;
	}


	public boolean isSatisfaite() {
		return satisfaite;
	}



	public void setSatisfaite(boolean satisfaite) {
		this.satisfaite = satisfaite;
	}



	@Override
	public String toString() {
		return "LigneDemandeAppro [idLigneDA=" + idLigneDA + ", quantiteDemandee=" + quantiteDemandee + ", article="
				+ article + ", uniter=" + uniter + ", appro=" + appro + ", satisfaite=" + satisfaite + "]";
	}

	


}
