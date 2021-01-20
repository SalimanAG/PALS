package com.sil.gpc.domains;

import java.sql.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Utilisateur {

	@Id  //*******************A générer automatiquement
	private Long idUtilisateur;
	private String login;
	private String motDePass;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String fonctionUtilisateur;
	private boolean activeUtilisateur;
	private String dateLastConnex;
	private boolean askMdp1erLance;
	
	@OneToMany(cascade = CascadeType.ALL,targetEntity = OpCaisse.class,mappedBy = "utilisateur")
	public List<OpCaisse> opCaisseParUtilisateur;

	
	@ManyToOne(cascade = CascadeType.ALL,targetEntity = Service.class)
	@JoinColumn(name = "codeService", referencedColumnName = "codeService", nullable = true)
	public Service service;
	
	//**************************Les affecters de l'utilisateur
	// Liaison à la table Affecter
	@OneToMany(cascade = CascadeType.ALL,targetEntity = Affecter.class, mappedBy = "utilisateur")
	public List<Utilisateur> affectationsDunUtilisateur;

	
	public Utilisateur() {
		super();
	}

	public Utilisateur(String login, String motDePass, String nomUtilisateur, String prenomUtilisateur,
			String fonctionUtilisateur, boolean activeUtilisateur, Service service) {
		super();
		this.login = login;
		this.motDePass = motDePass;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.fonctionUtilisateur = fonctionUtilisateur;
		this.activeUtilisateur = activeUtilisateur;
		this.service = service;
	}
	
	

	public Utilisateur(String login, String motDePass, String nomUtilisateur, String prenomUtilisateur,
			String fonctionUtilisateur, boolean activeUtilisateur, String dateLastConnex, boolean askMdp1erLance,
			Service service) {
		super();
		this.login = login;
		this.motDePass = motDePass;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.fonctionUtilisateur = fonctionUtilisateur;
		this.activeUtilisateur = activeUtilisateur;
		this.dateLastConnex = dateLastConnex;
		this.askMdp1erLance = askMdp1erLance;
		this.service = service;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePass() {
		return motDePass;
	}

	public void setMotDePass(String motDePass) {
		this.motDePass = motDePass;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getFonctionUtilisateur() {
		return fonctionUtilisateur;
	}

	public void setFonctionUtilisateur(String fonctionUtilisateur) {
		this.fonctionUtilisateur = fonctionUtilisateur;
	}

	public boolean isActiveUtilisateur() {
		return activeUtilisateur;
	}

	public void setActiveUtilisateur(boolean activeUtilisateur) {
		this.activeUtilisateur = activeUtilisateur;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", login=" + login + ", motDePass=" + motDePass
				+ ", nomUtilisateur=" + nomUtilisateur + ", prenomUtilisateur=" + prenomUtilisateur
				+ ", fonctionUtilisateur=" + fonctionUtilisateur + ", activeUtilisateur=" + activeUtilisateur
				+ ", opCaisseParUtilisateur=" + opCaisseParUtilisateur + ", service=" + service
				+ ", affectationsDunUtilisateur=" + affectationsDunUtilisateur + "]";
	}

	public String getDateLastConnex() {
		return dateLastConnex;
	}

	public void setDateLastConnex(String dateLastConnex) {
		this.dateLastConnex = dateLastConnex;
	}

	public boolean isAskMdp1erLance() {
		return askMdp1erLance;
	}

	public void setAskMdp1erLance(boolean askMdp1erLance) {
		this.askMdp1erLance = askMdp1erLance;
	}

	

	
}
