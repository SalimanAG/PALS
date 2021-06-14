package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.GroupUser;
import com.sil.gpc.repositories.GroupUserRepository;

@Service
public class GroupUserService {

	private final GroupUserRepository repo;

	public GroupUserService(GroupUserRepository repo) {
		super();
		this.repo = repo;
	}

    // Sauvegarder 
    public GroupUser save(GroupUser guser) {
    	return repo.save(guser);
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
    
    // Supprimer 
    public boolean delete(Long  id) {
    	if(this.repo.existsById(id))
            this.repo.deleteById(id);
    	
    return !this.repo.existsById(id);
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
