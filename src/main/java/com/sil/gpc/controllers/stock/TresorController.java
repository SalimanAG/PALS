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
import com.sil.gpc.domains.Commande;
import com.sil.gpc.domains.DemandeApprovisionnement;
import com.sil.gpc.domains.LigneCommande;
import com.sil.gpc.domains.LigneDemandeAppro;
import com.sil.gpc.services.CommandeService;
import com.sil.gpc.services.DemandeApproService;
import com.sil.gpc.services.LigneCommandeService;
import com.sil.gpc.services.LigneDemandeApproService;
import com.sil.gpc.services.LigneReceptionService;
import com.sil.gpc.services.ReceptionService;
import com.sil.gpc.services.RpService;

@RestController
@RequestMapping(path = "/perfora-gpc/v1/stock/")
public class TresorController {

	private final RpService rpService;
	private final CommandeService commandeService;
	private final LigneCommandeService ligneCommandeService;
	private final ReceptionService receptionService;
	private final LigneReceptionService ligneReceptionService;
	private final DemandeApproService demandeApproService;
	private final LigneDemandeApproService ligneDemandeApproService;
	
	public TresorController(RpService rpService, CommandeService commandeService,
			LigneCommandeService ligneCommandeService, ReceptionService receptionService,
			LigneReceptionService ligneReceptionService, DemandeApproService demandeApproService,
			LigneDemandeApproService ligneDemandeApproService) {
		super();
		this.rpService = rpService;
		this.commandeService = commandeService;
		this.ligneCommandeService = ligneCommandeService;
		this.receptionService = receptionService;
		this.ligneReceptionService = ligneReceptionService;
		this.demandeApproService = demandeApproService;
		this.ligneDemandeApproService = ligneDemandeApproService;
	}
	
	/*###########################################################
	#############	Partie réservée pour Rp
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour commande
	###########################################################
	*/
	
	@GetMapping(path = "commande/list")
	public List<Commande> getAllCommande(){
		
		return this.commandeService.getAll();
	}
	
	@GetMapping(path = "commande/byCodCom/{id}")
	public Optional<Commande> getCommandeById(@PathVariable(name = "id") String id){
		
		return this.commandeService.getById(id);
	}
	
	@PostMapping(path = "commande/list")
	public Commande createCommande( @RequestBody Commande commande) {
		
		return this.commandeService.save(commande);
	}
	
	@PutMapping(path = "commande/byCodCom/{id}")
	public Commande updateCommande(@PathVariable(name = "id") String id, @RequestBody Commande commande) {
		
		return this.commandeService.edit(id, commande);
	}
	
	@DeleteMapping(path = "commande/byCodCom/{id}")
	public Boolean deleteCommande(@PathVariable(name = "id") String id) {
		
		return this.commandeService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour lignes commande
	###########################################################
	*/
	
	@GetMapping(path = "ligneCommande/list")
	public List<LigneCommande> getAllLigneCommande(){
		
		return this.ligneCommandeService.getAll();
	}
	
	@GetMapping(path = "ligneCommande/byCodLigCom/{id}")
	public Optional<LigneCommande> getLigneCommandeById(@PathVariable(name = "id") Long id){
		
		return this.ligneCommandeService.getById(id);
	}
	
	@PostMapping(path = "ligneCommande/list")
	public LigneCommande createLigneCommande( @RequestBody LigneCommande ligneCommande) {
		
		return this.ligneCommandeService.save(ligneCommande);
	}
	
	@PutMapping(path = "ligneCommande/byCodLigCom/{id}")
	public LigneCommande updateLigneCommande(@PathVariable(name = "id") Long id, @RequestBody LigneCommande ligneCommande) {
		
		return this.ligneCommandeService.edit(id, ligneCommande);
	}
	
	@DeleteMapping(path = "ligneCommande/byCodLigCom/{id}")
	public Boolean deleteLigneCommande(@PathVariable(name = "id") Long id) {
		
		return this.ligneCommandeService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour reception
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour ligne reception
	###########################################################
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*###########################################################
	#############	Partie réservée pour demande appro
	###########################################################
	*/
	
	@GetMapping(path = "demandeAppro/list")
	public List<DemandeApprovisionnement> getAllDemandeAppro(){
		
		return this.demandeApproService.getAll();
	}
	
	@GetMapping(path = "demandeAppro/byCodDemApp/{id}")
	public Optional<DemandeApprovisionnement> getDemandeApproById(@PathVariable(name = "id") String id){
		
		return this.demandeApproService.getById(id);
	}
	
	@PostMapping(path = "demandeAppro/list")
	public DemandeApprovisionnement createDemandeAppro( @RequestBody DemandeApprovisionnement demandeApprovisionnement) {
		
		return this.demandeApproService.save(demandeApprovisionnement);
	}
	
	@PutMapping(path = "demandeAppro/byCodDemApp/{id}")
	public DemandeApprovisionnement updateDemandeAppro(@PathVariable(name = "id") String id, @RequestBody DemandeApprovisionnement demandeApprovisionnement) {
		
		return this.demandeApproService.edit(id, demandeApprovisionnement);
	}
	
	@DeleteMapping(path = "demandeAppro/byCodDemApp/{id}")
	public Boolean deleteDemandeAppro(@PathVariable(name = "id") String id) {
		
		return this.demandeApproService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour ligne demande appro
	###########################################################
	*/
	
	@GetMapping(path = "ligneDemandeAppro/list")
	public List<LigneDemandeAppro> getAllLigneDemandeAppro(){
		
		return this.ligneDemandeApproService.getAll();
	}
	
	@GetMapping(path = "ligneDemandeAppro/byCodLigDemApp/{id}")
	public Optional<LigneDemandeAppro> getLigneDemandeApproById(@PathVariable(name = "id") Long id){
		
		return this.ligneDemandeApproService.getById(id);
	}
	
	@PostMapping(path = "ligneDemandeAppro/list")
	public LigneDemandeAppro createLigneDemandeAppro( @RequestBody LigneDemandeAppro ligneDemandeAppro) {
		
		return this.ligneDemandeApproService.save(ligneDemandeAppro);
	}
	
	@PutMapping(path = "ligneDemandeAppro/byCodLigDemApp/{id}")
	public LigneDemandeAppro updateLigneDemandeAppro(@PathVariable(name = "id") Long id, @RequestBody LigneDemandeAppro ligneDemandeAppro) {
		
		return this.ligneDemandeApproService.edit(id, ligneDemandeAppro);
	}
	
	@DeleteMapping(path = "ligneDemandeAppro/byCodLigDemApp/{id}")
	public Boolean deleteLigneDemandeAppro(@PathVariable(name = "id") Long id) {
		
		return this.ligneDemandeApproService.delete(id);
	}
	
	
	
	
}
