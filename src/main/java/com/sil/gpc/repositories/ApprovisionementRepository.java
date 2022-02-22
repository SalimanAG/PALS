package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.Exercice;

@Repository
public interface ApprovisionementRepository extends JpaRepository<Approvisionnement, String>{

	public List<Approvisionnement> findByNumAppro(String numAppro);
	
	
	public List<Approvisionnement> findByExercice(Exercice exercice);
	
	@Query(value = "from Approvisionnement as l where l.exercice.codeExercice = ?1")
	public List<Approvisionnement> findByCodeExercice(String codeExo);
	
	public List<Approvisionnement> findByDateAppro(Date dateAppro);
	
	public List<Approvisionnement> findByDescriptionAppro(String descriptionAppro);
	
	@Query(value="SELECT valeur FROM (SELECT valeur FROM approvisionnement WHERE num_exercice = ?1 ORDER BY valeur DESC) WHERE ROWNUM = 1"
			, nativeQuery = true)
	/*@Query(value="SELECT valeur FROM approvisionnement WHERE num_exercice = ?1 ORDER BY valeur DESC LIMIT 1"
	, nativeQuery = true)*/
	public Integer findLastNumUsed(Long numExercice);
	
}
