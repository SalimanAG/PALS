package com.sil.gpc.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeService {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numTypService;
	@Column(unique = true)
	private String codeTypService;
	private String libTypService;
	
	public TypeService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeService(String codeTypService, String libTypService) {
		super();
		this.codeTypService = codeTypService;
		this.libTypService = libTypService;
	}

	public String getCodeTypService() {
		return codeTypService;
	}

	public void setCodeTypService(String codeTypService) {
		this.codeTypService = codeTypService;
	}

	public String getLibTypService() {
		return libTypService;
	}

	public void setLibTypService(String libTypService) {
		this.libTypService = libTypService;
	}
	
	

	public Long getNumTypService() {
		return numTypService;
	}

	public void setNumTypService(Long numTypService) {
		this.numTypService = numTypService;
	}

	@Override
	public String toString() {
		return "TypeService [numTypService=" + numTypService + ", codeTypService=" + codeTypService + ", libTypService="
				+ libTypService + "]";
	}

	
	
}
