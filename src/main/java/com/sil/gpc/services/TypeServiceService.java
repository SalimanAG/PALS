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
		return this.repo.save(typeService);
	}
	
	public TypeService edit(Long id, TypeService typeService) {
		
		TypeService entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setLibTypService(typeService.getLibTypService());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		TypeService entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public TypeService getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<TypeService> getAll(){
		
		return this.repo.findAll();
	}


	
}
