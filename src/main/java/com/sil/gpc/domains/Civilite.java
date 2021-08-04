package com.sil.gpc.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Civilite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numCivilite;
	@Column(unique = true)
	private String codeCivilite;
	private String libCivilite;
	/**
	 * 
	 */
	public Civilite() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param codeCivilite
	 * @param libCivilite
	 */
	public Civilite(String codeCivilite, String libCivilite) {
		super();
		this.codeCivilite = codeCivilite;
		this.libCivilite = libCivilite;
	}
	
	/**
	 * @return the numCivilite
	 */
	public Long getNumCivilite() {
		return numCivilite;
	}
	
	/**
	 * @param numCivilite the numCivilite to set
	 */
	public void setNumCivilite(Long numCivilite) {
		this.numCivilite = numCivilite;
	}
	
	/**
	 * @return the codeCivilite
	 */
	public String getCodeCivilite() {
		return codeCivilite;
	}
	
	/**
	 * @param codeCivilite the codeCivilite to set
	 */
	public void setCodeCivilite(String codeCivilite) {
		this.codeCivilite = codeCivilite;
	}
	
	/**
	 * @return the libCivilite
	 */
	public String getLibCivilite() {
		return libCivilite;
	}
	
	/**
	 * @param libCivilite the libCivilite to set
	 */
	public void setLibCivilite(String libCivilite) {
		this.libCivilite = libCivilite;
	}
	
	
	@Override
	public String toString() {
		return "civilite [numCivilite=" + numCivilite + ", codeCivilite=" + codeCivilite + ", libCivilite="
				+ libCivilite + "]";
	}
	
	

}
