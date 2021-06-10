package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Direction;
import com.sil.gpc.repositories.DirectionRepository;

@Service
public class DirectionService {

	private final DirectionRepository repo;

	public DirectionService(DirectionRepository repo) {
		super();
		this.repo = repo;
	}
	
	public Direction save(Direction direction) {
		return this.repo.save(direction);
	}
	
	public Direction edit(Long id, Direction direction) {
		
		Direction entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setLibDirection(direction.getLibDirection());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		Direction entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public Direction getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<Direction> getAll(){
		
		return this.repo.findAll();
	}


	
	
}
