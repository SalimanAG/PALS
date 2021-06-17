package com.sil.gpc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.DemandePrix;
import com.sil.gpc.domains.LigneCommande;
import com.sil.gpc.domains.LigneDemandePrix;
import com.sil.gpc.encapsuleurs.EncapCommande;
import com.sil.gpc.encapsuleurs.EncapDemandePrix;
import com.sil.gpc.repositories.DemandePrixRepository;
import com.sil.gpc.repositories.LigneDemandePrixRepository;

@Service
public class DemandePrixService {

	private final DemandePrixRepository repo;
	private final LigneDemandePrixRepository repo2;
	private final LigneDemandePrixService servi2;

	public DemandePrixService(DemandePrixRepository repo, LigneDemandePrixRepository repo2, LigneDemandePrixService servi2) {
		super();
		this.repo = repo;
		this.repo2 = repo2;
		this.servi2 = servi2;
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
	
	
	public EncapDemandePrix editByEncap(String id, EncapDemandePrix encap) {
		
		List<LigneDemandePrix> lignes = this.repo2.findAll();
		List<LigneDemandePrix> concernedLignes = new ArrayList<LigneDemandePrix>();
		List<LigneDemandePrix> newLignes = new ArrayList<LigneDemandePrix>();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getDemandePrix().getIdDemandePrix() == id) {
				concernedLignes.add(lignes.get(i));
			}
		}
		
		for(int i = 0; i < encap.getLigneDemandePrixs().size(); i++) {
			boolean added = true;
			LigneDemandePrix enti = null;
			
			for(int j = 0; j < concernedLignes.size(); j++) {
				if(concernedLignes.get(j).getArticle().getNumArticle() == encap.getLigneDemandePrixs().get(i).getArticle().getNumArticle()) {
					added = false;
					enti = concernedLignes.get(j);
					break;
				}
			}
			
			LigneDemandePrix newer = encap.getLigneDemandePrixs().get(i);
			newer.setDemandePrix(repo.getOne(id));
			
			if(added == true) {
				
				this.repo2.save(newer);
			}
			else {
				this.servi2.edit(enti.getIdLigneDemandePrix(), newer);
			}
		}
		
		for(int i = 0; i < concernedLignes.size(); i++) {
			
			boolean removed = true;
			
			for(int j = 0; j < encap.getLigneDemandePrixs().size(); j++) {
				if(concernedLignes.get(i).getArticle().getNumArticle() == encap.getLigneDemandePrixs().get(j).getArticle().getNumArticle()) {
					removed = false;
					break;
				}
			}
			
			if(removed == true) {
				this.repo2.deleteById(concernedLignes.get(i).getIdLigneDemandePrix());
			}			
			
		}
		
		lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getDemandePrix().getIdDemandePrix() == id) {
				newLignes.add(lignes.get(i));
			}
		}
		
		
		return new EncapDemandePrix(this.edit(id, encap.getDemandePrix()), newLignes);
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
