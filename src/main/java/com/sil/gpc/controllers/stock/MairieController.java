package com.sil.gpc.controllers.stock;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sil.gpc.domains.AppelOffre;
import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.BondTravail;
import com.sil.gpc.domains.CommandeAchat;
import com.sil.gpc.domains.ConsulterFrsForDp;
import com.sil.gpc.domains.DemandePrix;
import com.sil.gpc.domains.FactureProFormAcha;
import com.sil.gpc.domains.Inventaire;
import com.sil.gpc.domains.LettreCommande;
import com.sil.gpc.domains.LigneAppro;
import com.sil.gpc.domains.LigneDemandePrix;
import com.sil.gpc.domains.LigneFactureProFormAchat;
import com.sil.gpc.domains.LigneInventaire;
import com.sil.gpc.encapsuleurs.EncapApprovisionnement;
import com.sil.gpc.encapsuleurs.EncapDemandePrix;
import com.sil.gpc.encapsuleurs.EncapFactureProformAchat;
import com.sil.gpc.encapsuleurs.EncapInventaire;
import com.sil.gpc.services.AppelOffreService;
import com.sil.gpc.services.ApprovisionnementService;
import com.sil.gpc.services.BondTravailService;
import com.sil.gpc.services.CommandeAchatService;
import com.sil.gpc.services.ConsulterFrsForDpService;
import com.sil.gpc.services.DemandePrixService;
import com.sil.gpc.services.FactureProFormAchaService;
import com.sil.gpc.services.LettreCommandeService;
import com.sil.gpc.services.LigneApproService;
import com.sil.gpc.services.LigneDemandePrixService;
import com.sil.gpc.services.LigneFactureProFormAchaService;

@CrossOrigin
@RestController
@RequestMapping(path = "/perfora-stock/v1/stock/")
public class MairieController {

