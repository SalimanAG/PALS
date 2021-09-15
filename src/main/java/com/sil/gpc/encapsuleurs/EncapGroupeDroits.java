package com.sil.gpc.encapsuleurs;

import java.util.List;

import com.sil.gpc.domains.DroitUser;
import com.sil.gpc.domains.GroupUser;

public class EncapGroupeDroits {
	
	private GroupUser groupUser;
	private List<DroitUser> droitUsers;
	
	public EncapGroupeDroits(GroupUser groupUser, List<DroitUser> droitUsers) {
		super();
		this.groupUser = groupUser;
		this.droitUsers = droitUsers;
	}

	public GroupUser getGroupUser() {
		return groupUser;
	}

	public void setGroupUser(GroupUser groupUser) {
		this.groupUser = groupUser;
	}

	public List<DroitUser> getDroitUsers() {
		return droitUsers;
	}

	public void setDroitUsers(List<DroitUser> droitUsers) {
		this.droitUsers = droitUsers;
	}

	@Override
	public String toString() {
		return "EncapGroupeDroits [groupUser=" + groupUser + ", droitUsers=" + droitUsers + "]";
	}
	
	

}
