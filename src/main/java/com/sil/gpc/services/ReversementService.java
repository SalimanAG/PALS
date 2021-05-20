package com.sil.gpc.services;

import com.sil.gpc.domains.Reversement;

import com.sil.gpc.repositories.ReversementRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ReversementService {

	private final ReversementRepository reversementRepository;

    public ReversementService(ReversementRepository reversementRepository) {
        this.reversementRepository = reversementRepository;
    }
    
 // Sauvegarder 
    public Reversement save(Reversement rev) {
    	rev.setValideReve(true);
    	
    	Integer val = 1, nbrMaxCaract = 6;
		String code = "RV-";
		if(this.reversementRepository.findLastNumUsed(rev.getExercice().getCodeExercice()) != null) {
			val = this.reversementRepository.findLastNumUsed(rev.getExercice().getCodeExercice());
			val++;
			
		}
		
		rev.setValeur(val);
		
		code = code+rev.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		rev.setNumReversement(code+val);
		
		if(reversementRepository.existsById(rev.getNumReversement())==false) return   this.reversementRepository.save(rev);
		
		return null;

    }
    
    //Editer
    public Reversement edit(String numReversement, Reversement revers) {
       	
    	Reversement revertmod = this.reversementRepository.getOne(numReversement);
   		if(revertmod != null) {
   			revertmod.setNumReversement(revers.getNumReversement());
   			revertmod.setDateVersement(revers.getDateVersement());
   			revertmod.setValideReve(revers.isValideReve());
   			return this.reversementRepository.save(revertmod);
       }
   		return null;
       }
    
    
    // Supprimer 
    public boolean delete(String  id) {
    		if(this.reversementRepository.existsById(id))
            this.reversementRepository.deleteById(id);
    	
    	return this.reversementRepository.existsById(id);
    }   
    
    // 
    public Optional<Reversement> findById(String numReversement) {
        return this.reversementRepository.findById(numReversement);
    }
    

    // Liste 
    public List<Reversement> getAll() {
        return  this.reversementRepository.findAll();
    }
    
    //
    public List<Reversement> findByNumReversement(String NumReversement){
		
		return this.reversementRepository.findByNumReversement(NumReversement);
	}

    //
    public List<Reversement> findByDateReversement(Date DateReversement){
		
		return this.reversementRepository.findByDateVersement(DateReversement);
	}
    
    
 
    

}
