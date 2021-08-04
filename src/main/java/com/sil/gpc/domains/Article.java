package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity

public class Article implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numArticle;
	@Column(unique = true)
	private String codeArticle;
	private String libArticle;
	private boolean stockerArticle;
	private boolean numSerieArticle;
	private boolean livrableArticle;
	private boolean consommableArticle;
	private Long prixVenteArticle;
	private String couleurArticle;
	private double qteStIniTres;;
	private double puStIniTres;
	private Date datStInitArtTres;
	private String specialiterArticle;
	private String abregerArticle;
	private String compteArticle;
	private String codeBareArticle;
	private double tvaArticle;
	private double taxeSpecifiqArticle;
	private boolean afficherArticle;
	private double cmupActuArticle;
	private double stockMinimArticle;
	private double stockAlertArticle;
	private double stockSecurArticle;
	

	//Migration de la clé de l'exercice
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Exercice.class)
	@JoinColumn(name = "ExoStInit", referencedColumnName = "codeExercice",nullable = true)
	public Exercice exo;
		
	//Migration du code de la famille vers l'article
	@ManyToOne(targetEntity = Famille.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "numFamille",referencedColumnName = "numFamille",nullable = true)
	private Famille famille;
	
	//Migration de la clé de l'unité vers l'article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Fournisseur.class)
	@JoinColumn(name = "numFournisseur", referencedColumnName = "numFournisseur",nullable = true)
	public Fournisseur fournisseur;
	
	//Migration de la clé de l'unité vers l'article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = TypeArticle.class)
	@JoinColumn(name = "numTypeArt", referencedColumnName = "numTypeArt",nullable = true)
	public TypeArticle typeArticle;
	
	
	public Article() {
		super();
	}

	
	


	public Article(Long numArticle, String codeArticle, String libArticle, boolean stockerArticle,
			boolean numSerieArticle, boolean livrableArticle, boolean consommableArticle, Long prixVenteArticle,
			String couleurArticle, double qteStIniTres, double puStIniTres, Date datStInitArtTres,
			String specialiterArticle, String abregerArticle, String compteArticle, String codeBareArticle,
			double tvaArticle, double taxeSpecifiqArticle, boolean afficherArticle, double cmupActuArticle,
			double stockMinimArticle, double stockAlertArticle, double stockSecurArticle, Exercice exo, Famille famille,
			Fournisseur fournisseur, TypeArticle typeArticle) {
		super();
		this.numArticle = numArticle;
		this.codeArticle = codeArticle;
		this.libArticle = libArticle;
		this.stockerArticle = stockerArticle;
		this.numSerieArticle = numSerieArticle;
		this.livrableArticle = livrableArticle;
		this.consommableArticle = consommableArticle;
		this.prixVenteArticle = prixVenteArticle;
		this.couleurArticle = couleurArticle;
		this.qteStIniTres = qteStIniTres;
		this.puStIniTres = puStIniTres;
		this.datStInitArtTres = datStInitArtTres;
		this.specialiterArticle = specialiterArticle;
		this.abregerArticle = abregerArticle;
		this.compteArticle = compteArticle;
		this.codeBareArticle = codeBareArticle;
		this.tvaArticle = tvaArticle;
		this.taxeSpecifiqArticle = taxeSpecifiqArticle;
		this.afficherArticle = afficherArticle;
		this.cmupActuArticle = cmupActuArticle;
		this.stockMinimArticle = stockMinimArticle;
		this.stockAlertArticle = stockAlertArticle;
		this.stockSecurArticle = stockSecurArticle;
		this.exo = exo;
		this.famille = famille;
		this.fournisseur = fournisseur;
		this.typeArticle = typeArticle;
	}





	public Long getNumArticle() {
		return numArticle;
	}





	public void setNumArticle(Long numArticle) {
		this.numArticle = numArticle;
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

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}


	/**
	 * @return the qteStIniTres
	 */
	public double getQteStIniTres() {
		return qteStIniTres;
	}

	/**
	 * @param qteStIniTres the qteStIniTres to set
	 */
	public void setQteStIniTres(double qteStIniTres) {
		this.qteStIniTres = qteStIniTres;
	}

	/**
	 * @return the puStIniTres
	 */
	public double getPuStIniTres() {
		return puStIniTres;
	}

	/**
	 * @param puStIniTres the puStIniTres to set
	 */
	public void setPuStIniTres(double puStIniTres) {
		this.puStIniTres = puStIniTres;
	}

	/**
	 * @return the datStInitArtTres
	 */
	public Date getDatStInitArtTres() {
		return datStInitArtTres;
	}

	/**
	 * @param datStInitArtTres the datStInitArtTres to set
	 */
	public void setDatStInitArtTres(Date datStInitArtTres) {
		this.datStInitArtTres = datStInitArtTres;
	}

	/**
	 * @return the exo
	 */
	public Exercice getExo() {
		return exo;
	}

	/**
	 * @param exo the exo to set
	 */
	public void setExo(Exercice exo) {
		this.exo = exo;
	}



	public String getSpecialiterArticle() {
		return specialiterArticle;
	}



	public void setSpecialiterArticle(String specialiterArticle) {
		this.specialiterArticle = specialiterArticle;
	}



	public String getAbregerArticle() {
		return abregerArticle;
	}



	public void setAbregerArticle(String abregerArticle) {
		this.abregerArticle = abregerArticle;
	}



	public String getCompteArticle() {
		return compteArticle;
	}



	public void setCompteArticle(String compteArticle) {
		this.compteArticle = compteArticle;
	}



	public String getCodeBareArticle() {
		return codeBareArticle;
	}



	public void setCodeBareArticle(String codeBareArticle) {
		this.codeBareArticle = codeBareArticle;
	}



	public double getTvaArticle() {
		return tvaArticle;
	}



	public void setTvaArticle(double tvaArticle) {
		this.tvaArticle = tvaArticle;
	}



	public double getTaxeSpecifiqArticle() {
		return taxeSpecifiqArticle;
	}



	public void setTaxeSpecifiqArticle(double taxeSpecifiqArticle) {
		this.taxeSpecifiqArticle = taxeSpecifiqArticle;
	}



	public boolean isAfficherArticle() {
		return afficherArticle;
	}



	public void setAfficherArticle(boolean afficherArticle) {
		this.afficherArticle = afficherArticle;
	}



	public Fournisseur getFournisseur() {
		return fournisseur;
	}



	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}



	public double getCmupActuArticle() {
		return cmupActuArticle;
	}





	public void setCmupActuArticle(double cmupActuArticle) {
		this.cmupActuArticle = cmupActuArticle;
	}





	public double getStockMinimArticle() {
		return stockMinimArticle;
	}





	public void setStockMinimArticle(double stockMinimArticle) {
		this.stockMinimArticle = stockMinimArticle;
	}





	public double getStockAlertArticle() {
		return stockAlertArticle;
	}





	public void setStockAlertArticle(double stockAlertArticle) {
		this.stockAlertArticle = stockAlertArticle;
	}





	public double getStockSecurArticle() {
		return stockSecurArticle;
	}





	public void setStockSecurArticle(double stockSecurArticle) {
		this.stockSecurArticle = stockSecurArticle;
	}





	public TypeArticle getTypeArticle() {
		return typeArticle;
	}





	public void setTypeArticle(TypeArticle typeArticle) {
		this.typeArticle = typeArticle;
	}





	@Override
	public String toString() {
		return "Article [numArticle=" + numArticle + ", codeArticle=" + codeArticle + ", libArticle=" + libArticle
				+ ", stockerArticle=" + stockerArticle + ", numSerieArticle=" + numSerieArticle + ", livrableArticle="
				+ livrableArticle + ", consommableArticle=" + consommableArticle + ", prixVenteArticle="
				+ prixVenteArticle + ", couleurArticle=" + couleurArticle + ", qteStIniTres=" + qteStIniTres
				+ ", puStIniTres=" + puStIniTres + ", datStInitArtTres=" + datStInitArtTres + ", specialiterArticle="
				+ specialiterArticle + ", abregerArticle=" + abregerArticle + ", compteArticle=" + compteArticle
				+ ", codeBareArticle=" + codeBareArticle + ", tvaArticle=" + tvaArticle + ", taxeSpecifiqArticle="
				+ taxeSpecifiqArticle + ", afficherArticle=" + afficherArticle + ", cmupActuArticle=" + cmupActuArticle
				+ ", stockMinimArticle=" + stockMinimArticle + ", stockAlertArticle=" + stockAlertArticle
				+ ", stockSecurArticle=" + stockSecurArticle + ", exo=" + exo + ", famille=" + famille
				+ ", fournisseur=" + fournisseur + ", typeArticle=" + typeArticle + "]";
	}


	

	

}
