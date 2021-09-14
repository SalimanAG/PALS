package com.sil.gpc.services;

import com.sil.gpc.domains.AffectDroitGroupUser;
import com.sil.gpc.domains.AffectUserGroup;
import com.sil.gpc.domains.Service;
import com.sil.gpc.domains.Utilisateur;

import com.sil.gpc.repositories.UtilisateurRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@org.springframework.stereotype.Service
public class UtilisateurService implements UserDetailsService{

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	private final UtilisateurRepository userRepository;
	private final AffectDroitGroupUserService droitGroupUserService;
	private final AffectUserGroupService userGroupService;

    public UtilisateurService(UtilisateurRepository userRepository, AffectUserGroupService userGroupService, AffectDroitGroupUserService droitGroupUserService) {
        this.userRepository = userRepository;
		this.droitGroupUserService = droitGroupUserService;
		this.userGroupService = userGroupService;
    }
    
    // Sauvegarder 
    public Utilisateur save(Utilisateur user) {
    	user.setMotDePass(encoder.encode(user.getMotDePass()));
        return   this.userRepository.save(user);
    }
    
    //Editer
    public Utilisateur edit(Long idUser, Utilisateur user) {     	
    	Utilisateur usermod = this.userRepository.getOne(idUser);
   		if(usermod != null) {
   			usermod.setNomUtilisateur(user.getNomUtilisateur());
   			usermod.setPrenomUtilisateur(user.getPrenomUtilisateur());
   			usermod.setLogin(user.getLogin());
   			if(usermod.isAskMdp1erLance() && user.getMotDePass()!=null && user.getMotDePass()!="") {
   				usermod.setMotDePass(user.getMotDePass());
   			}
   			usermod.setAskMdp1erLance(user.isAskMdp1erLance());
   			usermod.setActiveUtilisateur(user.isActiveUtilisateur());
   			usermod.setService(user.getService());
   			usermod.setFonction(user.getFonction());
   			usermod.setProfession(user.getProfession());
   			usermod.setCivilite(user.getCivilite());
   			usermod.setGroupUser(user.getGroupUser());
   			
   			
   			return this.userRepository.save(usermod);
       }
   		return null;
       }
    
    // Supprimer
    public boolean delete(Long  id) {
    	if(this.userRepository.existsById(id))
            this.userRepository.deleteById(id);
            
    	return this.userRepository.existsById(id);
    }  
    
    
    public Utilisateur findByLoginAndMdp(String login, String mdp) {
    	
    	List<Utilisateur> lis = userRepository.findAll();
    	
    	for(int i = 0; i < lis.size(); i++) {
    		
    		if(lis.get(i).getLogin().equals(login)) {
    			if(lis.get(i).isAskMdp1erLance()) {
    				return lis.get(i);
    			}
    			else if(lis.get(i).getMotDePass().equals(mdp)){
    				return lis.get(i);
    			}
    		}
    	}
    	
        return null;
    }
    

    // 
    public Optional<Utilisateur> findById(Long id) {
        return this.userRepository.findById(id);
    }

    // 
    public Utilisateur trouveUn(Long id) {
        return this.userRepository.getOne(id);
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
    public Utilisateur findByLoginUtilisateur(String Login){
		
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
    public List<Utilisateur> findByServiceUtilisateur(Service ServiceUser){
		
		return this.userRepository.findByService(ServiceUser);
	}
    
    public List<String> getRolesByUserLogin(Utilisateur utilisateur){
    	List<String> roles = new ArrayList<>();
    	
    	List<AffectUserGroup> affectUserGroupList = userGroupService.getAll();
    	List<AffectDroitGroupUser> affectDroitGroupUserList = droitGroupUserService.getAll();
    	
    	for (int i = 0; i < affectUserGroupList.size(); i++) {
			
    		if(affectUserGroupList.get(i).getUtilisateur().getIdUtilisateur() == utilisateur.getIdUtilisateur()) {
    			
    			for (int j = 0; j < affectDroitGroupUserList.size(); j++) {
        			
    				if(affectDroitGroupUserList.get(j).getGroupUser().getIdGroupUser() == affectUserGroupList.get(i).getGroupUser().getIdGroupUser()) {
        				
    					boolean finded = false;
    					
    					for (int k = 0; k < roles.size(); k++) {
							if(roles.get(k).equals(affectDroitGroupUserList.get(j).getDroitUser().getCodeDroitUser())) {
								
								finded = true;
								break;
							}
							
						}
    					
    					if(!finded) {
    						roles.add(affectDroitGroupUserList.get(j).getDroitUser().getCodeDroitUser());
    					}
    					
        			}
        		}
    			
    		}
    		
    		
		}
    	
    	return roles;
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Utilisateur utilisateur = userRepository.findByLogin(username);
		
		if(utilisateur == null) throw new UsernameNotFoundException("Erreur de Nom d'Utilisateur ou Mot de Passe");
		
		Collection<GrantedAuthority> authorites = new ArrayList<>();
		
		getRolesByUserLogin(utilisateur).forEach(r -> {
			authorites.add(new SimpleGrantedAuthority(r));
		});
		
		return new User(username, utilisateur.getMotDePass(), authorites);
	}
  
    
   

}
