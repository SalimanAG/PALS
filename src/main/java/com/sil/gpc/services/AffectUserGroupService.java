package com.sil.gpc.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.AffectUserGroup;
import com.sil.gpc.domains.GroupUser;
import com.sil.gpc.domains.Utilisateur;
import com.sil.gpc.repositories.AffectUserGroupRepository;

@Service
public class AffectUserGroupService {

	private final AffectUserGroupRepository repo;

	public AffectUserGroupService(AffectUserGroupRepository repo) {
		super();
		this.repo = repo;
	}

    // Sauvegarder 
    public AffectUserGroup save(AffectUserGroup guser) {
    	return repo.save(guser);
    }
    
    // Editer 
    public AffectUserGroup edit(Long id, AffectUserGroup guser) {
       	if(repo.existsById(id)) {
   			AffectUserGroup por=repo.getOne(id);
   			por.setUtilisateur(guser.getUtilisateur());
   			por.setGroupUser(guser.getGroupUser());
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
    public Optional<AffectUserGroup> findById(Long id) {
        return this.repo.findById(id);
    }
    
    // 
    public List<AffectUserGroup> findByGroups(GroupUser g) {
        return this.repo.findByGroupUser(g);
    }
    
    // 
    public List<AffectUserGroup> findByUser(Utilisateur u) {
        return this.repo.findByUtilisateur(u);
    }
   
    // Liste 
    public List<AffectUserGroup> getAll() {
        return  this.repo.findAll();
    }
    
    public  List<GroupUser> getAllGroupUserForUser(Long idUser){
	    System.out.println();
        List<GroupUser> groupUserList= new ArrayList<>();
        this.repo.finAllGroupeUserForUser(idUser).forEach(
                a -> {
                    Object[] b = (Object[]) a;
                    GroupUser gp = new GroupUser((String) b[1], (String) b[2] );
                    gp.setNumGroupUser(((BigInteger) b[0]).longValue());
                    groupUserList.add(gp);
                }
        );
	    return  groupUserList;
    }
    
}
