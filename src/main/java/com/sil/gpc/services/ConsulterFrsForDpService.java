package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.ConsulterFrsForDp;
import com.sil.gpc.repositories.ConsulterFrsForDpRepository;

@Service
public class ConsulterFrsForDpService {

	private final ConsulterFrsForDpRepository repo;

	public ConsulterFrsForDpService(ConsulterFrsForDpRepository repo) {
		super();
		this.repo = repo;
	}
	
	public ConsulterFrsForDp save(ConsulterFrsForDp consulterFrsForDp) {
		if(!repo.existsById(consulterFrsForDp.getIdConsulterFrsForDp())) {
			return this.repo.save(consulterFrsForDp);
		}
		return null;
	}
	
	public ConsulterFrsForDp edit(Long id, ConsulterFrsForDp consulterFrsForDp) {
		
		ConsulterFrsForDp entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setDemandePrix(consulterFrsForDp.getDemandePrix());
			entiter.setFournisseur(consulterFrsForDp.getFournisseur());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		ConsulterFrsForDp entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public ConsulterFrsForDp getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<ConsulterFrsForDp> getAll(){
		
		return this.repo.findAll();
	}


	
	
}
