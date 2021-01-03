package com.sil.gpc.controllers.stock;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.Arrondissement;
import com.sil.gpc.domains.Caisse;
import com.sil.gpc.domains.LigneAppro;
import com.sil.gpc.repositories.ApprovisionementRepository;
import com.sil.gpc.services.ApprovisionnementService;
import com.sil.gpc.services.LigneApproService;
import com.sil.gpc.services.LignePlacementService;
import com.sil.gpc.services.LigneRecollementService;
import com.sil.gpc.services.PlacementService;
import com.sil.gpc.services.RecollementService;
import com.sil.gpc.services.RegisseurService;

@RestController
@RequestMapping(path = "/perfora-gpc/v1/stock/")
public class MairieController {

	private final ApprovisionnementService approvisionnementService;
	private final LigneApproService ligneApproService;
	private final PlacementService placementService;
	private final LignePlacementService lignePlacementService;
	private final RecollementService recollementService;
	private final LigneRecollementService ligneRecollementService;
	private final RegisseurService regisseurService;
	
	
	public MairieController(ApprovisionnementService approvisionnementService, LigneApproService ligneApproService,
			PlacementService placementService, LignePlacementService lignePlacementService,
			RecollementService recollementService, LigneRecollementService ligneRecollementService, RegisseurService regisseurService) {
		super();
		this.approvisionnementService = approvisionnementService;
		this.ligneApproService = ligneApproService;
		this.placementService = placementService;
		this.lignePlacementService = lignePlacementService;
		this.recollementService = recollementService;
		this.ligneRecollementService = ligneRecollementService;
		this.regisseurService = regisseurService;
	}
	
	/*###########################################################
	#############	Partie réservée pour Approvisionnement
	###########################################################
	*/
	
	@GetMapping(path = "approvisionnement/list")
	public List<Approvisionnement> getAllApprovisionnement(){
		
		return this.approvisionnementService.getAll();
	}
	
	@GetMapping(path = "approvisionnement/byCodApp/{id}")
	public Optional<Approvisionnement> getApprovisionnementById(@PathVariable(name = "id") String id){
		
		return this.approvisionnementService.getById(id);
	}
	
	@PostMapping(path = "approvisionnement/list")
	public Approvisionnement createApprovisionnement( @RequestBody Approvisionnement approvisionnement) {
		
		return this.approvisionnementService.save(approvisionnement);
	}
	
	@PutMapping(path = "approvisionnement/byCodApp/{id}")
	public Approvisionnement updateApprovisionnement(@PathVariable(name = "id") String id, @RequestBody Approvisionnement approvisionnement) {
		
		return this.approvisionnementService.edit(id, approvisionnement);
	}
	
	@DeleteMapping(path = "approvisionnement/byCodApp/{id}")
	public void deleteApprovisionnement(@PathVariable(name = "id") String id) {
		
		this.approvisionnementService.delete(id);
	}	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour ligne approvisionnement
	###########################################################
	*/
	
	@GetMapping(path = "ligneAppro/list")
	public List<LigneAppro> getAllLigneAppro(){
		
		return this.ligneApproService.getAll();
	}
	
	@GetMapping(path = "ligneAppro/byCodLigApp/{id}")
	public Optional<LigneAppro> getLigneApproById(@PathVariable(name = "id") Long id){
		
		return this.ligneApproService.getById(id);
	}
	
	@PostMapping(path = "ligneAppro/list")
	public LigneAppro createLigneAppro( @RequestBody LigneAppro ligneAppro) {
		
		return this.ligneApproService.save(ligneAppro);
	}
	
	@PutMapping(path = "ligneAppro/byCodLigApp/{id}")
	public LigneAppro updateLigneAppro(@PathVariable(name = "id") Long id, @RequestBody LigneAppro ligneAppro) {
		
		return this.ligneApproService.edit(id, ligneAppro);
	}
	
	@DeleteMapping(path = "ligneAppro/byCodLigApp/{id}")
	public void deleteLigneAppro(@PathVariable(name = "id") Long id) {
		
		this.ligneApproService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour Placement
	###########################################################
	*/
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour Ligne placement
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour Recollement
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour Ligne Recollement
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour Régisseur
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
