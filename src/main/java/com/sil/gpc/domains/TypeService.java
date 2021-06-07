package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TypeService {

	@Id
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

	@Override
	public String toString() {
		return "TypeService [codeTypService=" + codeTypService + ", libTypService=" + libTypService + "]";
	}
	
	
	
}
