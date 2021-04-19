package com.sil.gpc.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sil.gpc.domains.LigneInventaire;

@Repository
public interface LigneInventaireRepository extends JpaRepository<LigneInventaire, Long>{
	
	@Override
	default void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	default List<LigneInventaire> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	default Optional<LigneInventaire> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	default <S extends LigneInventaire> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
