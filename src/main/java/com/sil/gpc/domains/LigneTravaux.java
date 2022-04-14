package com.sil.gpc.domains;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;

@Entity
public class LigneTravaux {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLigneTravaux;
	
	private double qteLigneCommande;
	private double puLigneCommande;
	private double remise;
	private double tva;
	private double taibic;
	private double ts;
	
	//@ColumnDefault(value = "false")
	@ColumnDefault(value = "0")
	private boolean satisfaite;
	
	//@ColumnDefault(value = "false")
	@ColumnDefault(value = "0")
	private boolean prixUnitTtc;
	
	private String designationLigne;
	
	//Liaison à la table Travaux
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Travaux.class)
	@JoinColumn(name = "numTravaux", nullable = false, referencedColumnName = "numTravaux")
	public Travaux travaux;
	
	//Liaison à la unité
	@ManyToOne(targetEntity = Uniter.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "numUniter", referencedColumnName = "numUniter", nullable = false)
	private Uniter uniter;
	
	public LigneTravaux() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public LigneTravaux(Long idLigneTravaux, double qteLigneCommande, double puLigneCommande, double remise, double tva,
			double taibic, double ts, boolean satisfaite, boolean prixUnitTtc, String designationLigne, Travaux travaux,
			Uniter uniter) {
		super();
		this.idLigneTravaux = idLigneTravaux;
		this.qteLigneCommande = qteLigneCommande;
		this.puLigneCommande = puLigneCommande;
		this.remise = remise;
		this.tva = tva;
		this.taibic = taibic;
		this.ts = ts;
		this.satisfaite = satisfaite;
		this.prixUnitTtc = prixUnitTtc;
		this.designationLigne = designationLigne;
		this.travaux = travaux;
		this.uniter = uniter;
	}



	public Long getIdLigneTravaux() {
		return idLigneTravaux;
	}

	public void setIdLigneTravaux(Long idLigneTravaux) {
		this.idLigneTravaux = idLigneTravaux;
	}

	public double getQteLigneCommande() {
		return qteLigneCommande;
	}

	public void setQteLigneCommande(double qteLigneCommande) {
		this.qteLigneCommande = qteLigneCommande;
	}

	public double getPuLigneCommande() {
		return puLigneCommande;
	}

	public void setPuLigneCommande(double puLigneCommande) {
		this.puLigneCommande = puLigneCommande;
	}

	public double getRemise() {
		return remise;
	}

	public void setRemise(double remise) {
		this.remise = remise;
	}

	public double getTva() {
		return tva;
	}

	public void setTva(double tva) {
		this.tva = tva;
	}

	public double getTaibic() {
		return taibic;
	}

	public void setTaibic(double taibic) {
		this.taibic = taibic;
	}

	public double getTs() {
		return ts;
	}

	public void setTs(double ts) {
		this.ts = ts;
	}

	public boolean isSatisfaite() {
		return satisfaite;
	}

	public void setSatisfaite(boolean satisfaite) {
		this.satisfaite = satisfaite;
	}

	public boolean isPrixUnitTtc() {
		return prixUnitTtc;
	}

	public void setPrixUnitTtc(boolean prixUnitTtc) {
		this.prixUnitTtc = prixUnitTtc;
	}

	
	public String getDesignationLigne() {
		return designationLigne;
	}

	public void setDesignationLigne(String designationLigne) {
		this.designationLigne = designationLigne;
	}

	public Travaux getTravaux() {
		return travaux;
	}

	public void setTravaux(Travaux travaux) {
		this.travaux = travaux;
	}



	public Uniter getUniter() {
		return uniter;
	}



	public void setUniter(Uniter uniter) {
		this.uniter = uniter;
	}



	@Override
	public String toString() {
		return "LigneTravaux [idLigneTravaux=" + idLigneTravaux + ", qteLigneCommande=" + qteLigneCommande
				+ ", puLigneCommande=" + puLigneCommande + ", remise=" + remise + ", tva=" + tva + ", taibic=" + taibic
				+ ", ts=" + ts + ", satisfaite=" + satisfaite + ", prixUnitTtc=" + prixUnitTtc + ", designationLigne="
				+ designationLigne + ", travaux=" + travaux + ", uniter=" + uniter + "]";
	}

	

}
