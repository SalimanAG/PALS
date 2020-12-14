package com.sil.gpc.domains;

import javax.persistence.Entity;

@Entity
public class Rp {

	private String idRp;
	private Long numMagasinier;
	private Long idUtilisateur;
	
	public Rp() {
		super();
	}

	public Rp(String idRp, Long numMagasinier, Long idUtilisateur) {
		super();
		this.idRp = idRp;
		this.numMagasinier = numMagasinier;
		this.idUtilisateur = idUtilisateur;
	}

	public String getIdRp() {
		return idRp;
	}

	public void setIdRp(String idRp) {
		this.idRp = idRp;
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
		result = prime * result + ((idRp == null) ? 0 : idRp.hashCode());
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
		Rp other = (Rp) obj;
		if (idRp == null) {
			if (other.idRp != null)
				return false;
		} else if (!idRp.equals(other.idRp))
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
		return "Rp [idRp=" + idRp + ", numMagasinier=" + numMagasinier + ", idUtilisateur=" + idUtilisateur + "]";
	}
	
	
}
