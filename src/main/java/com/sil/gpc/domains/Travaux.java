package com.sil.gpc.domains;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Travaux {
	
	@Id
	private String numTravaux;
	private Date dateCommande;
	private Date dateRemise;
	private String description;
	private int delaiLivraison;
	private boolean valide;
	private int valeur;
	private boolean liver;
	private boolean reporter;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity =Fournisseur.class)
	@JoinColumn(name = "numFournisseur", referencedColumnName = "numFournisseur", nullable = false)
	private Fournisseur frs;

	//Liaison avec la table Exercice
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Exercice.class)
	@JoinColumn(name = "numExercice", referencedColumnName = "numExercice", nullable = false)
	private Exercice exercice;
	
	private String departement;
	private String numDa;
	private String justif;
	
	public Travaux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Travaux(String numTravaux, Date dateCommande, Date dateRemise, String description, int delaiLivraison,
			boolean valide, int valeur, boolean liver, boolean reporter, Fournisseur frs, Exercice exercice,
			String departement, String numDa, String justif) {
		super();
		this.numTravaux = numTravaux;
		this.dateCommande = dateCommande;
		this.dateRemise = dateRemise;
		this.description = description;
		this.delaiLivraison = delaiLivraison;
		this.valide = valide;
		this.valeur = valeur;
		this.liver = liver;
		this.reporter = reporter;
		this.frs = frs;
		this.exercice = exercice;
		this.departement = departement;
		this.numDa = numDa;
		this.justif = justif;
	}

	public String getNumTravaux() {
		return numTravaux;
	}

	public void setNumTravaux(String numTravaux) {
		this.numTravaux = numTravaux;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Date getDateRemise() {
		return dateRemise;
	}

	public void setDateRemise(Date dateRemise) {
		this.dateRemise = dateRemise;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDelaiLivraison() {
		return delaiLivraison;
	}

	public void setDelaiLivraison(int delaiLivraison) {
		this.delaiLivraison = delaiLivraison;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public boolean isLiver() {
		return liver;
	}

	public void setLiver(boolean liver) {
		this.liver = liver;
	}

	public boolean isReporter() {
		return reporter;
	}

	public void setReporter(boolean reporter) {
		this.reporter = reporter;
	}

	public Fournisseur getFrs() {
		return frs;
	}

	public void setFrs(Fournisseur frs) {
		this.frs = frs;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getNumDa() {
		return numDa;
	}

	public void setNumDa(String numDa) {
		this.numDa = numDa;
	}

	public String getJustif() {
		return justif;
	}

	public void setJustif(String justif) {
		this.justif = justif;
	}

	@Override
	public String toString() {
		return "Travaux [numTravaux=" + numTravaux + ", dateCommande=" + dateCommande + ", dateRemise=" + dateRemise
				+ ", description=" + description + ", delaiLivraison=" + delaiLivraison + ", valide=" + valide
				+ ", valeur=" + valeur + ", liver=" + liver + ", reporter=" + reporter + ", frs=" + frs + ", exercice="
				+ exercice + ", departement=" + departement + ", numDa=" + numDa + ", justif=" + justif + "]";
	}
	
	

}
