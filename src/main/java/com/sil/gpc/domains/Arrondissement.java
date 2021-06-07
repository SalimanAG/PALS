package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Arrondissement implements Serializable{

	@Id
	private String codeArrondi;
	private String nomArrondi;
	private String adresseArrondi;
	private String numTelArrondi;
	
	//Migration de lab clé de la commune vers l'arrondissement
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Commune.class)
	@JoinColumn(name = "commune", nullable = false, referencedColumnName = "codeCommune")
	public Commune commune;
	
	public Arrondissement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Arrondissement(String codeArrondi, String nomArrondi, String adresseArrondi, String numTelArrondi,
			Commune commune) {
		super();
		this.codeArrondi = codeArrondi;
		this.nomArrondi = nomArrondi;
		this.adresseArrondi = adresseArrondi;
		this.numTelArrondi = numTelArrondi;
		this.commune = commune;
	}
	public String getCodeArrondi() {
		return codeArrondi;
	}
	public void setCodeArrondi(String codeArrondi) {
		this.codeArrondi = codeArrondi;
	}
	public String getNomArrondi() {
		return nomArrondi;
	}
	public void setNomArrondi(String nomArrondi) {
		this.nomArrondi = nomArrondi;
	}
	public String getAdresseArrondi() {
		return adresseArrondi;
	}
	public void setAdresseArrondi(String adresseArrondi) {
		this.adresseArrondi = adresseArrondi;
	}
	public String getNumTelArrondi() {
		return numTelArrondi;
	}
	public void setNumTelArrondi(String numTelArrondi) {
		this.numTelArrondi = numTelArrondi;
	}
	
	public Commune getCommune() {
		return commune;
	}
	public void setCommune(Commune commune) {
		this.commune = commune;
	}
	@Override
	public String toString() {
		return "Arrondissement [codeArrondi=" + codeArrondi + ", nomArrondi=" + nomArrondi + ", adresseArrondi="
				+ adresseArrondi + ", numTelArrondi=" + numTelArrondi + ", codeCommune=" + commune + "]";
	}
	
}
