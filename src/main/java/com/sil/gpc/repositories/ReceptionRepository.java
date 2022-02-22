
package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Inventaire;
import com.sil.gpc.domains.LigneReception;
import com.sil.gpc.domains.Reception;

@Repository
public interface ReceptionRepository extends JpaRepository<Reception, String> {
	
	public List<Reception> findByNumReception(String NumReception);
	
	public List<Reception> findByObservation(String Observation);
	
	public List<Reception> findByDateReception(Date DateReception);

	@Query(value="SELECT valeur FROM (SELECT valeur FROM reception WHERE num_exercice = ?1 ORDER BY valeur DESC) WHERE ROWNUM = 1"
			, nativeQuery = true)
	
	/*@Query(value="SELECT valeur FROM reception WHERE num_exercice = ?1 ORDER BY valeur DESC LIMIT 1"
			, nativeQuery = true)*/
	public Integer findLastNumUsed(Long numExercice);
	
	@Query(value = "from Reception as l where l.exercice.codeExercice = ?1")
	public List<Reception> findByCodeExercice(String codeExo);
	
	
}
