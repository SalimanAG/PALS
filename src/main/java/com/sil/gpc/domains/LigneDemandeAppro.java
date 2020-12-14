package com.sil.gpc.domains;

import javax.persistence.Entity;

@Entity
public class LigneDemandeAppro {

	private String codeArticle;
	private String numDA;
	private Long quantiteDemandee;
	
	public LigneDemandeAppro() {
		super();
	}

	public LigneDemandeAppro(String codeArticle, String numDA, Long quantiteDemandee) {
		super();
		this.codeArticle = codeArticle;
		this.numDA = numDA;
		this.quantiteDemandee = quantiteDemandee;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getNumDA() {
		return numDA;
	}

	public void setNumDA(String numDA) {
		this.numDA = numDA;
	}

	public Long getQuantiteDemandee() {
		return quantiteDemandee;
	}

	public void setQuantiteDemandee(Long quantiteDemandee) {
		this.quantiteDemandee = quantiteDemandee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeArticle == null) ? 0 : codeArticle.hashCode());
		result = prime * result + ((numDA == null) ? 0 : numDA.hashCode());
		result = prime * result + ((quantiteDemandee == null) ? 0 : quantiteDemandee.hashCode());
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
		LigneDemandeAppro other = (LigneDemandeAppro) obj;
		if (codeArticle == null) {
			if (other.codeArticle != null)
				return false;
		} else if (!codeArticle.equals(other.codeArticle))
			return false;
		if (numDA == null) {
			if (other.numDA != null)
				return false;
		} else if (!numDA.equals(other.numDA))
			return false;
		if (quantiteDemandee == null) {
			if (other.quantiteDemandee != null)
				return false;
		} else if (!quantiteDemandee.equals(other.quantiteDemandee))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LigneDemandeAppro [codeArticle=" + codeArticle + ", numDA=" + numDA + ", quantiteDemandee="
				+ quantiteDemandee + "]";
	}
	
	
}
