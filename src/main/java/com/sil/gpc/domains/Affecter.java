package com.sil.gpc.domains;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Affecter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAffecter;
	private Date dateDebAffecter;
	private Date dateFinAffecter;
	@ManyToOne(targetEntity = Caisse.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "codeCaisse", referencedColumnName = "codeCaisse", nullable = false)
	private Caisse caisse;
	private Long idUtilisateur;
	public Affecter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date getDateDebAffecter() {
		return dateDebAffecter;
	}
	public void setDateDebAffecter(Date dateDebAffecter) {
		this.dateDebAffecter = dateDebAffecter;
	}
	public Date getDateFinAffecter() {
		return dateFinAffecter;
	}
	public void setDateFinAffecter(Date dateFinAffecter) {
		this.dateFinAffecter = dateFinAffecter;
	}
	public Caisse getCaisse() {
		return caisse;
	}
	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	
	

}
