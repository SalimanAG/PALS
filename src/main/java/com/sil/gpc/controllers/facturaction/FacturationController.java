package com.sil.gpc.controllers.facturaction;

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

import com.sil.gpc.domains.Affecter;
import com.sil.gpc.domains.Caisse;
import com.sil.gpc.domains.ModePaiement;
import com.sil.gpc.domains.OpCaisse;
import com.sil.gpc.domains.TypeRecette;
import com.sil.gpc.services.AffecterService;
import com.sil.gpc.services.CaisseService;
import com.sil.gpc.services.LigneOpCaisseService;
import com.sil.gpc.services.LigneReversementService;
import com.sil.gpc.services.ModePaiementService;
import com.sil.gpc.services.OpCaisseService;
import com.sil.gpc.services.ReversementService;
import com.sil.gpc.services.TypeRecetteService;

@RestController
@RequestMapping(path = "/perfora-gpc/v1/facturation/")
public class FacturationController {

	private final CaisseService caisseService;
	private final AffecterService affecterService;
	private final LigneOpCaisseService ligneOpCaisseService;
	private final LigneReversementService ligneReversementService;
	private final ModePaiementService modePaiementService;
	private final OpCaisseService opCaisseService;
	private final ReversementService reversementService;
	private final TypeRecetteService typeRecetteService;
	
	
	public FacturationController(CaisseService caisseService, AffecterService affecterService,
			LigneOpCaisseService ligneOpCaisseService, LigneReversementService ligneReversementService,
			ModePaiementService modePaiementService, OpCaisseService opCaisseService,
			ReversementService reversementService, TypeRecetteService typeRecetteService) {
		super();
		this.caisseService = caisseService;
		this.affecterService = affecterService;
		this.ligneOpCaisseService = ligneOpCaisseService;
		this.ligneReversementService = ligneReversementService;
		this.modePaiementService = modePaiementService;
		this.opCaisseService = opCaisseService;
		this.reversementService = reversementService;
		this.typeRecetteService = typeRecetteService;
	}
	
	/*###########################################################
	#############	Partie réservée pour Caisse
	###########################################################
	*/
	
	@GetMapping(path = "caisse/list")
	public List<Caisse> getAllCaisse(){
		
		return this.caisseService.getAll();
	}
	
	@GetMapping(path = "caisse/byCodCai/{id}")
	public Optional<Caisse> getCaisseById(@PathVariable(name = "id") String id){
		
		return this.caisseService.getById(id);
	}
	
	@PostMapping(path = "caisse/list")
	public Caisse createCaisse( @RequestBody Caisse caisse) {
		
		return this.caisseService.save(caisse);
	}
	
	@PutMapping(path = "caisse/byCodCai/{id}")
	public Caisse updateCaisse(@PathVariable(name = "id") String id, @RequestBody Caisse caisse) {
		
		return this.caisseService.edit(id, caisse);
	}
	
	@DeleteMapping(path = "caisse/byCodCai/{id}")
	public Boolean deleteCaisse(@PathVariable(name = "id") String id) {
		
		return this.caisseService.delete(id);
	}
	
	/*###########################################################
	#############	Partie réservée pour Affecter
	###########################################################
	*/
	
	@GetMapping(path = "affecter/list")
	public List<Affecter> getAllAffecter(){
		
		return this.affecterService.getAll();
	}
	
	@GetMapping(path = "affecter/byCodAff/{id}")
	public Optional<Affecter> getAffecterById(@PathVariable(name = "id") Long id){
		
		return this.affecterService.getByid(id);
	}
	
	@PostMapping(path = "affecter/list")
	public Affecter createAffecter(@RequestBody Affecter affecter) {
		
		return this.affecterService.save(affecter);
	}
	
	@PutMapping(path = "affecter/byCodAff/{id}")
	public Affecter updateAffecter(@PathVariable(name = "id") Long id, @RequestBody Affecter affecter) {
		
		return this.affecterService.edit(id, affecter);
	}
	
