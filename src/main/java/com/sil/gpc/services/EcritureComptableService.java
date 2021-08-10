package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.EcritureComptable;
import com.sil.gpc.domains.OpeJournalSetting;
import com.sil.gpc.repositories.EcritureComptableRepository;

@Service
public class EcritureComptableService {

	private final EcritureComptableRepository repo;

	public EcritureComptableService(EcritureComptableRepository repo) {
		super();
		this.repo = repo;
	}
	
	public EcritureComptable save(EcritureComptable ecritureComptable) {
		return this.repo.save(ecritureComptable);
	}
	
	public List<EcritureComptable> save2(List<EcritureComptable> ecritureComptables) {
		return this.repo.saveAll(ecritureComptables);
	}
	
	public EcritureComptable edit(Long id, EcritureComptable ecritureComptable) {
		
		EcritureComptable entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setCentreConsEcri(ecritureComptable.getCentreConsEcri());
			entiter.setCompteEcri(ecritureComptable.getCompteEcri());
			entiter.setCredit(ecritureComptable.isCredit());
			entiter.setDateEcri(ecritureComptable.getDateEcri());
			entiter.setFamille(ecritureComptable.getFamille());
			entiter.setJournal(ecritureComptable.getJournal());
			entiter.setLibEcri(ecritureComptable.getLibEcri());
			entiter.setPieceEcri(ecritureComptable.getPieceEcri());
			entiter.setReferenceEcri(ecritureComptable.getReferenceEcri());
			entiter.setMontantEcri(ecritureComptable.getMontantEcri());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete (Long id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	public EcritureComptable getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<EcritureComptable> getAll(){
		
		return this.repo.findAll();
	}
	
	
}
