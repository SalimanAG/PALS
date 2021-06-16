package com.sil.gpc.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.DemandeApprovisionnement;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.LigneDemandeAppro;
import com.sil.gpc.domains.LigneReception;
import com.sil.gpc.repositories.DemandeApproRepository;
import com.sil.gpc.repositories.LigneDemandeApproRepository;

@Service
public class DemandeApproService {

	private final DemandeApproRepository repo;
	private final LigneDemandeApproRepository repo2;

	public DemandeApproService(DemandeApproRepository repo, LigneDemandeApproRepository repo2) {
		super();
		this.repo = repo;
		this.repo2 = repo2;
	}
	
	public DemandeApprovisionnement save(DemandeApprovisionnement demandeApprovisionnement) {
		demandeApprovisionnement.setValideDA(true);
		Integer val = 1, nbrMaxCaract = 6;
		String code = "DA-";
		if(this.repo.findLastNumUsed(demandeApprovisionnement.getExercice().getCodeExercice()) != null) {
			val = this.repo.findLastNumUsed(demandeApprovisionnement.getExercice().getCodeExercice());
			val++;
			
		}
		
		demandeApprovisionnement.setValeur(val);
		
		code = code+demandeApprovisionnement.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		demandeApprovisionnement.setNumDA(code+val);
		
		if(repo.existsById(demandeApprovisionnement.getNumDA())==false) return this.repo.save(demandeApprovisionnement);
		
		return null;
		
	}
	
	public DemandeApprovisionnement edit(String id, DemandeApprovisionnement demandeApprovisionnement) {
		
		DemandeApprovisionnement entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setDateDA(demandeApprovisionnement.getDateDA());
			entiter.setExercice(demandeApprovisionnement.getExercice());
			entiter.setValideDA(demandeApprovisionnement.isValideDA());
			entiter.setService(demandeApprovisionnement.getService());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(String id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	
	public boolean deleteADemandeApprovisionnement2(String id) {
		
		List<LigneDemandeAppro> lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getAppro().getNumDA() == id) {
				this.repo2.deleteById(lignes.get(i).getIdLigneDA());
			}
		}
		
		return this.delete(id);
	}
	
	
	public Optional<DemandeApprovisionnement> getById(String id){
		
		return this.repo.findById(id);
	}
	
	public List<DemandeApprovisionnement> getAll(){
		
		return this.repo.findAll();
	}
	
	public List<DemandeApprovisionnement> findByNumDA(String numDA){
		
		return this.repo.findByNumDA(numDA);
	}
	
	public List<DemandeApprovisionnement> findByDateDA(Date dateDA){
		
		return this.repo.findByDateDA(dateDA);
	}
	
	public List<DemandeApprovisionnement> findByExercice(Exercice exercice){
		
		return this.repo.findByExercice(exercice);
	}
	
}
