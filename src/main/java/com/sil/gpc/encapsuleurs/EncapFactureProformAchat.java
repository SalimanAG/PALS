package com.sil.gpc.encapsuleurs;

import java.util.List;

import com.sil.gpc.domains.FactureProFormAcha;
import com.sil.gpc.domains.LigneFactureProFormAchat;

public class EncapFactureProformAchat {

	private FactureProFormAcha factureProFormAcha;
	private List<LigneFactureProFormAchat> factureProFormAchats;
	
	public EncapFactureProformAchat(FactureProFormAcha factureProFormAcha,
			List<LigneFactureProFormAchat> factureProFormAchats) {
		super();
		this.factureProFormAcha = factureProFormAcha;
		this.factureProFormAchats = factureProFormAchats;
	}

	public FactureProFormAcha getFactureProFormAcha() {
		return factureProFormAcha;
	}

	public void setFactureProFormAcha(FactureProFormAcha factureProFormAcha) {
		this.factureProFormAcha = factureProFormAcha;
	}

	public List<LigneFactureProFormAchat> getFactureProFormAchats() {
		return factureProFormAchats;
	}

	public void setFactureProFormAchats(List<LigneFactureProFormAchat> factureProFormAchats) {
		this.factureProFormAchats = factureProFormAchats;
	}
	
	
	
}
