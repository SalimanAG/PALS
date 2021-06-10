package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Service implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numService;
	private String codeService;
	private String libService;
	
	//Liaison à la direction d'Appartenance
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Direction.class)
	@JoinColumn(name = "numDirection", referencedColumnName = "numDirection")
	private Direction direction;
	
	//Liaison à son super centre de consommation
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Service.class)
	@JoinColumn(name = "codeSuperService", referencedColumnName = "numService")
	private Service superService;
	
	//Liaison à son type de centre de consommation
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeService.class)
	@JoinColumn(name = "numTypService", referencedColumnName = "numTypService")
	private TypeService typeService;
	
	public Service() {
		super();
	}

	public Long getNumService() {
		return numService;
	}

	public void setNumService(Long numService) {
		this.numService = numService;
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
	
	

	public Service getSuperService() {
		return superService;
	}

	public void setSuperService(Service superService) {
		this.superService = superService;
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	@Override
	public String toString() {
		return "Service [numService=" + numService + ", codeService=" + codeService + ", libService=" + libService
				+ ", direction=" + direction + ", superService=" + superService + ", typeService=" + typeService + "]";
	}



	
	
	
}
