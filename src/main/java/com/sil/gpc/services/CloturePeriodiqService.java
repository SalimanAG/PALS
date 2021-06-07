package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sil.gpc.domains.CloturePeriodiq;
import com.sil.gpc.repositories.CloturePeriodiqRepository;

@Service
public class CloturePeriodiqService {

	private final CloturePeriodiqRepository repo;

	public CloturePeriodiqService(CloturePeriodiqRepository repo) {
		super();
		this.repo = repo;
	}
	
	public CloturePeriodiq save(CloturePeriodiq cloturePeriodiq) {
		if(!repo.existsById(cloturePeriodiq.getIdCloturePer())) {
			return this.repo.save(cloturePeriodiq);
		}
		return null;
	}
	
	public CloturePeriodiq edit(Long id, CloturePeriodiq cloturePeriodiq) {
		
		CloturePeriodiq entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setDateDebutCloturePer(cloturePeriodiq.getDateDebutCloturePer());
			entiter.setDateFinCloturePer(cloturePeriodiq.getDateFinCloturePer());
			entiter.setExercice(cloturePeriodiq.getExercice());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		CloturePeriodiq entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public CloturePeriodiq getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<CloturePeriodiq> getAll(){
		
		return this.repo.findAll();
	}

	
	
	
}
