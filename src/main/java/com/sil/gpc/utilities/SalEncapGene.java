package com.sil.gpc.utilities;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.Magasin;

public class SalEncapGene {
	
	private Magasin magasin;
	private Article article;
	
	
	public SalEncapGene() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SalEncapGene(Magasin magasin, Article article) {
		super();
		this.magasin = magasin;
		this.article = article;
	}


	public Magasin getMagasin() {
		return magasin;
	}


	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}


	@Override
	public String toString() {
		return "SalEncapGene [magasin=" + magasin + ", article=" + article + "]";
	}
	
	
	
}
