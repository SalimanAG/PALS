package com.sil.gpc.controllers.stock;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.sil.gpc.domains.AffectUniterToArticle;
import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.Famille;
import com.sil.gpc.domains.Gerer;
import com.sil.gpc.domains.Inventaire;
import com.sil.gpc.domains.LigneInventaire;
import com.sil.gpc.domains.Magasin;
import com.sil.gpc.domains.Magasinier;
import com.sil.gpc.domains.Stocker;
import com.sil.gpc.domains.TypeArticle;
import com.sil.gpc.domains.Uniter;
import com.sil.gpc.encapsuleurs.EncapInventaire;
import com.sil.gpc.repositories.ArticleRepository;
import com.sil.gpc.repositories.FamilleRepository;
import com.sil.gpc.services.AffectUniterToArticleService;
import com.sil.gpc.services.ArticleService;
import com.sil.gpc.services.FamilleService;
import com.sil.gpc.services.GererService;
import com.sil.gpc.services.InventaireService;
import com.sil.gpc.services.LigneInventaireService;
import com.sil.gpc.services.MagasinService;
import com.sil.gpc.services.MagasinierService;
import com.sil.gpc.services.StockerService;
import com.sil.gpc.services.TypeArticleService;
import com.sil.gpc.services.UniterService;
import com.sil.gpc.utilities.SalEncapGene;

@CrossOrigin
@RestController
@RequestMapping(path = "/perfora-stock/v1/stock/")
public class MagasinController {

	private final MagasinService magasinService;
	private final MagasinierService magasinierService;
	private final FamilleService familleService;
	private final ArticleService articleService;
	private final UniterService uniterService;
	private final GererService gererService;
	private final StockerService stockerService;
	private final LigneInventaireService lInvServ;
	private final InventaireService invServ;
	private final AffectUniterToArticleService affectUniterToArticleService;
	private final TypeArticleService typeArticleService;
	private  final  ArticleRepository articleRepository;
	
	@Autowired
	FamilleRepository familleRepository;
	
	
	
	public MagasinController(MagasinService magasinService, MagasinierService magasinierService,
			FamilleService familleService, ArticleService articleService, UniterService uniterService,
			GererService gererService, StockerService stockerService, LigneInventaireService lInvServ,
			InventaireService invServ, TypeArticleService typeArticleService, AffectUniterToArticleService affectUniterToArticleService, ArticleRepository articleRepository) {
		super();
		this.magasinService = magasinService;
		this.magasinierService = magasinierService;
		this.familleService = familleService;
		this.articleService = articleService;
		this.uniterService = uniterService;
		this.gererService = gererService;
		this.stockerService = stockerService;
		this.lInvServ = lInvServ;
		this.invServ = invServ;
		this.affectUniterToArticleService = affectUniterToArticleService;
		this.typeArticleService = typeArticleService;
		this.articleRepository = articleRepository;
	}

	/*###########################################################
	#############	Partie réservée pour magasin
	###########################################################
	*/
	
	@GetMapping(path = "magasin/list")
	public List<Magasin> getAllMagasin(){
		
		return this.magasinService.findAll();
	}
	
	@GetMapping(path = "magasin/byCodMag/{id}")
	public Optional<Magasin> getMagasinById(@PathVariable(name = "id") Long id){
		
		return this.magasinService.findById(id);
	}
	
	@PostMapping(path = "magasin/list")
	public Magasin createMagasin( @RequestBody Magasin magasin) {
		
		return this.magasinService.save(magasin);
	}
	
	@PostMapping(path = "magasin/list2")
	public List<Magasin> createMagasinByList( @RequestBody List<Magasin> magasins) {
		
		return this.magasinService.saveByList(magasins);
	}
	
	@PutMapping(path = "magasin/byCodMag/{id}")
	public Magasin updateMagasin(@PathVariable(name = "id") Long id, @RequestBody Magasin magasin) {
		
		return this.magasinService.edit(magasin, id);
	}
	
	@DeleteMapping(path = "magasin/byCodMag/{id}")
	public Boolean deleteMagasin(@PathVariable(name = "id") Long id) {
		
		return this.magasinService.delete(id);
	}	
	
	
	
	/*###########################################################
	#############	Partie réservée pour magasinier
	###########################################################
	*/
	
	@GetMapping(path = "magasinier/list")
	public List<Magasinier> getAllMagasinier(){
		
		return this.magasinierService.findAll();
	}
	
	@GetMapping(path = "magasinier/byCodMag/{id}")
	public Optional<Magasinier> getMagasinierById(@PathVariable(name = "id") Long id){
		
		return this.magasinierService.findById(id);
	}
	
	@PostMapping(path = "magasinier/list")
	public Magasinier createMagasinier( @RequestBody Magasinier magasinier) {
		
		return this.magasinierService.save(magasinier);
	}
	
