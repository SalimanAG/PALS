package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Civilite;

@Repository
public interface CiviliteRepository extends JpaRepository<Civilite, Long> {

}
