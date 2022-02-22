package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.Commande;
import com.sil.gpc.domains.LigneAppro;
import com.sil.gpc.domains.LigneCommande;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long>{
	
	@Query(value="FROM LigneCommande as l WHERE l.numCommande.numCommande = ?1"
			, nativeQuery = false)
	public List<LigneCommande> findByCodeCommande(Long codeCommande);

	/*public List<LigneCommande> findByIdLigneCommande (Long idLigneCommande);
	
	public List<LigneCommande> findByQteLigneCommande(Long qteLigneCommande);
	
	public List<LigneCommande> findByPULigneCommande(Long PULigneCommande);
	
	public List<LigneCommande> findByRemise(Long remise);
	
	public List<LigneCommande> findByTVA(Long tva);
	
	public List<LigneCommande> findByNumCommande(Commande commande);
	
	public List<LigneCommande> findByArticle(Article article);	*/
	
}
