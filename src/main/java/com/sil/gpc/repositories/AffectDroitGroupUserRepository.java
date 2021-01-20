package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.AffectDroitGroupUser;

@Repository
public interface AffectDroitGroupUserRepository extends JpaRepository<AffectDroitGroupUser, Long>{

}
