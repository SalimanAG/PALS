package com.sil.gpc.services;

import org.springframework.stereotype.Service;

import com.sil.gpc.repositories.PourcenReverseRepository;

@Service
public class PourcenReverseService {

	private final PourcenReverseRepository repo;

	public PourcenReverseService(PourcenReverseRepository repo) {
		super();
		this.repo = repo;
	}
	
	
	
}
