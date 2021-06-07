package com.sil.gpc.encapsuleurs;

import java.util.List;

import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.LigneAppro;

public class EncapApprovisionnement {

	private Approvisionnement approvisionnement;
	private List<LigneAppro> ligneAppros;
	
	public EncapApprovisionnement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EncapApprovisionnement(Approvisionnement approvisionnement, List<LigneAppro> ligneAppros) {
		super();
		this.approvisionnement = approvisionnement;
		this.ligneAppros = ligneAppros;
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

	@Override
	public String toString() {
		return "EncapApprovisionnement [approvisionnement=" + approvisionnement + ", ligneAppros=" + ligneAppros + "]";
	}
	
	
	
}
