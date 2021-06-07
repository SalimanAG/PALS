package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity(name = "Commande")
public class Commande implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numCommande;
	private Date dateCommande;
	private Date dateRemise;
	private String description;
	private int delaiLivraison;
	private boolean valide;
	private int valeur;
	private boolean liver;
	private boolean reporter;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity =Fournisseur.class)
	private Fournisseur frs;

	//Liaison avec la table Exercice
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = false)
	private Exercice exercice;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Commande(Long numCommande, Date dateCommande, Date dateRemise, String description, int delaiLivraison,
			boolean valide, int valeur, boolean liver, boolean reporter, Fournisseur frs, Exercice exercice) {
		super();
		this.numCommande = numCommande;
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
	}



	/**
	 * @return the valide
	 */
	public boolean isValide() {
		return valide;
	}

	/**
	 * @param valide the valide to set
	 */
	public void setValide(boolean valide) {
		this.valide = valide;
	}

	/**
	 * @return the valeur
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the numCommande
	 */
	public Long getNumCommande() {
		return numCommande;
	}

	/**
	 * @param numCommande the numCommande to set
	 */
	public void setNumCommande(Long numCommande) {
		this.numCommande = numCommande;
	}

	/**
	 * @return the dateCommande
	 */
	public Date getDateCommande() {
		return dateCommande;
	}

	/**
	 * @param dateCommande the dateCommande to set
	 */
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	/**
	 * @return the dateRemise
	 */
	public Date getDateRemise() {
		return dateRemise;
	}

	/**
	 * @param dateRemise the dateRemise to set
	 */
	public void setDateRemise(Date dateRemise) {
		this.dateRemise = dateRemise;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the delaiLivraison
	 */
	public int getDelaiLivraison() {
		return delaiLivraison;
	}

	/**
	 * @param delaiLivraison the delaiLivraison to set
	 */
	public void setDelaiLivraison(int delaiLivraison) {
		this.delaiLivraison = delaiLivraison;
	}

	/**
	 * @return the frs
	 */
	public Fournisseur getFrs() {
		return frs;
	}

	/**
	 * @param frs the frs to set
	 */
	public void setFrs(Fournisseur frs) {
		this.frs = frs;
	}

	/**
	 * @return the exercice
	 */
	public Exercice getExercice() {
		return exercice;
	}

	/**
	 * @param exercice the exercice to set
	 */
	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
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



	@Override
	public String toString() {
		return "Commande [numCommande=" + numCommande + ", dateCommande=" + dateCommande + ", dateRemise=" + dateRemise
				+ ", description=" + description + ", delaiLivraison=" + delaiLivraison + ", valide=" + valide
				+ ", valeur=" + valeur + ", liver=" + liver + ", reporter=" + reporter + ", frs=" + frs + ", exercice="
				+ exercice + "]";
	}

	

	
}