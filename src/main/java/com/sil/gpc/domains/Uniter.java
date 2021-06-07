package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Uniter implements Serializable{

	@Id
	private String codeUniter;
	private String libUniter;
	
	public Uniter() {
		super();
	}

	public Uniter(String codeUniter, String libUniter) {
		super();
		this.codeUniter = codeUniter;
		this.libUniter = libUniter;
	}

	public String getCodeUniter() {
		return codeUniter;
	}

	public void setCodeUniter(String codeUniter) {
		this.codeUniter = codeUniter;
	}

	public String getLibUniter() {
		return libUniter;
	}

	public void setLibUniter(String libUniter) {
		this.libUniter = libUniter;
	}


	@Override
	public String toString() {
		return "Uniter [codeUniter=" + codeUniter + ", libUniter=" + libUniter + "]";
	}
	
	
}
