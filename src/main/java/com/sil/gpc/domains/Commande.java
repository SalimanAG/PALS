package com.sil.gpc.domains;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "numCommande", length = 8, updatable = false)
	private String numCommande;
	private Date dateCommande;
	private String description;
	private int delaiLivraison;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, targetEntity =Fournisseur.class)
	private Fournisseur frs;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = LigneCommande.class,fetch = FetchType.EAGER,mappedBy = "cmde")
	public List<LigneCommande> lignesParCommande;
	//Liaison à venir avec la table Exercice
	private String codeExercice;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(String numCommande, Date dateCommande, String description, int delaiLivraison, Fournisseur frs,
			String codeExercice) {
		super();
		this.numCommande = numCommande;
		this.dateCommande = dateCommande;
		this.description = description;
		this.delaiLivraison = delaiLivraison;
		this.frs = frs;
		this.codeExercice = codeExercice;
	}

	public String getNumCommande() {
		return numCommande;
	}

	public void setNumCommande(String numCommande) {
		this.numCommande = numCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
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

	public Fournisseur getFrs() {
		return frs;
	}

	public void setFrs(Fournisseur frs) {
		this.frs = frs;
	}

	public String getCodeExercice() {
		return codeExercice;
	}

	public void setCodeExercice(String codeExercice) {
		this.codeExercice = codeExercice;
	}
	
	
}
