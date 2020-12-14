package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Commune {

	@Id
	private String codeCommune;
	private String nomCommune;
	private String numTelMairie;
	private String adresseMairie;
	private String codeDepartement;
	public Commune() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commune(String codeCommune, String nomCommune, String numTelMairie, String adresseMairie,
			String codeDepartement) {
		super();
		this.codeCommune = codeCommune;
		this.nomCommune = nomCommune;
		this.numTelMairie = numTelMairie;
		this.adresseMairie = adresseMairie;
		this.codeDepartement = codeDepartement;
	}
	public String getCodeCommune() {
		return codeCommune;
	}
	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}
	public String getNomCommune() {
		return nomCommune;
	}
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}
	public String getNumTelMairie() {
		return numTelMairie;
	}
	public void setNumTelMairie(String numTelMairie) {
		this.numTelMairie = numTelMairie;
	}
	public String getAdresseMairie() {
		return adresseMairie;
	}
	public void setAdresseMairie(String adresseMairie) {
		this.adresseMairie = adresseMairie;
	}
	public String getCodeDepartement() {
		return codeDepartement;
	}
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresseMairie == null) ? 0 : adresseMairie.hashCode());
		result = prime * result + ((codeCommune == null) ? 0 : codeCommune.hashCode());
		result = prime * result + ((codeDepartement == null) ? 0 : codeDepartement.hashCode());
		result = prime * result + ((nomCommune == null) ? 0 : nomCommune.hashCode());
		result = prime * result + ((numTelMairie == null) ? 0 : numTelMairie.hashCode());
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
		Commune other = (Commune) obj;
		if (adresseMairie == null) {
			if (other.adresseMairie != null)
				return false;
		} else if (!adresseMairie.equals(other.adresseMairie))
			return false;
		if (codeCommune == null) {
			if (other.codeCommune != null)
				return false;
		} else if (!codeCommune.equals(other.codeCommune))
			return false;
		if (codeDepartement == null) {
			if (other.codeDepartement != null)
				return false;
		} else if (!codeDepartement.equals(other.codeDepartement))
			return false;
		if (nomCommune == null) {
			if (other.nomCommune != null)
				return false;
		} else if (!nomCommune.equals(other.nomCommune))
			return false;
		if (numTelMairie == null) {
			if (other.numTelMairie != null)
				return false;
		} else if (!numTelMairie.equals(other.numTelMairie))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Commune [codeCommune=" + codeCommune + ", nomCommune=" + nomCommune + ", numTelMairie=" + numTelMairie
				+ ", adresseMairie=" + adresseMairie + ", codeDepartement=" + codeDepartement + "]";
	}
	
}
