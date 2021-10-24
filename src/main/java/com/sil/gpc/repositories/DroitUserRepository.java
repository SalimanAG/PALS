package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.DroitUser;

@Repository
public interface DroitUserRepository extends JpaRepository<DroitUser, Long> {

	List<DroitUser> findByIdDroitUser(Long idDroitUser);
	List<DroitUser> findByCodeDroitUser(String codeDroitUser);
	List<DroitUser> findByLibDroitUser(String libDroitUser);
	
	@Query(value="SELECT droit_user.id_droit_user, droit_user.code_droit_user, droit_user.descri_droit_user,\n" +
			"droit_user.lib_droit_user FROM affect_droit_group_user, group_user, droit_user\n" +
			" WHERE  affect_droit_group_user.num_group_user = group_user.num_group_user AND\n" +
			" droit_user.id_droit_user = affect_droit_group_user.id_droit_user AND group_user.num_group_user = ?1"
			, nativeQuery = true)
	List<DroitUser> finAllDroitUserForGroupUser(Long id);
	
}
