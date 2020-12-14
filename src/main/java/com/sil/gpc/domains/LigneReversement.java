package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LigneReversement {

	@Id
	private String codeArticle;
	private String numReversement;
	private Long quantiteLigneReversement;
	private Long PULigneReversement;
	private String dateQuittanceReversement;
	private String beneficiaire;
	private String observation;
	
	public LigneReversement() {
		super();
	}

	public LigneReversement(String codeArticle, String numReversement, Long quantiteLigneReversement,
			Long pULigneReversement, String dateQuittanceReversement, String beneficiaire, String observation) {
		super();
		this.codeArticle = codeArticle;
		this.numReversement = numReversement;
		this.quantiteLigneReversement = quantiteLigneReversement;
		PULigneReversement = pULigneReversement;
		this.dateQuittanceReversement = dateQuittanceReversement;
		this.beneficiaire = beneficiaire;
		this.observation = observation;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getNumReversement() {
		return numReversement;
	}

	public void setNumReversement(String numReversement) {
		this.numReversement = numReversement;
	}

	public Long getQuantiteLigneReversement() {
		return quantiteLigneReversement;
	}

	public void setQuantiteLigneReversement(Long quantiteLigneReversement) {
		this.quantiteLigneReversement = quantiteLigneReversement;
	}

	public Long getPULigneReversement() {
		return PULigneReversement;
	}

	public void setPULigneReversement(Long pULigneReversement) {
		PULigneReversement = pULigneReversement;
	}

	public String getDateQuittanceReversement() {
		return dateQuittanceReversement;
	}

	public void setDateQuittanceReversement(String dateQuittanceReversement) {
		this.dateQuittanceReversement = dateQuittanceReversement;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PULigneReversement == null) ? 0 : PULigneReversement.hashCode());
		result = prime * result + ((beneficiaire == null) ? 0 : beneficiaire.hashCode());
		result = prime * result + ((codeArticle == null) ? 0 : codeArticle.hashCode());
		result = prime * result + ((dateQuittanceReversement == null) ? 0 : dateQuittanceReversement.hashCode());
		result = prime * result + ((numReversement == null) ? 0 : numReversement.hashCode());
		result = prime * result + ((observation == null) ? 0 : observation.hashCode());
		result = prime * result + ((quantiteLigneReversement == null) ? 0 : quantiteLigneReversement.hashCode());
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
		LigneReversement other = (LigneReversement) obj;
		if (PULigneReversement == null) {
			if (other.PULigneReversement != null)
				return false;
		} else if (!PULigneReversement.equals(other.PULigneReversement))
			return false;
		if (beneficiaire == null) {
			if (other.beneficiaire != null)
				return false;
		} else if (!beneficiaire.equals(other.beneficiaire))
			return false;
		if (codeArticle == null) {
			if (other.codeArticle != null)
				return false;
		} else if (!codeArticle.equals(other.codeArticle))
			return false;
		if (dateQuittanceReversement == null) {
			if (other.dateQuittanceReversement != null)
				return false;
		} else if (!dateQuittanceReversement.equals(other.dateQuittanceReversement))
			return false;
		if (numReversement == null) {
			if (other.numReversement != null)
				return false;
		} else if (!numReversement.equals(other.numReversement))
			return false;
		if (observation == null) {
			if (other.observation != null)
				return false;
		} else if (!observation.equals(other.observation))
			return false;
		if (quantiteLigneReversement == null) {
			if (other.quantiteLigneReversement != null)
				return false;
		} else if (!quantiteLigneReversement.equals(other.quantiteLigneReversement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LigneReversement [codeArticle=" + codeArticle + ", numReversement=" + numReversement
				+ ", quantiteLigneReversement=" + quantiteLigneReversement + ", PULigneReversement="
				+ PULigneReversement + ", dateQuittanceReversement=" + dateQuittanceReversement + ", beneficiaire="
				+ beneficiaire + ", observation=" + observation + "]";
	}
	
}
