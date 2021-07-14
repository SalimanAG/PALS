package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Basic;
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
public class LigneCommande implements Serializable{



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneCommande;
	private double qteLigneCommande;
	private double puLigneCommande;
	private double remise;
	private double tva;
	private double taibic;
	private double ts;
	

	//Liaison à la table Commande
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Commande.class)
	@JoinColumn(name = "numCommande", nullable = false, referencedColumnName = "numCommande")
	public Commande numCommande;

	//Liaison à la table Article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Article.class)
	@JoinColumn(name = "numArticle", nullable = false, referencedColumnName = "numArticle")
	public Article article;
	
	//Liaison à la unité
	@ManyToOne(targetEntity = Uniter.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "numUniter", referencedColumnName = "numUniter")
	private Uniter uniter;
	
	@ColumnDefault(value = "false")
	private boolean satisfaite;
	
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LigneCommande(Long idLigneCommande, double qteLigneCommande, double puLigneCommande, double remise,
			double tva, double taibic, double ts, Commande numCommande, Article article, Uniter uniter) {
		super();
		this.idLigneCommande = idLigneCommande;
		this.qteLigneCommande = qteLigneCommande;
		this.puLigneCommande = puLigneCommande;
		this.remise = remise;
		this.tva = tva;
		this.taibic = taibic;
		this.ts = ts;
		this.numCommande = numCommande;
		this.article = article;
		this.uniter = uniter;
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


	public double getPuLigneCommande() {
		return puLigneCommande;
	}


	public void setPuLigneCommande(double puLigneCommande) {
		this.puLigneCommande = puLigneCommande;
	}


	public double getRemise() {
		return remise;
	}


	public void setRemise(double remise) {
		this.remise = remise;
	}


	public double getTva() {
		return tva;
	}


	public void setTva(double tva) {
		this.tva = tva;
	}


	public double getTaibic() {
		return taibic;
	}


	public void setTaibic(double taibic) {
		this.taibic = taibic;
	}


	public double getTs() {
		return ts;
	}


	public void setTs(double ts) {
		this.ts = ts;
	}


	public Uniter getUniter() {
		return uniter;
	}


	public void setUniter(Uniter uniter) {
		this.uniter = uniter;
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


	public boolean isSatisfaite() {
		return satisfaite;
	}


	public void setSatisfaite(boolean satisfaite) {
		this.satisfaite = satisfaite;
	}


	@Override
	public String toString() {
		return "LigneCommande [idLigneCommande=" + idLigneCommande + ", qteLigneCommande=" + qteLigneCommande
				+ ", puLigneCommande=" + puLigneCommande + ", remise=" + remise + ", tva=" + tva + ", taibic=" + taibic
				+ ", ts=" + ts + ", numCommande=" + numCommande + ", article=" + article + ", uniter=" + uniter
				+ ", satisfaite=" + satisfaite + "]";
	}
	
	
	
 	
}
