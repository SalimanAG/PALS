package com.sil.gpc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Inventaire;

@Repository
public interface InventaireRepository extends JpaRepository<Inventaire, String>{
	@Override
	default void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	default List<Inventaire> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	default Optional<Inventaire> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	default <S extends Inventaire> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Query(value="SELECT valeur FROM Inventaire WHERE code_exercice = ?1 ORDER BY valeur DESC LIMIT 1;"
			, nativeQuery = true)
	Integer findLastNumUsed(String codeExo);
}
