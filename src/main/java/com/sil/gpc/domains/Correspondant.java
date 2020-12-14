package com.sil.gpc.domains;

import javax.persistence.Entity;

@Entity
public class Correspondant {

	private String idCorrespondant;
	private boolean imputableCorres;
	private Long numMagasinier;
	private String codeTypeCorres;
	private String idUtilisateur;
	
	public Correspondant() {
		super();
	}

	public Correspondant(String idCorrespondant, boolean imputableCorres, Long numMagasinier, String codeTypeCorres,
			String idUtilisateur) {
		super();
		this.idCorrespondant = idCorrespondant;
		this.imputableCorres = imputableCorres;
		this.numMagasinier = numMagasinier;
		this.codeTypeCorres = codeTypeCorres;
		this.idUtilisateur = idUtilisateur;
	}

	public String getIdCorrespondant() {
		return idCorrespondant;
	}

	public void setIdCorrespondant(String idCorrespondant) {
		this.idCorrespondant = idCorrespondant;
	}

	public boolean isImputableCorres() {
		return imputableCorres;
	}

	public void setImputableCorres(boolean imputableCorres) {
		this.imputableCorres = imputableCorres;
	}

	public Long getNumMagasinier() {
		return numMagasinier;
	}

	public void setNumMagasinier(Long numMagasinier) {
		this.numMagasinier = numMagasinier;
	}

	public String getCodeTypeCorres() {
		return codeTypeCorres;
	}

	public void setCodeTypeCorres(String codeTypeCorres) {
		this.codeTypeCorres = codeTypeCorres;
	}

	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeTypeCorres == null) ? 0 : codeTypeCorres.hashCode());
		result = prime * result + ((idCorrespondant == null) ? 0 : idCorrespondant.hashCode());
		result = prime * result + ((idUtilisateur == null) ? 0 : idUtilisateur.hashCode());
		result = prime * result + (imputableCorres ? 1231 : 1237);
		result = prime * result + ((numMagasinier == null) ? 0 : numMagasinier.hashCode());
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
		Correspondant other = (Correspondant) obj;
		if (codeTypeCorres == null) {
			if (other.codeTypeCorres != null)
				return false;
		} else if (!codeTypeCorres.equals(other.codeTypeCorres))
			return false;
		if (idCorrespondant == null) {
			if (other.idCorrespondant != null)
				return false;
		} else if (!idCorrespondant.equals(other.idCorrespondant))
			return false;
		if (idUtilisateur == null) {
			if (other.idUtilisateur != null)
				return false;
		} else if (!idUtilisateur.equals(other.idUtilisateur))
			return false;
		if (imputableCorres != other.imputableCorres)
			return false;
		if (numMagasinier == null) {
			if (other.numMagasinier != null)
				return false;
		} else if (!numMagasinier.equals(other.numMagasinier))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Correspondant [idCorrespondant=" + idCorrespondant + ", imputableCorres=" + imputableCorres
				+ ", numMagasinier=" + numMagasinier + ", codeTypeCorres=" + codeTypeCorres + ", idUtilisateur="
				+ idUtilisateur + "]";
	}
	
	
}
