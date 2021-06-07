package com.sil.gpc.encapsuleurs;

import java.util.List;

import com.sil.gpc.domains.LigneReception;
import com.sil.gpc.domains.Reception;

public class EncapReception {

	private Reception reception;
	private List<LigneReception> ligneReceptions;
	
	public EncapReception() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EncapReception(Reception reception, List<LigneReception> ligneReceptions) {
		super();
		this.reception = reception;
		this.ligneReceptions = ligneReceptions;
	}

	public Reception getReception() {
		return reception;
	}

	public void setReception(Reception reception) {
		this.reception = reception;
	}

	public List<LigneReception> getLigneReceptions() {
		return ligneReceptions;
	}

	public void setLigneReceptions(List<LigneReception> ligneReceptions) {
		this.ligneReceptions = ligneReceptions;
	}

	@Override
	public String toString() {
		return "EncapReception [reception=" + reception + ", ligneReceptions=" + ligneReceptions + "]";
	}
	
	
	
}
