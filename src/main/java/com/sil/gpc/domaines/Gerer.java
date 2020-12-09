package com.sil.gpc.domaines;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Gerer {

	private Long numMagasinier;
	private String codeMagasin;
	private Date dateDebGerer;
	private Date dateFinGerer;
	
	public Gerer() {
		super();
	}

	public Gerer(Long numMagasinier, String codeMagasin, Date dateDebGerer, Date dateFinGerer) {
		super();
		this.numMagasinier = numMagasinier;
		this.codeMagasin = codeMagasin;
		this.dateDebGerer = dateDebGerer;
		this.dateFinGerer = dateFinGerer;
	}

	public Long getNumMagasinier() {
		return numMagasinier;
	}

	public void setNumMagasinier(Long numMagasinier) {
		this.numMagasinier = numMagasinier;
	}

	public String getCodeMagasin() {
		return codeMagasin;
	}

	public void setCodeMagasin(String codeMagasin) {
		this.codeMagasin = codeMagasin;
	}

	public Date getDateDebGerer() {
		return dateDebGerer;
	}

	public void setDateDebGerer(Date dateDebGerer) {
		this.dateDebGerer = dateDebGerer;
	}

	public Date getDateFinGerer() {
		return dateFinGerer;
	}

	public void setDateFinGerer(Date dateFinGerer) {
		this.dateFinGerer = dateFinGerer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeMagasin == null) ? 0 : codeMagasin.hashCode());
		result = prime * result + ((dateDebGerer == null) ? 0 : dateDebGerer.hashCode());
		result = prime * result + ((dateFinGerer == null) ? 0 : dateFinGerer.hashCode());
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
		Gerer other = (Gerer) obj;
		if (codeMagasin == null) {
			if (other.codeMagasin != null)
				return false;
		} else if (!codeMagasin.equals(other.codeMagasin))
			return false;
		if (dateDebGerer == null) {
			if (other.dateDebGerer != null)
				return false;
		} else if (!dateDebGerer.equals(other.dateDebGerer))
			return false;
		if (dateFinGerer == null) {
			if (other.dateFinGerer != null)
				return false;
		} else if (!dateFinGerer.equals(other.dateFinGerer))
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
		return "Gerer [numMagasinier=" + numMagasinier + ", codeMagasin=" + codeMagasin + ", dateDebGerer="
				+ dateDebGerer + ", dateFinGerer=" + dateFinGerer + "]";
	}
	
	
	
}
