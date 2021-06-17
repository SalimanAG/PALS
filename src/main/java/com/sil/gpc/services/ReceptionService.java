package com.sil.gpc.services;

import com.sil.gpc.domains.LigneAppro;
import com.sil.gpc.domains.LigneFactureProFormAchat;
import com.sil.gpc.domains.LigneReception;
import com.sil.gpc.domains.Reception;
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

    public ReceptionService(ReceptionRepository receptionRepository, LigneReceptionRepository repo2, LigneReceptionService servi2) {
        this.receptionRepository = receptionRepository;
		this.repo2 = repo2;
		this.servi2 = servi2;
    }

    // Sauvegarder 
    public Reception save(Reception rep) {
    	rep.setValideRecep(true);
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
			if(lignes.get(i).getReception().getNumReception() == id) {
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
				this.repo2.deleteById(concernedLignes.get(i).getIdLigneReception());
			}			
			
		}
		
		lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getReception().getNumReception() == id) {
				newLignes.add(lignes.get(i));
			}
		}
		
		
		return new EncapReception(this.edit(id, encap.getReception()), newLignes);
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
			if(lignes.get(i).getReception().getNumReception() == id) {
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
