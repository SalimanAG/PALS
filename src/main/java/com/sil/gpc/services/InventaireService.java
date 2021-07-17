package com.sil.gpc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Inventaire;
import com.sil.gpc.domains.LigneDemandePrix;
import com.sil.gpc.domains.LigneInventaire;
import com.sil.gpc.domains.LigneReception;
import com.sil.gpc.domains.Stocker;
import com.sil.gpc.encapsuleurs.EncapDemandePrix;
import com.sil.gpc.encapsuleurs.EncapInventaire;
import com.sil.gpc.repositories.InventaireRepository;
import com.sil.gpc.repositories.LigneInventaireRepository;
import com.sil.gpc.repositories.StockerRepository;

@Service
public class InventaireService {

	private final InventaireRepository repos;
	private final LigneInventaireRepository repo2;
	private final LigneInventaireService servi2;
	private final StockerRepository repo3;

	public InventaireService(InventaireRepository repos, LigneInventaireRepository repo, LigneInventaireService servi2, StockerRepository repo3) {
		super();
		this.repos = repos;
		this.repo2 = repo;
		this.servi2 = servi2;
		this.repo3 = repo3;
	}

	public Optional<Inventaire> findById(String num){
		return repos.findById(num);
	}
	
	public List<Inventaire> findAll(){
		return repos.findAll();
	}
	
	public Inventaire edit(Inventaire inv, String num){
		Inventaire opc=repos.getOne(num);
		if (opc!=null) {
		opc.setDateInv(inv.getDateInv());
		opc.setDescrInv(inv.getDescrInv());
		opc.setExercice(inv.getExercice());
		opc.setMagasin(inv.getMagasin());
		
		return repos.save(opc);
		}else
			return null;
	}
	
	
	public Inventaire edit3(Inventaire inv, String num){
		Inventaire entiter=repos.getOne(num);
		if (entiter!=null && entiter.isValideInve() == false) {
			List<LigneInventaire> lignes = this.repo2.findAll();
			List<Stocker> stockerList = this.repo3.findAll();
			
			for(int i = 0; i < lignes.size(); i++) {
				if(lignes.get(i).getInventaire().getNumInv().equalsIgnoreCase(num)) {
					boolean finded = false;
					
					for(int j = 0; j > stockerList.size(); j++) {
						if(stockerList.get(j).getArticle().getNumArticle() == lignes.get(i).getArticle().getNumArticle() 
								&& stockerList.get(j).getMagasin().getNumMagasin() == entiter.getMagasin().getNumMagasin()) {
							finded = true;
							
							Stocker elem = stockerList.get(j);
							
							elem.setQuantiterStocker(lignes.get(i).getStockreel());
							
							this.repo3.save(elem);
							
							break;
						}
					}
					
					if(finded == false) {
						this.repo3.save(new Stocker(null, lignes.get(i).getStockreel(), 0, 0, lignes.get(i).getPu(), lignes.get(i).getArticle(), entiter.getMagasin()));
					}
	
				}
			}
			
			entiter.setValideInve(inv.isValideInve());
		
			return repos.save(entiter);
		}else
			return null;
	}

	
	
	public EncapInventaire editByEncap(String id, EncapInventaire encap) {
		
		List<LigneInventaire> lignes = this.repo2.findAll();
		List<LigneInventaire> concernedLignes = new ArrayList<LigneInventaire>();
		List<LigneInventaire> newLignes = new ArrayList<LigneInventaire>();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getInventaire().getNumInv().equalsIgnoreCase(id)) {
				concernedLignes.add(lignes.get(i));
			}
		}
		
		for(int i = 0; i < encap.getLigneInventaires().size(); i++) {
			boolean added = true;
			LigneInventaire enti = null;
			
			for(int j = 0; j < concernedLignes.size(); j++) {
				if(concernedLignes.get(j).getArticle().getNumArticle() == encap.getLigneInventaires().get(i).getArticle().getNumArticle()) {
					added = false;
					enti = concernedLignes.get(j);
					break;
				}
			}
			
			LigneInventaire newer = encap.getLigneInventaires().get(i);
			newer.setInventaire(repos.getOne(id));
			
			if(added == true) {
				
				this.repo2.save(newer);
			}
			else {
				this.servi2.edit(newer, enti.getIdLigneInv());
			}
		}
		
		for(int i = 0; i < concernedLignes.size(); i++) {
			
			boolean removed = true;
			
			for(int j = 0; j < encap.getLigneInventaires().size(); j++) {
				if(concernedLignes.get(i).getArticle().getNumArticle() == encap.getLigneInventaires().get(j).getArticle().getNumArticle()) {
					removed = false;
					break;
				}
			}
			
			if(removed == true) {
				this.repo2.deleteById(concernedLignes.get(i).getIdLigneInv());
			}			
			
		}
		
		lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getInventaire().getNumInv().equalsIgnoreCase(id)) {
				newLignes.add(lignes.get(i));
			}
		}
		
		
		return new EncapInventaire(this.edit(encap.getInventaire(), id), newLignes);
	}
	
	

	

	public Inventaire save(Inventaire inv){
		Integer val = 1, nbrMaxCaract = 6;
		String code = "INV-"+inv.getExercice().getCodeExercice();
		if(this.repos.findLastNumUsed(inv.getExercice().getNumExercice()) != null) {
			val = this.repos.findLastNumUsed(inv.getExercice().getNumExercice());
			val++;
		}
		for (int i=0; i<nbrMaxCaract -  (val+"").length(); i++) {
			code+="0";
		}
		inv.setNumInv(code+val);
		inv.setValeur(val); 
		if(repos.existsById(inv.getNumInv())==false) return repos.save(inv);
		return null;
	}

	public boolean delete(String num){
		repos.deleteById(num);
		return !repos.existsById(num);
	}
	
	public boolean deleteAInventaire2(String id) {
		
		List<LigneInventaire> lignes = this.repo2.findAll();
		
		for(int i = 0; i < lignes.size(); i++) {
			if(lignes.get(i).getInventaire().getNumInv().equalsIgnoreCase(id)) {
				this.repo2.deleteById(lignes.get(i).getIdLigneInv());
			}
		}
		
		return this.delete(id);
	}
	
}
