package com.sil.gpc.domains;

import javax.persistence.Entity;

@Entity
public class Regisseur {

	private String idRegisseur;
	private Long numMagasinier;
	private Long idUtilisateur;
	
	public Regisseur() {
		super();
	}

	public Regisseur(String idRegisseur, Long numMagasinier, Long idUtilisateur) {
		super();
		this.idRegisseur = idRegisseur;
		this.numMagasinier = numMagasinier;
		this.idUtilisateur = idUtilisateur;
	}

	public String getIdRegisseur() {
		return idRegisseur;
	}

	public void setIdRegisseur(String idRegisseur) {
		this.idRegisseur = idRegisseur;
	}

	public Long getNumMagasinier() {
		return numMagasinier;
	}

	public void setNumMagasinier(Long numMagasinier) {
		this.numMagasinier = numMagasinier;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRegisseur == null) ? 0 : idRegisseur.hashCode());
		result = prime * result + ((idUtilisateur == null) ? 0 : idUtilisateur.hashCode());
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
		Regisseur other = (Regisseur) obj;
		if (idRegisseur == null) {
			if (other.idRegisseur != null)
				return false;
		} else if (!idRegisseur.equals(other.idRegisseur))
			return false;
		if (idUtilisateur == null) {
			if (other.idUtilisateur != null)
				return false;
		} else if (!idUtilisateur.equals(other.idUtilisateur))
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
		return "Regisseur [idRegisseur=" + idRegisseur + ", numMagasinier=" + numMagasinier + ", idUtilisateur="
				+ idUtilisateur + "]";
	}
	
	
	
}
