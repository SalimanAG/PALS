package com.sil.gpc.services;

import com.sil.gpc.domains.Service;
import com.sil.gpc.domains.Utilisateur;

import com.sil.gpc.repositories.UtilisateurRepository;
import java.util.List;
import java.util.Optional;

public class UtilisateurService {

	private final UtilisateurRepository userRepository;

    public UtilisateurService(UtilisateurRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // Sauvegarder 
    public Utilisateur save(Utilisateur user) {
        return   this.userRepository.save(user);
    }
    
    //Editer
    public Utilisateur edit(Long idUser, Utilisateur user) {
       	
    	Utilisateur usermod = this.userRepository.getOne(idUser);
   		if(usermod != null) {
   			usermod.setIdUtilisateur(user.getIdUtilisateur());
   			usermod.setNomUtilisateur(user.getNomUtilisateur());
   			usermod.setPrenomUtilisateur(user.getPrenomUtilisateur());
   			usermod.setLogin(user.getLogin());
   			usermod.setMotDePass(user.getMotDePass());
   			usermod.setActiveUtilisateur(user.isActiveUtilisateur());
   			usermod.setFonctionUtilisateur(user.getFonctionUtilisateur());
   			usermod.setCodeService(user.getCodeService());
   			return this.userRepository.save(usermod);
       }
   		return null;
       }
    
    // Supprimer
    public void delete(Long  id) {
    	if(this.userRepository.existsById(id))
            this.userRepository.deleteById(id);
    }   

    
    // 
    public Optional<Utilisateur> findById(Long id) {
        return this.userRepository.findById(id);
    }
    
    
    // Liste 
    public List<Utilisateur> getAll() {
        return  this.userRepository.findAll();
    }
    
    //
    public List<Utilisateur> findByIdUtilisateur(Long IdUser){
		
		return this.userRepository.findByIdUtilisateur(IdUser);
	}
    
    //
    public List<Utilisateur> findByActiveUtilisateur(boolean ActiveUser){
		
		return this.userRepository.findByActiveUtilisateur(ActiveUser);
	}
  
    //
    public List<Utilisateur> findByLoginUtilisateur(Long Login){
		
		return this.userRepository.findByLogin(Login);
	}
    
    //
    public List<Utilisateur> findByNomUtilisateur(Long NomUser){
		
		return this.userRepository.findByNomUtilisateur(NomUser);
	}
    
    //
    public List<Utilisateur> findByPrenomUtilisateur(Long PrenomUser){
		
		return this.userRepository.findByPrenomUtilisateur(PrenomUser);
	}
    
    //
    public List<Utilisateur> findByFonctionUtilisateur(Long FonctionUser){
		
		return this.userRepository.findByFonctionUtilisateur(FonctionUser);
	}
    
    //
    public List<Utilisateur> findByServiceUtilisateur(Service ServiceUser){
		
		return this.userRepository.findByServiceUtilisateur(ServiceUser);
	}
  
    
   

}
