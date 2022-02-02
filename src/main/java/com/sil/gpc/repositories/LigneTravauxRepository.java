package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.LigneTravaux;

@Repository
public interface LigneTravauxRepository extends JpaRepository<LigneTravaux, Long> {

}
