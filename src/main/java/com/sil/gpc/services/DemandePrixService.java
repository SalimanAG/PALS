package com.sil.gpc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.ConsulterFrsForDp;
import com.sil.gpc.domains.DemandePrix;
import com.sil.gpc.domains.LigneCommande;
import com.sil.gpc.domains.LigneDemandePrix;
import com.sil.gpc.encapsuleurs.EncapCommande;
import com.sil.gpc.encapsuleurs.EncapDemandePrix;
import com.sil.gpc.repositories.ConsulterFrsForDpRepository;
import com.sil.gpc.repositories.DemandePrixRepository;
import com.sil.gpc.repositories.LigneDemandePrixRepository;

@Service
public class DemandePrixService {

	private final DemandePrixRepository repo;
	private final LigneDemandePrixRepository repo2;
	private final LigneDemandePrixService servi2;
	private final ConsulterFrsForDpRepository repo3;
	private final ConsulterFrsForDpService servi3;

	public DemandePrixService(DemandePrixRepository repo, LigneDemandePrixRepository repo2, LigneDemandePrixService servi2, ConsulterFrsForDpService servi3, ConsulterFrsForDpRepository repo3) {
		super();
		this.repo = repo;
		this.repo2 = repo2;
		this.servi2 = servi2;
		this.repo3 = repo3;
		this.servi3 = servi3;
	}
	
	public DemandePrix save(DemandePrix demandePrix) {
		
    	Integer val = 1, nbrMaxCaract = 6;
		String code = "DP-";
		if(this.repo.findLastNumUsed(demandePrix.getExercice().getNumExercice()) != null) {
			val = this.repo.findLastNumUsed(demandePrix.getExercice().getNumExercice());
			val++;
			
		}
		
		demandePrix.setValeur(val);
		
		code = code+demandePrix.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		demandePrix.setIdDemandePrix(code+val);
		
		if(!repo.existsById(demandePrix.getIdDemandePrix())) {
			return this.repo.save(demandePrix);
		}
		return null;
	}
	
	public DemandePrix edit(String id, DemandePrix demandePrix) {
		
		DemandePrix entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setDateDemandePrix(demandePrix.getDateDemandePrix());
			entiter.setDateLimiteDemandePrix(demandePrix.getDateLimiteDemandePrix());
			entiter.setDesignationDemandePrix(demandePrix.getDesignationDemandePrix());
			entiter.setExercice(demandePrix.getExercice());
			//entiter.setReporter(demandePrix.get());
			entiter.setValideDemandePrix(demandePrix.isValideDemandePrix());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	
	public EncapDemandePrix editByEncap(String id, EncapDemandePrix encap) {
		
		List<LigneDemandePrix> lignes = this.repo2.findAll();
		List<LigneDemandePrix> concernedLignes = new ArrayList<LigneDemandePrix>();
		List<LigneDemandePrix> newLignes = new ArrayList<LigneDemandePrix>();
		
		System.out.println(encap);
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getDemandePrix().getIdDemandePrix().equalsIgnoreCase(id)) {
				concernedLignes.add(lignes.get(i));
			}
		}
		
		for(int i = 0; i < encap.getLigneDemandePrixs().size(); i++) {
			boolean added = true;
			LigneDemandePrix enti = null;
			
			for(int j = 0; j < concernedLignes.size(); j++) {
				if(concernedLignes.get(j).getArticle().getNumArticle() == encap.getLigneDemandePrixs().get(i).getArticle().getNumArticle()) {
					added = false;
					enti = concernedLignes.get(j);
					break;
				}
			}
			
			LigneDemandePrix newer = encap.getLigneDemandePrixs().get(i);
			newer.setDemandePrix(repo.getOne(id));
			
			if(added == true) {
				
				this.repo2.save(newer);
			}
			else {
				this.servi2.edit(enti.getIdLigneDemandePrix(), newer);
			}
		}
		
