package com.sil.gpc.services;

import com.sil.gpc.domains.LigneFactureProFormAchat;
import com.sil.gpc.domains.LigneReception;
import com.sil.gpc.domains.Reception;
import com.sil.gpc.repositories.LigneReceptionRepository;
import com.sil.gpc.repositories.ReceptionRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ReceptionService {

	private final ReceptionRepository receptionRepository;
	private final LigneReceptionRepository repo2;

    public ReceptionService(ReceptionRepository receptionRepository, LigneReceptionRepository repo2) {
        this.receptionRepository = receptionRepository;
		this.repo2 = repo2;
    }

    // Sauvegarder 
    public Reception save(Reception rep) {
    	rep.setValideRecep(true);
    	Integer val = 1, nbrMaxCaract = 6;
		String code = "RC-";
		if(this.receptionRepository.findLastNumUsed(rep.getExercice().getCodeExercice()) != null) {
			val = this.receptionRepository.findLastNumUsed(rep.getExercice().getCodeExercice());
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
