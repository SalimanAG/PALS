package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.LigneCommande;
import com.sil.gpc.domains.LigneDemandePrix;
import com.sil.gpc.repositories.LigneDemandePrixRepository;

@Service
public class LigneDemandePrixService {

	private final LigneDemandePrixRepository repo;

	public LigneDemandePrixService(LigneDemandePrixRepository repo) {
		super();
		this.repo = repo;
	}
	
	public LigneDemandePrix save(LigneDemandePrix ligneDemandePrix) {
		if(!repo.existsById(ligneDemandePrix.getIdLigneDemandePrix())) {
			return this.repo.save(ligneDemandePrix);
		}
		return null;
	}
	
	
	public List<LigneDemandePrix> saveAll (List<LigneDemandePrix> ligneDemandePrixs) {
		
		return this.repo.saveAll(ligneDemandePrixs);
	}
	
	
	public LigneDemandePrix edit(Long id, LigneDemandePrix ligneDemandePrix) {
		
		LigneDemandePrix entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setArticle(ligneDemandePrix.getArticle());
			entiter.setDemandePrix(ligneDemandePrix.getDemandePrix());
			entiter.setDesignationLigneDemandePrix(ligneDemandePrix.getDesignationLigneDemandePrix());
			entiter.setQteLigneDemandePrix(ligneDemandePrix.getQteLigneDemandePrix());
			entiter.setUniter(ligneDemandePrix.getUniter());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		LigneDemandePrix entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public LigneDemandePrix getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<LigneDemandePrix> getAll(){
		
		return this.repo.findAll();
	}


	
	
}
