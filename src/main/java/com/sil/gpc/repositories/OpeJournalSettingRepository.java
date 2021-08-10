package com.sil.gpc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sil.gpc.domains.OpeJournalSetting;

@Repository
public interface OpeJournalSettingRepository extends JpaRepository<OpeJournalSetting, Long> {

}
