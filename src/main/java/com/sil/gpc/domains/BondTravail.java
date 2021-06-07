package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BondTravail {

	@Id
	private String numBondTravail;
	
	private double valeur;

	//Liaison à la table Commande
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Commande.class)
	@JoinColumn(name = "numCommande", nullable = false, referencedColumnName = "numCommande")
	public Commande commande;


	public BondTravail() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BondTravail(String numBondTravail, Commande commande) {
		super();
		this.numBondTravail = numBondTravail;
		this.commande = commande;
	}


	public String getNumBondTravail() {
		return numBondTravail;
	}


	public void setNumBondTravail(String numBondTravail) {
		this.numBondTravail = numBondTravail;
	}


	public Commande getCommande() {
		return commande;
	}


	public void setCommande(Commande commande) {
		this.commande = commande;
	}


	@Override
	public String toString() {
		return "BondTravail [numBondTravail=" + numBondTravail + ", commande=" + commande + "]";
	}


	public double getValeur() {
		return valeur;
	}


	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	
	
	
}
