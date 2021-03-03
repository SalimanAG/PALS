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

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.Famille;
import com.sil.gpc.domains.Gerer;
import com.sil.gpc.domains.Magasin;
import com.sil.gpc.domains.Magasinier;
import com.sil.gpc.domains.PlageNumArticle;
import com.sil.gpc.domains.PlageNumDispo;
import com.sil.gpc.domains.Stocker;
import com.sil.gpc.domains.Uniter;
import com.sil.gpc.services.ArticleService;
import com.sil.gpc.services.FamilleService;
import com.sil.gpc.services.GererService;
import com.sil.gpc.services.MagasinService;
import com.sil.gpc.services.MagasinierService;
import com.sil.gpc.services.PlageNumArticleService;
import com.sil.gpc.services.PlageNumDispoService;
import com.sil.gpc.services.StockerService;
import com.sil.gpc.services.UniterService;

@CrossOrigin
@RestController
@RequestMapping(path = "/perfora-gpc/v1/stock/")
public class MagasinController {

	private final MagasinService magasinService;
	private final MagasinierService magasinierService;
	private final FamilleService familleService;
	private final ArticleService articleService;
	private final UniterService uniterService;
	private final GererService gererService;
	private final PlageNumArticleService plageNumArticleService;
	private final PlageNumDispoService plageNumDispoService;
	private final StockerService stockerService;
	
