package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.SiteMarcher;

@Repository
public interface SiteMarcherRepository extends JpaRepository<SiteMarcher, String>{

}
