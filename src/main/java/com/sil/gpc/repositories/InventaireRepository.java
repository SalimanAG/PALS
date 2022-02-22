package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.DemandeApprovisionnement;
import com.sil.gpc.domains.Inventaire;

@Repository
public interface InventaireRepository extends JpaRepository<Inventaire, String>{

	@Query(value="SELECT valeur FROM (SELECT valeur FROM inventaire WHERE num_exercice = ?1 ORDER BY valeur DESC) WHERE ROWNUM = 1"
			, nativeQuery = true)
	/*@Query(value="SELECT valeur FROM inventaire WHERE num_exercice = ?1 ORDER BY valeur DESC LIMIT 1"
			, nativeQuery = true)*/
	Integer findLastNumUsed(Long numExercice);
	
	
	@Query(value = "from Inventaire as l where l.exercice.codeExercice = ?1")
	public List<Inventaire> findByCodeExercice(String codeExo);
	
}
