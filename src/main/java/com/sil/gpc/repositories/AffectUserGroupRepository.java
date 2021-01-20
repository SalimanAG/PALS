package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.AffectUserGroup;

@Repository
public interface AffectUserGroupRepository extends JpaRepository<AffectUserGroup, Long>{

}
