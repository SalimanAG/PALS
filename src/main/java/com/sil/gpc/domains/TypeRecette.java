package com.sil.gpc.domains;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@SuppressWarnings("serial")
@Entity
public class TypeRecette implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//private Long idTypRec;
	
	@PrimaryKeyJoinColumn(columnDefinition = "codeTypRec")
	private String codeTypRec;
	private String libeTypRec;
	

	@OneToMany(targetEntity = OpCaisse.class, mappedBy = "typeRecette")
	public List<OpCaisse> opérationstype;
		
	public TypeRecette() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TypeRecette(String codeTypRec, String libeTypRec) {
		super();
		this.codeTypRec = codeTypRec;
		this.libeTypRec = libeTypRec;
	}

	public String getCodeTypRec() {
		return codeTypRec;
	}

	public void setCodeTypRec(String codeTypRec) {
		this.codeTypRec = codeTypRec;
	}

	public String getLibeTypRec() {
		return libeTypRec;
	}

	public void setLibeTypRec(String libeTypRec) {
		this.libeTypRec = libeTypRec;
	}
	
}