	@PutMapping(path = "magasinier/byCodMag/{id}")
	public Magasinier updateMagasinier(@PathVariable(name = "id") Long id, @RequestBody Magasinier magasinier) {
		
		return this.magasinierService.edit(magasinier, id);
	}
	
	@DeleteMapping(path = "magasinier/byCodMag/{id}")
	public Boolean deleteMagasinier(@PathVariable(name = "id") Long id) {
		
		return this.magasinierService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour famille
	###########################################################
	*/
	
	@GetMapping(path = "famille/list")
	public List<Famille> getAllFamille(){
		
		return this.familleService.getAll();
	}
	
	@GetMapping(path = "famille/byCodFam/{id}")
	public Optional<Famille> getFamilleById(@PathVariable(name = "id") Long id){
		
		return this.familleService.getById(id);
	}
	
	@PostMapping(path = "famille/list")
	public Famille createFamille( @RequestBody Famille famille) {
		
		return this.familleService.save(famille);
	}
	
	@PostMapping(path = "famille/list2")
	public List<Famille> createFamilleByList( @RequestBody List<Famille> familles) {
		
		return this.familleService.save2(familles);
	}
	
	@PutMapping(path = "famille/byCodFam/{id}")
	public Famille updateFamille(@PathVariable(name = "id") Long id, @RequestBody Famille famille) {
		
		return this.familleService.edit(id, famille);
	}
	
	@DeleteMapping(path = "famille/byCodFam/{id}")
	public Boolean deleteFamille(@PathVariable(name = "id") Long id) {
		
		return this.familleService.delete(id);
	}
	
	//Add
	@GetMapping(path = "famille/list-by-magasin/{numMagasin}")
	public List<Famille> getAllFamilleByMagasin(@PathVariable Long numMagasin){
		
		return familleRepository.findAllByMagasin_NumMagasin(numMagasin);
	}
	/*###########################################################
	#############	Partie réservée pour article
	###########################################################
	*/
	
	@GetMapping(path = "article/list0")
	public List<Article> getAllArticle(){
		
		return this.articleService.getAll();
	}
	
	@GetMapping(path = "article/list")
	public List<Article> getAllArticleAffichable(){
		
		return this.articleService.findByAffichableArticle(true);
	}
	
	@GetMapping(path = "article/byCodArt/{id}")
	public Optional<Article> getCaisseById(@PathVariable(name = "id") Long id){
		
		return this.articleService.getById(id);
	}
	
	@GetMapping(path = "article/listByCodMag/{id}")
	public List<Article> getAllArticleByMagasin(@PathVariable(name = "id") Long id){

		return this.articleRepository.finAllArticleForMagasin(id);
	}
	
	@PostMapping(path = "article/list")
	public Article createArticle( @RequestBody Article article) {
		
		return this.articleService.save(article);
	}
	
	@PostMapping(path = "article/list2")
	public List<Article> createArticleByList( @RequestBody List<Article> articles) {
		
		return this.articleService.saveByList(articles);
	}
	
	@PostMapping(path = "article/list3")
	public List<Article> createStockInitArticleByList( @RequestBody List<Article> articles) {
		
		return this.articleService.saveByList2(articles);
	}
	
	@PutMapping(path = "article/byCodArt/{id}")
	public Article updateArticle(@PathVariable(name = "id") Long id, @RequestBody Article article) {
		
		return this.articleService.edit(id, article);
	}
	
	@DeleteMapping(path = "article/byCodArt/{id}")
	public Boolean deleteArticle(@PathVariable(name = "id") Long id) {
		
		return this.articleService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour unité
	###########################################################
	*/
	
	@GetMapping(path = "uniter/list")
	public List<Uniter> getAllUniter(){
		
		return this.uniterService.getAll();
	}
	
	@GetMapping(path = "uniter/byCodUni/{id}")
	public Optional<Uniter> getUniterById(@PathVariable(name = "id") Long id){
		
		return this.uniterService.findById(id);
	}
	
	@PostMapping(path = "uniter/list")
	public Uniter createUniter( @RequestBody Uniter uniter) {
		
		return this.uniterService.save(uniter);
	}
	
	@PostMapping(path = "uniter/list2")
	public List<Uniter> createUniterByList( @RequestBody List<Uniter> uniters) {
		
		return this.uniterService.saveByList(uniters);
	}
	
	@PutMapping(path = "uniter/byCodUni/{id}")
	public Uniter updateUniter(@PathVariable(name = "id") Long id, @RequestBody Uniter uniter) {
		
		return this.uniterService.edit(id, uniter);
	}
	
	@DeleteMapping(path = "uniter/byCodUni/{id}")
	public Boolean deleteUniter(@PathVariable(name = "id") Long id) {
		
		return this.uniterService.delete(id);
	}	
	
	
	
	/*###########################################################
	#############	Partie réservée pour gérer
	###########################################################
	*/
	
	@GetMapping(path = "gerer/list")
	public List<Gerer> getAllGerer(){
		
		return this.gererService.getAll();
	}
	
	@GetMapping(path = "gerer/byCodGer/{id}")
	public Optional<Gerer> getGererById(@PathVariable(name = "id") Long id){
		
		return this.gererService.getById(id);
	}
	
	@PostMapping(path = "gerer/list")
	public Gerer createGerer( @RequestBody Gerer gerer) {
		
		return this.gererService.save(gerer);
	}
	
	@PutMapping(path = "gerer/byCodGer/{id}")
	public Gerer updateGerer(@PathVariable(name = "id") Long id, @RequestBody Gerer gerer) {
		
		return this.gererService.edit(id, gerer);
	}
	
	@DeleteMapping(path = "gerer/byCodGer/{id}")
	public Boolean deleteGerer(@PathVariable(name = "id") Long id) {
		
		return this.gererService.delete(id);
	}

	
	
	/*###########################################################
	#############	Partie réservée pour stocker
	###########################################################
	*/
	
	@GetMapping(path = "stocker/list")
	public List<Stocker> getAllStocker(){	
		return this.stockerService.getAll();
	}
	
	@GetMapping(path = "stocker/byCodSto/{id}")
	public Optional<Stocker> getStockerById(@PathVariable(name = "id") Long id){	
		return this.stockerService.findById(id);
	}
	
	@PostMapping(path = "stocker/list")
	public Stocker createStocker( @RequestBody Stocker stocker) {
		return this.stockerService.save(stocker);
	}
	
	@PostMapping(path = "stocker/findByArticleAndMagasin")
	public Stocker findAStockerByArticleAndMagasin( @RequestBody SalEncapGene donner) {
		return this.stockerService.findByArticleAndMagasin(donner.getArticle().getNumArticle(), donner.getMagasin().getNumMagasin());
	}
	
	@PutMapping(path = "stocker/byCodSto/{id}")
	public Stocker updateStocker(@PathVariable(name = "id") Long id, @RequestBody Stocker stocker) {
		
		return this.stockerService.edit(id, stocker);
	}
	
	@DeleteMapping(path = "stocker/byCodSto/{id}")
	public Boolean deleteStocker(@PathVariable(name = "id") Long id) {
		
		return this.stockerService.delete(id);
	}	

	/*###########################################################
	#############	Partie réservée pour Inventaire
	###########################################################
	*/
	
	@GetMapping(path = "inventaire/list")
	public List<Inventaire> getAllInventaire(){	
		return this.invServ.findAll();
	}
	
	@GetMapping(path = "inventaire/byCodSto/{id}")
	public Optional<Inventaire> getInventaireById(@PathVariable(name = "id") String id){	
		return this.invServ.findById(id);
	}
	
	@GetMapping(path = "inventaire/byCodExo/{codExo}")
	public List<Inventaire> getInventaireByCodeExo(@PathVariable(name = "codExo") String id){	
		return this.invServ.findByCodeExercice(id);
	}
	
	@PostMapping(path = "inventaire/list")
	public Inventaire createInventaire( @RequestBody Inventaire inv) {
		return this.invServ.save(inv);
	}
	
	@PostMapping(path = "inventaire/list2")
	public EncapInventaire createInventaireByEncap( @RequestBody EncapInventaire inv) {
		List<LigneInventaire> lignes = inv.getLigneInventaires();
		
		Inventaire element = this.invServ.save(inv.getInventaire());
		
		for (int i = 0; i < lignes.size(); i++) {
			LigneInventaire lig = lignes.get(i);
			lig.setInventaire(element);
			
			lignes.set(i, lig);
		}
		
		lignes = this.lInvServ.saveAll(lignes);
		
		return new EncapInventaire(element, lignes);
	}

	
	@PutMapping(path = "inventaire/byCodSto/{id}")
	public Inventaire updateInventaire(@PathVariable(name = "id") String id, @RequestBody Inventaire inv) {
		
		return this.invServ.edit(inv, id);
	}
	
	@PutMapping(path = "inventaire/byCodSto3/{id}")
	public Inventaire updateInventaireValidating(@PathVariable(name = "id") String id, @RequestBody Inventaire inv) {
		
		return this.invServ.edit3(inv, id);
	}
	
	@PutMapping(path = "inventaire/byCodSto2/{id}")
	public EncapInventaire updateInventaire2(@PathVariable(name = "id") String id, @RequestBody EncapInventaire encapInventaire) {
		
		return this.invServ.editByEncap(id, encapInventaire);
	}
	
	
	@DeleteMapping(path = "inventaire/byCodSto/{id}")
	public Boolean deleteInvent(@PathVariable(name = "id") String id) {
		
		return this.invServ.delete(id);
	}
	
	@DeleteMapping(path = "inventaire/byCodSto2/{id}")
	public Boolean deleteInvent2(@PathVariable(name = "id") String id) {
		
		return this.invServ.deleteAInventaire2(id);
	}

	/*###########################################################
	###########	Partie réservée pour LigneInventaire#############
	#############################################################
	*/
	
	@GetMapping(path = "ligneInventaire/list")
	public List<LigneInventaire> getAllLigneInventaire(){	
		return this.lInvServ.findAll();
	}
	
	@GetMapping(path = "ligneInventaire/byCodSto/{id}")
	public Optional<LigneInventaire> getLigneInventaireById(@PathVariable(name = "id") Long id){	
		return this.lInvServ.findById(id);
	}
	
	@GetMapping(path = "ligneInventaire/list/byCodeInv/{code}")
	public List<LigneInventaire> getLigneInventaireByCodeInventaire(@PathVariable(name = "code") String cod){	
		
		return this.lInvServ.findByCodeInventaire(cod);
		
	}
	
	@PostMapping(path = "ligneInventaire/list")
	public LigneInventaire createLigneInventaire( @RequestBody LigneInventaire livgInv) {
		return this.lInvServ.save(livgInv);
	}
	
	@PutMapping(path = "ligneInventaire/byCodSto/{id}")
	public LigneInventaire updateLigneInventaire(@PathVariable(name = "id") Long id, @RequestBody LigneInventaire ligInv) {
		
		return this.lInvServ.edit(ligInv, id);
	}
	
	@DeleteMapping(path = "ligneInventaire/byCodSto/{id}")
	public Boolean deleteLigneInventaire(@PathVariable(name = "id") Long id) {
		
		return this.lInvServ.delete(id);
	}	

	
	/*###########################################################
	###########	Partie réservée pour AffectUniterToArticle#############
	#############################################################
	*/
	
	@GetMapping(path = "affectUniterToArticle/list")
	public List<AffectUniterToArticle> getAllAffectUniterToArticle(){	
		return this.affectUniterToArticleService.getAll();
	}
	
	@GetMapping(path = "affectUniterToArticle/byIdAffUniToArti/{id}")
	public AffectUniterToArticle getLigneAffectUniterToArticleById(@PathVariable(name = "id") Long id){	
		return this.affectUniterToArticleService.getById(id);
	}
	
	@PostMapping(path = "affectUniterToArticle/list")
	public AffectUniterToArticle createAffectUniterToArticle( @RequestBody AffectUniterToArticle affectUniterToArticle) {
		return this.affectUniterToArticleService.save(affectUniterToArticle);
	}
	
	@PutMapping(path = "affectUniterToArticle/byIdAffUniToArti/{id}")
	public AffectUniterToArticle updateAffectUniterToArticle(@PathVariable(name = "id") Long id, @RequestBody AffectUniterToArticle affectUniterToArticle) {
		
		return this.affectUniterToArticleService.edit(id, affectUniterToArticle);
	}
	
	@DeleteMapping(path = "affectUniterToArticle/byIdAffUniToArti/{id}")
	public Boolean deleteAffectUniterToArticle(@PathVariable(name = "id") Long id) {
		
		return this.affectUniterToArticleService.delete(id);
	}	

	
	/*###########################################################
	###########	Partie réservée pour TypeArticle#############
	#############################################################
	*/
	
	@GetMapping(path = "typeArticle/list")
	public List<TypeArticle> getAllTypeArticle(){	
		return this.typeArticleService.getAll();
	}
	
	@GetMapping(path = "typeArticle/byCodTypArti/{id}")
	public TypeArticle getTypeArticleById(@PathVariable(name = "id") Long id){	
		return this.typeArticleService.getById(id);
	}
	
	@PostMapping(path = "typeArticle/list")
	public TypeArticle createTypeArticle( @RequestBody TypeArticle typeArticle) {
		return this.typeArticleService.save(typeArticle);
	}
	
	@PostMapping(path = "typeArticle/list2")
	public List<TypeArticle> createTypeArticleByList( @RequestBody List<TypeArticle> typeArticles) {
		return this.typeArticleService.saveByList(typeArticles);
	}
	
	@PutMapping(path = "typeArticle/byCodTypArti/{id}")
	public TypeArticle updateTypeArticle(@PathVariable(name = "id") Long id, @RequestBody TypeArticle typeArticle) {
		
		return this.typeArticleService.edit(id, typeArticle);
	}
	
	@DeleteMapping(path = "typeArticle/byCodTypArti/{id}")
	public Boolean deleteTypeArticle(@PathVariable(name = "id") Long id) {
		
		return this.typeArticleService.delete(id);
	}	

	
	
	
}
