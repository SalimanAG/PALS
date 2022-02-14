 package com.sil.gpc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sil.gpc.domains.Commande;
import com.sil.gpc.domains.FactureProFormAcha;
import com.sil.gpc.domains.LigneCommande;
import com.sil.gpc.domains.LigneDemandePrix;
import com.sil.gpc.domains.LigneFactureProFormAchat;
import com.sil.gpc.encapsuleurs.EncapCommande;
import com.sil.gpc.encapsuleurs.EncapDemandePrix;
import com.sil.gpc.encapsuleurs.EncapFactureProformAchat;
import com.sil.gpc.repositories.CommandeRepository;
import com.sil.gpc.repositories.FactureProFormAchaRepository;
import com.sil.gpc.repositories.LigneCommandeRepository;
import com.sil.gpc.repositories.LigneFactureProFormAchatRepository;

@Service
public class FactureProFormAchaService {

	private final FactureProFormAchaRepository repo;
	private final LigneFactureProFormAchatRepository repo2;
	private final LigneFactureProFormAchaService servi2;
	private final CommandeRepository repo3;
	private final CommandeService servi3;
	private final LigneCommandeRepository repo4;
	private final LigneCommandeService servi4;

	public FactureProFormAchaService(FactureProFormAchaRepository repo, LigneFactureProFormAchatRepository repo2, LigneFactureProFormAchaService servi2, CommandeRepository repo3, CommandeService servi3, LigneCommandeService servi4, LigneCommandeRepository repo4) {
		super();
		this.repo = repo;
		this.repo2 = repo2;
		this.servi2 = servi2;
		this.repo3 = repo3;
		this.servi3 = servi3;
		this.repo4 = repo4;
		this.servi4 = servi4;
		
	}
	
	public FactureProFormAcha save(FactureProFormAcha factureProFormAcha) {
		
		Integer val = 1, nbrMaxCaract = 6;
		String code = "FPA-";
		if(this.repo.findLastNumUsed(factureProFormAcha.getExercice().getNumExercice()) != null) {
			val = this.repo.findLastNumUsed(factureProFormAcha.getExercice().getNumExercice());
			val++;
			
		}
		
		factureProFormAcha.setValeur(val);
		
		code = code+factureProFormAcha.getExercice().getCodeExercice();
		
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		
		factureProFormAcha.setIdFpfa(code+val);
		
		
		if(!repo.existsById(factureProFormAcha.getIdFpfa())) {
			return this.repo.save(factureProFormAcha);
		}
		return null;
	}
	
	public FactureProFormAcha edit(String id, FactureProFormAcha factureProFormAcha) {
		
		FactureProFormAcha entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setCommande(factureProFormAcha.getCommande());
			entiter.setDateDeplisFpfa(factureProFormAcha.getDateDeplisFpfa());
			entiter.setDateFpfa(factureProFormAcha.getDateFpfa());
			entiter.setDatePriseFpfa(factureProFormAcha.getDatePriseFpfa());
			entiter.setDesignationFpfa(factureProFormAcha.getDesignationFpfa());
			entiter.setExercice(factureProFormAcha.getExercice());
			entiter.setFournisseur(factureProFormAcha.getFournisseur());
			entiter.setObserFpfa(factureProFormAcha.getObserFpfa());
			entiter.setValideFpfa(factureProFormAcha.isValideFpfa());
			entiter.setDemandePrix(factureProFormAcha.getDemandePrix());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	
	public EncapFactureProformAchat editByEncap(String id, EncapFactureProformAchat encap) {
		
		List<LigneFactureProFormAchat> lignes = this.repo2.findAll();
		List<LigneFactureProFormAchat> concernedLignes = new ArrayList<LigneFactureProFormAchat>();
		List<LigneFactureProFormAchat> newLignes = new ArrayList<LigneFactureProFormAchat>();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getFactureProFormAcha().getIdFpfa().equalsIgnoreCase(id)) {
				concernedLignes.add(lignes.get(i));
			}
		}
		
