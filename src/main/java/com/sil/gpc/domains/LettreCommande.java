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
	

	//Liaison à la table Commande
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Commande.class)
	@JoinColumn(name = "numCommande", nullable = false, referencedColumnName = "numCommande")
	public Commande commande;


	public LettreCommande() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LettreCommande(String numLettreComm, Commande commande) {
		super();
		this.numLettreComm = numLettreComm;
		this.commande = commande;
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


	@Override
	public String toString() {
		return "LettreCommande [numLettreComm=" + numLettreComm + ", commande=" + commande + "]";
	}

	
	
}
