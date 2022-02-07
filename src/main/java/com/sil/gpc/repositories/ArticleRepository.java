package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.Famille;
import com.sil.gpc.domains.Uniter;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

	public List<Article> findByCodeArticle(String codeArticle);
	
	public List<Article> findByLibArticle(String libArticle);
	
	public List<Article> findByPrixVenteArticle(Long prixVenteArticle);
	
	public List<Article> findByCouleurArticle(String couleurArticle);
	
	public List<Article> findByFamille(Famille famille);
	
	public List<Article> findByStockerArticle(boolean stockerArticle);
	
	public List<Article> findByNumSerieArticle(boolean numSerieArticle);
	
	public List<Article> findByLivrableArticle(boolean livrableArticle);
	
	public List<Article> findByConsommableArticle(boolean consommableArticle);
	
	@Query(value="from Article as a where a.afficherArticle = ?1"
			, nativeQuery = false)
	public List<Article> findByAffichableArticle(boolean affichableArticle);
	
	@Query(value="SELECT num_article, abreger_article, afficher_article, cmup_actu_article, code_article, " +
			"code_bare_article, compte_article, consommable_article, couleur_article, dat_st_init_art_tres, " +
			"lib_article, livrable_article, num_serie_article, prix_vente_article, pu_st_ini_tres, qte_st_ini_tres, " +
			"specialiter_article, stock_alert_article, stock_minim_article, stock_secur_article, stocker_article, " +
			"taxe_specifiq_article, tva_article, exo_st_init, article.num_famille, article.num_fournisseur, num_type_art\n" +
			"  FROM article, famille, magasin \n" +
			"  WHERE article.num_famille = famille.num_famille \n" +
			"  AND article.qte_st_ini_tres = 0\n"+
			"  AND famille.num_magasin = magasin.num_magasin\n"+
			"  AND famille.num_magasin = ?1"
			, nativeQuery = true)
	List<Article> finAllArticleForMagasin(Long id);


	
}
