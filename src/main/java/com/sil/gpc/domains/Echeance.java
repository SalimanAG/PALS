package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Echeance implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEcheance;
	private String mois;
	private Date dateEcheance;
	private boolean payeEcheance;

	@ManyToOne(targetEntity = Contrat.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "numContrat")
	Contrat contrat;

	//Liaison avec la table OpCaisse
	@ManyToOne(targetEntity = OpCaisse.class,fetch = FetchType.EAGER,cascade = CascadeType.REFRESH,optional = true)
	@JoinColumn(name = "numOpCaisse", referencedColumnName = "numOpCaisse",nullable = true)
	private OpCaisse opCaisse ;

	public Echeance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Echeance(String mois, Date dateEcheance, boolean payeEcheance, Contrat contrat) {
		super();
		this.mois = mois;
		this.dateEcheance = dateEcheance;
		this.payeEcheance = payeEcheance;
		this.contrat = contrat;
	}

	public Long getIdEcheance() {
		return idEcheance;
	}

	public void setIdEcheance(Long idEcheance) {
		this.idEcheance = idEcheance;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public Date getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(Date dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public boolean isPayeEcheance() {
		return payeEcheance;
	}

	public void setPayeEcheance(boolean payeEcheance) {
		this.payeEcheance = payeEcheance;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}

}