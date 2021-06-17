package com.sil.gpc.domains;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class FactureProFormAcha {

	@Id
	private String idFpfa;
	private Timestamp dateFpfa;
	private String designationFpfa;
	private boolean valideFpfa;
	private Timestamp datePriseFpfa;
	private Timestamp dateDeplisFpfa;
	private String obserFpfa;
	private double valeur;
	
	//Migration de la clé de l'unité vers l'article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Fournisseur.class)
	@JoinColumn(name = "numFournisseur", referencedColumnName = "numFournisseur",nullable = false)
	public Fournisseur fournisseur;
	
	//Migration de la clé de l'exercice
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Exercice.class)
	@JoinColumn(name = "numExercice", referencedColumnName = "numExercice",nullable = true)
	public Exercice exercice;
	

	//Liaison à la table Commande
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Commande.class)
	@JoinColumn(name = "numCommande", nullable = false, referencedColumnName = "numCommande")
	public Commande commande;
	
	//Liaison à la demande de prix ayant faire objet
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = DemandePrix.class)
	@JoinColumn(name = "idDemandePrix", referencedColumnName = "idDemandePrix",nullable = false)
	public DemandePrix demandePrix;



	public FactureProFormAcha() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public FactureProFormAcha(String idFpfa, Timestamp dateFpfa, String designationFpfa, boolean valideFpfa,
			Timestamp datePriseFpfa, Timestamp dateDeplisFpfa, String obserFpfa, Fournisseur fournisseur,
			Exercice exercice, Commande commande, DemandePrix demandePrix) {
		super();
		this.idFpfa = idFpfa;
		this.dateFpfa = dateFpfa;
		this.designationFpfa = designationFpfa;
		this.valideFpfa = valideFpfa;
		this.datePriseFpfa = datePriseFpfa;
		this.dateDeplisFpfa = dateDeplisFpfa;
		this.obserFpfa = obserFpfa;
		this.fournisseur = fournisseur;
		this.exercice = exercice;
		this.commande = commande;
		this.demandePrix = demandePrix;
	}



	public String getIdFpfa() {
		return idFpfa;
	}

	public void setIdFpfa(String idFpfa) {
		this.idFpfa = idFpfa;
	}

	public Timestamp getDateFpfa() {
		return dateFpfa;
	}

	public void setDateFpfa(Timestamp dateFpfa) {
		this.dateFpfa = dateFpfa;
	}

	public String getDesignationFpfa() {
		return designationFpfa;
	}

	public void setDesignationFpfa(String designationFpfa) {
		this.designationFpfa = designationFpfa;
	}

	public boolean isValideFpfa() {
		return valideFpfa;
	}

	public void setValideFpfa(boolean valideFpfa) {
		this.valideFpfa = valideFpfa;
	}

	public Timestamp getDatePriseFpfa() {
		return datePriseFpfa;
	}

	public void setDatePriseFpfa(Timestamp datePriseFpfa) {
		this.datePriseFpfa = datePriseFpfa;
	}

	public Timestamp getDateDeplisFpfa() {
		return dateDeplisFpfa;
	}

	public void setDateDeplisFpfa(Timestamp dateDeplisFpfa) {
		this.dateDeplisFpfa = dateDeplisFpfa;
	}

	public String getObserFpfa() {
		return obserFpfa;
	}

	public void setObserFpfa(String obserFpfa) {
		this.obserFpfa = obserFpfa;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}
	
	

	public Commande getCommande() {
		return commande;
	}



	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	


	public DemandePrix getDemandePrix() {
		return demandePrix;
	}



	public void setDemandePrix(DemandePrix demandePrix) {
		this.demandePrix = demandePrix;
	}



	public double getValeur() {
		return valeur;
	}



	public void setValeur(double valeur) {
		this.valeur = valeur;
	}



	@Override
	public String toString() {
		return "FactureProFormAcha [idFpfa=" + idFpfa + ", dateFpfa=" + dateFpfa + ", designationFpfa="
				+ designationFpfa + ", valideFpfa=" + valideFpfa + ", datePriseFpfa=" + datePriseFpfa
				+ ", dateDeplisFpfa=" + dateDeplisFpfa + ", obserFpfa=" + obserFpfa + ", fournisseur=" + fournisseur
				+ ", exercice=" + exercice + ", commande=" + commande + ", demandePrix=" + demandePrix + "]";
	}


	
	
	
}
