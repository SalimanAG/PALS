package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.LettreCommande;

@Repository
public interface LettreCommandeRepository extends JpaRepository<LettreCommande, String> {

}
