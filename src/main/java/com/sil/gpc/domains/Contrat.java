package com.sil.gpc.domains;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Contrat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "numContrat", length = 30)
	@PrimaryKeyJoinColumn(name = "ContratPK")
	private String numContrat;
	@Column(name = "dateSignatureContrat")
	private Date dateSignatureContrat;
	@Column(name = "dateEffetContrat")
	private Date dateEffetContrat;
	@Column(name = "avanceContrat")
	private double avanceContrat;
	@Column(name = "cautionContrat")
	private double cautionContrat;
	@Column(name = "immeubleContrat")
	private String codeIm;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idLocataire")
	private Locataire locataire;
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contrat(Long id, String numContrat, Date dateSignatureContrat, Date dateEffetContrat, double avanceContrat,
			double cautionContrat, String codeIm) {
		super();
		this.id = id;
		this.numContrat = numContrat;
		this.dateSignatureContrat = dateSignatureContrat;
		this.dateEffetContrat = dateEffetContrat;
		this.avanceContrat = avanceContrat;
		this.cautionContrat = cautionContrat;
		this.codeIm = codeIm;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumContrat() {
		return numContrat;
	}
	public void setNumContrat(String numContrat) {
		this.numContrat = numContrat;
	}
	public Date getDateSignatureContrat() {
		return dateSignatureContrat;
	}
	public void setDateSignatureContrat(Date dateSignatureContrat) {
		this.dateSignatureContrat = dateSignatureContrat;
	}
	public Date getDateEffetContrat() {
		return dateEffetContrat;
	}
	public void setDateEffetContrat(Date dateEffetContrat) {
		this.dateEffetContrat = dateEffetContrat;
	}
	public double getAvanceContrat() {
		return avanceContrat;
	}
	public void setAvanceContrat(double avanceContrat) {
		this.avanceContrat = avanceContrat;
	}
	public double getCautionContrat() {
		return cautionContrat;
	}
	public void setCautionContrat(double cautionContrat) {
		this.cautionContrat = cautionContrat;
	}
	public String getCodeIm() {
		return codeIm;
	}
	public void setCodeIm(String codeIm) {
		this.codeIm = codeIm;
	}

}
