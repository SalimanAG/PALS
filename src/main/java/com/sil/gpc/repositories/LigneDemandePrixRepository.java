package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.LigneDemandePrix;

@Repository
public interface LigneDemandePrixRepository extends JpaRepository<LigneDemandePrix, Long> {

}
