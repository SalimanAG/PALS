package com.sil.gpc.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CauseAnomalie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numCauseAno;
	@Column(unique = true)
	private String codeCauseAno;
	private String libCauseAno;
	
	public CauseAnomalie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CauseAnomalie(Long numCauseAno, String codeCauseAno, String libCauseAno) {
		super();
		this.numCauseAno = numCauseAno;
		this.codeCauseAno = codeCauseAno;
		this.libCauseAno = libCauseAno;
	}



	public String getCodeCauseAno() {
		return codeCauseAno;
	}

	public void setCodeCauseAno(String codeCauseAno) {
		this.codeCauseAno = codeCauseAno;
	}

	public String getLibCauseAno() {
		return libCauseAno;
	}

	public void setLibCauseAno(String libCauseAno) {
		this.libCauseAno = libCauseAno;
	}
	
	

	public Long getNumCauseAno() {
		return numCauseAno;
	}



	public void setNumCauseAno(Long numCauseAno) {
		this.numCauseAno = numCauseAno;
	}



	@Override
	public String toString() {
		return "CauseAnomalie [numCauseAno=" + numCauseAno + ", codeCauseAno=" + codeCauseAno + ", libCauseAno="
				+ libCauseAno + "]";
	}



	
}
