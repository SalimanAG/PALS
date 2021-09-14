package com.sil.gpc.domains;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Utilisateur {

	@Id  //*******************A générer automatiquement
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUtilisateur;
	@Column(unique = true)
	private String login;
	private String motDePass;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private boolean activeUtilisateur;
	private String dateLastConnex;
	private boolean askMdp1erLance;
	
	@ManyToOne(targetEntity = Service.class)
	@JoinColumn(name = "numService", referencedColumnName = "numService", nullable = true)
	public Service service;
	
	@ManyToOne(targetEntity = Profession.class)
	@JoinColumn(name = "numProfession", referencedColumnName = "numProfession", nullable = true)
	public Profession profession;
	
	@ManyToOne(targetEntity = Fonction.class)
	@JoinColumn(name = "numFonction", referencedColumnName = "numFonction", nullable = true)
	public Fonction fonction;
	
	@ManyToOne(targetEntity = Civilite.class)
	@JoinColumn(name = "numCivilite", referencedColumnName = "numCivilite", nullable = true)
	public Civilite civilite;
	
	@ManyToOne(targetEntity = GroupUser.class)
	@JoinColumn(name = "numGroupUser", referencedColumnName = "numGroupUser", nullable = true)
	public GroupUser groupUser;
	
	public Utilisateur() {
		super();
	}

	public Utilisateur(String login, String motDePass, String nomUtilisateur, String prenomUtilisateur,
			Fonction fonction, boolean activeUtilisateur, Service service, Profession profession,
			Civilite civilite, GroupUser groupUser) {
		super();
		this.login = login;
		this.motDePass = motDePass;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.fonction = fonction;
		this.activeUtilisateur = activeUtilisateur;
		this.service = service;
		this.profession = profession;
		this.civilite = civilite;
		this.groupUser = groupUser;
		this.askMdp1erLance = true;
	}

	public Utilisateur(String login, String motDePass, String nomUtilisateur, String prenomUtilisateur,
			Fonction fonction, boolean activeUtilisateur, String dateLastConnex, boolean askMdp1erLance,
			Service service, Profession profession,Civilite civilite, GroupUser groupUser) {
		super();
		this.login = login;
		this.motDePass = motDePass;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.fonction = fonction;
		this.activeUtilisateur = activeUtilisateur;
		this.dateLastConnex = dateLastConnex;
		this.askMdp1erLance = askMdp1erLance;
		this.service = service;
		this.profession = profession;
		this.civilite = civilite;
		this.groupUser = groupUser;
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

	@JsonIgnore
	public String getMotDePass() {
		return motDePass;
	}

	@JsonSetter
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

	public boolean isActiveUtilisateur() {
		return activeUtilisateur;
	}

	public void setActiveUtilisateur(boolean activeUtilisateur) {
		this.activeUtilisateur = activeUtilisateur;
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

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public GroupUser getGroupUser() {
		return groupUser;
	}

	public void setGroupUser(GroupUser groupUser) {
		this.groupUser = groupUser;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", login=" + login + ", motDePass=" + motDePass
				+ ", nomUtilisateur=" + nomUtilisateur + ", prenomUtilisateur=" + prenomUtilisateur
				+ ", activeUtilisateur=" + activeUtilisateur + ", dateLastConnex=" + dateLastConnex
				+ ", askMdp1erLance=" + askMdp1erLance + ", service=" + service + ", profession=" + profession
				+ ", fonction=" + fonction + ", civilite=" + civilite + ", groupUser=" + groupUser + "]";
	}

	

	
}
