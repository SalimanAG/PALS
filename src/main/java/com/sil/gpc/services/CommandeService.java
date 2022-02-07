package com.sil.gpc.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sil.gpc.domains.Commande;
import com.sil.gpc.domains.Exercice;
import com.sil.gpc.domains.Fournisseur;
import com.sil.gpc.domains.LigneCommande;
import com.sil.gpc.encapsuleurs.EncapCommande;
import com.sil.gpc.repositories.CommandeRepository;
import com.sil.gpc.repositories.LigneCommandeRepository;

@Service
public class CommandeService {

	private final CommandeRepository repo;
	private final LigneCommandeRepository repo2;
	private final LigneCommandeService servi2;
	private final ReceptionService servi3;

	public CommandeService(CommandeRepository repo, LigneCommandeRepository repo2, LigneCommandeService servi2, ReceptionService servi3) {
		super();
		this.repo = repo;
		this.repo2 = repo2;
		this.servi2 = servi2;
		this.servi3 = servi3;
	}
	
	public Commande save(Commande commande) {
		
		/*
		commande.setValide(true);
		Integer val = 1, nbrMaxCaract = 6;
		String code = "CA-";
		if(this.repo.findLastNumUsed(commande.getExercice().getCodeExercice()) != null) {
			val = this.repo.findLastNumUsed(commande.getExercice().getCodeExercice());
			val++;
			
		}
		
		commande.setValeur(val);
		
		code = code+commande.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		commande.setNumCommande(code+val);
		
		*/
		
		//System.out.println(commande.toString());
		
		//if(repo.existsById(commande.getNumCommande())==false) 
		return this.repo.save(commande) ;
		//return null;
	}
	
	public Commande edit(Long id, Commande commande) {
		
		Commande entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setDateCommande(commande.getDateCommande());
			entiter.setDelaiLivraison(commande.getDelaiLivraison());
			entiter.setDescription(commande.getDescription());
			entiter.setExercice(commande.getExercice());
			entiter.setFrs(commande.getFrs());
			entiter.setValide(commande.isValide());
			entiter.setDepartement(commande.getDepartement());
			entiter.setJustif(commande.getJustif());
			entiter.setNumDa(commande.getNumDa());
			entiter.setCmdDe(commande.getCmdDe());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	@Transactional
	public EncapCommande editByEncap(Long id, EncapCommande encap) {
				
		List<LigneCommande> lignes = this.repo2.findAll();
		List<LigneCommande> concernedLignes = new ArrayList<LigneCommande>();
		List<LigneCommande> newLignes = new ArrayList<LigneCommande>();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).numCommande.getNumCommande().equals(id)) {
				concernedLignes.add(lignes.get(i));
			}
		}
		
		for(int i = 0; i < encap.getLigneCommandes().size(); i++) {
			boolean added = true;
			LigneCommande enti = null;
			
			for(int j = 0; j < concernedLignes.size(); j++) {
				if(concernedLignes.get(j).getArticle().getNumArticle().equals(encap.getLigneCommandes().get(i).getArticle().getNumArticle()) ) {
					added = false;
					enti = concernedLignes.get(j);
					break;
				}
			}
			
			LigneCommande newer = encap.getLigneCommandes().get(i);
			newer.setNumCommande(repo.getOne(id));
			
			if(added == true) {
				
				this.repo2.save(newer);
			}
			else {
				this.servi2.edit(enti.getIdLigneCommande(), newer);
			}
		}
		
		for(int i = 0; i < concernedLignes.size(); i++) {
			
			boolean removed = true;
			
			for(int j = 0; j < encap.getLigneCommandes().size(); j++) {
				if(concernedLignes.get(i).getArticle().getNumArticle().longValue() == encap.getLigneCommandes().get(j).getArticle().getNumArticle().longValue()) {
					removed = false;
					break;
				}
			}
			
			if(removed == true) {
				this.repo2.deleteById(concernedLignes.get(i).getIdLigneCommande());
			}			
			
		}
		
		lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).numCommande.getNumCommande().equals(id)) {
				newLignes.add(lignes.get(i));
			}
		}
		
		
		return new EncapCommande(this.edit(id, encap.getCommande()), newLignes);
	}
	
	
	public boolean delete(Long id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	@Transactional
	public boolean deleteACommande2(Long id) {
		
		List<LigneCommande> lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getNumCommande().getNumCommande() == id) {
				this.repo2.deleteById(lignes.get(i).getIdLigneCommande());
			}
		}
		
		return this.delete(id);
	}
	
	public Commande getById(Long id){
		
		return this.repo.findById(id).get();
	}
	
	public List<Commande> getAll(){
		
		return this.repo.findAll();
	}
	
	
	public List<Commande> findByDateCommande(Date dateCommande){
		
		return this.repo.findByDateCommande(dateCommande);
	}
	
	public List<Commande> findByDescription(String description){
		
		return this.repo.findByDescription(description);
	}
	
	public List<Commande> findByDelaiLivraison(int delaiLivraison){
		
		return this.repo.findByDelaiLivraison(delaiLivraison);
	}
	
	public List<Commande> findByFrs(Fournisseur fournisseur){
		
		return this.repo.findByFrs(fournisseur);
	}
	
	public List<Commande> findByExercice(Exercice exercice){
		
		return this.repo.findByExercice(exercice);
	}

	public boolean hasCommandeReception(Long id) {
		boolean res = false;
		
		if(this.servi3.findByNumCommande(id).size() > 0) {
			res = true;
		}
		
		return res;
	}
	
}
