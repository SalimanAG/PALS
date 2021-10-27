package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.LettreCommande;

@Repository
public interface LettreCommandeRepository extends JpaRepository<LettreCommande, String> {

	@Query(value="SELECT valeur FROM (SELECT valeur FROM lettre_commande WHERE num_exercice = ?1 ORDER BY valeur DESC) WHERE ROWNUM = 1;"
			, nativeQuery = true)
	public Integer findLastNumUsed(Long numExercice);
	
	
}
