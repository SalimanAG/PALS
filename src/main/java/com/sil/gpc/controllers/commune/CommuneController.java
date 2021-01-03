package com.sil.gpc.controllers.commune;

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

import com.sil.gpc.domains.Arrondissement;
import com.sil.gpc.domains.Commune;
import com.sil.gpc.domains.Departement;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.Fournisseur;
import com.sil.gpc.services.ArrondissementService;
import com.sil.gpc.services.CommuneService;
import com.sil.gpc.services.DepartementService;
import com.sil.gpc.services.ExerciceService;
import com.sil.gpc.services.FournisseurService;
import com.sil.gpc.services.PaysService;
import com.sil.gpc.services.QuartierService;
import com.sil.gpc.services.ServiceService;
import com.sil.gpc.services.UtilisateurService;

@RestController
@RequestMapping(path = "/perfora-gpc/v1/commune/")
public class CommuneController {

	private final ExerciceService exerciceService;
	private final FournisseurService fournisseurService;
	private final ServiceService serviceService;
	private final UtilisateurService utilisateurService;
	private final PaysService paysService;
	private final DepartementService departementService;
	private final CommuneService communeService;
	private final ArrondissementService arrondissementService;
	private final QuartierService quartierService;
	
	public CommuneController(ExerciceService exerciceService, FournisseurService fournisseurService,
			ServiceService serviceService, UtilisateurService utilisateurService, PaysService paysService,
			DepartementService departementService, CommuneService communeService,
			ArrondissementService arrondissementService, QuartierService quartierService) {
		super();
		this.exerciceService = exerciceService;
		this.fournisseurService = fournisseurService;
		this.serviceService = serviceService;
		this.utilisateurService = utilisateurService;
		this.paysService = paysService;
		this.departementService = departementService;
		this.communeService = communeService;
		this.arrondissementService = arrondissementService;
		this.quartierService = quartierService;
	}
	
	
	/*###########################################################
	#############	Partie réservée pour exercice
	###########################################################
	*/
	
	@GetMapping(path = "exercice/list")
	public List<Exercice> getAllExercice(){
		
		return this.exerciceService.getAll();
	}
	
	@GetMapping(path = "exercice/byCodExe/{id}")
	public Optional<Exercice> getExerciceById(@PathVariable(name = "id") String id){
		
		return this.exerciceService.getById(id);
	}
	
	@PostMapping(path = "exercice/list")
	public Exercice createExercice( @RequestBody Exercice exercice) {
		
		return this.exerciceService.save(exercice);
	}
	
	@PutMapping(path = "exercice/byCodExe/{id}")
	public Exercice updateExercice(@PathVariable(name = "id") String id, @RequestBody Exercice exercice) {
		
		return this.exerciceService.edit(id, exercice);
	}
	
	@DeleteMapping(path = "exercice/byCodExe/{id}")
	public void deleteExercice(@PathVariable(name = "id") String id) {
		
		this.exerciceService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour fournisseur
	###########################################################
	*/
	
	@GetMapping(path = "fournisseur/list")
	public List<Fournisseur> getAllFournisseur(){
		
		return this.fournisseurService.getAll();
	}
	
	@GetMapping(path = "fournisseur/byCodFou/{id}")
	public Optional<Fournisseur> getFournisseurById(@PathVariable(name = "id") String id){
		
		return this.fournisseurService.getById(id);
	}
	
	@PostMapping(path = "fournisseur/list")
	public Fournisseur createFournisseur( @RequestBody Fournisseur fournisseur) {
		
		return this.fournisseurService.save(fournisseur);
	}
	
	@PutMapping(path = "fournisseur/byCodFou/{id}")
	public Fournisseur updateFournisseur(@PathVariable(name = "id") String id, @RequestBody Fournisseur fournisseur) {
		
		return this.fournisseurService.edit(id, fournisseur);
	}
	
	@DeleteMapping(path = "fournisseur/byCodFou/{id}")
	public void deleteFournisseur(@PathVariable(name = "id") String id) {
		
		this.fournisseurService.delete(id);
	}	
	
	
	/*###########################################################
	#############	Partie réservée pour service
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour utilisateur
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour pays
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour departement
	###########################################################
	*/
	
	@GetMapping(path = "departement/list")
	public List<Departement> getAllDepartement(){
		
		return this.departementService.getAll();
	}
	
	@GetMapping(path = "departement/byCodDep/{id}")
	public Optional<Departement> getDepartementById(@PathVariable(name = "id") String id){
		
		return this.departementService.getById(id);
	}
	
	@PostMapping(path = "departement/list")
	public Departement createDepartement( @RequestBody Departement departement) {
		
		return this.departementService.save(departement);
	}
	
	@PutMapping(path = "departement/byCodDep/{id}")
	public Departement updateDepartement(@PathVariable(name = "id") String id, @RequestBody Departement departement) {
		
		return this.departementService.edit(id, departement);
	}
	
	@DeleteMapping(path = "departement/byCodDep/{id}")
	public void deleteDepartement(@PathVariable(name = "id") String id) {
		
		this.departementService.delete(id);
	}	
	
	
	/*###########################################################
	#############	Partie réservée pour commune
	###########################################################
	*/
	
	@GetMapping(path = "commune/list")
	public List<Commune> getAllCommune(){
		
		return this.communeService.getAll();
	}
	
	@GetMapping(path = "commune/byCodCom/{id}")
	public Optional<Commune> getCommuneById(@PathVariable(name = "id") String id){
		
		return this.communeService.getById(id);
	}
	
	@PostMapping(path = "commune/list")
	public Commune createCommune( @RequestBody Commune commune) {
		
		return this.communeService.save(commune);
	}
	
	@PutMapping(path = "commune/byCodCom/{id}")
	public Commune updateCommune(@PathVariable(name = "id") String id, @RequestBody Commune commune) {
		
		return this.communeService.edit(id, commune);
	}
	
	@DeleteMapping(path = "commune/byCodCom/{id}")
	public void deleteCommune(@PathVariable(name = "id") String id) {
		
		this.communeService.delete(id);
	}	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour arrondissement
	###########################################################
	*/
	
	@GetMapping(path = "arrondissement/list")
	public List<Arrondissement> getAllArrondissement(){
		
		return this.arrondissementService.getAll();
	}
	
	@GetMapping(path = "arrondissement/byCodArr/{id}")
	public Optional<Arrondissement> getArrondissementById(@PathVariable(name = "id") String id){
		
		return this.arrondissementService.getById(id);
	}
	
	@PostMapping(path = "arrondissement/list")
	public Arrondissement createArrondissement( @RequestBody Arrondissement arrondissement) {
		
		return this.arrondissementService.save(arrondissement);
	}
	
	@PutMapping(path = "arrondissement/byCodArr/{id}")
	public Arrondissement updateArrondissement(@PathVariable(name = "id") String id, @RequestBody Arrondissement arrondissement) {
		
		return this.arrondissementService.edit(id, arrondissement);
	}
	
	@DeleteMapping(path = "arrondissement/byCodArr/{id}")
	public void deleteArrondissement(@PathVariable(name = "id") String id) {
		
		this.arrondissementService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour quartier
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
