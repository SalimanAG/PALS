package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.DemandePrix;

@Repository
public interface DemandePrixRepository extends JpaRepository<DemandePrix, String> {

}
