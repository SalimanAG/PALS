package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.GroupUser;

@Repository
public interface GroupUserRepository extends JpaRepository<GroupUser, Long> {
	
	List<GroupUser> findByLibGroupUser(String libGroupUser);
	List<GroupUser> findByIdGroupUser(String idGroupUser);

	@Query(value="SELECT group_user.num_group_user, group_user.id_group_user, group_user.lib_group_user  FROM affect_user_group, group_user, utilisateur\n" +
			" WHERE  affect_user_group.id_utilisateur = utilisateur.id_utilisateur AND \n" +
			" group_user.num_group_user = affect_user_group.num_group_user AND utilisateur.id_utilisateur = ?1"
			, nativeQuery = true)
	List<GroupUser> finAllGroupeUserForUser(Long id);
	
}
