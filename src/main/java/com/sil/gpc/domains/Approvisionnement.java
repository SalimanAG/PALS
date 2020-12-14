package com.sil.gpc.domains;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Approvisionnement {

	private String numAppro;
	private String descriptionAppro;
	private Date dateAppro;
	private String codeExercice;
	
	public Approvisionnement() {
		super();
	}

	public String getNumAppro() {
		return numAppro;
	}

	public void setNumAppro(String numAppro) {
		this.numAppro = numAppro;
	}

	public String getDescriptionAppro() {
		return descriptionAppro;
	}

	public void setDescriptionAppro(String descriptionAppro) {
		this.descriptionAppro = descriptionAppro;
	}

	public Date getDateAppro() {
		return dateAppro;
	}

	public void setDateAppro(Date dateAppro) {
		this.dateAppro = dateAppro;
	}

	public String getCodeExercice() {
		return codeExercice;
	}

	public void setCodeExercice(String codeExercice) {
		this.codeExercice = codeExercice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeExercice == null) ? 0 : codeExercice.hashCode());
		result = prime * result + ((dateAppro == null) ? 0 : dateAppro.hashCode());
		result = prime * result + ((descriptionAppro == null) ? 0 : descriptionAppro.hashCode());
		result = prime * result + ((numAppro == null) ? 0 : numAppro.hashCode());
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
		Approvisionnement other = (Approvisionnement) obj;
		if (codeExercice == null) {
			if (other.codeExercice != null)
				return false;
		} else if (!codeExercice.equals(other.codeExercice))
			return false;
		if (dateAppro == null) {
			if (other.dateAppro != null)
				return false;
		} else if (!dateAppro.equals(other.dateAppro))
			return false;
		if (descriptionAppro == null) {
			if (other.descriptionAppro != null)
				return false;
		} else if (!descriptionAppro.equals(other.descriptionAppro))
			return false;
		if (numAppro == null) {
			if (other.numAppro != null)
				return false;
		} else if (!numAppro.equals(other.numAppro))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Approvisionnement [numAppro=" + numAppro + ", descriptionAppro=" + descriptionAppro + ", dateAppro="
				+ dateAppro + ", codeExercice=" + codeExercice + "]";
	}
	
	
}
