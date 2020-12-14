package com.sil.gpc.domains;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "OpCaisse")
public class OpCaisse {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	// private Long idOpCaisse;

	@Column(name = "numOpCaisse", length = 20)
	@PrimaryKeyJoinColumn(name = "numOpCaisse")
	private String numOpCaisse;
	private Date dateOpCaisse;
	@Column(length = 50)
	private String contribuable;
	private boolean valideOpCaisse;
	@Column(length = 150)
	private String Observation;
	private Date dateSaisie;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Caisse.class)
	@JoinColumn(name = "codeCaisse", referencedColumnName = "codeCaisse", nullable = false)
	private Caisse caisse;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeRecette.class)
	@JoinColumn(name = "codeTypRec", referencedColumnName = "codeTypRec", nullable = false)
	private TypeRecette typeRecette;

	//Liaison à la table "ModePaiement"
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = ModePaiement.class)
	@JoinColumn(name = "codeModPay", referencedColumnName = "codeModPay", nullable = false)
	private ModePaiement modePaiement;
	

	private String codeExercice;
	private String idUtilisateur;
	
	// Liaison avec la table Echeance
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Echeance.class)
	@JoinTable(name = "OpCaisseEcheance", 
	joinColumns = { @JoinColumn(name = "numOpCaisse",nullable = true) }, 
	inverseJoinColumns = {@JoinColumn(name = "idEcheance", nullable = true) })
	private List<Echeance> echeancesOpCaisse;

	public OpCaisse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNumOpCaisse() {
		return numOpCaisse;
	}

	public void setNumOpCaisse(String numOpCaisse) {
		this.numOpCaisse = numOpCaisse;
	}

	public Date getDateOpCaisse() {
		return dateOpCaisse;
	}

	public void setDateOpCaisse(Date dateOpCaisse) {
		this.dateOpCaisse = dateOpCaisse;
	}

	public String getContribuable() {
		return contribuable;
	}

	public void setContribuable(String contribuable) {
		this.contribuable = contribuable;
	}

	public boolean isValideOpCaisse() {
		return valideOpCaisse;
	}

	public void setValideOpCaisse(boolean valideOpCaisse) {
		this.valideOpCaisse = valideOpCaisse;
	}

	public String getObservation() {
		return Observation;
	}

	public void setObservation(String observation) {
		Observation = observation;
	}

	public Date getDateSaisie() {
		return dateSaisie;
	}

	public void setDateSaisie(Date dateSaisie) {
		this.dateSaisie = dateSaisie;
	}

	public Caisse getCaisse() {
		return caisse;
	}

	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}

	public TypeRecette getTypeRecette() {
		return typeRecette;
	}

	public void setTypeRecette(TypeRecette typeRecette) {
		this.typeRecette = typeRecette;
	}

	public ModePaiement getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}

	public String getCodeExercice() {
		return codeExercice;
	}

	public void setCodeExercice(String codeExercice) {
		this.codeExercice = codeExercice;
	}

	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(String idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

}