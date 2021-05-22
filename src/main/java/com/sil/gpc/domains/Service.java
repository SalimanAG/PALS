package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Service implements Serializable {

	@Id
	private String codeService;
	private String libService;
	
	//Liaison à la direction d'Appartenance
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Direction.class)
	@JoinColumn(name = "codeDirection", referencedColumnName = "codeDirection")
	private Direction direction;
	
	public Service() {
		super();
	}

	public Service(String codeService, String libService) {
		super();
		this.codeService = codeService;
		this.libService = libService;
	}

	public String getCodeService() {
		return codeService;
	}

	public void setCodeService(String codeService) {
		this.codeService = codeService;
	}

	public String getLibService() {
		return libService;
	}

	public void setLibService(String libService) {
		this.libService = libService;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "Service [codeService=" + codeService + ", libService=" + libService + ", direction=" + direction + "]";
	}

	
	
	
}
