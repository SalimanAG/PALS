package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LignePlacement {

	@Id
	private String codeArticle;
	private String numPlacement;
	private Long quantiteLignePlacement;
	private Long PULignePlacement;
	
	public LignePlacement() {
		super();
	}

	public LignePlacement(String codeArticle, String numPlacement, Long quantiteLignePlacement, Long pULignePlacement) {
		super();
		this.codeArticle = codeArticle;
		this.numPlacement = numPlacement;
		this.quantiteLignePlacement = quantiteLignePlacement;
		PULignePlacement = pULignePlacement;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getNumPlacement() {
		return numPlacement;
	}

	public void setNumPlacement(String numPlacement) {
		this.numPlacement = numPlacement;
	}

	public Long getQuantiteLignePlacement() {
		return quantiteLignePlacement;
	}

	public void setQuantiteLignePlacement(Long quantiteLignePlacement) {
		this.quantiteLignePlacement = quantiteLignePlacement;
	}

	public Long getPULignePlacement() {
		return PULignePlacement;
	}

	public void setPULignePlacement(Long pULignePlacement) {
		PULignePlacement = pULignePlacement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PULignePlacement == null) ? 0 : PULignePlacement.hashCode());
		result = prime * result + ((codeArticle == null) ? 0 : codeArticle.hashCode());
		result = prime * result + ((numPlacement == null) ? 0 : numPlacement.hashCode());
		result = prime * result + ((quantiteLignePlacement == null) ? 0 : quantiteLignePlacement.hashCode());
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
		LignePlacement other = (LignePlacement) obj;
		if (PULignePlacement == null) {
			if (other.PULignePlacement != null)
				return false;
		} else if (!PULignePlacement.equals(other.PULignePlacement))
			return false;
		if (codeArticle == null) {
			if (other.codeArticle != null)
				return false;
		} else if (!codeArticle.equals(other.codeArticle))
			return false;
		if (numPlacement == null) {
			if (other.numPlacement != null)
				return false;
		} else if (!numPlacement.equals(other.numPlacement))
			return false;
		if (quantiteLignePlacement == null) {
			if (other.quantiteLignePlacement != null)
				return false;
		} else if (!quantiteLignePlacement.equals(other.quantiteLignePlacement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LignePlacement [codeArticle=" + codeArticle + ", numPlacement=" + numPlacement
				+ ", quantiteLignePlacement=" + quantiteLignePlacement + ", PULignePlacement=" + PULignePlacement + "]";
	}
	
}
