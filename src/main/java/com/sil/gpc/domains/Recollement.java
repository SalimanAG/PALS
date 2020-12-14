package com.sil.gpc.domains;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Recollement {

	@Id
	private String numRecollement;
	private String descriptionRecollement;
	private Date dateRecollement;
	private Long numMagasinier;
	private String codeExercice;
	
	public Recollement() {
		super();
	}

	public Recollement(String numRecollement, String descriptionRecollement, Date dateRecollement, Long numMagasinier,
			String codeExercice) {
		super();
		this.numRecollement = numRecollement;
		this.descriptionRecollement = descriptionRecollement;
		this.dateRecollement = dateRecollement;
		this.numMagasinier = numMagasinier;
		this.codeExercice = codeExercice;
	}

	public String getNumRecollement() {
		return numRecollement;
	}

	public void setNumRecollement(String numRecollement) {
		this.numRecollement = numRecollement;
	}

	public String getDescriptionRecollement() {
		return descriptionRecollement;
	}

	public void setDescriptionRecollement(String descriptionRecollement) {
		this.descriptionRecollement = descriptionRecollement;
	}

	public Date getDateRecollement() {
		return dateRecollement;
	}

	public void setDateRecollement(Date dateRecollement) {
		this.dateRecollement = dateRecollement;
	}

	public Long getNumMagasinier() {
		return numMagasinier;
	}

	public void setNumMagasinier(Long numMagasinier) {
		this.numMagasinier = numMagasinier;
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
		result = prime * result + ((dateRecollement == null) ? 0 : dateRecollement.hashCode());
		result = prime * result + ((descriptionRecollement == null) ? 0 : descriptionRecollement.hashCode());
		result = prime * result + ((numMagasinier == null) ? 0 : numMagasinier.hashCode());
		result = prime * result + ((numRecollement == null) ? 0 : numRecollement.hashCode());
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
		Recollement other = (Recollement) obj;
		if (codeExercice == null) {
			if (other.codeExercice != null)
				return false;
		} else if (!codeExercice.equals(other.codeExercice))
			return false;
		if (dateRecollement == null) {
			if (other.dateRecollement != null)
				return false;
		} else if (!dateRecollement.equals(other.dateRecollement))
			return false;
		if (descriptionRecollement == null) {
			if (other.descriptionRecollement != null)
				return false;
		} else if (!descriptionRecollement.equals(other.descriptionRecollement))
			return false;
		if (numMagasinier == null) {
			if (other.numMagasinier != null)
				return false;
		} else if (!numMagasinier.equals(other.numMagasinier))
			return false;
		if (numRecollement == null) {
			if (other.numRecollement != null)
				return false;
		} else if (!numRecollement.equals(other.numRecollement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Recollement [numRecollement=" + numRecollement + ", descriptionRecollement=" + descriptionRecollement
				+ ", dateRecollement=" + dateRecollement + ", numMagasinier=" + numMagasinier + ", codeExercice="
				+ codeExercice + "]";
	}
	
}
