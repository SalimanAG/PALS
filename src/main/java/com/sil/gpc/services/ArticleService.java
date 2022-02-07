package com.sil.gpc.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.Famille;
import com.sil.gpc.domains.Stocker;
import com.sil.gpc.domains.Uniter;
import com.sil.gpc.repositories.ArticleRepository;
import com.sil.gpc.repositories.StockerRepository;

@Service
public class ArticleService {

	private final ArticleRepository repo;
	private final StockerRepository repo2;

	public ArticleService(ArticleRepository repo, StockerRepository repo2) {
		super();
		this.repo = repo;
		this.repo2 = repo2;
	}
	
	public Article save(Article article) {
		
		return this.repo.save(article);
	}
	
	public List<Article> saveByList(List<Article> articles) {
		
		return this.repo.saveAll(articles);
	}
	
	@Transactional
	public List<Article> saveByList2(List<Article> articles) {
		
		List<Article> lister = new ArrayList<Article>();
		
		List<Stocker> stockerList = this.repo2.findAll();
		
		for(int i = 0; i<articles.size(); i++) {
			if(this.repo.existsById(articles.get(i).getNumArticle())) {
				Article entiter = this.repo.getOne(articles.get(i).getNumArticle());
				if(true) {//(entiter.getExo() == null) {
					entiter.setQteStIniTres(articles.get(i).getQteStIniTres());
					entiter.setPuStIniTres(articles.get(i).getPuStIniTres());
					entiter.setDatStInitArtTres(new Date(System.currentTimeMillis()));
					entiter.setExo(articles.get(i).getExo());
					
					boolean finded = false;
					
					for(int j = 0; j < stockerList.size(); j++) {
						if(stockerList.get(j).getArticle().getNumArticle() == entiter.getNumArticle() 
								&& stockerList.get(j).getMagasin().getNumMagasin() == entiter.getFamille().getMagasin().getNumMagasin()) {
							finded = true;
							
							//Stocker elem = stockerList.get(j);
							
							//elem.setCmup(entiter.getPuStIniTres());
							//elem.setQuantiterStocker(entiter.getQteStIniTres());
							
							//this.repo2.save(elem);
							
							break;
						}
					}
					
					if(finded == false) {
						this.repo2.save(new Stocker(null, entiter.getQteStIniTres(), 0, 0, entiter.getPuStIniTres(), entiter, entiter.getFamille().getMagasin()));
					}
					
					lister.add(this.repo.save(entiter)) ;
				}
			}
		}
		

		
		return lister;
	}
	
	public Article edit(Long id, Article article) {
		
		Article entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setCodeArticle(article.getCodeArticle());
			entiter.setConsommableArticle(article.isConsommableArticle());
			entiter.setCouleurArticle(article.getCouleurArticle());
			entiter.setLibArticle(article.getLibArticle());
			entiter.setLivrableArticle(article.isLivrableArticle());
			entiter.setNumSerieArticle(article.isNumSerieArticle());
			entiter.setPrixVenteArticle(article.getPrixVenteArticle());
			entiter.setStockerArticle(article.isStockerArticle());
			entiter.setFamille(article.getFamille());
			entiter.setAbregerArticle(article.getAbregerArticle());
			entiter.setAfficherArticle(article.isAfficherArticle());
			entiter.setCodeBareArticle(article.getCodeBareArticle());
			entiter.setCompteArticle(article.getCompteArticle());
			entiter.setFournisseur(article.getFournisseur());
			entiter.setSpecialiterArticle(article.getSpecialiterArticle());
			entiter.setTaxeSpecifiqArticle(article.getTaxeSpecifiqArticle());
			entiter.setTvaArticle(article.getTvaArticle());
			entiter.setCmupActuArticle(article.getCmupActuArticle());
			entiter.setStockSecurArticle(article.getStockSecurArticle());
			entiter.setStockMinimArticle(article.getStockMinimArticle());
			entiter.setStockAlertArticle(article.getStockAlertArticle());
			entiter.setTypeArticle(article.getTypeArticle());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		Article entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public Optional<Article> getById(Long id){
		
		return this.repo.findById(id);
	}
	
	public List<Article> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Article> findByCodeArticle(String codeArticle){
		
		return this.repo.findByCodeArticle(codeArticle);
	}
	
	public List<Article> findByLibArticle(String libArticle){
		
		return this.repo.findByLibArticle(libArticle);
	}
	
	public List<Article> findByPrixVenteArticle(Long prixVenteArticle){
		
		return this.repo.findByPrixVenteArticle(prixVenteArticle);
	}
	
	public List<Article> findByCouleurArticle(String couleurArticle){
		
		return this.repo.findByCouleurArticle(couleurArticle);
	}
	
	public List<Article> findByFamille(Famille famille){
		
		return this.repo.findByFamille(famille);
	}
	
	public List<Article> findByUnite(Uniter uniter){
		
		return null;
	}
	
	public List<Article> findByStockerArticle(boolean stockerArticle){
		
		return this.repo.findByStockerArticle(stockerArticle);
	}
	
	public List<Article> findByNumSerieArticle(boolean numSerieArticle){
		
		return this.repo.findByNumSerieArticle(numSerieArticle);
	}
	
	public List<Article> findByLivrableArticle(boolean livrableArticle){
		
		return this.repo.findByLivrableArticle(livrableArticle);
	}
	
	public List<Article> findByConsommableArticle(boolean consommableArticle){
		
		return this.repo.findByConsommableArticle(consommableArticle);
	}
	
	public List<Article> findByAffichableArticle(boolean affichableArticle){
		
		return this.repo.findByAffichableArticle(affichableArticle);
	}
	
	
	
}
