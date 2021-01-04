package com.sil.gpc.services;

import com.sil.gpc.domains.Rp;

import com.sil.gpc.repositories.RpRepository;
import java.util.List;
import java.util.Optional;

public class RpService {

	private final RpRepository rpRepository;

    public RpService(RpRepository rpRepository) {
        this.rpRepository = rpRepository;
    }

    
    // Sauvegarder
    public Rp save(Rp receptPercep) {
        return   this.rpRepository.save(receptPercep);
    }
    
  //Editer
    public Rp edit(String idRp, Rp recepPercept) {
       	
    	Rp rpmod = this.rpRepository.getOne(idRp);
   		if(rpmod != null) {
   			rpmod.setIdRp(recepPercept.getIdRp());
   			rpmod.setMagasinier(recepPercept.getMagasinier());
   			rpmod.setUtilisateur(recepPercept.getUtilisateur());
   			return this.rpRepository.save(rpmod);
       }
   		return null;
       }
    
    // Supprimer 
    public boolean delete(String  id) {
    	if(this.rpRepository.existsById(id))
            this.rpRepository.deleteById(id);
    	
            return this.rpRepository.existsById(id);
    }   
    
    // 
    public Optional<Rp> findById(String idRp) {
        return this.rpRepository.findById(idRp);
    }
    
    // Liste 
    public List<Rp> getAll() {
        return  this.rpRepository.findAll();
    }
    
    
    //
    public List<Rp> findByIdrp(String idRp){
		
		return this.rpRepository.findByIdRp(idRp);
	}

    
   

}
