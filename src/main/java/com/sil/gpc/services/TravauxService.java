package com.sil.gpc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Commande;
import com.sil.gpc.domains.LigneCommande;
import com.sil.gpc.domains.LigneTravaux;
import com.sil.gpc.domains.Travaux;
import com.sil.gpc.encapsuleurs.EncapTravaux;
import com.sil.gpc.repositories.LigneTravauxRepository;
import com.sil.gpc.repositories.TravauxRepository;

@Service
public class TravauxService {

	private final TravauxRepository repo;
	private final LigneTravauxRepository repo2;
	private final LigneTravauxService serv2;

	public TravauxService(TravauxRepository repo, LigneTravauxService serv2, LigneTravauxRepository repo2) {
		super();
		this.repo = repo;
		this.repo2 = repo2;
		this.serv2 = serv2;
	}
	
	public Travaux save(Travaux travaux) {
		
		Integer val = 1, nbrMaxCaract = 6;
		String code = "TRA-";
		if(this.repo.findLastNumUsed(travaux.getExercice().getNumExercice()) != null) {
			val = this.repo.findLastNumUsed(travaux.getExercice().getNumExercice());
			val++;
			
		}
		
		travaux.setValeur(val);
		
		code = code+travaux.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		travaux.setNumTravaux(code+val);
		
		
		
		if(!repo.existsById(travaux.getNumTravaux())) {
			return this.repo.save(travaux);
		}
		return null;
	}
	
	public EncapTravaux saveByEncap(EncapTravaux encapTravaux) {
		
		List<LigneTravaux> lignes = encapTravaux.getLigneTravauxs();
		
		Travaux element = this.save(encapTravaux.getTravaux());
		
		for (int i = 0; i < lignes.size(); i++) {
			LigneTravaux lig = lignes.get(i);
			lig.setTravaux(element);
			
			lignes.set(i, lig);
		}
		
		lignes = this.serv2.saveAll(lignes);
		
		return new EncapTravaux(element, lignes);
		
	}
	
	public Travaux edit(String id, Travaux travaux) {
		
		Travaux entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setDateCommande(travaux.getDateCommande());
			entiter.setDateRemise(travaux.getDateRemise());
			entiter.setDelaiLivraison(travaux.getDelaiLivraison());
			entiter.setDepartement(travaux.getDepartement());
			entiter.setDescription(travaux.getDescription());
			entiter.setExercice(travaux.getExercice());
			entiter.setFrs(travaux.getFrs());
			entiter.setJustif(travaux.getJustif());
			entiter.setLiver(travaux.isLiver());
			entiter.setNumDa(travaux.getNumDa());
			entiter.setReporter(travaux.isReporter());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public Travaux edit2(String id, Travaux travaux) {
		
		Travaux entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setValide(travaux.isValide());
						
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public EncapTravaux editByEncap(String id, EncapTravaux encapTravaux) {
		
		List<LigneTravaux> lignes = this.repo2.findAll();
		List<LigneTravaux> concernedLignes = new ArrayList<LigneTravaux>();
		List<LigneTravaux> newLignes = encapTravaux.getLigneTravauxs();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getTravaux().getNumTravaux().equalsIgnoreCase(id)) {
				concernedLignes.add(lignes.get(i));
			}
		}
		
		
		this.serv2.deleteAll(concernedLignes);
		
		Travaux tra = this.edit(id, encapTravaux.getTravaux());
		
		for(int i = 0; i < newLignes.size(); i++) {			
			newLignes.get(i).setTravaux(tra);
		}
		
		
		return new EncapTravaux(tra, serv2.saveAll(newLignes));

		
	}
	
	public boolean delete(String id) {
		
		Travaux entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	
	public boolean delete2(String id) {
		
		Travaux entiter = this.repo.getOne(id);
		if(entiter != null) {
			
			List<LigneTravaux> lignes = this.repo2.findAll();
			List<LigneTravaux> concernedLignes = new ArrayList<LigneTravaux>();
			
			for(int i = 0; i < lignes.size(); i++) {
				if(lignes.get(i).getTravaux().getNumTravaux().equalsIgnoreCase(id)) {
					concernedLignes.add(lignes.get(i));
				}
			}
			
			
			this.serv2.deleteAll(concernedLignes);
			
			
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	public Travaux getById(String id){
		
		return this.repo.findById(id).get();
	}
	
	public List<Travaux> getAll(){
		
		return this.repo.findAll();
	}


	

}
