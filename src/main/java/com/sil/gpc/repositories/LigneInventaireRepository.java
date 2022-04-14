package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.LigneInventaire;

@Repository
public interface LigneInventaireRepository extends JpaRepository<LigneInventaire, Long>{
	
	@Query(value="FROM LigneInventaire as l WHERE l.inventaire.numInv = ?1"
			, nativeQuery = false)
	public List<LigneInventaire> findByCodeInventaire(String codeInventaire);
	
}
