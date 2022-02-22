package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sil.gpc.domains.LigneTravaux;


@Repository
public interface LigneTravauxRepository extends JpaRepository<LigneTravaux, Long> {

	@Query(value="FROM LigneTravaux as l WHERE l.travaux.numTravaux = ?1"
			, nativeQuery = false)
	public List<LigneTravaux> findByCodeTravaux(String codeTravaux);
	
}
