package com.sil.gpc.services;

import java.util.List;
import org.springframework.stereotype.Service;


import com.sil.gpc.domains.Fonction;
import com.sil.gpc.repositories.FonctionRepository;

@Service
public class FonctionService {
	
	private final FonctionRepository repo;

	public FonctionService(FonctionRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Fonction save(Fonction fonction) {
		return this.repo.save(fonction);
	}
	
	public Fonction edit(Long id, Fonction fonction) {
		
		Fonction entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setCodeFonction(fonction.getCodeFonction());
			entiter.setLibFonction(fonction.getLibFonction());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		Fonction entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public Fonction getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<Fonction> getAll(){
		
		return this.repo.findAll();
	}


}
