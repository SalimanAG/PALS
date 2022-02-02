package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.LettreCommande;
import com.sil.gpc.repositories.LettreCommandeRepository;

@Service
public class LettreCommandeService {

	private final LettreCommandeRepository repo;

	public LettreCommandeService(LettreCommandeRepository repo) {
		super();
		this.repo = repo;
	}
	
	public LettreCommande save(LettreCommande lettreCommande) {
		
		Integer val = 1, nbrMaxCaract = 6;
		String code = "LC-";
		if(this.repo.findLastNumUsed(lettreCommande.getExercice().getNumExercice()) != null) {
			val = this.repo.findLastNumUsed(lettreCommande.getExercice().getNumExercice());
			val++;
			
		}
		
		lettreCommande.setValeur(val);
		
		code = code+lettreCommande.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		lettreCommande.setNumLettreComm(code+val);
		
		
		
		if(!repo.existsById(lettreCommande.getNumLettreComm())) {
			return this.repo.save(lettreCommande);
		}
		return null;
	}
	
	public LettreCommande edit(String id, LettreCommande lettreCommande) {
		
		LettreCommande entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setCommande(lettreCommande.getCommande());
			entiter.setExercice(lettreCommande.getExercice());
			entiter.setCommandeAchat(lettreCommande.getCommandeAchat());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		LettreCommande entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public LettreCommande getById(String id){
		
		return this.repo.findById(id).get();
	}
	
	public List<LettreCommande> getAll(){
		
		return this.repo.findAll();
	}


	
}
