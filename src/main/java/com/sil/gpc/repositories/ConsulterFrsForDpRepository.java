package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.ConsulterFrsForDp;

@Repository
public interface ConsulterFrsForDpRepository extends JpaRepository<ConsulterFrsForDp, Long> {

}
