package com.sil.gpc.services;

import org.springframework.stereotype.Service;

import com.sil.gpc.repositories.SiteMarcherRepository;

@Service
public class SiteMarcherService {

	private final SiteMarcherRepository repo;

	public SiteMarcherService(SiteMarcherRepository repo) {
		super();
		this.repo = repo;
	}
	
	
}
