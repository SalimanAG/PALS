package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Direction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numDirection;
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
	
	


	public Long getNumDirection() {
		return numDirection;
	}


	public void setNumDirection(Long numDirection) {
		this.numDirection = numDirection;
	}


	@Override
	public String toString() {
		return "Direction [numDirection=" + numDirection + ", codeDirection=" + codeDirection + ", libDirection="
				+ libDirection + "]";
	}


	



	

}
