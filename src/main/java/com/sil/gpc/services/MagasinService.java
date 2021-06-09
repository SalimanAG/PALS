package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Magasin;
import com.sil.gpc.repositories.MagasinRepository;

@Service
public class MagasinService {
	
	private final MagasinRepository repos;

	/**
	 * @param repos
	 */
	public MagasinService(MagasinRepository mr) {
		this.repos = mr;
	}
	
	public Magasin save(Magasin mg){
		if(!repos.existsById(mg.getNumMagasin())) {
			return repos.save(mg);
		}
		return null;
	}
	
	public Magasin edit(Magasin mg, Long cm){
		Magasin mag=repos.getOne(cm);
		if(mag!=null) {
		mag.setLibMagasin(mg.getLibMagasin());
		
		return repos.save(mag);
		}else
			return null;
	}

	public boolean delete(Long cm){
		repos.deleteById(cm);
		return repos.existsById(cm);
	}

	public Optional<Magasin> findById(Long cm){
		return repos.findById(cm);
	}

	public List<Magasin> findByLibelle(String lib){
		return repos.findByLibMagasin(lib);
	}

	public List<Magasin> findAll(){
		return repos.findAll();
	}

}
