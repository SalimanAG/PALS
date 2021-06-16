package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.LigneAppro;
import com.sil.gpc.domains.LigneDemandeAppro;
import com.sil.gpc.repositories.ApprovisionementRepository;
import com.sil.gpc.repositories.LigneApproRepository;

@Service
public class ApprovisionnementService {

	private final ApprovisionementRepository repo;
	private final LigneApproRepository repo2;

	public ApprovisionnementService(ApprovisionementRepository repo, LigneApproRepository repo2) {
		super();
		this.repo = repo;
		this.repo2 = repo2;
	}
	
	public Approvisionnement save(Approvisionnement approvisionnement) {
		approvisionnement.setValideAppro(true);	
		
		Integer val = 1, nbrMaxCaract = 6;
		String code = "BA-";
		if(this.repo.findLastNumUsed(approvisionnement.getExercice().getCodeExercice()) != null) {
			val = this.repo.findLastNumUsed(approvisionnement.getExercice().getCodeExercice());
			val++;
			
		}
		
		approvisionnement.setValeur(val);
		
		code = code+approvisionnement.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		approvisionnement.setNumAppro(code+val);
		approvisionnement.setValideAppro(true);
		
		if(repo.existsById(approvisionnement.getNumAppro())==false) return this.repo.save(approvisionnement) ;
		
		return null;
		
	}
	
	public Approvisionnement edit(String id, Approvisionnement approvisionnement) {
		
		Approvisionnement entiter = this.repo.getOne(id); 
		if(entiter != null) {
			entiter.setDateAppro(approvisionnement.getDateAppro());
			entiter.setDescriptionAppro(approvisionnement.getDescriptionAppro());
			entiter.setValideAppro(approvisionnement.isValideAppro());
			entiter.setExercice(approvisionnement.getExercice());
			entiter.setMagasin(approvisionnement.getMagasin());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		Approvisionnement entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	
	public boolean deleteAApprovisionnement2(String id) {
		
		List<LigneAppro> lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getAppro().getNumAppro() == id) {
				this.repo2.deleteById(lignes.get(i).getIdLigneAppro());
			}
		}
		
		return this.delete(id);
	}
	
	
	public Optional<Approvisionnement> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<Approvisionnement> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<Approvisionnement> findByNumAppro(String numAppro){
		
		return this.repo.findByNumAppro(numAppro);
	}
	
	public List<Approvisionnement> findByDateAppro(Date dateAppro){
		
		return this.repo.findByDateAppro(dateAppro);
	}
	
	public List<Approvisionnement> findByDescriptionAppro(String descriptionAppro){
		
		return this.repo.findByDescriptionAppro(descriptionAppro);
	}
	
	public List<Approvisionnement> findByExercice(Exercice exercice){
		
		return this.repo.findByExercice(exercice);
	}
	
}
