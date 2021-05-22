package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CauseAnomalie {

	@Id
	private String codeCauseAno;
	private String libCauseAno;
	
	public CauseAnomalie() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "CauseAnomalie [codeCauseAno=" + codeCauseAno + ", libCauseAno=" + libCauseAno + "]";
	}
	
	
}
