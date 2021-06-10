package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.CategorieFrs;

@Repository
public interface CategorieFrsRepository extends JpaRepository<CategorieFrs, Long> {

}