		for(int i = 0; i < concernedLignes.size(); i++) {
			
			boolean removed = true;
			
			for(int j = 0; j < encap.getLigneDemandePrixs().size(); j++) {
				if(concernedLignes.get(i).getArticle().getNumArticle().longValue() == encap.getLigneDemandePrixs().get(j).getArticle().getNumArticle()) {
					removed = false;
					break;
				}
			}
			
			if(removed == true) {
				this.repo2.deleteById(concernedLignes.get(i).getIdLigneDemandePrix());
			}			
			
		}
		
		lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getDemandePrix().getIdDemandePrix().equalsIgnoreCase(id)) {
				newLignes.add(lignes.get(i));
			}
		}
		
		//****************************Les Consulters**************************************
		
		List<ConsulterFrsForDp> consulters = this.repo3.findAll();
		List<ConsulterFrsForDp> concernedConsulters = new ArrayList<ConsulterFrsForDp>();
		List<ConsulterFrsForDp> newConnsulters = new ArrayList<ConsulterFrsForDp>();
		
		for(int i = 0; i < consulters.size(); i++) {
			if(consulters.get(i).getDemandePrix().getIdDemandePrix().equalsIgnoreCase(id)) {
				concernedConsulters.add(consulters.get(i));
			}
		}
		
		for(int i = 0; i < encap.getConsulterFrsForDps().size(); i++) {
			boolean added = true;
			ConsulterFrsForDp enti = null;
			
			for(int j = 0; j < concernedConsulters.size(); j++) {
				if(concernedConsulters.get(j).getFournisseur().getNumFournisseur() == encap.getConsulterFrsForDps().get(i).getFournisseur().getNumFournisseur()) {
					added = false;
					//System.out.println(added);
					enti = concernedConsulters.get(j);
					break;
				}
			}
			
			ConsulterFrsForDp newer = encap.getConsulterFrsForDps().get(i);
			newer.setDemandePrix(repo.getOne(id));
			
			if(added == true) {
				
				this.repo3.save(newer);
			}
			else {
				this.servi3.edit(enti.getIdConsulterFrsForDp(), newer);
			}
		}
		
		for(int i = 0; i < concernedConsulters.size(); i++) {
			
			boolean removed = true;
			
			for(int j = 0; j < encap.getConsulterFrsForDps().size(); j++) {
				if(concernedConsulters.get(i).getFournisseur().getNumFournisseur() == encap.getConsulterFrsForDps().get(j).getFournisseur().getNumFournisseur()) {
					removed = false;
					break;
				}
			}
			
			if(removed == true) {
				this.repo3.deleteById(concernedConsulters.get(i).getIdConsulterFrsForDp());
			}			
			
		}
		
		consulters = this.repo3.findAll();
		
		for(int i = 0; i < consulters.size(); i++) {
			if(consulters.get(i).getDemandePrix().getIdDemandePrix().equalsIgnoreCase(id)) {
				newConnsulters.add(consulters.get(i));
			}
		}
		
		
		return new EncapDemandePrix(this.edit(id, encap.getDemandePrix()), newLignes, newConnsulters);
	}
	
	
	
	public boolean delete(String id) {
		
		DemandePrix entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	
	public boolean deleteADemandePrix2(String id) {
		
		List<LigneDemandePrix> lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getDemandePrix().getIdDemandePrix().equalsIgnoreCase(id)) {
				this.repo2.deleteById(lignes.get(i).getIdLigneDemandePrix());
			}
		}
		
		List<ConsulterFrsForDp> consulters = this.repo3.findAll();
		
		for(int i = 0; i < consulters.size(); i++) {
			if(consulters.get(i).getDemandePrix().getIdDemandePrix().equalsIgnoreCase(id)) {
				this.repo3.deleteById(consulters.get(i).getIdConsulterFrsForDp());
			}
		}
		
		return this.delete(id);
	}
	
	
	public DemandePrix getById(String id){
		
		return this.repo.findById(id).get();
	}
	
	public List<DemandePrix> getAll(){
		
		return this.repo.findAll();
	}


	
}
