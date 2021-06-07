package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.FactureProFormAcha;

@Repository
public interface FactureProFormAchaRepository extends JpaRepository<FactureProFormAcha, String> {

}
