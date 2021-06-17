package com.sil.gpc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.FactureProFormAcha;
import com.sil.gpc.domains.LigneDemandePrix;
import com.sil.gpc.domains.LigneFactureProFormAchat;
import com.sil.gpc.encapsuleurs.EncapDemandePrix;
import com.sil.gpc.encapsuleurs.EncapFactureProformAchat;
import com.sil.gpc.repositories.FactureProFormAchaRepository;
import com.sil.gpc.repositories.LigneFactureProFormAchatRepository;

@Service
public class FactureProFormAchaService {

	private final FactureProFormAchaRepository repo;
	private final LigneFactureProFormAchatRepository repo2;
	private final LigneFactureProFormAchaService servi2;

	public FactureProFormAchaService(FactureProFormAchaRepository repo, LigneFactureProFormAchatRepository repo2, LigneFactureProFormAchaService servi2) {
		super();
		this.repo = repo;
		this.repo2 = repo2;
		this.servi2 = servi2;
	}
	
	public FactureProFormAcha save(FactureProFormAcha factureProFormAcha) {
		
		Integer val = 1, nbrMaxCaract = 6;
		String code = "FPA-";
		if(this.repo.findLastNumUsed(factureProFormAcha.getExercice().getNumExercice()) != null) {
			val = this.repo.findLastNumUsed(factureProFormAcha.getExercice().getNumExercice());
			val++;
			
		}
		
		factureProFormAcha.setValeur(val);
		
		code = code+factureProFormAcha.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		factureProFormAcha.setIdFpfa(code+val);
		
		
		if(!repo.existsById(factureProFormAcha.getIdFpfa())) {
			return this.repo.save(factureProFormAcha);
		}
		return null;
	}
	
	public FactureProFormAcha edit(String id, FactureProFormAcha factureProFormAcha) {
		
		FactureProFormAcha entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setCommande(factureProFormAcha.getCommande());
			entiter.setDateDeplisFpfa(factureProFormAcha.getDateDeplisFpfa());
			entiter.setDateFpfa(factureProFormAcha.getDateFpfa());
			entiter.setDatePriseFpfa(factureProFormAcha.getDatePriseFpfa());
			entiter.setDesignationFpfa(factureProFormAcha.getDesignationFpfa());
			entiter.setExercice(factureProFormAcha.getExercice());
			entiter.setFournisseur(factureProFormAcha.getFournisseur());
			entiter.setObserFpfa(factureProFormAcha.getObserFpfa());
			entiter.setValideFpfa(factureProFormAcha.isValideFpfa());
			entiter.setDemandePrix(factureProFormAcha.getDemandePrix());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	
	public EncapFactureProformAchat editByEncap(String id, EncapFactureProformAchat encap) {
		
		List<LigneFactureProFormAchat> lignes = this.repo2.findAll();
		List<LigneFactureProFormAchat> concernedLignes = new ArrayList<LigneFactureProFormAchat>();
		List<LigneFactureProFormAchat> newLignes = new ArrayList<LigneFactureProFormAchat>();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getFactureProFormAcha().getIdFpfa() == id) {
				concernedLignes.add(lignes.get(i));
			}
		}
		
		for(int i = 0; i < encap.getFactureProFormAchats().size(); i++) {
			boolean added = true;
			LigneFactureProFormAchat enti = null;
			
			for(int j = 0; j < concernedLignes.size(); j++) {
				if(concernedLignes.get(j).getArticle().getNumArticle() == encap.getFactureProFormAchats().get(i).getArticle().getNumArticle()) {
					added = false;
					enti = concernedLignes.get(j);
					break;
				}
			}
			
			LigneFactureProFormAchat newer = encap.getFactureProFormAchats().get(i);
			newer.setFactureProFormAcha(repo.getOne(id));
			
			if(added == true) {
				
				this.repo2.save(newer);
			}
			else {
				this.servi2.edit(enti.getIdLigneFpfa(), newer);
			}
		}
		
		for(int i = 0; i < concernedLignes.size(); i++) {
			
			boolean removed = true;
			
			for(int j = 0; j < encap.getFactureProFormAchats().size(); j++) {
				if(concernedLignes.get(i).getArticle().getNumArticle() == encap.getFactureProFormAchats().get(j).getArticle().getNumArticle()) {
					removed = false;
					break;
				}
			}
			
			if(removed == true) {
				this.repo2.deleteById(concernedLignes.get(i).getIdLigneFpfa());
			}			
			
		}
		
		lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getFactureProFormAcha().getIdFpfa() == id) {
				newLignes.add(lignes.get(i));
			}
		}
		
		
		return new EncapFactureProformAchat(this.edit(id, encap.getFactureProFormAcha()), newLignes);
	}
	
	

	
	
	public boolean delete(String id) {
		
		FactureProFormAcha entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	
	public boolean deleteAFactureProFormAcha2(String id) {
		
		List<LigneFactureProFormAchat> lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getFactureProFormAcha().getIdFpfa() == id) {
				this.repo2.deleteById(lignes.get(i).getIdLigneFpfa());
			}
		}
		
		return this.delete(id);
	}
	
	
	public FactureProFormAcha getById(String id){
		
		return this.repo.findById(id).get();
	}
	
	public List<FactureProFormAcha> getAll(){
		
		return this.repo.findAll();
	}


	
	
}
