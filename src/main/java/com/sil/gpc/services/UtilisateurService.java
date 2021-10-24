package com.sil.gpc.services;

import com.sil.gpc.domains.AffectDroitGroupUser;
import com.sil.gpc.domains.AffectUserGroup;
import com.sil.gpc.domains.Service;
import com.sil.gpc.domains.Utilisateur;
import com.sil.gpc.encapsuleurs.EncapUserGroupes;
import com.sil.gpc.repositories.AffectDroitGroupUserRepository;
import com.sil.gpc.repositories.AffectUserGroupRepository;
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
	private final AffectUserGroupRepository affectUserGroupRepository;

    public UtilisateurService(UtilisateurRepository userRepository, AffectUserGroupService userGroupService, AffectDroitGroupUserService droitGroupUserService, AffectUserGroupRepository affectUserGroupRepository) {
        this.userRepository = userRepository;
		this.droitGroupUserService = droitGroupUserService;
		this.userGroupService = userGroupService;
		this.affectUserGroupRepository = affectUserGroupRepository;
    }
    
    // Sauvegarder 
    public Utilisateur save(Utilisateur user) {
    	//user.setMotDePass(encoder.encode(user.getMotDePass()));
    	user.setMotDePass(null);
        return   this.userRepository.save(user);
    }
    
    public EncapUserGroupes save2(EncapUserGroupes encapUserGroupes) {
    	
    	Utilisateur utilisateur = save(encapUserGroupes.getUtilisateur());
    	
    	List<AffectUserGroup> affectUserGroups = new ArrayList<>();
    	
    	encapUserGroupes.getGroupUsers().forEach(r->{
    		affectUserGroups.add(new AffectUserGroup(utilisateur, r));
    	});
    	
    	affectUserGroupRepository.saveAll(affectUserGroups);
    	
    	return new EncapUserGroupes(utilisateur, encapUserGroupes.getGroupUsers());
    }
    
    public List<Utilisateur> save3(List<Utilisateur> utilisateurs) {
    	
    	utilisateurs.forEach(r -> {
    		//r.setMotDePass(encoder.encode(r.getMotDePass()));
    		r.setMotDePass(null);
    	});
    	
        return   this.userRepository.saveAll(utilisateurs);
    }
    
    //Editer
    public Utilisateur edit(Long idUser, Utilisateur user) {     	
    	Utilisateur usermod = this.userRepository.getOne(idUser);
   		if(usermod != null) {
   			usermod.setNomUtilisateur(user.getNomUtilisateur());
   			usermod.setPrenomUtilisateur(user.getPrenomUtilisateur());
   			usermod.setLogin(user.getLogin());
   			if(usermod.isAskMdp1erLance() && user.getMotDePass()!=null && user.getMotDePass()!="") {
   				usermod.setMotDePass(encoder.encode(user.getMotDePass()));
   			}
   			usermod.setAskMdp1erLance(user.isAskMdp1erLance());
   			usermod.setActiveUtilisateur(user.isActiveUtilisateur());
   			usermod.setService(user.getService());
   			usermod.setFonction(user.getFonction());
   			usermod.setProfession(user.getProfession());
   			usermod.setCivilite(user.getCivilite());
   			
   			usermod.setAccesChildService(user.isAccesChildService());
   			usermod.setMagasins(user.getMagasins());
   			
   			return this.userRepository.save(usermod);
       }
   		return null;
       }
    
    public EncapUserGroupes edit2(Long id, EncapUserGroupes encapUserGroupes) {
    	
    	Utilisateur utilisateur = edit(id, encapUserGroupes.getUtilisateur());
    	
    	List<AffectUserGroup> oldAffectUserGroups = affectUserGroupRepository.findAll();
    	
    	encapUserGroupes.getGroupUsers().forEach(r -> {
    		
    		boolean newer = true;
    		
    		for (int i = 0; i < oldAffectUserGroups.size(); i++) {
				
    			if(r.getNumGroupUser().equals(oldAffectUserGroups.get(i).getGroupUser().getNumGroupUser())
    					&& oldAffectUserGroups.get(i).getUtilisateur().getIdUtilisateur().equals(utilisateur.getIdUtilisateur())) {
    				newer = false;
    				break;
    			}
    			    			
			}
    		
    		if(newer) {
				affectUserGroupRepository.save(new AffectUserGroup(utilisateur, r));
			}
    		
    	});
    	
    	oldAffectUserGroups.forEach(r -> {
    		
    		if(r.getUtilisateur().getIdUtilisateur().equals(id)) {
    			boolean retenu = false;
        		
        		for (int i = 0; i < encapUserGroupes.getGroupUsers().size(); i++) {
    				if(r.getUtilisateur().getIdUtilisateur().equals(utilisateur.getIdUtilisateur()) 
    						&& r.getGroupUser().getNumGroupUser().equals(encapUserGroupes.getGroupUsers().get(i).getNumGroupUser())) {
    					
    					retenu = true;
    					break;
    				}
    			}
        		
        		if(!retenu) {
        			affectUserGroupRepository.deleteById(r.getIdAffectUserGroup());
        		}
    		}
    		
    	});
    	
    	
    	return new EncapUserGroupes(utilisateur, encapUserGroupes.getGroupUsers());
    }
    
    
    // Supprimer
    public boolean delete(Long  id) {
    	if(this.userRepository.existsById(id))
            this.userRepository.deleteById(id);
            
    	return this.userRepository.existsById(id);
    }  
    
    public boolean delete2(Long id) {
    	
    	List<AffectUserGroup> affectUserGroups = affectUserGroupRepository.findAll();
    	
    	affectUserGroups.forEach(r -> {
    		if(r.getUtilisateur().getIdUtilisateur().equals(id)) {
    			affectUserGroupRepository.delete(r);
    		}
    	});
    	
    	delete(id);
    	
    	return !userRepository.existsById(id);
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
    	//System.out.println("**********login : "+Login);
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
    	
    	//System.out.println(affectUserGroupList+" **** "+affectDroitGroupUserList+"\n *** "+utilisateur);
    	
    	for (int i = 0; i < affectUserGroupList.size(); i++) {
    		//System.out.println(affectUserGroupList.get(i).getUtilisateur().getIdUtilisateur() +" == "+ utilisateur.getIdUtilisateur());
    		//System.out.println(affectUserGroupList.get(i).getUtilisateur().getIdUtilisateur().equals(utilisateur.getIdUtilisateur()) );
    		if(affectUserGroupList.get(i).getUtilisateur().getIdUtilisateur().equals(utilisateur.getIdUtilisateur())) {
    			//System.out.println(affectUserGroupList.get(i).getUtilisateur().getIdUtilisateur() == utilisateur.getIdUtilisateur());
    			for (int j = 0; j < affectDroitGroupUserList.size(); j++) {
        			
    				if(affectDroitGroupUserList.get(j).getGroupUser().getNumGroupUser().equals(affectUserGroupList.get(i).getGroupUser().getNumGroupUser())) {
        				
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
