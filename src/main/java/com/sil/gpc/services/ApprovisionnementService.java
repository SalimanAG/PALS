package com.sil.gpc.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Approvisionnement;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.LigneAppro;
import com.sil.gpc.domains.LigneDemandeAppro;
import com.sil.gpc.domains.LigneDemandePrix;
import com.sil.gpc.encapsuleurs.EncapApprovisionnement;
import com.sil.gpc.encapsuleurs.EncapDemandePrix;
import com.sil.gpc.repositories.ApprovisionementRepository;
import com.sil.gpc.repositories.LigneApproRepository;

@Service
public class ApprovisionnementService {

	private final ApprovisionementRepository repo;
	private final LigneApproRepository repo2;
	private final LigneApproService servi2;

	public ApprovisionnementService(ApprovisionementRepository repo, LigneApproRepository repo2, LigneApproService servi2) {
		super();
		this.repo = repo;
		this.repo2 = repo2;
		this.servi2 = servi2;
	}
	
	public Approvisionnement save(Approvisionnement approvisionnement) {
		approvisionnement.setValideAppro(true);	
		
		Integer val = 1, nbrMaxCaract = 6;
		String code = "BA-";
		if(this.repo.findLastNumUsed(approvisionnement.getExercice().getNumExercice()) != null) {
			val = this.repo.findLastNumUsed(approvisionnement.getExercice().getNumExercice());
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
	
	
	public EncapApprovisionnement editByEncap(String id, EncapApprovisionnement encap) {
		
		List<LigneAppro> lignes = this.repo2.findAll();
		List<LigneAppro> concernedLignes = new ArrayList<LigneAppro>();
		List<LigneAppro> newLignes = new ArrayList<LigneAppro>();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getAppro().getNumAppro() == id) {
				concernedLignes.add(lignes.get(i));
			}
		}
		
		for(int i = 0; i < encap.getLigneAppros().size(); i++) {
			boolean added = true;
			LigneAppro enti = null;
			
			for(int j = 0; j < concernedLignes.size(); j++) {
				if(concernedLignes.get(j).getLigneDA().getArticle().getNumArticle() == encap.getLigneAppros().get(i).getLigneDA().getArticle().getNumArticle()) {
					added = false;
					enti = concernedLignes.get(j);
					break;
				}
			}
			
			LigneAppro newer = encap.getLigneAppros().get(i);
			newer.setAppro(repo.getOne(id));
			
			if(added == true) {
				
				this.repo2.save(newer);
			}
			else {
				this.servi2.edit(enti.getIdLigneAppro(), newer);
			}
		}
		
		for(int i = 0; i < concernedLignes.size(); i++) {
			
			boolean removed = true;
			
			for(int j = 0; j < encap.getLigneAppros().size(); j++) {
				if(concernedLignes.get(i).getLigneDA().getArticle().getNumArticle() == encap.getLigneAppros().get(j).getLigneDA().getArticle().getNumArticle()) {
					removed = false;
					break;
				}
			}
			
			if(removed == true) {
				this.repo2.deleteById(concernedLignes.get(i).getIdLigneAppro());
			}			
			
		}
		
		lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getAppro().getNumAppro() == id) {
				newLignes.add(lignes.get(i));
			}
		}
		
		
		return new EncapApprovisionnement(this.edit(id, encap.getApprovisionnement()), newLignes);
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
