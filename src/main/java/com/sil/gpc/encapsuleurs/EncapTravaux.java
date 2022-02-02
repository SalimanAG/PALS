package com.sil.gpc.encapsuleurs;

import java.util.List;

import com.sil.gpc.domains.LigneTravaux;
import com.sil.gpc.domains.Travaux;

public class EncapTravaux {

	private Travaux travaux;
	private List<LigneTravaux> ligneTravauxs;
	
	public EncapTravaux() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EncapTravaux(Travaux travaux, List<LigneTravaux> ligneTravauxs) {
		super();
		this.travaux = travaux;
		this.ligneTravauxs = ligneTravauxs;
	}

	public Travaux getTravaux() {
		return travaux;
	}

	public void setTravaux(Travaux travaux) {
		this.travaux = travaux;
	}

	public List<LigneTravaux> getLigneTravauxs() {
		return ligneTravauxs;
	}

	public void setLigneTravauxs(List<LigneTravaux> ligneTravauxs) {
		this.ligneTravauxs = ligneTravauxs;
	}

	@Override
	public String toString() {
		return "EncapTravaux [travaux=" + travaux + ", ligneTravauxs=" + ligneTravauxs + "]";
	}
	
	
	
}
