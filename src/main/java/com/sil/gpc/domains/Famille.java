package com.sil.gpc.domains;

import javax.persistence.Entity;

@Entity
public class Famille {

	private String codeFamille;
	private String libFamille;
	
	public Famille() {
		super();
	}

	public Famille(String codeFamille, String libFamille) {
		super();
		this.codeFamille = codeFamille;
		this.libFamille = libFamille;
	}

	public String getCodeFamille() {
		return codeFamille;
	}

	public void setCodeFamille(String codeFamille) {
		this.codeFamille = codeFamille;
	}

	public String getLibFamille() {
		return libFamille;
	}

	public void setLibFamille(String libFamille) {
		this.libFamille = libFamille;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeFamille == null) ? 0 : codeFamille.hashCode());
		result = prime * result + ((libFamille == null) ? 0 : libFamille.hashCode());
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
		Famille other = (Famille) obj;
		if (codeFamille == null) {
			if (other.codeFamille != null)
				return false;
		} else if (!codeFamille.equals(other.codeFamille))
			return false;
		if (libFamille == null) {
			if (other.libFamille != null)
				return false;
		} else if (!libFamille.equals(other.libFamille))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Famille [codeFamille=" + codeFamille + ", libFamille=" + libFamille + "]";
	}
	
	
}
