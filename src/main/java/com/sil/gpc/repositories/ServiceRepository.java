package com.sil.gpc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import com.sil.gpc.domains.Service;


@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
	
	public List<Service> findByCodeService(String CodeService);
	
	public List<Service> findByLibService(String LibelleService);

}
