package com.sil.gpc.domaines;

import javax.persistence.Entity;

@Entity
public class Article {

	private String codeArticle;
	private String libArticle;
	private boolean stockerArticle;
	private boolean numSerieArticle;
	private boolean livrableArticle;
	private boolean consommableArticle;
	private Long prixVenteArticle;
	private String couleurArticle;
	private String codeFamille;
	private String codeUniter;
	
	public Article() {
		super();
	}

	public Article(String codeArticle, String libArticle, boolean stockerArticle, boolean numSerieArticle,
			boolean livrableArticle, boolean consommableArticle, Long prixVenteArticle, String couleurArticle,
			String codeFamille, String codeUniter) {
		super();
		this.codeArticle = codeArticle;
		this.libArticle = libArticle;
		this.stockerArticle = stockerArticle;
		this.numSerieArticle = numSerieArticle;
		this.livrableArticle = livrableArticle;
		this.consommableArticle = consommableArticle;
		this.prixVenteArticle = prixVenteArticle;
		this.couleurArticle = couleurArticle;
		this.codeFamille = codeFamille;
		this.codeUniter = codeUniter;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public String getLibArticle() {
		return libArticle;
	}

	public void setLibArticle(String libArticle) {
		this.libArticle = libArticle;
	}

	public boolean isStockerArticle() {
		return stockerArticle;
	}

	public void setStockerArticle(boolean stockerArticle) {
		this.stockerArticle = stockerArticle;
	}

	public boolean isNumSerieArticle() {
		return numSerieArticle;
	}

	public void setNumSerieArticle(boolean numSerieArticle) {
		this.numSerieArticle = numSerieArticle;
	}

	public boolean isLivrableArticle() {
		return livrableArticle;
	}

	public void setLivrableArticle(boolean livrableArticle) {
		this.livrableArticle = livrableArticle;
	}

	public boolean isConsommableArticle() {
		return consommableArticle;
	}

	public void setConsommableArticle(boolean consommableArticle) {
		this.consommableArticle = consommableArticle;
	}

	public Long getPrixVenteArticle() {
		return prixVenteArticle;
	}

	public void setPrixVenteArticle(Long prixVenteArticle) {
		this.prixVenteArticle = prixVenteArticle;
	}

	public String getCouleurArticle() {
		return couleurArticle;
	}

	public void setCouleurArticle(String couleurArticle) {
		this.couleurArticle = couleurArticle;
	}

	public String getCodeFamille() {
		return codeFamille;
	}

	public void setCodeFamille(String codeFamille) {
		this.codeFamille = codeFamille;
	}

	public String getCodeUniter() {
		return codeUniter;
	}

	public void setCodeUniter(String codeUniter) {
		this.codeUniter = codeUniter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeArticle == null) ? 0 : codeArticle.hashCode());
		result = prime * result + ((codeFamille == null) ? 0 : codeFamille.hashCode());
		result = prime * result + ((codeUniter == null) ? 0 : codeUniter.hashCode());
		result = prime * result + (consommableArticle ? 1231 : 1237);
		result = prime * result + ((couleurArticle == null) ? 0 : couleurArticle.hashCode());
		result = prime * result + ((libArticle == null) ? 0 : libArticle.hashCode());
		result = prime * result + (livrableArticle ? 1231 : 1237);
		result = prime * result + (numSerieArticle ? 1231 : 1237);
		result = prime * result + ((prixVenteArticle == null) ? 0 : prixVenteArticle.hashCode());
		result = prime * result + (stockerArticle ? 1231 : 1237);
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
		Article other = (Article) obj;
		if (codeArticle == null) {
			if (other.codeArticle != null)
				return false;
		} else if (!codeArticle.equals(other.codeArticle))
			return false;
		if (codeFamille == null) {
			if (other.codeFamille != null)
				return false;
		} else if (!codeFamille.equals(other.codeFamille))
			return false;
		if (codeUniter == null) {
			if (other.codeUniter != null)
				return false;
		} else if (!codeUniter.equals(other.codeUniter))
			return false;
		if (consommableArticle != other.consommableArticle)
			return false;
		if (couleurArticle == null) {
			if (other.couleurArticle != null)
				return false;
		} else if (!couleurArticle.equals(other.couleurArticle))
			return false;
		if (libArticle == null) {
			if (other.libArticle != null)
				return false;
		} else if (!libArticle.equals(other.libArticle))
			return false;
		if (livrableArticle != other.livrableArticle)
			return false;
		if (numSerieArticle != other.numSerieArticle)
			return false;
		if (prixVenteArticle == null) {
			if (other.prixVenteArticle != null)
				return false;
		} else if (!prixVenteArticle.equals(other.prixVenteArticle))
			return false;
		if (stockerArticle != other.stockerArticle)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Article [codeArticle=" + codeArticle + ", libArticle=" + libArticle + ", stockerArticle="
				+ stockerArticle + ", numSerieArticle=" + numSerieArticle + ", livrableArticle=" + livrableArticle
				+ ", consommableArticle=" + consommableArticle + ", prixVenteArticle=" + prixVenteArticle
				+ ", couleurArticle=" + couleurArticle + ", codeFamille=" + codeFamille + ", codeUniter=" + codeUniter
				+ "]";
	}
	
	
}
