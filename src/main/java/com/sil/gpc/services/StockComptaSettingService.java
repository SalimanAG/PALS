package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Fournisseur;
import com.sil.gpc.domains.StockComptaSetting;
import com.sil.gpc.repositories.StockComptaSettingRepository;

@Service
public class StockComptaSettingService {

	private final StockComptaSettingRepository repo;

	public StockComptaSettingService(StockComptaSettingRepository repo) {
		super();
		this.repo = repo;
	}
	
	public StockComptaSetting save(StockComptaSetting stockComptaSetting) {
		return this.repo.save(stockComptaSetting);
	}
	
	public List<StockComptaSetting> save2(List<StockComptaSetting> stockComptaSettings) {
		return this.repo.saveAll(stockComptaSettings);
	}
	
	public StockComptaSetting edit(Long id, StockComptaSetting stockComptaSetting) {
		
		StockComptaSetting entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setAchat(stockComptaSetting.getAchat());
			entiter.setCompteStock(stockComptaSetting.getCompteStock());
			entiter.setCompteVaStock(stockComptaSetting.getCompteVaStock());
			entiter.setExportable(stockComptaSetting.isExportable());
			entiter.setFamille(stockComptaSetting.getFamille());
			entiter.setTvaAchat(stockComptaSetting.getTvaAchat());
			entiter.setTvaVente(stockComptaSetting.getTvaVente());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete (Long id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	public StockComptaSetting getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<StockComptaSetting> getAll(){
		
		return this.repo.findAll();
	}

}
