package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlageNumDispo {

	@Id
	private String codePlageDispo;
	private String numDebPlage;
	private String numDebPlageDispo;
	private String numFinPlage;
	private String numFinPlageDispo;
	private String annee;
	private String codeArticle;
	
	public PlageNumDispo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PlageNumDispo(String codePlageDispo, String numDebPlage, String numDebPlageDispo, String numFinPlage,
			String numFinPlageDispo, String annee, String codeArticle) {
		super();
		this.codePlageDispo = codePlageDispo;
		this.numDebPlage = numDebPlage;
		this.numDebPlageDispo = numDebPlageDispo;
		this.numFinPlage = numFinPlage;
		this.numFinPlageDispo = numFinPlageDispo;
		this.annee = annee;
		this.codeArticle = codeArticle;
	}

	public String getCodePlageDispo() {
		return codePlageDispo;
	}

	public void setCodePlageDispo(String codePlageDispo) {
		this.codePlageDispo = codePlageDispo;
	}

	public String getNumDebPlage() {
		return numDebPlage;
	}

	public void setNumDebPlage(String numDebPlage) {
		this.numDebPlage = numDebPlage;
	}

	public String getNumDebPlageDispo() {
		return numDebPlageDispo;
	}

	public void setNumDebPlageDispo(String numDebPlageDispo) {
		this.numDebPlageDispo = numDebPlageDispo;
	}

	public String getNumFinPlage() {
		return numFinPlage;
	}

	public void setNumFinPlage(String numFinPlage) {
		this.numFinPlage = numFinPlage;
	}

	public String getNumFinPlageDispo() {
		return numFinPlageDispo;
	}

	public void setNumFinPlageDispo(String numFinPlageDispo) {
		this.numFinPlageDispo = numFinPlageDispo;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annee == null) ? 0 : annee.hashCode());
		result = prime * result + ((codeArticle == null) ? 0 : codeArticle.hashCode());
		result = prime * result + ((codePlageDispo == null) ? 0 : codePlageDispo.hashCode());
		result = prime * result + ((numDebPlage == null) ? 0 : numDebPlage.hashCode());
		result = prime * result + ((numDebPlageDispo == null) ? 0 : numDebPlageDispo.hashCode());
		result = prime * result + ((numFinPlage == null) ? 0 : numFinPlage.hashCode());
		result = prime * result + ((numFinPlageDispo == null) ? 0 : numFinPlageDispo.hashCode());
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
		PlageNumDispo other = (PlageNumDispo) obj;
		if (annee == null) {
			if (other.annee != null)
				return false;
		} else if (!annee.equals(other.annee))
			return false;
		if (codeArticle == null) {
			if (other.codeArticle != null)
				return false;
		} else if (!codeArticle.equals(other.codeArticle))
			return false;
		if (codePlageDispo == null) {
			if (other.codePlageDispo != null)
				return false;
		} else if (!codePlageDispo.equals(other.codePlageDispo))
			return false;
		if (numDebPlage == null) {
			if (other.numDebPlage != null)
				return false;
		} else if (!numDebPlage.equals(other.numDebPlage))
			return false;
		if (numDebPlageDispo == null) {
			if (other.numDebPlageDispo != null)
				return false;
		} else if (!numDebPlageDispo.equals(other.numDebPlageDispo))
			return false;
		if (numFinPlage == null) {
			if (other.numFinPlage != null)
				return false;
		} else if (!numFinPlage.equals(other.numFinPlage))
			return false;
		if (numFinPlageDispo == null) {
			if (other.numFinPlageDispo != null)
				return false;
		} else if (!numFinPlageDispo.equals(other.numFinPlageDispo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlageNumDispo [codePlageDispo=" + codePlageDispo + ", numDebPlage=" + numDebPlage
				+ ", numDebPlageDispo=" + numDebPlageDispo + ", numFinPlage=" + numFinPlage + ", numFinPlageDispo="
				+ numFinPlageDispo + ", annee=" + annee + ", codeArticle=" + codeArticle + "]";
	}
	
}
