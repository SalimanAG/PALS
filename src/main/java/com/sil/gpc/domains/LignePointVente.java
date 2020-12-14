package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LignePointVente {

	@Id
	private String codeArticle;
	private String numPointVente;
	private Long quantiteLignePointVente;
	private Long PULignePointVente;
	private String numDebLignePointVente;
	private String numFinLignePointVente;
	
	public LignePointVente() {
		super();
	}

	public LignePointVente(String codeArticle, String numPointVente, Long quantiteLignePointVente,
			Long pULignePointVente, String numDebLignePointVente, String numFinLignePointVente) {
		super();
		this.codeArticle = codeArticle;
		this.numPointVente = numPointVente;
		this.quantiteLignePointVente = quantiteLignePointVente;
		PULignePointVente = pULignePointVente;
		this.numDebLignePointVente = numDebLignePointVente;
		this.numFinLignePointVente = numFinLignePointVente;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getNumPointVente() {
		return numPointVente;
	}

	public void setNumPointVente(String numPointVente) {
		this.numPointVente = numPointVente;
	}

	public Long getQuantiteLignePointVente() {
		return quantiteLignePointVente;
	}

	public void setQuantiteLignePointVente(Long quantiteLignePointVente) {
		this.quantiteLignePointVente = quantiteLignePointVente;
	}

	public Long getPULignePointVente() {
		return PULignePointVente;
	}

	public void setPULignePointVente(Long pULignePointVente) {
		PULignePointVente = pULignePointVente;
	}

	public String getNumDebLignePointVente() {
		return numDebLignePointVente;
	}

	public void setNumDebLignePointVente(String numDebLignePointVente) {
		this.numDebLignePointVente = numDebLignePointVente;
	}

	public String getNumFinLignePointVente() {
		return numFinLignePointVente;
	}

	public void setNumFinLignePointVente(String numFinLignePointVente) {
		this.numFinLignePointVente = numFinLignePointVente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PULignePointVente == null) ? 0 : PULignePointVente.hashCode());
		result = prime * result + ((codeArticle == null) ? 0 : codeArticle.hashCode());
		result = prime * result + ((numDebLignePointVente == null) ? 0 : numDebLignePointVente.hashCode());
		result = prime * result + ((numFinLignePointVente == null) ? 0 : numFinLignePointVente.hashCode());
		result = prime * result + ((numPointVente == null) ? 0 : numPointVente.hashCode());
		result = prime * result + ((quantiteLignePointVente == null) ? 0 : quantiteLignePointVente.hashCode());
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
		LignePointVente other = (LignePointVente) obj;
		if (PULignePointVente == null) {
			if (other.PULignePointVente != null)
				return false;
		} else if (!PULignePointVente.equals(other.PULignePointVente))
			return false;
		if (codeArticle == null) {
			if (other.codeArticle != null)
				return false;
		} else if (!codeArticle.equals(other.codeArticle))
			return false;
		if (numDebLignePointVente == null) {
			if (other.numDebLignePointVente != null)
				return false;
		} else if (!numDebLignePointVente.equals(other.numDebLignePointVente))
			return false;
		if (numFinLignePointVente == null) {
			if (other.numFinLignePointVente != null)
				return false;
		} else if (!numFinLignePointVente.equals(other.numFinLignePointVente))
			return false;
		if (numPointVente == null) {
			if (other.numPointVente != null)
				return false;
		} else if (!numPointVente.equals(other.numPointVente))
			return false;
		if (quantiteLignePointVente == null) {
			if (other.quantiteLignePointVente != null)
				return false;
		} else if (!quantiteLignePointVente.equals(other.quantiteLignePointVente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LignePointVente [codeArticle=" + codeArticle + ", numPointVente=" + numPointVente
				+ ", quantiteLignePointVente=" + quantiteLignePointVente + ", PULignePointVente=" + PULignePointVente
				+ ", numDebLignePointVente=" + numDebLignePointVente + ", numFinLignePointVente="
				+ numFinLignePointVente + "]";
	}
	
}
