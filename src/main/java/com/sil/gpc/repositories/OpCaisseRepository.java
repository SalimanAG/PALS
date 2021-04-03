package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.OpCaisse;

@Repository
public interface OpCaisseRepository extends JpaRepository<OpCaisse, String>{

	List<OpCaisse> findByCaisse(String codCai);
	List<OpCaisse> findByContribuable(String contribuable);
	List<OpCaisse> findByDateOpCaisse(Date dateOpCaisse);
	List<OpCaisse> findByModePaiement(String CodMP);
	List<OpCaisse> findByTypeRecette(String codTR);
	
	
	@Query(value="SELECT valeur FROM op_caisse WHERE code_caisse = ?1 AND code_exercice = ?2 ORDER BY valeur DESC LIMIT 1;"
			, nativeQuery = true)
	Integer findLastNumUsed(String codeCai, String codeExo);

	
}
