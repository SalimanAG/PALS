package com.sil.gpc.services;

import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.LigneAppro;
import com.sil.gpc.domains.LigneFactureProFormAchat;
import com.sil.gpc.domains.LigneReception;
import com.sil.gpc.domains.Magasin;
import com.sil.gpc.domains.Reception;
import com.sil.gpc.domains.Stocker;
import com.sil.gpc.encapsuleurs.EncapApprovisionnement;
import com.sil.gpc.encapsuleurs.EncapReception;
import com.sil.gpc.repositories.LigneReceptionRepository;
import com.sil.gpc.repositories.ReceptionRepository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ReceptionService {

	private final ReceptionRepository receptionRepository;
	private final LigneReceptionRepository repo2;
	private final LigneReceptionService servi2;
	private final StockerService servi3;
	private final LigneCommandeService servi4;

    public ReceptionService(ReceptionRepository receptionRepository, LigneReceptionRepository repo2, LigneReceptionService servi2, StockerService servi3, LigneCommandeService servi4) {
        this.receptionRepository = receptionRepository;
		this.repo2 = repo2;
		this.servi2 = servi2;
		this.servi3 = servi3;
		this.servi4 = servi4;
    }

    // Sauvegarder 
    public Reception save(Reception rep) {
    	//rep.setValideRecep(true);
    	Integer val = 1, nbrMaxCaract = 6;
		String code = "RC-";
		if(this.receptionRepository.findLastNumUsed(rep.getExercice().getNumExercice()) != null) {
			val = this.receptionRepository.findLastNumUsed(rep.getExercice().getNumExercice());
			val++;
			
		}
		
		rep.setValeur(val);
		
		code = code+rep.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		rep.setNumReception(code+val);
		
		if(receptionRepository.existsById(rep.getNumReception())==false) return this.receptionRepository.save(rep) ;
		
		return null;
        
    }
    
    // Editer 
    public Reception edit(String numReception, Reception recept) {
       	
    	Reception receptmod = this.receptionRepository.getOne(numReception);
   		if(receptmod != null) {
   			receptmod.setObservation(recept.getObservation());
   			receptmod.setDateReception(recept.getDateReception());
   			receptmod.setExercice(recept.getExercice());
   			receptmod.setMagasin(recept.getMagasin());
   			receptmod.setRefBordLivraiRecept(recept.getRefBordLivraiRecept());
   			receptmod.setReferenceReception(recept.getReferenceReception());
   			receptmod.setValideRecep(recept.isValideRecep());
   			
   			return this.receptionRepository.save(receptmod);
       }
   		return null;
       }
    
    
	
	public EncapReception editByEncap(String id, EncapReception encap) {
		
		List<LigneReception> lignes = this.repo2.findAll();
		List<LigneReception> concernedLignes = new ArrayList<LigneReception>();
		List<LigneReception> newLignes = new ArrayList<LigneReception>();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getReception().getNumReception().equalsIgnoreCase(id)) {
				concernedLignes.add(lignes.get(i));
			}
		}
		
		for(int i = 0; i < encap.getLigneReceptions().size(); i++) {
			boolean added = true;
			LigneReception enti = null;
			
			for(int j = 0; j < concernedLignes.size(); j++) {
				if(concernedLignes.get(j).getLigneCommande().getArticle().getNumArticle() == encap.getLigneReceptions().get(i).getLigneCommande().getArticle().getNumArticle()) {
					added = false;
					enti = concernedLignes.get(j);
					break;
				}
			}
			
			LigneReception newer = encap.getLigneReceptions().get(i);
			newer.setReception(this.receptionRepository.getOne(id));
			
			if(added == true) {
				
				this.repo2.save(newer);
			}
			else {
				this.servi2.edit(newer, enti.getIdLigneReception());
			}
		}
		
		for(int i = 0; i < concernedLignes.size(); i++) {
			
			boolean removed = true;
			
			for(int j = 0; j < encap.getLigneReceptions().size(); j++) {
				if(concernedLignes.get(i).getLigneCommande().getArticle().getNumArticle() == encap.getLigneReceptions().get(j).getLigneCommande().getArticle().getNumArticle()) {
					removed = false;
					break;
				}
			}
			
			if(removed == true) {
				concernedLignes.get(i).getLigneCommande().setSatisfaite(false);
				this.servi4.edit(concernedLignes.get(i).getLigneCommande().getIdLigneCommande(), concernedLignes.get(i).getLigneCommande());
				this.repo2.deleteById(concernedLignes.get(i).getIdLigneReception());
			}			
			
		}
		
		for(int i = 0; i < encap.getLigneReceptions().size(); i++) {
			
			this.servi4.edit(encap.getLigneReceptions().get(i).getLigneCommande().getIdLigneCommande(), encap.getLigneReceptions().get(i).getLigneCommande());
			
		}
		
		lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getReception().getNumReception().equalsIgnoreCase(id)) {
				newLignes.add(lignes.get(i));
			}
		}		
		
		
		return new EncapReception(this.edit(id, encap.getReception()), newLignes);
	}
	
	
	public Reception edit3(String id, Reception reception) {
		Reception entiter = this.receptionRepository.getOne(id); 
		if(entiter != null && reception.isValideRecep() != entiter.isValideRecep()) {

			
			
			List<LigneReception> lignes = this.servi2.findAll();
			List<Stocker> listStocker = this.servi3.getAll();
			
			for(int i = 0; i < lignes.size(); i++) {
				if(lignes.get(i).getReception().getNumReception().equalsIgnoreCase(id)) {
					boolean stockerFinded = false;
					
					LigneReception ligRecept = lignes.get(i);
					
					
					
					for(int j = 0; j < listStocker.size(); j++) {
						if(listStocker.get(j).getArticle().getNumArticle() == lignes.get(i).getLigneCommande().getArticle().getNumArticle()
								&& listStocker.get(j).getMagasin().getNumMagasin() == entiter.getMagasin().getNumMagasin()) {
							stockerFinded = true;
							
							Stocker newSt = listStocker.get(j);
							
							
							
							if(reception.isValideRecep() == true) {//Pour Validation
								
								ligRecept.setLastCump(newSt.getCmup());
								double cump = ((newSt.getCmup()*newSt.getQuantiterStocker())+(lignes.get(i).getPuLigneReception()*lignes.get(i).getQuantiteLigneReception()*(1+(lignes.get(i).getLigneCommande().getTva()/100))))/(newSt.getQuantiterStocker()+lignes.get(i).getQuantiteLigneReception());
								newSt.setQuantiterStocker(newSt.getQuantiterStocker()+lignes.get(i).getQuantiteLigneReception());
								newSt.setCmup(cump);
								
							}else if(reception.isValideRecep() == false) {//Pour Annulation
								newSt.setQuantiterStocker(newSt.getQuantiterStocker()-lignes.get(i).getQuantiteLigneReception());
								newSt.setCmup(ligRecept.getLastCump());
							}
							
							
																					
							this.servi3.edit(listStocker.get(j).getIdStocker(), newSt);
							
							break;
							
						}
					}
					
										
					if(stockerFinded == false) {
						//Elément à générer en stock
						this.servi3.save(new Stocker(Long.valueOf(0), lignes.get(i).getQuantiteLigneReception(), 0, 0, lignes.get(i).getPuLigneReception(), lignes.get(i).getLigneCommande().getArticle(), lignes.get(i).getReception().getMagasin()));
					}
					
					
					
					repo2.save(ligRecept);
					
				}
			}
			
			entiter.setValideRecep(reception.isValideRecep());
			
			return this.receptionRepository.save(entiter);
		}
		
		return null;
	}
	

    
    
    
    
    // Supprimer 
    public boolean delete(String  id) {
    	if(this.receptionRepository.existsById(id))
            this.receptionRepository.deleteById(id);
    	
    	return this.receptionRepository.existsById(id);
    }  
    
    
	public boolean deleteAReception2(String id) {
		
		List<LigneReception> lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getReception().getNumReception().equalsIgnoreCase(id)) {
				lignes.get(i).getLigneCommande().setSatisfaite(false);
				this.servi4.edit(lignes.get(i).getLigneCommande().getIdLigneCommande(), lignes.get(i).getLigneCommande());
				this.repo2.deleteById(lignes.get(i).getIdLigneReception());
			}
		}
		
		return this.delete(id);
	}
    
    
    // 
    public Optional<Reception> findById(String numReception) {
        return this.receptionRepository.findById(numReception);
    }
    
    
    // Liste 
    public List<Reception> getAll() {
        return  this.receptionRepository.findAll();
    }
    
 //
    public List<Reception> findByNumReception(String NumReception){
		
		return this.receptionRepository.findByNumReception(NumReception);
	}
    
    //
    public List<Reception> findByObservation(String Observation ){
		
		return this.receptionRepository.findByObservation(Observation);
	}
    
    //
    public List<Reception> findByDateReception(Date DateReception ){
		
		return this.receptionRepository.findByDateReception(DateReception);
	}

}
