package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Arrondissement {

	@Id
	private String codeArrondi;
	private String nomArrondi;
	private String adresseArrondi;
	private String numTelArrondi;
	private String codeCommune;
	public Arrondissement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Arrondissement(String codeArrondi, String nomArrondi, String adresseArrondi, String numTelArrondi,
			String codeCommune) {
		super();
		this.codeArrondi = codeArrondi;
		this.nomArrondi = nomArrondi;
		this.adresseArrondi = adresseArrondi;
		this.numTelArrondi = numTelArrondi;
		this.codeCommune = codeCommune;
	}
	public String getCodeArrondi() {
		return codeArrondi;
	}
	public void setCodeArrondi(String codeArrondi) {
		this.codeArrondi = codeArrondi;
	}
	public String getNomArrondi() {
		return nomArrondi;
	}
	public void setNomArrondi(String nomArrondi) {
		this.nomArrondi = nomArrondi;
	}
	public String getAdresseArrondi() {
		return adresseArrondi;
	}
	public void setAdresseArrondi(String adresseArrondi) {
		this.adresseArrondi = adresseArrondi;
	}
	public String getNumTelArrondi() {
		return numTelArrondi;
	}
	public void setNumTelArrondi(String numTelArrondi) {
		this.numTelArrondi = numTelArrondi;
	}
	public String getCodeCommune() {
		return codeCommune;
	}
	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresseArrondi == null) ? 0 : adresseArrondi.hashCode());
		result = prime * result + ((codeArrondi == null) ? 0 : codeArrondi.hashCode());
		result = prime * result + ((codeCommune == null) ? 0 : codeCommune.hashCode());
		result = prime * result + ((nomArrondi == null) ? 0 : nomArrondi.hashCode());
		result = prime * result + ((numTelArrondi == null) ? 0 : numTelArrondi.hashCode());
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
		Arrondissement other = (Arrondissement) obj;
		if (adresseArrondi == null) {
			if (other.adresseArrondi != null)
				return false;
		} else if (!adresseArrondi.equals(other.adresseArrondi))
			return false;
		if (codeArrondi == null) {
			if (other.codeArrondi != null)
				return false;
		} else if (!codeArrondi.equals(other.codeArrondi))
			return false;
		if (codeCommune == null) {
			if (other.codeCommune != null)
				return false;
		} else if (!codeCommune.equals(other.codeCommune))
			return false;
		if (nomArrondi == null) {
			if (other.nomArrondi != null)
				return false;
		} else if (!nomArrondi.equals(other.nomArrondi))
			return false;
		if (numTelArrondi == null) {
			if (other.numTelArrondi != null)
				return false;
		} else if (!numTelArrondi.equals(other.numTelArrondi))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Arrondissement [codeArrondi=" + codeArrondi + ", nomArrondi=" + nomArrondi + ", adresseArrondi="
				+ adresseArrondi + ", numTelArrondi=" + numTelArrondi + ", codeCommune=" + codeCommune + "]";
	}
	
}
