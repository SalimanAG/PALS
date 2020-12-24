package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@SuppressWarnings("serial")
@Entity
public class Caisse implements Serializable {
	
	@Id
	@PrimaryKeyJoinColumn
	private String codeCaisse;
	private String libeCaisse;

	
	//Liaison à venir
	@ManyToOne(cascade = CascadeType.DETACH,targetEntity = Arrondissement.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "codeArrondi",referencedColumnName = "codeArrondi")
	private Arrondissement arrondissement;
	
	@OneToMany(targetEntity = Affecter.class, mappedBy = "caisse")
	public List<Affecter> affectationsCaisse;
	
	@OneToMany(targetEntity = OpCaisse.class, mappedBy = "caisse")
	public List<OpCaisse> opérationsCaisse;
	
	
	public Caisse() {
		super();
		// TODO Auto-generated constructor stub
	}
	//*******************************Constructeur à regénérer
	public Caisse(String codeCaisse, String libeCaisse) {
		super();
		this.codeCaisse = codeCaisse;
		this.libeCaisse = libeCaisse;
	}
	public String getCodeCaisse() {
		return codeCaisse;
	}
	public void setCodeCaisse(String codeCaisse) {
		this.codeCaisse = codeCaisse;
	}
	public String getLibeCaisse() {
		return libeCaisse;
	}
	public void setLibeCaisse(String libeCaisse) {
		this.libeCaisse = libeCaisse;
	}
	
	public List<Affecter> getAffectationsCaisse() {
		return affectationsCaisse;
	}
	public void setAffectationsCaisse(List<Affecter> affectationsCaisse) {
		this.affectationsCaisse = affectationsCaisse;
	}
	public List<OpCaisse> getOpérationsCaisse() {
		return opérationsCaisse;
	}
	public void setOpérationsCaisse(List<OpCaisse> opérationsCaisse) {
		this.opérationsCaisse = opérationsCaisse;
	}
	

}
