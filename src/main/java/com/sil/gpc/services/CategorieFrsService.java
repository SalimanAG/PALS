package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.CategorieFrs;
import com.sil.gpc.repositories.CategorieFrsRepository;

@Service
public class CategorieFrsService {

	private final CategorieFrsRepository repo;

	public CategorieFrsService(CategorieFrsRepository repo) {
		super();
		this.repo = repo;
	}
	
	public CategorieFrs save(CategorieFrs categorieFrs) {
		return this.repo.save(categorieFrs);
	}
	
	public List<CategorieFrs> saveByList(List<CategorieFrs> categorieFrs) {
		return this.repo.saveAll(categorieFrs);
	}

	
	public CategorieFrs edit(Long id, CategorieFrs categorieFrs) {
		
		CategorieFrs entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setCodeCatFrs(categorieFrs.getCodeCatFrs());
			entiter.setLibCatFrs(categorieFrs.getLibCatFrs());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		CategorieFrs entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public CategorieFrs getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<CategorieFrs> getAll(){
		
		return this.repo.findAll();
	}

	
}
