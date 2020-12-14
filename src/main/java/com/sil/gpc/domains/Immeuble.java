package com.sil.gpc.domains;

import javax.persistence.Entity;

@Entity
public class Immeuble {

	private String codeIm;
	private String localisationIm;
	private boolean etatIm;
	private String codeTypIm;
	private String codeQuartier;
	
	public Immeuble() {
		super();
	}


	public Immeuble(String codeIm, String localisationIm, boolean etatIm, String codeTypIm, String codeQuartier) {
		super();
		this.codeIm = codeIm;
		this.localisationIm = localisationIm;
		this.etatIm = etatIm;
		this.codeTypIm = codeTypIm;
		this.codeQuartier = codeQuartier;
	}



	public String getCodeIm() {
		return codeIm;
	}

	public void setCodeIm(String codeIm) {
		this.codeIm = codeIm;
	}

	public String getLocalisationIm() {
		return localisationIm;
	}

	public void setLocalisationIm(String localisationIm) {
		this.localisationIm = localisationIm;
	}

	public boolean isEtatIm() {
		return etatIm;
	}

	public void setEtatIm(boolean etatIm) {
		this.etatIm = etatIm;
	}

	public String getCodeTypIm() {
		return codeTypIm;
	}

	public void setCodeTypIm(String codeTypIm) {
		this.codeTypIm = codeTypIm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeIm == null) ? 0 : codeIm.hashCode());
		result = prime * result + ((codeTypIm == null) ? 0 : codeTypIm.hashCode());
		result = prime * result + (etatIm ? 1231 : 1237);
		result = prime * result + ((localisationIm == null) ? 0 : localisationIm.hashCode());
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
		Immeuble other = (Immeuble) obj;
		if (codeIm == null) {
			if (other.codeIm != null)
				return false;
		} else if (!codeIm.equals(other.codeIm))
			return false;
		if (codeTypIm == null) {
			if (other.codeTypIm != null)
				return false;
		} else if (!codeTypIm.equals(other.codeTypIm))
			return false;
		if (etatIm != other.etatIm)
			return false;
		if (localisationIm == null) {
			if (other.localisationIm != null)
				return false;
		} else if (!localisationIm.equals(other.localisationIm))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Immeuble [codeIm=" + codeIm + ", localisationIm=" + localisationIm + ", etatIm=" + etatIm
				+ ", codeTypIm=" + codeTypIm + "]";
	}
	
	
}
