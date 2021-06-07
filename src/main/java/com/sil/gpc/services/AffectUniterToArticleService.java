package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.AffectUniterToArticle;
import com.sil.gpc.repositories.AffectUniterToArticleRepository;

@Service
public class AffectUniterToArticleService {

	private final AffectUniterToArticleRepository repo;

	public AffectUniterToArticleService(AffectUniterToArticleRepository repo) {
		super();
		this.repo = repo;
	}
	
	public AffectUniterToArticle save(AffectUniterToArticle affectUniterToArticle) {
		if(!repo.existsById(affectUniterToArticle.getIdAffectUniterToArticle())) {
			return this.repo.save(affectUniterToArticle);
		}
		return null;
	}
	
	public AffectUniterToArticle edit(Long id, AffectUniterToArticle affectUniterToArticle) {
		
		AffectUniterToArticle entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setArticle(affectUniterToArticle.getArticle());
			entiter.setUniter(affectUniterToArticle.getUniter());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		AffectUniterToArticle entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public AffectUniterToArticle getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<AffectUniterToArticle> getAll(){
		
		return this.repo.findAll();
	}

	
}
