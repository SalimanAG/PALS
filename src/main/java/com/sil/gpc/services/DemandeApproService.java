package com.sil.gpc.services;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sil.gpc.domains.Commande;
import com.sil.gpc.domains.DemandeApprovisionnement;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.LigneDemandeAppro;
import com.sil.gpc.encapsuleurs.EncapDemandeAppro;
import com.sil.gpc.repositories.DemandeApproRepository;
import com.sil.gpc.repositories.LigneDemandeApproRepository;

@Service
public class DemandeApproService {

	private final DemandeApproRepository repo;
	private final LigneDemandeApproRepository repo2;
	private final LigneDemandeApproService servi2;

	public DemandeApproService(DemandeApproRepository repo, LigneDemandeApproRepository repo2, LigneDemandeApproService servi2) {
		super();
		this.repo = repo;
		this.repo2 = repo2;
		this.servi2 = servi2;
	}
	
	public DemandeApprovisionnement save(DemandeApprovisionnement demandeApprovisionnement) {
		//demandeApprovisionnement.setValideDA(true);
		Integer val = 1, nbrMaxCaract = 6;
		String code = "DB-";
		if(this.repo.findLastNumUsed(demandeApprovisionnement.getExercice().getNumExercice()) != null) {
			val = this.repo.findLastNumUsed(demandeApprovisionnement.getExercice().getNumExercice());
			val++;
			
		}
		
		demandeApprovisionnement.setValeur(val);
		
		code = code+demandeApprovisionnement.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		demandeApprovisionnement.setNumDA(code+val);
		demandeApprovisionnement.setDateDA(new Timestamp(System.currentTimeMillis()));
		
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
			entiter.setDescription(demandeApprovisionnement.getDescription());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	
	@Transactional
	public EncapDemandeAppro editByEncap(String id, EncapDemandeAppro encap) {
		
		
		List<LigneDemandeAppro> concernedLignes = this.repo2.findByCodeDemAppro(id);
		List<LigneDemandeAppro> newLignes = new ArrayList<LigneDemandeAppro>();
		
		
		for(int i = 0; i < encap.getLigneDemandeAppros().size(); i++) {
			boolean added = true;
			LigneDemandeAppro enti = null;
			
			for(int j = 0; j < concernedLignes.size(); j++) {
				if(concernedLignes.get(j).getArticle().getNumArticle() == encap.getLigneDemandeAppros().get(i).getArticle().getNumArticle()) {
					added = false;
					enti = concernedLignes.get(j);
					break;
				}
			}
			
			LigneDemandeAppro newer = encap.getLigneDemandeAppros().get(i);
			newer.setAppro(repo.getOne(id));
			
			if(added == true) {
				
				this.repo2.save(newer);
			}
			else {
				this.servi2.edit(enti.getIdLigneDA(), newer);
			}
		}
		
		for(int i = 0; i < concernedLignes.size(); i++) {
			
			boolean removed = true;
			
			for(int j = 0; j < encap.getLigneDemandeAppros().size(); j++) {
				if(concernedLignes.get(i).getArticle().getNumArticle().longValue() == encap.getLigneDemandeAppros().get(j).getArticle().getNumArticle()) {
					removed = false;
					break;
				}
			}
			
			if(removed == true) {
				this.repo2.deleteById(concernedLignes.get(i).getIdLigneDA());
			}			
			
		}
		
		newLignes = this.repo2.findByCodeDemAppro(id);
		
		
		
		return new EncapDemandeAppro(this.edit(id, encap.getDemandeApprovisionnement()), newLignes);
	}
	
	

	
	public boolean delete(String id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	@Transactional
	public boolean deleteADemandeApprovisionnement2(String id) {
		
		List<LigneDemandeAppro> lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			//boolean va = false;
			if(lignes.get(i).getAppro().getNumDA().equalsIgnoreCase(id)) {
				this.repo2.deleteById(lignes.get(i).getIdLigneDA());
				//va = true;
			}
			//System.out.println("Valllll "+va+" "+lignes.get(i).getAppro().getNumDA()+" "+id);
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
	
	public List<DemandeApprovisionnement> findByCodeExercice(String codeExo){
		
		return this.repo.findByCodeExercice(codeExo);
	}
	
}
