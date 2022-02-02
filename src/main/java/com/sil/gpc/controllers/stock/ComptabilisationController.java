package com.sil.gpc.controllers.stock;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sil.gpc.domains.EcritureComptable;
import com.sil.gpc.domains.OpeJournalSetting;
import com.sil.gpc.domains.StockComptaSetting;
import com.sil.gpc.services.EcritureComptableService;
import com.sil.gpc.services.OpeJournalSettingService;
import com.sil.gpc.services.StockComptaSettingService;

@CrossOrigin
@RestController
@RequestMapping(path = "/perfora-stock/v1/compta/")
@Transactional
public class ComptabilisationController {

	private final StockComptaSettingService comptaSettingService;
	private final OpeJournalSettingService opeJournalSettingService;
	private final EcritureComptableService ecritureComptableService;
	
	public ComptabilisationController(OpeJournalSettingService opeJournalSettingService, StockComptaSettingService comptaSettingService, EcritureComptableService ecritureComptableService) {
		super();
		this.comptaSettingService = comptaSettingService;
		this.opeJournalSettingService = opeJournalSettingService;
		this.ecritureComptableService = ecritureComptableService;

	}
	
	/*###########################################################
	#############	Partie réservée pour StockComptaSetting
	###########################################################
	*/
	
	@GetMapping(path = "stockComptaSetting/list")
	public List<StockComptaSetting> getAllStockComptaSetting(){
		
		return this.comptaSettingService.getAll();
	}
	
	@GetMapping(path = "stockComptaSetting/byNum/{id}")
	public StockComptaSetting getStockComptaSettingById(@PathVariable(name = "id") Long id){
		
		return this.comptaSettingService.getById(id);
	}
	
	@PostMapping(path = "stockComptaSetting/list")
	public StockComptaSetting createStockComptaSetting( @RequestBody StockComptaSetting stockComptaSetting) {
		
		return this.comptaSettingService.save(stockComptaSetting);
	}
	
	@PostMapping(path = "stockComptaSetting/list2")
	public List<StockComptaSetting> createStockComptaSettingByList( @RequestBody List<StockComptaSetting> stockComptaSettings) {
		
		return this.comptaSettingService.save2(stockComptaSettings);
	}
	
	@PutMapping(path = "stockComptaSetting/byNum/{id}")
	public StockComptaSetting updateStockComptaSetting(@PathVariable(name = "id") Long id, @RequestBody StockComptaSetting stockComptaSetting) {
		
		return this.comptaSettingService.edit(id, stockComptaSetting);
	}
	
	@DeleteMapping(path = "stockComptaSetting/byNum/{id}")
	public Boolean deleteStockComptaSetting(@PathVariable(name = "id") Long id) {
		
		return this.comptaSettingService.delete(id);
	}	
	

	/*###########################################################
	#############	Partie réservée pour OpeJournalSetting
	###########################################################
	*/
	
	@GetMapping(path = "opeJournalSetting/list")
	public List<OpeJournalSetting> getAllOpeJournalSetting(){
		
		return this.opeJournalSettingService.getAll();
	}
	
	@GetMapping(path = "opeJournalSetting/byNum/{id}")
	public OpeJournalSetting getOpeJournalSettingById(@PathVariable(name = "id") Long id){
		
		return this.opeJournalSettingService.getById(id);
	}
	
	@PostMapping(path = "opeJournalSetting/list")
	public OpeJournalSetting createOpeJournalSetting( @RequestBody OpeJournalSetting opeJournalSetting) {
		
		return this.opeJournalSettingService.save(opeJournalSetting);
	}
	
	@PostMapping(path = "opeJournalSetting/list2")
	public List<OpeJournalSetting> createOpeJournalSettingByList( @RequestBody List<OpeJournalSetting> opeJournalSettings) {
		
		return this.opeJournalSettingService.save2(opeJournalSettings);
	}
	
	@PutMapping(path = "opeJournalSetting/byNum/{id}")
	public OpeJournalSetting updateOpeJournalSetting(@PathVariable(name = "id") Long id, @RequestBody OpeJournalSetting opeJournalSetting) {
		
		return this.opeJournalSettingService.edit(id, opeJournalSetting);
	}
	
	@DeleteMapping(path = "opeJournalSetting/byNum/{id}")
	public Boolean deleteOpeJournalSetting(@PathVariable(name = "id") Long id) {
		
		return this.opeJournalSettingService.delete(id);
	}	
	

	/*###########################################################
	#############	Partie réservée pour EcritureComptable
	###########################################################
	*/
	
	@GetMapping(path = "ecritureComptable/list")
	public List<EcritureComptable> getAllEcritureComptable(){
		
		return this.ecritureComptableService.getAll();
	}
	
	@GetMapping(path = "ecritureComptable/byNum/{id}")
	public EcritureComptable getEcritureComptableById(@PathVariable(name = "id") Long id){
		
		return this.ecritureComptableService.getById(id);
	}
	
	@PostMapping(path = "ecritureComptable/list")
	public EcritureComptable createEcritureComptable( @RequestBody EcritureComptable ecritureComptable) {
		
		return this.ecritureComptableService.save(ecritureComptable);
	}
	
	@PostMapping(path = "ecritureComptable/list2")
	public List<EcritureComptable> createEcritureComptableByList( @RequestBody List<EcritureComptable> ecritureComptables) {
		
		return this.ecritureComptableService.save2(ecritureComptables);
	}
	
	@PutMapping(path = "ecritureComptable/byNum/{id}")
	public EcritureComptable updateEcritureComptable(@PathVariable(name = "id") Long id, @RequestBody EcritureComptable ecritureComptable) {
		
		return this.ecritureComptableService.edit(id, ecritureComptable);
	}
	
	@DeleteMapping(path = "ecritureComptable/byNum/{id}")
	public Boolean deleteEcritureComptable(@PathVariable(name = "id") Long id) {
		
		return this.ecritureComptableService.delete(id);
	}	
	

	
	
}
