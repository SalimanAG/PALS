package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.PlageNumDispo;

@Repository
public interface PlageNumDispoRepository extends JpaRepository<PlageNumDispo, String>{

	List<PlageNumDispo>findByArticle(String codArt);
	List<PlageNumDispo>findByNumDebPlage(String num);
	List<PlageNumDispo>findByNumFinPlage(String num);
	List<PlageNumDispo>findByNumDebPlageDispo(String num);
	List<PlageNumDispo>findByNumFinPlageDispo(String num);
}
