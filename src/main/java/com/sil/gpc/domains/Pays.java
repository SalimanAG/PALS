package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Pays implements Serializable{

	@Id
	private String codePays;
	private String nomPays;
	private String nomCompletPays;
	
	public Pays() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pays(String codePays, String nomPays, String nomCompletPays) {
		super();
		
		this.codePays = codePays;
		this.nomPays = nomPays;
		this.nomCompletPays = nomCompletPays;
	}
	public String getCodePays() {
		return codePays;
	}
	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}
	public String getNomPays() {
		return nomPays;
	}
	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}
	public String getNomCompletPays() {
		return nomCompletPays;
	}
	public void setNomCompletPays(String nomCompletPays) {
		this.nomCompletPays = nomCompletPays;
	}

	@Override
	public String toString() {
		return "Pays [codePays=" + codePays + ", nomPays=" + nomPays + ", nomCompletPays=" + nomCompletPays + "]";
	}
	
}
