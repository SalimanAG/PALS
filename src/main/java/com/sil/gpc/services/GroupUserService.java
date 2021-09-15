package com.sil.gpc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.AffectDroitGroupUser;
import com.sil.gpc.domains.AffectUserGroup;
import com.sil.gpc.domains.GroupUser;
import com.sil.gpc.domains.Utilisateur;
import com.sil.gpc.encapsuleurs.EncapGroupeDroits;
import com.sil.gpc.encapsuleurs.EncapUserGroupes;
import com.sil.gpc.repositories.AffectDroitGroupUserRepository;
import com.sil.gpc.repositories.GroupUserRepository;

@Service
public class GroupUserService {

	private final GroupUserRepository repo;
	private final AffectDroitGroupUserRepository affectDroitGroupUserRepository;

	public GroupUserService(GroupUserRepository repo, AffectDroitGroupUserRepository affectDroitGroupUserRepository) {
		super();
		this.repo = repo;
		this.affectDroitGroupUserRepository = affectDroitGroupUserRepository;
	}

    // Sauvegarder 
    public GroupUser save(GroupUser guser) {
    	return repo.save(guser);
    }
    
	public EncapGroupeDroits save2(EncapGroupeDroits encapGroupeDroits) {
	    	
	    	GroupUser groupUser = save(encapGroupeDroits.getGroupUser());
	    	
	    	List<AffectDroitGroupUser> affectDroitGroupUsers = new ArrayList<>();
	    	
	    	encapGroupeDroits.getDroitUsers().forEach(r->{
	    		affectDroitGroupUsers.add(new AffectDroitGroupUser(r, groupUser));
	    	});
	    	
	    	affectDroitGroupUserRepository.saveAll(affectDroitGroupUsers);
	    	
	    	return new EncapGroupeDroits(groupUser, encapGroupeDroits.getDroitUsers());
	 }
    
    // Editer 
    public GroupUser edit(Long id, GroupUser guser) {
       	if(repo.existsById(id)) {
   			GroupUser por=repo.getOne(id);
   			por.setIdGroupUser(guser.getIdGroupUser());
   			por.setLibGroupUser(guser.getLibGroupUser());
   			return this.repo.save(por);
       }
   		return null;
       }
    
    public EncapGroupeDroits edit2(Long id, EncapGroupeDroits encapGroupeDroits) {
    	
    	GroupUser groupUser = edit(id, encapGroupeDroits.getGroupUser());
    	
    	List<AffectDroitGroupUser> oldAffectDroitGroupUsers = affectDroitGroupUserRepository.findAll();
    	
    	encapGroupeDroits.getDroitUsers().forEach(r -> {
    		
    		boolean newer = true;
    		
    		for (int i = 0; i < oldAffectDroitGroupUsers.size(); i++) {
				
    			if(r.getIdDroitUser().equals(oldAffectDroitGroupUsers.get(i).getDroitUser().getIdDroitUser())
    					&& oldAffectDroitGroupUsers.get(i).getGroupUser().getNumGroupUser().equals(groupUser.getNumGroupUser())) {
    				newer = false;
    				break;
    			}
    			
    			if(newer) {
    				affectDroitGroupUserRepository.save(new AffectDroitGroupUser(r, groupUser));
    			}
    			
			}
    		
    	});
    	
    	oldAffectDroitGroupUsers.forEach(r -> {
    		
    		boolean retenu = false;
    		
    		for (int i = 0; i < encapGroupeDroits.getDroitUsers().size(); i++) {
				if(r.getGroupUser().getNumGroupUser().equals(groupUser.getNumGroupUser()) 
						&& r.getDroitUser().getIdDroitUser().equals(encapGroupeDroits.getDroitUsers().get(i).getIdDroitUser())) {
					
					retenu = true;
					break;
				}
			}
    		
    		if(!retenu) {
    			affectDroitGroupUserRepository.deleteById(r.getIdAffectDroitGroup());
    		}
    		
    	});
    	
    	
    	return new EncapGroupeDroits(groupUser, encapGroupeDroits.getDroitUsers());
    }

    
    // Supprimer 
    public boolean delete(Long  id) {
    	if(this.repo.existsById(id))
            this.repo.deleteById(id);
    	
    return !this.repo.existsById(id);
    }
    
    public boolean delete2(Long id) {
    	
    	List<AffectDroitGroupUser> affectDroitGroupUsers = affectDroitGroupUserRepository.findAll();
    	
    	affectDroitGroupUsers.forEach(r -> {
    		if(r.getGroupUser().getNumGroupUser().equals(id)) {
    			affectDroitGroupUserRepository.delete(r);
    		}
    	});
    	
    	delete(id);
    	
    	return !affectDroitGroupUserRepository.existsById(id);
    }

    
    // 
    public Optional<GroupUser> findById(Long id) {
        return this.repo.findById(id);
    }
    
    // 
    public List<GroupUser> findByLib(String lib) {
        return this.repo.findByLibGroupUser(lib);
    }
   
    // Liste 
    public List<GroupUser> getAll() {
        return  this.repo.findAll();
    }
    
}
