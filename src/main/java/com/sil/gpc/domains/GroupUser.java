package com.sil.gpc.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GroupUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numGroupUser;
	@Column(unique = true)
	private String idGroupUser;
	private String libGroupUser;
	
	public GroupUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroupUser(String idGroupUser, String libGroupUser) {
		super();
		this.idGroupUser = idGroupUser;
		this.libGroupUser = libGroupUser;
	}

	public String getIdGroupUser() {
		return idGroupUser;
	}

	public void setIdGroupUser(String idGroupUser) {
		this.idGroupUser = idGroupUser;
	}

	public String getLibGroupUser() {
		return libGroupUser;
	}

	public void setLibGroupUser(String libGroupUser) {
		this.libGroupUser = libGroupUser;
	}
	
	

	public Long getNumGroupUser() {
		return numGroupUser;
	}

	public void setNumGroupUser(Long numGroupUser) {
		this.numGroupUser = numGroupUser;
	}

	@Override
	public String toString() {
		return "GroupUser [numGroupUser=" + numGroupUser + ", idGroupUser=" + idGroupUser + ", libGroupUser="
				+ libGroupUser + "]";
	}


	
	
}
