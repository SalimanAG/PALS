package com.sil.gpc.controllers.commune;

import java.sql.Date;
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
import com.sil.gpc.domains.EtreAffecte;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.Fournisseur;
import com.sil.gpc.domains.Service;
import com.sil.gpc.domains.Pays;
import com.sil.gpc.domains.Quartier;
import com.sil.gpc.domains.Utilisateur;
import com.sil.gpc.services.ArrondissementService;
import com.sil.gpc.services.CommuneService;
import com.sil.gpc.services.DepartementService;
import com.sil.gpc.services.EtreAffeccteService;
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
	private final EtreAffeccteService etreAffecterService;
	
	public CommuneController(ExerciceService exerciceService, FournisseurService fournisseurService,
			ServiceService serviceService, UtilisateurService utilisateurService, PaysService paysService,
			DepartementService departementService, CommuneService communeService, EtreAffeccteService etreAffecterService,
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
		this.etreAffecterService = etreAffecterService;
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
	
	@GetMapping(path = "exercice/byExoSel/{exoSel}")
	public List<Exercice> getExerciceById(@PathVariable(name = "exoSel") boolean exoSel){
		
		return this.exerciceService.findByExoSelectionner(exoSel);
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
	public Boolean deleteExercice(@PathVariable(name = "id") String id) {
		
		return this.exerciceService.delete(id);
	}
	
	

	/*###########################################################
	#############	Partie réservée pour EtreAffecte
	###########################################################
	*/
	
	@GetMapping(path = "Affect/list")
	public List<EtreAffecte> getAllAffectation(){
		
		return this.etreAffecterService.getAllAffect();
	}
	
	@GetMapping(path = "Affect/byId/{id}")
	public Optional<EtreAffecte> getAffectationById(@PathVariable(name = "id") Long id){
		
		return this.etreAffecterService.findById(id);
	}
	
@GetMapping(path = "Affect/bydatArr/{exoSel}")
	public List<EtreAffecte> findAffectationByDA(@PathVariable(name = "exoSel") Date da){
		
		return this.etreAffecterService.findByDateArrivee(da);
	}
	
	@PostMapping(path = "Affect/list")
	public EtreAffecte createAffectation( @RequestBody EtreAffecte affect) {
		
		return this.etreAffecterService.save(affect);
	}
	
	@PutMapping(path = "Affect/byId/{id}")
	public EtreAffecte updateAffectation(@PathVariable(name = "id") Long id, @RequestBody EtreAffecte affect) {
		
		return this.etreAffecterService.edit(id, affect);
	}
	
	@DeleteMapping(path = "Affect/byId/{id}")
	public Boolean deleteAffectation(@PathVariable(name = "id") Long id) {
		
		return this.etreAffecterService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour fournisseur
	###########################################################
	*/
	
	@GetMapping(path = "fournisseur/list")
	public List<Fournisseur> getAllFournisseur(){
		
		return this.fournisseurService.getAll();
	}
	
	@GetMapping(path = "fournisseur/byCodFou/{raiSocial}")
	public List<Fournisseur> getFournisseurByRaisonSocial(@PathVariable(name = "raiSocial") String raiSocial){
		
		return this.fournisseurService.findByRaisonSociale(raiSocial);
	}
	
	@GetMapping(path = "fournisseur/byIdenFou/{identite}")
	public List<Fournisseur> getFournisseurByIdentite(@PathVariable(name = "identite") String identite){
		
		return this.fournisseurService.findByIdentiteFrs(identite);
	}
	
	@GetMapping(path = "fournisseur/byAdrFou/{adresse}")
	public List<Fournisseur> getFournisseurByAdresse(@PathVariable(name = "adresse") String adresse){
		
		return this.fournisseurService.findByAdresseFrs(adresse);
	}
	
	@GetMapping(path = "fournisseur/byRaiSocFou/{id}")
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
	public Boolean deleteFournisseur(@PathVariable(name = "id") String id) {
		
		return this.fournisseurService.delete(id);
	}	
	
	
	/*###########################################################
	#############	Partie réservée pour service
	###########################################################
	*/
	@GetMapping(path = "service/list")
	public List<Service> getAllService(){
		
		return this.serviceService.getAll();
	}
	
	@GetMapping(path = "service/byCodSev/{id}")
	public Optional<Service> getServiceById(@PathVariable(name = "id") String id){
		
		return this.serviceService.findById(id);
	}
	
	@GetMapping(path = "service/byLibSev/{libelle}")
	public List<Service> getServiceByLibelleService(@PathVariable(name = "libelle") String libelle){
		
		return this.serviceService.findByLibelleServicer(libelle);
	}
	
	@PostMapping(path = "service/list")
	public Service createService( @RequestBody Service service) {
		
		return this.serviceService.save(service);
	}
	
	@PutMapping(path = "service/byCodSev/{id}")
	public Service updateService(@PathVariable(name = "id") String id, @RequestBody Service service) {
		
		return this.serviceService.edit(id, service);
	}
	
	@DeleteMapping(path = "service/byCodSev/{id}")
	public Boolean deleteService(@PathVariable(name = "id") String id) {
		
		return this.serviceService.delete(id);
	}	
	
	
	/*###########################################################
	#############	Partie réservée pour utilisateur
	###########################################################
	*/
	@GetMapping(path = "user/list")
	public List<Utilisateur> getAllUser(){
		
		return this.utilisateurService.getAll();
	}
	
	@GetMapping(path = "user/byCodUser/{id}")
	public Optional<Utilisateur> getUserById(@PathVariable(name = "id") Long id){
		
		return this.utilisateurService.findById(id);
	}
	
	@GetMapping(path = "user/byService/{sev}")
	public List<Utilisateur> getUserByService(@PathVariable(name = "sev") Service sev){
		
		return this.utilisateurService.findByServiceUtilisateur(sev);
	}
	
	@GetMapping(path = "user/byActiveUser/{actUser}")
	public List<Utilisateur> getUserByActiveUser(@PathVariable(name = "actUser") boolean actUser){
		
		return this.utilisateurService.findByActiveUtilisateur(actUser);
	}
	
	@GetMapping(path = "user/byFonUser/{fonc}")
	public List<Utilisateur> getUserByFonctionUser(@PathVariable(name = "fonc") Long fonc){
		
		return this.utilisateurService.findByFonctionUtilisateur(fonc);
	}
	
	@GetMapping(path = "user/byNomUser/{nom}")
	public List<Utilisateur> getUserByNomUser(@PathVariable(name = "nom") Long nom){
		
		return this.utilisateurService.findByNomUtilisateur(nom);
	}
	
	@PostMapping(path = "user/list")
	public Utilisateur createUser( @RequestBody Utilisateur user) {
		
		return this.utilisateurService.save(user);
	}
	
	@PutMapping(path = "user/byCodUser/{id}")
	public Utilisateur updateUser(@PathVariable(name = "id") Long id, @RequestBody Utilisateur user) {
		
		return this.utilisateurService.edit(id, user);
	}
	
	@DeleteMapping(path = "user/byCodUser/{id}")
	public Boolean deleteUser(@PathVariable(name = "id") Long id) {
		
		return this.utilisateurService.delete(id);
	}	
	
	
	/*###########################################################
	#############	Partie réservée pour pays
	###########################################################
	*/
	@GetMapping(path = "pays/list")
	public List<Pays> getAllPays(){
		
		return this.paysService.findByAll();
	}
	
	@GetMapping(path = "pays/byCodPay/{id}")
	public Optional<Pays> getPaysById(@PathVariable(name = "id") String id){
		
		return this.paysService.findById(id);
	}
	
	@GetMapping(path = "pays/byNomPay/{nom}")
	public List<Pays> getPaysByLibelle(@PathVariable(name = "nom") String nom){
		
		return this.paysService.findByNom(nom);
	}
	
	@PostMapping(path = "pays/list")
	public Pays createPays( @RequestBody Pays pays) {
		
		return this.paysService.save(pays);
	}
	
	@PutMapping(path = "pays/byCodPay/{id}")
	public Pays updatePays(@PathVariable(name = "id") String id, @RequestBody Pays pays) {
		
		return this.paysService.modifiePays(pays, id);
	}
	
	@DeleteMapping(path = "pays/byCodPay/{id}")
	public Boolean deletePays(@PathVariable(name = "id") String id) {
		
		return this.paysService.supprimePays(id);
	}	
	
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
	
	@GetMapping(path = "departement/byNomDep/{nom}")
	public List<Departement> getDepartementByNom(@PathVariable(name = "nom") String nom){
		
		return this.departementService.findByNomDepartement(nom);
	}
	
	@GetMapping(path = "departement/byPays/{pay}")
	public List<Departement> getDepartementByNom(@PathVariable(name = "pay") Pays pay){
		
		return this.departementService.findByPays(pay);
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
	public Boolean deleteDepartement(@PathVariable(name = "id") String id) {
		
		return this.departementService.delete(id);
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
	
	@GetMapping(path = "commune/byCodDep/{codeDep}")
	public List<Commune> getCommuneByCodeDepartement(@PathVariable(name = "codeDep") Departement codeDep){
		
		return this.communeService.findByCodeDepartement(codeDep);
	}
	
	@GetMapping(path = "commune/byAdrMai/{adrMai}")
	public List<Commune> getCommuneByAdresseMairie(@PathVariable(name = "adrMai") String adrMai){
		
		return this.communeService.findByAdresseMairie(adrMai);
	}
	
	@GetMapping(path = "commune/byNomCom/{nom}")
	public List<Commune> getCommuneByNomCommune(@PathVariable(name = "nom") String nom){
		
		return this.communeService.findByNomCommune(nom);
	}
	
	@GetMapping(path = "commune/byCodCom/{codeCom}")
	public List<Commune> getCommuneByCodeCom(@PathVariable(name = "codeCom") String codeCom){
		
		return this.communeService.findByCodeCommune(codeCom);
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
	public Boolean deleteCommune(@PathVariable(name = "id") String id) {
		
		return this.communeService.delete(id);
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
	
	@GetMapping(path = "arrondissement/byCom/{com}")
	public List<Arrondissement> getArrondissementByCommune(@PathVariable(name = "com") Commune com){
		
		return this.arrondissementService.findByCommune(com);
	}
	
	@GetMapping(path = "arrondissement/byNomArr/{nom}")
	public List<Arrondissement> getArrondissementByNomArrondissement(@PathVariable(name = "nom") String nom){
		
		return this.arrondissementService.findByNomArrondi(nom);
	}
	
	@GetMapping(path = "arrondissement/byCodArr/{code}")
	public List<Arrondissement> getArrondissementByCodeArrondissement(@PathVariable(name = "code") String code){
		
		return this.arrondissementService.findByCodeArrondi(code);
	}
	
	@GetMapping(path = "arrondissement/byAdrArr/{adresse}")
	public List<Arrondissement> getArrondissementByCommune(@PathVariable(name = "adresse") String adresse){
		
		return this.arrondissementService.findByAdresseArrondi(adresse);
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
	public Boolean deleteArrondissement(@PathVariable(name = "id") String id) {
		
		return this.arrondissementService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour quartier
	###########################################################
	*/
	@GetMapping(path = "quartier/list")
	public List<Quartier> getAllQuartier(){
		
		return this.quartierService.getAll();
	}
	
	@GetMapping(path = "quartier/byCodQua/{id}")
	public Optional<Quartier> getQuartierById(@PathVariable(name = "id") String id){
		
		return this.quartierService.findById(id);
	}
	
	@GetMapping(path = "quartier/byNomQua/{nom}")
	public List<Quartier> getQuartierByNom(@PathVariable(name = "nom") String nom){
		
		return this.quartierService.findByNomQuartier(nom);
	}
	
	@GetMapping(path = "quartier/byArrQua/{arrondissement}")
	public List<Quartier> getQuartierbByArrondissement(@PathVariable(name = "arrondissement") String arrondissement){
		
		return this.quartierService.findByNomQuartier(arrondissement);
	}
	
	@GetMapping(path = "quartier/byAdrQua/{adresse}")
	public List<Quartier> getQuartierbByAdresse(@PathVariable(name = "adresse") String adresse){
		
		return this.quartierService.findByAdresseQuartier(adresse);
	}
	
	@PostMapping(path = "quartier/list")
	public Quartier createPays( @RequestBody Quartier quartier) {
		
		return this.quartierService.save(quartier);
	}
	
	@PutMapping(path = "quartier/byCodQua/{id}")
	public Quartier updateQuartier(@PathVariable(name = "id") String id, @RequestBody Quartier quartier) {
		
		return this.quartierService.edit(id, quartier);
	}
	
	@DeleteMapping(path = "quartier/byCodQua/{id}")
	public Boolean deleteQuartier(@PathVariable(name = "id") String id) {
		
		return this.quartierService.delete(id);
	}	
	
	
	
}