		for(int i = 0; i < encap.getFactureProFormAchats().size(); i++) {
			boolean added = true;
			LigneFactureProFormAchat enti = null;
			
			for(int j = 0; j < concernedLignes.size(); j++) {
				if(concernedLignes.get(j).getArticle().getNumArticle() == encap.getFactureProFormAchats().get(i).getArticle().getNumArticle()) {
					added = false;
					enti = concernedLignes.get(j);
					break;
				}
			}
			
			LigneFactureProFormAchat newer = encap.getFactureProFormAchats().get(i);
			newer.setFactureProFormAcha(repo.getOne(id));
			
			if(added == true) {
				
				this.repo2.save(newer);
			}
			else {
				this.servi2.edit(enti.getIdLigneFpfa(), newer);
			}
		}
		
		for(int i = 0; i < concernedLignes.size(); i++) {
			
			boolean removed = true;
			
			for(int j = 0; j < encap.getFactureProFormAchats().size(); j++) {
				if(concernedLignes.get(i).getArticle().getNumArticle().longValue() == encap.getFactureProFormAchats().get(j).getArticle().getNumArticle()) {
					removed = false;
					break;
				}
			}
			
			if(removed == true) {
				this.repo2.deleteById(concernedLignes.get(i).getIdLigneFpfa());
			}			
			
		}
		
		lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getFactureProFormAcha().getIdFpfa().equalsIgnoreCase(id)) {
				newLignes.add(lignes.get(i));
			}
		}
		
		
		return new EncapFactureProformAchat(this.edit(id, encap.getFactureProFormAcha()), newLignes);
	}
	
	

	
	
	public boolean delete(String id) {
		
		FactureProFormAcha entiter = this.repo.getOne(id);
		if(entiter != null) {
			this.repo.deleteById(id);
		}
		
		return !this.repo.existsById(id);
	}
	
	
	public boolean deleteAFactureProFormAcha2(String id) {
		
		List<LigneFactureProFormAchat> lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getFactureProFormAcha().getIdFpfa().equalsIgnoreCase(id)) {
				this.repo2.deleteById(lignes.get(i).getIdLigneFpfa());
			}
		}
		
		return this.delete(id);
	}
	
	
	public FactureProFormAcha getById(String id){
		
		return this.repo.findById(id).get();
	}
	
	public List<FactureProFormAcha> getAll(){
		
		return this.repo.findAll();
	}

	
	public EncapCommande getCommande(String id, Commande commande) {
		
		FactureProFormAcha fpfa = this.repo.findById(id).get();
		Commande tempCom = new Commande();
		List<LigneCommande> tempLigneCommande = new ArrayList<LigneCommande>();
		
		
		if(fpfa !=null && fpfa.commande != null) {
			//tempCom = this.repo3.getOne();
			fpfa.commande.setDateCommande(commande.getDateCommande());
			fpfa.commande.setDateRemise(commande.getDateRemise());
			fpfa.commande.setDelaiLivraison(commande.getDelaiLivraison());
			
			tempCom = this.servi3.edit(fpfa.commande.getNumCommande(), fpfa.commande);
			
			List<LigneCommande> lignes = repo4.findAll();
			
			for(int i = 0; i < lignes.size(); i++) {
				if(lignes.get(i).getNumCommande().getNumCommande() == tempCom.getNumCommande()) {
					tempLigneCommande.add(lignes.get(i));
					
				}
			}
			
			return new EncapCommande(tempCom, tempLigneCommande);
			
		}
		else if(fpfa !=null) {
			
			tempCom = this.repo3.save(commande);
			
			List<LigneFactureProFormAchat> lignes1 = this.repo2 .findAll();
			
			
			for(int i = 0; i < lignes1.size(); i++) {
				if(lignes1.get(i).getFactureProFormAcha().getIdFpfa().equalsIgnoreCase(fpfa.getIdFpfa())) {
					tempLigneCommande.add(new LigneCommande(null, lignes1.get(i).getQteLigneFpfa(), lignes1.get(i).getPrixUnitHtLigneFpfa(), 0, lignes1.get(i).getTauxTvaLigneFpfa(), lignes1.get(i).getTauxTaxeAibicLigneFpfa(), lignes1.get(i).getTauxTsLigneFpfa(), tempCom, lignes1.get(i).getArticle(), lignes1.get(i).getUniter(), false, lignes1.get(i).isPrixUnitTtc(), lignes1.get(i).getCaracteristiqArti()));
					
				}
			}
			
			tempLigneCommande = this.repo4.saveAll(tempLigneCommande);
			
			fpfa.setCommande(tempCom);
			
			this.edit(id, fpfa);
			
			return new EncapCommande(tempCom, tempLigneCommande); 
			
		}
		
		return null;
		
	}

	
	
}
