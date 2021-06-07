package com.sil.gpc.encapsuleurs;

import java.util.List;

import com.sil.gpc.domains.Inventaire;
import com.sil.gpc.domains.LigneInventaire;

public class EncapInventaire {

	private Inventaire inventaire;
	private List<LigneInventaire> ligneInventaires;
	
	public EncapInventaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EncapInventaire(Inventaire inventaire, List<LigneInventaire> ligneInventaires) {
		super();
		this.inventaire = inventaire;
		this.ligneInventaires = ligneInventaires;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public List<LigneInventaire> getLigneInventaires() {
		return ligneInventaires;
	}

	public void setLigneInventaires(List<LigneInventaire> ligneInventaires) {
		this.ligneInventaires = ligneInventaires;
	}

	@Override
	public String toString() {
		return "EncapInventaire [inventaire=" + inventaire + ", ligneInventaires=" + ligneInventaires + "]";
	}
	
	
	
}
