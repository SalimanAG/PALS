package com.sil.gpc.domains;

import javax.persistence.Entity;

@Entity
public class LigneReception {

	private String codeArticle;
	private String numReception;
	private Long quantiteLigneReception;
	private Long PULigneReception;
	private String observationLigneCommande;
	private String numSeriDebLigneCommande;
	private String numSeriFinLigneCommande;
	
	public LigneReception() {
		super();
	}

	public LigneReception(String codeArticle, String numReception, Long quantiteLigneReception, Long pULigneReception,
			String observationLigneCommande, String numSeriDebLigneCommande, String numSeriFinLigneCommande) {
		super();
		this.codeArticle = codeArticle;
		this.numReception = numReception;
		this.quantiteLigneReception = quantiteLigneReception;
		PULigneReception = pULigneReception;
		this.observationLigneCommande = observationLigneCommande;
		this.numSeriDebLigneCommande = numSeriDebLigneCommande;
		this.numSeriFinLigneCommande = numSeriFinLigneCommande;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getNumReception() {
		return numReception;
	}

	public void setNumReception(String numReception) {
		this.numReception = numReception;
	}

	public Long getQuantiteLigneReception() {
		return quantiteLigneReception;
	}

	public void setQuantiteLigneReception(Long quantiteLigneReception) {
		this.quantiteLigneReception = quantiteLigneReception;
	}

	public Long getPULigneReception() {
		return PULigneReception;
	}

	public void setPULigneReception(Long pULigneReception) {
		PULigneReception = pULigneReception;
	}

	public String getObservationLigneCommande() {
		return observationLigneCommande;
	}

	public void setObservationLigneCommande(String observationLigneCommande) {
		this.observationLigneCommande = observationLigneCommande;
	}

	public String getNumSeriDebLigneCommande() {
		return numSeriDebLigneCommande;
	}

	public void setNumSeriDebLigneCommande(String numSeriDebLigneCommande) {
		this.numSeriDebLigneCommande = numSeriDebLigneCommande;
	}

	public String getNumSeriFinLigneCommande() {
		return numSeriFinLigneCommande;
	}

	public void setNumSeriFinLigneCommande(String numSeriFinLigneCommande) {
		this.numSeriFinLigneCommande = numSeriFinLigneCommande;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PULigneReception == null) ? 0 : PULigneReception.hashCode());
		result = prime * result + ((codeArticle == null) ? 0 : codeArticle.hashCode());
		result = prime * result + ((numReception == null) ? 0 : numReception.hashCode());
		result = prime * result + ((numSeriDebLigneCommande == null) ? 0 : numSeriDebLigneCommande.hashCode());
		result = prime * result + ((numSeriFinLigneCommande == null) ? 0 : numSeriFinLigneCommande.hashCode());
		result = prime * result + ((observationLigneCommande == null) ? 0 : observationLigneCommande.hashCode());
		result = prime * result + ((quantiteLigneReception == null) ? 0 : quantiteLigneReception.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneReception other = (LigneReception) obj;
		if (PULigneReception == null) {
			if (other.PULigneReception != null)
				return false;
		} else if (!PULigneReception.equals(other.PULigneReception))
			return false;
		if (codeArticle == null) {
			if (other.codeArticle != null)
				return false;
		} else if (!codeArticle.equals(other.codeArticle))
			return false;
		if (numReception == null) {
			if (other.numReception != null)
				return false;
		} else if (!numReception.equals(other.numReception))
			return false;
		if (numSeriDebLigneCommande == null) {
			if (other.numSeriDebLigneCommande != null)
				return false;
		} else if (!numSeriDebLigneCommande.equals(other.numSeriDebLigneCommande))
			return false;
		if (numSeriFinLigneCommande == null) {
			if (other.numSeriFinLigneCommande != null)
				return false;
		} else if (!numSeriFinLigneCommande.equals(other.numSeriFinLigneCommande))
			return false;
		if (observationLigneCommande == null) {
			if (other.observationLigneCommande != null)
				return false;
		} else if (!observationLigneCommande.equals(other.observationLigneCommande))
			return false;
		if (quantiteLigneReception == null) {
			if (other.quantiteLigneReception != null)
				return false;
		} else if (!quantiteLigneReception.equals(other.quantiteLigneReception))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LigneReception [codeArticle=" + codeArticle + ", numReception=" + numReception
				+ ", quantiteLigneReception=" + quantiteLigneReception + ", PULigneReception=" + PULigneReception
				+ ", observationLigneCommande=" + observationLigneCommande + ", numSeriDebLigneCommande="
				+ numSeriDebLigneCommande + ", numSeriFinLigneCommande=" + numSeriFinLigneCommande + "]";
	}
	
}
