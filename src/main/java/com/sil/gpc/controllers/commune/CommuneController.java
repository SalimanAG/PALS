package com.sil.gpc.controllers.commune;


import java.sql.Date;
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

import com.sil.gpc.domains.AffectDroitGroupUser;
import com.sil.gpc.domains.AffectUserGroup;
import com.sil.gpc.domains.AffectUserToArrondi;
import com.sil.gpc.domains.Arrondissement;
import com.sil.gpc.domains.CategorieFrs;
import com.sil.gpc.domains.CauseAnomalie;
import com.sil.gpc.domains.Civilite;
import com.sil.gpc.domains.CloturePeriodiq;
import com.sil.gpc.domains.Commune;
import com.sil.gpc.domains.Departement;
import com.sil.gpc.domains.Direction;
import com.sil.gpc.domains.DroitUser;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.Fonction;
import com.sil.gpc.domains.Fournisseur;
import com.sil.gpc.domains.GroupUser;
import com.sil.gpc.domains.Service;
import com.sil.gpc.domains.TypeService;
import com.sil.gpc.domains.Pays;
import com.sil.gpc.domains.Profession;
import com.sil.gpc.domains.Quartier;
import com.sil.gpc.domains.Utilisateur;
import com.sil.gpc.encapsuleurs.EncapGroupeDroits;
import com.sil.gpc.encapsuleurs.EncapUserGroupes;
import com.sil.gpc.repositories.DroitUserRepository;
import com.sil.gpc.repositories.GroupUserRepository;
import com.sil.gpc.services.AffectDroitGroupUserService;
import com.sil.gpc.services.AffectUserGroupService;
import com.sil.gpc.services.AffectUserToArrondiService;
import com.sil.gpc.services.ArrondissementService;
import com.sil.gpc.services.CategorieFrsService;
import com.sil.gpc.services.CauseAnomalieService;
import com.sil.gpc.services.CloturePeriodiqService;
import com.sil.gpc.services.CommuneService;
import com.sil.gpc.services.DepartementService;
import com.sil.gpc.services.DirectionService;
import com.sil.gpc.services.DroitUserService;
import com.sil.gpc.services.ExerciceService;
import com.sil.gpc.services.FournisseurService;
import com.sil.gpc.services.GroupUserService;
import com.sil.gpc.services.PaysService;
import com.sil.gpc.services.QuartierService;
import com.sil.gpc.services.ServiceService;
import com.sil.gpc.services.TypeServiceService;
import com.sil.gpc.services.UtilisateurService;
import com.sil.gpc.utilities.SalDate;
import com.sil.gpc.services.CiviliteService;
import com.sil.gpc.services.FonctionService;
import com.sil.gpc.services.ProfessionService;