	private final ApprovisionnementService approvisionnementService;
	private final LigneApproService ligneApproService;
	private final AppelOffreService appelOffreService;
	private final BondTravailService bondTravailService;
	private final CommandeAchatService commandeAchatService;
	private final ConsulterFrsForDpService consulterFrsForDpService;
	private final DemandePrixService demandePrixService;
	private final FactureProFormAchaService factureProFormAchaService;
	private final LettreCommandeService lettreCommandeService;
	private final LigneDemandePrixService ligneDemandePrixService;
	private final LigneFactureProFormAchaService ligneFactureProFormAchaService;
	
	
	public MairieController(ApprovisionnementService approvisionnementService, LigneApproService ligneApproService, LigneFactureProFormAchaService ligneFactureProFormAchaService, LigneDemandePrixService ligneDemandePrixService, LettreCommandeService lettreCommandeService, FactureProFormAchaService factureProFormAchaService, DemandePrixService demandePrixService, ConsulterFrsForDpService consulterFrsForDpService, CommandeAchatService commandeAchatService, BondTravailService bondTravailService, AppelOffreService appelOffreService) {
		super();
		this.approvisionnementService = approvisionnementService;
		this.ligneApproService = ligneApproService;
		this.appelOffreService = appelOffreService;
		this.bondTravailService = bondTravailService;
		this.commandeAchatService = commandeAchatService;
		this.consulterFrsForDpService = consulterFrsForDpService;
		this.demandePrixService = demandePrixService;
		this.factureProFormAchaService = factureProFormAchaService;
		this.lettreCommandeService = lettreCommandeService;
		this.ligneDemandePrixService = ligneDemandePrixService;
		this.ligneFactureProFormAchaService = ligneFactureProFormAchaService;
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
	
	@PostMapping(path = "approvisionnement/list2")
	public EncapApprovisionnement createApprovisionnementByEncap( @RequestBody EncapApprovisionnement encapApprovisionnement) {
		List<LigneAppro> lignes = encapApprovisionnement.getLigneAppros();
		
		Approvisionnement element = this.approvisionnementService.save(encapApprovisionnement.getApprovisionnement());
		
		for (int i = 0; i < lignes.size(); i++) {
			LigneAppro lig = lignes.get(i);
			lig.setAppro(element);
			
			lignes.set(i, lig);
		}
		
		lignes = this.ligneApproService.saveAll(lignes);
		
		return new EncapApprovisionnement(element, lignes);
	}

	
	@PutMapping(path = "approvisionnement/byCodApp/{id}")
	public Approvisionnement updateApprovisionnement(@PathVariable(name = "id") String id, @RequestBody Approvisionnement approvisionnement) {
		
		return this.approvisionnementService.edit(id, approvisionnement);
	}
	
	@DeleteMapping(path = "approvisionnement/byCodApp/{id}")
	public Boolean deleteApprovisionnement(@PathVariable(name = "id") String id) {
		
		return this.approvisionnementService.delete(id);
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
	public Boolean deleteLigneAppro(@PathVariable(name = "id") Long id) {
		
		return this.ligneApproService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour AppelOffre
	###########################################################
	*/
	
	@GetMapping(path = "appelOffre/list")
	public List<AppelOffre> getAllAppelOffre(){
		
		return this.appelOffreService.getAll();
	}
	
	@GetMapping(path = "appelOffre/byCodAppOff/{id}")
	public AppelOffre getAppelOffreById(@PathVariable(name = "id") String id){
		
		return this.appelOffreService.getById(id);
	}
	
	@PostMapping(path = "appelOffre/list")
	public AppelOffre createAppelOffre( @RequestBody AppelOffre appelOffre) {
		
		return this.appelOffreService.save(appelOffre);
	}
	
	@PutMapping(path = "appelOffre/byCodAppOff/{id}")
	public AppelOffre updateAppelOffre(@PathVariable(name = "id") String id, @RequestBody AppelOffre appelOffre) {
		
		return this.appelOffreService.edit(id, appelOffre);
	}
	
	@DeleteMapping(path = "appelOffre/byCodAppOff/{id}")
	public Boolean deleteLigneAppro(@PathVariable(name = "id") String id) {
		
		return this.appelOffreService.delete(id);
	}


	
	/*###########################################################
	#############	Partie réservée pour BondTravail
	###########################################################
	*/
	
	@GetMapping(path = "bondTravail/list")
	public List<BondTravail> getAllBondTravail(){
		
		return this.bondTravailService.getAll();
	}
	
	@GetMapping(path = "bondTravail/byCodBonTra/{id}")
	public BondTravail getBondTravailById(@PathVariable(name = "id") String id){
		
		return this.bondTravailService.getById(id);
	}
	
	@PostMapping(path = "bondTravail/list")
	public BondTravail createBondTravail( @RequestBody BondTravail bondTravail) {
		
		return this.bondTravailService.save(bondTravail);
	}
	
	@PutMapping(path = "bondTravail/byCodBonTra/{id}")
	public BondTravail updateBondTravail(@PathVariable(name = "id") String id, @RequestBody BondTravail bondTravail) {
		
		return this.bondTravailService.edit(id, bondTravail);
	}
	
	@DeleteMapping(path = "bondTravail/byCodBonTra/{id}")
	public Boolean deleteBondTravail(@PathVariable(name = "id") String id) {
		
		return this.bondTravailService.delete(id);
	}
	
	
	/*###########################################################
	#############	Partie réservée pour CommandeAchat
	###########################################################
	*/
	
	@GetMapping(path = "commandeAchat/list")
	public List<CommandeAchat> getAllCommandeAchat(){
		
		return this.commandeAchatService.getAll();
	}
	
	@GetMapping(path = "commandeAchat/byCodComAch/{id}")
	public CommandeAchat getCommandeAchatById(@PathVariable(name = "id") String id){
		
		return this.commandeAchatService.getById(id);
	}
	
	@PostMapping(path = "commandeAchat/list")
	public CommandeAchat createCommandeAchat( @RequestBody CommandeAchat commandeAchat) {
		
		return this.commandeAchatService.save(commandeAchat);
	}
	
	@PutMapping(path = "commandeAchat/byCodComAch/{id}")
	public CommandeAchat updateCommandeAchat(@PathVariable(name = "id") String id, @RequestBody CommandeAchat commandeAchat) {
		
		return this.commandeAchatService.edit(id, commandeAchat);
	}
	
	@DeleteMapping(path = "commandeAchat/byCodComAch/{id}")
	public Boolean deleteCommandeAchat(@PathVariable(name = "id") String id) {
		
		return this.commandeAchatService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour ConsulterFrsForDp
	###########################################################
	*/
	
	@GetMapping(path = "consulterFrsForDp/list")
	public List<ConsulterFrsForDp> getConsulterFrsForDp(){
		
		return this.consulterFrsForDpService.getAll();
	}
	
	@GetMapping(path = "consulterFrsForDp/byCodConFrsForDp/{id}")
	public ConsulterFrsForDp getConsulterFrsForDpById(@PathVariable(name = "id") Long id){
		
		return this.consulterFrsForDpService.getById(id);
	}
	
	@PostMapping(path = "consulterFrsForDp/list")
	public ConsulterFrsForDp createConsulterFrsForDp( @RequestBody ConsulterFrsForDp consulterFrsForDp) {
		
		return this.consulterFrsForDpService.save(consulterFrsForDp);
	}
	
	@PutMapping(path = "consulterFrsForDp/byCodConFrsForDp/{id}")
	public ConsulterFrsForDp updateConsulterFrsForDp(@PathVariable(name = "id") Long id, @RequestBody ConsulterFrsForDp consulterFrsForDp) {
		
		return this.consulterFrsForDpService.edit(id, consulterFrsForDp);
	}
	
	@DeleteMapping(path = "consulterFrsForDp/byCodConFrsForDp/{id}")
	public Boolean deleteConsulterFrsForDp(@PathVariable(name = "id") Long id) {
		
		return this.consulterFrsForDpService.delete(id);
	}

	

	/*###########################################################
	#############	Partie réservée pour DemandePrix
	###########################################################
	*/
	
	@GetMapping(path = "demandePrix/list")
	public List<DemandePrix> getAllDemandePrix(){
		
		return this.demandePrixService.getAll();
	}
	
	@GetMapping(path = "demandePrix/byCodDemPri/{id}")
	public DemandePrix getDemandePrixById(@PathVariable(name = "id") String id){
		
		return this.demandePrixService.getById(id);
	}
	
	@PostMapping(path = "demandePrix/list")
	public DemandePrix createDemandePrix( @RequestBody DemandePrix demandePrix) {
		
		return this.demandePrixService.save(demandePrix);
	}
	
	
	@PostMapping(path = "demandePrix/list2")
	public EncapDemandePrix createDemandePrixByEncap( @RequestBody EncapDemandePrix encapDemandePrix) {
		List<LigneDemandePrix> lignes = encapDemandePrix.getLigneDemandePrixs();
		
		DemandePrix element = this.demandePrixService.save(encapDemandePrix.getDemandePrix());
		
		for (int i = 0; i < lignes.size(); i++) {
			LigneDemandePrix lig = lignes.get(i);
			lig.setDemandePrix(element);
			
			lignes.set(i, lig);
		}
		
		lignes = this.ligneDemandePrixService.saveAll(lignes);
		
		return new EncapDemandePrix(element, lignes);
	}

	
	
	@PutMapping(path = "demandePrix/byCodDemPri/{id}")
	public DemandePrix updateDemandePrix(@PathVariable(name = "id") String id, @RequestBody DemandePrix demandePrix) {
		
		return this.demandePrixService.edit(id, demandePrix);
	}
	
	@DeleteMapping(path = "demandePrix/byCodDemPri/{id}")
	public Boolean deleteDemandePrix(@PathVariable(name = "id") String id) {
		
		return this.demandePrixService.delete(id);
	}
	
	
	/*###########################################################
	#############	Partie réservée pour LigneDemandePrix
	###########################################################
	*/
	
	@GetMapping(path = "ligneDemandePrix/list")
	public List<LigneDemandePrix> getAllLigneDemandePrix(){
		
		return this.ligneDemandePrixService.getAll();
	}
	
	@GetMapping(path = "ligneDemandePrix/byCodLigDemPri/{id}")
	public LigneDemandePrix getLigneDemandePrixById(@PathVariable(name = "id") Long id){
		
		return this.ligneDemandePrixService.getById(id);
	}
	
	@PostMapping(path = "ligneDemandePrix/list")
	public LigneDemandePrix createLigneDemandePrix( @RequestBody LigneDemandePrix ligneDemandePrix) {
		
		return this.ligneDemandePrixService.save(ligneDemandePrix);
	}
	
	@PutMapping(path = "ligneDemandePrix/byCodLigDemPri/{id}")
	public LigneDemandePrix updateLigneDemandePrix(@PathVariable(name = "id") Long id, @RequestBody LigneDemandePrix ligneDemandePrix) {
		
		return this.ligneDemandePrixService.edit(id, ligneDemandePrix);
	}
	
	@DeleteMapping(path = "ligneDemandePrix/byCodLigDemPri/{id}")
	public Boolean deleteLigneDemandePrix(@PathVariable(name = "id") Long id) {
		
		return this.ligneDemandePrixService.delete(id);
	}
	

	
	/*###########################################################
	#############	Partie réservée pour LettreCommande
	###########################################################
	*/
	
	@GetMapping(path = "lettreCommande/list")
	public List<LettreCommande> getAllLettreCommande(){
		
		return this.lettreCommandeService.getAll();
	}
	
	@GetMapping(path = "lettreCommande/byCodLetCom/{id}")
	public LettreCommande getLettreCommandeById(@PathVariable(name = "id") String id){
		
		return this.lettreCommandeService.getById(id);
	}
	
	@PostMapping(path = "lettreCommande/list")
	public LettreCommande createLettreCommande( @RequestBody LettreCommande lettreCommande) {
		
		return this.lettreCommandeService.save(lettreCommande);
	}
	
	@PutMapping(path = "lettreCommande/byCodLetCom/{id}")
	public LettreCommande updateLettreCommande(@PathVariable(name = "id") String id, @RequestBody LettreCommande lettreCommande) {
		
		return this.lettreCommandeService.edit(id, lettreCommande);
	}
	
	@DeleteMapping(path = "lettreCommande/byCodLetCom/{id}")
	public Boolean deleteLettreCommande(@PathVariable(name = "id") String id) {
		
		return this.lettreCommandeService.delete(id);
	}

	
	
	/*###########################################################
	#############	Partie réservée pour FactureProFormAcha
	###########################################################
	*/
	
	@GetMapping(path = "factureProFormAcha/list")
	public List<FactureProFormAcha> getAllFactureProFormAcha(){
		
		return this.factureProFormAchaService.getAll();
	}
	
	@GetMapping(path = "factureProFormAcha/byCodFacProForAch/{id}")
	public FactureProFormAcha getFactureProFormAchaById(@PathVariable(name = "id") String id){
		
		return this.factureProFormAchaService.getById(id);
	}
	
	@PostMapping(path = "factureProFormAcha/list")
	public FactureProFormAcha createFactureProFormAcha( @RequestBody FactureProFormAcha factureProFormAcha) {
		
		return this.factureProFormAchaService.save(factureProFormAcha);
	}
	
	
	@PostMapping(path = "factureProFormAcha/list2")
	public EncapFactureProformAchat createFactureProFormAchaByEncap( @RequestBody EncapFactureProformAchat encapFactureProformAchat) {
		List<LigneFactureProFormAchat> lignes = encapFactureProformAchat.getFactureProFormAchats();
		
		FactureProFormAcha element = this.factureProFormAchaService.save(encapFactureProformAchat.getFactureProFormAcha());
		
		for (int i = 0; i < lignes.size(); i++) {
			LigneFactureProFormAchat lig = lignes.get(i);
			lig.setFactureProFormAcha(element);
			
			lignes.set(i, lig);
		}
		
		lignes = this.ligneFactureProFormAchaService.saveAll(lignes);
		
		return new EncapFactureProformAchat(element, lignes);
	}
	
	
	@PutMapping(path = "factureProFormAcha/byCodFacProForAch/{id}")
	public FactureProFormAcha updateFactureProFormAcha(@PathVariable(name = "id") String id, @RequestBody FactureProFormAcha factureProFormAcha) {
		
		return this.factureProFormAchaService.edit(id, factureProFormAcha);
	}
	
	@DeleteMapping(path = "factureProFormAcha/byCodFacProForAch/{id}")
	public Boolean deleteFactureProFormAcha(@PathVariable(name = "id") String id) {
		
		return this.factureProFormAchaService.delete(id);
	}

	
	
	/*###########################################################
	#############	Partie réservée pour LigneFactureProFormAcha
	###########################################################
	*/
	
	@GetMapping(path = "ligneFactureProFormAchat/list")
	public List<LigneFactureProFormAchat> getAllLigneFactureProFormAchat(){
		
		return this.ligneFactureProFormAchaService.getAll();
	}
	
	@GetMapping(path = "ligneFactureProFormAchat/byCodLigFacProForAch/{id}")
	public LigneFactureProFormAchat getLigneFactureProFormAchatById(@PathVariable(name = "id") Long id){
		
		return this.ligneFactureProFormAchaService.getById(id);
	}
	
	@PostMapping(path = "ligneFactureProFormAchat/list")
	public LigneFactureProFormAchat createLigneFactureProFormAchat( @RequestBody LigneFactureProFormAchat ligneFactureProFormAchat) {
		
		return this.ligneFactureProFormAchaService.save(ligneFactureProFormAchat);
	}
	
	@PutMapping(path = "ligneFactureProFormAchat/byCodLigFacProForAch/{id}")
	public LigneFactureProFormAchat updateLigneFactureProFormAchat(@PathVariable(name = "id") Long id, @RequestBody LigneFactureProFormAchat ligneFactureProFormAchat) {
		
		return this.ligneFactureProFormAchaService.edit(id, ligneFactureProFormAchat);
	}
	
	@DeleteMapping(path = "ligneFactureProFormAchat/byCodLigFacProForAch/{id}")
	public Boolean deleteLigneFactureProFormAchat(@PathVariable(name = "id") Long id) {
		
		return this.ligneFactureProFormAchaService.delete(id);
	}

	
	
	
}
