package com.sil.gpc.services;

import org.springframework.stereotype.Service;

import com.sil.gpc.repositories.AffectUserGroupRepository;

@Service
public class AffectUserGroupService {

	private final AffectUserGroupRepository repo;

	public AffectUserGroupService(AffectUserGroupRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	
}
