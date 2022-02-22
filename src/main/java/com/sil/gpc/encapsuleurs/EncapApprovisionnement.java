package com.sil.gpc.encapsuleurs;

import java.util.List;

import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.DemandeApprovisionnement;
import com.sil.gpc.domains.LigneAppro;

public class EncapApprovisionnement {

	private Approvisionnement approvisionnement;
	private List<LigneAppro> ligneAppros;
	private DemandeApprovisionnement demandeApprovisionnement; 
	
	public EncapApprovisionnement() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public EncapApprovisionnement(Approvisionnement approvisionnement, List<LigneAppro> ligneAppros,
			DemandeApprovisionnement demandeApprovisionnement) {
		super();
		this.approvisionnement = approvisionnement;
		this.ligneAppros = ligneAppros;
		this.demandeApprovisionnement = demandeApprovisionnement;
	}



	public Approvisionnement getApprovisionnement() {
		return approvisionnement;
	}

	public void setApprovisionnement(Approvisionnement approvisionnement) {
		this.approvisionnement = approvisionnement;
	}

	public List<LigneAppro> getLigneAppros() {
		return ligneAppros;
	}

	public void setLigneAppros(List<LigneAppro> ligneAppros) {
		this.ligneAppros = ligneAppros;
	}


	public DemandeApprovisionnement getDemandeApprovisionnement() {
		return demandeApprovisionnement;
	}

	public void setDemandeApprovisionnement(DemandeApprovisionnement demandeApprovisionnement) {
		this.demandeApprovisionnement = demandeApprovisionnement;
	}


	@Override
	public String toString() {
		return "EncapApprovisionnement [approvisionnement=" + approvisionnement + ", ligneAppros=" + ligneAppros
				+ ", demandeApprovisionnement=" + demandeApprovisionnement + "]";
	}
	
	
	
}
