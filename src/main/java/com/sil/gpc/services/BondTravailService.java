package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.BondTravail;
import com.sil.gpc.repositories.BondTravailRepository;

@Service
public class BondTravailService {

	private final BondTravailRepository repo;

	public BondTravailService(BondTravailRepository repo) {
		super();
		this.repo = repo;
	}
	
	public BondTravail save(BondTravail bondTravail) {
		if(!repo.existsById(bondTravail.getNumBondTravail())) {
			return this.repo.save(bondTravail);
		}
		return null;
	}
	
	public BondTravail edit(String id, BondTravail bondTravail) {
		
		BondTravail entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setCommande(bondTravail.getCommande());
			entiter.setExercice(bondTravail.getExercice());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		BondTravail entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public BondTravail getById(String id){
		
		return this.repo.findById(id).get();
	}
	
	public List<BondTravail> getAll(){
		
		return this.repo.findAll();
	}

	
	
}
