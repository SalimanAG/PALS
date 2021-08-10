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
public class EcritureComptable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numEcriCompta;
	private String journal;
	private Date dateEcri;
	private String pieceEcri;
	private String compteEcri;
	private boolean credit;
	private String centreConsEcri;
	private String libEcri;
	private String referenceEcri;
	private double montantEcri;
	
	//Liaison avec Article
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Famille.class)
	@JoinColumn(name = "numFamille", referencedColumnName = "numFamille",nullable = false)
	private Famille famille;
	
	public EcritureComptable() {
		// TODO Auto-generated constructor stub
	}

	public EcritureComptable(Long numEcriCompta, String journal, Date dateEcri, String pieceEcri, String compteEcri,
			boolean credit, String centreConsEcri, String libEcri, String referenceEcri, Famille famille) {
		super();
		this.numEcriCompta = numEcriCompta;
		this.journal = journal;
		this.dateEcri = dateEcri;
		this.pieceEcri = pieceEcri;
		this.compteEcri = compteEcri;
		this.credit = credit;
		this.centreConsEcri = centreConsEcri;
		this.libEcri = libEcri;
		this.referenceEcri = referenceEcri;
		this.famille = famille;
	}
	
	

	public EcritureComptable(Long numEcriCompta, String journal, Date dateEcri, String pieceEcri, String compteEcri,
			boolean credit, String centreConsEcri, String libEcri, String referenceEcri, double montantEcri,
			Famille famille) {
		super();
		this.numEcriCompta = numEcriCompta;
		this.journal = journal;
		this.dateEcri = dateEcri;
		this.pieceEcri = pieceEcri;
		this.compteEcri = compteEcri;
		this.credit = credit;
		this.centreConsEcri = centreConsEcri;
		this.libEcri = libEcri;
		this.referenceEcri = referenceEcri;
		this.montantEcri = montantEcri;
		this.famille = famille;
	}

	public Long getNumEcriCompta() {
		return numEcriCompta;
	}

	public void setNumEcriCompta(Long numEcriCompta) {
		this.numEcriCompta = numEcriCompta;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public Date getDateEcri() {
		return dateEcri;
	}

	public void setDateEcri(Date dateEcri) {
		this.dateEcri = dateEcri;
	}

	public String getPieceEcri() {
		return pieceEcri;
	}

	public void setPieceEcri(String pieceEcri) {
		this.pieceEcri = pieceEcri;
	}

	public String getCompteEcri() {
		return compteEcri;
	}

	public void setCompteEcri(String compteEcri) {
		this.compteEcri = compteEcri;
	}

	public boolean isCredit() {
		return credit;
	}

	public void setCredit(boolean credit) {
		this.credit = credit;
	}

	public String getCentreConsEcri() {
		return centreConsEcri;
	}

	public void setCentreConsEcri(String centreConsEcri) {
		this.centreConsEcri = centreConsEcri;
	}

	public String getLibEcri() {
		return libEcri;
	}

	public void setLibEcri(String libEcri) {
		this.libEcri = libEcri;
	}

	public String getReferenceEcri() {
		return referenceEcri;
	}

	public void setReferenceEcri(String referenceEcri) {
		this.referenceEcri = referenceEcri;
	}

	public Famille getFamille() {
		return famille;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public double getMontantEcri() {
		return montantEcri;
	}

	public void setMontantEcri(double montantEcri) {
		this.montantEcri = montantEcri;
	}

	@Override
	public String toString() {
		return "EcritureComptable [numEcriCompta=" + numEcriCompta + ", journal=" + journal + ", dateEcri=" + dateEcri
				+ ", pieceEcri=" + pieceEcri + ", compteEcri=" + compteEcri + ", credit=" + credit + ", centreConsEcri="
				+ centreConsEcri + ", libEcri=" + libEcri + ", referenceEcri=" + referenceEcri + ", montantEcri="
				+ montantEcri + ", famille=" + famille + "]";
	}

	

}
