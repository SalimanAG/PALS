package com.sil.gpc.domains;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PointVente {

	@Id
	private String numpointVente;
	private Date datePointVente;
	private String codeExercice;
	private String idCorrespondant;
	
	public PointVente() {
		super();
	}

	public PointVente(String numpointVente, Date datePointVente, String codeExercice, String idCorrespondant) {
		super();
		this.numpointVente = numpointVente;
		this.datePointVente = datePointVente;
		this.codeExercice = codeExercice;
		this.idCorrespondant = idCorrespondant;
	}

	public String getNumpointVente() {
		return numpointVente;
	}

	public void setNumpointVente(String numpointVente) {
		this.numpointVente = numpointVente;
	}

	public Date getDatePointVente() {
		return datePointVente;
	}

	public void setDatePointVente(Date datePointVente) {
		this.datePointVente = datePointVente;
	}

	public String getCodeExercice() {
		return codeExercice;
	}

	public void setCodeExercice(String codeExercice) {
		this.codeExercice = codeExercice;
	}

	public String getIdCorrespondant() {
		return idCorrespondant;
	}

	public void setIdCorrespondant(String idCorrespondant) {
		this.idCorrespondant = idCorrespondant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeExercice == null) ? 0 : codeExercice.hashCode());
		result = prime * result + ((datePointVente == null) ? 0 : datePointVente.hashCode());
		result = prime * result + ((idCorrespondant == null) ? 0 : idCorrespondant.hashCode());
		result = prime * result + ((numpointVente == null) ? 0 : numpointVente.hashCode());
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
		PointVente other = (PointVente) obj;
		if (codeExercice == null) {
			if (other.codeExercice != null)
				return false;
		} else if (!codeExercice.equals(other.codeExercice))
			return false;
		if (datePointVente == null) {
			if (other.datePointVente != null)
				return false;
		} else if (!datePointVente.equals(other.datePointVente))
			return false;
		if (idCorrespondant == null) {
			if (other.idCorrespondant != null)
				return false;
		} else if (!idCorrespondant.equals(other.idCorrespondant))
			return false;
		if (numpointVente == null) {
			if (other.numpointVente != null)
				return false;
		} else if (!numpointVente.equals(other.numpointVente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PointVente [numpointVente=" + numpointVente + ", datePointVente=" + datePointVente + ", codeExercice="
				+ codeExercice + ", idCorrespondant=" + idCorrespondant + "]";
	}
	
	
}
