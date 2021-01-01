package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.LigneReception;
import com.sil.gpc.repositories.LigneReceptionRepository;

@Service
public class LigneReceptionService {

	private final LigneReceptionRepository lrr;

	/**
	 * @param lr
	 */
	public LigneReceptionService(LigneReceptionRepository lrr) {
		this.lrr = lrr;
	}

	public List<LigneReception> ajouteLigneReception(LigneReception ligne){
		lrr.save(ligne);
		return lrr.findAll();
	}

	public LigneReception modifieLigneReception(LigneReception ligne, Long id) {
		LigneReception lr=lrr.getOne(id);
		lr.setQuantiteLigneReception(ligne.getQuantiteLigneReception());
		lr.setPULigneReception(ligne.getPULigneReception());
		lr.setNumSerieDebLigneReception(ligne.getNumSerieDebLigneReception());
		lr.setNumSerieFinLigneReception(ligne.getNumSerieFinLigneReception());
		lr.setQuantiteLigneReception(ligne.getQuantiteLigneReception());
		lr.setObservationLigneReception(ligne.getObservationLigneReception());
		return lrr.save(lr);
	}

	public List<LigneReception> supprimeLigneReception(Long id) {
		lrr.deleteById(id);
		return lrr.findAll();
	}
}
