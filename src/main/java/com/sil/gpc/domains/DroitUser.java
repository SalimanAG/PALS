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
	private String DescriDroitUser;
	
	public DroitUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idDroitUser
	 * @param codeDroitUser
	 * @param libDroitUser
	 * @param descriDroitUser
	 */
	public DroitUser(Long idDroitUser, String codeDroitUser, String libDroitUser, String descriDroitUser) {
		this.idDroitUser = idDroitUser;
		this.codeDroitUser = codeDroitUser;
		this.libDroitUser = libDroitUser;
		DescriDroitUser = descriDroitUser;
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

	/**
	 * @return the descriDroitUser
	 */
	public String getDescriDroitUser() {
		return DescriDroitUser;
	}

	/**
	 * @param descriDroitUser the descriDroitUser to set
	 */
	public void setDescriDroitUser(String descriDroitUser) {
		DescriDroitUser = descriDroitUser;
	}

	@Override
	public String toString() {
		return "DroitUser [idDroitUser=" + idDroitUser + ", codeDroitUser=" + codeDroitUser + ", libDroitUser="
				+ libDroitUser + "]";
	}
	
	
}
