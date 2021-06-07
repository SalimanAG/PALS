package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.CloturePeriodiq;

@Repository
public interface CloturePeriodiqRepository extends JpaRepository<CloturePeriodiq, Long> {

}
