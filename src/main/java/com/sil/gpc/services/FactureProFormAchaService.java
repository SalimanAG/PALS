package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.FactureProFormAcha;
import com.sil.gpc.repositories.FactureProFormAchaRepository;

@Service
public class FactureProFormAchaService {

	private final FactureProFormAchaRepository repo;

	public FactureProFormAchaService(FactureProFormAchaRepository repo) {
		super();
		this.repo = repo;
	}
	
	public FactureProFormAcha save(FactureProFormAcha factureProFormAcha) {
		if(!repo.existsById(factureProFormAcha.getIdFpfa())) {
			return this.repo.save(factureProFormAcha);
		}
		return null;
	}
	
	public FactureProFormAcha edit(String id, FactureProFormAcha factureProFormAcha) {
		
		FactureProFormAcha entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setCommande(factureProFormAcha.getCommande());
			entiter.setDateDeplisFpfa(factureProFormAcha.getDateDeplisFpfa());
			entiter.setDateFpfa(factureProFormAcha.getDateFpfa());
			entiter.setDatePriseFpfa(factureProFormAcha.getDatePriseFpfa());
			entiter.setDesignationFpfa(factureProFormAcha.getDesignationFpfa());
			entiter.setExercice(factureProFormAcha.getExercice());
			entiter.setFournisseur(factureProFormAcha.getFournisseur());
			entiter.setObserFpfa(factureProFormAcha.getObserFpfa());
			entiter.setValideFpfa(factureProFormAcha.isValideFpfa());
			entiter.setDemandePrix(factureProFormAcha.getDemandePrix());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		FactureProFormAcha entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public FactureProFormAcha getById(String id){
		
		return this.repo.findById(id).get();
	}
	
	public List<FactureProFormAcha> getAll(){
		
		return this.repo.findAll();
	}


	
	
}
