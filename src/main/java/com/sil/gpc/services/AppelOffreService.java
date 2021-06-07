package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.AppelOffre;
import com.sil.gpc.repositories.AppelOffreRepository;

@Service
public class AppelOffreService {

	private final AppelOffreRepository repo;

	public AppelOffreService(AppelOffreRepository repo) {
		super();
		this.repo = repo;
	}
	
	public AppelOffre save(AppelOffre appelOffre) {
		if(!repo.existsById(appelOffre.getNumAppelOffre())) {
			return this.repo.save(appelOffre);
		}
		return null;
	}
	
	public AppelOffre edit(String id, AppelOffre appelOffre) {
		
		AppelOffre entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setCommande(appelOffre.getCommande());
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		AppelOffre entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public AppelOffre getById(String id){
		
		return this.repo.findById(id).get();
	}
	
	public List<AppelOffre> getAll(){
		
		return this.repo.findAll();
	}

	
}
