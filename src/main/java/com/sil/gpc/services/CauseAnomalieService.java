package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.CauseAnomalie;
import com.sil.gpc.repositories.CauseAnomalieRepository;

@Service
public class CauseAnomalieService {

	private final CauseAnomalieRepository repo;

	public CauseAnomalieService(CauseAnomalieRepository repo) {
		super();
		this.repo = repo;
	}
	
	public CauseAnomalie save(CauseAnomalie causeAnomalie) {
		if(!repo.existsById(causeAnomalie.getCodeCauseAno())) {
			return this.repo.save(causeAnomalie);
		}
		return null;
	}
	
	public CauseAnomalie edit(String id, CauseAnomalie causeAnomalie) {
		
		CauseAnomalie entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setLibCauseAno(causeAnomalie.getLibCauseAno());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		CauseAnomalie entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public CauseAnomalie getById(String id){
		
		return this.repo.findById(id).get();
	}
	
	public List<CauseAnomalie> getAll(){
		
		return this.repo.findAll();
	}

	
}
