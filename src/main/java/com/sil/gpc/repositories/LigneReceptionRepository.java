package com.sil.gpc.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.LigneInventaire;
import com.sil.gpc.domains.LigneReception;

@Repository
public interface LigneReceptionRepository extends JpaRepository<LigneReception, Long>{

	/*List<LigneReception> findByQuantiteLigneReception(double qte);
	List<LigneReception> findByPULigneReception(double prix);*/
	
	@Query(value="FROM LigneReception as l WHERE l.ligneCommande.numCommande.numCommande = ?1"
			, nativeQuery = false)
	public List<LigneReception> findByNumCommande(Long numCommande);
	
	
	@Query(value="FROM LigneReception as l WHERE l.reception.numReception = ?1"
			, nativeQuery = false)
	public List<LigneReception> findByCodeReception(String codeReception);
	
	
	@Query(value="SELECT * FROM reception r, ligne_reception lr, ligne_commande lc, article art\r\n"
			+ "WHERE r.num_reception = lr.num_reception AND lr.id_ligne_cmde = lc.id_ligne_commande AND lc.num_article = art.num_article\r\n"
			+ "AND art.num_article = ?\r\n"
			+ "AND r.date_validation >= ? AND r.date_validation  <= ?"
			, nativeQuery = true)
	public List<LigneReception> getAllLigneReceptionByPeriodeAndArticle(Long numArticle, LocalDateTime dateDebut, LocalDateTime dateFin );

	
}
