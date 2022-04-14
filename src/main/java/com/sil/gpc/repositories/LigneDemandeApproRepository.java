package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.DemandeApprovisionnement;
import com.sil.gpc.domains.LigneAppro;
import com.sil.gpc.domains.LigneDemandeAppro;

@Repository
public interface LigneDemandeApproRepository extends JpaRepository<LigneDemandeAppro, Long> {

	public List<LigneDemandeAppro> findByIdLigneDA(Long idLigneDA);
	
	public List<LigneDemandeAppro> findByQuantiteDemandee(Long quantiteDemandee);
	
	public List<LigneDemandeAppro> findByArticle(Article article);
	
	public List<LigneDemandeAppro> findByAppro(DemandeApprovisionnement appro);
	
	@Query(value="FROM LigneDemandeAppro as l WHERE l.appro.numDA = ?1"
			, nativeQuery = false)
	public List<LigneDemandeAppro> findByCodeDemAppro(String codeCommande);
	
}
