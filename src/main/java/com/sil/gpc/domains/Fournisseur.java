package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity(name = "Fournisseur")
public class Fournisseur implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numFournisseur;
	private String codeFrs;
	private String identiteFrs;
	private String adresseFrs;
	private String raisonSociale;
	private String numIfuFrs;
	private String telFRS;
	private String description;
	private String domaineInterven;
	private String regComFrs;
	private String compteAvanceFrs;
	private String compteFacturationFrs;
	private String compteConsignationFrs;
	private String compteAvoirFrs;
	private boolean agreerFrs;
	private String numAgrementFrs;
	
	//Liaison à la catégorie de Frs
		@ManyToOne(fetch = FetchType.EAGER, targetEntity = CategorieFrs.class)
		@JoinColumn(name = "codeCatFrs", referencedColumnName = "codeCatFrs")
		private CategorieFrs categorieFrs;
	
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Fournisseur(String codeFrs, String identiteFrs, String adresseFrs, String raisonSociale, String numIfuFrs,
			String telFRS, String description, String domaineInterven, String regComFrs, String compteAvanceFrs,
			String compteFacturationFrs, String compteConsignationFrs, String compteAvoirFrs, boolean agreerFrs,
			String numAgrementFrs, CategorieFrs categorieFrs) {
		super();
		this.codeFrs = codeFrs;
		this.identiteFrs = identiteFrs;
		this.adresseFrs = adresseFrs;
		this.raisonSociale = raisonSociale;
		this.numIfuFrs = numIfuFrs;
		this.telFRS = telFRS;
		this.description = description;
		this.domaineInterven = domaineInterven;
		this.regComFrs = regComFrs;
		this.compteAvanceFrs = compteAvanceFrs;
		this.compteFacturationFrs = compteFacturationFrs;
		this.compteConsignationFrs = compteConsignationFrs;
		this.compteAvoirFrs = compteAvoirFrs;
		this.agreerFrs = agreerFrs;
		this.numAgrementFrs = numAgrementFrs;
		this.categorieFrs = categorieFrs;
	}



	public Long getNumFournisseur() {
		return numFournisseur;
	}



	public void setNumFournisseur(Long numFournisseur) {
		this.numFournisseur = numFournisseur;
	}



	public String getCodeFrs() {
		return codeFrs;
	}

	public void setCodeFrs(String codeFrs) {
		this.codeFrs = codeFrs;
	}

	public String getIdentiteFrs() {
		return identiteFrs;
	}

	public void setIdentiteFrs(String identiteFrs) {
		this.identiteFrs = identiteFrs;
	}

	public String getAdresseFrs() {
		return adresseFrs;
	}

	public void setAdresseFrs(String adresseFrs) {
		this.adresseFrs = adresseFrs;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getNumIfuFrs() {
		return numIfuFrs;
	}

	public void setNumIfuFrs(String numIfuFrs) {
		this.numIfuFrs = numIfuFrs;
	}

	public String getTelFRS() {
		return telFRS;
	}

	public void setTelFRS(String telFRS) {
		this.telFRS = telFRS;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public String getDomaineInterven() {
		return domaineInterven;
	}



	public void setDomaineInterven(String domaineInterven) {
		this.domaineInterven = domaineInterven;
	}



	public String getRegComFrs() {
		return regComFrs;
	}



	public void setRegComFrs(String regComFrs) {
		this.regComFrs = regComFrs;
	}



	public String getCompteAvanceFrs() {
		return compteAvanceFrs;
	}



	public void setCompteAvanceFrs(String compteAvanceFrs) {
		this.compteAvanceFrs = compteAvanceFrs;
	}



	public String getCompteFacturationFrs() {
		return compteFacturationFrs;
	}



	public void setCompteFacturationFrs(String compteFacturationFrs) {
		this.compteFacturationFrs = compteFacturationFrs;
	}



	public String getCompteConsignationFrs() {
		return compteConsignationFrs;
	}



	public void setCompteConsignationFrs(String compteConsignationFrs) {
		this.compteConsignationFrs = compteConsignationFrs;
	}



	public String getCompteAvoirFrs() {
		return compteAvoirFrs;
	}



	public void setCompteAvoirFrs(String compteAvoirFrs) {
		this.compteAvoirFrs = compteAvoirFrs;
	}



	public boolean isAgreerFrs() {
		return agreerFrs;
	}



	public void setAgreerFrs(boolean agreerFrs) {
		this.agreerFrs = agreerFrs;
	}



	public String getNumAgrementFrs() {
		return numAgrementFrs;
	}



	public void setNumAgrementFrs(String numAgrementFrs) {
		this.numAgrementFrs = numAgrementFrs;
	}



	public CategorieFrs getCategorieFrs() {
		return categorieFrs;
	}



	public void setCategorieFrs(CategorieFrs categorieFrs) {
		this.categorieFrs = categorieFrs;
	}



	@Override
	public String toString() {
		return "Fournisseur [numFournisseur=" + numFournisseur + ", codeFrs=" + codeFrs + ", identiteFrs=" + identiteFrs
				+ ", adresseFrs=" + adresseFrs + ", raisonSociale=" + raisonSociale + ", numIfuFrs=" + numIfuFrs
				+ ", telFRS=" + telFRS + ", description=" + description + ", domaineInterven=" + domaineInterven
				+ ", regComFrs=" + regComFrs + ", compteAvanceFrs=" + compteAvanceFrs + ", compteFacturationFrs="
				+ compteFacturationFrs + ", compteConsignationFrs=" + compteConsignationFrs + ", compteAvoirFrs="
				+ compteAvoirFrs + ", agreerFrs=" + agreerFrs + ", numAgrementFrs=" + numAgrementFrs + ", categorieFrs="
				+ categorieFrs + "]";
	}




}
