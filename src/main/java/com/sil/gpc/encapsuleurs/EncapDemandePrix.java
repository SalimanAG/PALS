package com.sil.gpc.encapsuleurs;

import java.util.List;

import com.sil.gpc.domains.DemandePrix;
import com.sil.gpc.domains.LigneDemandePrix;

public class EncapDemandePrix {

	private DemandePrix demandePrix;
	private List<LigneDemandePrix> ligneDemandePrixs;
	
	public EncapDemandePrix(DemandePrix demandePrix, List<LigneDemandePrix> ligneDemandePrixs) {
		super();
		this.demandePrix = demandePrix;
		this.ligneDemandePrixs = ligneDemandePrixs;
	}

	public DemandePrix getDemandePrix() {
		return demandePrix;
	}

	public void setDemandePrix(DemandePrix demandePrix) {
		this.demandePrix = demandePrix;
	}

	public List<LigneDemandePrix> getLigneDemandePrixs() {
		return ligneDemandePrixs;
	}

	public void setLigneDemandePrixs(List<LigneDemandePrix> ligneDemandePrixs) {
		this.ligneDemandePrixs = ligneDemandePrixs;
	}
	
	
	
}
