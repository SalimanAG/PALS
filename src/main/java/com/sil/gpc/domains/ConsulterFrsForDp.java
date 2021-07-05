package com.sil.gpc.domains;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ConsulterFrsForDp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idConsulterFrsForDp;
	private Timestamp dateRemise;
	private boolean choisit;
	
	//Migration de la clé de l'unité vers l'article
		@ManyToOne(fetch = FetchType.EAGER,targetEntity = Fournisseur.class)
		@JoinColumn(name = "numFournisseur", referencedColumnName = "numFournisseur",nullable = false)
		public Fournisseur fournisseur;
		
	//Migration de la clé de l'unité vers l'article
		@ManyToOne(fetch = FetchType.EAGER,targetEntity = DemandePrix.class)
		@JoinColumn(name = "idDemandePrix", referencedColumnName = "idDemandePrix",nullable = false)
		public DemandePrix demandePrix;

	public ConsulterFrsForDp() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ConsulterFrsForDp(Long idConsulterFrsForDp, Timestamp dateRemise, boolean choisit, Fournisseur fournisseur,
			DemandePrix demandePrix) {
		super();
		this.idConsulterFrsForDp = idConsulterFrsForDp;
		this.dateRemise = dateRemise;
		this.choisit = choisit;
		this.fournisseur = fournisseur;
		this.demandePrix = demandePrix;
	}



	public Long getIdConsulterFrsForDp() {
		return idConsulterFrsForDp;
	}

	public void setIdConsulterFrsForDp(Long idConsulterFrsForDp) {
		this.idConsulterFrsForDp = idConsulterFrsForDp;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public DemandePrix getDemandePrix() {
		return demandePrix;
	}

	public void setDemandePrix(DemandePrix demandePrix) {
		this.demandePrix = demandePrix;
	}

	public Timestamp getDateRemise() {
		return dateRemise;
	}

	public void setDateRemise(Timestamp dateRemise) {
		this.dateRemise = dateRemise;
	}

	public boolean isChoisit() {
		return choisit;
	}

	public void setChoisit(boolean choisit) {
		this.choisit = choisit;
	}

	@Override
	public String toString() {
		return "ConsulterFrsForDp [idConsulterFrsForDp=" + idConsulterFrsForDp + ", dateRemise=" + dateRemise
				+ ", choisit=" + choisit + ", fournisseur=" + fournisseur + ", demandePrix=" + demandePrix + "]";
	}

		
		
	
}
