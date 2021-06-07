package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Direction {

	@Id
	private String codeDirection;
	private String libDirection;
	
	
	public Direction() {
		// TODO Auto-generated constructor stub
	}


	public Direction(String codeDirection, String libDirection) {
		super();
		this.codeDirection = codeDirection;
		this.libDirection = libDirection;
	}


	public String getCodeDirection() {
		return codeDirection;
	}


	public void setCodeDirection(String codeDirection) {
		this.codeDirection = codeDirection;
	}


	public String getLibDirection() {
		return libDirection;
	}


	public void setLibDirection(String libDirection) {
		this.libDirection = libDirection;
	}


	@Override
	public String toString() {
		return "Direction [codeDirection=" + codeDirection + ", libDirection=" + libDirection + "]";
	}



	

}
