package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Civilite;
import com.sil.gpc.repositories.CiviliteRepository;

@Service
public class CiviliteService {
	
	private final CiviliteRepository repo;

	public CiviliteService(CiviliteRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Civilite save(Civilite civilite) {
		return this.repo.save(civilite);
	}
	
	public Civilite edit(Long id, Civilite civilite) {
		
		Civilite entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setCodeCivilite(civilite.getCodeCivilite());
			entiter.setLibCivilite(civilite.getLibCivilite());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		Civilite entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public Civilite getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<Civilite> getAll(){
		
		return this.repo.findAll();
	}

}
