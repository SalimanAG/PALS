package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.TypeService;
import com.sil.gpc.repositories.TypeServiceRepository;

@Service
public class TypeServiceService {

	private final TypeServiceRepository repo;

	public TypeServiceService(TypeServiceRepository repo) {
		super();
		this.repo = repo;
	}
	
	public TypeService save(TypeService typeService) {
		if(!repo.existsById(typeService.getCodeTypService())) {
			return this.repo.save(typeService);
		}
		return null;
	}
	
	public TypeService edit(String id, TypeService typeService) {
		
		TypeService entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setLibTypService(typeService.getLibTypService());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		TypeService entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public TypeService getById(String id){
		
		return this.repo.findById(id).get();
	}
	
	public List<TypeService> getAll(){
		
		return this.repo.findAll();
	}


	
}
