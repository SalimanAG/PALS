package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class LigneCommande implements Serializable{



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneCommande;
	private double qteLigneCommande;
	private double PULigneCommande;
	private double REmise;
	private double TVA;

	//Liaison à la table Commande
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Commande.class)
	@JoinColumn(name = "numCommande", nullable = false, referencedColumnName = "numCommande")
	public Commande numCommande;

	//Liaison à la table Article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Article.class)
	@JoinColumn(name = "codeArticle", nullable = false, referencedColumnName = "codeArticle")
	public Article article;
	
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LigneCommande(Long idLigneCommande, double qteLigneCommande, double pULigneCommande, double remise,
			double tVA, Commande cmde, String codeArticle) {
		super();
		this.idLigneCommande = idLigneCommande;
		this.qteLigneCommande = qteLigneCommande;
		PULigneCommande = pULigneCommande;
		REmise = remise;
		TVA = tVA;
		this.numCommande = cmde;
	}



	public Long getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(Long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public double getQteLigneCommande() {
		return qteLigneCommande;
	}

	public void setQteLigneCommande(double qteLigneCommande) {
		this.qteLigneCommande = qteLigneCommande;
	}

	public double getPULigneCommande() {
		return PULigneCommande;
	}

	public void setPULigneCommande(double pULigneCommande) {
		PULigneCommande = pULigneCommande;
	}

	public double getRemise() {
		return REmise;
	}

	public void setRemise(double remise) {
		REmise = remise;
	}

	public double getTVA() {
		return TVA;
	}

	public void setTVA(double tVA) {
		TVA = tVA;
	}

	public Commande getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(Commande numCommande) {
		this.numCommande = numCommande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
	
 	
}
