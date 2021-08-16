package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.LigneCommande;
import com.sil.gpc.domains.LigneReception;
import com.sil.gpc.repositories.LigneReceptionRepository;

@Service
public class LigneReceptionService {

	private final LigneReceptionRepository repos;

	/**
	 * @param repos
	 */
	public LigneReceptionService(LigneReceptionRepository lrr) {
		this.repos = lrr;
	}

	public Optional<LigneReception> findById(Long id) {
		return repos.findById(id);
	}


	/*public List<LigneReception> findByQte (double qte){
		return repos.findByQuantiteLigneReception(qte);
	}

	public List<LigneReception> findByPrix (double prix){
		return repos.findByPULigneReception(prix);
	}*/

	public List<LigneReception> findAll() {
		return repos.findAll();
	}

	public LigneReception save(LigneReception ligne){
		return repos.save(ligne);
	}
	
	public List<LigneReception> saveAll (List<LigneReception> ligneReceptions) {
		
		return this.repos.saveAll(ligneReceptions);
	}

	public LigneReception edit(LigneReception ligne, Long id) {
		LigneReception cible=repos.getOne(id);
		if (cible!=null) {
		cible.setPuLigneReception(ligne.getPuLigneReception());
		cible.setNumSerieDebLigneReception(ligne.getNumSerieDebLigneReception());
		cible.setNumSerieFinLigneReception(ligne.getNumSerieFinLigneReception());
		cible.setQuantiteLigneReception(ligne.getQuantiteLigneReception());
		cible.setObservationLigneReception(ligne.getObservationLigneReception());
		cible.setImputer(ligne.isImputer());
		cible.setLigneCommande(ligne.getLigneCommande());
		cible.setReception(ligne.getReception());
		cible.setLastCump(ligne.getLastCump());
		cible.setLastStockQte(ligne.getLastStockQte());
		
		return repos.save(cible);
		}
		else 
			return null;
	}

	public boolean delete(Long id) {
		repos.deleteById(id);
		return repos.existsById(id);
	}
}
