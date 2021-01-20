package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DroitUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDroitUser;
	private String codeDroitUser;
	private String libDroitUser;
	
	public DroitUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DroitUser(String codeDroitUser, String libDroitUser) {
		super();
		this.codeDroitUser = codeDroitUser;
		this.libDroitUser = libDroitUser;
	}

	public Long getIdDroitUser() {
		return idDroitUser;
	}

	public void setIdDroitUser(Long idDroitUser) {
		this.idDroitUser = idDroitUser;
	}

	public String getCodeDroitUser() {
		return codeDroitUser;
	}

	public void setCodeDroitUser(String codeDroitUser) {
		this.codeDroitUser = codeDroitUser;
	}

	public String getLibDroitUser() {
		return libDroitUser;
	}

	public void setLibDroitUser(String libDroitUser) {
		this.libDroitUser = libDroitUser;
	}

	@Override
	public String toString() {
		return "DroitUser [idDroitUser=" + idDroitUser + ", codeDroitUser=" + codeDroitUser + ", libDroitUser="
				+ libDroitUser + "]";
	}
	
	
}
