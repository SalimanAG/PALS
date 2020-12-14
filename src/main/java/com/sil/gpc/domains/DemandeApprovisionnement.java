package com.sil.gpc.domains;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DemandeApprovisionnement {

	@Id
	private String numDA;
	private Date date;
	private String codeExercice;
	
	public DemandeApprovisionnement() {
		super();
	}

	public DemandeApprovisionnement(String numDA, Date date, String codeExercice) {
		super();
		this.numDA = numDA;
		this.date = date;
		this.codeExercice = codeExercice;
	}

	public String getNumDA() {
		return numDA;
	}

	public void setNumDA(String numDA) {
		this.numDA = numDA;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((numDA == null) ? 0 : numDA.hashCode());
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
		DemandeApprovisionnement other = (DemandeApprovisionnement) obj;
		if (codeExercice == null) {
			if (other.codeExercice != null)
				return false;
		} else if (!codeExercice.equals(other.codeExercice))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (numDA == null) {
			if (other.numDA != null)
				return false;
		} else if (!numDA.equals(other.numDA))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DemandeApprovisionnement [numDA=" + numDA + ", date=" + date + ", codeExercice=" + codeExercice + "]";
	}
	
}
