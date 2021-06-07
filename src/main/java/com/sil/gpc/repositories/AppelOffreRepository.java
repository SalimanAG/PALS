package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.AppelOffre;

@Repository
public interface AppelOffreRepository extends JpaRepository<AppelOffre, String> {

}
