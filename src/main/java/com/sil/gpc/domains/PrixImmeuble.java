package com.sil.gpc.domains;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class PrixImmeuble {

	private Long idPrixIm;
	private Date dateDebPrixIm;
	private Date dateFinPrixIm;
	private Long prixIm;
	private String codeIm;
	
	public PrixImmeuble() {
		super();
	}

	public PrixImmeuble(Date dateDebPrixIm, Date dateFinPrixIm, Long prixIm, String codeIm) {
		super();
		this.dateDebPrixIm = dateDebPrixIm;
		this.dateFinPrixIm = dateFinPrixIm;
		this.prixIm = prixIm;
		this.codeIm = codeIm;
	}

	public Long getIdPrixIm() {
		return idPrixIm;
	}

	public void setIdPrixIm(Long idPrixIm) {
		this.idPrixIm = idPrixIm;
	}

	public Date getDateDebPrixIm() {
		return dateDebPrixIm;
	}

	public void setDateDebPrixIm(Date dateDebPrixIm) {
		this.dateDebPrixIm = dateDebPrixIm;
	}

	public Date getDateFinPrixIm() {
		return dateFinPrixIm;
	}

	public void setDateFinPrixIm(Date dateFinPrixIm) {
		this.dateFinPrixIm = dateFinPrixIm;
	}

	public Long getPrixIm() {
		return prixIm;
	}

	public void setPrixIm(Long prixIm) {
		this.prixIm = prixIm;
	}

	public String getCodeIm() {
		return codeIm;
	}

	public void setCodeIm(String codeIm) {
		this.codeIm = codeIm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeIm == null) ? 0 : codeIm.hashCode());
		result = prime * result + ((dateDebPrixIm == null) ? 0 : dateDebPrixIm.hashCode());
		result = prime * result + ((dateFinPrixIm == null) ? 0 : dateFinPrixIm.hashCode());
		result = prime * result + ((idPrixIm == null) ? 0 : idPrixIm.hashCode());
		result = prime * result + ((prixIm == null) ? 0 : prixIm.hashCode());
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
		PrixImmeuble other = (PrixImmeuble) obj;
		if (codeIm == null) {
			if (other.codeIm != null)
				return false;
		} else if (!codeIm.equals(other.codeIm))
			return false;
		if (dateDebPrixIm == null) {
			if (other.dateDebPrixIm != null)
				return false;
		} else if (!dateDebPrixIm.equals(other.dateDebPrixIm))
			return false;
		if (dateFinPrixIm == null) {
			if (other.dateFinPrixIm != null)
				return false;
		} else if (!dateFinPrixIm.equals(other.dateFinPrixIm))
			return false;
		if (idPrixIm == null) {
			if (other.idPrixIm != null)
				return false;
		} else if (!idPrixIm.equals(other.idPrixIm))
			return false;
		if (prixIm == null) {
			if (other.prixIm != null)
				return false;
		} else if (!prixIm.equals(other.prixIm))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PrixImmeuble [idPrixIm=" + idPrixIm + ", dateDebPrixIm=" + dateDebPrixIm + ", dateFinPrixIm="
				+ dateFinPrixIm + ", prixIm=" + prixIm + ", codeIm=" + codeIm + "]";
	}
	
	
}
