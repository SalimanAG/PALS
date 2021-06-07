package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.LigneFactureProFormAchat;

@Repository
public interface LigneFactureProFormAchatRepository extends JpaRepository<LigneFactureProFormAchat, Long> {

}
