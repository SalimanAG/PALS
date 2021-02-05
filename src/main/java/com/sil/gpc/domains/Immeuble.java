package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Immeuble implements Serializable{

	@Id
	private String codeIm;
	private String libIm;
	private String localisationIm;
	private boolean etatIm;
	private double superficie;
	private double valUnit;
	private String stuctResp;
	private String autre;
	//Liaison avec Quartier
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Arrondissement.class)
	@JoinColumn(name="codeArrondi", referencedColumnName = "codeArrondi", nullable = true)
	private Arrondissement arrondissement;

	//Liaison avec Arrondissement
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Quartier.class)
	@JoinColumn(name="codeQuartier", referencedColumnName = "codeQuartier", nullable = true)
	private Quartier quartier;
	
	//Liaison  avec TypeImmeuble
		@ManyToOne(fetch = FetchType.EAGER,targetEntity = TypeImmeuble.class)
		@JoinColumn(name="codeTypImm", referencedColumnName = "codeTypIm", nullable = false)
		private TypeImmeuble typeImmeuble;
		
	//Liaison  avec Site
			@ManyToOne(fetch = FetchType.EAGER,targetEntity = SiteMarcher.class)
			@JoinColumn(name="codeSite", referencedColumnName = "codeSite", nullable = false)
			private SiteMarcher siteMarcher;
			
	
	/**
			 * 
			 */
			public Immeuble() {
				super();
				// TODO Auto-generated constructor stub
			}

	/**
			 * @param codeIm
			 * @param libIm
			 * @param localisationIm
			 * @param etatIm
			 * @param superficie
			 * @param valUnit
			 * @param stuctResp
			 * @param autre
			 * @param arrondissement
			 * @param quartier
			 * @param typeImmeuble
			 * @param siteMarcher
			 */
			public Immeuble(String codeIm, String libIm, String localisationIm, boolean etatIm, double superficie,
					double valUnit, String stuctResp, String autre, Arrondissement arrondissement, Quartier quartier,
					TypeImmeuble typeImmeuble, SiteMarcher siteMarcher) {
				this.codeIm = codeIm;
				this.libIm = libIm;
				this.localisationIm = localisationIm;
				this.etatIm = etatIm;
				this.superficie = superficie;
				this.valUnit = valUnit;
				this.stuctResp = stuctResp;
				this.autre = autre;
				this.arrondissement = arrondissement;
				this.quartier = quartier;
				this.typeImmeuble = typeImmeuble;
				this.siteMarcher = siteMarcher;
			}

	/**
	 * @return the codeIm
	 */
	public String getCodeIm() {
		return codeIm;
	}

	/**
	 * @param codeIm the codeIm to set
	 */
	public void setCodeIm(String codeIm) {
		this.codeIm = codeIm;
	}

	/**
	 * @return the libIm
	 */
	public String getLibIm() {
		return libIm;
	}

	/**
	 * @param libIm the libIm to set
	 */
	public void setLibIm(String libIm) {
		this.libIm = libIm;
	}

	/**
	 * @return the localisationIm
	 */
	public String getLocalisationIm() {
		return localisationIm;
	}

	/**
	 * @param localisationIm the localisationIm to set
	 */
	public void setLocalisationIm(String localisationIm) {
		this.localisationIm = localisationIm;
	}

	/**
	 * @return the etatIm
	 */
	public boolean isEtatIm() {
		return etatIm;
	}

	/**
	 * @param etatIm the etatIm to set
	 */
	public void setEtatIm(boolean etatIm) {
		this.etatIm = etatIm;
	}

	/**
	 * @return the superficie
	 */
	public double getSuperficie() {
		return superficie;
	}

	/**
	 * @param superficie the superficie to set
	 */
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	/**
	 * @return the valUnit
	 */
	public double getValUnit() {
		return valUnit;
	}

	/**
	 * @param valUnit the valUnit to set
	 */
	public void setValUnit(double valUnit) {
		this.valUnit = valUnit;
	}

	/**
	 * @return the stuctResp
	 */
	public String getStuctResp() {
		return stuctResp;
	}

	/**
	 * @param stuctResp the stuctResp to set
	 */
	public void setStuctResp(String stuctResp) {
		this.stuctResp = stuctResp;
	}

	/**
	 * @return the autre
	 */
	public String getAutre() {
		return autre;
	}

	/**
	 * @param autre the autre to set
	 */
	public void setAutre(String autre) {
		this.autre = autre;
	}

	/**
	 * @return the arrondissement
	 */
	public Arrondissement getArrondissement() {
		return arrondissement;
	}

	/**
	 * @param arrondissement the arrondissement to set
	 */
	public void setArrondissement(Arrondissement arrondissement) {
		this.arrondissement = arrondissement;
	}

	/**
	 * @return the quartier
	 */
	public Quartier getQuartier() {
		return quartier;
	}

	/**
	 * @param quartier the quartier to set
	 */
	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

	/**
	 * @return the typeImmeuble
	 */
	public TypeImmeuble getTypeImmeuble() {
		return typeImmeuble;
	}

	/**
	 * @param typeImmeuble the typeImmeuble to set
	 */
	public void setTypeImmeuble(TypeImmeuble typeImmeuble) {
		this.typeImmeuble = typeImmeuble;
	}

	/**
	 * @return the siteMarcher
	 */
	public SiteMarcher getSiteMarcher() {
		return siteMarcher;
	}

	/**
	 * @param siteMarcher the siteMarcher to set
	 */
	public void setSiteMarcher(SiteMarcher siteMarcher) {
		this.siteMarcher = siteMarcher;
	}

}
