package com.sil.gpc.encapsuleurs;

import java.util.List;

import com.sil.gpc.domains.DemandeApprovisionnement;
import com.sil.gpc.domains.LigneDemandeAppro;

public class EncapDemandeAppro {

	private DemandeApprovisionnement demandeApprovisionnement;
	private List<LigneDemandeAppro> ligneDemandeAppros;
	
	public EncapDemandeAppro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EncapDemandeAppro(DemandeApprovisionnement demandeApprovisionnement,
			List<LigneDemandeAppro> ligneDemandeAppros) {
		super();
		this.demandeApprovisionnement = demandeApprovisionnement;
		this.ligneDemandeAppros = ligneDemandeAppros;
	}

	public DemandeApprovisionnement getDemandeApprovisionnement() {
		return demandeApprovisionnement;
	}

	public void setDemandeApprovisionnement(DemandeApprovisionnement demandeApprovisionnement) {
		this.demandeApprovisionnement = demandeApprovisionnement;
	}

	public List<LigneDemandeAppro> getLigneDemandeAppros() {
		return ligneDemandeAppros;
	}

	public void setLigneDemandeAppros(List<LigneDemandeAppro> ligneDemandeAppros) {
		this.ligneDemandeAppros = ligneDemandeAppros;
	}

	@Override
	public String toString() {
		return "EncapDemandeAppro [demandeApprovisionnement=" + demandeApprovisionnement + ", ligneDemandeAppros="
				+ ligneDemandeAppros + "]";
	}
	
	
	
}
