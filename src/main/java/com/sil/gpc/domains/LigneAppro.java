package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class LigneAppro implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneAppro;
	private double quantiteLigneAppro;
	private double PULigneAppro;
	private double lastStockQte;

	//Liaison avec Approvisionnement
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Approvisionnement.class)
	@JoinColumn(name = "numAppro", referencedColumnName = "numAppro",nullable = false)
	public Approvisionnement appro;

	//Liaison avec LigneDemmandeAppro
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = LigneDemandeAppro.class)
	@JoinColumn(name = "numidDA", referencedColumnName = "idLigneDA",nullable = false)
	public LigneDemandeAppro ligneDA;	
	
	public LigneAppro() {
		super();
	}


	public LigneAppro(Long quantiteLigneAppro, Long pULigneAppro, LigneDemandeAppro ligneDA) {
		super();
		this.quantiteLigneAppro = quantiteLigneAppro;
		PULigneAppro = pULigneAppro;
		this.ligneDA = ligneDA;
	}


	public Long getIdLigneAppro() {
		return idLigneAppro;
	}

	public void setIdLigneAppro(Long idLigneAppro) {
		this.idLigneAppro = idLigneAppro;
	}

	public double getQuantiteLigneAppro() {
		return quantiteLigneAppro;
	}

	public void setQuantiteLigneAppro(double quantiteLigneAppro) {
		this.quantiteLigneAppro = quantiteLigneAppro;
	}

	public double getPULigneAppro() {
		return PULigneAppro;
	}

	public void setPULigneAppro(double pULigneAppro) {
		PULigneAppro = pULigneAppro;
	}
	

	public Approvisionnement getAppro() {
		return appro;
	}


	public void setAppro(Approvisionnement appro) {
		this.appro = appro;
	}


	public LigneDemandeAppro getLigneDA() {
		return ligneDA;
	}


	public void setLigneDA(LigneDemandeAppro ligneDA) {
		this.ligneDA = ligneDA;
	}


	public double getLastStockQte() {
		return lastStockQte;
	}


	public void setLastStockQte(double lastStockQte) {
		this.lastStockQte = lastStockQte;
	}


	@Override
	public String toString() {
		return "LigneAppro [idLigneAppro=" + idLigneAppro + ", quantiteLigneAppro=" + quantiteLigneAppro
				+ ", PULigneAppro=" + PULigneAppro + ", lastStockQte=" + lastStockQte + ", appro=" + appro
				+ ", ligneDA=" + ligneDA + "]";
	}

	

	
}
