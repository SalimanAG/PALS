package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LigneRecollement {

	@Id
	private String codeArticle;
	private String numRecollement;
	private Long quantiteLigneRecollement;
	private Long PULigneRecollement;
	private String numDebLigneRecollement;
	private String numFinLigneRecollement;
	private String observationLigneRecollement;
	
	public LigneRecollement() {
		super();
	}

	public LigneRecollement(String codeArticle, String numRecollement, Long quantiteLigneRecollement,
			Long pULigneRecollement, String numDebligneRecollement, String numFinLigneRecollement,
			String observationLigneRecollement) {
		super();
		this.codeArticle = codeArticle;
		this.numRecollement = numRecollement;
		this.quantiteLigneRecollement = quantiteLigneRecollement;
		PULigneRecollement = pULigneRecollement;
		this.numDebLigneRecollement = numDebligneRecollement;
		this.numFinLigneRecollement = numFinLigneRecollement;
		this.observationLigneRecollement = observationLigneRecollement;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getNumRecollement() {
		return numRecollement;
	}

	public void setNumRecollement(String numRecollement) {
		this.numRecollement = numRecollement;
	}

	public Long getQuantiteLigneRecollement() {
		return quantiteLigneRecollement;
	}

	public void setQuantiteLigneRecollement(Long quantiteLigneRecollement) {
		this.quantiteLigneRecollement = quantiteLigneRecollement;
	}

	public Long getPULigneRecollement() {
		return PULigneRecollement;
	}

	public void setPULigneRecollement(Long pULigneRecollement) {
		PULigneRecollement = pULigneRecollement;
	}

	public String getNumDebligneRecollement() {
		return numDebLigneRecollement;
	}

	public void setNumDebligneRecollement(String numDebligneRecollement) {
		this.numDebLigneRecollement = numDebligneRecollement;
	}

	public String getNumFinLigneRecollement() {
		return numFinLigneRecollement;
	}

	public void setNumFinLigneRecollement(String numFinLigneRecollement) {
		this.numFinLigneRecollement = numFinLigneRecollement;
	}

	public String getObservationLigneRecollement() {
		return observationLigneRecollement;
	}

	public void setObservationLigneRecollement(String observationLigneRecollement) {
		this.observationLigneRecollement = observationLigneRecollement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PULigneRecollement == null) ? 0 : PULigneRecollement.hashCode());
		result = prime * result + ((codeArticle == null) ? 0 : codeArticle.hashCode());
		result = prime * result + ((numDebLigneRecollement == null) ? 0 : numDebLigneRecollement.hashCode());
		result = prime * result + ((numFinLigneRecollement == null) ? 0 : numFinLigneRecollement.hashCode());
		result = prime * result + ((numRecollement == null) ? 0 : numRecollement.hashCode());
		result = prime * result + ((observationLigneRecollement == null) ? 0 : observationLigneRecollement.hashCode());
		result = prime * result + ((quantiteLigneRecollement == null) ? 0 : quantiteLigneRecollement.hashCode());
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
		LigneRecollement other = (LigneRecollement) obj;
		if (PULigneRecollement == null) {
			if (other.PULigneRecollement != null)
				return false;
		} else if (!PULigneRecollement.equals(other.PULigneRecollement))
			return false;
		if (codeArticle == null) {
			if (other.codeArticle != null)
				return false;
		} else if (!codeArticle.equals(other.codeArticle))
			return false;
		if (numDebLigneRecollement == null) {
			if (other.numDebLigneRecollement != null)
				return false;
		} else if (!numDebLigneRecollement.equals(other.numDebLigneRecollement))
			return false;
		if (numFinLigneRecollement == null) {
			if (other.numFinLigneRecollement != null)
				return false;
		} else if (!numFinLigneRecollement.equals(other.numFinLigneRecollement))
			return false;
		if (numRecollement == null) {
			if (other.numRecollement != null)
				return false;
		} else if (!numRecollement.equals(other.numRecollement))
			return false;
		if (observationLigneRecollement == null) {
			if (other.observationLigneRecollement != null)
				return false;
		} else if (!observationLigneRecollement.equals(other.observationLigneRecollement))
			return false;
		if (quantiteLigneRecollement == null) {
			if (other.quantiteLigneRecollement != null)
				return false;
		} else if (!quantiteLigneRecollement.equals(other.quantiteLigneRecollement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LigneRecollement [codeArticle=" + codeArticle + ", numRecollement=" + numRecollement
				+ ", quantiteLigneRecollement=" + quantiteLigneRecollement + ", PULigneRecollement="
				+ PULigneRecollement + ", numDebligneRecollement=" + numDebLigneRecollement
				+ ", numFinLigneRecollement=" + numFinLigneRecollement + ", observationLigneRecollement="
				+ observationLigneRecollement + "]";
	}
	
}
