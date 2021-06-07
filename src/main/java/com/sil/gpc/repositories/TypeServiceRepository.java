package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.TypeService;

@Repository
public interface TypeServiceRepository extends JpaRepository<TypeService, String> {

}
