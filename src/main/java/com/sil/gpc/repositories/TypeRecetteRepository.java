package com.sil.gpc.repositories;
import java.util.List;


import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.sil.gpc.domains.TypeRecette;

@Repository
public interface TypeRecetteRepository extends JpaRepository<TypeRecette, String>{
	
	public List<TypeRecette> findByCodeTypeRecette(String CodeTypeRecette);
	public List<TypeRecette> findByLibelleTypRec(String LibelleTypRecette);
	
}