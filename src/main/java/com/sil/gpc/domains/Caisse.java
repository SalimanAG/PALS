package com.sil.gpc.domains;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Caisse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCaisse;
	@PrimaryKeyJoinColumn
	private String codeCaisse;
	private String libeCaisse;
	private String codeArondissement;
	
	@OneToMany(targetEntity = Affecter.class, mappedBy = "caisse")
	public List<Affecter> affectationsCaisse;
	
	@OneToMany(targetEntity = OpCaisse.class, mappedBy = "caisse")
	public List<OpCaisse> opérationsCaisse;
	
	
	public Caisse() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public Long getIdCaisse() {
		return idCaisse;
	}
	public void setIdCaisse(Long idCaisse) {
		this.idCaisse = idCaisse;
	}
	public String getCodeArondissement() {
		return codeArondissement;
	}
	public void setCodeArondissement(String codeArondissement) {
		this.codeArondissement = codeArondissement;
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
