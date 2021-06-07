package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AppelOffre {

	@Id
	private String numAppelOffre;
	
	private double valeur;
	
	//Liaison à la table Commande
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Commande.class)
	@JoinColumn(name = "numCommande", nullable = false, referencedColumnName = "numCommande")
	public Commande commande;


	public AppelOffre() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AppelOffre(String numAppelOffre, Commande commande) {
		super();
		this.numAppelOffre = numAppelOffre;
		this.commande = commande;
	}


	public String getNumAppelOffre() {
		return numAppelOffre;
	}


	public void setNumAppelOffre(String numAppelOffre) {
		this.numAppelOffre = numAppelOffre;
	}


	public Commande getCommande() {
		return commande;
	}


	public void setCommande(Commande commande) {
		this.commande = commande;
	}


	@Override
	public String toString() {
		return "AppelOffre [numAppelOffre=" + numAppelOffre + ", commande=" + commande + "]";
	}


	public double getValeur() {
		return valeur;
	}


	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	
	
}
