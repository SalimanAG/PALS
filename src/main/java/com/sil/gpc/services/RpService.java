package com.sil.gpc.services;

import com.sil.gpc.domains.TresCom;

import com.sil.gpc.repositories.RpRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class RpService {

	private final RpRepository rpRepository;

    public RpService(RpRepository rpRepository) {
        this.rpRepository = rpRepository;
    }

    
    // Sauvegarder
    public TresCom save(TresCom receptPercep) {
        return   this.rpRepository.save(receptPercep);
    }
    
  //Editer
    public TresCom edit(String idRp, TresCom recepPercept) {
       	
    	TresCom rpmod = this.rpRepository.getOne(idRp);
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
    public Optional<TresCom> findById(String idRp) {
        return this.rpRepository.findById(idRp);
    }
    
    // Liste 
    public List<TresCom> getAll() {
        return  this.rpRepository.findAll();
    }
    
    
    //
    public List<TresCom> findByIdrp(String idRp){
		
		return this.rpRepository.findByIdRp(idRp);
	}

    
   

}
