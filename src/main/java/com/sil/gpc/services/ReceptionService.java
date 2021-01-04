package com.sil.gpc.services;

import com.sil.gpc.domains.Reception;

import com.sil.gpc.repositories.ReceptionRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public class ReceptionService {

	private final ReceptionRepository receptionRepository;

    public ReceptionService(ReceptionRepository receptionRepository) {
        this.receptionRepository = receptionRepository;
    }

    
    // Sauvegarder 
    public Reception save(Reception rep) {
        return   this.receptionRepository.save(rep);
    }
    
    // Editer 
    public Reception edit(String numReception, Reception recept) {
       	
    	Reception receptmod = this.receptionRepository.getOne(numReception);
   		if(receptmod != null) {
   			receptmod.setNumReception(recept.getNumReception());
   			receptmod.setObservation(recept.getObservation());
   			receptmod.setDateReception(recept.getDateReception());
   			return this.receptionRepository.save(receptmod);
       }
   		return null;
       }
    
    // Supprimer 
    public boolean delete(String  id) {
            this.receptionRepository.deleteById(id);
    	
    	if(this.receptionRepository.existsById(id)) return false; else return true;
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