	public MagasinController(MagasinService magasinService, MagasinierService magasinierService,
			FamilleService familleService, ArticleService articleService, UniterService uniterService,
			GererService gererService, PlageNumArticleService plageNumArticleService,
			PlageNumDispoService plageNumDispoService, StockerService stockerService) {
		super();
		this.magasinService = magasinService;
		this.magasinierService = magasinierService;
		this.familleService = familleService;
		this.articleService = articleService;
		this.uniterService = uniterService;
		this.gererService = gererService;
		this.plageNumArticleService = plageNumArticleService;
		this.plageNumDispoService = plageNumDispoService;
		this.stockerService = stockerService;

		Magasin mg= magasinService.save(new Magasin("MC", "Magasin central"));
		Uniter U= uniterService.save(new Uniter("U", "Unité"));
		Famille F= familleService.save(new Famille("01", "Famille Etat Civil"));
		Famille F1= familleService.save(new Famille("02", "Famille Affaires domaniales"));
		Article a=new Article("01001", "Certificat de possession d'état", true, true, true, false, (long)500, "SM",F,U);
		Article art= articleService.save(new Article("01001", "Certificat de possession d'état", true, true, true, false, (long)500, "SM", F, U));
		Article art1= articleService.save(new Article("01002", "Certificat de position militaire", true, true, true, false, (long)200, "SM", F, U));
		Article art2= articleService.save(new Article("01003", "Certificat de résidence", true, true, true, false, (long)500, "SM", F, U));
		Article art3= articleService.save(new Article("01004", "Certificat de de vie et de charge", true, true, true, false, (long)300, "SM", F, U));
		Article art4= articleService.save(new Article("01005", "Timbre de légalisation à 400", true, true, true, false, (long)400, "SM", F, U));
		Article art5= articleService.save(new Article("02001", "Convention de vente de parcelle", true, true, true, false, (long)4000, "SM", F1, U));
		Article art6= articleService.save(new Article("02002", "Convention de vente de maison", true, true, true, false, (long)10000, "SM", F1, U));
		Article art7= articleService.save(new Article("02003", "Timbbre de légalisation de vente de bien meuble", true, true, true, false, (long)10000, "SM", F1, U));
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
	public Optional<Magasin> getMagasinById(@PathVariable(name = "id") String id){
		
		return this.magasinService.findById(id);
	}
	
	@PostMapping(path = "magasin/list")
	public Magasin createMagasin( @RequestBody Magasin magasin) {
		
		return this.magasinService.save(magasin);
	}
	
	@PutMapping(path = "magasin/byCodMag/{id}")
	public Magasin updateMagasin(@PathVariable(name = "id") String id, @RequestBody Magasin magasin) {
		
		return this.magasinService.edit(magasin, id);
	}
	
	@DeleteMapping(path = "magasin/byCodMag/{id}")
	public Boolean deleteMagasin(@PathVariable(name = "id") String id) {
		
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
	public Optional<Famille> getFamilleById(@PathVariable(name = "id") String id){
		
		return this.familleService.getById(id);
	}
	
	@PostMapping(path = "famille/list")
	public Famille createFamille( @RequestBody Famille famille) {
		
		return this.familleService.save(famille);
	}
	
	@PutMapping(path = "famille/byCodFam/{id}")
	public Famille updateFamille(@PathVariable(name = "id") String id, @RequestBody Famille famille) {
		
		return this.familleService.edit(id, famille);
	}
	
	@DeleteMapping(path = "famille/byCodFam/{id}")
	public Boolean deleteFamille(@PathVariable(name = "id") String id) {
		
		return this.familleService.delete(id);
	}
	
	
	/*###########################################################
	#############	Partie réservée pour article
	###########################################################
	*/
	
	@GetMapping(path = "article/list")
	public List<Article> getAllArticle(){
		
		return this.articleService.getAll();
	}
	
	@GetMapping(path = "article/byCodArt/{id}")
	public Optional<Article> getCaisseById(@PathVariable(name = "id") String id){
		
		return this.articleService.getById(id);
	}
	
	@PostMapping(path = "article/list")
	public Article createArticle( @RequestBody Article article) {
		
		return this.articleService.save(article);
	}
	
	@PutMapping(path = "article/byCodArt/{id}")
	public Article updateArticle(@PathVariable(name = "id") String id, @RequestBody Article article) {
		
		return this.articleService.edit(id, article);
	}
	
	@DeleteMapping(path = "article/byCodArt/{id}")
	public Boolean deleteArticle(@PathVariable(name = "id") String id) {
		
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
	public Optional<Uniter> getUniterById(@PathVariable(name = "id") String id){
		
		return this.uniterService.findById(id);
	}
	
	@PostMapping(path = "uniter/list")
	public Uniter createUniter( @RequestBody Uniter uniter) {
		
		return this.uniterService.save(uniter);
	}
	
	@PutMapping(path = "uniter/byCodUni/{id}")
	public Uniter updateUniter(@PathVariable(name = "id") String id, @RequestBody Uniter uniter) {
		
		return this.uniterService.edit(id, uniter);
	}
	
	@DeleteMapping(path = "uniter/byCodUni/{id}")
	public Boolean deleteUniter(@PathVariable(name = "id") String id) {
		
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
	#############	Partie réservée pour Plage Numéro Article
	###########################################################
	*/
	
	@GetMapping(path = "plageNumArticle/list")
	public List<PlageNumArticle> getAllPlageNumArticle(){
		
		return this.plageNumArticleService.findAll();
	}
	
	@GetMapping(path = "plageNumArticle/byCodPlaNumArt/{id}")
	public Optional<PlageNumArticle> getPlageNumArticleById(@PathVariable(name = "id") Long id){
		
		return this.plageNumArticleService.recherchePlage(id);
	}
	
	@PostMapping(path = "plageNumArticle/list")
	public PlageNumArticle createPlageNumArticle( @RequestBody PlageNumArticle plageNumArticle) {
		
		return this.plageNumArticleService.save(plageNumArticle);
	}
	
	@PutMapping(path = "plageNumArticle/byCodPlaNumArt/{id}")
	public PlageNumArticle updatePlageNumArticle(@PathVariable(name = "id") Long id, @RequestBody PlageNumArticle plageNumArticle) {
		
		return this.plageNumArticleService.edit(plageNumArticle, id);
	}
	
	@DeleteMapping(path = "plageNumArticle/byCodPlaNumArt/{id}")
	public Boolean deletePlageNumArticle(@PathVariable(name = "id") Long id) {
		
		return this.plageNumArticleService.delete(id);
	}
	
	
	
	/*###########################################################
	#############	Partie réservée pour Plage Numéro Dispo
	###########################################################
	*/
	
	@GetMapping(path = "plageNumDispo/list")
	public List<PlageNumDispo> getAllPlageNumDispo(){
		
		return this.plageNumDispoService.findAll();
	}
	
	@GetMapping(path = "plageNumDispo/byCodPlaNumDis/{id}")
	public Optional<PlageNumDispo> getPlageNumDispoById(@PathVariable(name = "id") String id){
		
		return this.plageNumDispoService.findById(id);
	}
	
	@PostMapping(path = "plageNumDispo/list")
	public PlageNumDispo createPlageNumDispo( @RequestBody PlageNumDispo plageNumDispo) {
		
		return this.plageNumDispoService.save(plageNumDispo);
	}
	
	@PutMapping(path = "plageNumDispo/byCodPlaNumDis/{id}")
	public PlageNumDispo updatePlageNumDispo(@PathVariable(name = "id") String id, @RequestBody PlageNumDispo plageNumDispo) {
		
		return this.plageNumDispoService.edit(plageNumDispo, id);
	}
	
	@DeleteMapping(path = "plageNumDispo/byCodPlaNumDis/{id}")
	public Boolean deletePlageNumDispo(@PathVariable(name = "id") String id) {
		
		return this.plageNumDispoService.delete(id);
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
	
	@PutMapping(path = "stocker/byCodSto/{id}")
	public Stocker updateStocker(@PathVariable(name = "id") Long id, @RequestBody Stocker stocker) {
		
		return this.stockerService.edit(id, stocker);
	}
	
	@DeleteMapping(path = "stocker/byCodSto/{id}")
	public Boolean deleteStocker(@PathVariable(name = "id") Long id) {
		
		return this.stockerService.delete(id);
	}	
	
	
	
}
