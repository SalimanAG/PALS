package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.OpeJournalSetting;
import com.sil.gpc.domains.StockComptaSetting;
import com.sil.gpc.repositories.OpeJournalSettingRepository;

@Service
public class OpeJournalSettingService {

	private final OpeJournalSettingRepository repo;

	public OpeJournalSettingService(OpeJournalSettingRepository repo) {
		super();
		this.repo = repo;
	}
	
	public OpeJournalSetting save(OpeJournalSetting opeJournalSetting) {
		return this.repo.save(opeJournalSetting);
	}
	
	public List<OpeJournalSetting> save2(List<OpeJournalSetting> opeJournalSettings) {
		return this.repo.saveAll(opeJournalSettings);
	}
	
	public OpeJournalSetting edit(Long id, OpeJournalSetting opeJournalSetting) {
		
		OpeJournalSetting entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setJournal(opeJournalSetting.getJournal());
			entiter.setOperation(opeJournalSetting.getOperation());
			entiter.setDateDebut(opeJournalSetting.getDateDebut());
			entiter.setDateFin(opeJournalSetting.getDateFin());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete (Long id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	public OpeJournalSetting getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<OpeJournalSetting> getAll(){
		
		return this.repo.findAll();
	}
	
	
}
