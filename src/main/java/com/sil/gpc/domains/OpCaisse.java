package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity(name = "OpCaisse")
public class OpCaisse implements Serializable {
	@Id
	@Column(name = "numOpCaisse", length = 20)
	private String numOpCaisse;
	private Date dateOpCaisse;
	@Column(length = 50)
	private String contribuable;
	private boolean valideOpCaisse;
	@Column(length = 150)
	private String obsOpCaisse;
	private Date dateSaisie;
	private int valeur;

	//Liaison à la caisse
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Caisse.class)
	@JoinColumn(name = "codeCaisse", referencedColumnName = "codeCaisse", nullable = false)
	private Caisse caisse;

	//Liaison au type de recette
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = TypeRecette.class)
	@JoinColumn(name = "codeTypRec", referencedColumnName = "codeTypRec", nullable = false)
	private TypeRecette typeRecette;

	//Liaison à la table "ModePaiementRepository"
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = ModePaiement.class)
	@JoinColumn(name = "codeModPay", referencedColumnName = "codeModPay", nullable = false)
	private ModePaiement modePaiement;

	//Liaison au type de recette
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Exercice.class)
	@JoinColumn(name = "codeExercice", referencedColumnName = "codeExercice", nullable = true)
	private Exercice exercice;

	//Liaison à la table "ModePaiementRepository"
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Utilisateur.class)
	@JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur", nullable = true)
	private Utilisateur utilisateur;

	public OpCaisse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numOpCaisse
	 * @param dateOpCaisse
	 * @param contribuable
	 * @param valideOpCaisse
	 * @param obsOpCaisse
	 * @param dateSaisie
	 * @param caisse
	 * @param typeRecette
	 * @param modePaiement
	 * @param exercice
	 * @param utilisateur
	 */
	public OpCaisse(String numOpCaisse, Date dateOpCaisse, String contribuable, boolean valideOpCaisse,
			String obsOpCaisse, Date dateSaisie, Caisse caisse, TypeRecette typeRecette, ModePaiement modePaiement,
			Exercice exercice, Utilisateur utilisateur) {
		this.numOpCaisse = numOpCaisse;
		this.dateOpCaisse = dateOpCaisse;
		this.contribuable = contribuable;
		this.valideOpCaisse = valideOpCaisse;
		this.obsOpCaisse = obsOpCaisse;
		this.dateSaisie = dateSaisie;
		this.caisse = caisse;
		this.typeRecette = typeRecette;
		this.modePaiement = modePaiement;
		this.exercice = exercice;
		this.utilisateur = utilisateur;
	}

	@Override
	public String toString() {
		return "OpCaisse [numOpCaisse=" + numOpCaisse + ", dateOpCaisse=" + dateOpCaisse + ", contribuable="
				+ contribuable + ", valideOpCaisse=" + valideOpCaisse + ", obsOpCaisse=" + obsOpCaisse + ", dateSaisie="
				+ dateSaisie + ", caisse=" + caisse + ", typeRecette=" + typeRecette + ", modePaiement=" + modePaiement
				+ ", exercice=" + exercice + ", utilisateur=" + utilisateur + "]";
	}

	/**
	 * @return the valeur
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	/**
	 * @return the numOpCaisse
	 */
	public String getNumOpCaisse() {
		return numOpCaisse;
	}

	/**
	 * @param numOpCaisse the numOpCaisse to set
	 */
	public void setNumOpCaisse(String numOpCaisse) {
		this.numOpCaisse = numOpCaisse;
	}

	/**
	 * @return the dateOpCaisse
	 */
	public Date getDateOpCaisse() {
		return dateOpCaisse;
	}

	/**
	 * @param dateOpCaisse the dateOpCaisse to set
	 */
	public void setDateOpCaisse(Date dateOpCaisse) {
		this.dateOpCaisse = dateOpCaisse;
	}

	/**
	 * @return the contribuable
	 */
	public String getContribuable() {
		return contribuable;
	}

	/**
	 * @param contribuable the contribuable to set
	 */
	public void setContribuable(String contribuable) {
		this.contribuable = contribuable;
	}

	/**
	 * @return the valideOpCaisse
	 */
	public boolean isValideOpCaisse() {
		return valideOpCaisse;
	}

	/**
	 * @param valideOpCaisse the valideOpCaisse to set
	 */
	public void setValideOpCaisse(boolean valideOpCaisse) {
		this.valideOpCaisse = valideOpCaisse;
	}

	/**
	 * @return the obsOpCaisse
	 */
	public String getObsOpCaisse() {
		return obsOpCaisse;
	}

	/**
	 * @param obsOpCaisse the obsOpCaisse to set
	 */
	public void setObsOpCaisse(String obsOpCaisse) {
		this.obsOpCaisse = obsOpCaisse;
	}

	/**
	 * @return the dateSaisie
	 */
	public Date getDateSaisie() {
		return dateSaisie;
	}

	/**
	 * @param dateSaisie the dateSaisie to set
	 */
	public void setDateSaisie(Date dateSaisie) {
		this.dateSaisie = dateSaisie;
	}

	/**
	 * @return the caisse
	 */
	public Caisse getCaisse() {
		return caisse;
	}

	/**
	 * @param caisse the caisse to set
	 */
	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}

	/**
	 * @return the typeRecette
	 */
	public TypeRecette getTypeRecette() {
		return typeRecette;
	}

	/**
	 * @param typeRecette the typeRecette to set
	 */
	public void setTypeRecette(TypeRecette typeRecette) {
		this.typeRecette = typeRecette;
	}

	/**
	 * @return the modePaiement
	 */
	public ModePaiement getModePaiement() {
		return modePaiement;
	}

	/**
	 * @param modePaiement the modePaiement to set
	 */
	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}

	/**
	 * @return the exercice
	 */
	public Exercice getExercice() {
		return exercice;
	}

	/**
	 * @param exercice the exercice to set
	 */
	public void setExercice(Exercice exercice) {
		this.exercice = exercice;
	}

	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(caisse, contribuable, dateOpCaisse, dateSaisie, exercice, modePaiement, numOpCaisse,
				obsOpCaisse, typeRecette, utilisateur, valideOpCaisse);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OpCaisse other = (OpCaisse) obj;
		return Objects.equals(caisse, other.caisse) && Objects.equals(contribuable, other.contribuable)
				&& Objects.equals(dateOpCaisse, other.dateOpCaisse) && Objects.equals(dateSaisie, other.dateSaisie)
				&& Objects.equals(exercice, other.exercice) && Objects.equals(modePaiement, other.modePaiement)
				&& Objects.equals(numOpCaisse, other.numOpCaisse) && Objects.equals(obsOpCaisse, other.obsOpCaisse)
				&& Objects.equals(typeRecette, other.typeRecette) && Objects.equals(utilisateur, other.utilisateur)
				&& valideOpCaisse == other.valideOpCaisse;
	}

}