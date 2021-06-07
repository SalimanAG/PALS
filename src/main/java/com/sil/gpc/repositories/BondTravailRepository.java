package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.BondTravail;

@Repository
public interface BondTravailRepository extends JpaRepository<BondTravail, String> {

}
