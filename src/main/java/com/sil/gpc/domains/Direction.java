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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeDirection == null) ? 0 : codeDirection.hashCode());
		result = prime * result + ((libDirection == null) ? 0 : libDirection.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direction other = (Direction) obj;
		if (codeDirection == null) {
			if (other.codeDirection != null)
				return false;
		} else if (!codeDirection.equals(other.codeDirection))
			return false;
		if (libDirection == null) {
			if (other.libDirection != null)
				return false;
		} else if (!libDirection.equals(other.libDirection))
			return false;
		return true;
	}
	
	

}
