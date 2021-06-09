package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Approvisionnement implements Serializable {

	@Id
	private String numAppro;
	private String descriptionAppro;
	private Date dateAppro;
	@Column()
	private boolean valideAppro;
	private int valeur;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = true)
	private Exercice exercice;
	
	@ManyToOne(targetEntity = Magasin.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "numMagasin", referencedColumnName = "numMagasin")
	private Magasin magasin;
	
	
	public Approvisionnement() {
		super();
	}


	public Approvisionnement(String numAppro, String descriptionAppro, Date dateAppro, boolean valideAppro, int valeur,
			Exercice exercice, Magasin magasin) {
		super();
		this.numAppro = numAppro;
		this.descriptionAppro = descriptionAppro;
		this.dateAppro = dateAppro;
		this.valideAppro = valideAppro;
		this.valeur = valeur;
		this.exercice = exercice;
		this.magasin = magasin;
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
	 * @return the numAppro
	 */
	public String getNumAppro() {
		return numAppro;
	}

	/**
	 * @param numAppro the numAppro to set
	 */
	public void setNumAppro(String numAppro) {
		this.numAppro = numAppro;
	}

	/**
	 * @return the descriptionAppro
	 */
	public String getDescriptionAppro() {
		return descriptionAppro;
	}

	/**
	 * @param descriptionAppro the descriptionAppro to set
	 */
	public void setDescriptionAppro(String descriptionAppro) {
		this.descriptionAppro = descriptionAppro;
	}

	/**
	 * @return the dateAppro
	 */
	public Date getDateAppro() {
		return dateAppro;
	}

	/**
	 * @param dateAppro the dateAppro to set
	 */
	public void setDateAppro(Date dateAppro) {
		this.dateAppro = dateAppro;
	}

	/**
	 * @return the valideAppro
	 */
	public boolean isValideAppro() {
		return valideAppro;
	}

	/**
	 * @param valideAppro the valideAppro to set
	 */
	public void setValideAppro(boolean valideAppro) {
		this.valideAppro = valideAppro;
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
	
	

	public Magasin getMagasin() {
		return magasin;
	}


	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}


	@Override
	public String toString() {
		return "Approvisionnement [numAppro=" + numAppro + ", descriptionAppro=" + descriptionAppro + ", dateAppro="
				+ dateAppro + ", valideAppro=" + valideAppro + ", valeur=" + valeur + ", exercice=" + exercice
				+ ", magasin=" + magasin + "]";
	}



}