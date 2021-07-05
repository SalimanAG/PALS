package com.sil.gpc.domains;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Uniter implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numUniter;
	private String codeUniter;
	private String libUniter;
	private double poids;
	
	public Uniter() {
		super();
	}

	

	public Uniter(Long numUniter, String codeUniter, String libUniter, double poids) {
		super();
		this.numUniter = numUniter;
		this.codeUniter = codeUniter;
		this.libUniter = libUniter;
		this.poids = poids;
	}



	public Long getNumUniter() {
		return numUniter;
	}

	public void setNumUniter(Long numUniter) {
		this.numUniter = numUniter;
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

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}



	@Override
	public String toString() {
		return "Uniter [numUniter=" + numUniter + ", codeUniter=" + codeUniter + ", libUniter=" + libUniter + ", poids="
				+ poids + "]";
	}



	
	
}
