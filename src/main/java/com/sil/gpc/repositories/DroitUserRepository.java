package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.DroitUser;

@Repository
public interface DroitUserRepository extends JpaRepository<DroitUser, Long> {

	
}
