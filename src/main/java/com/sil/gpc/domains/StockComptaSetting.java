package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StockComptaSetting {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numParamCompta;
	private String achat;
	private double tvaAchat;
	private String compteStock;
	private String compteVaStock;
	private double tvaVente;
	private boolean exportable;
	
	//Liaison avec Article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Famille.class)
	@JoinColumn(name = "numFamille", referencedColumnName = "numFamille",nullable = false)
	private Famille famille;
	
	public StockComptaSetting() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockComptaSetting(Long numParamCompta, String achat, double tvaAchat, String compteStock,
			String compteVaStock, double tvaVente, boolean exportable, Famille famille) {
		super();
		this.numParamCompta = numParamCompta;
		this.achat = achat;
		this.tvaAchat = tvaAchat;
		this.compteStock = compteStock;
		this.compteVaStock = compteVaStock;
		this.tvaVente = tvaVente;
		this.exportable = exportable;
		this.famille = famille;
	}

	public Long getNumParamCompta() {
		return numParamCompta;
	}

	public void setNumParamCompta(Long numParamCompta) {
		this.numParamCompta = numParamCompta;
	}

	public String getAchat() {
		return achat;
	}

	public void setAchat(String achat) {
		this.achat = achat;
	}

	public double getTvaAchat() {
		return tvaAchat;
	}

	public void setTvaAchat(double tvaAchat) {
		this.tvaAchat = tvaAchat;
	}

	public String getCompteStock() {
		return compteStock;
	}

	public void setCompteStock(String compteStock) {
		this.compteStock = compteStock;
	}

	public String getCompteVaStock() {
		return compteVaStock;
	}

	public void setCompteVaStock(String compteVaStock) {
		this.compteVaStock = compteVaStock;
	}

	public double getTvaVente() {
		return tvaVente;
	}

	public void setTvaVente(double tvaVente) {
		this.tvaVente = tvaVente;
	}

	public boolean isExportable() {
		return exportable;
	}

	public void setExportable(boolean exportable) {
		this.exportable = exportable;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	@Override
	public String toString() {
		return "StockComptaSetting [numParamCompta=" + numParamCompta + ", achat=" + achat + ", tvaAchat=" + tvaAchat
				+ ", compteStock=" + compteStock + ", compteVaStock=" + compteVaStock + ", tvaVente=" + tvaVente
				+ ", exportable=" + exportable + ", famille=" + famille + "]";
	}

	
	
	
}
