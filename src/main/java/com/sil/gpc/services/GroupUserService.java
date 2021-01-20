package com.sil.gpc.services;

import org.springframework.stereotype.Service;

import com.sil.gpc.repositories.GroupUserRepository;

@Service
public class GroupUserService {

	private final GroupUserRepository repo;

	public GroupUserService(GroupUserRepository repo) {
		super();
		this.repo = repo;
	}
	
	
}
