package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.LigneCommande;
import com.sil.gpc.domains.LigneFactureProFormAchat;
import com.sil.gpc.repositories.LigneFactureProFormAchatRepository;

@Service
public class LigneFactureProFormAchaService {

	private final LigneFactureProFormAchatRepository repo;

	public LigneFactureProFormAchaService(LigneFactureProFormAchatRepository repo) {
		super();
		this.repo = repo;
	}
	
	public LigneFactureProFormAchat save(LigneFactureProFormAchat ligneFactureProFormAchat) {
		if(!repo.existsById(ligneFactureProFormAchat.getIdLigneFpfa())) {
			return this.repo.save(ligneFactureProFormAchat);
		}
		return null;
	}
	
	
	public List<LigneFactureProFormAchat> saveAll (List<LigneFactureProFormAchat> ligneFactureProFormAchats) {
		
		return this.repo.saveAll(ligneFactureProFormAchats);
	}
	
	
	
	public LigneFactureProFormAchat edit(Long id, LigneFactureProFormAchat ligneFactureProFormAchat) {
		
		LigneFactureProFormAchat entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setArticle(ligneFactureProFormAchat.getArticle());
			entiter.setDesignLigneFpfa(ligneFactureProFormAchat.getDesignLigneFpfa());
			entiter.setFactureProFormAcha(ligneFactureProFormAchat.getFactureProFormAcha());
			entiter.setPrixUnitHtLigneFpfa(ligneFactureProFormAchat.getPrixUnitHtLigneFpfa());
			entiter.setPrixUnitLigneFpfa(ligneFactureProFormAchat.getPrixUnitLigneFpfa());
			entiter.setQteLigneFpfa(ligneFactureProFormAchat.getQteLigneFpfa());
			entiter.setTauxTaxeAibicLigneFpfa(ligneFactureProFormAchat.getTauxTaxeAibicLigneFpfa());
			entiter.setTauxTsLigneFpfa(ligneFactureProFormAchat.getTauxTsLigneFpfa());
			entiter.setTauxTvaLigneFpfa(ligneFactureProFormAchat.getTauxTvaLigneFpfa());
			entiter.setUniter(ligneFactureProFormAchat.getUniter());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		LigneFactureProFormAchat entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public LigneFactureProFormAchat getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<LigneFactureProFormAchat> getAll(){
		
		return this.repo.findAll();
	}


	
	
}
