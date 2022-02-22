package com.sil.gpc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.LigneReception;
import com.sil.gpc.domains.LigneTravaux;
import com.sil.gpc.repositories.LigneTravauxRepository;

@Service
public class LigneTravauxService {

	private final LigneTravauxRepository repo;

	public LigneTravauxService(LigneTravauxRepository repo) {
		super();
		this.repo = repo;
	}
	
	public LigneTravaux save(LigneTravaux ligneTravaux) {
		
			return this.repo.save(ligneTravaux);
		
	}
	
	public List<LigneTravaux> saveAll(List<LigneTravaux> ligneTravauxs) {
		
		return this.repo.saveAll(ligneTravauxs);
	
	}
	
	public LigneTravaux edit(Long id, LigneTravaux ligneTravaux) {
		
		LigneTravaux entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setDesignationLigne(ligneTravaux.getDesignationLigne());
			entiter.setPrixUnitTtc(ligneTravaux.isPrixUnitTtc());
			entiter.setPuLigneCommande(ligneTravaux.getPuLigneCommande());
			entiter.setQteLigneCommande(ligneTravaux.getQteLigneCommande());
			entiter.setRemise(ligneTravaux.getRemise());
			entiter.setSatisfaite(ligneTravaux.isSatisfaite());
			entiter.setTaibic(ligneTravaux.getTaibic());
			entiter.setTravaux(ligneTravaux.getTravaux());
			entiter.setTs(ligneTravaux.getTs());
			entiter.setTva(ligneTravaux.getTva());
			entiter.setUniter(ligneTravaux.getUniter());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		LigneTravaux entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public List<LigneTravaux> deleteAll(List<LigneTravaux> ligneTravauxs){
		this.repo.deleteAll(ligneTravauxs);
		return ligneTravauxs;
	}
	
	public LigneTravaux getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<LigneTravaux> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<LigneTravaux> findByCodeTravaux(String codeTravaux){
		
		return this.repo.findByCodeTravaux(codeTravaux);
		
	}

	
}
