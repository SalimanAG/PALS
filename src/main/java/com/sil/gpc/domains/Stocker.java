package com.sil.gpc.domains;

import javax.persistence.Entity;

@Entity
public class Stocker {

	private String codeMagasin;
	private String codeArticle;
	private Long quantiterStocker;
	private Long stockDeSecuriter;
	private Long stockMinimal;
	private Long cmup;
	
	public Stocker() {
		super();
	}

	public Stocker(String codeMagasin, String codeArticle, Long quantiterStocker, Long stockDeSecuriter,
			Long stockMinimal, Long cmup) {
		super();
		this.codeMagasin = codeMagasin;
		this.codeArticle = codeArticle;
		this.quantiterStocker = quantiterStocker;
		this.stockDeSecuriter = stockDeSecuriter;
		this.stockMinimal = stockMinimal;
		this.cmup = cmup;
	}

	public String getCodeMagasin() {
		return codeMagasin;
	}

	public void setCodeMagasin(String codeMagasin) {
		this.codeMagasin = codeMagasin;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public Long getQuantiterStocker() {
		return quantiterStocker;
	}

	public void setQuantiterStocker(Long quantiterStocker) {
		this.quantiterStocker = quantiterStocker;
	}

	public Long getStockDeSecuriter() {
		return stockDeSecuriter;
	}

	public void setStockDeSecuriter(Long stockDeSecuriter) {
		this.stockDeSecuriter = stockDeSecuriter;
	}

	public Long getStockMinimal() {
		return stockMinimal;
	}

	public void setStockMinimal(Long stockMinimal) {
		this.stockMinimal = stockMinimal;
	}

	public Long getCmup() {
		return cmup;
	}

	public void setCmup(Long cmup) {
		this.cmup = cmup;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cmup == null) ? 0 : cmup.hashCode());
		result = prime * result + ((codeArticle == null) ? 0 : codeArticle.hashCode());
		result = prime * result + ((codeMagasin == null) ? 0 : codeMagasin.hashCode());
		result = prime * result + ((quantiterStocker == null) ? 0 : quantiterStocker.hashCode());
		result = prime * result + ((stockDeSecuriter == null) ? 0 : stockDeSecuriter.hashCode());
		result = prime * result + ((stockMinimal == null) ? 0 : stockMinimal.hashCode());
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
		Stocker other = (Stocker) obj;
		if (cmup == null) {
			if (other.cmup != null)
				return false;
		} else if (!cmup.equals(other.cmup))
			return false;
		if (codeArticle == null) {
			if (other.codeArticle != null)
				return false;
		} else if (!codeArticle.equals(other.codeArticle))
			return false;
		if (codeMagasin == null) {
			if (other.codeMagasin != null)
				return false;
		} else if (!codeMagasin.equals(other.codeMagasin))
			return false;
		if (quantiterStocker == null) {
			if (other.quantiterStocker != null)
				return false;
		} else if (!quantiterStocker.equals(other.quantiterStocker))
			return false;
		if (stockDeSecuriter == null) {
			if (other.stockDeSecuriter != null)
				return false;
		} else if (!stockDeSecuriter.equals(other.stockDeSecuriter))
			return false;
		if (stockMinimal == null) {
			if (other.stockMinimal != null)
				return false;
		} else if (!stockMinimal.equals(other.stockMinimal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stocker [codeMagasin=" + codeMagasin + ", codeArticle=" + codeArticle + ", quantiterStocker="
				+ quantiterStocker + ", stockDeSecuriter=" + stockDeSecuriter + ", stockMinimal=" + stockMinimal
				+ ", cmup=" + cmup + "]";
	}
	
	
}
