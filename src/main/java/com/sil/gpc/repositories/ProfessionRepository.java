package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Profession;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession, Long> {

}
