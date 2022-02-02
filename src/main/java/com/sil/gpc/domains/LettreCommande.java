package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LettreCommande {

	@Id
	private String numLettreComm;
	
	private double valeur;

	//Liaison à la table Commande
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Commande.class)
	@JoinColumn(name = "numCommande", nullable = false, referencedColumnName = "numCommande")
	public Commande commande;
	
	//Liaison à la table CommandeAchat
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = CommandeAchat.class)
	@JoinColumn(name = "numComAchat", nullable = true, referencedColumnName = "numComAchat")
	public CommandeAchat commandeAchat;
	
	//Liaison avec la table Exercice
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Exercice.class)
	@JoinColumn(name = "numExercice", referencedColumnName = "numExercice", nullable = false)
	private Exercice exercice;


	public LettreCommande() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public LettreCommande(String numLettreComm, double valeur, Commande commande, CommandeAchat commandeAchat,
			Exercice exercice) {
		super();
		this.numLettreComm = numLettreComm;
		this.valeur = valeur;
		this.commande = commande;
		this.commandeAchat = commandeAchat;
		this.exercice = exercice;
	}



	public String getNumLettreComm() {
		return numLettreComm;
	}


	public void setNumLettreComm(String numLettreComm) {
		this.numLettreComm = numLettreComm;
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



	public CommandeAchat getCommandeAchat() {
		return commandeAchat;
	}



	public void setCommandeAchat(CommandeAchat commandeAchat) {
		this.commandeAchat = commandeAchat;
	}



	@Override
	public String toString() {
		return "LettreCommande [numLettreComm=" + numLettreComm + ", valeur=" + valeur + ", commande=" + commande
				+ ", commandeAchat=" + commandeAchat + ", exercice=" + exercice + "]";
	}


	
	
}
