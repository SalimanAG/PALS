package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CommandeAchat {

	@Id
	private String numComAchat;
	
	private double valeur;
	

	//Liaison à la table Commande
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Commande.class)
	@JoinColumn(name = "numCommande", nullable = false, referencedColumnName = "numCommande")
	public Commande commande;
	
	//Liaison avec la table Exercice
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Exercice.class)
	@JoinColumn(name = "numExercice", referencedColumnName = "numExercice", nullable = false)
	private Exercice exercice;


	public CommandeAchat() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CommandeAchat(String numComAchat, double valeur, Commande commande, Exercice exercice) {
		super();
		this.numComAchat = numComAchat;
		this.valeur = valeur;
		this.commande = commande;
		this.exercice = exercice;
	}




	public String getNumComAchat() {
		return numComAchat;
	}


	public void setNumComAchat(String numComAchat) {
		this.numComAchat = numComAchat;
	}


	public Commande getCommande() {
		return commande;
	}


	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	
	

	public double getValeur() {
		return valeur;
	}


	public void setValeur(double valeur) {
		this.valeur = valeur;
	}


	public Exercice getExercice() {
		return exercice;
	}


	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}


	@Override
	public String toString() {
		return "CommandeAchat [numComAchat=" + numComAchat + ", valeur=" + valeur + ", commande=" + commande
				+ ", exercice=" + exercice + "]";
	}




	
	
	
}
