package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@SuppressWarnings("serial")
@Entity(name = "OpCaisse")
public class OpCaisse implements Serializable {
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
	
	//Liaison à la caisse
	private Date dateSaisie;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Caisse.class)
	@JoinColumn(name = "codeCaisse", referencedColumnName = "codeCaisse", nullable = false)
	private Caisse caisse;
	
	//Liaison au type de recette
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeRecette.class)
	@JoinColumn(name = "codeTypRec", referencedColumnName = "codeTypRec", nullable = false)
	private TypeRecette typeRecette;

	//Liaison à la table "ModePaiement"
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = ModePaiement.class)
	@JoinColumn(name = "codeModPay", referencedColumnName = "codeModPay", nullable = false)
	private ModePaiement modePaiement;
	
	// Liaison avec la table Echeance
	@OneToMany( cascade = CascadeType.ALL,targetEntity = Echeance.class, mappedBy = "opCaisse")
	private List<Echeance> echeancesOpCaisse;
	
	//Liaison à l'exercice
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = false)
	private Exercice exercice;

	//Liaison à la table "Utilisateur"
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Utilisateur.class)
	@JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur", nullable = false)
	private Utilisateur utilisateur;
	
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

	@Override
	public String toString() {
		return "OpCaisse [numOpCaisse=" + numOpCaisse + ", dateOpCaisse=" + dateOpCaisse + ", contribuable="
				+ contribuable + ", valideOpCaisse=" + valideOpCaisse + ", Observation=" + Observation + ", dateSaisie="
				+ dateSaisie + ", caisse=" + caisse + ", typeRecette=" + typeRecette + ", modePaiement=" + modePaiement
				+ ", exercice=" + exercice + ", utilisateur=" + utilisateur + ", echeancesOpCaisse=" + echeancesOpCaisse
				+ "]";
	}

}