@RestController
@CrossOrigin
@RequestMapping(path = "/perfora-stock/v1/commune/")
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
	private final GroupUserService ug;
	private final AffectDroitGroupUserService dgus;
	private final AffectUserGroupService aug;
	private final DroitUserService du;
	private final AffectUserToArrondiService auta;
	private final CategorieFrsService categorieFrsService;
	private final CauseAnomalieService causeAnomalieService;
	private final DirectionService directionService;
	private final CloturePeriodiqService cloturePeriodiqService;
	private final TypeServiceService typeServiceService;
	private final CiviliteService civiliteService;
	private final FonctionService fonctionService;
	private final ProfessionService professionService;
	private final GroupUserRepository groupUserRepository;
	private final DroitUserRepository droitUserRepository;

	public CommuneController(ExerciceService exerciceService, FournisseurService fournisseurService,
			ServiceService serviceService, UtilisateurService utilisateurService, PaysService paysService,
			DepartementService departementService, CommuneService communeService,
			ArrondissementService arrondissementService, QuartierService quartierService,
			GroupUserService ug,
			AffectDroitGroupUserService dgus, AffectUserGroupService aug, DroitUserService du,
			AffectUserToArrondiService auta, DirectionService directionService, CloturePeriodiqService cloturePeriodiqService, CauseAnomalieService causeAnomalieService, 
			CategorieFrsService categorieFrsService, TypeServiceService typeServiceService, CiviliteService civiliteService, FonctionService fonctionService, ProfessionService professionService, DroitUserRepository droitUserRepository, GroupUserRepository groupUserRepository ) {
		this.exerciceService = exerciceService;
		this.fournisseurService = fournisseurService;
		this.serviceService = serviceService;
		this.utilisateurService = utilisateurService;
		this.paysService = paysService;
		this.departementService = departementService;
		this.communeService = communeService;
		this.arrondissementService = arrondissementService;
		this.quartierService = quartierService;
		this.ug = ug;
		this.dgus = dgus;
		this.aug = aug;
		this.du = du;
		this.auta = auta;
		this.categorieFrsService = categorieFrsService;
		this.causeAnomalieService = causeAnomalieService;
		this.directionService = directionService;
		this.cloturePeriodiqService = cloturePeriodiqService;
		this.typeServiceService = typeServiceService;
		this.civiliteService = civiliteService;
		this.fonctionService = fonctionService;
		this.professionService = professionService;
		this.groupUserRepository = groupUserRepository;
		this.droitUserRepository = droitUserRepository;
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
	public Optional<Exercice> getExerciceById(@PathVariable(name = "id") Long id){
		
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
	public Exercice updateExercice(@PathVariable(name = "id") Long id, @RequestBody Exercice exercice) {
		
		return this.exerciceService.edit(id, exercice);
	}
	
	@DeleteMapping(path = "exercice/byCodExe/{id}")
	public Boolean deleteExercice(@PathVariable(name = "id") Long id) {
		
		return this.exerciceService.delete(id);
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
	public Optional<Fournisseur> getFournisseurById(@PathVariable(name = "id") Long id){
		
		return this.fournisseurService.getById(id);
	}
	
	@PostMapping(path = "fournisseur/list")
	public Fournisseur createFournisseur( @RequestBody Fournisseur fournisseur) {
		
		return this.fournisseurService.save(fournisseur);
	}
	
	@PostMapping(path = "fournisseur/list2")
	public List<Fournisseur> createFournisseurByList( @RequestBody List<Fournisseur> fournisseurs) {
		
		return this.fournisseurService.save2(fournisseurs);
	}
	
	@PutMapping(path = "fournisseur/byCodFou/{id}")
	public Fournisseur updateFournisseur(@PathVariable(name = "id") Long id, @RequestBody Fournisseur fournisseur) {
		
		return this.fournisseurService.edit(id, fournisseur);
	}
	
	@DeleteMapping(path = "fournisseur/byCodFou/{id}")
	public Boolean deleteFournisseur(@PathVariable(name = "id") Long id) {
		
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
	public Optional<Service> getServiceById(@PathVariable(name = "id") Long id){
		
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
	
	@PostMapping(path = "service/list2")
	public List<Service> createServiceByList( @RequestBody List<Service> services) {
		
		return this.serviceService.saveByList(services);
	}
	
	@PutMapping(path = "service/byCodSev/{id}")
	public Service updateService(@PathVariable(name = "id") Long id, @RequestBody Service service) {
		
		return this.serviceService.edit(id, service);
	}
	
	@DeleteMapping(path = "service/byCodSev/{id}")
	public Boolean deleteService(@PathVariable(name = "id") Long id) {
		
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
	
	
	@GetMapping(path = "user/byNomUser/{nom}")
	public List<Utilisateur> getUserByNomUser(@PathVariable(name = "nom") Long nom){
		
		return this.utilisateurService.findByNomUtilisateur(nom);
	}
	
	
	@GetMapping(path = "/utilisat/askMdp/{login}")
	public void getUserAskMdp(@PathVariable(name = "login") String nom){
		
		
	}
	
	@GetMapping(path = "user/byLoginUser/{login}")
	public Utilisateur getUserByLogin(@PathVariable(name = "login") String login){

		return this.utilisateurService.findByLoginUtilisateur(login);
	}
	
	@PostMapping(path = "user/byLoginMdpUser")
	public Utilisateur getUserByLoginMdpUser(@RequestBody Utilisateur user){
		
		return this.utilisateurService.findByLoginAndMdp(user.getLogin(), user.getMotDePass());
	}
	
	@PostMapping(path = "user/list")
	public Utilisateur createUser( @RequestBody Utilisateur user) {
		
		return this.utilisateurService.save(user);
	}
	
	@PostMapping(path = "user/list2")
	public EncapUserGroupes createUserByEncap( @RequestBody EncapUserGroupes encapUserGroupes) {
		
		return this.utilisateurService.save2(encapUserGroupes);
	}
	
	@PostMapping(path = "user/list3")
	public List<Utilisateur> createUserByList( @RequestBody List<Utilisateur> utilisateurs) {
		
		return this.utilisateurService.save3(utilisateurs);
	}
	
	@PutMapping(path = "user/byCodUser/{id}")
	public Utilisateur updateUser(@PathVariable(name = "id") Long id, @RequestBody Utilisateur user) {
		
		return this.utilisateurService.edit(id, user);
	}
	
	@PutMapping(path = "user/byCodUser2/{id}")
	public EncapUserGroupes updateUserByEncap(@PathVariable(name = "id") Long id, @RequestBody EncapUserGroupes encapUserGroupes) {
		
		return this.utilisateurService.edit2(id, encapUserGroupes);
	}
	
	@DeleteMapping(path = "user/byCodUser/{id}")
	public Boolean deleteUser(@PathVariable(name = "id") Long id) {
		
		return this.utilisateurService.delete(id);
	}	
	

	@DeleteMapping(path = "user/byCodUser2/{id}")
	public Boolean deleteUserByEncap(@PathVariable(name = "id") Long id) {
		
		return this.utilisateurService.delete2(id);
	}
	
	/*###########################################################
	#############	Partie réservée pour AffectDroitGroupeUser
	###########################################################
	*/
	@GetMapping(path = "adgu/list")
	public List<AffectDroitGroupUser> getAllDroitsGroup(){
		
		return this.dgus.getAll();
	}
	
	@GetMapping(path = "adgu/byId/{id}")
	public Optional<AffectDroitGroupUser> getDroitGroupeUser(@PathVariable(name = "id") Long id){
		
		return this.dgus.findById(id);
	}
	
	@GetMapping(path = "adgu/bygro/{gu}")
	public List<AffectDroitGroupUser> getDroitGroupByGroup(@PathVariable(name = "gu") GroupUser gu){
		
		return this.dgus.findByGroup(gu);
	}
	
	@GetMapping(path = "adgu/bydro/{du}")
	public List<AffectDroitGroupUser> getDroitGroupByDroit(@PathVariable(name = "du") DroitUser du){
		
		return this.dgus.findByDroit(du);
	}
	
	@PostMapping(path = "adgu/list")
	public AffectDroitGroupUser createaffectDroitGroup( @RequestBody AffectDroitGroupUser adgu) {
		
		return this.dgus.save(adgu);
	}
	
	@PutMapping(path = "adgu/byid/{id}")
	public AffectDroitGroupUser updatedroitGroup(@PathVariable(name = "id") Long id, @RequestBody AffectDroitGroupUser adgu) {
		
		return this.dgus.edit(id, adgu);
	}
	
	@DeleteMapping(path = "user/byidr/{id}")
	public Boolean deleteDroitGroup(@PathVariable(name = "id") Long id) {
		
		return this.dgus.delete(id);	
	}
	
	
	/*###########################################################
	#############	Partie réservée pour AffectUserGroup
	###########################################################
	*/

	@GetMapping(path = "ug/list")
	public List<AffectUserGroup> getAllgroups(){
		
		return this.aug.getAll();
	}
	
	@GetMapping(path = "aug/byId/{id}")
	public Optional<AffectUserGroup> getGroupeUser(@PathVariable(name = "id") Long id){
		
		return this.aug.findById(id);
	}
	
	@GetMapping(path = "aug/bygro/{gro}")
	public List<AffectUserGroup> getUserGroupBygroup(@PathVariable(name = "gu") GroupUser gu){
		
		return this.aug.findByGroups(gu);
	}
	
	@GetMapping(path = "aug/byUse/{du}")
	public List<AffectUserGroup> getUserByDroit(@PathVariable(name = "du") Utilisateur u){
		
		return this.aug.findByUser(u);
	}
	
	@GetMapping(path = "aug/userGroup/{id}")
	public List<GroupUser> getAllGroupUserForUser(@PathVariable(name = "id") Long id){
		System.out.println(id);
		//return this.aug.getAllGroupUserForUser(id);
		return this.groupUserRepository.finAllGroupeUserForUser(id);
	}
	
	@PostMapping(path = "aug/list")
	public AffectUserGroup createAffectUserGroup( @RequestBody AffectUserGroup agu) {
		
		return this.aug.save(agu);
	}
	
	@PutMapping(path = "aug/byid/{id}")
	public AffectUserGroup updateAffectUserGroup(@PathVariable(name = "id") Long id, @RequestBody AffectUserGroup agu) {
		
		return this.aug.edit(id, agu);
	}
	
	@DeleteMapping(path = "aug/byidAGU/{id}")
	public Boolean deleteUserToGroup(@PathVariable(name = "id") Long id) {
		
		return this.aug.delete(id);
}	
	
	
	/*###########################################################
	#############	Partie réservée pour DroitUser
	###########################################################
	*/

	@GetMapping(path = "du/list")
	public List<DroitUser> getAllDroits(){
		
		return this.du.getAll();
	}
	
	@GetMapping(path = "du/byId/{id}")
	public Optional<DroitUser> getDroitUser(@PathVariable(name = "id") Long id){
		
		return this.du.findById(id);
	}
	
	@GetMapping(path = "du/byCodDro/{cdu}")
	public List<DroitUser> droitUserBycode(@PathVariable(name = "cdu") String cdu){
		
		return this.du.findByCodedroit(cdu);
	}
	
	@GetMapping(path = "du/byLib/{lib}")
	public List<DroitUser> getDroitByLib(@PathVariable(name = "lib") String lib){
		
		return this.du.findByLibDroitId(lib);
	}
	
	@PostMapping(path = "du/list")
	public DroitUser createDroitUser( @RequestBody DroitUser dus) {
		
		return this.du.save(dus);
	}
	
	@PutMapping(path = "du/byid/{id}")
	public DroitUser updateDroit(@PathVariable(name = "id") Long id, @RequestBody DroitUser du) {
		
		return this.du.edit(id, du);
	}
	
	@DeleteMapping(path = "du/byid/{id}")
	public Boolean deleteDroitUser(@PathVariable(name = "id") Long id) {
		
		return this.du.delete(id);
}	
	
	
	/*###########################################################
	#############	Partie réservée pour GoupUser
	###########################################################
	*/

	@GetMapping(path = "gro/list")
	public List<GroupUser> getAllGroups(){
		
		return this.ug.getAll();
	}
	
	@GetMapping(path = "gro/byId/{id}")
	public Optional<GroupUser> getGroupe(@PathVariable(name = "id") Long id){
		
		return this.ug.findById(id);
	}
	
	@GetMapping(path = "gro/byLib/{lib}")
	public List<GroupUser> getGroupByLib(@PathVariable(name = "lib") String lib){
		
		return this.ug.findByLib(lib);
	}

	@GetMapping(path = "gro/byGroupUserId/{id}")
	public List<DroitUser> getDroitUserForGroupeUser(@PathVariable(name = "id") Long id){

		//return this.dgus.getAllDroitUserForGroupUser(id);
		//return this.affectDroitGroupUserRepository.finAllDroitUserForGroupUser(id);
		return  this.droitUserRepository.finAllDroitUserForGroupUser(id);
	}
	
	@PostMapping(path = "gro/list")
	public GroupUser createGroupUser( @RequestBody GroupUser group) {
		
		return this.ug.save(group);
	}
	
	@PostMapping(path = "gro/list2")
	public EncapGroupeDroits createGroupUserByEncap( @RequestBody EncapGroupeDroits encapGroupeDroits) {
		
		return this.ug.save2(encapGroupeDroits);
	}
	
	@PutMapping(path = "gro/byid/{id}")
	public GroupUser updateGroup(@PathVariable(name = "id") Long id, @RequestBody GroupUser g) {
		
		return this.ug.edit(id, g);
	}
	
	@PutMapping(path = "gro/byid2/{id}")
	public EncapGroupeDroits updateGroupByEncap(@PathVariable(name = "id") Long id, @RequestBody EncapGroupeDroits encapGroupeDroits) {
		
		return this.ug.edit2(id, encapGroupeDroits);
	}
	
	@DeleteMapping(path = "gro/byid/{id}")
	public Boolean deleteGroup(@PathVariable(name = "id") Long id) {
		
		return this.ug.delete(id);
	}
	
	@DeleteMapping(path = "gro/byid2/{id}")
	public Boolean deleteGroupByEncap(@PathVariable(name = "id") Long id) {
		
		return this.ug.delete2(id);
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
	public Quartier createQuartier( @RequestBody Quartier quartier) {
		
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

	
	
	/*###########################################################
	#############	Partie réservée pour AffectUserToArrondi
	###########################################################
	*/
	@GetMapping(path = "affectUserToArrondi/list")
	public List<AffectUserToArrondi> getAllAffectUserArrondi(){
		
		return this.auta.getAll();
	}
	
	@GetMapping(path = "affectAnUserToArrondi/byCodAffUseToArr/{id}")
	public AffectUserToArrondi getUserArrondiId(@PathVariable(name = "id") Long id){
		
		return this.auta.findAnAffect(id);
	}
	
	@PostMapping(path = "affectUserToArrondi/list")
	public AffectUserToArrondi createUserArrondi( @RequestBody AffectUserToArrondi userArrondi) {
		
		return this.auta.save(userArrondi);
	}
	
	@PutMapping(path = "affectUserToArrondi/byCodAffUseToArr/{id}")
public AffectUserToArrondi updateUserArrondi(@PathVariable(name = "id") Long id, @RequestBody AffectUserToArrondi userArrondi) {
		return this.auta.edit(id, userArrondi);
	}
	
	@DeleteMapping(path = "affectUserToArrondi/byCodAffUseToArr/{id}")
	public Boolean deleteUserArrondi(@PathVariable(name = "id") Long id) {
		
		return this.auta.delete(id);
	}	
	

	/*###########################################################
	#############	Partie réservée pour CategorieFrs
	###########################################################
	*/
	@GetMapping(path = "categorieFrs/list")
	public List<CategorieFrs> getAllCategorieFrs(){
		
		return this.categorieFrsService.getAll();
	}
	
	@GetMapping(path = "categorieFrs/byCodCatFrs/{id}")
	public CategorieFrs getCategorieFrsById(@PathVariable(name = "id") Long id){
		
		return this.categorieFrsService.getById(id);
	}
	
	@PostMapping(path = "categorieFrs/list")
	public CategorieFrs createCategorieFrs( @RequestBody CategorieFrs categorieFrs) {
		
		return this.categorieFrsService.save(categorieFrs);
	}
	
	@PostMapping(path = "categorieFrs/list2")
	public List<CategorieFrs> createCategorieFrsByList( @RequestBody List<CategorieFrs> categorieFrs) {
		
		return this.categorieFrsService.saveByList(categorieFrs);
	}
	
	@PutMapping(path = "categorieFrs/byCodCatFrs/{id}")
	public CategorieFrs updateCategorieFrs(@PathVariable(name = "id") Long id, @RequestBody CategorieFrs categorieFrs) {
		return this.categorieFrsService.edit(id, categorieFrs);
	}
	
	@DeleteMapping(path = "categorieFrs/byCodCatFrs/{id}")
	public Boolean deleteCategorieFrs(@PathVariable(name = "id") Long id) {
		
		return this.categorieFrsService.delete(id);
	}	

	
	
	/*###########################################################
	#############	Partie réservée pour CauseAnomalie
	###########################################################
	*/
	@GetMapping(path = "causeAnomalie/list")
	public List<CauseAnomalie> getAllCauseAnomalie(){
		
		return this.causeAnomalieService.getAll();
	}
	
	@GetMapping(path = "causeAnomalie/byCodCauAno/{id}")
	public CauseAnomalie getCauseAnomalieById(@PathVariable(name = "id") Long id){
		
		return this.causeAnomalieService.getById(id);
	}
	
	@PostMapping(path = "causeAnomalie/list")
	public CauseAnomalie createCauseAnomalie( @RequestBody CauseAnomalie causeAnomalie) {
		
		return this.causeAnomalieService.save(causeAnomalie);
	}
	
	@PutMapping(path = "causeAnomalie/byCodCauAno/{id}")
	public CauseAnomalie updateCauseAnomalie(@PathVariable(name = "id") Long id, @RequestBody CauseAnomalie causeAnomalie) {
		return this.causeAnomalieService.edit(id, causeAnomalie);
	}
	
	@DeleteMapping(path = "causeAnomalie/byCodCauAno/{id}")
	public Boolean deleteCauseAnomalie(@PathVariable(name = "id") Long id) {
		
		return this.causeAnomalieService.delete(id);
	}	

	
	
	/*###########################################################
	#############	Partie réservée pour TypeService
	###########################################################
	*/
	@GetMapping(path = "typeService/list")
	public List<TypeService> getAllTypeService(){
		
		return this.typeServiceService.getAll();
	}
	
	@GetMapping(path = "typeService/byCodTypSer/{id}")
	public TypeService getTypeServiceById(@PathVariable(name = "id") Long id){
		
		return this.typeServiceService.getById(id);
	}
	
	@PostMapping(path = "typeService/list")
	public TypeService createTypeService( @RequestBody TypeService typeService) {
		
		return this.typeServiceService.save(typeService);
	}
	
	@PostMapping(path = "typeService/list2")
	public List<TypeService> createTypeServiceByList( @RequestBody List<TypeService> typeServices) {
		
		return this.typeServiceService.saveByList(typeServices);
	}
	
	@PutMapping(path = "typeService/byCodTypSer/{id}")
	public TypeService updateDirection(@PathVariable(name = "id") Long id, @RequestBody TypeService typeService) {
		return this.typeServiceService.edit(id, typeService);
	}
	
	@DeleteMapping(path = "typeService/byCodTypSer/{id}")
	public Boolean deleteTypeService(@PathVariable(name = "id") Long id) {
		
		return this.typeServiceService.delete(id);
	}	

	
	/*###########################################################
	#############	Partie réservée pour CloturePeriodiq
	###########################################################
	*/
	@GetMapping(path = "cloturePeriodiq/list")
	public List<CloturePeriodiq> getAllCloturePeriodiq(){
		
		return this.cloturePeriodiqService.getAll();
	}
	
	@GetMapping(path = "cloturePeriodiq/byCodCloPer/{id}")
	public CloturePeriodiq getCloturePeriodiqById(@PathVariable(name = "id") Long id){
		
		return this.cloturePeriodiqService.getById(id);
	}
	
	@PostMapping(path = "cloturePeriodiq/isCloturedByDate")
	public boolean getIfPeriodIsCloturedByDate(@RequestBody SalDate date){
		
		return this.cloturePeriodiqService.isPeriodeClotured(date.getDate());
	}
	
	@PostMapping(path = "cloturePeriodiq/list")
	public CloturePeriodiq createCloturePeriodiq( @RequestBody CloturePeriodiq cloturePeriodiq) {
		
		return this.cloturePeriodiqService.save(cloturePeriodiq);
	}
	
	@PutMapping(path = "cloturePeriodiq/byCodCloPer/{id}")
	public CloturePeriodiq updateCloturePeriodiq(@PathVariable(name = "id") Long id, @RequestBody CloturePeriodiq cloturePeriodiq) {
		return this.cloturePeriodiqService.edit(id, cloturePeriodiq);
	}
	
	@DeleteMapping(path = "cloturePeriodiq/byCodCloPer/{id}")
	public Boolean deleteCloturePeriodiq(@PathVariable(name = "id") Long id) {
		
		return this.cloturePeriodiqService.delete(id);
	}	
	
	
	/*###########################################################
	#############	Partie réservée pour Direction
	###########################################################
	*/
	@GetMapping(path = "direction/list")
	public List<Direction> getAllDirection(){
		
		return this.directionService.getAll();
	}
	
	@GetMapping(path = "direction/byCodDir/{id}")
	public Direction getDirectionById(@PathVariable(name = "id") Long id){
		
		return this.directionService.getById(id);
	}
	
	@PostMapping(path = "direction/list")
	public Direction createDirection( @RequestBody Direction direction) {
		
		return this.directionService.save(direction);
	}
	
	@PostMapping(path = "direction/list2")
	public List<Direction> createDirectionByList( @RequestBody List<Direction> directions) {
		
		return this.directionService.saveByList(directions);
	}
	
	@PutMapping(path = "direction/byCodDir/{id}")
	public Direction updateDirection(@PathVariable(name = "id") Long id, @RequestBody Direction direction) {
		return this.directionService.edit(id, direction);
	}
	
	@DeleteMapping(path = "direction/byCodDir/{id}")
	public Boolean deleteDirection(@PathVariable(name = "id") Long id) {
		
		return this.directionService.delete(id);
	}	
	
	
	/*###########################################################
	#############	Partie réservée pour Civilite
	###########################################################
	*/
	@GetMapping(path = "civilite/list")
	public List<Civilite> getAllCivilite(){
		
		return this.civiliteService.getAll();
	}
	
	@GetMapping(path = "civilite/byCodCiv/{id}")
	public Civilite getCiviliteById(@PathVariable(name = "id") Long id){
		
		return this.civiliteService.getById(id);
	}
	
	@PostMapping(path = "civilite/list")
	public Civilite createCivilite( @RequestBody Civilite civilite) {
		
		return this.civiliteService.save(civilite);
	}
	
	
	@PutMapping(path = "civilite/byCodCiv/{id}")
	public Civilite updateCivilite(@PathVariable(name = "id") Long id, @RequestBody Civilite civilite) {
		return this.civiliteService.edit(id, civilite);
	}
	
	@DeleteMapping(path = "civilite/byCodCiv/{id}")
	public Boolean deleteCivilite(@PathVariable(name = "id") Long id) {
		
		return this.civiliteService.delete(id);
	}	



	/*###########################################################
	#############	Partie réservée pour Fonction
	###########################################################
	*/
	@GetMapping(path = "fonction/list")
	public List<Fonction> getAllFonction(){
		
		return this.fonctionService.getAll();
	}
	
	@GetMapping(path = "fonction/byCodFon/{id}")
	public Fonction getFonctionById(@PathVariable(name = "id") Long id){
		
		return this.fonctionService.getById(id);
	}
	
	@PostMapping(path = "fonction/list")
	public Fonction createFonction( @RequestBody Fonction fonction) {
		
		return this.fonctionService.save(fonction);
	}
	
	
	@PutMapping(path = "fonction/byCodFon/{id}")
	public Fonction updateFonction(@PathVariable(name = "id") Long id, @RequestBody Fonction fonction) {
		return this.fonctionService.edit(id, fonction);
	}
	
	@DeleteMapping(path = "fonction/byCodFon/{id}")
	public Boolean deleteFonction(@PathVariable(name = "id") Long id) {
		
		return this.fonctionService.delete(id);
	}	

	

	/*###########################################################
	#############	Partie réservée pour Profession
	###########################################################
	*/
	@GetMapping(path = "profession/list")
	public List<Profession> getAllProfession(){
		
		return this.professionService.getAll();
	}
	
	@GetMapping(path = "profession/byCodPro/{id}")
	public Profession getProfessionById(@PathVariable(name = "id") Long id){
		
		return this.professionService.getById(id);
	}
	
	@PostMapping(path = "profession/list")
	public Profession createProfession( @RequestBody Profession profession) {
		
		return this.professionService.save(profession);
	}
	
	
	@PutMapping(path = "profession/byCodPro/{id}")
	public Profession updateProfession(@PathVariable(name = "id") Long id, @RequestBody Profession profession) {
		return this.professionService.edit(id, profession);
	}
	
	@DeleteMapping(path = "profession/byCodPro/{id}")
	public Boolean deleteProfession(@PathVariable(name = "id") Long id) {
		
		return this.professionService.delete(id);
	}	



	
	
}
