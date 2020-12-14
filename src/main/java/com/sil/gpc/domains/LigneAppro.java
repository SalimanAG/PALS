package com.sil.gpc.domains;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class LigneAppro {

	private String codeArticle;
	private String numAppro;
	private Long quantiteLigneAppro;
	private Long PULigneAppro;
	private String numDebLigneAppro;
	private String numFinLigneAppro;
	
	public LigneAppro() {
		super();
	}

	public LigneAppro(String codeArticle, String numAppro, Long quantiteLigneAppro, Long pULigneAppro,
			String numDebLigneAppro, String numFinLigneAppro) {
		super();
		this.codeArticle = codeArticle;
		this.numAppro = numAppro;
		this.quantiteLigneAppro = quantiteLigneAppro;
		PULigneAppro = pULigneAppro;
		this.numDebLigneAppro = numDebLigneAppro;
		this.numFinLigneAppro = numFinLigneAppro;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getNumAppro() {
		return numAppro;
	}

	public void setNumAppro(String numAppro) {
		this.numAppro = numAppro;
	}

	public Long getQuantiteLigneAppro() {
		return quantiteLigneAppro;
	}

	public void setQuantiteLigneAppro(Long quantiteLigneAppro) {
		this.quantiteLigneAppro = quantiteLigneAppro;
	}

	public Long getPULigneAppro() {
		return PULigneAppro;
	}

	public void setPULigneAppro(Long pULigneAppro) {
		PULigneAppro = pULigneAppro;
	}

	public String getNumDebLigneAppro() {
		return numDebLigneAppro;
	}

	public void setNumDebLigneAppro(String numDebLigneAppro) {
		this.numDebLigneAppro = numDebLigneAppro;
	}

	public String getNumFinLigneAppro() {
		return numFinLigneAppro;
	}

	public void setNumFinLigneAppro(String numFinLigneAppro) {
		this.numFinLigneAppro = numFinLigneAppro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PULigneAppro == null) ? 0 : PULigneAppro.hashCode());
		result = prime * result + ((codeArticle == null) ? 0 : codeArticle.hashCode());
		result = prime * result + ((numAppro == null) ? 0 : numAppro.hashCode());
		result = prime * result + ((numDebLigneAppro == null) ? 0 : numDebLigneAppro.hashCode());
		result = prime * result + ((numFinLigneAppro == null) ? 0 : numFinLigneAppro.hashCode());
		result = prime * result + ((quantiteLigneAppro == null) ? 0 : quantiteLigneAppro.hashCode());
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
		LigneAppro other = (LigneAppro) obj;
		if (PULigneAppro == null) {
			if (other.PULigneAppro != null)
				return false;
		} else if (!PULigneAppro.equals(other.PULigneAppro))
			return false;
		if (codeArticle == null) {
			if (other.codeArticle != null)
				return false;
		} else if (!codeArticle.equals(other.codeArticle))
			return false;
		if (numAppro == null) {
			if (other.numAppro != null)
				return false;
		} else if (!numAppro.equals(other.numAppro))
			return false;
		if (numDebLigneAppro == null) {
			if (other.numDebLigneAppro != null)
				return false;
		} else if (!numDebLigneAppro.equals(other.numDebLigneAppro))
			return false;
		if (numFinLigneAppro == null) {
			if (other.numFinLigneAppro != null)
				return false;
		} else if (!numFinLigneAppro.equals(other.numFinLigneAppro))
			return false;
		if (quantiteLigneAppro == null) {
			if (other.quantiteLigneAppro != null)
				return false;
		} else if (!quantiteLigneAppro.equals(other.quantiteLigneAppro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LigneAppro [codeArticle=" + codeArticle + ", numAppro=" + numAppro + ", quantiteLigneAppro="
				+ quantiteLigneAppro + ", PULigneAppro=" + PULigneAppro + ", numDebLigneAppro=" + numDebLigneAppro
				+ ", numFinLigneAppro=" + numFinLigneAppro + "]";
	}
	
	
}
