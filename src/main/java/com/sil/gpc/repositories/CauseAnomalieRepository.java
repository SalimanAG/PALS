package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.CauseAnomalie;

@Repository
public interface CauseAnomalieRepository extends JpaRepository<CauseAnomalie, Long> {

}
