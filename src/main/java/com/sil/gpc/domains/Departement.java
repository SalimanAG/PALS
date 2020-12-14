package com.sil.gpc.domains;

import javax.persistence.Entity;

@Entity
public class Departement {

	private String codeDepartement;
	private String nomDepartement;
	private String codePays;
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departement(String codeDepartement, String nomDepartement, String codePays) {
		super();
		this.codeDepartement = codeDepartement;
		this.nomDepartement = nomDepartement;
		this.codePays = codePays;
	}
	public String getCodeDepartement() {
		return codeDepartement;
	}
	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}
	public String getNomDepartement() {
		return nomDepartement;
	}
	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}
	public String getCodePays() {
		return codePays;
	}
	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeDepartement == null) ? 0 : codeDepartement.hashCode());
		result = prime * result + ((codePays == null) ? 0 : codePays.hashCode());
		result = prime * result + ((nomDepartement == null) ? 0 : nomDepartement.hashCode());
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
		Departement other = (Departement) obj;
		if (codeDepartement == null) {
			if (other.codeDepartement != null)
				return false;
		} else if (!codeDepartement.equals(other.codeDepartement))
			return false;
		if (codePays == null) {
			if (other.codePays != null)
				return false;
		} else if (!codePays.equals(other.codePays))
			return false;
		if (nomDepartement == null) {
			if (other.nomDepartement != null)
				return false;
		} else if (!nomDepartement.equals(other.nomDepartement))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Departement [codeDepartement=" + codeDepartement + ", nomDepartement=" + nomDepartement + ", codePays="
				+ codePays + "]";
	}
	
	
}
