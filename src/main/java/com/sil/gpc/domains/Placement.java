package com.sil.gpc.domains;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Placement {

	@Id
	private String numPlacement;
	private Date datePlacement;
	private String codeExercice;
	
	public Placement() {
		super();
	}

	public Placement(String numPlacement, Date datePlacement, String codeExercice) {
		super();
		this.numPlacement = numPlacement;
		this.datePlacement = datePlacement;
		this.codeExercice = codeExercice;
	}

	public String getNumPlacement() {
		return numPlacement;
	}

	public void setNumPlacement(String numPlacement) {
		this.numPlacement = numPlacement;
	}

	public Date getDatePlacement() {
		return datePlacement;
	}

	public void setDatePlacement(Date datePlacement) {
		this.datePlacement = datePlacement;
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
		result = prime * result + ((datePlacement == null) ? 0 : datePlacement.hashCode());
		result = prime * result + ((numPlacement == null) ? 0 : numPlacement.hashCode());
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
		Placement other = (Placement) obj;
		if (codeExercice == null) {
			if (other.codeExercice != null)
				return false;
		} else if (!codeExercice.equals(other.codeExercice))
			return false;
		if (datePlacement == null) {
			if (other.datePlacement != null)
				return false;
		} else if (!datePlacement.equals(other.datePlacement))
			return false;
		if (numPlacement == null) {
			if (other.numPlacement != null)
				return false;
		} else if (!numPlacement.equals(other.numPlacement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Placement [numPlacement=" + numPlacement + ", datePlacement=" + datePlacement + ", codeExercice="
				+ codeExercice + "]";
	}
	
}
