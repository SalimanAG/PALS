package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class SiteMarcher implements Serializable{

	
	@Id
	private String codeSite;
	private String libSite;
	private String descriSite;
	
	public SiteMarcher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SiteMarcher(String codeSite, String libSite, String descriSite) {
		super();
		this.codeSite = codeSite;
		this.libSite = libSite;
		this.descriSite = descriSite;
	}


	public String getCodeSite() {
		return codeSite;
	}

	public void setCodeSite(String codeSite) {
		this.codeSite = codeSite;
	}

	public String getLibSite() {
		return libSite;
	}

	public void setLibSite(String libSite) {
		this.libSite = libSite;
	}

	public String getDescriSite() {
		return descriSite;
	}

	public void setDescriSite(String descriSite) {
		this.descriSite = descriSite;
	}

	@Override
	public String toString() {
		return "SiteMarcher [codeSite=" + codeSite + ", LibSite=" + libSite + ", DescriSite=" + descriSite + "]";
	}
	
	
	
	
}
