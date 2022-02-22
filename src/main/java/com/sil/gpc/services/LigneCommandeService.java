package com.sil.gpc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sil.gpc.domains.Article;
import com.sil.gpc.domains.Commande;
import com.sil.gpc.domains.LigneAppro;
import com.sil.gpc.domains.LigneCommande;
import com.sil.gpc.repositories.LigneCommandeRepository;

@Service
public class LigneCommandeService {

	private final LigneCommandeRepository repo;

	public LigneCommandeService(LigneCommandeRepository repo) {
		super();
		this.repo = repo;
	}
	
	public LigneCommande save(LigneCommande ligneCommande) {
		
		return this.repo.save(ligneCommande);
	}
	
	
	public List<LigneCommande> saveAll (List<LigneCommande> ligneCommandes) {
		
		return this.repo.saveAll(ligneCommandes);
	}

	
	
	public LigneCommande edit(Long id, LigneCommande ligneCommande) {
		
		LigneCommande entiter = this.repo.getOne(id);
		if(entiter != null) {
			entiter.setPuLigneCommande(ligneCommande.getPuLigneCommande());
			entiter.setQteLigneCommande(ligneCommande.getQteLigneCommande());
			entiter.setRemise(ligneCommande.getRemise());
			entiter.setTva(ligneCommande.getTva());
			entiter.setArticle(ligneCommande.getArticle());
			entiter.setNumCommande(ligneCommande.getNumCommande());
			entiter.setTaibic(ligneCommande.getTaibic());
			entiter.setTs(ligneCommande.getTs());
			entiter.setUniter(ligneCommande.getUniter());
			entiter.setSatisfaite(ligneCommande.isSatisfaite());
			entiter.setPrixUnitTtc(ligneCommande.isPrixUnitTtc());
			
			return this.repo.save(entiter);
		}
		
		return null;
	}
	
	public boolean delete(Long id) {
		
		if(this.repo.existsById(id)==true)
			this.repo.deleteById(id);
		
		return !this.repo.existsById(id);
	}
	
	public Optional<LigneCommande> getById(Long id){
		
		return this.repo.findById(id);
	}
	
	public List<LigneCommande> getAll(){
		
		return this.repo.findAll();
	}

	public List<LigneCommande> findByCodeCommande(Long code){
		return this.repo.findByCodeCommande(code);
	}

	
}
