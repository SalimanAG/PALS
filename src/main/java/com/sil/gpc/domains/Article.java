package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity

public class Article implements Serializable {

	@Id
	private String codeArticle;
	private String libArticle;
	private boolean stockerArticle;
	private boolean numSerieArticle;
	private boolean livrableArticle;
	private boolean consommableArticle;
	private Long prixVenteArticle;
	private String couleurArticle;
	
	//Migration du code de la famille vers l'article
	@ManyToOne(targetEntity = Famille.class, fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
	@JoinColumn(name = "famille",referencedColumnName = "codeFamille")
	private Famille famille;

	//Migration de la clé de l'unité vers l'article
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Uniter.class)
	@JoinColumn(name = "unite", referencedColumnName = "codeUniter",nullable = false)
	public Uniter unite;

	// Liaison à LigneAppro
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = LigneAppro.class,mappedBy = "article")
	public List<LigneAppro> articlesApprovisionnes;

	// Liaison à LigneCommande
	@OneToMany(cascade = CascadeType.ALL,targetEntity = LigneCommande.class,mappedBy = "article")
	public List<LigneCommande> articlesCommandes;

	// Liaison à LigneDemmadeAppro
	@OneToMany(cascade = CascadeType.ALL,targetEntity = LigneDemandeAppro.class,mappedBy = "article")
	public List<LigneDemandeAppro> aticlesDemandés;

	// Liaison à LignePlacement
	@OneToMany(cascade = CascadeType.ALL,targetEntity = LignePlacement.class,mappedBy = "article")
	public List<LignePlacement> articlesPlaces;

	// Liaison à LigneCommande
	@OneToMany(cascade = CascadeType.ALL,targetEntity = LignePointVente.class,mappedBy = "article")
	public List<LignePointVente> articlesVendus;

	// Liaison à LigneReception
	//@OneToMany(cascade = CascadeType.ALL,targetEntity = LigneReception.class,mappedBy = "article")
	//public List<LigneReception> articlesReceptionnes;

	// Liaison à LigneRecollement
	@OneToMany(cascade = CascadeType.ALL,targetEntity = LigneRecollement.class,mappedBy = "article")
	public List<LigneRecollement> articlesRecolles;

	// Liaison à LigneReversement
	@OneToMany(cascade = CascadeType.ALL,targetEntity = LigneReversement.class,mappedBy = "article")
	public List<LigneReversement> articlesReverses;

	// Liaison à Stocker
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Stocker.class,mappedBy = "article")
	public List<Stocker> stocker;

	public Article() {
		super();
	}

	public Article(String codeArticle, String libArticle, boolean stockerArticle, boolean numSerieArticle,
			boolean livrableArticle, boolean consommableArticle, Long prixVenteArticle, String couleurArticle,
			Famille famille, Uniter uniter) {
		super();
		this.codeArticle = codeArticle;
		this.libArticle = libArticle;
		this.stockerArticle = stockerArticle;
		this.numSerieArticle = numSerieArticle;
		this.livrableArticle = livrableArticle;
		this.consommableArticle = consommableArticle;
		this.prixVenteArticle = prixVenteArticle;
		this.couleurArticle = couleurArticle;
		this.famille = famille;
		this.unite = uniter;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getLibArticle() {
		return libArticle;
	}

	public void setLibArticle(String libArticle) {
		this.libArticle = libArticle;
	}

	public boolean isStockerArticle() {
		return stockerArticle;
	}

	public void setStockerArticle(boolean stockerArticle) {
		this.stockerArticle = stockerArticle;
	}

	public boolean isNumSerieArticle() {
		return numSerieArticle;
	}

	public void setNumSerieArticle(boolean numSerieArticle) {
		this.numSerieArticle = numSerieArticle;
	}

	public boolean isLivrableArticle() {
		return livrableArticle;
	}

	public void setLivrableArticle(boolean livrableArticle) {
		this.livrableArticle = livrableArticle;
	}

	public boolean isConsommableArticle() {
		return consommableArticle;
	}

	public void setConsommableArticle(boolean consommableArticle) {
		this.consommableArticle = consommableArticle;
	}

	public Long getPrixVenteArticle() {
		return prixVenteArticle;
	}

	public void setPrixVenteArticle(Long prixVenteArticle) {
		this.prixVenteArticle = prixVenteArticle;
	}

	public String getCouleurArticle() {
		return couleurArticle;
	}

	public void setCouleurArticle(String couleurArticle) {
		this.couleurArticle = couleurArticle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeArticle == null) ? 0 : codeArticle.hashCode());
		result = prime * result + (consommableArticle ? 1231 : 1237);
		result = prime * result + ((couleurArticle == null) ? 0 : couleurArticle.hashCode());
		result = prime * result + ((libArticle == null) ? 0 : libArticle.hashCode());
		result = prime * result + (livrableArticle ? 1231 : 1237);
		result = prime * result + (numSerieArticle ? 1231 : 1237);
		result = prime * result + ((prixVenteArticle == null) ? 0 : prixVenteArticle.hashCode());
		result = prime * result + (stockerArticle ? 1231 : 1237);
		return result;
	}


	public boolean equalsIgnoreCase(String anotherString) {
		return codeArticle.equalsIgnoreCase(anotherString);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "Article [codeArticle=" + codeArticle + ", libArticle=" + libArticle + ", stockerArticle="
				+ stockerArticle + ", numSerieArticle=" + numSerieArticle + ", livrableArticle=" + livrableArticle
				+ ", consommableArticle=" + consommableArticle + ", prixVenteArticle=" + prixVenteArticle
				+ ", couleurArticle=" + couleurArticle + ", codeFamille=" + famille + "]";
	}
	
	
}
