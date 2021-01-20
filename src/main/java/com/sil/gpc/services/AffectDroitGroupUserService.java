package com.sil.gpc.services;

import org.springframework.stereotype.Service;

import com.sil.gpc.repositories.AffectDroitGroupUserRepository;

@Service
public class AffectDroitGroupUserService {

	private final AffectDroitGroupUserRepository repo;

	public AffectDroitGroupUserService(AffectDroitGroupUserRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	
}
