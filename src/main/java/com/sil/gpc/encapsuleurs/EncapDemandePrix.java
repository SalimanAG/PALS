package com.sil.gpc.encapsuleurs;

import java.util.List;

import com.sil.gpc.domains.ConsulterFrsForDp;
import com.sil.gpc.domains.DemandePrix;
import com.sil.gpc.domains.LigneDemandePrix;

public class EncapDemandePrix {

	private DemandePrix demandePrix;
	private List<LigneDemandePrix> ligneDemandePrixs;
	private List<ConsulterFrsForDp> consulterFrsForDps;
	
	

	public EncapDemandePrix(DemandePrix demandePrix, List<LigneDemandePrix> ligneDemandePrixs,
			List<ConsulterFrsForDp> consulterFrsForDps) {
		super();
		this.demandePrix = demandePrix;
		this.ligneDemandePrixs = ligneDemandePrixs;
		this.consulterFrsForDps = consulterFrsForDps;
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

	public List<ConsulterFrsForDp> getConsulterFrsForDps() {
		return consulterFrsForDps;
	}

	public void setConsulterFrsForDps(List<ConsulterFrsForDp> consulterFrsForDps) {
		this.consulterFrsForDps = consulterFrsForDps;
	}
	
	
	
}
