package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Commande;
import com.sil.gpc.domains.CommandeAchat;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.Fournisseur;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

	//public List<Commande> findByNumCommande(String numCommande);
	
	public List<Commande> findByDateCommande(Date dateCommande);
	
	public List<Commande> findByDescription(String description);
	
	public List<Commande> findByDelaiLivraison(int delaiLivraison);
	
	public List<Commande> findByFrs(Fournisseur fournisseur);
	
	public List<Commande> findByExercice(Exercice exercice);
	
	@Query(value="SELECT valeur FROM (SELECT valeur FROM commande WHERE code_exercice = ?1 ORDER BY valeur DESC) WHERE ROWNUM = 1"
			, nativeQuery = true)
	/*@Query(value="SELECT valeur FROM commande WHERE code_exercice = ?1 ORDER BY valeur DESC LIMIT 1"
			, nativeQuery = true)*/
	public Integer findLastNumUsed(String codeExercice);
	
	@Query(value = "from Commande as l where l.exercice.codeExercice = ?1")
	public List<Commande> findByCodeExercice(String codeExo);

	
}
