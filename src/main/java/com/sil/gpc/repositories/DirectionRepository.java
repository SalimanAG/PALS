package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.Direction;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long> {

}
