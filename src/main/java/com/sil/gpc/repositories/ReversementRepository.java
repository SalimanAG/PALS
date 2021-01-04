package com.sil.gpc.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Reversement;

@Repository
public interface ReversementRepository extends JpaRepository<Reversement, String> {
	
	public List<Reversement> findByNumReversement(String NumReversement);
	
	public List<Reversement> findByDateReversement(Date DateReversement);

}
