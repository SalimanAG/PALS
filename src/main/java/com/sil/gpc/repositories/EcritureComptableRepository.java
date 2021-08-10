package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.EcritureComptable;

@Repository
public interface EcritureComptableRepository extends JpaRepository<EcritureComptable, Long> {

}
