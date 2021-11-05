package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.LigneReception;

@Repository
public interface LigneReceptionRepository extends JpaRepository<LigneReception, Long>{

	/*List<LigneReception> findByQuantiteLigneReception(double qte);
	List<LigneReception> findByPULigneReception(double prix);*/
	
	@Query(value="FROM LigneReception as l WHERE l.ligneCommande.numCommande.numCommande = ?1"
			, nativeQuery = false)
	public List<LigneReception> findByNumCommande(Long numCommande);

	
}
