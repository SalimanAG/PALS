package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Uniter;

@Repository
public interface UniterRepository extends JpaRepository<Uniter, Long> {
	
	public List<Uniter> findByCodeUniter(String CodeUniter);
	
	public List<Uniter> findByLibUniter(String LibelleUniter);

}
