package com.sil.gpc.domains;

import javax.persistence.Entity;

@Entity
public class Quartier {

	private String codeQuatier;
	private String nomQuartier;
	private String numTelQuartier;
	private String adresseQuartier;
	private String codeArrondi;
	
	public Quartier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quartier(String codeQuatier, String nomQuartier, String numTelQuartier, String adresseQuartier,
			String codeArrondi) {
		super();
		this.codeQuatier = codeQuatier;
		this.nomQuartier = nomQuartier;
		this.numTelQuartier = numTelQuartier;
		this.adresseQuartier = adresseQuartier;
		this.codeArrondi = codeArrondi;
	}
	public String getCodeQuatier() {
		return codeQuatier;
	}
	public void setCodeQuatier(String codeQuatier) {
		this.codeQuatier = codeQuatier;
	}
	public String getNomQuartier() {
		return nomQuartier;
	}
	public void setNomQuartier(String nomQuartier) {
		this.nomQuartier = nomQuartier;
	}
	public String getNumTelQuartier() {
		return numTelQuartier;
	}
	public void setNumTelQuartier(String numTelQuartier) {
		this.numTelQuartier = numTelQuartier;
	}
	public String getAdresseQuartier() {
		return adresseQuartier;
	}
	public void setAdresseQuartier(String adresseQuartier) {
		this.adresseQuartier = adresseQuartier;
	}
	public String getCodeArrondi() {
		return codeArrondi;
	}
	public void setCodeArrondi(String codeArrondi) {
		this.codeArrondi = codeArrondi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresseQuartier == null) ? 0 : adresseQuartier.hashCode());
		result = prime * result + ((codeArrondi == null) ? 0 : codeArrondi.hashCode());
		result = prime * result + ((codeQuatier == null) ? 0 : codeQuatier.hashCode());
		result = prime * result + ((nomQuartier == null) ? 0 : nomQuartier.hashCode());
		result = prime * result + ((numTelQuartier == null) ? 0 : numTelQuartier.hashCode());
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
		Quartier other = (Quartier) obj;
		if (adresseQuartier == null) {
			if (other.adresseQuartier != null)
				return false;
		} else if (!adresseQuartier.equals(other.adresseQuartier))
			return false;
		if (codeArrondi == null) {
			if (other.codeArrondi != null)
				return false;
		} else if (!codeArrondi.equals(other.codeArrondi))
			return false;
		if (codeQuatier == null) {
			if (other.codeQuatier != null)
				return false;
		} else if (!codeQuatier.equals(other.codeQuatier))
			return false;
		if (nomQuartier == null) {
			if (other.nomQuartier != null)
				return false;
		} else if (!nomQuartier.equals(other.nomQuartier))
			return false;
		if (numTelQuartier == null) {
			if (other.numTelQuartier != null)
				return false;
		} else if (!numTelQuartier.equals(other.numTelQuartier))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Quartier [codeQuatier=" + codeQuatier + ", nomQuartier=" + nomQuartier + ", numTelQuartier="
				+ numTelQuartier + ", adresseQuartier=" + adresseQuartier + ", codeArrondi=" + codeArrondi + "]";
	}
	
	
}
