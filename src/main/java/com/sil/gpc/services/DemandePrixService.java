package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.DemandePrix;
import com.sil.gpc.domains.LigneCommande;
import com.sil.gpc.domains.LigneDemandePrix;
import com.sil.gpc.repositories.DemandePrixRepository;
import com.sil.gpc.repositories.LigneDemandePrixRepository;

@Service
public class DemandePrixService {

	private final DemandePrixRepository repo;
	private final LigneDemandePrixRepository repo2;

	public DemandePrixService(DemandePrixRepository repo, LigneDemandePrixRepository repo2) {
		super();
		this.repo = repo;
		this.repo2 = repo2;
	}
	
	public DemandePrix save(DemandePrix demandePrix) {
		if(!repo.existsById(demandePrix.getIdDemandePrix())) {
			return this.repo.save(demandePrix);
		}
		return null;
	}
	
	public DemandePrix edit(String id, DemandePrix demandePrix) {
		
		DemandePrix entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setDateDemandePrix(demandePrix.getDateDemandePrix());
			entiter.setDateLimiteDemandePrix(demandePrix.getDateLimiteDemandePrix());
			entiter.setDesignationDemandePrix(demandePrix.getDesignationDemandePrix());
			entiter.setExercice(demandePrix.getExercice());
			//entiter.setReporter(demandePrix.get());
			entiter.setValideDemandePrix(demandePrix.isValideDemandePrix());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		DemandePrix entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	
	public boolean deleteADemandePrix2(String id) {
		
		List<LigneDemandePrix> lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getDemandePrix().getIdDemandePrix() == id) {
				this.repo2.deleteById(lignes.get(i).getIdLigneDemandePrix());
			}
		}
		
		return this.delete(id);
	}
	
	
	public DemandePrix getById(String id){
		
		return this.repo.findById(id).get();
	}
	
	public List<DemandePrix> getAll(){
		
		return this.repo.findAll();
	}


	
}
