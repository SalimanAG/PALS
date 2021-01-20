package com.sil.gpc.services;

import org.springframework.stereotype.Service;

import com.sil.gpc.repositories.DroitUserRepository;

@Service
public class DroitUserService {

	private final DroitUserRepository repo;

	public DroitUserService(DroitUserRepository repo) {
		super();
		this.repo = repo;
	}
	
	
}
