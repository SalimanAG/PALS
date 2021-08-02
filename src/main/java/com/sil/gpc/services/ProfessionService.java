package com.sil.gpc.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Profession;
import com.sil.gpc.repositories.ProfessionRepository;

@Service
public class ProfessionService {
	
	private final ProfessionRepository repo;

	public ProfessionService(ProfessionRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Profession save(Profession profession) {
		return this.repo.save(profession);
	}
	
	public Profession edit(Long id, Profession profession) {
		
		Profession entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setCodeProfession(profession.getCodeProfession());
			entiter.setLibProfession(profession.getLibProfession());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		Profession entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public Profession getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<Profession> getAll(){
		
		return this.repo.findAll();
	}

}
