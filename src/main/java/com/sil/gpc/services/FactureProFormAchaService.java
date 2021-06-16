package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.FactureProFormAcha;
import com.sil.gpc.domains.LigneDemandePrix;
import com.sil.gpc.domains.LigneFactureProFormAchat;
import com.sil.gpc.repositories.FactureProFormAchaRepository;
import com.sil.gpc.repositories.LigneFactureProFormAchatRepository;

@Service
public class FactureProFormAchaService {

	private final FactureProFormAchaRepository repo;
	private final LigneFactureProFormAchatRepository repo2;

	public FactureProFormAchaService(FactureProFormAchaRepository repo, LigneFactureProFormAchatRepository repo2) {
		super();
		this.repo = repo;
		this.repo2 = repo2;
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
	
	
	public boolean deleteAFactureProFormAcha2(String id) {
		
		List<LigneFactureProFormAchat> lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getFactureProFormAcha().getIdFpfa() == id) {
				this.repo2.deleteById(lignes.get(i).getIdLigneFpfa());
			}
		}
		
		return this.delete(id);
	}
	
	
	public FactureProFormAcha getById(String id){
		
		return this.repo.findById(id).get();
	}
	
	public List<FactureProFormAcha> getAll(){
		
		return this.repo.findAll();
	}


	
	
}
