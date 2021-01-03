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

import com.sil.gpc.domains.Caisse;
import com.sil.gpc.domains.Correspondant;
import com.sil.gpc.services.CorrespondantService;
import com.sil.gpc.services.LignePointVenteService;
import com.sil.gpc.services.PointVenteService;
import com.sil.gpc.services.TypCorresService;

@RestController
@RequestMapping(path = "/perfora-gpc/v1/stock/")
public class CorrespondantController {

	private final CorrespondantService correspondantService;
	private final TypCorresService typCorresService;
	private final PointVenteService pointVenteService;
	private final LignePointVenteService lignePointVenteService;
	
	public CorrespondantController(CorrespondantService correspondantService, TypCorresService typCorresService,
			PointVenteService pointVenteService, LignePointVenteService lignePointVenteService) {
		super();
		this.correspondantService = correspondantService;
		this.typCorresService = typCorresService;
		this.pointVenteService = pointVenteService;
		this.lignePointVenteService = lignePointVenteService;
	}
	
	/*###########################################################
	#############	Partie réservée pour Correspondant
	###########################################################
	*/
	
	@GetMapping(path = "correspondant/list")
	public List<Correspondant> getAllCorrespondant(){
		
		return this.correspondantService.getAll();
	}
	
	@GetMapping(path = "correspondant/byCodCor/{id}")
	public Optional<Correspondant> getCorrespondantById(@PathVariable(name = "id") String id){
		
		return this.correspondantService.getById(id);
	}
	
	@PostMapping(path = "correspondant/list")
	public Correspondant createCorrespondant( @RequestBody Correspondant correspondant) {
		
		return this.correspondantService.save(correspondant);
	}
	
	@PutMapping(path = "correspondant/byCodCor/{id}")
	public Correspondant updateCorrespondant(@PathVariable(name = "id") String id, @RequestBody Correspondant correspondant) {
		
		return this.correspondantService.edit(id, correspondant);
	}
	
	@DeleteMapping(path = "correspondant/byCodCor/{id}")
	public void deleteCorrespondant(@PathVariable(name = "id") String id) {
		
		this.correspondantService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour type Correspondant
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour point Vente
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour ligne point Vente
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
