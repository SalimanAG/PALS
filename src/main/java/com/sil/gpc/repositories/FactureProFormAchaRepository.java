package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.FactureProFormAcha;

@Repository
public interface FactureProFormAchaRepository extends JpaRepository<FactureProFormAcha, String> {

	/*@Query(value="SELECT valeur FROM (SELECT valeur FROM facture_pro_form_acha WHERE num_exercice = ?1 ORDER BY valeur DESC) WHERE ROWNUM = 1"
			, nativeQuery = true)*/
	@Query(value="SELECT valeur FROM facture_pro_form_acha WHERE num_exercice = ?1 ORDER BY valeur DESC LIMIT 1"
	, nativeQuery = true)
	public Integer findLastNumUsed(Long numExercice);
	
	
}
