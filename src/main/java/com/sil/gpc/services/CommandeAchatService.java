package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.CommandeAchat;
import com.sil.gpc.repositories.CommandeAchatRepository;

@Service
public class CommandeAchatService {

	private final CommandeAchatRepository repo;

	public CommandeAchatService(CommandeAchatRepository repo) {
		super();
		this.repo = repo;
	}
	
	public CommandeAchat save(CommandeAchat commandeAchat) {
		
		Integer val = 1, nbrMaxCaract = 6;
		String code = "CA-";
		if(this.repo.findLastNumUsed(commandeAchat.getExercice().getNumExercice()) != null) {
			val = this.repo.findLastNumUsed(commandeAchat.getExercice().getNumExercice());
			val++;
			
		}
		
		commandeAchat.setValeur(val);
		
		code = code+commandeAchat.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		commandeAchat.setNumComAchat(code+val);
		
		
		
		if(!repo.existsById(commandeAchat.getNumComAchat())) {
			return this.repo.save(commandeAchat);
		}
		return null;
	}
	
	public CommandeAchat edit(String id, CommandeAchat commandeAchat) {
		
		CommandeAchat entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setCommande(commandeAchat.getCommande());
			entiter.setExercice(commandeAchat.getExercice());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		CommandeAchat entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public CommandeAchat getById(String id){
		
		return this.repo.findById(id).get();
	}
	
	public List<CommandeAchat> getAll(){
		
		return this.repo.findAll();
	}


	
	
}
