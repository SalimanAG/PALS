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
	

	//Liaison à la table Commande
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Commande.class)
	@JoinColumn(name = "numCommande", nullable = false, referencedColumnName = "numCommande")
	public Commande commande;


	public CommandeAchat() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CommandeAchat(String numComAchat, Commande commande) {
		super();
		this.numComAchat = numComAchat;
		this.commande = commande;
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


	@Override
	public String toString() {
		return "CommandeAchat [numComAchat=" + numComAchat + ", commande=" + commande + "]";
	}
	
	
	
}
