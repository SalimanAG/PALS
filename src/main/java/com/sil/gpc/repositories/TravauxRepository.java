package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Reception;
import com.sil.gpc.domains.Travaux;

@Repository
public interface TravauxRepository extends JpaRepository<Travaux, String> {

	
	@Query(value="SELECT valeur FROM (SELECT valeur FROM travaux WHERE num_exercice = ?1 ORDER BY valeur DESC) WHERE ROWNUM = 1"
			, nativeQuery = true)
	/*@Query(value="SELECT valeur FROM travaux WHERE num_exercice = ?1 ORDER BY valeur DESC LIMIT 1"
	, nativeQuery = true)*/
	public Integer findLastNumUsed(Long numExercice);
	
	
	@Query(value = "from Travaux as l where l.exercice.codeExercice = ?1")
	public List<Travaux> findByCodeExercice(String codeExo);
	
}
