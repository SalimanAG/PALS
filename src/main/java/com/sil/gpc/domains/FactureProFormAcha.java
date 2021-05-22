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
	private String idFactureProFormAcha;
	private Timestamp dateFactureProFormAcha;
	private String designationFactureProFormAcha;
	private boolean valideFactureProFormAcha;
	private Timestamp datePriseFactureProFormAcha;
	private Timestamp dateDeplisFactureProFormAcha;
	private String obserFactureProFormAcha;
	
	//Migration de la clé de l'unité vers l'article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Fournisseur.class)
	@JoinColumn(name = "codeFrs", referencedColumnName = "codeFrs",nullable = false)
	public Fournisseur fournisseur;
	
	//Migration de la clé de l'exercice
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice",nullable = true)
	public Exercice exercice;

	public FactureProFormAcha() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FactureProFormAcha(String idFactureProFormAcha, Timestamp dateFactureProFormAcha,
			String designationFactureProFormAcha, boolean valideFactureProFormAcha,
			Timestamp datePriseFactureProFormAcha, Timestamp dateDeplisFactureProFormAcha,
			String obserFactureProFormAcha, Fournisseur fournisseur, Exercice exercice) {
		super();
		this.idFactureProFormAcha = idFactureProFormAcha;
		this.dateFactureProFormAcha = dateFactureProFormAcha;
		this.designationFactureProFormAcha = designationFactureProFormAcha;
		this.valideFactureProFormAcha = valideFactureProFormAcha;
		this.datePriseFactureProFormAcha = datePriseFactureProFormAcha;
		this.dateDeplisFactureProFormAcha = dateDeplisFactureProFormAcha;
		this.obserFactureProFormAcha = obserFactureProFormAcha;
		this.fournisseur = fournisseur;
		this.exercice = exercice;
	}

	public String getIdFactureProFormAcha() {
		return idFactureProFormAcha;
	}

	public void setIdFactureProFormAcha(String idFactureProFormAcha) {
		this.idFactureProFormAcha = idFactureProFormAcha;
	}

	public Timestamp getDateFactureProFormAcha() {
		return dateFactureProFormAcha;
	}

	public void setDateFactureProFormAcha(Timestamp dateFactureProFormAcha) {
		this.dateFactureProFormAcha = dateFactureProFormAcha;
	}

	public String getDesignationFactureProFormAcha() {
		return designationFactureProFormAcha;
	}

	public void setDesignationFactureProFormAcha(String designationFactureProFormAcha) {
		this.designationFactureProFormAcha = designationFactureProFormAcha;
	}

	public boolean isValideFactureProFormAcha() {
		return valideFactureProFormAcha;
	}

	public void setValideFactureProFormAcha(boolean valideFactureProFormAcha) {
		this.valideFactureProFormAcha = valideFactureProFormAcha;
	}

	public Timestamp getDatePriseFactureProFormAcha() {
		return datePriseFactureProFormAcha;
	}

	public void setDatePriseFactureProFormAcha(Timestamp datePriseFactureProFormAcha) {
		this.datePriseFactureProFormAcha = datePriseFactureProFormAcha;
	}

	public Timestamp getDateDeplisFactureProFormAcha() {
		return dateDeplisFactureProFormAcha;
	}

	public void setDateDeplisFactureProFormAcha(Timestamp dateDeplisFactureProFormAcha) {
		this.dateDeplisFactureProFormAcha = dateDeplisFactureProFormAcha;
	}

	public String getObserFactureProFormAcha() {
		return obserFactureProFormAcha;
	}

	public void setObserFactureProFormAcha(String obserFactureProFormAcha) {
		this.obserFactureProFormAcha = obserFactureProFormAcha;
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

	@Override
	public String toString() {
		return "FactureProFormAcha [idFactureProFormAcha=" + idFactureProFormAcha + ", dateFactureProFormAcha="
				+ dateFactureProFormAcha + ", designationFactureProFormAcha=" + designationFactureProFormAcha
				+ ", valideFactureProFormAcha=" + valideFactureProFormAcha + ", datePriseFactureProFormAcha="
				+ datePriseFactureProFormAcha + ", dateDeplisFactureProFormAcha=" + dateDeplisFactureProFormAcha
				+ ", obserFactureProFormAcha=" + obserFactureProFormAcha + ", fournisseur=" + fournisseur
				+ ", exercice=" + exercice + "]";
	}
	
	
	
	
}
