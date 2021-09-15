package com.sil.gpc.encapsuleurs;

import java.util.List;

import com.sil.gpc.domains.GroupUser;
import com.sil.gpc.domains.Utilisateur;

public class EncapUserGroupes {

	private Utilisateur utilisateur;
	
	private List<GroupUser> groupUsers;

	public EncapUserGroupes(Utilisateur utilisateur, List<GroupUser> groupUsers) {
		super();
		this.utilisateur = utilisateur;
		this.groupUsers = groupUsers;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<GroupUser> getGroupUsers() {
		return groupUsers;
	}

	public void setGroupUsers(List<GroupUser> groupUsers) {
		this.groupUsers = groupUsers;
	}

	@Override
	public String toString() {
		return "EncapUserGroupes [utilisateur=" + utilisateur + ", groupUsers=" + groupUsers + "]";
	}
	
	
}
