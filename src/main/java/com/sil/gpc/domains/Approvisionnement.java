package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Approvisionnement implements Serializable {

	@Id
	private String numAppro;
	private String descriptionAppro;
	private Date dateAppro;
	
	//@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = LigneAppro.class, mappedBy = )
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = true)
	private Exercice exercice;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = LigneAppro.class,fetch = FetchType.EAGER,mappedBy = "appro")
	public List<LigneAppro> ligneParAppro;
	
	public Approvisionnement() {
		super();
	}

	public String getNumAppro() {
		return numAppro;
	}

	public void setNumAppro(String numAppro) {
		this.numAppro = numAppro;
	}

	public String getDescriptionAppro() {
		return descriptionAppro;
	}

	public void setDescriptionAppro(String descriptionAppro) {
		this.descriptionAppro = descriptionAppro;
	}

	public Date getDateAppro() {
		return dateAppro;
	}

	public void setDateAppro(Date dateAppro) {
		this.dateAppro = dateAppro;
	}

	public Exercice getExercice() {
		return exercice;
	}

	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	
	
}