	@DeleteMapping(path = "Affecter/byCodAff/{id}")
	public Boolean deleteAffecter(@PathVariable(name = "id") Long id) {
		
		return this.affecterService.delete(id);
	}
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour mode paiement
	###########################################################
	*/
	
	@GetMapping(path = "modePaiement/list")
	public List<ModePaiement> getAllModePaiement(){
		
		return null;
	}
	
	@GetMapping(path = "modePaiement/byCodModPai/{id}")
	public ModePaiement getModePaiementById(@PathVariable(name = "id") String id){
		
		return null;//this.modePaiementService.rechercheModePaiement(id);
	}
	
	@PostMapping(path = "modePaiement/list")
	public ModePaiement createModePaiement(@RequestBody ModePaiement modePaiement) {
		
		return null; //this.modePaiementService.ajouteModePaiment(modePaiement);
	}
	
	@PutMapping(path = "modePaiement/byCodModPai/{id}")
	public ModePaiement updateModePaiement(@PathVariable(name = "id") String id, @RequestBody ModePaiement modePaiement) {
		
		return null; //this.modePaiementService.modifieMP(modePaiement, id);
	}
	
	@DeleteMapping(path = "modePaiement/byCodModPai/{id}")
	public Boolean deleteModePaiement(@PathVariable(name = "id") String id) {
		
		return null;//this.modePaiementService.suppprimeModePaiement(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour type recette
	###########################################################
	*/
	
	@GetMapping(path = "typeRecette/list")
	public List<TypeRecette> getAllTypeRecette(){
		
		return null; //this.typeRecetteService.findAllTypeRecette();
	}
	
	@GetMapping(path = "typeRecette/byCodTypRec/{id}")
	public TypeRecette getTypeRecetteById(@PathVariable(name = "id") String id){
		
		return null; //this.typeRecetteService.findById(id);
	}
	
	@PostMapping(path = "typeRecette/list")
	public TypeRecette createTypeRecette(@RequestBody TypeRecette typeRecette) {
		
		return null; //this.typeRecetteService.save(typeRecette);
	}
	
	@PutMapping(path = "typeRecette/byCodTypRec/{id}")
	public TypeRecette updateTypeRecette(@PathVariable(name = "id") String id, @RequestBody TypeRecette typeRecette) {
		
		return null;//this.typeRecetteService.edit(id, typeRecette);
	}
	
	@DeleteMapping(path = "typeRecette/byCodTypRec/{id}")
	public Boolean deleteTypeRecette(@PathVariable(name = "id") String id) {
		
		return null;//this.typeRecetteService.delete(id);
	}
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour Opération Caisse
	###########################################################
	*/
	
	@GetMapping(path = "opCaisse/list")
	public List<OpCaisse> getAllOpcaisse(){
		
		return null;//this.opCaisseService.
	}
	
	@GetMapping(path = "opCaisse/byCodOpCai/{id}")
	public OpCaisse getOpCaisseById(@PathVariable(name = "id") String id){
		
		return null; //this.opCaisseService.rechercheOpCaisse(id);
	}
	
	@PostMapping(path = "opCaisse/list")
	public OpCaisse createOpCaisse(@RequestBody OpCaisse opCaisse) {
		
		return null;//this.opCaisseService.ajouteOpCaisse(opCaisse);
	}
	
	@PutMapping(path = "opCaisse/byCodOpCai/{id}")
	public OpCaisse updateOpCaisse(@PathVariable(name = "id") String id, @RequestBody OpCaisse opCaisse) {
		
		return null;//this.opCaisseService.modifieOpCaisse(opCaisse, id);
	}
	
	@DeleteMapping(path = "opCaisse/byCodOpCai/{id}")
	public Boolean deleteOpCaisse(@PathVariable(name = "id") String id) {
		
		return null;//this.opCaisseService.supprimeOpCaisse(id);
	}
	
	
	/*###########################################################
	#############	Partie réservée pour ligne opération caisse
	###########################################################
	*/
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour reversement
	###########################################################
	*/
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour ligne reversement
	###########################################################
	*/
	
	
	
	
	
}
