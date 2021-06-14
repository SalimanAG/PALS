package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.TypeArticle;
import com.sil.gpc.repositories.TypeArticleRepository;

@Service
public class TypeArticleService {

	private final TypeArticleRepository repo;

	public TypeArticleService(TypeArticleRepository repo) {
		super();
		this.repo = repo;
	}
	
	public TypeArticle save(TypeArticle typeArticle) {
		return this.repo.save(typeArticle);
	}
	
	public TypeArticle edit(Long id, TypeArticle typeArticle) {
		
		TypeArticle entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setCodeTypeArt(typeArticle.getCodeTypeArt());
			entiter.setLibTypeArt(typeArticle.getLibTypeArt());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		TypeArticle entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public TypeArticle getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<TypeArticle> getAll(){
		
		return this.repo.findAll();
	}


	
}
