package com.sil.gpc.domaines;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Exercice {

	private String codeExercice;
	private String libExercice;
	private Date dateDebut;
	private Date dateFin;
	private String etatExo;
	private boolean exoSelectionner;
	
	public Exercice() {
		super();
	}

	public Exercice(String codeExercice, String libExercice, Date dateDebut, Date dateFin, String etatExo,
			boolean exoSelectionner) {
		super();
		this.codeExercice = codeExercice;
		this.libExercice = libExercice;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etatExo = etatExo;
		this.exoSelectionner = exoSelectionner;
	}

	public String getCodeExercice() {
		return codeExercice;
	}

	public void setCodeExercice(String codeExercice) {
		this.codeExercice = codeExercice;
	}

	public String getLibExercice() {
		return libExercice;
	}

	public void setLibExercice(String libExercice) {
		this.libExercice = libExercice;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getEtatExo() {
		return etatExo;
	}

	public void setEtatExo(String etatExo) {
		this.etatExo = etatExo;
	}

	public boolean isExoSelectionner() {
		return exoSelectionner;
	}

	public void setExoSelectionner(boolean exoSelectionner) {
		this.exoSelectionner = exoSelectionner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeExercice == null) ? 0 : codeExercice.hashCode());
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((etatExo == null) ? 0 : etatExo.hashCode());
		result = prime * result + (exoSelectionner ? 1231 : 1237);
		result = prime * result + ((libExercice == null) ? 0 : libExercice.hashCode());
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
		Exercice other = (Exercice) obj;
		if (codeExercice == null) {
			if (other.codeExercice != null)
				return false;
		} else if (!codeExercice.equals(other.codeExercice))
			return false;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (etatExo == null) {
			if (other.etatExo != null)
				return false;
		} else if (!etatExo.equals(other.etatExo))
			return false;
		if (exoSelectionner != other.exoSelectionner)
			return false;
		if (libExercice == null) {
			if (other.libExercice != null)
				return false;
		} else if (!libExercice.equals(other.libExercice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Exercice [codeExercice=" + codeExercice + ", libExercice=" + libExercice + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", etatExo=" + etatExo + ", exoSelectionner=" + exoSelectionner + "]";
	}
	
	
}
