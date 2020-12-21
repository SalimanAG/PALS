package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class PlageNumArticle implements Serializable {

	@Id
	@GeneratedValue
	private Long idPlage;
	private String numDebPlage;
	private String numFinPlage;

	@ManyToOne(cascade = CascadeType.DETACH,targetEntity = Article.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "codeArticle",referencedColumnName = "codeArticle",nullable = false)
	public Article article;
	
	private String numRecollement;
	private String numPlacement;
	private String numAppro;
	
	public PlageNumArticle() {
		super();
	}

	public PlageNumArticle(Long idPlage, String numDebPlage, String numFinPlage) {
		super();
		this.idPlage = idPlage;
		this.numDebPlage = numDebPlage;
		this.numFinPlage = numFinPlage;
	}

	public Long getIdPlage() {
		return idPlage;
	}

	public void setIdPlage(Long idPlage) {
		this.idPlage = idPlage;
	}

	public String getNumDebPlage() {
		return numDebPlage;
	}

	public void setNumDebPlage(String numDebPlage) {
		this.numDebPlage = numDebPlage;
	}

	public String getNumFinPlage() {
		return numFinPlage;
	}

	public void setNumFinPlage(String numFinPlage) {
		this.numFinPlage = numFinPlage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPlage == null) ? 0 : idPlage.hashCode());
		result = prime * result + ((numDebPlage == null) ? 0 : numDebPlage.hashCode());
		result = prime * result + ((numFinPlage == null) ? 0 : numFinPlage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlageNumArticle other = (PlageNumArticle) obj;
		if (idPlage == null) {
			if (other.idPlage != null)
				return false;
		} else if (!idPlage.equals(other.idPlage))
			return false;
		if (numDebPlage == null) {
			if (other.numDebPlage != null)
				return false;
		} else if (!numDebPlage.equals(other.numDebPlage))
			return false;
		if (numFinPlage == null) {
			if (other.numFinPlage != null)
				return false;
		} else if (!numFinPlage.equals(other.numFinPlage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlageNumArticle [idPlage=" + idPlage + ", numDebPlage=" + numDebPlage + ", numFinPlage=" + numFinPlage
				+ "]";
	}
	
}
