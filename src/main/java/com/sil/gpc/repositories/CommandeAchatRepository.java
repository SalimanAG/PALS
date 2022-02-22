package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.CommandeAchat;

@Repository
public interface CommandeAchatRepository extends JpaRepository<CommandeAchat, String> {

	@Query(value="SELECT valeur FROM (SELECT valeur FROM commande_achat WHERE num_exercice = ?1 ORDER BY valeur DESC) WHERE ROWNUM = 1"
			, nativeQuery = true)
	/*@Query(value="SELECT valeur FROM commande_achat WHERE num_exercice = ?1 ORDER BY valeur DESC LIMIT 1"
	, nativeQuery = true)*/
	public Integer findLastNumUsed(Long numExercice);
	
	@Query(value = "from CommandeAchat as l where l.exercice.codeExercice = ?1")
	public List<CommandeAchat> findByCodeExercice(String codeExo);
	
	
}
