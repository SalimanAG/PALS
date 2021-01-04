package com.sil.gpc.services;


import com.sil.gpc.domains.TypeRecette;

import com.sil.gpc.repositories.TypeRecetteRepository;
import java.util.List;
import java.util.Optional;

public class TypeRecetteService {

	// @Autowired
    private final TypeRecetteRepository typeRecetteRepository;

    public TypeRecetteService(TypeRecetteRepository typeRecetteRepository) {
    	super();
        this.typeRecetteRepository = typeRecetteRepository;
    }

    
 // Sauvegarder un TypeRecette
    public TypeRecette save(TypeRecette typeRecette) {
        return   this.typeRecetteRepository.save(typeRecette);
    }
    
    // Editer un TypeRecette
    public TypeRecette edit(String id,TypeRecette typeRecette) {
    	
    	TypeRecette typeRecettemod = this.typeRecetteRepository.getOne(id);
		if(typeRecettemod != null) {
			typeRecettemod.setCodeTypRec(typeRecette.getCodeTypRec());
			typeRecettemod.setCodeTypRec(typeRecette.getLibeTypRec());
			
			return this.typeRecetteRepository.save(typeRecettemod);
    }
		return null;
    }
    
 // Supprimer un TypeRecette
    public void delete(String id) {
    	if(this.typeRecetteRepository.existsById(id))
			this.typeRecetteRepository.deleteById(id);
    }   
    
 // Renvoie un TypeRecette par son code
    public  Optional <TypeRecette>findById(String codeTypRec) {
    	return this.typeRecetteRepository.findById(codeTypRec);
    }
    
    // Liste des TypeRecette
    public List<TypeRecette> getAll() {
        return  this.typeRecetteRepository.findAll();
    }
    
    
    //liste par code
	public List<TypeRecette> findByCodeTypeRecette(String CodeTypeRecette){
		
		return this.typeRecetteRepository.findByCodeTypeRecette(CodeTypeRecette);
	}
	
	//liste par libelle
	public List<TypeRecette> findByLibelleTypeRecette(String LibelleTypeRecette){
		
		return this.typeRecetteRepository.findByLibelleTypRec(LibelleTypeRecette);
	}

}
