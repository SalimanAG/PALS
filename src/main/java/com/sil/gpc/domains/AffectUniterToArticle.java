package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class AffectUniterToArticle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAffectUniterToArticle;
	
	//Liaison à la article
		@ManyToOne(targetEntity = Article.class, fetch = FetchType.EAGER)
		@JoinColumn(name = "numArticle", referencedColumnName = "numArticle", nullable = false)
		private Article article;
	
	//Liaison à la unité
		@ManyToOne(targetEntity = Uniter.class, fetch = FetchType.EAGER)
		@JoinColumn(name = "numUniter", referencedColumnName = "numUniter", nullable = false)
		private Uniter uniter;

	public AffectUniterToArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AffectUniterToArticle(Long idAffectUniterToArticle, Article article, Uniter uniter) {
		super();
		this.idAffectUniterToArticle = idAffectUniterToArticle;
		this.article = article;
		this.uniter = uniter;
	}

	public Long getIdAffectUniterToArticle() {
		return idAffectUniterToArticle;
	}

	public void setIdAffectUniterToArticle(Long idAffectUniterToArticle) {
		this.idAffectUniterToArticle = idAffectUniterToArticle;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Uniter getUniter() {
		return uniter;
	}

	public void setUniter(Uniter uniter) {
		this.uniter = uniter;
	}

	@Override
	public String toString() {
		return "AffectUniterToArticle [idAffectUniterToArticle=" + idAffectUniterToArticle + ", article=" + article
				+ ", uniter=" + uniter + "]";
	}

	
	
	

	
}
