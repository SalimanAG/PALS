package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity(name = "Commande")
public class Commande implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)//*******************************Pourquoi ça ?
	@Column(name = "numCommande", length = 8, updatable = false)
	private String numCommande;
	private Date dateCommande;
	private String description;
	private int delaiLivraison;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL, targetEntity =Fournisseur.class)
	private Fournisseur frs;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = LigneCommande.class,fetch = FetchType.EAGER,mappedBy = "numCommande")
	public List<LigneCommande> lignesParCommande;
	
	//Liaison à venir avec la table Exercice
	@ManyToOne(cascade = CascadeType.DETACH,fetch = FetchType.LAZY,targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = false)
	private Exercice exercice;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(String numCommande, Date dateCommande, String description, int delaiLivraison, Fournisseur frs,
			Exercice exercice) {
		super();
		this.numCommande = numCommande;
		this.dateCommande = dateCommande;
		this.description = description;
		this.delaiLivraison = delaiLivraison;
		this.frs = frs;
		this.exercice = exercice;
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

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	public List<LigneCommande> getLignesParCommande() {
		return lignesParCommande;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
}
